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
	 * ����ʽ
	 */
	@RequestMapping("/helloworld")
	public String hello(){
		return "success";
	}
	
	/*
	 *����method���� 
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
	 * ��·�ɲ���
	 */
	@RequestMapping(value="/testVariable/{id}")
	public String testRequestVariable(@PathVariable("id") Integer id){
		System.out.println(id);
		return "post";
	}
	
	/*
	 * ����RESTful��� ������
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
	 * �����������header����session
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
	 * �����������Ϊһ��java���� POJO
	 */
	@RequestMapping(value="/testPOJO")
	public String testPOJO(Person p){
		System.out.println(p);
		return "success";
	}
	
	/*
	 * ����servletһ����springmvc
	 */
	@RequestMapping(value="/testServlet")
	public void testServlet(HttpServletRequest req , HttpServletResponse resp) throws IOException{
		PrintWriter pw = resp.getWriter();
		pw.println("Hi , I feel ok !");
	}
	
	/*
	 * �ѷ��ض�����ڽ��ҳ����
	 */
	@RequestMapping(value="/testModelAndView")
	public ModelAndView testModelAndView(){
		ModelAndView result = new ModelAndView("success");
		result.addObject("time",new Date());
		result.addObject("zyf",new Person("zyf" , 22 , "man"));
		return result;
	}
	@RequestMapping(value="/testMap")
	public String testMap(Map<String , Object> map){//��������е�Mapֱ�Ӵ������ص�ModelAndView��
		map.put("zyf", "zhizhang");
		map.put("time",new Date());
		return "success";
	}
	
	/*
	 * ���ؽ������session
	 */
	@RequestMapping(value="/testSessionAttribute")
	public String testSessionAttribute(Map<String , Object> map){
		map.put("zyf", "һ����ͨ������");
		return "success";
	}
	
	/*
	 * ����������ж������ݲ�����ʱ����ԭ�����ݿ�������޸�
	 * ModelAttribute
	 */
	@ModelAttribute
	public void putUser(@RequestParam(value="id",required=false ) Integer id, 
									Map<String , Object> map){
		//System.out.println("��ִ����");
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
