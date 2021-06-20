package com.fabRoadies.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class LoginSms {

	public static void sendsms(String message, String number) {

		try {
			String api_key = "6oMmyczsHKaNVrTlqwdwmoFLMs0STXhs2uvxKZGXp8SMVM0a6TtRTlbNKZeC";
			String sendId ="TXTIND";
			message = URLEncoder.encode(message, "UTF-8");
			String language="english";
			String route="p";
//			String numbers="7976378593";
			String myurl="https://www.fast2sms.com/dev/bulk?authorization="+api_key+"&sender_id="+sendId+"&message="+message+"&language="+language+"&route="+route+"&numbers="+number;    
			System.out.println(myurl);
			
			URL url=new URL(myurl);
			
			HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			System.out.println("Wait..............");
			
			int code=con.getResponseCode();
			System.out.println("Response code : "+code);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
