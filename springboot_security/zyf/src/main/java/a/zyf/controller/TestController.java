package a.zyf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping("/gun")
	public String gun(){
		return "gun";
	}
	
	@RequestMapping("/hello2")
	public String hello2(){
		return "hello2";
	}
	
	@RequestMapping("/hello1")
	public String hello1(){
		return "hello1";
	}
	
	@RequestMapping("/hellozhizhang")
	public String hellozhizhang(){
		return "hello zyf";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/helloadmin")
	public String helloadmin(){
		return "hello admin";
	}
}
