<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 본문시작 memberIns.jsp -->
	
	<!-- 파티원 정보 입력 -->
	<input type="hidden" id="n_num" name="n_num" value="${dto.n_num}">
	<div class="container-fluid text-center">	
		<div class="container text-center">
			${dto.n_num}	
			${dto.n_title}
			${dto.n_date}
			${dto.n_content} 
			${dto.n_readcnt}
			${msg}
			<form name="frm" method="post" action="<%=request.getContextPath()%>/notice/noticedelelte.do?n_num=${dto.n_num}">
			<input type="submit" value="공지삭제하기"  class="btn btn-success">
			</form>
			<form name="frm" method="post" action="<%=request.getContextPath()%>/notice/noticeupdate.do?n_num=${dto.n_num}">
			<input type="submit" value="공지수정하기"  class="btn btn-success">
			</form>
			<a href="<%=request.getContextPath()%>/notice/noticeupdate.do?n_num=${dto.n_num}">수정하기</a>
			<a href="<%=request.getContextPath()%>/notice/noticedelelte.do?n_num=${dto.n_num}">삭제하기</a>
		</div>
	</div>




<!-- 본문끝 -->

<%@ include file="../footer.jsp"%>