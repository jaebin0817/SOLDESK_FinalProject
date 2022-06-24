<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

</div>
	<!-- Footer -->
	<footer >

	  <div class="container-fluid bg-3 text-center">
	    <a href="<%=request.getContextPath()%>/notice/notice.do">공지사항</a> &nbsp;&nbsp;
	    <a href="">문의사항</a>
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
