<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../common.css">
<title>Insert title here</title>
</head>
<body>
<table><caption>부서목록</caption>
	<tr><th>부서코드</th><th>부서명</th><th>근무지</th><th>수정여부</th><th>삭제여부</th></tr>
<c:forEach var ="dept" items="${list}">
	<tr><td>${dept.deptno}</td><td>${dept.dname }</td>
		<td>${dept.loc }</td><td><a href="updateForm.do?deptno=${dept.deptno}">수정</a></td>
		<td><a href="delete.do?deptno=${dept.deptno}">삭제</a></td></tr>
</c:forEach>
</table>
<a href="insertForm.jsp">입력</a>
</body>
</html>