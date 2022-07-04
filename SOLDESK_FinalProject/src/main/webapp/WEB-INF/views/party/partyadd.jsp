<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 test.jsp -->
	
	
	<!-- OTT/역할(파티장or파티원) 선택 -->
	
  <div class="container-fluid text-center">	

	<div class="pagetitle">
		
		<span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
		<span><strong> 파티 매칭 시작하기 </strong></span>
		<h5>보고 싶은 OTT와 파티 역할을 선택해 주세요</h5>
		<hr>
	</div>

    <form name="frm" method="post" action="partyadd.do">
    	
      <div>	
    	<div><strong>OTT선택</strong></div>
    	<input type="radio" id="ott_name" name="ott_name" value="netflix">넷플릭스<br>
    	<input type="radio" id="ott_name" name="ott_name" value="tving" checked="checked">티빙<br>
    	<input type="radio" id="ott_name" name="ott_name" value="watcha">왓챠<br>
    	<input type="radio" id="ott_name" name="ott_name" value="disney">디즈니<br>
      </div>
      ${dto.mem_id }
      
      <hr>
      
      <div>	
    	<div><strong>역할선택</strong></div>
    	<input type="radio" id="party_role" name="party_role" value="party_host" checked="checked">파티장<br>
    	<input type="radio" id="party_role" name="party_role" value="party_member">파티원<br>
      </div>	
 	  
 	  <hr> 
 	    
	  <div>
	      <input type="submit" value="파티 생성/가입하기">
	  </div>  
    
    </form>
  </div>	
	



<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>