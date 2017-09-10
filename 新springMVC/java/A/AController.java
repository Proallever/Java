package A;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AController {
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public ModelAndView f(@Valid Person p, BindingResult result){
		if(result.hasErrors()){
			for(ObjectError error : result.getAllErrors()){
				//进行错误处理 
				System.out.println(error.getDefaultMessage());
			}
		}
		System.out.println("1");
	
		System.out.println(p.getName() + p.getDesc() +p.getBirth());
		return new ModelAndView("hehe");
	}
	
	@RequestMapping(value="/go")
	public String ff(){
		return "1";
	}
	
	@RequestMapping("/uploada")
	public String g(){
		return "upload";
	}
	
	@RequestMapping("/upload")
	public void h(Person p , HttpServletRequest request) throws IOException{
		if( null != p.getFile()){
			System.out.println(p.getName() + p.getFile().getSize());
			String filePath = request.getServletContext().getRealPath("/tmp/") + p.getFile().getOriginalFilename();
			p.getFile().transferTo(new File(filePath));
		}
	}
	
	@RequestMapping("/exception")
	public void fff(){
		throw new RuntimeException("oo");
	}
}
