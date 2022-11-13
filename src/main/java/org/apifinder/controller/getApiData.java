package org.apifinder.controller;


import java.util.Scanner;

import javax.sql.DataSource;

import org.apifinder.model.apiData;
import org.apifinder.model.apiModel;



import jakarta.annotation.Resource;

import java.net.HttpURLConnection;

import java.net.URL;

import java.io.IOException;




import org.json.JSONArray;
import org.json.JSONObject;




public class getApiData {
	
	
	@Resource(name="jdbc/project")
	public DataSource dataSource;
	
	
  public boolean resetData(DataSource dataSource) throws IOException{
		
    	
    	
    	URL url = new URL("https://api.publicapis.org/entries");
    	//String appid = "631fc16fd8f86f425bc1fa91";
    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	conn.connect();

    	String inline = "";
	    Scanner scanner = new Scanner(url.openStream());
	  
	   //Write all the JSON data into a string using a scanner
	    while (scanner.hasNext()) {
	       inline += scanner.nextLine();
	       
	    }
	  System.out.println(inline);
	  inline = inline.substring(24,inline.length()-1);
	  System.out.println(inline);
	   scanner.close();
	   JSONArray jsonArray = new JSONArray(inline);
	   System.out.println(inline);
	   
	   
	    //userDao.truncateTable();
	    for (int i = 0; i < jsonArray.length(); i++) {
	        JSONObject apiD = jsonArray.getJSONObject(i);
	        System.out.println(apiD.getString("API"));
	        System.out.println(apiD.getString("Description"));
	        System.out.println(apiD.getString("Auth"));
	        System.out.println(apiD.getBoolean("HTTPS"));
	        System.out.println(apiD.getString("Cors"));
	        System.out.println(apiD.getString("Link"));
	        System.out.println(apiD.getString("Category"));
	        apiData api = new apiData(apiD.getString("API"),apiD.getString("Description"),apiD.getString("Auth"),String.valueOf(apiD.getBoolean("HTTPS")),apiD.getString("Cors"),apiD.getString("Link"),apiD.getString("Category"));
	        boolean currentuser = false;
			try {
				
				currentuser = new apiModel().addApi(dataSource, api);
				 
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		  
	    }
	    

	    return true;
        
    }
}