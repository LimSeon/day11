package com.kh.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("dp post - > do get??");
		
		// 0단계)
		// POST방식의 기본 인코딩 설정은 ISO-8859-1 이상한애로 설정
		// POST방식의 경우 값을 뽑기전에 미리 UTF-8방식으로 인코딩 설정을 해야한다.
		request.setCharacterEncoding("UTF-8");
		
		// 1단계)
		// request.getParameter 또는 request.getParameterValues로 값 뽑아내기
		String name = request.getParameter("name"); // : String
		// System.out.println(name);
		String gender = request.getParameter("gender");
		int age = 0;
		String ageCheck = request.getParameter("age");
		if(ageCheck.equals("")) {
		} else {
			age = Integer.parseInt(ageCheck);
			if(age < 0) {
				age = 0;
			}
		}
		// int age = Integer.parseInt(request.getParameter("age"));
		String city = request.getParameter("city");
		double height = Double.parseDouble(request.getParameter("height"));
		String[] foods = request.getParameterValues("food");
		/*
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		if(foods == null){
			System.out.println("foods : 없음");
		} else {
			System.out.println("foods : " + String.join("-", foods));
		}
		*/
		// 2) 단계
		// 처리 -> Service -> DAO -> DB
		
		// 3단계
		// 3_1. JSP이용해서 응답페이지를 만들기
		// JSP(Java Server Page) : HTML내에서 JAVA코드를 넣는다.
		
		// 응답화면(JSP)에서 필요로 하는 데이터들을 request객체에 담아서 보내줘야함
		// request에 attribute영역에 있음 => 키 - 벨류 세트로 묶어서 담을 수 있음
		// request.setAttribute(키, 벨류);
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
		request.setAttribute("msg", "조회 성공");
		
		// request.setAttribute(name, Object o) : void // 다형성
		// 3_2. 현재 작업중인 doGet()에서 응답페이지를 만드는 과정을 위임해야 한다.
		// 응답페이지를 JSP에게 위임(떠넘기기)
		
		// 위임 시 필요한 객체 : RequestDispatcher
		// 1) 응답하고자하는 뷰(jsp)를 선택하면서 객체를 생성 request.getRequestDispatcher(jsp경로);
		RequestDispatcher view = request.getRequestDispatcher("view/responsePage.jsp");
		
		// 2) forwarding : forward()
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("do post?????????");
		doGet(request, response);
	}

}
