<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 메인카테고리 끝 -->


	<div class="pagetitle">
		<br>
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 리뷰 더보기 </strong></span>
		<br><br>
	</div>

<div id="reviews">
<c:set var="mcode" value="${ dto.mcode }"></c:set>
   <!-- 리뷰 및 수정 삭제 버튼 -->
   <c:forEach var="dto" items="${ list }">
      <p>ID : ${dto.mem_id}</p>
      <p>후기 제목 : ${dto.rev_title}</p>
      <p>등록 날짜 : ${dto.rev_reg}</p>
      <hr>
      <p>한줄평 : ${dto.rev_cont}</p>
      <p>개인 평점 : ${dto.rev_rate}</p>
      <p>스포 여부 : ${dto.rev_spo }</p>
         <form method="post"
         action="<%=request.getContextPath()%>/reviewupdate.do?mcode=${ mcode }&rev_code=${dto.rev_code } "
         method="POST">
         <input type="hidden" id="rev_code" name="rev_code" value="${dto.rev_code}">
         <input type="submit" value="update">
         </form>
   
         <form method="post"
         action="reviewdelete.do?mcode=${mcode}&rev_code=${dto.rev_code } "
         method="POST">
         <input type="hidden" id="rev_code" name="rev_code" value="${dto.rev_code}">
         <input type="submit" value="delete">
         </form>
   </c:forEach>
</div>


<script>

var loading = false;    //중복실행여부 확인 변수
var page = 1;   //불러올 페이지

$(window).scroll(function(){  
    if($(document).height() <= $(window).scrollTop() + $(window).height()){    
       
       page++;               
       loadNext();  
    }
 });


/*nextpageload function*/
function loadNext()
{
        $.ajax({
                type:"post",
                url:"morereviews.do",
                data : {page : page, 
                         mcode :searchParam('mcode')
                        },
                //dataType : "text",
                success: function(data){
                    
                   $.each(data,function(index, value) {
                        $('#reviews').append("<p>ID : "+value.mem_id+"</p>");
                        $('#reviews').append("<p>후기 제목 : "+value.rev_title+"</p>");
                        $('#reviews').append("<p>등록 날짜 : "+value.rev_reg+"</p>");
                        $('#reviews').append("<hr>");
                        $('#reviews').append("<p>한줄평 : "+value.rev_cont+"</p>");
                        $('#reviews').append("<p>개인 평점 : "+value.rev_rate+"</p>");
                        $('#reviews').append("<p>스포 여부 : : "+value.rev_spo+"</p>");
                        
                   })
                   
                }
                ,error: function(error) 
                {
                    alert(error);
                }
            });
}


function searchParam(key) {
    return new URLSearchParams(location.search).get(key);
};
   

   
   </script>
   
   
   
   






<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>