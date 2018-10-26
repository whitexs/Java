package com.kh.person.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPerson1Servlet
 */
@WebServlet("/testPerson2.biz")
public class TestPerson2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestPerson2Servlet() { super(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		// request.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html; charset=UTF-8");
		
		// 첫번째 매개 변수인 HttpServletRequest request는
		// 웹 브라우저로부터 전달된 (사용자가 요청한) 데이터를 받아주는 역할이다.
		// 두번째 매개 변수인 HttpServletResponse response는
		// request를 통해 받은 데이터를 가공하여 처리한 결과를 다시 사용자에게 리턴하는 역할이다.
		
		// 2. request로부터 데이터 전달 받기
		
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		
		// 체크박스나 기타 여러 값을 가지는 name을 호출할 경우
		// name값을 배열형태로 받아온다.
		
		String[] foodArr = request.getParameterValues("food");
		
		System.out.println("name : " + name);
		System.out.println("color : " + color);
		System.out.println("animal : " + animal);
		
		for(String str : foodArr){
			
			System.out.println("foodArr : " + str);
			
		}
		
		// 3. response 객체에 처리한 응답 내용 전송하기
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>개인 취향 테스트 결과</title></head>");
		out.println("<body>");
		out.println("<h2 style='color: red;'>개인 취향 테스트 결과</h2>");
		out.printf("<span style='color:blue; font-weight: bold;'>%s</span>님의 개인 취향은 <br>", name);
		out.printf("<span style='color:green;'>%s</span>색을 좋아 하시고 <br>", color);
		out.printf("<span style='color:yellowgreen;'>%s</span> 라는 동물을 좋아하시고,<br>", animal);
		out.println("좋아하는 음식은 ");
		
		for(String food : foodArr) {
			
			out.printf("%s ", food);
			
		}
		
		out.println("입니다.");
		out.println("</body>");
		out.println("</html>");

		out.flush();
		out.close();
	}
}




















