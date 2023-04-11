package com.quize.project;

import java.sql.SQLException;

public class Question extends GetQuestion {

	public static void main(String[] args) throws SQLException {
		
		GetQuestion getQuestion =new GetQuestion();
		
		getQuestion.getQuize();
}	

}
