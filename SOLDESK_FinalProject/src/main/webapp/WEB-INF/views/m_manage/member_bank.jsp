<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 member_bank.jsp -->
	
	
	<!-- 계좌등록/변경 시작 -->
	<div class="container" align="center">
		<div class="pagetitle">
			<br>
			<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
			<span><strong> 계좌 등록 </strong></span>
			<h5>★★★기존에 등록되어 있는 계좌가 있다면 노출시키고 수정 버튼 노출</h5>
			<h5>★★★기존에 등록되어 있는 계좌가 없다면 등록 버튼 노출</h5>
		</div>
		<form name="bankfrm">
			<table class="table table-bordered" id="login_table" style="width:500px; margin:auto;">
		  	  <tr>
		  	    <th>은행</th>
				<td>
				  <input type="text" id="bank_name" name="bank_name" class="form-control">
				</td>
			  </tr>
			  <tr>
			  	<th>계좌번호</th>
				<td>
				  <input type="text" id="bank_account" name="bank_account" class="form-control">
				</td>
			  </tr>
		</table>
		</form>
		<br>
		<input class="btn btn-default" type="submit" value="등록">
		<input class="btn btn-default" type="reset" value="취소">
	</div>
	<!-- 계좌등록/변경 끝 -->




	

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>