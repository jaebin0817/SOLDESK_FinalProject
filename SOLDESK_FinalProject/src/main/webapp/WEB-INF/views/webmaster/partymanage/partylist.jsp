<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

<%@ include file="../../header.jsp"%>

<!-- 본문시작 partylist.jsp -->
	
	
	<!-- 관리자페이지 : 파티정보 읽어오기 -->
	
  <div class="container-fluid text-center">	
		
	<table class="table table-hover">
		<tr>
			<th>파티아이디</th>
			<th>파티장</th>
			<th>구독OTT</th>
			<th>생성날짜</th>
			<th>매칭인원</th>
		</tr>

		<c:forEach var="dto" items="${list}"> 	
			<tr>
				<td>${dto.party_id }</td>
				<td><a href="partyread.do?party_id=${dto.party_id }">${dto.mem_id }</a></td>				
				<td>${dto.ott_name }</td>
				<td>${dto.ott_cdate }</td>
				<td>${dto.matching_no }</td>
			</tr>	
		</c:forEach>
		
	</table>

  </div>	
	



<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>