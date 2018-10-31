package com.cg.mpw.dao;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.mpw.exception.InvalidInputException;



public class DBConnection {

	

      private static Connection con;
		public static Connection getConnection() throws InvalidInputException{
			
			String url="";
			String username="";
			String pwd="";
			
		try {
			if(con==null){
			FileInputStream fis= 
	new FileInputStream("./resources/dbconfig.properties");	
				Properties prop= new Properties();
				
				prop.load(fis);
				
				url= prop.getProperty("url");
				String driver=prop.getProperty("driver");
				username=prop.getProperty("username");
				pwd= prop.getProperty("password");
			Class.forName(driver);
			System.out.println("class loaded..");
			con=DriverManager.getConnection(url,username,pwd);
			System.out.println("connected to db..");
			}
		} catch (SQLException e) {
				throw new InvalidInputException(e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new InvalidInputException(e.getMessage());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
			return con;
		}
		
		
	}

