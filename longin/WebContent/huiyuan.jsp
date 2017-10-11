<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/denglu.css"/>
<title>Insert title here</title>
</head>
<body>
		<div class="maijia">
			<div class="maijiayi">
				<div class="denglu">
					<div class="denglu1">
						<span >用户登录</span>
						<a href="#">免费注册</a>
					</div>
					<form action="HYServlet" method="post">
					<div class="denglu2">
						<div class="denglu3">
					       账号：<br />
						<input type="" name="username" id="" placeholder="请输入用户名" />
						密码：<br  />
						<input type="" name="password" id="" placeholder="请输入密码" />
						<p><input type="checkbox"  name="checkbox" value="1">自动登录</p>
					     <button type="submit" value="登录" class="longin"> 登录</button>    
						</div>
						</div>
						</form>
					</div>				
				</div>
			
			</div>
			
		</div>
</body>
</html>