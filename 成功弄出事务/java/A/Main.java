package A;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Main {
	
	@PersistenceUnit
	private EntityManagerFactory factory; 
	
	private int i = 0;
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml");
//		EntityManagerFactory fa = ctx.getBean(EntityManagerFactory.class);
		PlatformTransactionManager tm = (PlatformTransactionManager)ctx.getBean("transactionManager");
		Main main = ctx.getBean(Main.class);
		try { main.inc();
		
		}catch(Exception e){
			
		}
//		System.out.println(main.factory.isOpen());
		System.out.println(main.i);
	}
	
	@Transactional
	public void inc(){
		i++ ;
		if(true){
			throw new RuntimeException();
		}
		i++ ;
	}
	
}
