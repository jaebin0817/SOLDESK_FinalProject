$(document).ajaxStart(function(e) {
	window.ajaxCheck = 1;								
});					
$(document).ajaxStop(function(e) { 								
	window.ajaxCheck = null; 								
});

var form = { 
				mcode : mcode, 
			    mem_id : mem_id 
		}

function likeCheck(){
	$(document).off('click').on('click', '#likeBtn',function(){
		var form = { 
				mcode : mcode, 
			    mem_id : mem_id 
		} 
		if( isRun ){
			alert("처리중");
			return;
		}
		isRun = true;
		$.ajax({ 
			url : "/content_crilike.do",
			type : "POST",
			data : form,
			datatype : "JSON",
			contentType: 'application/x-www-form-urlencoded; charset=utf-8',
			success: function (result){
				isRun = false;
				if(likecnt == 0){
					likecnt += 1;
					alert("좋아요가 추가 되었습니다." + result);
				}else {
					likecnt -= 1;
					alert("좋아요가 취소 되었습니다." + result)
				}
			},
			error : function(error){
				isRun = false;
				alert("실패하였습니다."+error);
				
			}
			
		});
	});	
}

function watchCheck(){
	$(document).off('click').on('click', '#watchBtn',function(){
		if( isRun ){
			alert("처리중");
			return;
		}
		isRun = true;
		
		$.ajax({
			url : "/content_criwatch.do",
			type : "post",
			data : form,
			datatype : "json",
			contentType: 'application/x-www-form-urlencoded; charset=utf-8',
			success: function (result){
				isRun = false;
				if(watchcnt == 0){
					watchcnt += 1;
					alert("이 컨텐츠를 보았습니다. " + result);
				}else {
					watchcnt -= 1;
					alert("이 컨텐츠를 보질 않았습니다." + result)
				}
				
				
			},
			error : function(error){
				isRun = false;
				alert("실패하였습니다." + error);
				
			}
			
		});
	});	
}

function pointCheck(){
	$(document).off('click').on('click', '#pointBtn',function(){
		if( isRun ){
			alert("처리중");
			return;
		}
		isRun = true;
		$.ajax({ 
			url : "/content_cripoint.do",
			type : "POST",
			data : form,
			datatype : "JSON",
			contentType: 'application/x-www-form-urlencoded; charset=utf-8',
			success: function (result){
				isRun = false;
				if(pointcnt == 0){
					pointcnt += 1;
					alert("찜 하였습니다." + result);
				}else {
					pointcnt -= 1;
					alert("찜하지 않았습니다." + result)
				}
			},
			error : function(error){
				isRun = false;
				alert("실패하였습니다."+error);
				
			}
			
		});
	});	
}