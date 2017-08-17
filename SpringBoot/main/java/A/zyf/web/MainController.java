package A.zyf.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Value("${name}")
	private String name ; 
	
	@RequestMapping("/hello")
	public String hello(){
		
		
		System.out.println("hello"+name);
		return "helloworld";
	}
	
}
