<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" import="java.util.*,com.neusoft.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/tianjia.css" />
</head>
<body>
<div class="div-add" id="div-add-id" >
			<div id="div-up">
				<span id="span1id">添加分类</span>
			
			</div>
			<form action="AddCateServlet" method="post">
			
			<div id="div-down">
			
				<div id="down_div1id">
					分类名称<input type="text" id="down_inputid" name="input_add" placeholder="请输入要添加的分类名称" /><span id="spanid"></span>
				</div>
				<div id="down_div2id" >
				
					上级分类
					<% 
			
						Object obj=request.getAttribute("catelist");
		     if(obj!=null){
		    	 List<Cate> cateList=(List<Cate>) obj;%>
					<select id="arr_topclass" name="add_select">
						<% 
						for(int i=0;i<cateList.size();i++){%>
						<option name="option_name" value="<%=cateList.get(i).getCid() %>"><%= cateList.get(i).getCname()%></option>
						<%} %>
					
						<%} %>
					</select>
				</div>
				<div id="down_div3id">
					<input type="submit" id="_input1id" name="button_name" value="yes"/>
					<input type="submit" id="_input2id" name="button_name" value="no"/>
				</div>
			</div>
			</form>
		</div>
</body>
</html>