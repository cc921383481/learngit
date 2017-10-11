<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page language="java" import="java.util.*,com.neusoft.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/upcate.css" />
</head>
<body>
		<div class="div-add" id="div-add-id" >
			<div id="div-up">
				<span id="span1id">编辑分类</span>
				<span id="span2id"><a><img src="img/cha1.png" onclick="closeDiv()"></a></span>
			</div>
			<%  
				Object obj=request.getAttribute("selectList");
				Object obj_cid=request.getAttribute("getcid");
				if(obj!=null){
					if(obj_cid!=null){
					 List<Cate> cateList=(List<Cate>) obj;
					 int getcid=(Integer)obj_cid;
					 String getcname="as";
					 for(int i=0;i<cateList.size();i++){
						 if(cateList.get(i).getCid()==getcid){
							 getcname=cateList.get(i).getCname();
						 }
					 } %>
	
			<form action="UpdateCateservlet" method="post">
			<div id="div-down">
				<div id="down_div1id">
					<div id="div11id">分类名称<input type="text" id="down_inputid1"  name="update_input"  placeholder="请输入修改的分类名称"/></div>
					<div id="div2id">上级分类<select id="down_inputid2" name="select_partent">
					
				<%for(int i=0;i<cateList.size();i++){ %>
					<option value="<%=cateList.get(i).getCid()%>"><%=cateList.get(i).getCname() %></option>
				<%} %>
					</select></div>
				</div>
				
				<div id="down_div2id">
					<input type="submit" id="_input1id" name="button_name" value="yes"/>
					<input type="submit" id="_input2id"  name="button_name" value="no"/>					
				    
				</div>
			</div>
			<input type="hidden" name="type" value="${getcid}" />
			</form>
			<%} 
		 }%>
		</div>
</body>
</html>