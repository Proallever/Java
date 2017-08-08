package A;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorld {
	
	@RequestMapping("/helloworld")
	public String hello(){
		return "success";
	}
	
	@RequestMapping(value="/testMethod" ,method = RequestMethod.GET)
	public String testMethodGet(){
		return "get";
	}
	
	@RequestMapping(value="/testMethod" ,method = RequestMethod.POST)
	public String testMethodPost(){
		return "post";
	}
	
	@RequestMapping(value="/testVariable/{id}")
	public String testRequestVariable(@PathVariable("id") Integer id){
		System.out.println(id);
		return "post";
	}
}
