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
	
	<input type="button" value="콘텐츠추가" onclick="location.href='/addcontent.do'"><br><br>
	
		
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
			<tr>
			<td colspan='2' style='text-align:center; height: 50px'>
				<form action="contmanage.do">
					<select name="col">
						<option value="mcode">영화코드
						<option value="mtitle">영화제목
					</select>
					<input type="text" name="word" id="word">
					<input type="submit" value="검색" class="btn btn-primary">
				</form>
			</td>
			</tr>
			<tr>
				<td colspan='2' style='text-align:center; height: 50px;' >
				${paging}
	
				</td>
			</tr>
	</table>
  </div>	
	



<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>