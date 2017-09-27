package zyf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
	@Bean(name="shenqidea")
	public String a(){
		String a = new String("zyf is the best!");
		return a ;
	}
}
