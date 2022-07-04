<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 qnaform.jsp -->
<!-- 스마트 에디터 넣기 !! -->	
	
	<div class="container-fluid text-center">	
	<div class="pagetitle">
		<br>
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 문의사항 등록 </strong></span>
		<br><br>
	</div>
	<form name="frm" id="frm" method="post" action="qnaProc.do" autocomplete="off">
		<input name="qna_pw" id="qna_pw" type="hidden" value=${mem_pw }>
		<div class="container text-center">
			<input name="qna_title" id="qna_title" type="text" class="form-control" size="20" placeholder="문의 제목을 적어주세요" required>
			<textarea class="form-control" style="resize: none;" rows="5" name="qna_content" id="qna_content" placeholder="문의사항을 적어주세요"  required></textarea>
		</div>
		<input type="submit" value="입력"  class="btn btn-success">
		<input type="reset"  value="취소"  class="btn btn-danger">
	</form>
	</div>




<!-- 본문끝 -->

<%@ include file="../footer.jsp"%>