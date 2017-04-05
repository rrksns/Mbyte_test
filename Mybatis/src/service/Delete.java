package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;

public class Delete implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		DeptDao dd = DeptDao.getInstance();
		int result =dd.delete(deptno);
		request.setAttribute("result", result);
		return "delete";
	}

}
