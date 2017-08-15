package A;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JPATest {
	
	private EntityManagerFactory factory ; 
	private EntityManager manager;
	private EntityTransaction tx;
	
	@Before
	public void init(){
		factory = Persistence.createEntityManagerFactory("JPA");
		manager = factory.createEntityManager();
		tx = manager.getTransaction();
		tx.begin();
	}
	
	@After
	public void destory(){
		tx.commit();
		manager.close();
		factory.close();
	}
	
	/*
	 * 相当于hibernate的get
	 */
	@Test
	public void testFind() {
		Person zyf = manager.find(Person.class, 1);
		System.out.println("---------");
		System.out.println(zyf);
	}
	
	/*
	 * 相当于hibernate的load
	 */
	@Test
	public void testGetReference(){
		Person zyf = manager.getReference(Person.class, 1);
		System.out.println("--------");
		System.out.println(zyf);
	}
	
	/*
	 * 类似于save
	 */
	@Test
	public void testPersist(){
		Person p = new Person("zy",22,new Date());
		manager.persist(p);
	}
	
	/*
	 * delete
	 */
	@Test
	public void testDelete(){
		Person p = manager.find(Person.class, 2);
		manager.remove(p);
	}
	
	/*
	 * merge相当于hibernate的saveOrUpdate
	 */
	@Test
	public void testMerge1(){
		Person p = new Person("zy",22,new Date());
		manager.merge(p);
	}
	
	/*
	 * merge相当于hibernate的saveOrUpdate
	 * 游离对象如果数据有直接update
	 * 没有则插入
	 */
	@Test
	public void testMerge2(){
		Person p = new Person("zy",22,new Date());
		p.setId(4);
		p.setAge(21);
		manager.merge(p);
	}	
	
	/*
	 * ManyToOne
	 */
	@Test
	public void testManyToOne(){
		Office office = new Office("329");
		Shangbanzu sbz1 = new Shangbanzu("zyf");
		Shangbanzu sbz2 = new Shangbanzu("zyf2");
		sbz1.setOffice(office);
		sbz2.setOffice(office);
		manager.persist(sbz1);
		manager.persist(sbz2);
		manager.persist(office);
	}
	
	/*
	 * OneToMany
	 */
	@Test
	public void testOneToMany(){
		Office office = new Office("329");
		Shangbanzu sbz1 = new Shangbanzu("zyf");
		Shangbanzu sbz2 = new Shangbanzu("zyf2");
		office.getMembers().add(sbz1);
		office.getMembers().add(sbz2);
		manager.persist(sbz1);
		manager.persist(sbz2);
		manager.persist(office);
	}
	
	/*
	 * OneToOne
	 */
	@Test
	public void testOneToOne(){
		Door door = new Door("zz");
		Lock lock = new Lock("hh");
		
		door.setLock(lock);
		
		//必须先保存lock再保存door ,因为door上有lock的外键
		manager.persist(lock);
		manager.persist(door);
	}
	
	/*
	 * ManyToMany
	 */
	@Test
	public void testManyToMany(){
		Group group1 = new Group("group1");
		Group group2 = new Group("group2");
		Member member1 = new Member("member1");
		Member member2 = new Member("member2");
		Member member3 = new Member("member3");
		
		group1.getMembers().add(member1);
		group1.getMembers().add(member2);
		
		group2.getMembers().add(member2);
		group2.getMembers().add(member3);
		
		manager.persist(member1);
		manager.persist(member2);
		manager.persist(member3);
		manager.persist(group1);
		manager.persist(group2);	
	}
	
	/*
	 * JPQL
	 */
	@Test
	public void testJPQL(){
		String jpql = "from Person p where p.age >= ?";
		Query query = manager.createQuery(jpql);
		query.setParameter(1 , 22);
		List<Person> list = query.getResultList();
		System.out.println(list);
	}
}
