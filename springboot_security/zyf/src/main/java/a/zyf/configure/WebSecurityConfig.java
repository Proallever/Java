package a.zyf.configure;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration          // 配置文件
@EnableWebSecurity      // 开启Security
@EnableGlobalMethodSecurity(prePostEnabled = true)  //AOP
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Bean
	 @Override
	 protected AuthenticationManager authenticationManager() throws Exception {
	      return super.authenticationManager();
	 }
	 
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        	//选出哪些路由可以直接请求
            .authorizeRequests().antMatchers("/hello1","/hello2").permitAll()
            .and()
            .authorizeRequests().antMatchers("/hellozhizhang").hasAuthority("admin")
            .anyRequest().authenticated()
            //别 的路由需要验证
//            .and()
//            .anyRequest().authenticated();
            .and()
            .formLogin().permitAll();
            //.loginPage("/hello")
            //.defaultSuccessUrl("/hello")
            //.failureUrl("/gun").permitAll()
//            .and()
//        	.logout()
//        	.logoutSuccessUrl("/baibai").permitAll();
        
        
        super.configure(http);
    }

    /**
     * 配置内存用户
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("zyf").password("123").roles("USER")
            .and().withUser("zyf2").password("123").roles("ruozhi").authorities("zyf2","admin");
    }

}