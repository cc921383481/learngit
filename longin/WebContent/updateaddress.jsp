<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
	<link rel="stylesheet" href="css/addclass.css" />
	<!-- script type="text/javascript" src="js/addclass.js" ></script> -->
</head>
<body>
		<div class="div-add" id="div-add-id" >
			<div id="div-up">
				<span id="span1id">修改地址</span>
				<span id="span2id"><a><img src="img/cha1.png" onclick="closeDiv()"></a></span>
			</div>
			<form action="updateAddressOutServlet.do" method="post">
			<input type="hidden" name="type" value="${address.id}"/>
			<div id="div-down">
					
				<div id="down_div1id">
					地址名称<input type="text" id="down_inputid" name="_text"  value="${address.sname }"/><span id="spanid"></span>
				</div>
				<div id="down_div2id" >
					上级地址
					
					<select id="arr_topclass" name="add_select">
					
					<c:forEach items="${addressList}" var="add" varStatus="varSta">
						<option name="option_name" value="${add.id}">${add.name}</option>
					</c:forEach>	
					</select>
				</div>
				<div id="down_div3id">
					<input type="submit" id="_input1id" name="sub" value="确认"/>
					<input type="submit" id="_input2id" name="sub" value="取消"/>
				</div>
			</div>
			</form>
		</div>
		<script>
			function closeDiv(){
				var closeid=document.getElementById("div-add-id");
				closeid.style.display="none";
			}
		</script>
	</body>
</html>