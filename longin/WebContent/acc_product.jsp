<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
	table{
		text-align: center;
	}
	#input2{
		/*margin-left: 50px;*/
		height: 35px;
 		margin-bottom: 10px;
	}
		</style>
	</head>
	<body>
		<h3>卖家信息管理</h3>
		<input type="button" id="input2" name="addinput" value="添加卖家" onclick="location.href=('addacc_product.jsp')"/>
		<form action="accProductServlet.do" method="post">
			<table border='1' width='800px' cellpadding="0px" cellspacing="0px">
				<thead>
				<tr>
					<th>操作</th>
					<th>会员ID</th>
					<th>用户类型</th>
					<th>用户名</th>
					<th>密码</th>
					<th>注册时间</th>
					<th>最后登录时间</th>
					<th>IP地址</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${accProducts.datas}" var="cmd" varStatus="varSta">
					<tr>
						<td>
							<a href="accProductServlet.do?reqType=4&delete_id=${cmd.id}"><img src="img/cha.png"/></a>
							<a href="updateAccProductServlet.do?getid=${cmd.id}"><img src="img/xiu.png"/></a>
						</td>
						<td>${cmd.id}</td>
						<td>卖家</td>
						<td>${cmd.loginname}</td>
						<td>${cmd.password}</td>
						<td>${cmd.registertime}</td>
						<td>${cmd.lastlogintime}</td>
						<td>${cmd.ip}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
	共${accProducts.totalcount}条记录${accProducts.pageNo}/${accProducts.totalPageSize}页 &nbsp;
		
	<c:if test="${accProducts.pageNo>0}">
	<a href="accProductServlet.do?reqType=2&pageNo=1&pageSize=5">首页</a>&nbsp;
	</c:if>
	
    <a href="accProductServlet.do?reqType=2&pageNo=${accProducts.pageNo==1?accProducts.pageNo:accProducts.pageNo-1}&pageSize=5">上一页</a>&nbsp;
	
	<a href="accProductServlet.do?reqType=2&pageNo=${accProducts.pageNo==accProducts.totalPageSize?accProducts.pageNo:accProducts.pageNo+1}&pageSize=5">下一页</a>&nbsp;
	
	<a href="accProductServlet.do?reqType=2&pageNo=${accProducts.totalPageSize}&pageSize=5">尾页</a>
	
	第<select onchange="self.location.href=options[selectedIndex].value">
  		
  		<c:forEach begin="0" end="${accProducts.totalPageSize-1}" step="1" var="i" >
  		<c:choose>
  		<c:when test="${accProducts.pageNo==i+1 }">
  			<option value="accProductServlet.do?reqType=2&pageNo=${i+1} }&pageSize=5" selected="selected">${i+1}</option>
  		</c:when>
  		<c:otherwise>
  		<option value="accProductServlet.do?reqType=2&pageNo=${i+1}&pageSize=5" >${i+1}</option>
  		</c:otherwise>	
		</c:choose>
		</c:forEach>
	</select>页
		</form>
	</body>
	</body>
</html>