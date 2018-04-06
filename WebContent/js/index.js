/*
* @Author: Administrator
* @Date:   2017-12-25 16:34:52
* @Last Modified by:   Administrator
* @Last Modified time: 2017-12-25 18:55:22
*/

// $("#pswd").bind('oninput', function(){
	
// })
$("#pswd")[0].oninput = function(){
	if($("#pswd").val() == ''){
		$("#key").addClass('key');
	}else {
		console.log($("#pswd").val());
		$("#key").removeClass('key');
	}
}

$("#text")[0].oninput = function(){
	if($("#text").val() == ''){
		$("#key1").addClass('key1');
	}else {
		console.log($("#text").val());
		$("#key1").removeClass('key1');
	}
}
