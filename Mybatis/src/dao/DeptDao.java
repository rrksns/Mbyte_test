package dao;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import model.Dept;
public class DeptDao {
	  private static DeptDao instance = new DeptDao();
	  private DeptDao() {}
	  public static DeptDao getInstance() {
		  return instance;
	  }
	  private static SqlSession session;
	  static {
	    try {
	      Reader reader = 
	    	Resources.getResourceAsReader("configuration.xml");
	      SqlSessionFactory sqlMapper = 
	    		 new SqlSessionFactoryBuilder().build(reader); 
	      session = sqlMapper.openSession(true);
	      reader.close(); 
	    } catch (IOException e) {
	      System.out.println(e.getMessage());
	    }
	  }
	public List<Dept> list() {
		List<Dept> list = null;
		try { list = session.selectList("deptns.list");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public Dept select(int deptno) {
		Dept dept = null;
		try { dept=(Dept)
				session.selectOne("deptns.select",deptno);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dept;
	}
	public int update(Dept dept) {
		int result = 0;
		try { result=session.update("deptns.update",dept);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int delete(int deptno) {
		int result = 0;
		try { result=session.delete("deptns.delete",deptno);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int insert(Dept dept) {
		int result = 0;
		try { result = session.insert("deptns.insert",dept);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}	  
}