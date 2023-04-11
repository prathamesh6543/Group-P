package com.quize.project;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

		public Connection getConnection() {
			 Connection con=null;
			try {
			//	Step 1
				Class.forName("com.mysql.jdbc.Driver");
			 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizquestion",
					"root","Hitesh123!");
						
			}catch (Exception e){
				e.printStackTrace();
			}
			return con;
			
				
			}
		}
		
		