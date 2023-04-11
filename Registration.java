package com.quize.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {

	public static void registerUser() throws SQLException
	{
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the first name");
		String fname=scanner.nextLine();
		System.out.println("Enter the lastname");
		String lname=scanner.nextLine();
		System.out.println("Enter the Username");
		String username=scanner.nextLine();
		System.out.println("Enter the password");
		String password=scanner.nextLine();
		System.out.println("Enter the city");
		String city=scanner.nextLine();
		System.out.println("Enter the mail id");
		String mailid=scanner.nextLine();
		System.out.println("Enter the mobile number");
		String mob=scanner.nextLine();
		char u='a';
		do
		{
			System.out.println("Enter the user type u for user and a for admin in lowercase");
			u=scanner.next().charAt(0);}while(u!='u'||u!='a');
		boolean ans =checkregistration(fname,lname,username,password,city,mailid,mob);
		if(ans==true)
			System.out.println("Already registered");
		else
			insertData(fname,lname,username,password,city,mailid,mob);
		if(u=='a')
			Adminopetation.adminmenu();
		if(u=='u')
			Useroperation.usermenu();
		//StoreUserInMap.store(fname,lname,username,password,city,mailid,mob);
	}
	private static boolean checkregistration(String fname,String lname,String username,String password,String city,String mailid,String mob)
	{
		boolean ans=false;
				Connection con=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			ConnectionTest connectionTest =new ConnectionTest();
			con=connectionTest.getConnection();
		ps =con.prepareStatement("select username ,password from user where username=?,password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		res=ps.executeQuery();
		if(res.next()) {
			res.beforeFirst();   //go to black
			while(res.next()) {
				String u= res.getString("username");
				String p =res.getString("password");
				if(u.equalsIgnoreCase(username)==true&& p.equals(password));
				ans=true;
				break;
			}
		}
		
	}catch(Exception e) {
	e.printStackTrace();
	}
	return ans;
}
public static void insertData(String fname,String lname,String username,String password,String city,String mailid,String mob) throws SQLException
{
	Connection con=null;
	PreparedStatement ps=null;
	char u =0;
	try {
		ConnectionTest connectionTest =new ConnectionTest();
		con=connectionTest.getConnection();
	ps=con.prepareStatement("insert into user(firstname,lastname,username,password,city,email,mobilenumber,user_type)value(?,?,?,?,?,?,?,?)");
	ps.setString(1, fname);
	ps.setString(2, lname);
	ps.setString(3, username);
	ps.setString(4, password);
	ps.setString(5, city);
	ps.setString(6, mailid);
	ps.setString(7, mob);
	
	ps.setString(8, Character.toString(u));
	int a=ps.executeUpdate();
	System.out.println("Thankyou for your registration"+fname);
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		con.close();
		ps.close();
	
	}
	
   }
			
}
	

