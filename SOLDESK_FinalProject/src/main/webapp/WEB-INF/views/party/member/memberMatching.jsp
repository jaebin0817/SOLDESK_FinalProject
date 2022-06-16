<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>

<!-- 본문시작 memberMatch.jsp -->
	
	<!-- 파티원 정보 입력 -->
	
	<div class="container-fluid text-center">
	<form name="frm" method="post" action="party/membermatch.do">
		<input type="hidden" id="ott_name" name="ott_name" value="${ ott_name }">
		<input type="hidden" id="mem_id" name="mem_id" placeholder="회원아이디" value="${ mem_id }"><!-- 세션정보에서 가져오기 -->
		<input type="hidden" id="ott_price" name="ott_price" value="${ ott_price }">
		
		<h3>매칭 준비가 되었습니다<h3>
		매칭이 완료되면 결제됩니다
		매칭예상 시간 ${ ott_name }는 약 2시간 소요
		
		${ ott_name }
		<br>
		<input type="submit" value="시작하기"  class="btn btn-success">
	</form>
	</div>




<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>