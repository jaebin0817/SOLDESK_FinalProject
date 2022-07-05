<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

<%@ include file="../../header.jsp"%>
<!-- 본문시작 likecontent.jsp -->

<!-- 내가 좋아요한 목록 -->	
  <div class="container-fluid text-center">	
 	 <span><strong>좋아요한 작품들</strong></span>	
 	 
 	 <table id="like_table" name="like_table">
		<c:forEach var="dto" items="${like_list}">
		<tr>
			<td>
				<a href="contlist/contlistread.do?mcode=${ dto.mcode }" >
					<img src="../../../storage/${dto.mthum}" alt="movie" width="200px"/>
				</a>
			</td>
			<td>
				<strong>${ dto.mtitle }</strong>
			</td>
			<td>
				<c:if test="${ dto.netflix eq 'O' }" >
							<img src="../../images/icon_netflix.png" width="30px" />
				</c:if>
				
				<c:if test="${ dto.watcha eq 'O' }" >
					<img src="../../images/icon_watcha.png" width="30px" />
				</c:if>
				<c:if test="${ dto.tving eq 'O' }" >
					<img src="../../images/icon_tving.png" width="30px" />
				</c:if>
				<c:if test="${ dto.disney eq 'O' }" >
					<img src="../../images/icon_disney.png" width="30px" />
				</c:if>
			</td>
		</tr>	
		<tr>
			<td>
				<span class="text-date"> ${ dto.mdate }</span>
			</td>
		</tr>
		<tr>
			<td>
				${ dto.mrate }
			</td>
		</tr>
		</c:forEach>
    </table>
  </div>
<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>
