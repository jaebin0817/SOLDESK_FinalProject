<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

<%@ include file="../../header.jsp"%>

<!-- 본문시작 themeList.jsp -->
	
	
<!-- 관리자페이지 : 추천 테마 리스트 -->
	
  <div class="container-fluid text-center">	
	
	
	<div class="pagetitle">
		<br>
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 추천 테마 리스트 </strong></span>
		<br>
	</div>
	
	<input type="button" value="테마추가" onclick="location.href='/themeadd.do'" class="btn btn-danger"><br><br>
	<input type="button" value="추천글추가" onclick="location.href='/recadd.do'" class="btn btn-danger"><br><br>
	
		


  </div>	
	



<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>