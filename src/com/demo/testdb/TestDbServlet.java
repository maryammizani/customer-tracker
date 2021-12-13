package com.demo.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Setup Connection variables
		String lUser = "springstudent";
		String lPass = "springstudent";
		String lJdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=FALSE&serverTimezone=UTC";
 		// String lDriver = "com.mysql.jdbc.Driver";   // Deprecated
		String lDriver = "com.mysql.cj.jdbc.Driver";
				
		// Get connection to database
		try {
			PrintWriter lPrintWriter=response.getWriter();
			lPrintWriter.println("Connecting to database: " + lJdbcUrl + "\n");
			Class.forName(lDriver);
			Connection lConnection = DriverManager.getConnection(lJdbcUrl, lUser, lPass);
			lPrintWriter.println("SUCCESS!");
			lConnection.close();
		}
		catch (Exception exc){
			exc.printStackTrace();
			throw new ServletException();
		}		
	}
}
