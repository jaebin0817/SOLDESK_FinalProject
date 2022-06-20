<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 -->
<div>
	<div class="w3-border w3-center w3-padding">
		<c:if test="${ mem_id == null }">
			추천 기능은 <button type="button" id="login"><b class="w3-text-blue">로그인</b></button> 후 사용 가능합니다.<br />
				<i class="fa fa-heart" style="font-size:16px;color:red"></i>
				<span class="rec_count"></span>					
		</c:if>
		<c:if test="${ mem_id != null }">
			<button class="w3-button w3-black w3-round" id="rec_update">
				<i class="fa fa-heart" style="font-size:16px;color:red"></i>
					&nbsp;<span class="rec_count"></span>
			</button> 
		</c:if>
	</div>
</div>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>