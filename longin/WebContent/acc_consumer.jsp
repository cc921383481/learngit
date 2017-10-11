<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员信息管理</title>
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
		<h3>会员信息管理</h3>
		<input type="button" id="input2" name="addinput" value="添加会员" onclick="location.href=('addacc_consumer.jsp')"/>
		<form action="consumerServlet.do" method="post">
			<table border='1' width='800px' cellpadding="0px" cellspacing="0px">
				<thead>
				<tr>
					<th>操作</th>
					<th>会员ID</th>
					<th>用户类型</th>
					<th>用户名</th>
					<th>用户昵称</th>
					<th>已完成订单总额(元)</th>
					<th>已完成订单数(单)</th>
					<th>最近消费时间</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${consumers.datas}" var="cmd" varStatus="varSta">
					<tr>
						<td>
							<a href="consumerServlet.do?reqType=4&check_id=${cmd.id}"><img src="img/ren.png"/></a>
							<a href="UpdateConsumerServlet?getid=${cmd.id}"><img src="img/xiang.png"/></a>
						</td>
						<td>${cmd.id}</td>
						<td>买家</td>
						<td>${cmd.loginname}</td>
						<td>${cmd.nickname}</td>
						<td>${cmd.money}</td>
						<td>0</td>
						<td>${cmd.lasttime}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
	共${consumers.totalcount}条记录${consumers.pageNo}/${consumers.totalPageSize}页 &nbsp;
		
	<c:if test="${consumers.pageNo>0}">
	<a href="consumerServlet.do?reqType=2&pageNo=1&pageSize=5">首页</a>&nbsp;
	</c:if>
	
    <a href="consumerServlet.do?reqType=2&pageNo=${consumers.pageNo==1?consumers.pageNo:consumers.pageNo-1}&pageSize=5">上一页</a>&nbsp;
	
	<a href="consumerServlet.do?reqType=2&pageNo=${consumers.pageNo==consumers.totalPageSize?consumers.pageNo:consumers.pageNo+1}&pageSize=5">下一页</a>&nbsp;
	
	<a href="consumerServlet.do?reqType=2&pageNo=${consumers.totalPageSize}&pageSize=5">尾页</a>
	
	第<select onchange="self.location.href=options[selectedIndex].value">
  		
  		<c:forEach begin="0" end="${consumers.totalPageSize-1}" step="1" var="i" >
  		<c:choose>
  		<c:when test="${consumers.pageNo==i+1 }">
  			<option value="consumerServlet.do?reqType=2&pageNo=${i+1} }&pageSize=5" selected="selected">${i+1}</option>
  		</c:when>
  		<c:otherwise>
  		<option value="consumerServlet.do?reqType=2&pageNo=${i+1}&pageSize=5" >${i+1}</option>
  		</c:otherwise>	
		</c:choose>
		</c:forEach>
	</select>页
		</form>
	</body>
</html>
