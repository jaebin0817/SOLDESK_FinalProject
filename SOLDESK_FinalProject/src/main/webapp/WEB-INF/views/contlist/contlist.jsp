<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 contlist.jsp -->

	<div id="cont_list" class="container-fluid text-center">
		<h3>↓ 원하는 영화나 드라마를 마음껏! ↓</h3>
		<br>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href="contlist_1.do"><img src="/images/movie_witcher.jpg" alt="movie"
					width="50"></a>
				<div class="title">마녀</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href="contlist_2.do"><img src="/images/movie_school.jpg" alt="movie"
					width="50"></a>
				<div class="title">지금 우리 학교는</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">
							★★★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_simpan.jpg" alt="movie"
					width="50"></a>
				<div class="title">소년심판</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_spy.jpg" alt="movie"
					width="50"></a>
				<div class="title">스파이 패밀리</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">
							★★★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_sweethome.jpg" alt="movie"
					width="50"></a>
				<div class="title">스위트 홈</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">
							★★★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_sool.jfif" alt="movie"
					width="50"></a>
				<div class="title">술꾼 도시 여자들</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">★★★★
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_jotjot.jpg" alt="movie"
					width="50"></a>
				<div class="title">좋좋소 시즌 5</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">
							★★★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_kimyohan.jpeg" alt="movie"
					width="50"></a>
				<div class="title">기묘한 이야기 시즌 4</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_topGun.jpg" alt="movie"
					width="50"></a>
				<div class="title">탑 건</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_my.jpg" alt="movie"
					width="50"></a>
				<div class="title">나의 해방일지</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">
							★★★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_ourblues.jpg" alt="movie"
					width="50"></a>
				<div class="title">우리들의 블루스</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">
							★★★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_cleaningup.jpeg" alt="movie"
					width="50"></a>
				<div class="title">클리닝 업!</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">★★★</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_broker.jpeg" alt="movie"
					width="50"></a>
				<div class="title">브로커</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">★★★★
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-3">
			<div class="thumbnail">
				<a href=""><img src="/images/movie_madongseok.jpg" alt="movie"
					width="50"></a>
				<div class="title">범죄도시2</div>
				<div class="rating">
					<div class="light-wrap">
						<div data-v-5281ecd8 class="light-percent light-green">
							★★★★★</div>
					</div>
				</div>
			</div>
		</div>

		<!-- ------------------------------------------------------------------------------------------------------->

	</div>


	<!-- 본문 끝 -->
	
<%@ include file="../footer.jsp"%>	