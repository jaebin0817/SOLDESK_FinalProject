<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>contlist.jsp</title>
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

</head>

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
					<li><a href="/contlist/contlist.do">컨텐츠</a>
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
