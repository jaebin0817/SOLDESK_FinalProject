<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>contlist_1.jsp</title>
<meta charset="utf-8">
<link rel="stylesheet" href="/css/layout.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>








<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">


	<!------ 메인카테고리 시작 -------------------------------------------------->
	<nav class="navbar navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="<%=request.getContextPath()%>"> <img
					src="/images/logo.png" alt="HOME" width="180px">
				</a>
			</div>

			<div>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="">컨텐츠</a>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="">탐색</a></li>
							<li><a href="">신작</a></li>
							<li><a href="">추천</a></li>
						</ul></li>

					<li><a href="">파티매칭</a></li>
					<li><a href="m_manage/mypage.do">마이페이지</a></li>
				</ul>
			</div>

		</div>
	</nav>

	<!-- 메인카테고리 끝 -->

	<!-- 본문 시작 -->
	<div class="movie-info-container">
		<div class="rating-help-contents-wrap"
			style="display: none; top: 289.375px;">
			<div class="arrow-wrap">
				<div class="help-contents">
					<span style="font-weight: 500;">오팟 평점지수</span><span
						style="display: block; margin-top: 3px;"> 오팟에서는 신호등의 색으로
						작품에 대한 자신의 취향을 평가할 수 있습니다. 오팟 지수는 영화나 TV시리즈에 초록색 신호등 평가를 한 유저의 비율을
						나타냅니다. <a href="/support/faq"
						style="text-decoration: underline; display: inline-block;">자세히
							알아보기</a>
					</span>
				</div>
			</div>
			<div class="rotten-help-contents-wrap"
				style="display: none; top: 319.275px;">
				<div class="arrow-wrap">
					<div class="rotten-arrow-up" style="left: 20px;"></div>
				</div>
			</div>
			<div class="imdb-help-contents-wrap"
				style="display: none; top: 319.275px;">
				<div class="arrow-wrap">
					<div class="imdb-arrow-up" style="left: 84px;"></div>
				</div>
				<div class="help-contents">
					<span style="font-weight: 400;"> 별 점 : ★★★★</span>
				</div>
			</div>
			<h3 class="title-kr">마녀</h3>
			<h4 class="title-en">The Witch : Part 1. The Subversion</h4>

			<span class="metadata-item">액션 ·</span><span class="metadata-item">2018</span>

			<div class="movie-light-percent light-green">79.72%</div>
		</div>

		<div class="score">89% ·</div>
		<div class="score" style="margin-left: 3px;">7.2 ·</div>

		<div class="score">3.0</div>
	</div>
	<div class="poster">
		<img
			data-src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/movie_poster_images/280x400/movie_64758_1528162802.jpg"
			src="https://nujhrcqkiwag1408085.cdn.ntruss.com/static/upload/movie_poster_images/280x400/movie_64758_1528162802.jpg"
			lazy="loaded">
	</div>



	<hr class="new-divider">


	<!-- 본문 끝 -->

	<!-- Footer -->
	<footer>

		<div class="container-fluid bg-3 text-center">
			<a href="">공지사항</a> &nbsp;&nbsp; <a href="">문의사항</a>
		</div>

		<div class="container-fluid bg-4 text-center">
			<p>Copyright &copy; OPOT</p>
			<p>SOLDESK 1조</p>
			<p>조원들 Contact Info</p>
		</div>


	</footer>


</body>
</html>
