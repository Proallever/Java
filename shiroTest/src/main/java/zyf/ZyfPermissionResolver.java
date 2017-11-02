package zyf;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;

/**
* @Author 庄元丰
* @CreateTime 2017年11月2日下午2:55:54
* 大概把string 变成权限实体
*/
public class ZyfPermissionResolver implements PermissionResolver{

	public Permission resolvePermission(String permissionString) {
		System.out.println("permissionResolver is working!");
		return new ZyfPermission(permissionString);
	}

}
