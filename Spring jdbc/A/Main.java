package A;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-test.xml");
//		JdbcTemplate jt = (JdbcTemplate)ctx.getBean("jdbcTemplate");
		NamedParameterJdbcTemplate npt = (NamedParameterJdbcTemplate)ctx.getBean("namedParameterJdbcTemplate");
		

		/*��jdbcTemplate.update����һ������
		 * 
		 */
//		String sql = "update users set username = ? where id = ?";
//		jt.update(sql , "zyf" , 1);
		
		/*��jdbcTemplate.batchUpdate�����������
		 * �����������
		 */
//		String sql = "insert into users (id , username , password )values (?,?,?)";
//		List<Object[]> bacthArgs = new ArrayList<Object[]>();
//		bacthArgs.add(new Object[]{2,"zyf1","123"});
//		bacthArgs.add(new Object[]{3,"zyf2","123"});
//		bacthArgs.add(new Object[]{4,"zyf3","123"});
//		jt.batchUpdate(sql, bacthArgs);
		
		/*��RowMapper����ѯ��һ������
		 * 
		 */
//		String sql = "select id , username as userName , password from users";
//		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class); 	
//		List<User> list = jt.query(sql, mapper);
//		System.out.println(list);
		
		/*ʹ��query��ѯĳһ��ֵ
		 * 
		 */
//		String sql = "select count(*) from users";
//		int num = jt.queryForObject(sql, Integer.class);
//		System.out.println(num);
		
		/*ʹ��NameParamrterJdbcTemplate
		 * 
		 */
//		String sql = "update users set username = :username , password = :password where id = :id ";
//		Map<String , Object> paramMap = new HashMap<String , Object>();
//		paramMap.put("id" , 1);
//		paramMap.put("username" , "zyf4");
//		paramMap.put("password" , "123");
//		npt.update(sql, paramMap);
		
		
	}	

}
