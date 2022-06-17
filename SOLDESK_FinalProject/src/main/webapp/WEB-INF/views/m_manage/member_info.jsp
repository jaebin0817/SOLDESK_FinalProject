<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 member_info.jsp -->
	
	
	<!-- 회원정보 수정 시작 -->
	<div class = "container">
		<% 
			
		%>
		<div class="content">
			<h1>회원 정보 수정</h1>
			<form name="mem_info" id="mem_info" method = "get">
			<table class="table">
			  <tr>
				<th>아이디 : </th>
				 
				<td style="text-align: left;">
					<input type="text" value="${ dto.mem_id }" readonly>
				</td>
			  </tr>
			  <tr>
			  	<th>비밀번호 : </th>
			  	<td style="text-align: left;">
			  		
			  		<input type="password" name="mem_pw" id="mem_pw">${ dto.mem_pw }
			  	</td>
			  </tr>
			  <tr>
			  	<th>연락처 : </th>
			  	<td style="text-align: left;">
			  		
					<input type="text" value="${ dto.mem_phone }">
			  	</td>
			  </tr>
			  <tr>
			  	<th>이메일 : </th>
			  	<td style="text-align: left;">
			  		
					<input type="text" value="${ dto.mem_email }">
			  	</td>
			  </tr>
			  <tr>
			  	<th>가입날짜: </th>
			  	<td style="text-align: left;">
			  	 	${ dto.mem_reg }
			  	</td>
			  </tr>
			  <tr>
			  	<th>생년월일: </th>
			  	<td style="text-align: left;">
			  		<input type="text" value="${ dto.mem_birth }" readonly>
			  		
			  	</td>
			  </tr>
			  <tr>
				 <td colspan="2" align="center">
				    <input type="submit" value="회원정보수정"  class="btn btn-primary"/>
				    <input type="reset"  value="취소"        class="btn btn-primary"/>
				 </td>
			  </tr>
		  <tr>
		  	
		</table>
		</form>
		</div>
	</div>
	<!-- 회원정보 수정 끝 -->
		

	

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>