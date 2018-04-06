<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/changePwd.css">
<title></title>

<body>
	<div class="context">
    <form class="form-horizontal" action="updatePwdchangePwd.action" method="post">
      <fieldset>
        <div id="legend" class="">
          <legend class="title">修改密码</legend>
        </div>
      <div class="control-group">

            <!-- Text input-->
            <label class="control-label" for="input01">请输入原密码：</label>
            <div class="controls controls1">
              <input placeholder="原密码" id="oldPwd" class="input-xlarge" type="text">
              <p class="help-block" id="oldPwdhelp">&nbsp;&nbsp;原密码错误</p>
            </div>
          </div>

      <div class="control-group">

            <!-- Text input-->
            <label class="control-label" for="input01">请输入新密码：</label>
            <div class="controls controls1">
              <input placeholder="新密码" name="newPwd" id="newPwd" class="input-xlarge" type="text">
              <p class="help-block" id="newPwdhelp">&nbsp;&nbsp;请输入密码</p>
            </div>
          </div>
      <div class="control-group">

            <!-- Text input-->
            <label class="control-label" for="input01">请再次输入密码：</label>
            <div class="controls controls1">
              <input placeholder="确认密码" id="newRePwd" class="input-xlarge" type="text">
              <p class="help-block" id="newRePwdhelp">&nbsp;&nbsp;两次密码不符</p>
            </div>
          </div>
          <div class="control-group">
            <!-- Button -->
            <div class="controls controlsOK">
              <button class="btn btn-success">确定</button>
            </div>

            <!-- Button -->
            <div class="controls controlsBack">
              <button class="btn btn-default">返回</button>
            </div>
          </div>
          
      </fieldset>
    </form> 
  </div>
  </body>
  <script type="text/javascript">
  	console.log("aaa");
  	var flag = true;
	$("#oldPwd").blur(function(){
		var oldPwd = $(this).val();
		$.ajax({
			url : 'checkPwdchangePwd.action',
			type : 'post',
			data : {'oldPwd':oldPwd},
			dataType : "json",
			success: function(data) {
				console.log("成功啦")
				console.log(data);
				var a = false;
				if(data ==a){
					//我要把提示显示出来
					//$('#oldPwdhelp').style.display="inline";
					$("#oldPwd").css("background-color","#FFCCFF");
					//$("#oldPwdhelp").css("display","#inline");
				}else{
					$("#oldPwd").css("background-color","#FFFFFF");
				}
				
			}
		}); 
	});
	$("#newPwd").blur(function(){
		var newPwd = $(this).val();
		//判断长度
		if(newPwd==$("#oldPwd").val()){
			$("#newPwdhelp").css("background-color","#FFCCFF");
			flag = false;
		}else{
			$("#newPwdhelp").css("background-color","#FFFFFF");
			flag = true;
		}
	});
	$("#newRePwd").blur(function(){
		console.log("#newRePwd");
		//判断两次密码是否相等
		var newPwd = $(this).val();
		if(newPwd!=$("#newPwdhelp").val()){
			$("#newRePwdhelp").css("background-color","#FFCCFF");
			flag = false;
		}else{
			$("#newRePwdhelp").css("background-color","#FFFFFF");
			flag = true;
		}
	});
  </script>
	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/waterbubble.js" type="text/javascript"></script>


</html>