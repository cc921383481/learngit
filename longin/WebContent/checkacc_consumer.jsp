<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看会员信息</title>
		<style>
			table{
				/*text-align: center;*/
			}
			.td1{
				width: 150px;
				text-align: center;
			}
			.td2{
				width: 500px;
				height: 35px;
			}			
			input{
				margin-left: 150px;
				height: 25px;
				width: 250px;
			}
			
			#input1,#input2{
				height: 35px;
   				width: 80px;
			}
			#input1{
				margin-left: 270px;
			}
		</style>
	</head>
	<body>
		<h3>查看会员信息</h3>
		<form action="ConsumerServlet" method="post">
			<table cellpadding="0" cellspacing="0" border="1" width="800px">
				<tr>
					<td class="td1">用户名:</td>
					<td class="td2"><input type="text" name="loginname" value="${consumer.loginname}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="td1">密码:</td>
					<td class="td2"><input type="text" name="password" value="${consumer.password}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="td1">注册时间:</td>
					<td class="td2"><input type="text" name="registertime" value="${consumer.registertime}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="td1">最后登录时间:</td>
					<td class="td2"><input type="text" name="lastlogintime" value="${consumer.lastlogintime}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="td1">IP地址:</td>
					<td class="td2"><input type="text" name="ip" value="${consumer.ip}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="td1">用户昵称:</td>
					<td class="td2"><input type="text" name="nickname" value="${consumer.nickname}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="td1">订单金额:</td>
					<td class="td2"><input type="text" name="money" value="${consumer.money}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="td1">最近消费时间:</td>
					<td class="td2"><input type="text" name="lasttime" value="${consumer.lasttime}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="button" id="input1" name="sub" value="返回" onclick="location.href=('consumerServlet.do')"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
