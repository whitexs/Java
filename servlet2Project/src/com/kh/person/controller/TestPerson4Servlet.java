package com.kh.person.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPerson1Servlet
 */
@WebServlet("/testPerson4.biz")
public class TestPerson4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestPerson4Servlet() { super(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		
		String[] foodArr = request.getParameterValues("food");
		
		System.out.println("name : " + name);
		System.out.println("color : " + color);
		System.out.println("animal : " + animal);
		
		for(String str : foodArr){
			
			System.out.println("foodArr : " + str);
			
		}
		
		// 화면 출력용 값 저장하기
		request.setAttribute("name", name);
		request.setAttribute("color", color);
		request.setAttribute("animal", animal);
		request.setAttribute("food", foodArr);
		
		RequestDispatcher view
		    = request.getRequestDispatcher("views/result.jsp");
		
		view.forward(request, response);
		
	}
}




















