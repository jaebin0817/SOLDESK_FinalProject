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
<div id="review_insert" class="container-fluid text-center">
	<button class="btn_previous">
		<a
			href="<%=request.getContextPath()%>/contlist/contlistread.do?mcode=${ dto2.mcode }">
			<img src="../../storage/previous_button.png" alt="back" width="30px">
		</a>
	</button>


	<!--   썸네일이랑 제목, 키워드 넣을거임. 키노라이츠 리뷰 작성처럼. 
	<div class="poster">
		<img src="../../storage/${dto.mthum}" alt="movie" width="200px">
	</div>
	<div>
		<h4>${dto.mtitle}</h4>
	</div>
	
	<div class="key_code">
		<c:forEach items="${keylist}" var="list">
			<a href="search.do?key_name=${list}"> <c:forEach items="${list}"
					var="map">
	   			${map}
	   		</c:forEach>
			</a>
		</c:forEach>
	</div>
	 -->

	<form >
		<section class="section-area" style="padding: 0 16px 16px;">
			<div class="input-wrap">
				<h5 class="section-title">언제 감상하셨나요?</h5>
				<div class="date-wrap">
					<input type="tel" placeholder="입력형태: 20200701" value="2022.06.23"
						class="primary-dark-input">
				</div>
			</div>
		</section>

		<section class="section-area" style="padding: 0 50px 50px;">
			<h5 class="section-title" style="width: 70%; display: inline-block;">간단히
				기록하기</h5>
			<div class="input-wrap">
				<div class="date-wrap">
					<textarea placeholder="작품에 대한 감상을 짧게 남겨주세요. 작성한 글이 제목으로 보여집니다."
						class="primary-dark-input contents" style="width: 70%;"></textarea>
				</div>
			</div>

			<div class="checkbox-wrap">
				<span class="checkbox-item"><span
					class="dark-default-check-wrap"> <input type="checkbox"
						id="check-spoiler" class="filter-checkbox"><label
						for="check-spoiler" class="checker"></label></span> <span
					class="checkbox-text"><label for="check-spoiler">스포일러
							포함</label></span></span>
			</div>
		</section>
		<footer class="rating-action-bar">
			<button class="primary-btn" onclick="location.href='<%=request.getContextPath()%>/contlist/contlistread.do?mcode=${ dto2.mcode }'">
				완료
			</button>

		</footer>
	</form>
</div>


