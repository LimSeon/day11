# day11
Servlet&amp;JSP 수업내용
## 0_Servlet/JSP 개요
## 1_Servlet
### GET방식 테스트

### POST방식 테스트
#### 1. 특징
1. POST방식으로 요청하면 URL BODY영역에 데이터를 포함시켜서 요청 <br>
2. BODY영역은 전송하는 길이에 제약이 없음 <br>
3. 즐겨찾기는 가능하다 전달되는 데이터가 URL에 노출되지 않음 <br>
4. 최대 요청 받는 시간(Time out)이 존재함 <br>

#### 2. value값 뽑아내기
0) 단계: 값을 뽑기 전에 미리 UTF-8방식으로 인코딩 설정
> request.setCharacterEncoding("UTF-8");


