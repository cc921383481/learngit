var _thead=[
	'操作','订单状态','物流状态','订单编号','商品数量','订单金额(元)'
];
var _tbody=[
	['','已完成','已发货','5528761451','1','99'],
	['','已完成','已发货','5528761451','1','34']
	
];
function _onload(){
	//ship-head
	
	
	//ship-mid
	var _ship_mid_id=document.getElementById("ship-mid-id");
	var _ship_head_p=document.createElement("p");
	_ship_head_p.setAttribute("style","margin-top: 15px;");
	var _p_text=document.createTextNode('订单总数:'+_tbody.length);
	_ship_head_p.appendChild(_p_text);
	_ship_mid_id.appendChild(_ship_head_p);
	
	
	var input1_mid=document.createElement("input");
	input1_mid.setAttribute("id","input1id");
	input1_mid.setAttribute("type","text");
	input1_mid.setAttribute("placeholder","可以输入收件人姓名、联系电话、订单编号");
	_ship_mid_id.appendChild(input1_mid);
	//订单时间
	var _span1=document.createElement("span");
	_span1.setAttribute("id","span1id");
	_ship_mid_id.appendChild(_span1);
	_span1.innerHTML="订单时间";
	
	var input2_mid=document.createElement("input");
	input2_mid.setAttribute("id","input2id")
	input2_mid.setAttribute("type","date");
	input2_mid.setAttribute("value","2017-09-24");
	_ship_mid_id.appendChild(input2_mid);
	//到
	var _span2=document.createElement("span");
	_span2.setAttribute("id","span2id");
	_ship_mid_id.appendChild(_span2);
	_span2.innerHTML="到";
	
	var input3_mid=document.createElement("input");
	input3_mid.setAttribute("id","input3id")
	input3_mid.setAttribute("type","date");
	input3_mid.setAttribute("value","2017-09-24");
	_ship_mid_id.appendChild(input3_mid);
	//查询按钮 导出Excel
	var input4_mid=document.createElement("input");
	input4_mid.setAttribute("id","input4id")
	input4_mid.setAttribute("type","submit");
	input4_mid.setAttribute("value","查询");
	_ship_mid_id.appendChild(input4_mid);
	
	var input5_mid=document.createElement("input");
	input5_mid.setAttribute("id","input5id")
	input5_mid.setAttribute("type","submit");
	input5_mid.setAttribute("value","导出Excel");
	_ship_mid_id.appendChild(input5_mid);
	
	//ship-down
	var _theadid=document.getElementById("theadid");
	var _tr=document.createElement("tr");
	_theadid.appendChild(_tr);
	for (var i=0;i<_thead.length;i++) {
		var _td=document.createElement("th");
		_td.setAttribute("id","_td"+i);
		_td.setAttribute("style","font-size:15px;background-color: #C0C0C0;")
		_tr.appendChild(_td);
		var _td_text=document.createTextNode(_thead[i]);
		_td.appendChild(_td_text);
	}
	
	for(var j=0;j<_tbody.length;j++){
		var _tbodyid=document.getElementById("tbodyid");
		var _tbody_tr=document.createElement("tr");
		_tbody_tr.setAttribute("id","_trid"+j);
		_tbodyid.appendChild(_tbody_tr);
		
		for (var k=0;k<_tbody[j].length;k++) {
			var _tbody_tr_td=document.createElement("td");
			_tbody_tr.appendChild(_tbody_tr_td);
			var _td_div=document.createElement("div");
	    	_tbody_tr_td.appendChild(_td_div);
	    	if(k===0){
	    		var a_img1=document.createElement("a");
	    		a_img1.setAttribute("href","#");
	    		_td_div.appendChild(a_img1);
	    		var _div_img1=document.createElement("img");
		    	_div_img1.setAttribute("src","img/see.png");
		    	a_img1.appendChild(_div_img1);
		    	
		    	var a_img2=document.createElement("a");
		    	a_img2.setAttribute("href","#");
		    	_td_div.appendChild(a_img2);
		    	var _div_img2=document.createElement("img");
		    	_div_img2.setAttribute("src","img/del.png");
		    	a_img2.appendChild(_div_img2);
	    	}
	    	if(k!=0){
	    		var _div_text=document.createTextNode(_tbody[j][k]);
	    		_td_div.appendChild(_div_text);
	    	}
	    	
		}
		
	}
}	

