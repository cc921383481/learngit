<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/orderdisplay.css" />
	</head>
	<body>
		<div id="div_all">
			<div class="div_list_word"><p>订单状态：</p><p id="div_list_word_right">未付款</p><button id="div_button">返回</button></div>
			<!--订单信息-->
			<div id="div_content_list01">
			<div class="div_list"><p>订单信息</p></div>
			<div class="div_list_have"><p>订单编号：</p>4563467</div>
			<div class="div_list_have"><p>支付方式：</p>在线支付</div>
			<div class="div_list_have"><p>下单时间：</p>54658767</div>
			<div class="div_list_have"><p>付款时间：</p>3546547</div>
			</div>
			<!--收货人信息-->
			<div id="div_content_list02">
			<div class="div_list"><p>收货人信息</p></div>
			<div class="div_list_have"><p>收货人姓名：</p>张浩</div>
			<div class="div_list_have"><p>地址：</p>河北省深州市</div>
			<div class="div_list_have"><p>联系电话：</p>675853423</div>
			</div>
			<!--物流信息-->
			<div id="div_content_list03">
				<div class="div_list"><p>收货人信息</p></div>
				<div class="div_list_have"><p>物流公司</P><input  class="div_input" type="text" /></div>
					<div class="div_list_have"><p>物流单号</p> <input class="div_input" type="text"/></div>
					<div id="div_list_have_button"><button id="confirm">确认发货</button></div>
			</div>
			<!--备注信息-->
			<div id="div_content_list04">
				<div class="div_list"><p>备注信息</p></div>
				<div class="div_list_have"><textarea>这是备注信息</textarea></div>
			</div>
			<!--商品详细内容-->
			<div id="div_content_list05">
				<div class="div_list">
					<div class="div_list_pro"><p>商品编号</p></div>
					<div class="div_list_pro"><p>商品名称</p></div>
					<div class="div_list_pro"><p>商品数量</p></div>
					<div class="div_list_pro"><p>商品单价（元）</p></div>
				</div>
				<div class="div_list_prodisplay">
					<div class="div_list_pro"><p>4523667</p></div>
					<div class="div_list_pro"><p>华为</p></div>
					<div class="div_list_pro"><p>1</p></div>
					<div class="div_list_pro"><p>5666</p></div>
				</div>
			</div>
			
		</div>
	</body>
</html>