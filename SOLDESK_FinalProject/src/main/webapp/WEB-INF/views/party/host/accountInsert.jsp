<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>

<!-- 본문시작 accountInsert.jsp -->
	
	<!-- 계좌번호 입력 -->
	
	<div class="container-fluid text-center">	
	
		<div>정산받을 계좌의 은행을 선택해주세요</div>
	    <form name="frm" method="post" action="ottinfo.do">
			
			<input type="hidden" id="ott_name" name="ott_name" value="${ ott_name }">
			<input type="hidden" id="ott_price" name="ott_price" value="${ ott_price }">
			<input type="hidden" id="payback_amount" name="payback_amount" value="${ payback_amount }">
			
			
			<input type="text" id="bank_name" name="bank_name" placeholder="은행명">
			<input type="text" id="bank_account" name="bank_account" placeholder="본인명의 계좌번호 입력">
			
			
		    
		    <div>
		      <input type="submit" value="다음">
		    </div>  
	    </form>
	
	</div>




<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>