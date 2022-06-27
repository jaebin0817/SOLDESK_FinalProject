var mem_id = $(document).attr('mem_id');
var url_href = window.location.href;
var url = new URL(url_href);
var isRun = false;
var pointcnt = 0, likecnt = 0, watchcnt=0;	
var mcode = url.searchParams.get("mcode");

function likeCheck(){
	$("#likeBtn").click(function(){
		if( isRun ){
			alert("처리중");
			return;
		}
		isRun = true;
		
		$.ajax({
			url : "content_crilike.do",
			type : "post",
			data : { 
				mcode : mcode, 
			    mem_id : mem_id
			       },
			datatype : "json",
			contentType: 'application/x-www-form-urlencoded; charset=utf-8',
			success: function (result){
				if(likecnt == 0){
					likecnt += 1;
					alert("좋아요가 추가 되었습니다." + result);
				}else {
					likecnt -= 1;
					alert("좋아요가 취소 되었습니다." + result)
				}
				setTimeout(function(){ isRun = false; }, 10000);
			},
			error : function(error){
				alert("실패하였습니다."+error);
				setTimeout(function(){ isRun = false; }, 10000);
			}
			
		});
	});	
}

function watchCheck(){
	$("#watchBtn").click(function(){
		if( isRun ){
			alert("처리중");
			return;
		}
		isRun = true;
		
		$.ajax({
			url : "content_criwatch.do",
			type : "post",
			data : { 
				mcode : mcode, 
			    mem_id : mem_id
			       },
			datatype : "json",
			contentType: 'application/x-www-form-urlencoded; charset=utf-8',
			success: function (result){
				if(watchcnt == 0){
					watchcnt += 1;
					alert("이 컨텐츠를 보았습니다. " + result);
				}else {
					watchcnt -= 1;
					alert("이 컨텐츠를 보질 않았습니다." + result)
				}
		
				setTimeout(function(){ isRun = false; }, 10000);
			},
			error : function(error){
				alert("실패하였습니다." + error);
				setTimeout(function(){ isRun = false; }, 10000);
			}
			
		});
	});	
}

function pointCheck(){
	$("#pointBtn").click(function(){
		if( isRun ){
			alert("처리중");
			return;
		}
		isRun = true;
		
		$.ajax({
			url : "content_cripoint.do",
			type : "post",
			data : { 
				mcode : mcode, 
			    mem_id : mem_id
			       },
			datatype : "json",
			contentType: 'application/x-www-form-urlencoded; charset=utf-8',
			success: function (result){
				if(pointcnt == 0){
					pointcnt += 1;
					alert("찜 했습니다." + result);
				}else {
					pointcnt -= 1;
					alert("찜하기를 취소하였습니다." + result)
				}
				setTimeout(function(){ isRun = false; }, 10000);
			},
			error : function(error){
				alert("실패하였습니다."+error);
				setTimeout(function(){ isRun = false; }, 10000);
			}
			
		});
	});	
}