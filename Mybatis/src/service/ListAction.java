package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import model.Dept;

public class ListAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		DeptDao dd = DeptDao.getInstance();
		List<Dept> list = dd.list();
		request.setAttribute("list",list);
		return "list";
	
	}
}
