package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import model.Member;

public class MemberList implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		final int ROWPERPAGE =10;//한페이지당 페이지수
		final int PAGEPERBLOCK=10;
		String pageNum=request.getParameter("pageNum");
		if(pageNum == null|| pageNum.equals(""))pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		MemberDao md= MemberDao.getInstance();
		int total = md.getTotal();
		int startRow = (currentPage-1)*ROWPERPAGE+1;
		int endRow = startRow+ROWPERPAGE-1;
		int number=total-startRow+1;
		List<Member> list = md.list(startRow,endRow);
		int totPage =(int)Math.ceil((double)total/ROWPERPAGE); //총페이지수 계산
		int startPage=currentPage-(currentPage-1)%PAGEPERBLOCK;
		//startPage=currentPage/PAGEPERBLOCK*PAGEPERBLOCK+1;
		int endPage = startPage+PAGEPERBLOCK-1;
		if(endPage>totPage)endPage=totPage;
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("totPage", totPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("PAGEPERBLOCK", PAGEPERBLOCK);
		
		return "list";
	}

}
