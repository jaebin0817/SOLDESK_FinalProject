<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 -->
<div>	
	<!-- 포스터 -->
	<img src="<%=request.getContextPath() %>">
	<table>
		<tr>
		  <td><img src="../images/like.jpg"> <input type="button" value="좋아요"> </td>
		</tr>
	</table>
	<input type="button"> 
</div>
<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>