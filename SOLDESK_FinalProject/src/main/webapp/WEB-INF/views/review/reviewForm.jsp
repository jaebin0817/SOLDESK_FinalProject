<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 메인카테고리 끝 -->


<!-- 본문 시작 -->
<h1>이 작품, 어떠셨나요?</h1>
<br>
<br>


<div class="container-fluid text-center" style="display: inline-block;"
	align="left">
	<form name="frm" id="frm" method="post" action="contlistins.do">
		<input type="hidden" id="mcode" class="form-control" name="mcode" value="${ mcode }">

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
						<h4 align="left">언제 감상하셨나요?</h4> <input name="rev_reg"
						id="rev_reg" type="tel" class="form-control" 
						placeholder="입력형태: 20200701" required>
					</td>
				</tr>
				<tr>
					<td><input name="rev_title" id="rev_title" type="text"
						class="form-control" placeholder="제목을 써주세요"
						size="20" placeholder="후기제목" required></td>
				</tr>
				<tr>
					<td><textarea
							placeholder="작품에 대한 감상을 짧게 남겨주세요. 작성한 글이 제목으로 보여집니다."
							class="primary-dark-input contents"
							style="padding: 50px 100px 100px;" id="rev_cont" name="rev_cont"
							required></textarea></td>
				</tr>
				<tr>
					<td>
						<span class="rev_spo_check">내용에 스포일러가 포함 돼있습니까? </span>
						<input name="rev_spo" id="rev_spo" type="checkbox" value="O">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="입력" class="btn btn-success">
						<input type="reset" value="취소" class="btn btn-cancel">
					</td>
				</tr>
			</table>

	</form>


</div>


<script>
	function IDlog(mem_lv) {

		if (mem_lv == null || mem_lv == "F") {
			alert("로그인 후 작성가능합니다")
			return false;
		}
		return true;
	}//IDlog() end
</script>





<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>