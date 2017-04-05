package dao;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.sql.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Member;
import javax.naming.*;
public class MemberDao {
	private static MemberDao instance; // = new MemberDao();
	private MemberDao() {	}
	public static MemberDao getInstance() {
		if (instance == null) instance = new MemberDao();
		return instance;
	}
	private static SqlSession session;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("configuration.xml");
			SqlSessionFactory sqlMapper = 
				new SqlSessionFactoryBuilder().build(reader); 
			session = sqlMapper.openSession(true); //true 는 autocommit
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public int confirm(String id) {
		int result = 0;
		String str = (String)session.selectOne("confirm",id);
		if(str != null) result = 1;
		return result;
	}
	public int insert(Member member) {
		return session.insert("memberns.insert",member);// memberns쓰는이유는 insert가 여러개라서 위치를 확인시켜줌
	}
	public int loginChk(String id, String passwd) {
		int result = 0;
//		HashMap<String, String> hs = new HashMap<>();
//		hs.put("id", id);
		String dbPass= "";
		try { dbPass=(String) session.selectOne("memberns.loginChk",id);
		}catch(Exception e) { System.out.println(e.getMessage());}
		if (dbPass==null || dbPass.equals("")) {
			result = -1;
		} else if (passwd.equals(dbPass)) result = 1;
		else result = 0;
		return result;
	}
	public Member select(String id) {
		Member mem = (Member)session.selectOne("memberns.select",id);		
		return mem;
	}
	public int update(Member member) {
		
		int result = 0;	
		result=session.update("memberns.update",member);
		return result;
	}
	public int delete(String id) {
		return session.update("memberns.delete",id);
	}
	public List<Member> list(int startRow, int endRow) {
		HashMap<String,Integer> hashMap = new HashMap<>();
		hashMap.put("startRow", startRow);
		hashMap.put("endRow", endRow);
		
		return session.selectList("memberns.list",hashMap);
	}
	public int getTotal() {
		return (int)session.selectOne("getTotal");
	}
}