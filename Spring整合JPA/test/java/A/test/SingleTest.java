package A.test;

import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.transaction.annotation.Transactional;

import A.dao.PersonRepository;
import A.dao.PersonRepository3;
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
	 * 测试数据源是否可用
	 */
	@Test
	public void testDataSource(){
		System.out.println(ctx.getBean("dataSource"));
	}
	
	/*
	 * 测试JPA是否整合成功
	 */
	@Test
	public void testJpa(){	
	}
	
	/*
	 * 测试DAO
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
	
	/*
	 * 测试Repository
	 */
	@Test
	public void testRepository(){
		PersonRepository pr = (PersonRepository)ctx.getBean("personRepository");
		System.out.println(pr.getByName("zyf"));
	}
	
	/*
	 * 测试Repository中的各种方法
	 */
	@Test
	public void testRepositoryMethods(){
		PersonRepository pr = (PersonRepository)ctx.getBean("personRepository");
		System.out.println(pr.getByNameStartingWith("wang"));
		System.out.println(pr.getByIdLessThanAndNameEndsWith(7, "ong"));
		
		List<String> list = new ArrayList<String>();
		list.add("zy");
		list.add("zyf");
		System.out.println(pr.getByNameIn(list));
		
		System.out.println(pr.getByNameLike("%lih%"));
	}
	
	/*
	 * 测试@Query注解
	 */
	@Test
	public void testRepositoryAITE(){
		PersonRepository pr = (PersonRepository)ctx.getBean("personRepository");
		System.out.println(pr.getoo());
		System.out.println(pr.ooo("%lih%", 7 ));
		System.out.println(pr.ooo2(5));
	}
	
	/*
	 * 测试修改
	 */
	@Test
	public void testUpdate(){
		personService.repository();
	}
	
	/*
	 * 测试CRUDRepository
	 */
	@Test
	public void testCreate(){
		List<Person> list = new ArrayList<Person>();
		Person p1 = new Person("huluwa1");
		list.add(p1);
		Person p2 = new Person("huluwa2");
		list.add(p2);
		personService.savePersons2(list);
	}
	
	/*
	 * 测试分页
	 */
	@Test
	public void testPage(){
		PersonRepository3 pr3 = (PersonRepository3)ctx.getBean("personRepository3");
		//排序方式
		Order order = new Order(Direction.DESC,"id");
		//排序
		Sort sort = new Sort(order);
		
		int pageNo = 3;
		int pageSize = 5;
		PageRequest pageable = new PageRequest(pageNo, pageSize , sort);
		Page<Person> page = pr3.findAll(pageable);
		
		/*
		 * getContent不对
		 */
		//System.out.println(page.getContent());
		System.out.println(page.getTotalElements());

	}
}
