package service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import model.Member;

public class Join implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		Member member = new Member();
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setAddress(address);
		member.setTel(tel);
		MemberDao md = MemberDao.getInstance();
		int result = md.insert(member);
		request.setAttribute("result", result);
		
		return "join";
	}

}
