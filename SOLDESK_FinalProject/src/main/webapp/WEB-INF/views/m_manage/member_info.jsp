<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<%@ include file="../header.jsp"%>
<!-- 본문시작 member_info.jsp -->

<!-- 회원 정보 수정 시작 -->

<div class="container text-center">
   
   <div class="pagetitle"><!-- css에  -->
      <br>
      <span><img src="/images/pot_icon.png" alt="OPOT" width="50px"></span>
      <span><strong> 회원 정보 수정 </strong></span>
      <br><br>
   </div>
   
   <form name="mem_info" id="mem_info" method="post">
   
      <table class="table memTable" id="memTable">
         
      <tr>
          <th>아이디</th>
          <td>
            <input type="text" class="form-control" name="mem_id" id="mem_id" value="${ dto.mem_id }" size="10" readonly>
          </td>
          <td>  
          </td>
      </tr>
      <tr>
          <th>생년월일</th>
          <td>
            <input type="text" class="form-control" name="mem_birth" id="mem_birth" value="${ dto.mem_birth }" readonly>
          </td>
          <td>  

          </td>
      </tr>
      <tr>
          <th>현재비밀번호*</th>
          <td>
            <input type="password" class="form-control" name="mem_pw" id="mem_pw" size="20" required>
          </td>
          <td></td>
      </tr>
      <tr>
          <th>신규비밀번호</th>
          <td>
            <input type="password" class="form-control" name="new_pw" id="new_pw" size="20">
          </td>
          <td></td>
      </tr>
      <tr>
          <th>신규비밀번호확인</th>
          <td>
            <input type="password" class="form-control" name="re_pw" id="re_pw" size="20">
          </td>
          <td></td>
      </tr>
      <tr>
          <th>연락처*</th>
          <td>
            <input type="text" class="form-control" name="mem_phone" id="mem_phone" value="${ dto.mem_phone }" required>
          </td>
          <td></td>
      </tr>
      <tr>
          <th>이메일*</th>
          <td>
              <input type="text" class="form-control" name="mem_email" id="mem_email"  value="${ dto.mem_email }" required>
          </td>
          <td>
            <input type="button" class="btn" value="Email 중복확인" onclick="">
          </td>
      </tr>
      
   
      <tr>
           <th>가입날짜</th>
           <td colspan="2">
               ${ dto.mem_reg }
           </td>
      </tr>
      <tr>
           <td colspan="3">
           </td>
      </tr>      
   
      </table>
            
      <input type="submit" value="수정"  id="memBtn" class="btn"/>
        <input type="reset"  value="취소"  id="memBtn" class="btn"/>
      <br><br><br>
      
   </form>

</div>


<!-- 회원정보 수정 끝 -->
   

<!-- 본문끝 -->
<%@ include file="../footer.jsp"%>