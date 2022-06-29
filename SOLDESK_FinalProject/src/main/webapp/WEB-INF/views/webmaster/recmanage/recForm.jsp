<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

<%@ include file="../../header.jsp"%>

<script src="../ckeditor/ckeditor.js"></script>
<script>CKEDITOR.replace( 'ckeditor', {});</script>
<script> 

	ClassicEditor 
		.create( document.querySelector( '#content' ),{
			language: 'ko',
			removePlugins: [ 'ImageUpload' ]
		} )
		.then( newEditor => {
	    	editor = newEditor;
		} )
		.catch( error => { console.error( error ); } 
		); 

</script>
<!-- 본문시작 recForm.jsp -->
	
	
<!-- 관리자페이지 : 추천 리스트 작성페이지 -->
	
<div class="container text-center">	
	
	
	<div class="pagetitle">
		<br>
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 추천리스트 작성 </strong></span>
		<br><br>
	</div>
	
	<button class="btn btn-danger" onclick="location.href='<%=request.getContextPath()%>/reclist.do'">글목록</button><br><br>

	<div id="recfrmarea">
	
		<form name="recfrm" id="recfrm" method="post" action="recins.do" onsubmit="return recCheck()"> <!-- myscript.js에 함수 작성함 -->
		<table class="table" style="margin:auto;">
		<tr>
		   <th>제목</th>
		   <td><input type="text" name="subject" id="subject" class="form-control" maxlength="100" required></td>
		</tr>
		<tr><td colspan="2"></td></tr>
		</table> 
		
		<textarea name="content" id="content"></textarea>
		
		<br>
		<div id="btnArea">
			<input id="bbsBtn" type="submit" value="쓰기" class="btn">
		    <input id="bbsBtn" type="reset"  value="취소" class="btn">
		</div>
		</form>
		
	</div>	



	


</div>

<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>