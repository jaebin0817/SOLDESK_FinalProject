<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  

<!-- 본문시작 notice.jsp -->
	
  	<div class="container-fluid text-center">
	<h3>공지사항입니다</h3>
		<div class="container-fluid text-center">
		<table>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.n_num}</td>	
				<td><a href="../notice/noticemasterread.do?n_num=${dto.n_num}">${dto.n_title}</a></td>
				<td>${dto.n_date}</td>
				<td>${dto.n_readcnt}</td>
			</tr>
		</c:forEach>
		
		</table>
		</div>
	</div>
	<form name="frm" method="post" action="<%=request.getContextPath()%>/notice/noticewrite.do">
		<input type="submit" value="공지사항등록"  class="btn btn-success">
	</form>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>