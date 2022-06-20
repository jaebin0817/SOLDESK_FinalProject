<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  

<!-- 본문시작 notice.jsp -->
  	<div class="container-fluid text-center">

	<div class="pagetitle">
		<br>
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 공지사항 </strong></span>
		<br><br>
	</div>


	<table class="table">
	<tr>
		<th>글번호</th>
		<th>글제목</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.n_num}</td>	
			<td>${dto.n_title}</td>
			<td>${dto.n_date}</td>
			<td>${dto.n_readcnt}</td>
		</tr>
	</c:forEach>
	
	</table>
	</div>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>