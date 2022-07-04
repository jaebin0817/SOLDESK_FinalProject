<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작 noticeread.jsp -->
	
	
	<div class="container-fluid text-center">	
		<div class="container text-center">	
		<table class="table" >
		<tr>
			<td colspan="2"><h1>${dto.qna_title}</h1></td>
		</tr>
		<tr>
			<th>문의날짜</th>
			<td>${dto.qna_date}</td>
		</tr>
		<tr>
			<th colspan="2" ><h4>내용</h4></th>
		</tr>
		<tr height=500>
			<td colspan="2"><h3>${dto.qna_content}</h3></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.mem_id}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${dto.qna_readcnt}</td>
		</tr>
		</table>
		${mem_id}
		${mem_pw}
		${msg}
		</div>
		
        <c:choose>
	          <c:when test="${ mem_id=='webmaster' }">
	            <form name="frm" id="frm" action="qnadelete.do" method="post" onsubmit="return IDlog()">
		            <input type="hidden" id="mem_id" name="mem_id" value="${mem_id}">
		            <input type="hidden" id="d_mem_id" name="d_mem_id" value="${dto.mem_id}">
		            <input type="hidden" id="qna_num" name="qna_num" value="${dto.qna_num}">
		            <input type="submit" value="웹마스터문의사항삭제"  class="btn btn-danger">
		        </form>	
	            <form name="frm" id="frm" action="qnaupdate.do?qna_num=${dto.qna_num}" method="post" onsubmit="return IDlog2()">
		        	<input type="hidden" id="mem_id" name="mem_id" value="${mem_id}">
		            <input type="hidden" id="d_mem_id" name="d_mem_id" value="${dto.mem_id}">
		        	<input type="submit" value="웹마스터문의사항수정"  class="btn btn-warning">
		        </form>       
	          </c:when>
	          <c:otherwise>
	          	<form name="frm" id="frm" action="qnadelete.do" method="post" onsubmit="return IDlog()">
		            <input type="hidden" id="mem_id" name="mem_id" value="${mem_id}">
		            <input type="hidden" id="d_mem_id" name="d_mem_id" value="${dto.mem_id}">
		            <input type="hidden" id="qna_num" name="qna_num" value="${dto.qna_num}">
		            <input type="hidden" name="qna_pw" id="qna_pw" value="${mem_pw}">
		            <input type="submit" value="문의사항삭제"  class="btn btn-danger">
		        </form>	
	            <form name="frm" id="frm" action="qnaupdate.do?qna_num=${dto.qna_num}" method="post" onsubmit="return IDlog2()">
		        	<input type="hidden" id="mem_id" name="mem_id" value="${mem_id}">
		            <input type="hidden" id="d_mem_id" name="d_mem_id" value="${dto.mem_id}">
		        	<input type="submit" value="문의사항수정"  class="btn btn-warning">
		        </form>
	          </c:otherwise>
	    </c:choose>
	        <input type="button" value="홈으로"  onclick="location.href='/home.do'" class="btn btn-success">
		<input type="button" value="공지목록" onclick="location.href='/notice/notice.do'" class="btn btn-success">
        
        <input type="email">

	</div>
		
	<script>
	function IDlog() {
		var mem_id=document.getElementById("mem_id").value;
		var d_mem_id=document.getElementById("d_mem_id").value;
		mem_id=mem_id.trim();
		d_mem_id=d_mem_id.trim();
		var message="진행된 내용은 복구되지 않습니다\n계속 진행할까요?";
	    
		
		if(mem_id=="webmaster"){
			if(confirm(message)){//확인true, 취소false
		        return true; //서버로 전송       
		    }else{
		        return false; //서버로 전송 안됨
		    }//if end
		}else if(mem_id!=d_mem_id){
			alert("본인만 삭제 가능합니다")
			return false;
		}
		if(confirm(message)){//확인true, 취소false
	        return true; //서버로 전송
	    }else{
	        return false; //서버로 전송 안됨
	    }//if end
	}//IDlog() end
	
	function IDlog2() {
		var mem_id=document.getElementById("mem_id").value;
		var d_mem_id=document.getElementById("d_mem_id").value;
		mem_id=mem_id.trim();
		d_mem_id=d_mem_id.trim();
		if(mem_id=="webmaster"){
			return true;
		}else if(mem_id!=d_mem_id){
			alert("본인만 수정 가능합니다")
			return false;
		}
		return true;
		
	}//IDlog2() end

	</script>
		
	




<!-- 본문끝 -->

<%@ include file="../footer.jsp"%>