<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CRUD VIEW1</title>
	<link rel="stylesheet" href="/resources/css/view.css">
</head>
<body>
	<h1>내용 작성</h1>
	<form action="/crud/insert" method="post">
		<input type="text" name="message" placeholder="입력 내용을 작성하세요.">
		<input type="submit" value="입력">
	</form>
	<hr>
	<h1>내용 검색</h1>
	<form action="/crud/view" method="get">
		<input type="text" name="keyword" placeholder="검색 키워드를 작성하세요.">
		<input type="submit" value="검색">
	</form>
	<hr>
	<h1>내용 목록</h1>
	<ol>
		<c:forEach var="row" items="${list}">
			<li>${row}</li>
		</c:forEach>
	</ol>
</body>
</html>