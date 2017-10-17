import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		  Map<String, Object> condition = new HashMap<>() ; 
		  condition.put("name", "zzzoe");
		  List<Person> p = session.selectList("A.AA.TestMapper.selectPersonWithCondition" , condition);
		  System.out.println(p);
		  
//		     可以直接插入pojo
//		  Person person = new Person("zzzoe" ,22 ,170.0);
//		  session.insert("A.AA.TestMapper.insertPerson" , person);
		  session.commit();
		} finally {
		  session.close();
		}
	}
}
