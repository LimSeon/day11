package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChickenServlet
 */
@WebServlet("/orderChicken.do")
public class ChickenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChickenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 전달값 중에 한글이 있을 경우 인코딩 처리(POST방식일 경우)
		
		// 2) 요청 시 전달한 값을 뽑기 및 데이터 가공 처리 => 변수에 기록
		// request.getParameter("키") : String
		// request.getParameterValues("키) : String[] 배열
		
		// 주문자정보
		String nickName = request.getParameter("nickName"); // "닉네임"
		String phone = request.getParameter("phone"); // "전화번호"
		String address = request.getParameter("address"); // "주소"
		String message = request.getParameter("message"); // 빈문자열"" or "요청사항"
		
		
		// 주문정보
		String chicken = request.getParameter("chicken"); 		// "치킨"
		String[] sides = request.getParameterValues("side"); 	// null or ["사이드1","사이드2"...]
		String[] drinks = request.getParameterValues("drink");  // null or ["음료수1", "음료수2"...]
		String payment = request.getParameter("payment");		// "cash", "card"
		
		// 3) 요청처리
		// 보통의 흐름 : Controller - Service - DAO - DB
		
		// 사용자가 보게될 내용을 처리 : 가격
		
		int price = 0;
		
		// 치킨가격 + 사이드 추가 시 가격 + 음료 추가 시 가격 == 총 결제할 금액
		/*
		 * 황금올리브 치킨 : 20,000원
		 * 볼케이노 치킨 : 30,000원
		 * 고추바사삭 치킨 : 20,000원
		 * 허니콤보 치킨 : 14,000원
		 * 호랑이 치킨 : 18,000원
		 * 민트초코 치킨 : 50,000원
		 */
		switch(chicken) {
		case "황금올리브 치킨" : 
		case "고추바사삭 치킨" : price += 20000; break;
		case "볼케이노 치킨" : price += 30000; break;
		case "허니콤보 치킨" : price += 14000; break;
		case "호랑이 치킨" : price += 18000; break;
		case "민트초코 치킨" : price += 50000; break;
		}
		/*
		 * 사이즈 추가 시 가격
			웨지감자 : 5,000
			치즈볼 : 3,000
			치즈스틱 : 5,000
			떡볶이 : 8,000
			오뎅탕 : 10,000
			민트초코아이스크림 : 1,000
		*/
		if(sides != null) {
			for(int i = 0; i < sides.length; i++) {
				switch(sides[i]) {
				case "웨지감자" :
				case "치즈스틱" : price += 5000; break;
				case "치즈볼" : price += 3000; break;
				case "떡볶이" : price += 8000; break;
				case "오뎅탕" : price += 10000; break;
				case "민트초코아이스크림" : price += 1000; break;
				}
			}
		}
		/*
		 * 음료수 추가 시 가격
			제로콜라 : 3,000
			테라 : 4,500
			데자와 : 2,000
			솔의눈 : 2,000
			맥콜 : 2,000
			민트초코우유 : 1,800
		*/
		
		if(drinks != null) {
			for(int i = 0; i < drinks.length; i++) {
				switch(drinks[i]) {
				case "제로콜라" : price += 3000; break;
				case "테라" : price += 4500; break;
				case "데자와" :
				case "솔의눈" :
				case "맥콜" : price += 2000; break;
				case "민트초코우유" : price += 1800; break;
				}
			}
		}
		System.out.println("====주문자 정보===");
		System.out.printf("닉네임 : %s \n "
						+ "전화번호 : %s \n"
						+ "주소 : %s \n"
						+ "요청사항 : %s \n", 
						nickName,
						phone,
						address,
						message);
		
		System.out.println("===주문 정보 ===");
		System.out.println("치킨 : " + chicken);
		System.out.println("사이드 : " + String.join("-", sides));
		System.out.println("음료 : " + String.join("-", drinks));
		System.out.println("결제 방법 : " + payment);
		System.out.println("총 금액 : " + price + "원 입니다." );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
