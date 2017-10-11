var _ulnorm=[
	'商品编号','现有库存','库存调节','销售价格'
];
var arr_normclass=[
		{'name':'添加规格商品','img':'img/cha1.png'}
];



function _onload(){
	//normhead
	var _headid=document.getElementById("headid");
	for (var i=0;i<arr_normclass.length;i++) {
		var _up_span1=document.createElement("span");
		_up_span1.setAttribute("id","span1id");
		_headid.appendChild(_up_span1);
		var _span_text=document.createTextNode(arr_normclass[i].name);
		_up_span1.appendChild(_span_text);
		
		var _up_span2=document.createElement("span");
		_up_span2.setAttribute("id","span2id");
		var _span2_img=document.createElement("img");
		_span2_img.setAttribute("src","img/cha1.png");
		_span2_img.setAttribute("id","_span2_img_id");
		_span2_img.setAttribute("onclick","closeDiv()");
		_up_span2.appendChild(_span2_img);
		_headid.appendChild(_up_span2);
	}
	
	
	//normmid
	var _ul=document.getElementById("ul");
	for(var j=0;j<_ulnorm.length;j++){
		var _li=document.createElement("li");
		_li.setAttribute("class","li");
		_ul.appendChild(_li);
		
		var _li_p=document.createElement("p");
		_li_p.setAttribute("class","p");
		_li_p.setAttribute("id","id_p"+j);
		_li.appendChild(_li_p);
		var _li_p_text=document.createTextNode(_ulnorm[j]);
		_li_p.appendChild(_li_p_text);
	}
	//
	var _right_id=document.getElementById("normmid-right-id");
	for (var k=0;k<_ulnorm.length;k++) {
		var _div_right=document.createElement("div");
		_div_right.setAttribute("class","right-div");
		_div_right.setAttribute("id","right-id"+k);
		_right_id.appendChild(_div_right);
		if(k===0 || k===1 || k===3){
			var _inputid=document.createElement("input");
			_inputid.setAttribute("id","_inputid"+k);
			
			_div_right.appendChild(_inputid);
		}
		if(k===2){
			var input_radio1=document.createElement("input");
	    	input_radio1.setAttribute("type","radio");
	    	input_radio1.setAttribute("name","pic");
	    	_div_right.appendChild(input_radio1);
	    	var radio1=document.createTextNode("增加");
	    	_div_right.appendChild(radio1);
	    	
	    	var input_radio2=document.createElement("input");
	    	input_radio2.setAttribute("type","radio");
	    	input_radio2.setAttribute("name","pic");
	    	input_radio2.setAttribute("style","margin-left: 40px;");
	    	_div_right.appendChild(input_radio2);
	    	var radio2=document.createTextNode("减少");
	    	_div_right.appendChild(radio2);
	    	
	    	var _inputid=document.createElement("input");
			_inputid.setAttribute("id","_inputid"+k);
			_div_right.appendChild(_inputid);
		}
		
	}
	var _right_id3=document.getElementById("_inputid3");
	_right_id3.placeholder="不填写，即使用商品默认价格";
	//确认 取消
	var _downid=document.getElementById("downid");
		var _input1=document.createElement("input");
		_input1.setAttribute("type","button");
		_input1.setAttribute("value","确认");
		_input1.setAttribute("id","_input1id");
		_downid.appendChild(_input1);
		
		var _input2=document.createElement("input");
		_input2.setAttribute("type","button");
		_input2.setAttribute("value","取消");
		_input2.setAttribute("id","_input2id");
		_downid.appendChild(_input2);
	
}
function closeDiv(){
	var closeid=document.getElementById("normid");
	closeid.style.display="none";
	
}