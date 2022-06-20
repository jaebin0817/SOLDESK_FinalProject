<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 본문시작 memberIns.jsp -->
	
	<!-- 파티원 정보 입력 -->
	
	<div class="container-fluid text-center">	
		<div class="container text-center">
			${dto.n_num}	
			${dto.n_title}
			${dto.n_date}
			${dto.n_content} 
			${dto.n_readcnt}
			${msg}
		</div>
	</div>




<!-- 본문끝 -->

<%@ include file="../footer.jsp"%>