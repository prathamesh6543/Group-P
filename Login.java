package com.quize.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	public static void loginUser() throws SQLException {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the user name");
				String user= scanner.nextLine();
				System.out.println("enter the password");
				String password = scanner.nextLine();
				Login login=new Login();
				login.checkLogin(user,password);
	}
	
	public void checkLogin(String username,String password) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
	try {
		ConnectionTest connectionTest=new ConnectionTest();
		con=connectionTest.getConnection();
		ps=con.prepareStatement("select username, password from user where username=?and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			 rs =ps.executeQuery();
			if (rs.next()) {
				rs.beforeFirst();
				while (rs.next()) {
					        String u= rs.getString("user");
					        String p=rs.getString("password");
					if  (u.equalsIgnoreCase(username)==false)
						     System.out.println("Enter valid user name");
					else if (p.equals(password)==false)
						      System.out.println("Enter valid password");
					else 
						      System.out.println("welcom to our quize application ");
				}
			}
			else {
				System.out.println("No record match, you have not yet registered");
				}
			}catch(Exception e) {
				e.printStackTrace();
	}finally {
		con.close();
		ps.close();
		rs.close();
		
	}
	
	}
	}
