<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>        
    
<%@ include file="../../header.jsp"%>

<!-- 본문시작 addcontent.jsp -->

<div class="container text-center">
<form name="contfrm" id="contfrm" method="post" action="contins.do" enctype="multipart/form-data" onsubmit="">
	<table class="table">
	<tr>
	    <th>영화제목</th>
	    <td colspan="4"><input type="text" name="mtitle" id="mtitle" class="form-control" size="20" maxlength="20" required autofocus></td>
	</tr>
	<tr>
		<th>서비스 중인 OTT</th>
	    <th>
	    	<label><input type="checkbox" name="netflix" id="netflix" value="O"> 넷플릭스 &nbsp;</label>
	    	<label><input type="checkbox" name="watcha" id="watcha" value="O"> 왓챠 &nbsp;</label>	
	    	<label><input type="checkbox" name="tving" id="tving" value="O"> 티빙 &nbsp;</label>
	    	<label><input type="checkbox" name="diseny" id="diseny" value="O"> 디즈니 &nbsp;</label>
	    </th>
	    
	    <th></th>
	    <th></th>
	    <th></th>
	</tr>
	<tr>
	    <th>개봉년도</th>
	    <td colspan="4">
	      <select name="mdate" id="mdate" class="form-control">
	      </select>
	    </td>
	</tr>
	<tr>
	    <th rowspan="2">키워드코드</th>
	    <td colspan="4">
	    	<c:forEach var="dto" items="${ list }" begin="0" end="${ fn:length(list) }">
	    	<label><input type="checkbox" class="key_word" name="key_word" id="key_word" value="${ dto.key_code }"> ${ dto.key_name } &nbsp;</label>
	    	</c:forEach>
	    </td>
	</tr>
	<tr>
	    <td colspan="4">
	    	<textarea class="form-control" name="key_code" id="key_code"></textarea>
	    </td>
	</tr>
	<tr>
	    <th>영화포스터</th>
	    <td colspan="4">
	    	<input type="file" name="mthumMF" id="mthumMF" class="form-control">
	    </td>
	</tr>
	<tr>
	    <td colspan="5">
	    </td>
	</tr> 
	</table>
	<input type="submit" value="컨텐츠 등록" class="btn">
	<input type="reset"  value="취소"       class="btn"><br><br>

</form>
</div>

    <script>
    
    	createYear();
    	
        function createYear(){

            var cYear=moment().year();  //현재년도 2022
            for(y=cYear; y>=cYear-70; y--){
                //3) 현재년도를 미리 selected
                if(cYear==y){
                    $("<option>").text(y).attr("selected", "selected").appendTo("#mdate");
                }else{
                    $("<option>").text(y).appendTo("#mdate");
                }//if end
            }//for end

        }//createYear() end

        
        $(".key_word").change(function(){
        	
        	var key_code=$(this).attr("value")+" || ";
        	
            if($(this).is(":checked")){
                //alert("체크박스 체크");
                //alert(key_code);
                $("#key_code").append(key_code); 
            	
            }else{
                //alert("체크박스 체크해제");
                //alert(key_code);
                $("#key_code").empty();
                $(".key_word").prop("checked", false);
            }
        });
     
    </script>

<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>