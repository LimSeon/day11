<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립팅 요소</title>
</head>
<body>
	<h1>스크립팅 요소</h1>
	<!-- HTML주석 : 개발자도구탭에 노출 -->
	<%--
		<%= sum %>
		스클립틀립 안에서 자바코드의 실행순서는 순수 자바코드랑 마찬가지로 위에서 아래 순서대로 흐른다.
		즉, 먼저 선언을 하고나서 출력식을 통해 출력할 수 있다.
	 --%>
	<%--JSP주석 : 개발자도구탭봐도 안보임 --%>
	
	<%
		// 스크립틀릿 : 이 안에 자바코드를 작성(변수 선언, 초기화, 제어문 등)
		// 1 ~ 100까지의 함께를 구해보자
		
		int sum = 0;
	
		for(int i = 1; i <= 100; i++){
			sum += i; 
		}
		
		// System.out.println("sum : " + sum);
	%>
	
	<p>
		웹 브라우저화면에 출력하고 싶으면? <br>
		스크립틀릿으로 출력 : <% out.println(sum); %> <br>
		표현식(출력)으로 출력 : <%= sum %> <br> <!-- ;을 쓰지 않도록 주의 -->
	</p>
	<%
		// 배열 사용
		String[] names = {"이승철","김승철","홍승철"};
	%>
	
	<h5>배열의 길이 <%= names.length %></h5>
	
	<%= Arrays.toString(names) %>
	
	<H4>반복문을 통해 HTML요소를 반복적으로 화면에 출력!!</H4>
	
	<ul>
		<% for(int i = 0; i < names.length; i++) { %>
			<li><%= names[i] %></li>
		<% } %>
		<br>
		<% for(String s : names){ %>
			<li><%= s %></li>
		<% } %>
		
		<%!
			public void test(){
			
		}
		%>
		<% test(); %>
		
	</ul>

</body>
</html>