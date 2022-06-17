<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 member_info.jsp -->
	
	
<!-- 회원 가입 시작 -->
<h1 align="center"> 회원 가입</h1>
<div class = "container">
	<h1>회원 가입</h1>
	<form name="member_join" id="mem_info" method = "get">
	<table class="table">
	  <tr>
		<th>아이디 : </th> 
		<td style="text-align: left;">
				<input type="text" name="mem_id" id="mem_id">
		</td>
	  </tr>
	  <tr>
	  	<th>비밀번호 : </th>
	  	<td style="text-align: left;">
	  			<input type="password" name="mem_pw" id="mem_pw"  >
	  	</td>
	  </tr>
	  <tr>
	  	<th>연락처 : </th>
	  	<td style="text-align: left;">
	  			<input type="tel" name="mem_phone" id="mem_phone" >
	  	</td>
	  </tr>
	  <tr>
	  	<th>이메일 : </th>
	  	<td style="text-align: left;">
	  			<input type="email" name="mem_email" id="mem_email" >
	  	</td>
	  </tr>
	  <tr>
	  	<th>생년월일: </th>
	  	<td style="text-align: left;">
	  		<input type="text" name="birth_year" id="birth_year">
	  		-
	  		<input type="text" name="gender_code" id="gender_code" style="width:100px;">
	  	</td>
	  </tr>
	  <tr>
		 <td colspan="2">
		    <input type="submit" value="회원가입"  class="btn btn-primary"/>
		    <input type="reset"  value="취소"        class="btn btn-primary"/>
		 </td>
	  </tr>
	</table>
	</form>

	
</div>
<!-- 회원 가입 끝 -->		

	

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>