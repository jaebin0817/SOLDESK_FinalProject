var mem_id = $(document).attr('mem_id');
var url_href = window.location.href;
var url = new URL(url_href);
var isRun = false;	
var mcode = url.searchParams.get("mcode");
var form = { mcode : mcode, mem_id : mem_id };

function reloadDivArea(){
	location.reload();
}

function likeCheck(){

	$(document).off('click').on('click', '#likeBtn',function(){

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
				if(result.like_check == 1){
					alert("좋아요" + result.like_check);
					result.like_check = 0; 
				}else {
					alert("좋아요 취소" + result.like_check);
					result.like_check = 1;
				}
				
				reloadDivArea();
			},
			error : function(error){
				isRun = false;
				alert("실패"+error);
				
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
		var watchcnt = $('#watchcheck').val();
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
					alert("봤어요" + watchcnt + result);
				}else {
					watchcnt -= 1;
					alert("봤어요 취소" + watchcnt + result)
				}
				reloadDivArea();
				
				
			},
			error : function(error){
				isRun = false;
				alert("실패" + error);
				
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
ehch
		$.ajax({ 
			url : "/content_cripoint.do",
			type : "POST",
			data : form,
			datatype : "JSON",
			contentType: 'application/x-www-form-urlencoded; charset=utf-8',
			success: function (result){
				isRun = false;
				
				reloadDivArea();
			},
			error : function(error){
				isRun = false;
				alert("실패하였습니다."+error);
				
			}
			
		});
	});	
}