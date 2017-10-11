<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/zhuyee.css"/>

		<link rel="stylesheet" href="css/cheshi.css" />
		<script type="text/javascript" src="js/left.js" ></script>

	</head>
	<body onload="_onload()">
		<div id="daohang" class="daohang">
			<div id=""  class="z1">
			</div>
			<div id=""  class="z2">
				<a></a>
			</div>
			
			<div id=""  class="anniu">
				<button class="an">首页</button>&nbsp;&nbsp;&nbsp;&nbsp;
				|&nbsp;&nbsp;<button class="an">邮件</button>&nbsp;&nbsp;
				|&nbsp;&nbsp;<button class="an">项目</button>&nbsp;&nbsp;
				|&nbsp;&nbsp;<button class="an">文档</button>&nbsp;&nbsp;	
				<button  value="退出"  class="tianjia"  style="margin-left: 620px;" onclick="location.href=('LoginServlet')">退出</button>
			</div>
			
		</div>
		
			<div class="ww">
			<div class="manager" id="manager1" style="background-color: #lalala;">
			
            </div>
             </div>
             
             <table  id="theadid">
             	
		<div id="guanli"  class="gunali">
			
			
			<iframe src="" name="ifrm" id="ifrm" width="1072px" height="784px";></iframe>
			
		</div>
		
		
		</table>
		 <script >
        function tian(){
        	window.open("LoginServlet");
        }
        </script>
	</body>
	
</html>
