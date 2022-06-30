<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 mysubscribe.jsp -->
<!-- 구독OTT/파티 관리 -->
<div class="container text-center">

	<div class="pagetitle">
		<br>
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 구독OTT/파티정보 </strong></span>
		<br>
	</div>
	
	<h4><strong>${ s_mem_id }</strong> 님의 구독정보입니다 </h4>
	
		<table class="table">
		<tr>
			<th>구독OTT</th>
			<th>이용금액</th>
			<th>이용역할</th>
			<th>구독시작일</th>
			<th>구독종료일</th>
			<th>OTT계정ID</th>
			<th>OTT계정PW</th>
		</tr>
		
		<c:set var="savedFee" value="${ 0 }"></c:set>
		
		<c:forEach var="dto" items="${list}"> 	
			
			<c:choose>
				<c:when test="${dto.party_role eq '파티장' }">
					<c:set var="serviceFee" value="${ 400 }"></c:set>
				</c:when>
				<c:when test="${dto.party_role eq '파티원' }">
					<c:set var="serviceFee" value="${ 500 }"></c:set>
				</c:when>
			</c:choose>

			<tr>
				<td>${ dto.ott_name }</td>
				<td>${ fn:substringBefore(dto.ott_price/4+serviceFee, '.') }</td>
				<td>${ dto.party_role }</td>
				<td>${ dto.subscribe_start }</td>
				<td>${ dto.subscribe_end }</td>
				<td>${ dto.ott_id }</td>
				<td>${ dto.ott_pw }</td>
			</tr>	
			
			<tr style="display: none;">
			  <td colspan="7">${ savedFee=savedFee+dto.ott_price/4+serviceFee }</td>
			</tr>
			
		</c:forEach>
		
		<tr>
			<td colspan="3">혼자 사용시 결제했을 금액</td>
			<td colspan="4">${ totalOttFee }</td>
		</tr>
		<tr>
			<td colspan="3">OPOT 파티에서 결제한 금액</td>
			<td colspan="4">${ fn:substringBefore(savedFee, '.') }</td>
		</tr>
		<tr>
			<td colspan="3">OPOT으로 절약한 금액</td>
			<td colspan="4"><strong>${ fn:substringBefore(totalOttFee-savedFee, '.') }</strong></td>
		</tr>
		
	</table>

	
	
	


	
</div>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>