<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 메인카테고리 끝 -->

<!-- 본문 시작 -->
<div id="cont_list" class="container-fluid text-center">
	<h3>영화 상세정보와 리뷰</h3>
	<br> <a
		href="<%=request.getContextPath()%>/contlist/contlistread.do?mcode=${ dto.mcode }">
		<img src="../../storage/${dto.mthum}" alt="movie" width="300px"><br>
	</a>
	<c:if test="${dto.netflix eq 'O' }">
		<a href="/watch.do?mcode=${ dto.mcode }"><img src="../../images/icon_netflix.png" width="50px"></a>
	</c:if>
	<c:if test="${dto.tving eq 'O'  }">
		<a href="/watch.do?mcode=${ dto.mcode }"><img src="../../images/icon_tving.png" width="50px"></a>
	</c:if>
	<c:if test="${dto.watcha eq 'O'  }">
		<a href="/watch.do?mcode=${ dto.mcode }"><img src="../../images/icon_watcha.png" width="50px"></a>
	</c:if>
	<c:if test="${dto.diseny eq 'O'  }">
		<a href="/watch.do?mcode=${ dto.mcode }"><img src="../../images/icon_disney.png" width="50px"></a>
	</c:if>

	<div class="mtitle">${dto.mtitle}</div>

	<div class="key_code">
		장르 :
			<c:forEach items="${keylist}" var="list">
				<a href="search.do?key_name=${list}"> 
			<c:forEach items="${list}" var="map">
	   			${map}
	   		</c:forEach>
				</a>
			</c:forEach>
	</div>

	<div class="mrate">컨텐츠 평점 : ${dto.mrate}</div>
	<div class="like">좋아요 수 : ${dto.cri_like}</div>
	
	<!-- 감독 배우 목록 -->	
	<div id="people" class="container-fluid text-center">
	  <h3>감독 / 출연</h3><br>
 	  <c:set var="no" value="1"></c:set>

		<c:forEach var="dto" items="${ peoplelist }" begin="0" end="${ fn:length(peoplelist) }" step="1">
			
		</c:forEach>

	</div>
	<!-- 감독 배우 목록 -->
	
	
	<hr>
	<div class="mem_id">ID : ${dto2.mem_id}</div>
	<div class="rev_title">후기 제목 : ${dto2.rev_title}</div>
	<div class="rev_reg">등록 날짜 : ${dto2.rev_reg}</div>
	<hr>
	<div class="rev_cont">한줄평 : ${dto2.rev_cont}</div>
	<div class="rev_rate">개인 평점 : ${dto2.rev_rate}</div>
	<div class="rev_spo">스포 여부 : ${dto2.rev_spo }</div>

</div>



<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>