package iii.servletjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstSimpleProgram")
public class SimpleServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("這是doGet()方法的訊息");
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("這是doPost()方法的訊息");
	}

}
