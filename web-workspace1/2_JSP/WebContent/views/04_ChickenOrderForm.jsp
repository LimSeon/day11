<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치킨 주문 페이지</title>
</head>
<body>
	
	<h1>☆반반무많이 치킨에 오신걸 환영합니다.★</h1>
	
	<h2>오늘의 날짜</h2>
	<%@ include file="datePrint.jsp" %>
	
	<br>
	
	<form action="/2_JSP/orderChicken.do" method="get">
	주문정보
		<fieldset>
			<legend>주문자 정보</legend>
			<table>
				<tr>
					<th>닉네임</th>
					<td><input type="text" required name="nickName"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" required name="phone"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" required name="address"></td>
				</tr>
				<tr>
					<th>요청사항</th>
					<td><textarea style="resize: none;" name="message"></textarea></td>
				</tr>
			</table>
		</fieldset>
		
		<fieldset>
			<legend>주문 정보</legend>

			<table>
				<tr>
					<th>치킨</th>
					<td>
						<select name="chicken">
							<option>황금올리브 치킨</option>
							<option>볼케이노 치킨</option>
							<option>고추바사삭 치킨</option>
							<option>허니콤보 치킨</option>
							<option>호랑이 치킨</option>
							<option>민트초코 치킨</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>사이드</th>
					<td>
						<input type="checkbox" value="웨지감자" name="side">웨지감자
						<input type="checkbox" value="치즈볼" name="side">치즈볼
						<input type="checkbox" value="치즈스틱" name="side">치즈스틱
						<input type="checkbox" value="떡볶이" name="side">떡볶이
						<input type="checkbox" value="오뎅탕" name="side">오뎅탕
						<input type="checkbox" value="민트초코아이스크림" name="side">민트초코아이스크림
					</td>
				</tr>
				<tr>
					<th>음료</th>
					<td>
						<input type="checkbox" value="제로콜라" name="drink">제로콜라(펩시)
						<input type="checkbox" value="테라" name="drink">테라
						<input type="checkbox" value="데자와" name="drink">데자와
						<input type="checkbox" value="솔의눈" name="drink">솔의눈
						<input type="checkbox" value="맥콜" name="drink">맥콜
						<input type="checkbox" value="민트초코우유" name="drink">민트초코우유
					</td>
				</tr>
				<tr>
					<th>결제방식</th>
					<td>
						<input type="radio" value="card" name="payment" checked>카드결제
						<input type="radio" value="cash" name="payment">만나서 현금 결제
					</td>
				</tr>
			</table>
		</fieldset>
		<input type="submit" value="주문하기">
		<input type="reset" value="다시고르기">
	</form>
</body>
</html>