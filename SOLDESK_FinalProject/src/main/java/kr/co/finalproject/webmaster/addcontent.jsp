<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>        
    
<%@ include file="../header.jsp"%>

<!-- 본문시작 addcontent.jsp -->

<div class="container">
<form name="contfrm" id="contfrm" method="post" action="contins.do" enctype="multipart/form-data" onsubmit="">
	<table class="table">
	<tr>
	    <th colspan="2">영화제목</th>
	    <td colspan="6"><input type="text" name="mtitle" id="mtitle" class="form-control" size="20" maxlength="20" required autofocus></td>
	</tr>
	<tr>
	    <th>넷플릭스</th>
	    <td><input type="checkbox" name="netflix" id="netflix" value="O"></td>
	    <th>왓챠</th>
	    <td><input type="checkbox" name="watcha" id="watcha" value="O"></td>
	    <th>티빙</th>
	    <td><input type="checkbox" name="tving" id="tving" value="O"></td>
	    <th>디즈니</th>
	    <td><input type="checkbox" name="diseny" id="diseny" value="O"></td>
	</tr>
	<tr>
	    <th colspan="2">개봉년도</th>
	    <td colspan="6"><input type="text" name="mdate" id="mdate" class="form-control" required></td>
	</tr>
	<tr>
	    <th colspan="2">키워드코드</th>
	    <td colspan="6">
	    	
	    	<input type="checkbox" name="key_code" id="key_code" class="form-control" value="${ dto.keycode }">
	    </td>
	</tr>
	<tr>
	    <td colspan="8">
	    	  <input type="submit" value="컨텐츠 등록" class="btn">
	    	  <input type="reset"  value="취소"       class="btn">
	    </td>
	</tr> 
	</table>
</form>
</div>

    <script>
    	createYear();
    	
        function createYearMonth(){

            var cYear=moment().year();  //현재년도 2022
            for(y=cYear-5; y<=cYear+5; y++){
                //3) 현재년도를 미리 selected
                if(cYear==y){
                    $("<option>").text(y).attr("selected", "selected").appendTo("#myYear");
                }else{
                    $("<option>").text(y).appendTo("#myYear");
                }//if end
            }//for end

            //4) '일' 생성하는 함수 호출
            createDate();

        }//createYearMonth() end

     
    </script>

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>