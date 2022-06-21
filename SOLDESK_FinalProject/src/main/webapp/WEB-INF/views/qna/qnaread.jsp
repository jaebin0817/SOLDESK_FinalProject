<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 noticeread.jsp -->
	
	
	<div class="container-fluid text-center">	
		<div class="container text-center">	
		<table class="table">
		<tr>
			<th>글번호</th>
			<td>${dto.qna_num}</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td>${dto.qna_title}</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${dto.qna_date}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.qna_content}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.mem_id}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${dto.qna_readcnt}</td>
		</tr>
		</table>
		</div>
	</div>
		<form name="frm" id="frm" action="qnaForm.do" method="post" action="qnaForm.do" onsubmit="return IDlog(${mem_id},${dto.mem_id})">
            <input type="submit" value="문의사항삭제"  class="btn btn-success">
        </form>	
	<script>
	function IDlog(s_mem_id, mem_id) {

		if(mem_id!=s_mem_id){
			alert("본인만 수정 가능합니다")
			return false;
		}
		return true;
	}//IDlog() end

	</script>
		
	




<!-- 본문끝 -->

<%@ include file="../footer.jsp"%>