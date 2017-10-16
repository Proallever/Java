import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import zyf.Person;

/**
* @author 张佳晨
*/
public class Main {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream ,"development");
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  Person p = (Person) session.selectOne("A.AA.TestMapper.selectPerson",1);
		  System.out.println(p);
		  session.insert("A.AA.TestMapper.insertPerson" , "zzz");
//		  session.update("A.AA.TestMapper.updatePerson");
		  session.commit();
		} finally {
		  session.close();
		}
	}
}
