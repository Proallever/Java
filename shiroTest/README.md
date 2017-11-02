#### shiro不结合web的使用   
#### 用户通过subject login发生了好多事情..    
#### 传AuthenticationToken,找到securityManager的realms，在realm里面传authenticationInfo，交给内部的credentialsMatcher判断一下，之后可以返回成功与豆    
#### 当调用isPermitted时，首先通过permissionResolver解析字符串，变成权限实体，然后再通过rolePermissionResolver来判断是否有权限   
#### 有意思
