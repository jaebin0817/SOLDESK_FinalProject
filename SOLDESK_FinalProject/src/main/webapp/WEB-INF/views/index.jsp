<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<!DOCTYPE html>
<html lang="en">
<head>
  <title>OPOT</title>
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
	      	<li><a href="contlist/contlist.do">컨텐츠</a></li>
	        <li><a href="party/partyadd.do">파티매칭</a></li>
	        	
	        <c:choose>
	          <c:when test="${ s_mem_id==null || s_mem_pw==null || s_mem_lv==null }">
	            <li><a href="login.do">로그인</a></li>	            
	          </c:when>
	          <c:otherwise>
	            <li><a href="mypage.do">마이페이지</a></li>
	          </c:otherwise>
	        </c:choose>
      </ul>
    </div>
  </div>
</nav><!-- 메인카테고리 끝 -->


<!-- 본문 시작 -->

	<!-- 컨텐츠 검색 시작 -->
	<div class="jumbotron text-center">
	  <br><br><br><br>	
	  <form>
	    <div class="input-group">
	      <input type="search" class="form-control" size="50" placeholder="컨텐츠 검색" required>
	      <div class="input-group-btn">
	        <button type="button" class="btn btn-danger">검색</button>
	      </div>
	    </div>
	  </form>
	</div>
	<!-- 컨텐츠 검색 끝 -->
	
	<!-- OTT랭킹 -->
	<div id="cont_rank" class="container-fluid text-center">
		<h3>오늘의 통합 랭킹</h3><br>
		<div>
			<a href=""><img src="/images/movie_whyHer.jpeg" alt="movie" width="40"></a>
			<p>1. 왜 오수재인가?</p>
		</div>
		<div>
			<a href=""><img src="/images/movie_topGun.jpg" alt="movie" width="40"></a>
			<p>2. 탑 건</p>
		</div>
		<div>
			<a href=""><img src="/images/movie_theRoundup.jpg" alt="movie" width="40"></a>
			<p>3. 범죄도시2</p>
		</div>
	</div>
	<!-- OTT랭킹 끝 -->
	
	<!-- 추천 컨텐츠 -->
	<div id="cont_list" class="container-fluid text-center">
		<h3>오늘 이거 볼까요? 👀</h3><br>
	    <div class="col-sm-3">
	      <div class="thumbnail">
	        <a href=""><img src="/images/movie_greenbook.jpg" alt="movie" width="280"></a>
            <p><strong>그린북</strong></p>
	        <p>★★★★★</p>
	      </div>
	    </div>
	    <div class="col-sm-3">
	      <div class="thumbnail">
	        <a href=""><img src="/images/movie_soul.jpg" alt="movie" width="280"></a>
            <p><strong>소울</strong></p>
	        <p>★★★★★</p>
	      </div>
	    </div>
	    <div class="col-sm-3">
	      <div class="thumbnail">
	        <a href=""><img src="/images/movie_jujutsuKaisen.jpg" alt="movie" width="280"></a>
            <p><strong>주술회전</strong></p>
	        <p>★★★★★</p>
	      </div>
	    </div>
	    <div class="col-sm-3">
	      <div class="thumbnail">
	        <a href=""><img src="/images/movie_dune.jpg" alt="movie" width="280"></a>
            <p><strong>듄</strong></p>
	        <p>★★★★☆</p>
	      </div>
	    </div>

	</div>
	<!-- 추천 컨텐츠 끝 -->



<!-- 본문 끝 -->

	<!-- Footer -->
	<footer >

	  <div class="container-fluid bg-3 text-center">
	    <a href="">공지사항</a> &nbsp;&nbsp;
	    <a href="">문의사항</a>
	    <!-- 세션이용해서 회원등급 A(webmaster)일때만 접근 허용 -->
	    <c:if test="${ s_mem_lv=='A' }">
	      <br><a href="webmaster/webmaster.do">관리자페이지</a>
	    </c:if>
	  </div>
	  
	  <div class="container-fluid bg-4 text-center">
	  	  <a href="<%=request.getContextPath()%>">
	          <img src="/images/logo_white_grey.png" alt="HOME" width="100px">
	      </a>
		  <p>Copyright &copy; OPOT</p> 
		  <p>SOLDESK 1조</p>
		  <p>조원들 Contact Info</p>
	  </div>
	  

	</footer>


</body>
</html>
