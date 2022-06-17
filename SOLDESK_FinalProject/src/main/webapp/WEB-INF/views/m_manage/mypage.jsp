<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 마이 페이지 바디 -->
<div class="container" style="text-align: center;" >
		<h3> 아이디 : ${ dto.mem_id } </h3>
		<br>
		<h4> 전화번호 : ${ dto.mem_phone } </h4>
		<ul>
	    	<li>
	    		<input type="button" value="개인정보수정" onclick="location.href='member_info.do'">
	    	</li>
	    	<br>
	    	<li>
	    		<input type="button" value="구독관리/마이파티" onclick="location.href='member_subandpa.do'">
	    	</li>
	    	<br>
	    	<li>
	    		<input type="button" value="계좌등록 및 변경" onclick="location.href='member_bank.do'">
	    	</li>
		</ul>
</div>
<!-- 마이 페이지 끝 -->

<%@ include file="../footer.jsp" %>