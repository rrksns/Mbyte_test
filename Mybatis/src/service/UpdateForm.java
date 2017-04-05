package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import model.Dept;

public class UpdateForm implements CommandProcess{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		DeptDao dd= DeptDao.getInstance();
		Dept dept = dd.select(deptno);
		request.setAttribute("dept", dept);
		return "updateForm";
	}

}
