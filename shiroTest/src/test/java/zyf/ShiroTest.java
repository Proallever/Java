package zyf;

import static org.junit.Assert.*;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import junit.framework.Assert;

/**
* @Author 庄元丰
* @CreateTime 2017年10月31日下午4:12:52
*/
public class ShiroTest {
	
	/**
	 * 基本的shiro测试，基于写死的用户，角色和权限
	 */
	@Test
	public void testShiro1() {
		
		//得到securityManager
	    Factory<org.apache.shiro.mgt.SecurityManager> factory =  
	            new IniSecurityManagerFactory("classpath:shiro1.ini");  
	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance(); 
	    SecurityUtils.setSecurityManager(securityManager); 
	    
	    //得到当前用户
	    Subject currentUser = SecurityUtils.getSubject(); 
	    
	    //就能用session了
	    Session session = currentUser.getSession();
	    session.setAttribute("name", "zyffff");
	    System.out.println("session中的name： " + session.getAttribute("name"));
	    
	    //登陆一下
	    UsernamePasswordToken token = new UsernamePasswordToken("zyf", "123456");  
	    token.setRememberMe(true);
	    try {  
	        currentUser.login(token);  
	    } catch (AuthenticationException e) {  
	    	System.out.println("登录失败");
	    }  
	    
	    //看一下是否登录，和是否是记住的方式登录
	    System.out.println("验证身份成功了： " + currentUser.isAuthenticated());
	    System.out.println("是记住我的方式登录的： " + currentUser.isRemembered());
	    
	    //看一下角色
	    if (currentUser.hasRole("admin")) {
	    	System.out.println("我是admin");
	    }
	    
	    //看一下权限
	    if (currentUser.isPermitted("update")) {
	    	System.out.println("is permitted to update");
	    }
	    
	    //登出
	    currentUser.logout();
	}
	
	/**
	 * 用数据库来记录user，role，permission
	 * 主要shiro2里面配置了 jdbcRealm
	 */
	@Test
	public void testShiro2() {
		
		//得到securityManager
	    Factory<org.apache.shiro.mgt.SecurityManager> factory =  
	            new IniSecurityManagerFactory("classpath:shiro2.ini");  
	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance(); 
	    SecurityUtils.setSecurityManager(securityManager); 
	    
	    //得到当前用户
	    Subject currentUser = SecurityUtils.getSubject();  

	    UsernamePasswordToken token = new UsernamePasswordToken("zyf", "123456");  
	    
	    try {  
	        currentUser.login(token);  
	    } catch (AuthenticationException e) {  
	    	System.out.println("登录失败");
	    }  
	    
	    if (currentUser.hasRole("admin")) {
	    	System.out.println("I am an admin");
	    }
	    
	    //这里居然没有权限 = = 
	    if (currentUser.isPermitted("write")) {
	    	System.out.println("I am permitted to write");
	    }
	    
	    currentUser.logout();  
	}
	
	/**
	 * 测试自定义Realm
	 * 多个Realm验证你的身份，使用默认策略
	 */
	@Test
	public void testShiro3() {
		//得到securityManager
	    Factory<org.apache.shiro.mgt.SecurityManager> factory =  
	            new IniSecurityManagerFactory("classpath:shiro3.ini");  
	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance(); 
	    SecurityUtils.setSecurityManager(securityManager); 
	    
	    //得到当前用户
	    Subject currentUser = SecurityUtils.getSubject();  

	    UsernamePasswordToken token = new UsernamePasswordToken("zyf", "123456");  
	    
	    try {  
	        currentUser.login(token);  
	    } catch (AuthenticationException e) {  
	    	System.out.println("登录失败");
	    }  
	}
	
	/**
	 * 自己写一套这个权限验证的过程lvyilv
	 */
	@Test
	public void testShiro4() {
		//得到securityManager
	    Factory<org.apache.shiro.mgt.SecurityManager> factory =  
	            new IniSecurityManagerFactory("classpath:shiro4.ini");  
	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance(); 
	    SecurityUtils.setSecurityManager(securityManager);
	    
	    //得到当前用户
	    Subject currentUser = SecurityUtils.getSubject(); 
	    UsernamePasswordToken token = new UsernamePasswordToken("zyf", "123456"); 
	    
	    try {  
	        currentUser.login(token);  
	    } catch (AuthenticationException e) {  
	    	System.out.println("登录失败");
	    } 
	    
	    if (currentUser.hasRole("admin")) {
	    	System.out.println("I am a admin");
	    }
	    
	    if (currentUser.isPermitted("write")) {
	    	System.out.println("I can write");
	    }
	}

}
