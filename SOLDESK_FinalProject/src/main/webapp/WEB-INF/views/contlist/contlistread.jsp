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
		<img src="../../storage/${dto.mthum}" alt="movie" width="300px">
	</a>
	<c:if test="${dto.netflix eq 'O' }">
		<img src="../../images/Netflix.png" width="50px">
	</c:if>
	<c:if test="${dto.tving eq 'O'  }">
		<img src="../../images/Tving.png" width="50px">
	</c:if>
	<c:if test="${dto.watcha eq 'O'  }">
		<img src="../../images/Watcha.png" width="50px">
	</c:if>
	<c:if test="${dto.diseny eq 'O'  }">
		<img src="../../images/Diseny.png" width="50px">
	</c:if>

	<div class="mtitle">${dto.mtitle}</div>
	<div class="mrate">영화 평점 : ${dto.mrate}</div>
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
