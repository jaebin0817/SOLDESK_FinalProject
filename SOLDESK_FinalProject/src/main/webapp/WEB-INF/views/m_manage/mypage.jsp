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
			
			<button type="button" class="btn btn-default btn-lg btn-block" onclick="location.href='member_info.do'">개인정보수정</button>
	    	<br><br>
			<button type="button" class="btn btn-default btn-lg btn-block" onclick="location.href='mysubscribe.do'">구독관리/마이파티</button>	    	
	    	<br><br>
			<button type="button" class="btn btn-default btn-lg btn-block" onclick="location.href='mycontent.do'">나의 컨텐츠/시청 정보</button>	    		    	
	    	<br><br>
			<button type="button" class="btn btn-default btn-lg btn-block" onclick="location.href='member_bank.do'">계좌등록 및 변경</button>	    		    	
	    	
	    	<hr>
	    	<input type="submit" value="로그아웃" class="btn btn-danger btn-lg">
			<br><br>
			
		</form>

</div>
<!-- 마이 페이지 끝 -->

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>