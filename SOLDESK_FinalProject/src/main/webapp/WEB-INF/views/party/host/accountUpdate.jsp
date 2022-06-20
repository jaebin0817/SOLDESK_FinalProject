<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>

<!-- 본문시작 accountUpdate.jsp -->
	
	<!-- 은행계좌 업데이트 (DB에 저장된 계좌가 있을 때) -->
	
	<div class="container-fluid text-center">	
	
		<div>계좌업데이트</div>
		<div>현재 등록된 은행을 확인해주세요</div>
	    <form name="frm" method="post" action="ottinfo.do">
			
			<input type="hidden" id="ott_name" name="ott_name" value="${ ott_name }">
			<input type="hidden" id="ott_price" name="ott_price" value="${ ott_price }">
			<input type="hidden" id="payback_amount" name="payback_amount" value="${ payback_amount }">
			
			
			<input type="text" id="bank_name" name="bank_name" value="${ dto.bank_name }" placeholder="은행명">
			<input type="text" id="bank_account" name="bank_account" value="${ dto.bank_account }" placeholder="본인명의 계좌번호 입력">
			
			
		    
		    <div>
		      <input type="submit" value="다음">
		    </div>  
	    </form>

	
	</div>




<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>