<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="common.css">
</head>
<body>
<form action="insert.do">
<table><caption>부서정보 수정</caption>	
	<tr><th>부서코드</th><td><input type="text" name="deptno" required="required" autofocus="autofocus"></td></tr>
	<tr><th>부서명</th><td><input type="text" name="dname" required="required" 
	></td></tr>
	<tr><th>근무지</th><td><input type="text" name="loc" required="required" 
	></td></tr>
	<tr><th colspan="2"><input type="submit" value="확인"></th></tr>


</table>
</form>

</body>
</html>