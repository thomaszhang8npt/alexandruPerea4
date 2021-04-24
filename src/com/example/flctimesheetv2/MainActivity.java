package com.example.flctimesheetv2;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private static String SOAP_ACTION = "http://ax2012r2a:8101/DynamicsAx/Services/FLCTimeSheetServiceGroup";

    private static String NAMESPACE = "http://ax2012r2a:8101/DynamicsAx/Services";
    private static String METHOD_NAME = "insertIntoTimeSheet";

    private static String URL = "http://ax2012r2a:8101/DynamicsAx/Services/FLCTimeSheetServiceGroup?wsdl";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b;
		
		b = (Button) findViewById(R.id.button1);
		
		b.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
				request.addProperty("_srId","SR1");
				request.addProperty("_from","");
				request.addProperty("_to","");
				request.addProperty("_description","9gag");
				
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		        envelope.setOutputSoapObject(request);
		        
		        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		        try {
        			//comment
		            //this is the actual part that will call the webservice
		        	//compare
		            androidHttpTransport.call(SOAP_ACTION, envelope);        
		        } catch (Exception e) {
		            e.printStackTrace(); 
		        }
		        SoapObject result = (SoapObject)envelope.bodyIn;
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
