<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CRUD VIEW2</title>
	<link rel="shortcut icon" type="image/x-icon" href="http://gdj21.gudi.kr/images/icon_goodee.png">
	<link rel="stylesheet" href="/resources/css/view.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 	<script type="text/javascript" src="/resources/js/crud_module.js"></script> -->
<!-- 	<script type="text/javascript" src="/resources/js/crud.js"></script> -->
<!-- 	<script type="text/javascript" src="/resources/js/crud1.js"></script> -->
	<script type="text/javascript" src="/resources/js/crud2.js"></script>
</head>
<body>
	<h1>내용 작성</h1>
	<form id="create">
		<input type="text" id="message" placeholder="입력 내용을 작성하세요.">
		<input type="submit" value="입력">
	</form>
	<hr>
	<h1>내용 검색</h1>
	<form id="read">
		<input type="text" id="keyword" placeholder="검색 키워드를 작성하세요.">
		<input type="submit" value="검색">
	</form>
	<hr>
	<h1>내용 목록</h1>
	<div id="BTN">
		<button>ON / OFF</button>
	</div>
	<div id="LIST"></div>
</body>
</html>