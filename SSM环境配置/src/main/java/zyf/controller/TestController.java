package zyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zyf.domain.person.Person;
import zyf.domain.person.PersonRepository;

/**
* @author 张佳晨 ...其实是庄元丰
*/
@RestController
public class TestController {
	@Autowired
	private PersonRepository personRepository ; 
	
//	@RequestMapping(name="/test" ,method=RequestMethod.GET)
//	public String hello() {
//		return "hello,world";
//	}
	
	@RequestMapping(name="/test2" ,method=RequestMethod.GET)
	public Person test() {
		System.out.println("111");
		return personRepository.query();
	}
}
