var arr_input=['按消费金额排序','按订单总数排序','按消费日期排序'];

var _theadmem=[
	'操作','会员ID','用户类型','用户名','已完成订单金额(元)','已完成订单数','折扣积分','最近消费'
];
var _tbodymem=[
	['','979',' ','wxasdf01','0.01','1','  ',getNowFormatDate()],
	['','980',' ','wxasdf02','0.01','1','  ',getNowFormatDate()]
	
];

//系统当前时间
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







function _onload(){
	var downup_id=document.getElementById("downupid");
	for(var i=0;i<arr_input.length;i++){
	var up_input=document.createElement("input");
	up_input.setAttribute("type","submit");
	up_input.setAttribute("value",arr_input[i]);
	up_input.setAttribute("id","inputid"+i);
	up_input.setAttribute("onclick","sort("+i+")");
	downup_id.appendChild(up_input);
	}
	//_theadmem
	var _theadid=document.getElementById("theadid");
	var _tr=document.createElement("tr");
	_theadid.appendChild(_tr);
	for (var j=0;j<_theadmem.length;j++) {
		var _td=document.createElement("th");
		_td.setAttribute("id","_td"+j);
		_td.setAttribute("style","font-size:15px;background-color: #C0C0C0;height: 20px;border: 1px solid #A8A8A8;");
		_tr.appendChild(_td);
		var _td_text=document.createTextNode(_theadmem[j]);
		_td.appendChild(_td_text);
	}
	
	//_tbodymem
	for(var k=0;k<_tbodymem.length;k++){
		var _tbodyid=document.getElementById("tbodyid");
		var _tbody_tr=document.createElement("tr");
		_tbody_tr.setAttribute("id","_trid"+k);
		_tbodyid.appendChild(_tbody_tr);
		
		for (var m=0;m<_tbodymem[k].length;m++) {
			var _tbody_tr_td=document.createElement("td");
			_tbody_tr_td.setAttribute("style","border: 1px solid #C0C0C0;");
			_tbody_tr.appendChild(_tbody_tr_td);
			var _td_div=document.createElement("div");
			_td_div.setAttribute("style","padding-left: 10px;")
	    	_tbody_tr_td.appendChild(_td_div);
	    	if(m===0){
	    		var a_img1=document.createElement("a");
	    		a_img1.setAttribute("href","#");
	    		_td_div.appendChild(a_img1);
	    		var _div_img1=document.createElement("img");
		    	_div_img1.setAttribute("src","img/ren.png");
		    	a_img1.appendChild(_div_img1);
		    	
		    	var a_img2=document.createElement("a");
		    	a_img2.setAttribute("href","#");
		    	_td_div.appendChild(a_img2);
		    	var _div_img2=document.createElement("img");
		    	_div_img2.setAttribute("src","img/xiang.png");
		    	a_img2.appendChild(_div_img2);
	    	}
	    	if(m!=0){
	    		var _div_text=document.createTextNode(_tbodymem[k][m]);
	    		_td_div.appendChild(_div_text);
	    	}
	    	
		}
		
	}
	
	
	
}
