<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

<%@ include file="../../header.jsp"%>

<!-- 본문시작 contentrlist.jsp -->
	
	
<!-- 관리자페이지 : 콘텐츠 리스트 읽어오기 -->
	
  <div class="container-fluid text-center">	
	
	
	<div class="pagetitle">
		<br>
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 영화제목을 누르면 수정페이지로 이동합니다 </strong></span>
		<br>
	</div>
	
	<input type="button" value="콘텐츠추가" onclick="location.href='/addcontent.do'">
	
		
	<table class="table table-hover">
		<tr>

			<th>영화코드</th>
			<th>영화제목</th>
		</tr>

		<c:forEach var="dto" items="${list}"> 	
			<tr>
				<td>${ dto.mcode }</td>
				<td><a href="contupdate.do?mcode=${ dto.mcode }">${dto.mtitle }</a></td>				
			</tr>	
		</c:forEach>
		
	</table>

  </div>	
	



<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>