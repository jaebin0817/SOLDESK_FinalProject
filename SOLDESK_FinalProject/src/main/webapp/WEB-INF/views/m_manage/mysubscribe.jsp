<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 mysubscribe.jsp -->
<!-- 구독OTT/파티 관리 -->
<div class="container text-center">
	
	<c:forEach var="dto" items="${list}" begin="1" end="1">
	<h1><strong>${ dto.mem_id }</strong> 님</h1>
	<h2>구독정보입니다</h2>
	</c:forEach>
	
		<table class="table table-hover">
		<tr>
			<th>구독OTT</th>
			<th>이용역할</th>
			<th>결제금액</th>
			<th>구독시작일</th>
			<th>구독종료일</th>
		</tr>

		<c:forEach var="dto" items="${list}"> 	
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>${dto.subscribe_end }</td>
			</tr>	
		</c:forEach>
		
	</table>

	
	
	


	
</div>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>