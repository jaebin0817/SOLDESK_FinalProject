<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>member.jsp</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="/css/layout.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<!-- 메인카테고리 시작 -->
<nav class="navbar navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
	      <a href="<%=request.getContextPath()%>">
	          <img src="/images/logo.png" alt="HOME" width="180px">
	      </a>
    </div>
    <div>
      <ul class="nav navbar-nav navbar-right">
	      	<li><a href="">컨텐츠</a></li>
	        <li><a href="">파티매칭</a></li>
	        <li><a href="">마이페이지</a></li>
      </ul>
    </div>
  </div>
</nav><br><br><br><br><br>
<!-- 메인카테고리 끝 -->

<!-- 본문 시작 -->
<form name="cardfrm" id="cardfrm" method="post" action="member.do">
	<div class="container text-center">
		<input name="c_num" id="c_num" type="number" class="form-control" size="20" maxlength="16" placeholder="카드 번호를 입력 해 주세요" required>
		카드 년 월 입력
		<select name="card_m" id="card_m">
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06">06</option>
                <option value="07">07</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>            
        </select>
        <select name="card_y" id="card_y">
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>
                <option value="32">32</option>
                <option value="33">33</option>            
        </select>
        <br>
        비밀번호 입력<input type="password" name="card_pw" id="card_pw" maxlength="2">  
        <br>
        카드사
        <select name="card_com" id="card_com" >
                <option value="신한">신한</option>
                <option value="국민">국민</option>
                <option value="삼성">삼성</option>
                <option value="케이뱅크">케이뱅크</option>
                <option value="카카오">카카오</option>
                <option value="BC">BC</option>
                <option value="외환">외환</option>
                <option value="기업">기업</option>      
        </select>
        <br>
		<input type="submit" value="입력"  class="btn btn-success">
        <input type="reset"  value="취소"  class="btn btn-danger">
	</div>
</form>



<!-- 본문 끝 -->

	<!-- Footer -->
	<footer >

	  <div class="container-fluid bg-3 text-center">
	    <a href="">공지사항</a> &nbsp;&nbsp;
	    <a href="">문의사항</a>
	  </div>
	  
	  <div class="container-fluid bg-4 text-center">
		  <p>Copyright &copy; OPOT</p> 
		  <p>SOLDESK 1조</p>
		  <p>조원들 Contact Info</p>
	  </div>
	  

	</footer>


</body>
</html>