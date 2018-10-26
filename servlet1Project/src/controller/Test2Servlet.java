package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test2Servlet
 */
@WebServlet("/test2.do")
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 전송값에 영어가 아닌 문자가 있을 경우 인코딩하기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. view(HTML)에서 전달한 내용을 꺼내어 변수에 담기
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		System.out.println("아이디 : " + userid);
		System.out.println("비밀번호 : " + userpwd);
		
		// 3. 웹 페이지에 스트림 연결
		PrintWriter out = response.getWriter();
		
		// 4. 스트림을 통한 HTML 문서작성
		out.println("<html>");
		out.println("      <head>");
		out.println("            <title>로그인 결과 확인하기</title>");
		out.println("      </head>");
		out.println("      <body>");
		out.println("          아이디 : " + userid + " <br>");
		out.println("          비밀번호 : " + userpwd);
		out.println("      </body>");
		out.println("</html>");
		
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




