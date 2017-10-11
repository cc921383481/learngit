<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑商品</title>
<link rel="stylesheet" href="css/updateproduct.css" />
	 <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	</head>
	<body >
	<form action="UpProductOutServlet" method="post">
		<div class="productupdate">
			<div class="listhead">编辑商品</div>
			<div class="listdown">
				<div class="listdown-left">
					<ul id="ulproduct">
						<li><p id="id_p0">商品名称</p></li>
						<li><p id="id_p1">所属类别</p></li>
						<li><p id="id_p2">货号</p></li>
						<li><p id="id_p3">规格</p></li>
						<li><p id="id_p4">上传照片</p></li>
						<li><p id="id_p5">商品价格</p></li>
						<li><p id="id_p6">点击数</p></li>
						<li><p id="id_p7">是否推荐</p></li>
						<li><p id="id_p8">是否降价</p></li>
						<li><p id="id_p9">是否上线</p></li>
						<li><p id="id_p10">商品详情</p></li>
						<li></li>
					</ul>
				</div>
			
				<div class="listdown-right" id="listdown-right-id">
					<div id="right-id0"><input type='text' name="pname" value="${product.pname}"/><span>*</span></div>
					<div id="right-id1"><select id="sys" name="sel1" value = ""><option>${product.cid}</option></select>
										<select id="sub" name="sel2"><option>${product.id}</option></select></div>
					<div id="right-id2"><input type='text'/ name="pno" value="${product.pno}" ><span>*</span></div>
					<div id="right-id3"><select id="sys_size"  name="sel3"><option>1</option></select></div>
					<div id="right-id4"><input type='file'/ name="picture"></div>
					<div id="right-id5"><input type='text'/ name="price"><span>*</span></div>
					<div id="right-id6"><input type='text' name="count"/></div>
					<div id="right-id7"><input type='radio' name="picon1" value="true"/>是&nbsp;&nbsp;&nbsp;<input type='radio' name="picon1" value="false"/>否</div>
					<div id="right-id8"><input type='radio' name="picon2" value="true"/>是&nbsp;&nbsp;&nbsp;<input type='radio' name="picon2" value="false"/>否</div>
					<div id="right-id9"><input type='radio' name="picon3" value="true"/>是&nbsp;&nbsp;&nbsp;<input type='radio' name="picon3" value="false"/>否</div>
					<div id="right-id10"><textarea name="pdetail" ></textarea></div>
					<!-- <div>
					//添加id的隐藏域
					<input type='hidden' name='id' value='"+contact.getId()+"'/>";
				    </div> -->
					<button id="_input1id" type="submit" value="true" name="_button">确认</button>
					<button id="_input2id" type="submit" value="false" name="_button">取消</button>
					</div>
				</div>
	
			</div>
			<script>
          		CKEDITOR.replace("pdetail");
          	</script>
	
			</form>
	</body>
</html>