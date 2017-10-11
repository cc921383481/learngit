<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已付款订单</title>
<link rel="stylesheet" href="css/orderinfo.css" />
	</head>
	<body>
		<!---->
		<div id="div_all">
			<!--头部-->
			<form action="payMentServlet.do" method="get">
			<div id="div_head">
				<div id="div_head_right"><input type="text" id="div_head_input" placeholder="请输入要输入的内容！" ><input id="search" type="button" name="search" value="搜索"/></div>
				 
			</div>
			</form>
			<!--中部-->
			<div id="div_middle" >
			<c:forEach items="${orderlist.datas}" var="omd">
				<!--每一个小div-->
				<div class="div_middle_have" >
					<div class="middle_head"><p>订单信息</p></div>
						
					    <%-- <input type="hidden" name="searchType" value="${omd.orderlist[0].orderstatus}"/> --%>
				
						<div class="pro_name"><p>订单编号：</p><c:out value="${omd.orderlist[0].orderno}"></c:out></div>
						<div class="pro_pno"><p>商品数量：</p><c:out value="${fn:length(omd.productlist)}"></c:out></div>
				
					<div class="middle_middle"><p>收货信息</p></div>
						<div class="pro_name"><p>收货人：</p><c:out value="${omd.orderlist[0].ca[0].cname}"></c:out></div>
						<div class="pro_pno"><p>联系方式：</p><c:out value="${omd.orderlist[0].ca[0].phone}"></c:out></div>
					
					<div class="middle_bottom"><p class="middle_bottom_p">订单状态：</p><span class="word01"><c:out value="${omd.orderlist[0].orderstatusname}"></c:out></span></div>
					
					<div class="middle_a">
					<a href="orderDisplayServlet.do?orderId=${omd.orderid}&pageNo=${orderlist.pageNo}&pagesize=4">查看详情</a>
					</div>
				</div>
				</c:forEach>
			
			
	<div style="margin-top:420px;height:40px">
	共${orderlist.totalcount}条记录${orderlist.pageNo}/${orderlist.totalPageSize}页 &nbsp;
		
	<c:if test="${orderlist.pageNo>0}">
	<a href="payMentServlet.do?reqType=2&pageNo=1&pageSize=4&searchType=2">首页</a>&nbsp;
	</c:if>
	
    <a href="payMentServlet.do?reqType=2&pageNo=${orderlist.pageNo==1?orderlist.pageNo:orderlist.pageNo-1}&pageSize=4&searchType=2">上一页</a>&nbsp;
	
	<a href="payMentServlet.do?reqType=2&pageNo=${orderlist.pageNo==orderlist.totalPageSize?orderlist.pageNo:orderlist.pageNo+1}&pageSize=4&searchType=2">下一页</a>&nbsp;
	
	<a href="payMentServlet.do?reqType=2&pageNo=${orderlist.totalPageSize}&pageSize=4&searchType=2">尾页</a>
	
	第<select onchange="self.location.href=options[selectedIndex].value">
  		
  		<c:forEach begin="0" end="${orderlist.totalPageSize-1}" step="1" var="i" >
  		<c:choose>
  		<c:when test="${orderlist.pageNo==i+1 }">
  			<option value="payMentServlet.do?reqType=2&pageNo=${i+1} }&pageSize=4&searchType=2" selected="selected">${i+1}</option>
  		</c:when>
  		<c:otherwise>
  		<option value="payMentServlet.do?reqType=2&pageNo=${i+1}&pageSize=4&searchType=2" >${i+1}</option>
  		</c:otherwise>	
		</c:choose>
		</c:forEach>
	</select>页
	</div>
	</div>
		</div>
	</body>
</html>