<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 


	<!-- Footer -->
	<footer >

	  <div class="container-fluid bg-3 text-center">
	    <a href="<%=request.getContextPath()%>/notice/notice.do">공지사항</a> &nbsp;&nbsp;
	    <a href="">문의사항</a>
	    <!-- 회원등급 A(webmaster)일때만 접근 허용 -->
	    <c:if test="${ s_mem_lv=='A' }">
	      <br><a href="<%=request.getContextPath()%>/webmaster/webmaster.do">관리자페이지</a>
	    </c:if>
	  </div>
	  
	  <div class="container-fluid bg-4 text-center">
	  	  <a href="<%=request.getContextPath()%>/home.do">
	          <img src="/images/logo_white_grey.png" alt="HOME" width="100px">
	      </a>
		  <p>Copyright &copy; OPOT</p> 
		  <p>SOLDESK 1조</p>
		  <p>조원들 Contact Info</p>
	  </div>
	  

	</footer>


</body>
</html>
