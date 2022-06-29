<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 mypage.jsp -->
	
<!-- 마이 페이지 바디 -->
<div class="container text-center">

	<div class="pagetitle">
		<br>
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 마이페이지 </strong></span>
		<br>
	</div>


		<h3> <strong>${ s_mem_id }</strong>님 환영합니다</h3><hr>
			
		<form action="<%=request.getContextPath()%>/logout.do" method="post"> 
			
	    	<input type="button" value="개인정보수정" onclick="location.href='member_info.do'">
	    	<br><br>
	    	<input type="button" value="구독관리/마이파티" onclick="location.href='mysubscribe.do'">
	    	<br><br>
	    	<input type="button" value="나의 컨텐츠" onclick="location.href='mycontent.do'">
	    	<br><br>
	    	<input type="button" value="계좌등록 및 변경" onclick="location.href='member_bank.do'">
	    	<hr>
	    	<input type="submit" value="로그아웃">
			<br><br>
			
		</form>

</div>
<!-- 마이 페이지 끝 -->

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>