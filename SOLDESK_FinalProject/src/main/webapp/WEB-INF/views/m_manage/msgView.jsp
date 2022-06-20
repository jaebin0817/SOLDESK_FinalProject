<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 msgView.jsp -->

  <div class="container-fluid text-center">
    <div class="title">알림</div>
    
    <div class="content">
    	<dl>
    		<dd>${ msg != null ? img : "" } ${ msg }</dd> <!-- requestScope생략 -->
    		<dd>${ s_mem_id }</dd>
    		<dd>${ s_mem_pw }</dd>
    		<dd>${ s_mem_lv }</dd>
    	</dl>

    </div>
    
  </div>  

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>