package A;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes(names={"zyf"})
@Controller
public class HelloWorld {
	
	/*
	 * 基本式
	 */
	@RequestMapping("/helloworld")
	public String hello(){
		return "success";
	}
	
	/*
	 *根据method区分 
	 */
	@RequestMapping(value="/testMethod" ,method = RequestMethod.GET)
	public String testMethodGet(){
		return "get";
	}	
	@RequestMapping(value="/testMethod" ,method = RequestMethod.POST)
	public String testMethodPost(){
		return "post";
	}
	
	/*
	 * 带路由参数
	 */
	@RequestMapping(value="/testVariable/{id}")
	public String testRequestVariable(@PathVariable("id") Integer id){
		System.out.println(id);
		return "post";
	}
	
	/*
	 * 试试RESTful风格 的请求
	 */
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.GET)
	public String testRestGet(@PathVariable(value="id") Integer id){
		System.out.println(id);
		return "post";
	}
	@RequestMapping(value="/testRest",method=RequestMethod.POST)
	public String testRestPost(){
		System.out.println("post");
		return "post";
	}
	@RequestMapping(value="/testRest",method=RequestMethod.PUT)
	public String testRestPut(){
		System.out.println("put");
		return "post";
	}
	@RequestMapping(value="/testRest",method=RequestMethod.DELETE)
	public String testRestDelete(){
		System.out.println("delete");
		return "post";
	}
	
	/*
	 * 拿请求参数，header，和session
	 */
	@RequestMapping(value="/testParameter")
	public String testParameter(@RequestParam(value="name",required=true) String name,
								@RequestParam(value="age" , required=true) Integer age,
								@RequestParam(value="height" , required=false , defaultValue="0.0") Double height){
		System.out.println("name = "+name+",age = "+age+",height = "+height+".");
		return "success";
	}	
	@RequestMapping(value="/testHeader")
	public String testHeader(@RequestHeader(value="Accept-Encoding",required=true) String encoding){
		System.out.println(encoding);
		return "success";
	}
	@RequestMapping(value="/testSession")
	public String testSession(@CookieValue(value="JSESSIONID",required=false) String cookie){
		System.out.println(cookie);
		return "success";
	}
	
	/*
	 * 把请求参数传为一个java对象 POJO
	 */
	@RequestMapping(value="/testPOJO")
	public String testPOJO(Person p){
		System.out.println(p);
		return "success";
	}
	
	/*
	 * 像用servlet一样用springmvc
	 */
	@RequestMapping(value="/testServlet")
	public void testServlet(HttpServletRequest req , HttpServletResponse resp) throws IOException{
		PrintWriter pw = resp.getWriter();
		pw.println("Hi , I feel ok !");
	}
	
	/*
	 * 把返回对象放在结果页面中
	 */
	@RequestMapping(value="/testModelAndView")
	public ModelAndView testModelAndView(){
		ModelAndView result = new ModelAndView("success");
		result.addObject("time",new Date());
		result.addObject("zyf",new Person("zyf" , 22 , "man"));
		return result;
	}
	@RequestMapping(value="/testMap")
	public String testMap(Map<String , Object> map){//请求参数中的Map直接带到返回的ModelAndView中
		map.put("zyf", "zhizhang");
		map.put("time",new Date());
		return "success";
	}
	
	/*
	 * 返回结果放在session
	 */
	@RequestMapping(value="/testSessionAttribute")
	public String testSessionAttribute(Map<String , Object> map){
		map.put("zyf", "一个普通的男人");
		return "success";
	}
	
	/*
	 * 当请求参数中对象数据不完整时，在原有数据库对象上修改
	 * ModelAttribute
	 */
	@ModelAttribute
	public void putUser(@RequestParam(value="id",required=false ) Integer id, 
									Map<String , Object> map){
		//System.out.println("我执行了");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc.xml");
		JdbcTemplate jt = (JdbcTemplate)ctx.getBean("jdbcTemplate");
		String sql = "select * from users where id = ?";
		org.springframework.jdbc.core.RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class); 
		List<User> list = jt.query(sql, rowMapper,1);
		User user = list.get(0);
		
		map.put("abc" , user);
	}
	
	@RequestMapping(value="/testModelAttribute")
	public String testModelAttribute(@ModelAttribute(value="abc")User user){
		System.out.println(user);
		return "success";
	}
	
}
