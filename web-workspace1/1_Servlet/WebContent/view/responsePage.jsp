<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 이 구문을 스크립틀릿(scriptlet)이라고 해서 HTML내에 자바코드를 쓸 수 있는 영역
	// 현재 이 jsp파일에서 필요한 데이터들 => request객체의 attribute영역에 담겨있음
	// request getAttribute("키값") : object
	String name = (String)request.getAttribute("name");
	String gender = (String)request.getAttribute("gender");
	int age = (int)request.getAttribute("age");
	String city = (String)request.getAttribute("city");
	double height = (double)request.getAttribute("height");
	String[] foods = (String[])request.getAttribute("foods");

	String msg = request.getAttribute("msg") + "";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 응답화면</title>
</head>
<body>
	<div>요청 결과 : <%= msg%></div>
	<span><%= name %></span>님은
	<span><%= age %></span>살이며,
	<span><%= city %></span>에 삽니다.
	
	키는<span><%= height %></span> cm이고 <br>
	
	성별은 
	
	<% if(gender == null) { %>
		<!-- 성별을 선택을 안했을 경우 -->
		<span>선택을 안했습니다.</span> <br>
	<% } else{ %>
		<% if(gender.equals("M")) {%>
			<!-- 남자 선택 -->
			<span>남자입니다.</span> <br>
		<%} else { %>
			<!-- 여자 선택 -->
			<span>여자입니다.</span> <br>
		<%} %>
	<% } %>
	
	좋아하는 음식은
	<!-- 체크를 안했을 경우 -->
	<% if(foods == null) {%>
		없습니다.
	<% } else {%>
	<!-- 체크를 했을 경우 -->
		<ul>
			<% for(int i = 0; i < foods.length; i++) { %>
				<li><%= foods[i] %></li>
			<% } %>
		</ul>
	<% } %>
	
	입니다.
	
	
	
</body>
</html>