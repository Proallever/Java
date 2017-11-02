package zyf;

import java.util.Arrays;
import java.util.Collection;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;

/**
* @Author 庄元丰
* @CreateTime 2017年11月2日下午3:02:31
*/
public class ZyfRolePermissionResolver implements RolePermissionResolver{

	public Collection<Permission> resolvePermissionsInRole(String roleString) {
		if ("admin".equals(roleString)) {
			return Arrays.asList((Permission)new ZyfPermission("write"), (Permission)new ZyfPermission("read"));
		} else if ("user".equals(roleString)) {
			return Arrays.asList((Permission)new ZyfPermission("read"));
		}
		return null;
	}
	
}
