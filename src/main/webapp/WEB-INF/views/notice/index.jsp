<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<link rel="shortcut icon" type="image/x-icon" href="http://gdj21.gudi.kr/images/icon_goodee.png">
	<link rel="stylesheet" href="resources/css/notice.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/notice.js"></script>
</head>
<body>
	<form id="login">
		<h1>로그인 수정</h1>
		<p>
			<label for="id">ID</label>
			<input type="text" name="id" id="id" placeholder="아이디를 입력하세요." required="required">
		</p>
		<p>
			<label for="pwd">PW</label>
			<input type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력하세요." required="required">
		</p>
		<p>
			<input type="submit" value="로그인">
		</p>
	</form>
	<div id="state">
		<p></p>
	</div>
</body>
</html>