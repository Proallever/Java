package zyf;

import org.apache.shiro.authz.Permission;

/**
* @Author 庄元丰
* @CreateTime 2017年11月2日下午2:46:46
* 大概是权限实体
*/
public class ZyfPermission implements Permission{

	private String permissionStr;
	
	public ZyfPermission(String str) {
		System.out.println("init");
		this.permissionStr = str;
	}

	public boolean implies(Permission p) {
		if (!(p instanceof ZyfPermission)) {
			return false;
		}
		
		if (((ZyfPermission)p).getPermissionStr().equals(permissionStr)) {
			return true;
		}
		
		return false;
	}

	public String getPermissionStr() {
		return permissionStr;
	}

	public void setPermissionStr(String permissionStr) {
		this.permissionStr = permissionStr;
	}
	
}
