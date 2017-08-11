package A;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {

	private SessionFactory factory; 
	private Session session;
	private Transaction ts;
	
	@Before
	public void init(){
		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr =  new StandardServiceRegistryBuilder().configure().build();
		factory = cfg.buildSessionFactory(sr);
		session = factory.openSession();
		ts = session.beginTransaction();
	}
	
	@After
	public void destroy(){
		ts.commit();
		session.close();
		factory.close();
	}
	
	/*
	 * 查表，session的一级缓存 
	 */
	@Test
	public void testGet() {
		Person p = session.get(Person.class, 2);
		System.out.println(p);
		p = session.get(Person.class, 2);
		System.out.println(p);
	}
	
	/*
	 * 测试更新数据
	 */
	@Test
	public void testUpdate1(){
		Person p = session.get(Person.class, 1);
		p.setName("帅气的庄元丰");
	}
	
	/*
	 * 测试插入数据
	 */
	@Test
	public void testInsert() throws ParseException{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("1994-12-14");
		Person p = new Person("lvyzoee",22,168,date);
		session.save(p);
	}
	
	/*
	 * 测试清理缓存
	 */
	@Test
	public void testClear() throws ParseException{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("1994-12-14");
		Person p = new Person("lvyzoee",22,168.2,date);
		session.persist(p);
		//save是立即执行的
		session.clear();
	}
	
	/*
	 *测试load 
	 *load 是一种代理 懒加载
	 *先把数据库记录变成对象再说，如果没有记录会抛异常
	 */
	@Test
	public void testLoad(){
		Person p = session.load(Person.class, 2);
		System.out.println(p);
	}
	
	/*
	 * 测试update
	 */
	@Test
	public void testUpdate(){
		Person p =session.get(Person.class, 2);
		p.setHeight(110);
		ts.commit();
		session.close();
		session = factory.openSession();
		//当session关闭之后,p为游离态，只能通过update修改，不能直接关联session
		ts = session.beginTransaction();
		session.update(p);
	}
	
	/*
	 * 测试saveOrUpdate
	 */
	@Test
	public void testSaveOrUpdate(){
		Person p = new Person("zyfffff",22,183.3,new Date());
		p.setId(4);
		session.saveOrUpdate(p);
	}
	
	/*
	 * 测试delete
	 */
	@Test
	public void testDelete(){
		Person p = session.get(Person.class, 1);
		session.delete(p);
	}
	
	/*
	 * 测试Component
	 * 挺有趣的，感受到了数据表与类的这种映射
	 */
	@Test
	public void testComponet(){
		Person p = new Person("zyf",22,183.4,new Date());
		Engine engine = new Engine("zyf",250);
		Car car = new Car("audi", 300000, engine);
		p.setCar(car);
		session.save(p);
	}
	
	
}
