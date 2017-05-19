//用户框失去焦点后验证value值
function oBlur_1() {
	var a = document.getElementsByTagName("input")[0].value;
    if (!a) { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
    } else if(a){ //用户框value值不为空
        document.getElementById("remind_1").innerHTML = "";
        document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
    }
};

//密码框失去焦点后验证value值
function oBlur_2() {
	var b = document.getElementsByTagName("input")[1].value;
    if (!b) { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_4").style.marginBottom = 1+ "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
    }else if(b.length<6) {
    	document.getElementById("remind_2").innerHTML = "密码必须大于6位";
    	document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
    	document.getElementById("change_margin_4").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
    }
    else if(b){ //密码框value值不为空
        document.getElementById("remind_2").innerHTML = "";
        document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_4").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_3").style.marginTop = 19 + "px";
    }
};
//确认密码框失去焦点后验证value值
function oBlur_3(){
	var b = document.getElementsByTagName("input")[1].value;
	var c = document.getElementsByTagName("input")[2].value;
	if(!c){
		document.getElementById("remind_3").innerHTML="请确认密码！";      document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
	}else if(c!=b){
		document.getElementById("remind_3").innerHTML="两次密码不一致！";      document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
	}else if(!b){
		document.getElementById("remind_3").innerHTML="请先输入密码";      document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
	}
	else {
		document.getElementById("remind_3").innerHTML="";
		document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
		document.getElementById("change_margin_4").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_3").style.marginTop = 19 + "px";
	}	
};
//用户框获得焦点的隐藏提醒
function oFocus_1() {
    document.getElementById("remind_1").innerHTML = "";
    document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
};
//密码框获得焦点的隐藏提醒
function oFocus_2() {
    document.getElementById("remind_2").innerHTML = "";
    document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
};
function oFocus_3() {
    document.getElementById("remind_3").innerHTML = "";
    document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_4").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_3").style.marginTop = 19 + "px";
};
//若输入框为空，阻止表单的提交
function submitTest() {
    if (!a&&!b) { //用户框value值和密码框value值都为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_4").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false; //只有返回true表单才会提交
    } else if (!a) { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        return false;
    } else if (!b) { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_4").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false;
    }else if(c!=b){
    	document.getElementById("remind_3").innerHTML="两次密码不一致！";
    	document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
    	document.getElementById("change_margin_4").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
    	return false;
    	
    }
};