<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.*,model.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	Member mem = new Member();
	MemberDao md = MemberDao.getInstance();
 	for(int i=100;i<=209;i++){
 		mem.setId("k"+i);
 		mem.setPasswd("k"+i);
 		mem.setName("길동"+i);
 		mem.setAddress("서울 강남"+i);
 		mem.setTel("018-1212-333"+i);
 		md.insert(mem);
 		
}
%>
입력완료
</body>
</html>