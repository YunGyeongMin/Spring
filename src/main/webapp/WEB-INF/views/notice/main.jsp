<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판</title>
	<link rel="shortcut icon" type="image/x-icon" href="http://gdj21.gudi.kr/images/icon_goodee.png">
	<link rel="stylesheet" href="/resources/css/notice.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/js/notice.js"></script>
</head>
<body>
	<div>
		<h1>${sessionScope.USER.nm} 게시판</h1>
		<button type="button" id="create">글쓰기</button>
		<button type="button" id="logout">로그아웃</button>
	</div>
	<div id="msg" class="disNone">
		<form>
			<p class="disNone">
				<input type="hidden" name="no" id="no">
				<input type="hidden" name="uNo" id="uNo">
			</p>
			<p>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" placeholder="제목을 입력하세요." required="required">
			</p>
			<p>
				<label for="content">내용</label>
				<textarea rows="5" cols="3" name="content" id="content" placeholder="제목을 입력하세요."></textarea>
			</p>
			<p>
				<input type="submit" value="적용"><input type="button" value="취소">
			</p>
		</form>
	</div>
	<div id="list">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</body>
</html>