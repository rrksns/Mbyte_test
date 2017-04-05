<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="sessionCheck.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../common.css">
</head><body>
<table><caption>회원정보</caption>
	<tr><th>아이디</th><th>이름</th><th>주소</th><th>전화</th>
		<th>가입일</th><th>삭제여부</th></tr>
<c:if test="${empty list }">
	<tr><td colspan="6">데이터가 없습니다</td></tr>
</c:if>
<c:if test="${not empty list }">
<c:forEach var="mem" items="${list}">
	<tr><td>${mem.id}</td><td>${mem.name}</td>
		<td>${mem.address}</td><td>${mem.tel}</td>
		<td>${mem.reg_date}<td>${mem.del}</td></tr>
</c:forEach>
</c:if>
</table>
<div align="center">
<c:if test="${startPage > PAGEPERBLOCK }">
		<a href="list.do?pageNum=${endPage-PAGEPERBLOCK}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="list.do?pageNum=${i}" >[${i}]</a>
</c:forEach>
<c:if test="${endPage < totPage }">
		<a href="list.do?pageNum=${startPage+PAGEPERBLOCK}">[다음]</a>
</c:if>	
</div>
</body>
</html>