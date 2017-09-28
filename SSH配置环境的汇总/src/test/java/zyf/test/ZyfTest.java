package zyf.test;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import zyf.domain.Student.Student;
import zyf.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc.xml")
public class ZyfTest {
	@Autowired
	@Qualifier(value="shenqidea")
	private String a;
	
	@PersistenceContext
	private EntityManager manager ; 
	
	@Autowired
	private TestService testService ; 
	
	private ExpressionParser parser = null ;
	@Before
	public void init(){
		parser = new SpelExpressionParser();
	}
	
	@Test
	public void testA(){
		System.out.println(a);
	}
	
	/*
	 * 所以测试里面事务是自动回滚的
	 */
	@Test
	@Transactional
	@Rollback(value=false)
	public void testTransaction(){
		Student s1 = new Student();
		s1.setName("zyf");
		manager.persist(s1);	
	}
	
	/*
	 * SpEL的解析
	 */
	@Test
	public void testParse(){
		Date value = parser.parseExpression("'2017/08/13'").getValue(Date.class);
		System.out.println(value);
	}
	
	@Test
	public void testParse2(){
		String value = parser.parseExpression("'hehe'.concat('haha')").getValue(String.class);
		System.out.println(value);
	}
	
	/*
	 * 这样也行
	 */
	@Test
	public void testParse3(){
		List<Integer> value = parser.parseExpression("{{1,2},{2,3,4},{3,4,{1,2}}}").getValue(List.class);
		System.out.println(value);
	}
	
	@Test
	public void testParse4(){
		Boolean value = parser.parseExpression("'15858580733' matches '^[0-9]{11}$'").getValue(Boolean.class);
		System.out.println(value);
	}
	
	/*
	 * 测试一下缓存
	 */
	@Test
	public void testCache(){
		System.out.println(testService.getStudent(2l));
		System.out.println(testService.getStudent(2l));
	}
}
	