<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>

<!-- 아이디/ 비밀번호 찾기 창 -->

	<div class="container" align="center">
		<form name= "infofind" id= "infofind" method="post" >
			<h3> 아이디/ 비밀번호 찾기</h3>
			<table>
				<tr> 
					<td>
						<a href='findidscr.do'>[아이디 찾기]</a>
						<a href='findpwscr.do'>[비밀번호 찾기]</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="../footer.jsp" %>