<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 webmaster.jsp -->
	
	
	<!-- 관리자페이지 -->
	
  <div class="container-fluid text-center">	

	<form name="frm" method="post" action="<%=request.getContextPath()%>/notice/noticemaster.do">		
		<input type="button" value="콘텐츠추가" onclick="location.href='/addcontent.do'">
		<input type="button" value="게시글관리" onclick="location.href=''">
		<input type="button" value="회원관리" onclick="location.href=location.href='/memberlist.do'">
		<input type="button" value="파티목록관리" onclick="location.href='/partylist.do'">
		<input type="button" value="파티매칭대기목록" onclick="">
		<input type="submit" value="공지사항관리">
	</form>
  
  </div>	
	



<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>