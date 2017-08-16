package A.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import A.entities.Person;
import A.services.PersonService;

public class SingleTest {
	private ApplicationContext ctx = null ;
	private PersonService personService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("context-beans.xml");
		personService = (PersonService)ctx.getBean("personService");
	}
	
	/*
	 * ��������Դ�Ƿ����
	 */
	@Test
	public void testDataSource(){
		System.out.println(ctx.getBean("dataSource"));
	}
	
	/*
	 * ����JPA�Ƿ����ϳɹ�
	 */
	@Test
	public void testJpa(){	
	}
	
	/*
	 * ����DAO
	 */
	@Test 
	public void testDAO(){
		Person p = new Person();
		p.setName("zyf");
		Person p2 = new Person();
		p2.setName("zy");
		Person[] pp = new Person[2];
		pp[0] = p;
		pp[1] = p2;
		
		personService.savePersons(pp);
	}
	
}
