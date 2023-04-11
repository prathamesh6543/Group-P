package com.quize.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class GetQuestion {
	
	int c;
	int a ;
	    ResultSet rs =null;
		Connection conn =null;	
		PreparedStatement ps =null;	
		
		String question;
		String option1;
		String option2;
		String option3;
		String option4;
		String correctanswer;
		public void getQuize() throws SQLException {
			
			try {
				ConnectionTest connectionTest =new ConnectionTest();
				 conn =	connectionTest.getConnection();
				 ps = conn.prepareStatement("select question ,option1,option2,option3,option4 from knowledge ");
		
			//4th step
		 rs =ps.executeQuery();
		// for(int i=1;i<=10;i++) {
		while (rs.next())
			
		{
			
				
			
		
		//	System.out.println("Select question no 1"+ rs.getString("id"));
			System.out.println("select question " +rs.getString("question"));
			System.out.println(rs.getString("option1"));
			System.out.println(rs.getString("option2"));
			System.out.println(rs.getString("option3"));
			System.out.println(rs.getString("option4"));
			//call the method 
			
			Scanner scanner=new Scanner(System.in);
			System.out.println("type the option in the form  as a,b,c,d only ");
			String s =scanner.nextLine();
			
			 ps = conn.prepareStatement("select correctanswer from knowledge ");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
			//	if (s.equals(rs.getLong(ps))) {
					  a++;
				}
			}
					    
		
		
		}catch (Exception e){
			
		
			e.printStackTrace();
		
		}finally {
			
		conn.close();
		ps.close();
		rs.close();
		}
			return ;
			
		}
     public static void main(String[] args) throws SQLException {
    	 GetQuestion getQuestion=new GetQuestion();
    	// System.out.println(getQuestion.getQuize());
	}
}
		
		
		
	      
	

	







	
	
	

