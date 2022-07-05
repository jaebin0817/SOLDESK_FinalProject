<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>

<!-- 본문시작 msgView.jsp -->

  <div class="container-fluid text-center">
  	<h1>${ ott_name }</h1>
  	
  	<h5>등록된 카드 정보가 존재합니다</h5>
  	<table class="table">
  		<tr>
  			<th width=30%>카드사</th>
  			<th>카드번호</th>
  		</tr>
  		<tr>
  			<th><h3>${ dto.card_com }카드</h3></th>
  			<th><h3>${ dto.card_no }</h3></th>
  		</tr>
  	</table>
  	<form method="post" action="cardupdate.do">
		<input type="submit" value="수정하기" class="btn btn-success">
	</form>

	
	<h3>${ ott_name } 기존 프리미엄 서비스 이용가격 ${ott_price} 에서</h3> <br>
	<h3>${payback_amount} 원 절약하여</h3>
	<h3>${party_pcost} 원 으로 절약하시게 됩니다~</h3>
	<br>
	파티 매칭을 시작하시겠습니까?
	<br>
	
	<form method="post" action="membermatch.do">	
		<input type="submit" value="매칭하기" class="btn btn-success">
		<input type="hidden" id="mem_id" name="mem_id" placeholder="회원아이디" value="${ mem_id }">
		<input type="hidden" id="ott_name" name="ott_name" value="${ ott_name }"> 
		<input type="hidden" id="ott_price" name="ott_price" value="${ ott_price }">
		<input type="hidden" id="party_pcost" name="party_pcost" value="${ party_pcost }">
	</form>

    
    

    
  </div>  

<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>