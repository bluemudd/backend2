<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 상세</title>
</head>
<body>
	<h1>게시글 상세</h1>
	<p>제목 : ${ data.title }</p>
	<p>내용 : ${ data.category }</p>
	<p>입력일 : <fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd HH:mm:ss"/></p>
	<a href="/list">목록으로</a>
	<p>
	<a href="update?boarId=${boardId }">수정</a>
	</p>
	<form method="POST" action="/delte">
	<input type="hidden" name="boardId" value="${boardId }"/>
	<input type="submit" value="삭제"/>
	</form>
	<p>
	<a href="/list">목록으로</a>
	</p>
</body>
</html>