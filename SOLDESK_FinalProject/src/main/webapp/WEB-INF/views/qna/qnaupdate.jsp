<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 noticewrite.jsp -->
<!-- 스마트 에디터 넣기 !! -->	
	
	<div class="container-fluid text-center">	
	<form name="frm" id="frm" method="post" action="qnaupdateProc.do">
	
		<div class="container text-center">
		<input name="qna_title" id="qna_title" type="text" class="form-control" size="20" value="${dto.qna_title}" required>
		<input name="qna_content" id="qna_content" type="text" class="form-control" size="20" value="${dto.qna_content}" required>	
		<input name="qna_pw" id="qna_pw" type="password" class="form-control" size="20" required>
		<input type="hidden" id="qna_num" name="qna_num" value="${dto.qna_num}">
		
		<input type="submit" value="입력"  class="btn btn-success">
		<input type="reset"  value="취소"  class="btn btn-danger">
		</div>
	</form>
	</div>




<!-- 본문끝 -->

<%@ include file="../footer.jsp"%>