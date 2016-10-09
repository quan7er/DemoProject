function deleteHandle(eleId,url) {	// 进行删除的控制
	var idInfo = "" ;	// 这是最终要删除的数据
	var obj = document.all(eleId) ;
	if (obj.length == undefined) {	// 不是一个数组，是一个单独的数据
		if(obj.checked) {	// 有选项被选中
			idInfo += obj.value + "|" ;
		}
	} else {
		for (var x = 0 ; x < obj.length ; x ++) {
			if(obj[x].checked) {	// 有选项被选中
				idInfo += obj[x].value + "|" ;
			}
		}
	}
	if (idInfo == "") {	// 没有选择中要删除的数据
		alert("您还未选择任何要删除的数据，请先选择！") ;
	} else {
		if (window.confirm("您确定要删除这些数据吗？")) {
			window.location = url + "?ids=" + idInfo ;
		}
	} 
}
function selectAll(eleId,selId) {
	var obj = document.all(eleId) ;
	if (obj.length == undefined) {	// 不是一个数组，是一个单独的数据
		obj.checked = document.getElementById(selId).checked ;
	} else {
		for (var x = 0 ; x < obj.length ; x ++) {
			obj[x].checked = document.getElementById(selId).checked ;
		}
	}
} 

function goTime() {	// 倒计时跳转处理
	var mt = parseInt(document.getElementById("mytime").innerHTML) ;
	mt -- ;	// 时间减少
	if (mt == 0) {	// 进行跳转
		window.location = goUrl ;
	} else {
		document.getElementById("mytime").innerHTML = mt ;
		setTimeout(goTime,1000) ;	// 每一秒触发一次
	}
}
function validateRegex(eleId,regex) {
	var obj = document.getElementById(eleId) ;
	if (obj.value == "") {
		obj.className = "wrong" ;
		return false ;
	} else {
		if (regex.test(obj.value)) {
			obj.className = "right" ;
			return true ;
		} else {
			obj.className = "wrong" ;
			return false ;
		}
	}
}
function validateEmpty(eleId) {
	var obj = document.getElementById(eleId) ;
	if (obj.value == "") {
		obj.className = "wrong" ;
		return false ;
	} else {
		obj.className = "right" ;
		return true ;
	}
}