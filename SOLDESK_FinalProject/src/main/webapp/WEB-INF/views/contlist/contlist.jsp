<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

	<!-- 메인카테고리 끝 -->

	<!-- 본문 시작 -->
	<div id="cont_list" class="container-fluid text-center">
		<h3>↓ 원하는 영화나 드라마를 마음껏! ↓</h3>
		<br>


<c:forEach var="dto" items="${list}">
	<div class="col-sm-3">
		<div class="thumbnall">
			<a href="<%=request.getContextPath()%>/contlist/contlistread.do?mcode=${ dto.mcode }">
				<img src="../../storage/${dto.mthum}" alt="movie"
				width="300px">
			</a>
			<div class="mtitle">${dto.mtitle}</div>
			<div class="mrate">평점 : ${dto.mrate}</div>
			
		
			<c:if test="${dto.netflix eq 'O' }" >
				<img src="../../images/icon_netflix.png" width="50px">
			</c:if>
			<c:if test="${dto.tving eq 'O'  }" >
				<img src="../../images/icon_tving.png" width="50px">
			</c:if>
			<c:if test="${dto.watcha eq 'O'  }" >
				<img src="../../images/icon_watcha.png" width="50px">
			</c:if>
			<c:if test="${dto.diseny eq 'O'  }" >
				<img src="../../images/icon_disney.png" width="50px">
			</c:if>
			
			
			</div>
	</div>
</c:forEach>
</div>


	<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>