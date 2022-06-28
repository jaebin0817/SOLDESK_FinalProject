<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>

<!-- 본문시작 accountInsert.jsp -->
	
	<!-- 계좌번호 입력 -->
	
	<div class="container-fluid text-center">	
	
		<div>공유할 ${ ott_name } 계정을 등록해주세요</div>
	    <form name="frm" method="post" action="checkout.do">
			
			<input type="hidden" id="ott_name" name="ott_name" value="${ ott_name }">
			<input type="hidden" id="ott_price" name="ott_price" value="${ ott_price }">
			<input type="hidden" id="payback_amount" name="payback_amount" value="${ payback_amount }">
			<input type="hidden" id="bank_name" name="bank_name" value="${ bank_name }">
			<input type="hidden" id="bank_account" name="bank_account" value="${ bank_account }">
			
			
			<input type="text" id="ott_id" name="ott_id" placeholder='${ ott_name }아이디 입력'>
			<input type="text" id="ott_pw" name="ott_pw" placeholder="OTT 비밀번호 입력">

		    
		    <div>
		      <input type="submit" value="다음" class="btn btn-danger">
		    </div>  
	    </form>
	
	</div>




<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>