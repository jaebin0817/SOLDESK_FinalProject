<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>   
 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
       
<script type="text/javascript" src="../js/calendar.js"></script>
<script class="cssdesk" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.0/moment.min.js" type="text/javascript"></script>

	
    <div id='calendar'>
  		
    </div>
    <div id="term_start">
    	<c:forEach var="dto" items="${sublist}">
    	    ${dto.subscribe_start}
    	    ${dto.subscribe_end }
    	</c:forEach>
    </div>  

<%@ include file="../footer.jsp"%>