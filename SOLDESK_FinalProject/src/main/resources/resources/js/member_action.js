
var isRun = false;

function idCheck(){
	var mem_id=document.getElementById("mem_id").value;
	mem_id = mem_id.trim();
	
	if(mem_id.length < 3 || mem_id == ""){
		alert("아이디 3글자 이상 입력해 주세요");
		document.getElementById("mem_id").focus();
        return false; 
	} 
	
	$(document).on('click', '#idcheck', function(){
		let user_id = $("#mem_id").val(); 
		
		if( isRun ){
			alert("처리중");
			return;
		}
		isRun = true;
		
		$.ajax({
			url : "/IdCheck.do",
			type : "POST",
			data : { mem_id : user_id },
			datatype : "JSON",
			success : function(result){
				isRun = false;
				alert("성공하였습니다." + result);
				
				if(result == 0){
					$("#checkId").html("사용 가능한 아이디가 아닙니다.");
					$("#checkId").attr('color', 'red');
				} else {
					$("#checkId").html("사용 가능한 아이디 입니다.");
					$("#checkId").attr('color', 'blue');
				}
			}, 
			error : function(){
				isRun = false;
				alert("서버요청실패");
			} 
		});
	});

}

function emailCheck() {
   var mem_email=document.getElementById("mem_email").value; 
   mem_email=mem_email.trim();
   var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

   if(exptext.test(mem_email)==false){

   //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우         
   alert("이메일형식이 올바르지 않습니다.");
   document.getElementById("mem_email").focus();
       return false;
   }//if end
   
   $(document).on('click', '#emailcheck', function(){
	 	 let user_email = $("#mem_email").val(); 
         if( isRun ){
			alert("처리중");
			return;
		}
		isRun = true;
		
		$.ajax({
			url : "/EmailCheck.do",
			type : "POST",
			data : { mem_email : user_email },
			datatype : "JSON",
			success : function(result){
				isRun = false;
				if(result == 1){
					alert("사용 가능한 이메일 입니다.");
				} else {
					alert("중복된 이메일 입니다.");
				}
				
			}, 
			error : function(){
				isRun = false;
				alert("서버요청실패");
			} 
		});
	});

         
         return true;
}//emailCheck() end

function phoneCheck(){
	var mem_phone = document.getElementById("mem_phone").value;
	mem_phone = mem_phone.trim();
	var p_check = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	if(p_check == "" || p_check.test(mem_phone) == false){
		document.getElementById("mem_phone").focus();
		return false;
	} else {
		alert("해당 유형이 맞습니다.");
		return true;
	}
	
}


function birthCheck(){
		var mem_birth = document.getElementById("mem_birth").value;
		mem_birth = mem_birth.trim();
		var exp = /\d{2}([0]\d|[1][0-2])([0][1-9]|[1-2]\d|[3][0-1])[-]*[1-4]/;
		
		if(exp == "" || exp.test(mem_birth) == false){
			alert("생년웡일 형식이 잘못되었습니다.");
			document.getElementById("mem_birth").focus();
			return false;
		}else {
			alert("해당 유형이 맞습니다. ");
			return true;
		}
		
}//birthCheck()

function pwCheck(){
	var mem_pw=document.getElementById('mem_pw').value;
	var re_pw = document.getElementById('re_pw').value;
	mem_pw=mem_pw.trim();	
	re_pw = re_pw.trim();
	
	if(mem_pw.length  < 4 || mem_pw == ""){
		alert("비밀번호를 4자리 이상 입력해주세요");
		document.getElementById("mem_pw").focus();
		return false;
	}
	
	if(re_pw != mem_pw){
		alert("비밀번호가 다릅니다");
		return false;
	}else {
		alert("비밀번호가 같습니다");
		return true;
	}
	
}

function findId(){
	var idphone= document.getElementById("idphone").value;
	var idemail =document.getElementById("idemail").value;
	idphone = idphone.trim();
	idemail = idemail.trim();
	var p_check = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	 
	if(idphone.length == "" || idemail.length == ""){
		alert("공간을 채워주시기 바랍니다.");
	}
	else {
		if(exptext.test(idemail) == false || p_check.test(idphone) == false){
			alert("올바르지 않은 양식입니다.");
		}
	}
}

function findPw(){
	var mem_id = document.getElementById("mem_id").value;
	var mem_phone= document.getElementById("mem_phone").value;
	var mem_email = documnet.getelementById("mem_email.").vula
	
	mem_id = mem_id.trim();
	mem_email=mem_email.trim();
	mem_phone = mem_phone.trim();
	
	var data = { mem_id: mem_id, mem_phone : mem_phone, mem_email : mem_email };
}

