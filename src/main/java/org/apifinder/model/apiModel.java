package org.apifinder.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Resource;

import javax.sql.DataSource;

import org.apifinder.entity.apiData;

public class apiModel {

	public List<apiData> listApi(DataSource dataSource) {
		// Step 1: Initialize connection objects
		List<apiData> listApi = new ArrayList<>(); 
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
			connect = dataSource.getConnection();
			
			// Step 2: Create a SQL statements string
			String query = "Select * from apiData1";
			stmt = connect.createStatement();

			// Step 3: Execute SQL query
         rs = stmt.executeQuery(query);
         
			// Step 4: Process the result set
			while(rs.next()){
				listApi.add(new apiData(rs.getInt("apiId"),rs.getString("api"), rs.getString("description"), rs.getString("auth"), rs.getString("https"),rs.getString("cors"),rs.getString("link"),rs.getString("category")));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listApi;
	}

	public boolean addApi(DataSource dataSource, apiData newApi) {
		
		
		Connection connect = null;
		PreparedStatement statement= null;
		try {
			connect = dataSource.getConnection();
			String api = newApi.getApi();
			String description = newApi.getDescription();
			String auth = newApi.getAuth();
			String https = newApi.getHttps();
			String cors = newApi.getCors();
			String link = newApi.getLink();
			String category = newApi.getCategory();
			
			String query = "INSERT INTO apiData1 (api,description,auth,https,cors,link,category) VALUES (?,?,?,?,?,?,?);";
			statement = connect.prepareStatement(query);
			statement.setString(1, api);
			statement.setString(2, description);
			statement.setString(3, auth);
			statement.setString(4, https);
			statement.setString(5, cors);
			statement.setString(6, link);
			statement.setString(7, category);
			statement.execute();
			
			connect.close();
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return true;
		
		
	}

	public void updateApi(DataSource dataSource, apiData updatedApi) {

		Connection connect = null;
		PreparedStatement statement= null;
		try {
			connect = dataSource.getConnection();
			int apiId = updatedApi.getApiId();
			String api = updatedApi.getApi();
			String description = updatedApi.getDescription();
			String auth = updatedApi.getAuth();
			String https = updatedApi.getHttps();
			
			String cors = updatedApi.getCors();
			String link = updatedApi.getLink();
			String category = updatedApi.getCategory();
			String query = "update apiData1 set api = ?, description = ?, auth = ?, https = ?, cors = ?, link = ?, category = ? where apiId= ?";
			
			
			statement = connect.prepareStatement(query);
			statement.setString(1, api);
			statement.setString(2, description);
			statement.setString(3, auth);
			statement.setString(4, https);
			statement.setString(5, cors);
			statement.setString(6, link);
			statement.setString(7, category);
			statement.setInt(8, apiId);
			statement.execute();
			connect.close();
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
	}

	public void deleteApi(DataSource dataSource, int apiId) {
	
		
		Connection connect = null;
		PreparedStatement statement= null;
		try {
			connect = dataSource.getConnection();
			
			String query = "delete from apiData1 where apiId= ?";
			statement = connect.prepareStatement(query);
			statement.setInt(1, apiId);
			statement.execute();
			connect.close();
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		

		
	}
	
public void truncateTable(DataSource dataSource) {
	
		
		Connection connect = null;
		PreparedStatement statement= null;
		try {
			connect = dataSource.getConnection();
			
			String query = "truncate table apiData1";
			statement = connect.prepareStatement(query);
			
			statement.execute();
			
			connect.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		

		
	}


}
