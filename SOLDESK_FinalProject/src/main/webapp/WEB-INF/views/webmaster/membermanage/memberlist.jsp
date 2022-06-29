<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

<%@ include file="../../header.jsp"%>

<!-- 본문시작 memberlist.jsp -->
	
	
	<!-- 관리자페이지 : 회원정보 읽어오기 -->
	
  <div class="container-fluid text-center">	
		
	<table class="table table-hover">
		<tr>
			<th>회원ID</th>
			<th>연락처</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>생년월일</th>
			<th>회원등급</th>
		</tr>

		<c:forEach var="dto" items="${list}"> 	
			<tr>
				<td><a href="memread.do?mem_id=${dto.mem_id }">${dto.mem_id }</a></td>				
				<td>${dto.mem_phone }</td>
				<td>${dto.mem_email }</td>
				<td>${dto.mem_reg }</td>
				<td>${dto.mem_birth }</td>
				<td>
				  <select class="form-control" id="mem_lv" name="mem_lv">
                    <c:choose>
                    	<c:when test="${ dto.mem_lv eq 'A' }"><option value="A" selected>A</option></c:when>
                    	<c:otherwise><option value="A">A</option></c:otherwise>
                    </c:choose>
                    <c:choose>
                    	<c:when test="${ dto.mem_lv eq 'B' }"><option value="B" selected>B</option></c:when>
                    	<c:otherwise><option value="B">B</option></c:otherwise>
                    </c:choose>
					<c:choose>
                    	<c:when test="${ dto.mem_lv eq 'F' }"><option value="F" selected>F</option></c:when>
                    	<c:otherwise><option value="F">F</option></c:otherwise>
                    </c:choose>
                  </select>
				</td>
				
			</tr>	
			</c:forEach>
			<tr>
				<td colspan='6' style='text-align:center; height: 50px'>
					<form action="memberlist.do">
						<select name="col">
							<option value="mem_id">아이디
							<option value="mem_phone">연락처
							<option value="mem_email">이메일
							<option value="mem_lv">회원등급
						</select>
						<input type="text" name="word" id="word">
						<input type="submit" value="검색" class="btn btn-primary">
					</form>
				</td>
			</tr>
			<tr>
			<td colspan='6' style='text-align:center; height: 50px;' >
			${paging}

			</td>
		</tr>
		
	</table>

  </div>	
	



<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>