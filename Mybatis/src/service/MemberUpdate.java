package service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import model.Member;

public class MemberUpdate implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.getMessage();			
		}
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String address = request.getParameter("address");
		String tel= request.getParameter("tel");
		String name = request.getParameter("name");
		Member member = new Member();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setTel(tel);
		MemberDao md = MemberDao.getInstance();
		int result=md.update(member);
		request.setAttribute("result", result);
		return "update";
	}

}
