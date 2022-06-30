var xhr;
var checkFirst = loopSend = false;
var lastKeyword = "";
var keyword="";

function search(val){
    if(checkFirst == false){
        //alert(val);
     	$('#suggest').empty();
        keyword=val;
        setTimeout("sendKeyword()", 1000);          
        loopSend = true;
    }
}


function sendKeyword(){
    if(loopSend == false) return;
	 	//alert(keyword);	 
	if(keyword !== ""){
              
	    $.ajax({
            url:"moviesuggest.do",
            type:"post",
        	data : {
				keyword : keyword,			
        	},		
            success:function(data){//success callback함수
 				
 				$.each(data,function(index, value) {
 					
 					var mtitle=value.mtitle;
 					
 					//alert(value);
 					//alert(index);
 					//alert(value.mtitle);
 					//alert(value.mcode);
 					//$('#suggestList').append(value.mtitle);
 					//$('#suggest').append('<input type="button" value="'+value.mtitle+'" class="searchedcont">');
 					//$('#suggest').append('<span>'+value.mcode+'</span>');
 					$('#suggest').append('<a href="javascript:select('+mtitle+');">'+value.mtitle+'</a>');
 					
 				})
 				
            },
            error:function(error){
				alert("에러: " + error);
			}
   		});//ajax() end             				

	}
}


function select(reData){
     frm.mcode1.value = reData;
     loopSend = checkFirst = false;
     $('#suggest').empty();
}

