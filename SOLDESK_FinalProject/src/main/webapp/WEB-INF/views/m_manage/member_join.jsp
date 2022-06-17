<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 회원 가입 시작 -->
<h1 align="center"> 회원 가입</h1>
<div class = "container">
	<h1>회원 가입</h1>
	<form name="member_join" id="mem_info" method="post" action="<%=request.getContextPath()%>/member_join.do" onsubmit="return">
	<table class="table">
	  <tr>
		<th>아이디 : </th> 
		<td>
			<input type="text" name="mem_id" id="mem_id">
		</td>
	  </tr>
	  <tr>
	  	<th>비밀번호 : </th>
	  	<td>
	  		<input type="password" name="mem_pw" id="mem_pw"  >
	  	</td>
	  </tr>
	  <tr>
	  	<th>연락처 : </th>
	  	<td>
	  		<input type="tel" name="mem_phone" id="mem_phone" >
	  	</td>
	  </tr>
	  <tr>
	  	<th>이메일 : </th>
	  	<td>
	  			<input type="email" name="mem_email" id="mem_email" >
	  	</td>
	  </tr>
	  <tr>
	  	<th>생년월일: </th>
	  	<td>
	  		<input type="text" name="mem_birth" id="mem_birth" maxlength="7">
	  	</td>
	  </tr>
	  <tr>
		 <td colspan="2" align="center">
		    <input type="submit" value="회원가입"  class="btn btn-primary"/>
		    <input type="reset"  value="취소"        class="btn btn-primary"/>
		 </td>
	  </tr>
	</table>
	</form>

	
</div>
<!-- 회원 가입 끝 -->

<%@ include file="../footer.jsp" %>