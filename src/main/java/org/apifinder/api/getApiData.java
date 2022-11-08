package org.apifinder.api;

import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apifinder.entity.apiData;
import org.apifinder.model.apiModel;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jakarta.annotation.Resource;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;



import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;




public class getApiData {
	
	
	@Resource(name="jdbc/project")
	//@Resource(lookup="jdbc/project")
	public DataSource dataSource;
	
	
  public boolean resetData(DataSource dataSource) throws IOException{
		
    	
    	
    	URL url = new URL("https://api.publicapis.org/entries");
    	//String appid = "631fc16fd8f86f425bc1fa91";
    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	conn.connect();

//        URLConnection connection = new URL("https://api.publicapis.org/entries").openConnection();
//        connection.connect();

//        BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
//
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = r.readLine()) != null) {
//            sb.append(line);
//        }
//       System.out.println(sb.toString());
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
				//if (currentuser = true)
				currentuser = new apiModel().addApi(dataSource, api);
				 
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		    String responseMessage = currentuser ? "Succesfully created user" : "Failed to create user";
		    
		    //System.out.println(responseMessage);
	    }
	    
//	    Gson gson = new Gson(); // Or use new GsonBuilder().create();
//	    apiData api = gson.fromJson(inline, apiData.class); // deserializes json into target2
//	    
//	    System.out.println(api.toString());
	    
//	    Gson gson = new Gson();
//	    JsonParser parser = new JsonParser();
//	    JsonObject object = (JsonObject) parser.parse(inline);// response will be the json String
//	    apiData api = gson.fromJson(object, apiData.class); 
//	    System.out.println(api.toString());
	    
	    
	    

	    
	    //Close the scanner
	    
        //JSONObject jsonObj = (JSONObject)JSONSerializer.toJSON(inline); // convert String to JSON
        //System.out.println(jsonObj);
       
//        apiData api = (apiData)JSONObject.toBean(jsonObj, apiData.class); // convert JSON to Bean
//        System.out.println(api.toString());
	    return true;
        
    }
}