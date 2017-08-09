<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index</title>
</head>
<body>
	<a href="helloworld">Hello World!</a><br />
	
	<a href="testMethod">testMethod</a><br />
	
	<form method="post" action="testMethod">
		<input type="submit" value="post" />
	</form>
	
	<a href="testVariable/33">testVariable</a><br />
	
	<a href="testRest/1">testRestGET</a><br />
	
	<form method="post" action="testRest">
		<input type="submit" value="post" />
	</form>
	
	<form method="post" action="testRest">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="put" />
	</form>
	
	<form method="post" action="testRest">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="delete" />
	</form>
	
	<a href="testParameter?name=zyf&age=22">test parameter</a><br />
	<a href="testHeader">test header</a><br />
	<a href="testSession">test Session</a>
	
	<form method="post" action="testPOJO">
		name:<input type="text" name="name" /><br />
		age:<input type="text" name="age" /><br />
		gender:<input type="text" name="gender" /><br />
		gf.name<input type="text" name="girlFriend.name" /><br />
		gf.age<input type="text" name="girlFriend.age" /><br />
		gf.gender<input type="text" name="girlFriend.gender" /><br />
		<input type="submit" value="submit" />		
	</form>
	
	<a href="testServlet">test Servlet</a><br />
	<a href="testModelAndView">test ModelAndView</a><br />
	<a href="testMap">test Map</a><br />
	<a href="testSessionAttribute">testSessionAttribute</a><br />
	<form method="post" action="testModelAttribute">
		<input type="hidden" name="id" value="1">
		<input type="text" name="userName" />
		<input type="submit" value="提交" />
	</form>
	 
</body>
</html>