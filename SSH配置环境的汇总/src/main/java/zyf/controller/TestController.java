package zyf.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zyf.domain.Student.Student;

@Controller
public class TestController {
	@Autowired
	@Qualifier("shenqidea")
	private String a ;
	
	@Value("#{shenqidea}")
	private String b ;
	
	//这个SpEL还挺厉害的，类路径下的配置属性都能parse出来
	@Value("${db.user}")
	private String user ; 
	
	@PersistenceContext
	private EntityManager manager ; 
	
	@ResponseBody
	@RequestMapping("/test")
	public String test(){
		return a + b + user;
	}
	
	@Transactional
	@RequestMapping("/test2")
	public void test2(){
		Student s1 = new Student();
		s1.setName("zyf");
		manager.persist(s1);
		throw new RuntimeException("haha");
	}
	
	@ResponseBody
	@RequestMapping("/test3")
	public Student test3(){
		return new Student("zyf");
	}
	
}
