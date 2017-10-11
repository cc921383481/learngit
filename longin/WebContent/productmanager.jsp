<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" import="java.util.*,com.neusoft.entity.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
		<link rel="stylesheet" href="css/productmanager.css" />
		<!--<script type="text/javascript" src="js/productmanager.js" ></script>-->
	</head>
	<body >
	<div class="product">
			<div id="div-up">你的位置：商品管理</div>
			<form action="ProductServlet" method="post"  name="frm">
			<div id="div-mid">
				<span><input type="button" value="添加" id="inp1" onclick="location.href=('productlist.jsp')"/></span>
				<span><input  type="submit" value="删除" id="inp2"  onclick="checkdel(frm.delid,frm)"/></span>
				<span><input type="button" value="回收站" id="inpc"/></span>
				<span><input type="text"  placeholder="商品编号/名称" class="inpt"/></span>
				<span><input type="submit" value="搜索" id="inps"/></span>
			</div>
			<div id="div-down">
					<table cellpadding="0px" cellspacing="0px" border="1" width="98%">
							<thead id="theadid">
								<tr>
									<th id="_td0"><input type="checkbox" id="checkall" class="noborder" name="checkbox" onclick="CheckAll(frm.delid,frm.checkbox)"/></th>
									<th id="_td1">编号</th>
									<th id="_td2">商品名称</th>
									<th id="_td3">商品图片</th>
									<th id="_td4">商品详情</th>
									<th id="_td7">商品价格</th>
									<th id="_td5">上架</th>
									<th id="_td6">操作</th>
								</tr>
							</thead>
							<tbody id="tbodyid">
							<c:forEach items="${products.datas}" var="pmd" varStatus="status">
								<tr>
									<td id="td0"><div><input name="delid" type="checkbox" class="noborder" value="${pmd.id}"></div></td>
									<td id="td1"><div>${pmd.id}</div></td>
									<td id="td2"><div>${pmd.pname}</div></td>
									<td id="td3"><div><img src="${pmd.pic}" style="width: 80px;height: 80px;"/></div></td>
									<td id="td4"><div>${pmd.pdetail}</div></td>
									<td id="td7"><div>${pmd.price}</div></td>
									<td id="td5"><div>${pmd.online}</div></td>
									<td id="td6"><div><a href="UpProductServlet?getid=${pmd.id}">编辑<img src="img/xiu.png"/></a>&nbsp;&nbsp;&nbsp;<a href="ProductServlet?reqType=4&delet_id=${pmd.id}">删除<img src="img/shanchu.png"/></a></div></td>
								</tr>
							</c:forEach>
							</tbody>
					</table>
					共${products.totalcount}条记录${products.pageNo}/${products.totalPageSize}页 &nbsp;
		
	<c:if test="${products.pageNo>0}">
	<a href="ProductServlet?reqType=2&pageNo=1&pageSize=5">首页</a>&nbsp;
	</c:if>
	
    <a href="ProductServlet?reqType=2&pageNo=${products.pageNo==1?products.pageNo:products.pageNo-1}&pageSize=5">上一页</a>&nbsp;
	
	<a href="ProductServlet?reqType=2&pageNo=${products.pageNo==products.totalPageSize?products.pageNo:products.pageNo+1}&pageSize=5">下一页</a>&nbsp;
	
	<a href="ProductServlet?reqType=2&pageNo=${products.totalPageSize}&pageSize=5">尾页</a>
	
	第<select onchange="self.location.href=options[selectedIndex].value">
  		
  		<c:forEach begin="0" end="${products.totalPageSize-1}" step="1" var="i" >
  		<c:choose>
  		<c:when test="${products.pageNo==i+1 }">
  			<option value="ProductServlet?reqType=2&pageNo=${i+1} }&pageSize=5" selected="selected">${i+1}</option>
  		</c:when>
  		<c:otherwise>
  		<option value="ProductServlet?reqType=2&pageNo=${i+1}&pageSize=5" >${i+1}</option>
  		</c:otherwise>	
		</c:choose>
		</c:forEach>
			</select>页
			</div>
			<div id="ch" style="display:none">
                <input name="delid" type="checkbox" value="0">
            </div>
            <!-- 一层ch用于放置隐藏的checkbox控件，因为当表单中只是一个checkbox控件时，应用javascript获得其length属性值为undefine -->
		</form>
			</div>
	<script type="text/javascript">
	 function CheckAll(elementsA, elementsB){
	        for (i = 0; i < elementsA.length; i++) {
	            elementsA[i].checked = true;
	        }
	        if (elementsB.checked == false) {
	            for (j = 0; j < elementsA.length; j++) {
	                elementsA[j].checked = false;
	            }
	        }
	    }
	 //判断用户是否选择了要删除的记录，如果是，则提示“是否删除”；否则提示“请选择要删除的记录”
    function checkdel(delid, formname) {
        var flag = false;
        for (i = 0; i < delid.length; i++) {
            if (delid[i].checked) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            alert("请选择要删除的记录！");
            return false;
        } else {
            if (confirm("确定要删除吗？")) {
                formname.submit();
            }
        }
    }  
	</script>
	</body>
</html>