<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>member_bank.jsp</title>
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
	        <li><a href="mypage.do">마이페이지</a></li>
      </ul>
    </div>
  </div>
</nav><br><br><br><br><br>
<!-- 계좌등록/변경 시작 -->
<div class="container" align="center">
	<h1>계좌등록</h1>
	<form name="bankfrm">
	<table>
	  <tr>
	     <td>계좌번호: <input type="text" id="bank_num" name="bank_num">
	     <td>은행 :  
	     	<select id="bankname" name="bankname">
	     		<option>국민</option>
	     		<option>신한</option>
	     		<option>우리</option>
	     	</select>
	  </tr>
	</table>
	</form>
	
	<input type="submit" value="등록">
	<input type="reset" value="취소">
</div>
<!-- 계좌등록/변경 끝 -->

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

</body>
</html>