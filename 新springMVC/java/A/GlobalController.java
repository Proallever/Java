package A;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * 这样写可以全局处理异常
 */

@ControllerAdvice
public class GlobalController {
	
	@ExceptionHandler(Exception.class)
	public String f(){
		return "error";
	}
}
