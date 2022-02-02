package Basepackage;


import java.net.HttpURLConnection;

import java.net.URL;



public class VerifyBrokenLinkUtil {
	
	
	
	public static void Verifylink (String linkString) {
		
		try {
			URL url = new URL(linkString);
			
			//Open HTTP Connection
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			//Set Time in between the links
			urlConnection.setConnectTimeout(3000);
			//Connect
			urlConnection.connect();
			
			if(urlConnection.getResponseCode() == 200  ) {
				
				
			}else {
				
				System.out.println("Failed");
				
			}
			
		
			
			
		}
		catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		
		
		
		
		
		
	}
	
	


	
	
	


}
