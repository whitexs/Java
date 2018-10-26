package test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstAckServlet
 */
@WebServlet("/firstAck.srv")
public class FirstAckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstAckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request 영역 확인 값
		int reqSum = (request.getAttribute("requestValue") == null) ?
				         0 : (Integer)request.getAttribute("requestValue"); 
		
		// session 영역 확인 값
		// getSession() : 만약 이전에 연결된 내용이 있다면 해당 내용을 가져오지만,
		//                이전에 연결된 내용이 없을 경우 새로 만들어서 가져온다.
		// getSession(false) : 이전 연결정보가 없다면 null을 반환하는 메소드
		HttpSession session = request.getSession(false);
		int sesSum = (session.getAttribute("sessionValue") == null) ? 
				       0 : (Integer)session.getAttribute("sessionValue");
		
		// application 영역 확인 값
		ServletContext context = this.getServletContext();
		int conSum = (context.getAttribute("contextValue") == null) ?
				       0 : (Integer)context.getAttribute("contextValue");
		
		// 결과 확인용 스트림 객체 생성하기
		PrintWriter out = response.getWriter();
		
		out.println("<html><head>");
		out.println("<title>객체 영역 테스트 결과</title>");
		out.println("</head>");
		out.println("<body>");
		
		// page 영역
		// int sum = 30;
		out.println("<h3>Page 영역</h3>");
		out.println("해당 페이지에만 존재하는 객체의 범위를 말한다.<br>");
		out.println("만약 해당 페이지에서 다른 페이지로 이동하면 사라진다.");
		// out.println("계산 결과 : " + sum); (오류)
		out.println("<br><br>");
		
		// request 영역
		out.println("<h3>Request 영역</h3>");
		out.println("각 페이지 이동 시 연결되어 있는 페이지 간의 데이터를 <br>");
		out.println("유지하는 범위를 말한다. 이동하는 각 페이지 간 데이터가 유지되고,<br>");
		out.println("서로 다른 연결점을 가지는 페이지를 만났을 때 사라진다.");
		out.printf("<br>결과 확인 : %d <br><br>", reqSum);
		
		// session 영역
		out.println("<h3>Session 영역</h3>");
		out.println("한 번의 웹 브라우저 연결이 지속되는 동안 데이터를 유지하는 범위를 말한다.<br>");
		out.println("웹 브라우저 연결 시 객체가 생성되고 웹 브라우저 종료 시 객체가 소멸된다.");
		out.printf("<br>결과 확인 : %d<br><br>", sesSum);
		
		// application 영역
		out.println("<h3>Application 영역 (= Context 영역)</h3>");
		out.println("서버가 실행되어 있는 동안 객체를 생성하여 유지하는 객체 범위를 말한다.");
		out.println("서버가 실행되면 생성되고, 서버가 종료하면 소멸된다.");
		out.printf("<br>결과 확인 : %d<br><br>", conSum);
		
		
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
