<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改规格</title>
</head>
	<body>
		<h3>修改规格</h3>
		<form action="updateRuleOutServlet.do" method="post">
		<input type="hidden" name="type" value="${rule.id}"/>
		商品编号:<input type="text" name="_textid" value="${rule.pid}" /></br></br>
		商品尺寸:<input type="text" name="_textsize" value="${rule.size}"/></br></br>
		<input type="submit" name="sub" value="确认" />
		<input type="submit" name="sub" value="取消"/>
		</form>
	</body>
</html>