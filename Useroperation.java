package com.quize.project;

import java.sql.SQLException;
import java.util.Scanner;

public class Useroperation {
					
				
				public static void main(String[] args) throws SQLException
			    {System.out.println("User Operation");
				System.out.println("1.Student Registration");
				System.out.println("2.Student Login");
				System.out.println("3.Display the list of question");
				System.out.println("4.Store Quize result into database");
				System.out.println("5.Display Quiz result");
				System.out.println("6.Score as per ascending order");
				System.out.println("7.Know the individual score ");
				
				System.out.println("8.Exit");
				
					Scanner scanner=new Scanner(System.in);
					int num = 0;
					
					
					
					System.out.println("Enter your choice");
					num =scanner.nextInt();
					
					switch(num)
					{
					case 1:
					System.out.println("This is the Student Registration ");
					 Registration registration=new  Registration();
					 registration.registerUser();
					 
					break;
					
					case 2:
						System.out.println("This is the student login page");
						Login login=new Login();
						login.loginUser();
					break;
					
					case 3:
						System.out.println("This is the list of question you need to answer");
						GetQuestion getQuestion=new GetQuestion();
						getQuestion.getQuize();
						
					
					break;
					
					case 4:
						System.out.println("Store Quize result into database");
					   
					
					break;
					
					case 5:
						System.out.println("Know your result ");
					    
					 break;
					 
					case 6:
						System.out.println("Score of the student");
					 
					 break;
					 
					case 7:
						System.out.println("Know the individual score");
					   
					 break;
					 
				
						
				
					 
					}
				}

				public static void usermenu() {
					// TODO Auto-generated method stub
					
				}
				

			

			
	
		
		
	}


