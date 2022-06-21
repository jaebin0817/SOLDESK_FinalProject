<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>

<!-- 본문시작 -->
<div class="container" align="center">	
	<c:choose>
	<c:when test="${ s_mem_id==null || s_mem_pw==null || s_mem_lv==null }">
		<a href="<%=request.getContextPath()%>/login.do">로그인</a>
	</c:when>
	<c:otherwise>  
		
		<a href="content_cri.do" onclick="javascript:like_func()">
		<img src="../images/like.png" width="20px">좋아요</a>
		<a href="content_cri.do" onclick="javascript:like_func()">
		<img src="../images/dislike.png" width="20px">싫어요</a>
		
		<a href="content_cri.do" onclick="javascript:watch_func()">
		<img src="../images/watched.png" width="20px">봤어요</a> 
		<a href="content_cri.do" onclick="javascript:point_func()">
		<img src="../images/heart.png" width="20px">찜하기</a> 

	</c:otherwise>
	</c:choose>

</div>	
<%@ include file="../footer.jsp"%>