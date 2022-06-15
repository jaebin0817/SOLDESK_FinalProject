<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>msgView.jsp</title>
	<style> 
      *{ font-family: gulim; font-size: 24px; } /* 페이지 모든 요소에 스타일 적용(*) */
    </style> 
    <link href="../css/style.css" rel="stylesheet" type="text/css"><!-- css폴더 경로 잘보기!  -->
</head>
<body>
    <div class="title">알림</div>
    
    <div class="content">
    	<dl>
    		<dd>${ msg != null ? img : "" } ${ msg }</dd> <!-- requestScope생략 -->
    	</dl>
    	<p>
    		${ link1 }
    		${ link2 }    
    	</p>
    </div>

</body>
</html>