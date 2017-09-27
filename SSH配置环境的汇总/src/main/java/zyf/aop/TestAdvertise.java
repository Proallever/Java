package zyf.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAdvertise {
	@Before("execution(public * zyf..*(..))")
	public void before(JoinPoint jp){
		System.out.println("before");
	}
}
