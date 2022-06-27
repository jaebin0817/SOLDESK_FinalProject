function idCheck(){
	var mem_id=document.getElementById("mem_id").value;
	mem_id = mem_id.trim();
	
	if(mem_id.length < 3 || mem_id == ""){
		alert("아이디 3글자 이상 입력해 주세요");
		document.getElementById('mem_id').focus();
        return false; 
	} 
	
	$("#mem_id").focusout(function(){
		let user_id = $("#mem_id").val(); 
		
		$.ajax({
			url : "IdCheck.do",
			type : "post",
			data : {mem_id : user_id},
			datatype : "json",
			success : function(result){
				if(result == 0){
					$("#checkId").html("사용 가능한 아이디가 아닙니다.");
					$("#checkId").attr('color', 'red');
				} else {
					$("#checkId").html("사용 가능한 아이디 입니다.");
					$("#checkId").attr('color', 'blue');
				}
			}, 
			error : function(){
				alert("서버요청실패");
			} 
		})
	})
	
	
	return true;
}

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
	
	
}

function findPw(){
	
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
         return true;
}//emailCheck() end


function birthCheck(){
		var mem_birth = document.getElementById("mem_birth").value;
		mem_birth = mem_birth.trim();
		var exp = /d{2}([0]\d|[1][0-2])([0][1-9]|[1-2]\d|[3][0-1])[-]*[1-4]/;
		
		if(exp == "" || exp.test(mem_birth) == false){
			alert("생년웡일 형식이 잘못되었습니다.");
			document.getElementById("mem_birth").focus();
			return false;
		}
		return true;
}//birthCheck()