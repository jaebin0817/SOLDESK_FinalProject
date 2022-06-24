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
	          <c:when test="${ s_mem_lv=='A' }">
	            <li><a href="webmaster/webmaster.do">관리자페이지</a></li>	            
	          </c:when>
	          <c:otherwise>
	            <li><a href="m_manage/mypage.do">마이페이지</a></li>
	          </c:otherwise>
	        </c:choose>
      </ul>
    </div>
  </div>
</nav><!-- 메인카테고리 끝 -->


<!-- 본문 시작 -->


<div id="wrap" class="container-fluid bg-1 text-center">
	
	<!-- 컨텐츠 검색 -->
	<div id="searchfield" class="container">   
	  <form action="mainsearch.do">
	    <div class="input-group">
	      <input type="search" id="searchkey" name="searchkey" class="form-control" size="50" placeholder="작품명, 감독, 배우를 검색해보세요" required>
	      <div class="input-group-btn">
	        <input type="submit" class="btn btn-danger" value="검색">
	      </div>
	    </div>
	  </form>
	</div>
	<div id="searchbtns" class="container"><br>&nbsp;&nbsp;   
		<c:forEach var="dto" items="${ keywords }" begin="1" end="8" step="1">
				<button class="btn btn-danger" onclick="location.href='/keysearch.do?key_name=${ dto.key_name }&key_code=${ dto.key_code }'">#${ dto.key_name }</button>&nbsp;&nbsp;
		</c:forEach>	
	</div>
	<!-- 컨텐츠 검색 끝 -->
	
	
	<!-- OTT랭킹 / 시청목록 count해서 가장 많은 top3 -->	
	<div id="cont_rank" class="container-fluid text-center">
	  <h3>오늘의 통합 랭킹</h3><br>
 	  <c:set var="no" value="1"></c:set>
	  <ul>
		<c:forEach var="dto" items="${ rank }" begin="0" end="${ fn:length(rank) }" step="1">
			<dl class="ranklist">
			<a href="<%=request.getContextPath()%>/contlist/contlistread.do?mcode=${ dto.mcode }">
			  <span class="cont-poster">
				<img src="../storage/${ dto.mthum }" class="img-circle" alt="movie" width="80" height="80">
			  </span>
			  <span class="cont-rank">
			    ${ no }
			  </span>
			  <span class="cont-title">
			    ${ dto.mtitle }
			  </span>
			  <span class="hide">${ no=no+1 }</span>
			</a>
			</dl>
		</c:forEach>
	  </ul>
	</div>
	<!-- OTT랭킹 끝 -->
	
	<!-- 추천 컨텐츠 -->
		
	<div id="cont_list" class="container-fluid text-center">
		<h3>오늘 이거 볼까요? 👀</h3><br>
	        
	      <c:set var="maxcontent" value="${ 8 }"></c:set><!-- 노출할 최대 컨텐츠 수 -->
	        
	          <c:choose>
	          	<c:when test="${ fn:length(list)<maxcontent }">
	          	  <c:set var="end" value="${ fn:length(list) }"></c:set>
	          	</c:when>
	          	<c:otherwise>
	          	  <c:set var="end" value="${ maxcontent-1 }"></c:set>
	          	</c:otherwise>
	          </c:choose>

	          	
	      <c:forEach var="dto" items="${ list }" begin="0" end="${ end }" step="1">
			
				<div class="col-sm-3">
			      <div class="thumbnail">
			        <a href="<%=request.getContextPath()%>/contlist/contlistread.do?mcode=${ dto.mcode }"><img src="../storage/${dto.mthum }" alt="movie" width="280"></a>
		            <p><strong>${dto.mtitle }</strong></p>
			        <p>
			        	<!-- 평점 별로 바꿔서 출력 -->
			        	<c:forEach begin="1" end="${ dto.mrate }">★</c:forEach><c:forEach begin="${ dto.mrate+1 }" end="5">☆</c:forEach>
			        	${ dto.mrate }
			        </p>
	        	  </div>
	    		</div>
	      </c:forEach>
	</div>
	<!-- 추천 컨텐츠 끝 -->
</div>

<!-- 본문 끝 -->

	<!-- Footer -->
	<footer >

	  <div class="container-fluid bg-3 text-center">
	    <a href="notice/notice.do">공지사항</a> &nbsp;&nbsp;
	    <a href="">문의사항</a>
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