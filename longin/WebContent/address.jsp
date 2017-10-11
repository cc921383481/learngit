<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/cate.css" />
</head>
<body>
    <form action="addressServlet.do" method="post">
	<div class="div-add" id="div-add-id" >
		<div id="div-up">
			<span id="span1id">地址</span>
			<span id="span2id"><a><img src="img/cha1.png" onclick="closeDiv()"></a></span>
		</div>
		<div id="div-down">
			<div id="down_div1id">
				<div id="down_div2id">
					<input type="button" id="_input1id" name="addcate" value="添加地址"  onclick="location.href=('addAddressServlet.do')"/>
				</div>
				
				<div id="div11id">
				；
					<table   cellpadding="0px" cellspacing="0px"  >
						<thead>
							<tr>
								<th><div>编号</div></th>
								<th><div>上级地址名</div></th>
								<th><div>地址名</div></th>
								<th><div>操作</div></th>
							</tr>
						</thead>
						<tbody >
				<c:forEach items="${addresss.datas}" var="asd" varStatus="varSta">
						<tr>
						<td><div>${asd.id}</div></td>
						<td><div>${asd.shname}</div></td>
						<td><div>${asd.sname}</div></td>
						<td><div>
						<a href="updateAddressServlet.do?getid=${asd.id }">编辑</a>&nbsp;&nbsp;&nbsp;
						<a href="addressServlet.do?reqType=4&delet_id=${asd.id }">删除</a>
						</div></td>
						</tr>
			</c:forEach>
						</tbody>
					</table>
				</div>
		<div id="div12id">
	共${addresss.totalcount}条记录${addresss.pageNo}/${addresss.totalPageSize}页 &nbsp;
		
	<c:if test="${addresss.pageNo>0}">
	<a href="addressServlet.do?reqType=2&pageNo=1&pageSize=5">首页</a>&nbsp;
	</c:if>
	
    <a href="addressServlet.do?reqType=2&pageNo=${addresss.pageNo==1?addresss.pageNo:addresss.pageNo-1}&pageSize=5">上一页</a>&nbsp;
	
	<a href="addressServlet.do?reqType=2&pageNo=${addresss.pageNo==addresss.totalPageSize?addresss.pageNo:addresss.pageNo+1}&pageSize=5">下一页</a>&nbsp;
	
	<a href="addressServlet.do?reqType=2&pageNo=${addresss.totalPageSize}&pageSize=5">尾页</a>
	
	第<select onchange="self.location.href=options[selectedIndex].value">
 
  		<c:forEach begin="0" end="${addresss.totalPageSize-1}" step="1" var="i" >
  		<c:choose>
  		<c:when test="${addresss.pageNo==i+1 }">
  			<option value="addressServlet.do?reqType=2&pageNo=${i+1} }&pageSize=5" selected="selected">${i+1}</option>
  		</c:when>
  		<c:otherwise>
  		<option value="addressServlet.do?reqType=2&pageNo=${i+1}&pageSize=5" >${i+1}</option>
  		</c:otherwise>	
		</c:choose>
		</c:forEach>
			</select>页
		</div>
			</div>
			
		</div>
	</div>
	</form>
	
	<script>
		function closeDiv(){
		var closeid=document.getElementById("div-add-id");
		closeid.style.display="none";
		}
		function deleteJobDetail(){
		     if(window.confirm('你确定要删除吗')){
		          //后台删除数据方法
		           return true;
		      }else{
		          return false;
		      }
		  }
	</script>
</body>
</html>