package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import model.Dept;

public class Update implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		dept.setDname(dname);
		dept.setLoc(loc);
		DeptDao dd =  DeptDao.getInstance();
		int result = dd.update(dept);
		request.setAttribute("result", result);
				
		return "update";
	}
	

}
