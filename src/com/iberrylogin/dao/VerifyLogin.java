package com.iberrylogin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VerifyLogin {
    public static boolean validate(String name, String pass) {
    	boolean status=false;
    	
    	try{
    			Class.forName("com.mysql.jdbc.Driver");
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sravanthi","root","root");
    	PreparedStatement pst=con.prepareStatement("select * from user");
    	ResultSet rs=pst.executeQuery();
    	while(rs.next()){
    	if(rs.getString(1).equals(name)&&rs.getString(2).equals(pass)){
    		System.out.print(rs.getString(1));
    	status=true;
    	}
    	}
    	}
    	catch(Exception e){
    		
    		e.printStackTrace();
    	}
        
        return status;
    }
}