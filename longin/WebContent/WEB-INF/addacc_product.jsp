<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加卖家</title>
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
	<!--<h3>查看会员信息</h3> -->
		<form action="addAccProductServlet.do" method="post">
			<table cellpadding="0" cellspacing="0" border="1" width="800px">
				<tr>
					<td class="td1">用户名:</td>
					<td class="td2"><input type="text" name="loginname" /></td>
				</tr>
				<tr>
					<td class="td1">密码:</td>
					<td class="td2"><input type="text" name="password" /></td>
				</tr>
				<%-- <tr>
					<td class="td1">注册时间:</td>
					<td class="td2"><input type="text" name="registertime" value="${accProduct.registertime}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="td1">最后登录时间:</td>
					<td class="td2"><input type="text" name="lastlogintime" value="${accProduct.lastlogintime}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="td1">IP地址:</td>
					<td class="td2"><input type="text" name="ip" value="${accProduct.ip}" readonly="readonly"/></td>
				</tr> --%>
				<tr>
					<td colspan="2">
					<input type="submit" id="input1" name="sub" value="确认" />
					<input type="submit" id="input2" name="sub" value="取消" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
