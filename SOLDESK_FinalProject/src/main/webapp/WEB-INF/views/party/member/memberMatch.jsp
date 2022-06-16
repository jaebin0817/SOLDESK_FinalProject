<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>

<!-- 본문시작 memberMatch.jsp -->
	
	<!-- 파티원 정보 입력 -->
	
	<div class="container-fluid text-center">
	<form name="frm" method="post" action="membermatch.do">
		<input type="hidden" id="ott_name" name="ott_name" value="${ ott_name }">
		<input type="hidden" id="mem_id" name="mem_id" placeholder="회원아이디" value="${ mem_id }"><!-- 세션정보에서 가져오기 -->
		<input type="hidden" id="ott_price" name="ott_price" value="${ ott_price }">
		
		파티 매칭을 시작합니다
		<br>
		<input type="submit" value="시작하기"  class="btn btn-success">
	</form>
	</div>




<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>