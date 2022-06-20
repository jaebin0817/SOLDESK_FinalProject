<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 memberIns.jsp -->
	
	<!-- 파티원 정보 입력 -->
	
	<div class="container-fluid text-center">	
	<form name="frm" id="frm" method="post" action="noticeupdateproc.do?n_num=${n_num}">
	<input type="hidden" id="n_num" name="n_num" value="${n_num}">	
		<div class="container text-center">
		<input name="n_title" id="n_title" type="text" class="form-control" size="20" value=${dto.n_title } required>
		<input name="n_content" id="n_content" type="text" class="form-control" size="20" value=${dto.n_content } required>	
		<input type="submit" value="입력"  class="btn btn-success">
		<input type="reset"  value="취소"  class="btn btn-danger">
		</div>
	</form>
	</div>




<!-- 본문끝 -->

<%@ include file="../footer.jsp"%>