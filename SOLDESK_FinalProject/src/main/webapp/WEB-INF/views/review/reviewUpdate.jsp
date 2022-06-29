<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 -->
<h1>이 작품, 어떠셨나요?</h1>
<br>
<br>

<div class="container-fluid text-center" style="display: inline-block;"
	align="left">
	<form name="frm" id="frm" method="post" action="<%=request.getContextPath()%>/reviewupdateproc.do">
		<input type="hidden" id="mcode" class="form-control" name="mcode" value="${ dto2.mcode }">
		<input type="hidden" id="rev_code" class="form-control" name="rev_code" value="${ dto2.rev_code }">

			<table class="table">
				<tr>
					<td>
						<div>
							<div>
								<strong>평점</strong>
							</div>
							<input type="radio" id="rev_rate" name="rev_rate" value="1"
								checked="checked">1점<br> <input type="radio"
								id="rev_rate" name="rev_rate" value="2">2점<br> <input
								type="radio" id="rev_rate" name="rev_rate" value="3">3점<br>
							<input type="radio" id="rev_rate" name="rev_rate" value="4">4점<br>
							<input type="radio" id="rev_rate" name="rev_rate" value="5">5점<br>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<h4 align="left">언제 감상하셨나요?</h4> 
						<input name="rev_reg" value="${ dto2.rev_reg }"
						id="rev_reg" type="tel" class="form-control" 
						placeholder="입력형태: 20200701" required>
					</td>
				</tr>
				<tr>
					<td>
						<input name="rev_title" id="rev_title" type="text"
						class="form-control" placeholder="제목을 써주세요" value="${dto2.rev_title }"
						size="20" placeholder="후기제목" required>
					</td>
				</tr>
				<tr>
					<td><textarea
							placeholder="작품에 대한 감상을 짧게 남겨주세요. 작성한 글이 제목으로 보여집니다."
							class="primary-dark-input contents"
							style="padding: 50px 100px 100px;" id="rev_cont" name="rev_cont"
							required>${dto2.rev_cont }</textarea></td>
				</tr>
				<tr>
					<td>
						<span class="rev_spo_check">내용에 스포일러가 포함 돼있습니까? </span>
						<input name="rev_spo" id="rev_spo" type="checkbox" value="O">
					</td>
				</tr>
				<tr>
					<td>
					<input type="submit" value="수정 완료"  class="btn btn-success" >
					<input type="button"  value="수정 취소"  class="btn btn-cancel"   onclick="history.back()">
					</td>
				</tr>
			</table>

	</form>


</div>	



	<script>
	function IDlog(mem_lv) {
		if(mem_id == s_mem_id){
			alert("수정했습니다.")
			return true;
		} (mem_id != s_mem_id)
		alert("다른 사람의 리뷰는 수정 할 수 없습니다.")
		return false;
	}//IDlog() end
	</script>


<!-- 본문끝 -->

<%@ include file="../footer.jsp"%>