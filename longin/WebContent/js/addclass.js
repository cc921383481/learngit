var arr_addclass=[
		{'name':'添加分类','img':'img/cha1.png'}
];

var arr_topclass=['顶级分类','服饰','鞋','装','日用']

function _onload(){
	var _div_up=document.getElementById("div-up");
	var _div_down=document.getElementById("div-down");
	
	for (var i=0;i<arr_addclass.length;i++) {
		var _up_span1=document.createElement("span");
		_up_span1.setAttribute("id","span1id");
		_div_up.appendChild(_up_span1);
		var _span_text=document.createTextNode(arr_addclass[i].name);
		_up_span1.appendChild(_span_text);
		
		var _up_span2=document.createElement("span");
		_up_span2.setAttribute("id","span2id");
		var _span2_img=document.createElement("img");
		_span2_img.setAttribute("src","img/cha1.png");
		_span2_img.setAttribute("id","_span2_img_id");
		_span2_img.setAttribute("onclick","closeDiv()");
		_up_span2.appendChild(_span2_img);
		_div_up.appendChild(_up_span2);
	}
	//分类名称
	var down_div1=document.createElement("div");
	down_div1.setAttribute("id","down_div1id");
	_div_down.appendChild(down_div1);
	var down_text1=document.createTextNode("分类名称");
	var down_input=document.createElement("input");
	down_input.setAttribute("id","down_inputid");
	down_div1.appendChild(down_text1);
	down_div1.appendChild(down_input);
	
	//上级分类
	var down_div2=document.createElement("div");
	down_div2.setAttribute("id","down_div2id");
	_div_down.appendChild(down_div2);
	var down_text2=document.createTextNode("上级分类");
	var _form5=document.createElement("form");
	_form5.setAttribute("name","form5");
	
	down_div2.appendChild(down_text2);
	down_div2.appendChild(_form5);
	
	var _select_arr_topclass=document.createElement("select");
	_select_arr_topclass.setAttribute("id","arr_topclass");
//			_select_arr_topclass.setAttribute("onchange","_changeSelect(this.selectedIndex)");
	
	_form5.appendChild(_select_arr_topclass);
	//将arr_topclass数组中的数据写入select中
	var _arr_topclass=document.getElementById("arr_topclass");
	
	_arr_topclass.length=arr_topclass.length;
	for(var s = 0; s< arr_topclass.length; s++) {
		_arr_topclass.options[s].text = arr_topclass[s];
		_arr_topclass.options[s].value = arr_topclass[s];
	}
	//确认 取消
	var down_div3=document.createElement("div");
	down_div3.setAttribute("id","down_div3id");
	_div_down.appendChild(down_div3);
	var _input1=document.createElement("input");
	_input1.setAttribute("type","button");
	_input1.setAttribute("value","确认");
	_input1.setAttribute("id","_input1id");
	down_div3.appendChild(_input1);
	
	var _input2=document.createElement("input");
	_input2.setAttribute("type","button");
	_input2.setAttribute("value","取消");
	_input2.setAttribute("id","_input2id");
	down_div3.appendChild(_input2);
	
}
function closeDiv(){
	var closeid=document.getElementById("div-add-id");
	closeid.style.display="none";
	
}
