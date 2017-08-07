package A;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Adviser {
	@Before("execution(public int A.CaculaterImpl.*(int,int))")
	 public void beforeMethod(){
		 System.out.println("before");
	 }
}
