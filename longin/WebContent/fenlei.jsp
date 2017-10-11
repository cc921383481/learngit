<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page language="java" import="java.util.*,com.neusoft.entity.*"%>
<%@ page import="com.neusoft.entity.Cate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/fenlei.css" />
</head>
<body>

 		<div class="bian">
	<form action="CateServlet" method="post">
    <table  width="98%" cellspacing="0" cellpadding="0" border="1">
     <span>商品类别   :</span><br />
    <button  value="添加分类"  class="tianjia" onclick="tian()">添加</button>
    	 
     
     
     <tr>
        <th>分类编号</th>
        <th>分类名称</th>
        <th>上级分类</th>
        <th>操作</th>
      </tr>  
     
      <tbody>
    <%response.setContentType("text/html;charset=utf-8");
			         Object obj=request.getAttribute("cates");
					 if(obj!=null){
						PageModel<Cate> pageModel=(PageModel<Cate>)obj;
						for(int i=0;i<pageModel.getDatas().size();i++){
						Cate pmd=pageModel.getDatas().get(i);%>
   
        <tr>
          <td><%=pmd.getCid() %></td>
          <td><%=pmd.getCname() %></td>
          <td><%=pmd.getPid() %></td>
          <td><a href="UpdateCateservlet?getcid=<%=pmd.getCid()%>">修改</a>&nbsp;&nbsp;&nbsp;
							<a href="CateServlet?reqType=4&delet_cid=<%=pmd.getCid()%>">删除</a></td>
        </tr>
        <% }%>
        </tbody>
        </table>
        <div id="div12id">
	共<%=pageModel.getTotalcount() %>条记录<%=pageModel.getPageNo() %>/<%=pageModel.getTotalPageSize() %>页 &nbsp;
		
	<%if(pageModel.getPageNo()>0  ){%>
	<a href="CateServlet?reqType=2&pageNo=1&pageSize=10">首页</a>&nbsp;<%}%>
	
    <a href="CateServlet?reqType=2&pageNo=<%=pageModel.getPageNo()==1 ? pageModel.getPageNo() : pageModel.getPageNo()-1 %>&pageSize=10">上一页</a>&nbsp;
	
	<a href="CateServlet?reqType=2&pageNo=<%=pageModel.getPageNo()==pageModel.getTotalPageSize() ? pageModel.getPageNo() :pageModel.getPageNo()+1 %>&pageSize=5">下一页</a>&nbsp;
	
	<a href="CateServlet?reqType=2&pageNo=<%=pageModel.getTotalPageSize() %>&pageSize=10">尾页</a>
					          
	第<select onchange="self.location.href=options[selectedIndex].value">
  		<%
  		if(pageModel!=null){
  			int _totalPageSize=pageModel.getTotalPageSize();
  			for(int i=0;i<_totalPageSize;i++){
  				if(pageModel.getPageNo()==(i+1)){%>
  					<option value="CateServlet?reqType=2&pageNo=<%=i+1 %>&pageSize=10" selected="selected"><%=(i+1) %></option>
  				<%}else{ %>
  					 <option value="CateServlet?reqType=2&pageNo=<%=i+1 %>&pageSize=10" ><%=(i+1)%></option>
  				<%}
  			}
  		
  		}
  	%>
			</select>页
			<% }
				%>
       </form>
        </div>
        <script >
        function tian(){
        	window.open("tianjia.jsp");
        }
        </script>
</body>

</html>
