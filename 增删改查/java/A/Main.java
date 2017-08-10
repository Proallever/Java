package A;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {
	@Autowired
	private JdbcTemplate jt ;
	
	/*
	 * 增
	 */
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String create(User user){
		System.out.println(user);
		String sql = "insert into users(username , password) values (?,?)";
		jt.update(sql , user.getUserName() , user.getPassword());
		return "redirect:/user/list";
	}
	
	/*
	 * 返回增视图
	 */
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String viewCreate(){
		return "create";
	}
	
	/*
	 * 删
	 */
	@RequestMapping(value="/user/delete/{id}",method=RequestMethod.GET)
	public String remove(@PathVariable(value="id") Integer id){
		String sql = "delete from users where id = ?";
		this.jt.update(sql , id);
		return "redirect:/user/list";
	}
	
	/*
	 * 改
	 */
	@RequestMapping(value="/user/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable(value="id") Integer id , User user){
		String sql = "update users set username = ? , password = ? where id = ?";
		this.jt.update(sql , user.getUserName() , user.getPassword() , id);
		return "success";
	}
	
	@RequestMapping(value="/user/update/{id}", method=RequestMethod.GET)
	public String updateView(@PathVariable(value="id") Integer id ,Map<String , Object> map){
		map.put("id",id);
		return "update";
	}
	
	/*
	 * 查
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public ModelAndView detail(@PathVariable(value="id") Integer id ){
		ModelAndView mv = new ModelAndView("success");
		String sql = "select * from users where id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = this.jt.queryForObject(sql, rowMapper,id);
		mv.addObject("users",user);
		return mv;
	}
	
	
	/*
	 * 列表
	 */
	@RequestMapping(value="/user/list",method=RequestMethod.GET)
	public ModelAndView query(){
		ModelAndView mv = new ModelAndView("success");
		String sql = "select * from users ";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		List<User> list = this.jt.query(sql, rowMapper);
		mv.addObject("users", list);
		return mv;
	}
	
}
