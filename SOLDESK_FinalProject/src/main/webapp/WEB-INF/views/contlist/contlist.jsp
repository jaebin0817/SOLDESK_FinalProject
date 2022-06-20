<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 contlist.jsp -->

<div id="cont_list" class="container-fluid text-center">
	
	<h3>↓ 원하는 영화나 드라마를 마음껏! ↓</h3>
	<br>

	<c:forEach var="dto" items="${list}">
		<div class="col-sm-3">
			<div class="thumbnail">
				<a href="contlist/contlistread.do?mcode=${ dto.mcode }"><img src="../../storage/${dto.mthum }" alt="movie"
					width="300px"></a>
				<div class="mtitle">${dto.mtitle }</div>
				<div class="mrate">평점 : ${dto.mrate}</div>

				<c:if test="${dto.netflix eq 'O' }" >
					<img src="../../images/icon_netflix.png" width="20px">
				</c:if>
				<c:if test="${dto.tving eq 'O'  }" >
					<img src="../../images/icon_tving.png" width="20px">
				</c:if>
				<c:if test="${dto.watcha eq 'O'  }" >
					<img src="../../images/icon_watcha.png" width="20px">
				</c:if>
				<c:if test="${dto.diseny eq 'O'  }" >
					<img src="../../images/icon_disney.png" width="20px">
				</c:if>

			</div>
		</div>
	</c:forEach>
	
</div>


	<!-- 본문 끝 -->
	
<%@ include file="../footer.jsp"%>	