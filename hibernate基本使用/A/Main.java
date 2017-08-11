package A;

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

public class Main {

	public static void main(String[] args) throws ParseException {
		
		//天呐，创建一个sessionFactory
		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr =  new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = cfg.buildSessionFactory(sr);
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date birth = dateFormat1.parse("1995-08-13");
		Person p = new Person("zyf",22,183.2,birth);
		
		session.save(p);
		
		transaction.commit();
		session.close();
		factory.close();
	}

}
