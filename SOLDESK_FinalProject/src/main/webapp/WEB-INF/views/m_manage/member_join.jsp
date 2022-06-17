<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>member_join.jsp</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="/css/layout.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body id="member_join" data-spy="scroll" data-target=".navbar" data-offset="60">


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
	        <li><a href="mypage.do">마이페이지</a></li>
      </ul>
    </div>
  </div>
</nav><br><br><br><br><br>
<!-- 메인카테고리 끝 -->

<!-- 회원 가입 시작 -->
<h1 align="center"> 회원 가입</h1>
<div class = "container">
	<h1>회원 가입</h1>
	<form name="member_join" id="mem_info" method = "get">
	<table class="table">
	  <tr>
		<th>아이디 : </th> 
		<td style="text-align: left;">
				<input type="text" name="mem_id" id="mem_id">
		</td>
	  </tr>
	  <tr>
	  	<th>비밀번호 : </th>
	  	<td style="text-align: left;">
	  			<input type="password" name="mem_pw" id="mem_pw"  >
	  	</td>
	  </tr>
	  <tr>
	  	<th>연락처 : </th>
	  	<td style="text-align: left;">
	  			<input type="tel" name="mem_phone" id="mem_phone" >
	  	</td>
	  </tr>
	  <tr>
	  	<th>이메일 : </th>
	  	<td style="text-align: left;">
	  			<input type="email" name="mem_email" id="mem_email" >
	  	</td>
	  </tr>
	  <tr>
	  	<th>생년월일: </th>
	  	<td style="text-align: left;">
	  		<input type="text" name="birth_year" id="birth_year">
	  		-
	  		<input type="text" name="gender_code" id="gender_code" style="width:100px;">
	  	</td>
	  </tr>
	  <tr>
		 <td colspan="2">
		    <input type="submit" value="회원가입"  class="btn btn-primary"/>
		    <input type="reset"  value="취소"        class="btn btn-primary"/>
		 </td>
	  </tr>
	</table>
	</form>

	
</div>
<!-- 회원 가입 끝 -->

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