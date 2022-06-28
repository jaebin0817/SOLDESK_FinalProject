<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  

<!-- 본문시작 noticelist.jsp -->
  	<div class="container-fluid text-center">
	
	<div class="pagetitle">
		<br>
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 공지사항 </strong></span>
		<br>
	</div>	


		<div class="container-fluid text-center">
		<table class="table">
		<tr>
			<th>글제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>그룹번호</th>
			<th>등록일</th>
			
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td><a href="../qna/qnaread.do?qna_num=${dto.qna_num}">${dto.qna_title}</a></td>
				<td>${dto.mem_id}</td>
				<td>${dto.qna_readcnt}</td>
				<td>${dto.qna_grpno}</td>
				<td>${dto.qna_date}</td>
			</tr>
		</c:forEach>
		
		</table>
		</div>
		<form name="frm" id="frm" method="post" action="qnaForm.do" onsubmit="return IDlog(${mem_lv})">
            <input type="submit" value="문의사항등록"  class="btn btn-danger">
        </form>
	</div>
		
	<script>
	function IDlog(mem_lv) {
		if(mem_lv==null || mem_lv=="F"){
			alert("로그인 후 작성가능합니다")
			return false;
		}
		return true;
	}//IDlog() end

	</script>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>