<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 서블릿에서 전달한 내용 확인하기
	String name = (String)request.getAttribute("name");
	String color = (String)request.getAttribute("color");
	String animal = (String)request.getAttribute("animal");
	String[] foods = (String[])request.getAttribute("food");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>개인 취향 테스트 결과 (JSP)</title>
	<style>
		span:nth-of-type(1){
			color:blue; 
			font-weight: bold;
		}
		span:nth-of-type(2){
			color:green;
		}
		span:nth-of-type(3){
			color:yellowgreen;
		}
	</style>
</head>
<body>
	<h1>개인 취향 테스트 결과 확인(JSP)</h1>
	<span><%=name %></span>님의 개인 취향은<br>
	<span><%=color %></span>색을 좋아 하시고 <br>
	<span><%=animal %></span> 라는 동물을 좋아하시고,<br>
	좋아하는 음식은 <%=foods %> 입니다.
</body>
</html>






