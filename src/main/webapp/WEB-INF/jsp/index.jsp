<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>DREAM NIGHT!</h2>

获取用户:<a href="/getId/1">GO</a>
<br/>
<br/>
<form action="/getId" method="post"> 
ID:<input type="number" name="id" placeholder="请输入用户ID"/><input type="submit" value="确认"/>
</form>
<br/>
<form action="/createUser" method="post"> 
邮箱:<input type="email" name="email" placeholder="请输入EAMIL"/><br>
昵称:<input type="text" name="nickname" placeholder="请输入昵称"/><br>
密码:<input type="password" name="password" placeholder="请输入密码"/><br>
日期:<input type="date" name="createtime" placeholder="请输入日期"/><br>
<input type="submit" value="确认"/>
</form>

</body>
</html>
