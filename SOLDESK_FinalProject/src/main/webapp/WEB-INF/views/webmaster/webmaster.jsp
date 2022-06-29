<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 webmaster.jsp -->
	
	
	<!-- 관리자페이지 -->
	
  <div class="container-fluid text-center">	

	<form name="frm" method="post" action="<%=request.getContextPath()%>/logout.do">		
		<input type="button" value="콘텐츠관리" onclick="location.href='/contmanage.do'">
		<input type="button" value="추천글관리" onclick="location.href='/themelist.do'">
		<input type="button" value="회원관리" onclick="location.href=location.href='/memberlist.do'">
		<input type="button" value="파티목록관리" onclick="location.href='/partylist.do'">
		<input type="button" value="파티매칭대기목록" onclick="">
		<input type="button" value="공지사항관리" onclick="location.href='/notice/noticemaster.do'">
		<hr>
		<input type="submit" value="로그아웃">
	</form>
  
  </div>	
	



<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>