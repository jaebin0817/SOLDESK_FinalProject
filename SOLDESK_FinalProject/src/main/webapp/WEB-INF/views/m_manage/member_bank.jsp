<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 member_bank.jsp -->
	
	
	<!-- 계좌등록/변경 시작 -->
	<div class="container" align="center">
		<h1>계좌등록</h1>
		<form name="bankfrm">
		<table>
		  <tr>
		     <td>계좌번호: <input type="text" id="bank_num" name="bank_num">
		     <td>은행 :  
		     	<select id="bankname" name="bankname">
		     		<option>국민</option>
		     		<option>신한</option>
		     		<option>우리</option>
		     	</select>
		  </tr>
		</table>
		</form>
		
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</div>
	<!-- 계좌등록/변경 끝 -->




	

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>