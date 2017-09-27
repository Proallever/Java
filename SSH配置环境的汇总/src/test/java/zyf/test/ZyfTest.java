package zyf.test;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import zyf.domain.Student.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc.xml")
public class ZyfTest {
	@Autowired
	@Qualifier(value="shenqidea")
	private String a;
	
	@PersistenceContext
	private EntityManager manager ; 
	
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
}
	