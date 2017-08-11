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
	 * ���session��һ������ 
	 */
	@Test
	public void testGet() {
		Person p = session.get(Person.class, 2);
		System.out.println(p);
		p = session.get(Person.class, 2);
		System.out.println(p);
	}
	
	/*
	 * ���Ը�������
	 */
	@Test
	public void testUpdate1(){
		Person p = session.get(Person.class, 1);
		p.setName("˧����ׯԪ��");
	}
	
	/*
	 * ���Բ�������
	 */
	@Test
	public void testInsert() throws ParseException{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("1994-12-14");
		Person p = new Person("lvyzoee",22,168,date);
		session.save(p);
	}
	
	/*
	 * ����������
	 */
	@Test
	public void testClear() throws ParseException{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("1994-12-14");
		Person p = new Person("lvyzoee",22,168.2,date);
		session.persist(p);
		//save������ִ�е�
		session.clear();
	}
	
	/*
	 *����load 
	 *load ��һ�ִ��� ������
	 *�Ȱ����ݿ��¼��ɶ�����˵�����û�м�¼�����쳣
	 */
	@Test
	public void testLoad(){
		Person p = session.load(Person.class, 2);
		System.out.println(p);
	}
	
	/*
	 * ����update
	 */
	@Test
	public void testUpdate(){
		Person p =session.get(Person.class, 2);
		p.setHeight(110);
		ts.commit();
		session.close();
		session = factory.openSession();
		//��session�ر�֮��,pΪ����̬��ֻ��ͨ��update�޸ģ�����ֱ�ӹ���session
		ts = session.beginTransaction();
		session.update(p);
	}
	
	/*
	 * ����saveOrUpdate
	 */
	@Test
	public void testSaveOrUpdate(){
		Person p = new Person("zyfffff",22,183.3,new Date());
		p.setId(4);
		session.saveOrUpdate(p);
	}
	
	/*
	 * ����delete
	 */
	@Test
	public void testDelete(){
		Person p = session.get(Person.class, 1);
		session.delete(p);
	}
	
	/*
	 * ����Component
	 * ͦ��Ȥ�ģ����ܵ������ݱ����������ӳ��
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
