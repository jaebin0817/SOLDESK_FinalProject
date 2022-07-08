<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 agreement.jsp-->
<div class="container text-center">
	
	<div class="pagetitle">
		<br>
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 회원 가입 약관 </strong></span>
		<br><br>
	</div>
	
	<form action="memberjoin.do" method="post" onsubmit="return send()">
	

	            <textarea cols="55" rows="14" readonly>
	
					회원가입 약관
				
	            </textarea>

	
	<div style="text-align: center">
	  <label><input type="checkbox" name="agree" id="agree"/> 약관에 동의합니다</label>
	  <br>
	  <input type="submit" value="회원가입" id="memBtn" class="btn btn-danger"> 
	  <input type="button" value="취소"    id="memBtn" class="btn btn-danger" onclick="javascript:history.back()">
	</div>
	</form>
	<br><br>
	
</div>

<script>
	function send() {
		if(document.getElementById("agree").checked==true){
			return true;	
		}else{
			alert("약관에 동의한 후 회원가입이 가능합니다.");
			return false;	
		}//if end		
	}//send() end
</script>


<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>	