package A;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * ����д����ȫ�ִ����쳣
 */

@ControllerAdvice
public class GlobalController {
	
	@ExceptionHandler(Exception.class)
	public String f(){
		return "error";
	}
}
