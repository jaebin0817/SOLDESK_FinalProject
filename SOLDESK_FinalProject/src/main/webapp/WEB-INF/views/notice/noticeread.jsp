<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 본문시작 noticeread.jsp -->
	
	
	<div class="container-fluid text-center">	
		<div class="container text-center">
		<table class="table" >
		<tr>
			<td colspan="2"><h1>${dto.n_title}</h1></td>
		</tr>
		<tr>
			<th>공지날짜</th>
			<td>${dto.n_date}</td>
		</tr>
		<tr>
			<th colspan="2" ><h4>내용</h4></th>
		</tr>
		<tr height=500>
			<td colspan="2"><h3>${dto.n_content}</h3></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${dto.n_readcnt}</td>
		</tr>
		</table>
		<input type="button" value="홈으로"  onclick="location.href='/home.do'" class="btn btn-default">
		<input type="button" value="공지목록" onclick="location.href='/notice/notice.do'" class="btn btn-default">
		</div>
	</div>




<!-- 본문끝 -->

<%@ include file="../footer.jsp"%>