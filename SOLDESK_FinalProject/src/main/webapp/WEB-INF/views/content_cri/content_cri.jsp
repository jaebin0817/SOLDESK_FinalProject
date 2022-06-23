<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>


<!-- 본문시작 -->
<div class="container" align="center" id="cri_panel">
   		
   <form name="crifrm" id="crifrm" method="post">	
	<c:choose>
	<c:when test="${ s_mem_id==null || s_mem_pw==null || s_mem_lv==null }">
		<a href="<%=request.getContextPath()%>/login.do">로그인</a>
	</c:when>
	<c:otherwise>  
		<input type="hidden" id="like_check" value="${dto.cri_like}">
		<button type="button" id="likeBtn" >좋아요</button> 
		<div id="like_result">${dto.cri_like}</div> 
		<button type="button" name="watch" id="watchBtn">
		<img src="../images/watched.png" width="20px">봤어요</button>
		<button type="button" name="point" id="pointBtn">
		<img src="../images/heart.png" width="20px">찜하기</button> 

	</c:otherwise>
	</c:choose>
	</form>
</div>	
	<script>
	$(document).on("click", function() 
		 $.ajax({
			 url: "content_cri/content_crilike.do", 
			 type: "POST",		    
			 data: mcode : $("#crifrm").serialize(),		    
			 dataType: "json",		       
			 success: function(data){ 
				alert("'좋아요'가 반영되었습니다!") ;
				},
		     error: function (request, status, error){
			    alert("ajax실패")                  		    
			 }		  
		});
	}
	</script>

<%@ include file="../footer.jsp"%>