<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>

<script type="text/javascript" src="./js/contentcri_action.js"></script>

<!-- 본문시작 -->
<div class="container" align="center" id="cri_panel">
   		
   <form name="crifrm" id="crifrm" method="post">	
	<c:choose>
	<c:when test="${ s_mem_id==null || s_mem_pw==null || s_mem_lv==null }">
		<a href="<%=request.getContextPath()%>/login.do">로그인</a>
	</c:when>
	<c:otherwise> 
		<input type="button" id="likeBtn" value="좋아요" onclick="likeCheck()"> 
		<input type="button" id="watchBtn" value="봤어요" onclick="watchCheck()">
		<img src="../images/watched.png" width="20px">
		<input type="button" id="pointBtn" value = "찜하기" onclick="pointCheck()">
		<img src="../images/heart.png" width="20px">

	</c:otherwise>
	</c:choose>
	</form>
</div>	

<%@ include file="../footer.jsp"%>