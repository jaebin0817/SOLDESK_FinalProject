<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>

<!-- 본문시작 payback.jsp -->
	
	<!-- 정산 금액 및 일자 체크 -->
	
	<div class="container-fluid text-center">	
	
		<div>매월 정산받는 금액과 일자를 확인해주세요</div>
	    <form name="frm" method="post" action="">
			
			<input type="hidden" id="ott_name" name="ott_name" value="${ ott_name }">
			<input type="hidden" id="ott_name" name="ott_name" value="${ ott_price }">
			
			<h1>${ ott_name }</h1>
			
			혼자 사용할 때 금액 : ${ ott_price }<br>
			
			매월 정산받는 금액 : ${ payback_amount }<br><hr>
			
		    
		    <div>
		      <input type="submit" value="시작하기">
		    </div>  
	    </form>
	
	</div>




<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>