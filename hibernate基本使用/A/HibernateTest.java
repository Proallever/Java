package A;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
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
	
	/*
	 * ����һ�Զ��ϵ
	 */
	@Test
	public void testManyToOne(){
		Emperor emp = new Emperor("zyf" , 120);
		Princess pri = new Princess("zy" ,98 , emp);
		Princess pri2 = new Princess("zy2",98,emp);
		session.save(pri);
		session.save(emp);
		session.save(pri2);
	}
	/*
	 * ���Թ�����ѯ 
	 */
	@Test
	public void testManyToOneQuery(){
		Princess ps= session.get(Princess.class, 2);
		System.out.println(ps);
	}
	
	/*
	 * ����˫��OneTOMany
	 */
	@Test
	public void testManyToOneDeque(){
		Emperor ps = session.get(Emperor.class, 4);
		System.out.println(ps.getPrincesses());
	}
	
	/*
	 * ����˫��һ��һ
	 */
	@Test
	public void testOneToOne(){
		Husband husband = new Husband();
		Wife wife = new Wife("zy",husband);
		Wife wife2 = new Wife("zy2",husband);
		husband.setWife(wife);
		husband.setName("zyf");
		session.save(husband);
		session.save(wife);
		session.save(wife2);
	}
	
	/*
	 * ����һ��һ��ѯ 
	 */
	@Test
	public void testOneToOneQuery(){
		Husband hus = session.get(Husband.class, 3);
		System.out.println(hus.getWife().getHusband().getName());
	}
	
	/*
	 * ���Զ�Զ��ϵ
	 */
	@Test
	public void testManyToMany(){
		Student stu1 = new Student("zyf") ;
		Student stu2 = new Student("zy");
		
		Course cos1 = new Course("���Դ���");
		Course cos2 = new Course("��������");
		Course cos3 = new Course("΢�ּ���");
		Course cos4 = new Course("����ѧ");
		
		stu1.getCourses().add(cos1);
		stu1.getCourses().add(cos2);
		stu1.getCourses().add(cos3);
		
		stu2.getCourses().add(cos3);
		stu2.getCourses().add(cos4);
		
		session.save(cos1);
		session.save(cos2);
		session.save(cos3);
		session.save(cos4);
		
		session.save(stu1);
		session.save(stu2);
		
		System.out.println(stu1);
		System.out.println(stu2);
	}
	
	/*
	 * ���Զ�Զ��ѯ
	 */
	@Test
	public void testManyToManyQuery(){
		Student zyf = session.get(Student.class, 11);
		System.out.println(zyf);
	}
	
	/*
	 * ����HQL
	 */
	@Test
	public void testHQL(){
		String hql = "from Person p where p.height > ? and p.name like ?";
		Query query = session.createQuery(hql);
		query.setInteger(0,167)
			.setString(1, "%zoe%");
		System.out.println(query.list());
	}
	
	/*
	 * ����HQL����������������
	 */
	@Test
	public void testHQL2(){
		String hql = "from Person p where p.height > :height and p.name like :name";
		Query query = session.createQuery(hql);
		query.setDouble("height",167)
			.setString("name", "%zoe%");
		System.out.println(query.list());
	}
	
	/*
	 * ����HQL��ҳ��ѯ��ͶӰ
	 * ͶӰ�������������б�
	 */
	@Test
	public void testHQL3(){
		String hql = "select p.name , p.age from Person p";
		Query query = session.createQuery(hql);
		
		int pageNum = 2;
		int pageSize = 5;
		
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Object []> list = query.list();
		for(Object[] o : list){
			System.out.println(Arrays.asList(o));
		}
	}
	
	/*
	 * ���Թ�����ѯ
	 */
	@Test
	public void testJoinQuery(){
		String hql = "select s.id , s.name , cour.name from Student s join s.courses cour"; 
		Query query = session.createQuery(hql);
		List<Object []> list = query.list();
		for(Object[] o : list){
			System.out.println(Arrays.asList(o));
		}
	}
	
	/*
	 * ����ԭ��sql��ѯ
	 */
	@Test
	public void testSQL(){
		String sql = "select * from course where id = 22";
		Query query = session.createSQLQuery(sql);
		List<Object []> list = query.list();
		for(Object[] o : list){
			System.out.println(Arrays.asList(o));
		}
	}
}
