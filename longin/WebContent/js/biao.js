var news=[
{"title":"订单编号：","title1":"12123"},
{"title":"支付方式：","title1":"在线支付"},
{"title":"下单时间：","title1":getNowFormatDate()},
{"title":"付款时间：","title1":getNowFormatDate()},
];
var neww=[
{"titlee":"收货人信息：","title2":"1212"},
{"titlee":"地址：","title2":"北京三里屯"},
{"titlee":"联系电话：","title2":"1212131232"},
];
var newr=[
{"title":"物流公司：","title1":"1212"},
{"title":"物流单号：","title1":"北京三里屯"},
{"title":"      ","title1":"h"},
];
var dingdan=['订单信息'];
var sho=['收货人信息'];
var wul=['物流信息'];
var beizhu=['备注信息' ];
var shang=['商品编号','商品名称','商品数量','商品单价(元)' 
];
var spbh=[
{"title":"12345678","title1":"商品名称 尺码 颜色","spmc":"1","spdj":"20"},
{"title":"12345678","title1":"商品名称 尺码 颜色","spmc":"1","spdj":"20"},

];
function getNowFormatDate() {
		    var date = new Date();
		    var seperator1 = "-";
		    var seperator2 = ":";
		    var month = date.getMonth() + 1;
		    var strDate = date.getDate();
		    if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }
		    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
		            + " " + date.getHours() + seperator2 + date.getMinutes()
		            + seperator2 + date.getSeconds();
		    return currentdate;
}

function onload(){
       var ddh =document.getElementById("dingd");
          var _tr=document.createElement("tr");
          for(var i=0;i<dingdan.length;i++){
          var _td=document.createElement("th");
		  _td.setAttribute("id","_td"+i);
		  _td.setAttribute("style","font-size:15px;background-color: #C0C0C0;padding-right: 961px;padding-left: 1px;");
		  _tr.appendChild(_td);
			var _td_text=document.createTextNode(dingdan[i]);
			_td.appendChild(_td_text);
			ddh.appendChild(_tr);
			}



	var _body=document.getElementsByTagName("body")[0];
	  for(var i=0;i<news.length;i++){
	     var cc=document.getElementById("b22");
	  	 var dd=document.getElementById("b3");
	  	var _var_date=new Date(news[i].publishtime);
		
		var _div=document.createElement("div");
		
		_div.setAttribute("id","_div"+i);
		
		
		var _div_style="width:84px;height:22px;border:1px none solid blue;margin-top: 5px;"
		_div.setAttribute("style",_div_style);
		cc.appendChild(_div);
		
			var _content_p=document.createElement("a");
		_content_p.setAttribute("style","text-align: left;margin-top: 20px;");
		var _content_p_text=document.createTextNode(news[i].title);
		_content_p.appendChild(_content_p_text);
		
		cc.appendChild(_div);
		_div.appendChild(_content_p);
		_content_p.appendChild(_content_p_text)	
  }
	  //订单信息2
	     for(var i=0;i<news.length;i++){
	  	 var ddd=document.getElementById("b33");
//	  	var _var_date=new Date(news[i].publishtime);
		
		var _div=document.createElement("div");
		
		_div.setAttribute("id","_div"+i);
		
		
		var _div_style="width:500px;height:22px;border:1px none solid blue;margin-top: 5px;"
		_div.setAttribute("style",_div_style);
		dd.appendChild(_div);
		
			var _content_p=document.createElement("a");
		_content_p.setAttribute("style","text-align: left;");
		var _content_p_text=document.createTextNode(news[i].title1);
		_content_p.appendChild(_content_p_text);
		
		ddd.appendChild(_div);
		_div.appendChild(_content_p);
		_content_p.appendChild(_content_p_text)
		
       	}
	      var sh =document.getElementById("shouhuo");
          var _tr=document.createElement("tr");
          for(var i=0;i<sho.length;i++){
          var _td=document.createElement("th");
		  _td.setAttribute("id","_td"+i);
		  _td.setAttribute("style","font-size:15px;background-color: #C0C0C0;padding-right: 947px;");
		  _tr.appendChild(_td);
			var _td_text=document.createTextNode(sho[i]);
			_td.appendChild(_td_text);
			sh.appendChild(_tr);
			}
	     
	     
	     
	     
	     //收货人1
	     for(var i=0;i<neww.length;i++){
	  		 var ff=document.getElementById("shouhuo1");
	  		 
	  	    var _div=document.createElement("div");
		
		  _div.setAttribute("id","_div"+i);
		  var _div_style="width:96px;height:22px;border:1px none solid blue;margin-top: 5px;"
		  _div.setAttribute("style",_div_style);

		
		  var _content_p=document.createElement("a");
		_content_p.setAttribute("style","text-align: left;");
		var _content_p_text=document.createTextNode(neww[i].titlee);
		_content_p.appendChild(_content_p_text);
		
		ff.appendChild(_div);
		_div.appendChild(_content_p);
		_content_p.appendChild(_content_p_text);
//		shou.appendChild(_tr);
	  	}
	     // 收货人信息2
	     	for(var i=0;i<neww.length;i++){
	  		 var shouhuo=document.getElementById("shouhuo2");
	  		 
	  	    var _div=document.createElement("div");
		
		  _div.setAttribute("id","_div"+i);
		  var _div_style="width:250px;height:22px;border:1px none solid blue;margin-top: 5px;"
		  _div.setAttribute("style",_div_style);
		  shouhuo.appendChild(_div);
		
		  var _content_p=document.createElement("a");
		_content_p.setAttribute("style","text-align: left;");
		var _content_p_text=document.createTextNode(neww[i].title2);
		_content_p.appendChild(_content_p_text);
		
		shouhuo.appendChild(_div);
		_div.appendChild(_content_p);
		_content_p.appendChild(_content_p_text)
	  	}
	  	  	//物流信息
	  	var wl=document.getElementById("wuliu")
//	  	 for(var i=0;i<newr.length;i++){
//	  	var _td=document.createElement("th");
//			_td.setAttribute("id","_td"+i);
//			_td.setAttribute("style","font-size:15px;background-color: #C0C0C0;padding-right: 1038px;");
//			_tr.appendChild(_td);
//			var _td_text=document.createTextNode(beizhu[i]);
//			_td.appendChild(_td_text);
//	  	}
         var wuliu =document.getElementById("wuliu1");
          var _tr=document.createElement("tr");
        for(var i=0;i<wul.length;i++){
          var _td=document.createElement("th");
			_td.setAttribute("id","_td"+i);
			_td.setAttribute("style","font-size:15px;background-color: #C0C0C0;padding-right: 962px;");
			_tr.appendChild(_td);
			var _td_text=document.createTextNode(wul[i]);
			_td.appendChild(_td_text);
			}
	   for(var i=0;i<newr.length;i++){
	  		
			
		    var _div=document.createElement("div");
			wl.appendChild(_tr);
	  		 
	  	    var _div=document.createElement("div");
		
		  _div.setAttribute("id","_div"+i);
		  var _div_style="width:250px;height:22px;border:1px none solid blue;margin-top: 5px;"
		  _div.setAttribute("style",_div_style);
		  
		
		
		  var _content_p=document.createElement("a");
		_content_p.setAttribute("style","text-align: left;");
		var _content_p_text=document.createTextNode(newr[i].title);
		_content_p.appendChild(_content_p_text);
		  
		wuliu.appendChild(_div);
		_div.appendChild(_content_p);
		_content_p.appendChild(_content_p_text);
		
		
		
	  	}
	       //备注信息
	    var _theadid=document.getElementById("beixhu");
	    var  kuang=document.getElementById("kuang");
	   var _tr=document.createElement("tr");
	   _theadid.appendChild(_tr);
	   for(var i=0;i<beizhu.length;i++){
	  	
			var _td=document.createElement("th");
			_td.setAttribute("id","_td"+i);
			_td.setAttribute("style","font-size:15px;background-color: #C0C0C0;padding-right: 962px;");
			_tr.appendChild(_td);
			var _td_text=document.createTextNode(beizhu[i]);
			_td.appendChild(_td_text);
			
		    var _div=document.createElement("div");
		
		  _div.setAttribute("id","_div"+i);
		  var _div_style="width:1017px;height:200px;border:1px  solid blue;"
//		  _div_style.setAttribute("style","contenteditable="true"");
           var bianji=document.getElementById(_div_style);
//         bianji.contentEditable="true";
		  _div.setAttribute("style",_div_style);
		  kuang.appendChild(_div);
		
	}
	     //zuiixia
	    
	    var _theadid=document.getElementById("sp");
	    var _tr=document.createElement("tr");
	   _theadid.appendChild(_tr);
	  	for(var i=0;i<shang.length;i++){
	  	
			var _td=document.createElement("th");
			_td.setAttribute("id","_td"+i);
			_td.setAttribute("style","font-size:15px;background-color: #C0C0C0;padding-right: 192px;");
			_tr.appendChild(_td);
			var _td_text=document.createTextNode(shang[i]);
			_td.appendChild(_td_text);
	}
	     	
	   var _spbh=document.getElementById("spbh");
	   var _spbh1=document.getElementById("spbh1");
	   var _spbh2=document.getElementById("spbh2");
	   var _spbh3=document.getElementById("spbh3");
	  var _tr=document.createElement("tr");
	  for(var i=0;i<spbh.length;i++){
         var _div=document.createElement("div");
		
		  _div.setAttribute("id","_div"+i);
		  var _div_style="width:250px;height:22px;border:1px none solid blue;margin-top: 5px;"
		  _div.setAttribute("style",_div_style);
		  
		   var _content_p=document.createElement("a");
		_content_p.setAttribute("style","text-align: left;");
		var _content_p_text=document.createTextNode(spbh[i].title);

		
		_div.appendChild(_content_p);
		_content_p.appendChild(_content_p_text)
		  _spbh.appendChild(_div)
		
	  }
	  for(var i=0;i<spbh.length;i++){
         var _div=document.createElement("div");
		  _div.setAttribute("id","_div"+i);
		  var _div_style="width:250px;height:22px;border:1px none solid blue;margin-top: 5px;"
		  _div.setAttribute("style",_div_style); 
		   var _content_p=document.createElement("a");
		_content_p.setAttribute("style","text-align: left;");
		var _content_p_text=document.createTextNode(spbh[i].title1);	
		_div.appendChild(_content_p);
		_content_p.appendChild(_content_p_text)
		  _spbh1.appendChild(_div)
		
	  }
	  for(var i=0;i<spbh.length;i++){
         var _div=document.createElement("div");
		  _div.setAttribute("id","_div"+i);
		  var _div_style="width:250px;height:22px;border:1px none solid blue;margin-top: 5px;"
		  _div.setAttribute("style",_div_style); 
		   var _content_p=document.createElement("a");
		_content_p.setAttribute("style","text-align: left;");
		var _content_p_text=document.createTextNode(spbh[i].spmc);	
		_div.appendChild(_content_p);
		_content_p.appendChild(_content_p_text)
		  _spbh2.appendChild(_div)
		
	  }
	  for(var i=0;i<spbh.length;i++){
         var _div=document.createElement("div");
		  _div.setAttribute("id","_div"+i);
		  var _div_style="width:250px;height:22px;border:1px none solid blue;margin-top: 5px;"
		  _div.setAttribute("style",_div_style); 
		   var _content_p=document.createElement("a");
		_content_p.setAttribute("style","text-align: left;");
		var _content_p_text=document.createTextNode(spbh[i].spdj);	
		_div.appendChild(_content_p);
		_content_p.appendChild(_content_p_text)
		  _spbh3.appendChild(_div)
		
	  }
}