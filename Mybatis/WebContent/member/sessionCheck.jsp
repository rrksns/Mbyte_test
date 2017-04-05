<%
	String id = (String) session.getAttribute("id");
	if (id == null || id.equals("")) {
		response.sendRedirect("logInForm.jsp");
		return;
	}
%>