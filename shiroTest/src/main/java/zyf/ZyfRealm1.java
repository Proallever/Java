package zyf;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
* @Author 庄元丰
* @CreateTime 2017年11月2日下午1:50:06
*/
public class ZyfRealm1 extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String Id = principals.getPrimaryPrincipal().toString();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  

		if ("zyf".equals(Id)) {
	        authorizationInfo.addRole("admin");  
		} else if("zy".equals(Id)) {
	        authorizationInfo.addRole("user"); 
		}
		
		//手动+权限 其实不需要这样做
//        authorizationInfo.addStringPermission("read");  
//        authorizationInfo.addStringPermission("write");  
        return authorizationInfo;  
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();  //得到用户名  
        String password = new String((char[])token.getCredentials()); //得到密码  
        
        System.out.println("你用了这个token：" + username + "&" + password); 
        if(!"zyf".equals(username)) {  
            throw new UnknownAccountException(); //如果用户名错误  
        }  
        if(!"123456".equals(password)) {  
            throw new IncorrectCredentialsException(); //如果密码错误  
        }  
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；  
        return new SimpleAuthenticationInfo(username, password, getName());
	}
	
}
