<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

	<!-- 메인카테고리 끝 -->

	<!-- 본문 시작 -->
<div id="cont_list" class="container-fluid text-center">

	<div class="pagetitle">
		<br>
		<span><strong> 👀 컨텐츠들을 구경해보세요! 👀 </strong></span>
		<h5>${ msg }</h5>
		<br>
	</div>
	
	
		<div class="ott_search">
			
			<button class="ott_search_btn" id="netflix_btn" name="netflix_btn" value="netflix"><img src="../../images/icon_netflix_search.png"></button>
			<button class="ott_search_btn" id="tving_btn" name="tving_btn" value="tving"><img src="../../images/icon_tving_search.png"></button>
			<button class="ott_search_btn" id="watcha_btn" name="watcha_btn" value="watcha"><img src="../../images/icon_watcha_search.png"></button>
			<button class="ott_search_btn" id="disney_btn" name="disney_btn" value="disney"><img src="../../images/icon_disney_search.png"></button>
			<p id="panel"></p>
		</div>
		
		<div class="contents">
			<c:set var="no" value="1"></c:set>
			<c:forEach var="dto" items="${list}">
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="thumb" id="content${ no }">
					  
						<a href="<%=request.getContextPath()%>/contlist/contlistread.do?mcode=${ dto.mcode }">
							<img src="../../storage/${dto.mthum}" alt="movie"
							width="300px">
						</a>
						<div class="mtitle"><strong>${dto.mtitle}</strong></div>
						<div class='stars'>
				        	<c:forEach begin="1" end="${ dto.mrate }">★</c:forEach><c:forEach begin="${ dto.mrate+1 }" end="5">☆</c:forEach>
				        	${ dto.mrate }
				        </div>
						
					
						<c:if test="${dto.netflix eq 'O' }" >
							<img src="../../images/icon_netflix.png" width="50px">
						</c:if>
						<c:if test="${dto.tving eq 'O'  }" >
							<img src="../../images/icon_tving.png" width="50px">
						</c:if>
						<c:if test="${dto.watcha eq 'O'  }" >
							<img src="../../images/icon_watcha.png" width="50px">
						</c:if>
						<c:if test="${dto.disney eq 'O'  }" >
							<img src="../../images/icon_disney.png" width="50px">
						</c:if>
					</div>
				</div>
				<span class="hide">${ no=no+1 }</span>
 			</c:forEach>
		
		</div>	
		
    
</div>

	<script>	
	
	$(".ott_search_btn").click(function(){
			
		//alert($(this).val());				
		
	    $.ajax({
            url:"ottsearch.do",  //요청명령어 
            type:"get",        //get방식
        	data : {
				ott : $(this).val(),
        	},		
            success:function(data){//success callback함수
                
                $(".thumb").empty();
   			    var no=0;
            	$.each(data,function(index, value) { // 값이 여러개 일 때는 반복문 사용
	      			
	      			var stars="";
	                for(i=1; i<=value.mrate; i++){ stars+="★"; }
	                for(i=value.mrate+1; i<=5; i++){ stars+="☆"; }
            		
            		mimg=$('<img>', {
            			'src' : '../../storage/'+value.mthum,
            			'width' : '300px',
            			'id' : value.mcode
            		});
            	
            		netfliximg=$('<img>', {
            			'src' : '../../images/icon_netflix.png',
            			'width' : '50px',
            		});
            		
            		tvingimg=$('<img>', {
            			'src' : '../../images/icon_tving.png',
            			'width' : '50px',
            		});
            		
            		watchaimg=$('<img>', {
            			'src' : '../../images/icon_watcha.png',
            			'width' : '50px',
            		});
            		
            		disneyimg=$('<img>', {
            			'src' : '../../images/icon_disney.png',
            			'width' : '50px',
            		});

      			   	var identifier = ".thumb";
            		
          			//$(".thumb:eq("+i+")").append(mimg);
          			$(identifier).eq(no).append("<input type='image' id='"+value.mcode+"' name='"+value.mcode+"' src='../../storage/"+value.mthum+"' alt='movie' width='300px' onclick=''>");

	      			$(identifier).eq(no).append("<div class='mtitle'><strong>"+value.mtitle+"</strong></div>");
	      			$(identifier).eq(no).append("<div class='stars'>"+stars+value.mrate+"</div>");
	      			if(value.netflix=="O"){$(identifier).eq(no).append(netfliximg);}
	      			if(value.tving=="O"){$(identifier).eq(no).append(tvingimg);}
	      			if(value.watcha=="O"){$(identifier).eq(no).append(watchaimg);}
	      			if(value.disney=="O"){$(identifier).eq(no).append(disneyimg);}
					
	      			$("input[name="+value.mcode+"]").attr('onclick', 'location.href="<%=request.getContextPath()%>/contlist/contlistread.do?mcode='+value.mcode+'"');
	      			
					no++;
					//alert(no);
					
			
                 })
            },
            error:function(error){
				alert("에러: " + error);
			}
   		});//ajax() end
			
	});	
		
	</script>

	<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>