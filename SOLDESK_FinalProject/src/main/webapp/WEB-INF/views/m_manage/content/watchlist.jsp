<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

<%@ include file="../../header.jsp"%>

<!-- 본문시작 watchlist.jsp -->
	
	
  <div class="container-fluid text-center">	
		
	<table class="table table-hover">
		<tr>
			<th>영화 코드</th>
			<th>영화 이름</th>
			<th>본 날짜</th>
			<th>시청 번호</th>
		</tr>

		<c:forEach var="dto" items="${watchlist}"> 	
			<tr>
				<td>${dto.mcode }</td>
				<td>
					<img src="../../storage/${ dto.mthum }" alt="${ dto.mtitle }" width="50px">
					<a href="<%=request.getContextPath()%>/contlist/contlistread.do?mcode=${ dto.mcode }">${ dto.mtitle }</a>
				</td>				
				<td>${dto.watch_time }</td>
				<td>${dto.watch_reg }</td>
			</tr>	
		</c:forEach>
		
	</table>

  </div>	


<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>