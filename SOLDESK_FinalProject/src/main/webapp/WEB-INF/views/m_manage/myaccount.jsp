<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 myaccount.jsp -->
	
	
	<!-- 등록된 카드/계좌 정보 확인 -->
	<div class="container" align="center">
		<div class="pagetitle">
			<br>
			<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
			<span><strong> 결제카드/정산계좌 정보 </strong></span>
		</div>
		
		<div id="card-wrap">
		</div>
		
		<br>
		<input class="btn btn-default" type="submit" value="등록">
		<input class="btn btn-default" type="reset" value="취소">
		
		<table class="table table-bordered" id="bank_table" style="width:500px; margin:auto;">
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