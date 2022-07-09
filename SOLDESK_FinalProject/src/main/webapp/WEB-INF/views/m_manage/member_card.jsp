<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    

<%@ include file="../../header.jsp"%>
<script type="text/javascript" src = "../js/card.js"></script>

<!-- 본문시작 member_card.jsp -->

<!-- 내가 좋아요한 목록 -->	
  	<div>
		<h1>변경할 카드를 선택해주세요</h1>
	</div>	
 	
 <h3>카드 정보를 입력해주세요</h3>
		<div class="container text-center">
			<input type="text" autocomplete="off" size="20" name="card_no"
				id="card_no" class="form-control" name="cardnumber"
				onkeyup="validatecardnumber(this.value)" size="20" maxlength="16"
				placeholder="카드 번호를 입력 해 주세요"
				oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
				required />
			<div id='notice'></div>
			<br>
			<strong>카드 유효기간을 입력해주세요</strong>
			<table class="table">
				<tr>
					<td>
						<select class="form-control" name="card_m" id="card_m">
							<option value="MM">MM</option>
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select> 
					</td>
					<td>
						<select class="form-control" name="card_y" id="card_y">
				                <option value="YY">YY</option>
				                <option value="22">22</option>
				                <option value="23">23</option>
				                <option value="24">24</option>
				                <option value="25">25</option>
				                <option value="26">26</option>
				                <option value="27">27</option>
				                <option value="28">28</option>
				                <option value="29">29</option>
				                <option value="30">30</option>
				                <option value="31">31</option>
				                <option value="32">32</option>
				                <option value="33">33</option>            
				        </select>
					</td>
				</tr>
			</table>

			<strong>카드 비밀번호 앞 2자리를 입력해주세요</strong>
			<input class="form-control" type="password"
				name="card_pw" id="card_pw" maxlength="2" autocomplete="off"
				oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
				required /> 
			<br> 
			<strong>카드사를 선택해주세요</strong>
			<select class="form-control"
				name="card_com" id="card_com">
				<option value="00">선택해주세요</option>
				<option value="신한">신한</option>
				<option value="국민">국민</option>
				<option value="삼성">삼성</option>
				<option value="케이뱅크">케이뱅크</option>
				<option value="카카오">카카오</option>
				<option value="BC">BC</option>
				<option value="외환">외환</option>
				<option value="기업">기업</option>
			</select> 
			<br> 
			<input type="submit" value="입력" class="btn btn-success">
			<input type="reset" value="취소" class="btn btn-danger">
		</div>

<!-- 본문끝 -->
<%@ include file="../../footer.jsp"%>
