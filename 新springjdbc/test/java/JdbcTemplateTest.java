import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import zyf.Person;

public class JdbcTemplateTest {
	
	JdbcTemplate jt = null;
	NamedParameterJdbcTemplate npjt = null ;
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml");
		jt =(JdbcTemplate) ctx.getBean("jdbcTemplate");
		npjt = new NamedParameterJdbcTemplate(jt);
	}
	
	@Test
	public void testA(){
		System.out.println(jt);
		System.out.println(npjt);
	}
	
	@Test
	public void testQueryObject(){
		String sql = "select * from test where id = ? ";
		Person pp = jt.queryForObject(sql, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
				Person p = new Person();
				p.setId(arg0.getInt("id"));
				p.setName(arg0.getString("name"));
				p.setAge(arg0.getInt("age"));
				p.setWeight(arg0.getDouble("weight"));
				return p;
			}
			
		} , 2);
		
		System.out.println(pp);
	}
	
	/*
	 * 命名参数需要有一个Map
	 * 还可以用in
	 */
	@Test
	public void testNameParamJT(){
		String sql = "select * from test where id in (:id) ";
		
		Map<String, List> map = new HashMap<>();
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(3);
		map.put("id", ints);
		
		List<Person> pp = npjt.query(sql, map , new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
				Person p = new Person();
				p.setId(arg0.getInt("id"));
				p.setName(arg0.getString("name"));
				p.setAge(arg0.getInt("age"));
				p.setWeight(arg0.getDouble("weight"));
				return p;
			}
			
		});
		System.out.println(pp);
	}
	
	@Test
	public void testPreparedStatement(){
		String sql = "select * from test where age = ?";
		PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory(
				sql , new int[]{Types.INTEGER});
		
		List<Person> list = jt.query(factory.newPreparedStatementCreator(new Object[]{22}), 
				new RowMapper<Person>() {

					@Override
					public Person mapRow(ResultSet arg0, int arg1) throws SQLException {
						Person p = new Person();
						p.setId(arg0.getInt("id"));
						p.setName(arg0.getString("name"));
						p.setAge(arg0.getInt("age"));
						p.setWeight(arg0.getDouble("weight"));
						return p;
					}
			
				});
		
		System.out.println(list);
	}
	
}
