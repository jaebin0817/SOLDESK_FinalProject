<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>

<!-- 본문시작 checkout.jsp -->
	
	<!-- 파티장 신청자가 마지막을 입력한 정보를 확인한 뒤 insert -->
	
	<div class="container-fluid text-center">
	<div>파티 생성</div>
    <form name="frm" method="post" action="create.do">
		
		<input type="text" id="mem_id" name="mem_id" placeholder="회원아이디" value="${ s_mem_id }"><!-- 세션으로 줄것임 -->
		<input type="text" id="ott_name" name="ott_name" placeholder="OTT종류" value="${ ott_name }"><!-- 히든으로 줄것임 -->
		<input type="text" id="ott_price" name="ott_price" placeholder="OTT가격" value="${ ott_price }"><!-- 히든으로 줄것임 -->
		<input type="text" id="ott_id" name="ott_id" placeholder="OTT 계정 아이디" value="${ ott_id }">
		<input type="password" id="ott_pw" name="ott_pw" placeholder="OTT 계정 비번" value="${ ott_pw }">
		<input type="text" id="bank_name" name="bank_name" placeholder="정산 계좌 은행명" value="${ bank_name }">
		<input type="text" id="bank_account" name="bank_account" placeholder="정산 계좌 번호" value="${ bank_account }">
		<input type="text" id="payback_amount" name="payback_amount" placeholder="정산 금액" value="${ payback_amount }">
	    
	    <div>
	      <input type="submit" value="파티 생성하기"><!-- 파티생성 완료 안내창으로 이동 -->
	    </div>  
    </form>
	</div>
	




<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>