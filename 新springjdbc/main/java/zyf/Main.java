package zyf;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception, SQLException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml");
		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());

	}
}
