package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test1Servlet
 */
@WebServlet("/test1.do")
public class Test1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /*
     * HTTP (HyperText Transfer Protocol) :
     *   - 서버와 클라이언트 간의 통신 규칙을 정하기 위한 통신 규약.
     *   - Request (요청), Response (응답) 간의 데이터 전달의 형식을
     *     구조화하기 위해 사용하는 통신 규약이다.
     *   - Client --- Request ---> Server
     *   - Server --- Response --> Client
     *   
     *   - GET / POST
     *   - GET은 사용자가 조회하고자 하는 정보를 URL주소에 담아 전달하는 통신 타입으로,
     *     기본적인 URL 주소 뒤에 ?username=홍길동&age=10 등의 형식을 가진
     *     쿼리 스트링으로써 데이터를 전달한다.
     *   - 조회 용도로 많이 쓰이며, 링크를 공유하고자 할 때 해당 링크의 정보를 통합적으로
     *     전달할 때 많이 사용한다. (SELECT / www.naver.com?search=라면+잘+끓이기)
     *   
     *   - POST는 사용자가 특정 정보를 추가, 수정하고자 할 때 전달하는 데이터를 URL 주소창이 아닌
     *     Request Body 라는 특정 영역에 담아 전달할 때 사용한다.
     *   - URL 주소창이 아닌 별도의 영역에 데이터를 저장하기 때문에 데이터 크기의 제한이
     *     GET방식에 비해 넓다. 또한 사용자가 요청하는 정보가 주소창에 노출되는 것을
     *     막고자 할 때 많이 사용한다. (INSERT / UPDATE / DELETE)
     */
    // GET 방식으로 데이터를 전달 받았을 경우
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 전송받은 값이 영어가 아닐 경우 UTF-8 방식으로 인코딩해야 한다.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. 웹 페이지에 표현할 정보를 전달하는 스트림 연결하기
		PrintWriter out = response.getWriter();
		
		// 3. 웹 페이지로 표현할 정보 입력
		out.println("<html><head><title>");
		out.println("서블릿이란?</title></head>");
		out.println("<body>");
		
		out.println("<h1>서블릿 이란?<h1>");
		
		out.println("<h3>서블릿은 웹 애플리케이션으로 보여질 소스 코드나"
				   +"특정 구문을 자바 언어를 통해 구현하는 기술을 말한다.</h3>");
		
		out.println("<a href='/sp1/index.html'>메인으로 가기</a>");
		
		out.println("</body></html>");
		
		out.flush();
		out.close();
	}

	// POST 방식으로 데이터를 전달 받았을 경우
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
