<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 mypage.jsp -->
	
<!-- 마이 페이지 바디 -->
<div class="container" style="text-align: center;" >
	<% 
	   String mem_id = request.getParameter("mem_id");
	   String mem_phone = request.getParameter("mem_phone");
	%>
		<h3> 아이디 ${ s_mem_id }</h3>

		<ul>
	    	<li>
	    		<input type="button" value="개인정보수정" onclick="location.href='member_info.do'">
	    	</li>
	    	<br>
	    	<li>
	    		<input type="button" value="구독관리/마이파티" onclick="location.href='mysubscribe.do'">
	    	</li>
	    	<br>
	    	<li>
	    		<input type="button" value="계좌등록 및 변경" onclick="location.href='member_bank.do'">
	    	</li>
		</ul>
</div>
<!-- 마이 페이지 끝 -->

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>