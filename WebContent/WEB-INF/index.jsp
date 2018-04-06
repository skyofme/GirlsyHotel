<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//  basePath= http://localhost:8080/SSH_Demo01/
%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>酒店后台管理系统</title>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css" />
<link rel="stylesheet" href="<%=basePath%>css/font-awesome.css" />
<link rel="stylesheet" href="<%=basePath%>css/index.css" />
<link rel="stylesheet" href="<%=basePath%>css/mm-vertical.css" />

<link rel="stylesheet" href="<%=basePath%>css/component1.css" />

<style>
html {
	height: 100%;
}

body {
	height: 100%;
}

.container-fluid {
	height: auto;
}

.main {
	/* width: 100%; */
	
}
/* @media screen and (max-width: 900px) {
	.nav-left {
		display: none;
	}
} */

</style>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/metisMenu.js"></script>

<script src="<%=basePath%>js/classie.js"></script>
<script src="<%=basePath%>js/modalEffects.js"></script>
</head>
<body onload="init1()">
	<%
		Object o = (Object) session.getAttribute("init1");
		if (o != null) {
	%>
	${init1 }
	<%
		}
		session.removeAttribute("init1");
	%>
	<div style="height: 100%; background-color: #3E3E3E;">
		<div class="container-fluid">
			<!--顶部导航-->
			<nav class="nav-top">
				<div class="navbar-header">
					<a class="navbar-brand" href="index.jsp"><strong><i
							class="icon fa fa-plane"></i> GIRLSY HOTEL</strong></a>

					<div id="sideNav" href="index.jsp">
						<i class="fa fa-bars icon"></i>
					</div>
				</div>

			</nav>
		<!--左侧导航-->
		<nav class="nav-left sidebar-nav">
			<ul class="metismenu" id="menu">
				<!-- 总经理拥有的界面 -->
				<li class="active"><a href="javascript:void(0);" aria-expanded="false"
					data-uri="data"><i class="fa fa-android"></i>查看数据</a></li>
				<c:if test="${otherAuthEmp or selectEmp}">
					<li><a href="javascript:void(0);" class="has-arrow" aria-expanded="false"
					data-uri="none"><i class="fa fa-android"></i>员工管理</a>
					<ul aria-expanded="false">
					<c:if test="${selectEmp}">
						<li><a href="javascript:void(0);" aria-expanded="false" aria-disabled="true"
						data-uri="empAll"><i class="fa fa-qrcode" id="allemp"></i>查询所有员工 </a></li>
					</c:if>
					<c:if test="${otherAuthEmp}">
						<li><a href="javascript:void(0);" aria-expanded="false" aria-disabled="true"
						data-uri="doAdd"><i class="fa fa-qrcode"></i>添加员工</a></li>
					</c:if>
					</ul></li>
				</c:if>
				<c:if test="${otherAuthRoomType or selectRoomType or otherAuthRoom or selectRoom}">
					<li><a class="has-arrow" href="javascript:void(0);" aria-expanded="false"
					data-uri="none"><i class="fa fa-qrcode"></i>客房管理</a>
					<ul aria-expanded="false">
						<c:if test="${otherAuthRoomType or selectRoomType}">
							<li><a href="javascript:void(0);" aria-expanded="false" aria-disabled="true"
							data-uri="showAll"><i class="fa fa-qrcode" id="typemgr"></i>类型修改 </a></li>
						</c:if>
						<c:if test="${otherAuthRoom}">
							<li><a href="javascript:void(0);" aria-expanded="false" aria-disabled="true"
							data-uri="rmtpAdd"><i class="fa fa-qrcode"></i>添加客房</a></li>
						</c:if>
						<c:if test="${selectRoom}">
							<li><a href="javascript:void(0);" aria-expanded="false" aria-disabled="true"
							data-uri="rmtpAll"><i class="fa fa-qrcode" id="allroomtype"></i>查询所有客房 </a></li>
						</c:if>
					</ul></li>
				</c:if>
				<li class="active"><a href="javascript:void(0);" aria-expanded="false"
					data-uri="changePwd"><i class="fa fa-android"></i>修改密码</a></li>
				<!--收银员拥有的界面  -->
				<c:if test="${addOrd}">
					<li class="active"><a href="javascript:void(0);" aria-expanded="false"
					data-uri="rmAll"><i class="fa fa-android"></i>客户入住</a></li>
				</c:if>
				<c:if test="${selectOrd}">
					<li class="active"><a href="javascript:void(0);" aria-expanded="false"
					data-uri="order"><i class="fa fa-android"></i>订单管理</a></li>
				</c:if>
				<c:if test="${selectAllLog}">
					<li class="active"><a href="javascript:void(0);" aria-expanded="false"
					data-uri="logAll"><i class="fa fa-android"></i>查看所有日志</a></li>
				</c:if>
				<li class="active"><a href="javascript:void(0);" aria-expanded="false"
					data-uri="logById"><i class="fa fa-android"></i>查看员工日志</a></li>
				<!-- 总经理、收银员共同拥有的界面 -->
					<li class="active"><a href="javascript:void(0);" aria-expanded="false"
					data-uri="cusAll" id="alluser"><i class="fa fa-android"></i>查看所有用户</a></li>
				<li class="active"><a href="logoutAction?logout=loginOut" aria-expanded="false"
					data-uri="none"><i class="fa fa-android"></i>退出登录</a></li>
			</ul>
		</nav>
		<input type="hidden" value="${pageSize!=0?pageSize:10}"
			id="tagpageSize">
		<!-- 主体-->
		<div class="main"></div>
	</div>
	</div>
	
	<!--  Modal 入住登记-->
	<div class="md-modal md-effect-8" id="modal-8">
    <div class="md-content">
      <div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">入住登记</h4>
		</div>
		<div class="modal-body">
			<div class="input-group">
				<span class="input-group-addon">房间ID号</span> <input id="rmid"
					type="text" class="form-control" placeholder="Username"
					aria-describedby="basic-addon1" value="301"> <span
					class="input-group-addon">单价</span> <input id="price"
					type="text" class="form-control" aria-describedby="basic-addon1"
					value="100">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">身份证号</span> <input id="idcard"
					type="text" class="form-control" placeholder="请输入身份证号码"
					aria-describedby="basic-addon1"> <span
					class="input-group-addon">姓名</span> <input id="name" type="text"
					class="form-control" placeholder="请输入客户姓名"
					aria-describedby="basic-addon1">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">入住时间</span> 
				<input id="intime"
					type="date" class="form-control" aria-describedby="basic-addon1">
				 <span
					class="input-group-addon">退房时间</span> 
				<input id="outtime"
					type="date" class="form-control" aria-describedby="basic-addon1">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default md-close" id="checkIn"
					>取消</button>
				<button type="button" class="btn btn-primary" onclick="checkIn()">确定入住</button>
			</div>
		</div>
    </div>
  </div>
	<!-- Modal 修改用户信息-->
		<div class="md-modal md-effect-9" id="modal-9">
	    <div class="md-content">
	      <div class="modal-header">
				<h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
			</div>
			<div class="modal-body">
				<form action="">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">ID号</span> <input
							type="text" class="form-control" placeholder="Username"
							aria-describedby="basic-addon1" value="1"> <span
							class="input-group-addon" id="basic-addon1">名字</span> <input
							type="text" class="form-control" placeholder="Username"
							aria-describedby="basic-addon1" value="1">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">部门</span>
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								选择部门 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</div>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">工资</span> <input
							type="text" class="form-control" placeholder="Username"
							aria-describedby="basic-addon1" value="1"> <span
							class="input-group-addon" id="basic-addon1">电话</span> <input
							type="text" class="form-control" placeholder="Username"
							aria-describedby="basic-addon1" value="1">
					</div>
					<div class="modal-footer">
						<button type="button" class="md-close btn btn-default"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">确定修改</button>
					</div>
				</form>
			</div>
	    </div>
	  </div>
	<!-- Modal  订单详情-->
		<div class="md-modal md-effect-3" id="modal-3"  role="dialog">
	    <div class="md-content">
	      <div class="modal-header">
			<h4 class="modal-title" id="myModalLabel">订单详情</h4>
		  </div>
		<div class="modal-body">
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">订单号</span> <input
					type="text" class="form-control" placeholder="Username"
					id="ordId" aria-describedby="basic-addon1" value="301"> <span
					class="input-group-addon" id="basic-addon1">入住人</span> <input
					type="text" class="form-control" aria-describedby="basic-addon1"
					id="ordCusName" value="100">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">身份证号</span> <input
					type="text" class="form-control" placeholder="请输入身份证号码"
					id="ordCusCid" aria-describedby="basic-addon1"> <span
					class="input-group-addon" id="basic-addon1">房间号</span> <input
					type="text" class="form-control" placeholder="请输入房间号码"
					id="ordRmName" aria-describedby="basic-addon1">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">入住时间</span> <input
					type="text" class="form-control" id="ordInDate"
					aria-describedby="basic-addon1"> <span
					class="input-group-addon" id="basic-addon1">退房时间</span> <input
					type="text" class="form-control" id="ordOutDate"
					aria-describedby="basic-addon1">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">房间单价</span> <input
					type="text" class="form-control" placeholder="请输入房间单价"
					id="ordDayPrice" aria-describedby="basic-addon1"> <span
					class="input-group-addon" id="basic-addon1">入住天数</span> <input
					type="text" class="form-control" placeholder="请输入入住天数"
					id="ordTotalDay" aria-describedby="basic-addon1">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">订单总价</span> <input
					type="text" class="form-control" placeholder="请输入房间单价"
					id="ordTotalPrice" aria-describedby="basic-addon1"> <span
					class="input-group-addon" id="basic-addon1">房间类型</span> <input
					type="text" class="form-control" placeholder="请输入房间单价"
					id="ordRoomTypeName" aria-describedby="basic-addon1">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">有无调价</span> <input
					type="text" class="form-control" placeholder="请输入身份证号码"
					id="modifyPriceFlag" aria-describedby="basic-addon1"> <span
					class="input-group-addon" id="basic-addon1">住房状态</span> <input
					type="text" class="form-control" placeholder="请输入身份证号码"
					id="ordState" aria-describedby="basic-addon1">
			</div>
			<div class="modal-footer">
				<button type="button" class="md-close btn btn-primary">Close</button>
			</div>
		</div>
	    </div>
  	</div>
	<!-- Modal 文件上传 -->
  <div class="md-modal md-effect-8" id="modal-10">
    <div class="md-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
		<h4 style="padding-top: 10px; padding-left: 5px;">房间图片</h4>
		<div style="padding: 10px;">
    		<ul class="upload-ul clearfix">
		<!-- <li class="diyUploadHover"> 					
		<div class="viewThumb">					    
			<input type="hidden">					    
			<div class="diyBar"> 							
				<div class="diyProgress">0%</div> 					   
			</div> 					    
			<p class="diyControl">
			<span class="diyLeft OldLeft"><i></i></span><span class="diyCancel OldCancel"><i></i>
			</span><span class="diyRight OldRight"><i></i>
			</span>
			</p>					
			<img id="imageId1">
		</div> 				
		</li>
		
		<li class="diyUploadHover"> 					
		<div class="viewThumb">					    
			<input type="hidden">					    
			<div class="diyBar"> 							
				<div class="diyProgress">0%</div> 					   
			</div> 					    
			<p class="diyControl">
			<span class="diyLeft OldLeft"><i></i></span><span class="diyCancel OldCancel"><i></i>
			</span><span class="diyRight OldRight"><i></i>
			</span>
			</p>					
			<img id="imageId2"  >
		</div> 				
		</li>

		<li class="diyUploadHover"> 					
		<div class="viewThumb">					    
			<input type="hidden">					    
			<div class="diyBar"> 							
				<div class="diyProgress">0%</div> 					   
			</div> 					    
			<p class="diyControl">
			<span class="diyLeft OldLeft"><i></i></span><span class="diyCancel OldCancel"><i></i>
			</span><span class="diyRight OldRight"><i></i>
			</span>
			</p>					
			<img id="imageId3">
		</div> 				
		</li>
		
		<li class="diyUploadHover"> 					
		<div class="viewThumb">					    
			<input type="hidden">					    
			<div class="diyBar"> 							
				<div class="diyProgress">0%</div> 					   
			</div> 					    
			<p class="diyControl">
			<span class="diyLeft OldLeft"><i></i></span><span class="diyCancel OldCancel"><i></i>
			</span><span class="diyRight OldRight"><i></i>
			</span>
			</p>					
			<img id="imageId4">
		</div> 				
		</li>
		
		<li class="diyUploadHover"> 					
		<div class="viewThumb">					    
			<input type="hidden">					    
			<div class="diyBar"> 							
				<div class="diyProgress">0%</div> 					   
			</div> 					    
			<p class="diyControl">
			<span class="diyLeft OldLeft"><i></i></span><span class="diyCancel OldCancel"><i></i>
			</span><span class="diyRight OldRight"><i></i>
			</span>
			</p>					
			<img id="imageId5">
		</div> 				
		</li>
		
	 -->	

        <li class="upload-pick">
            <input type="file" style="opacity:0;" class="webuploader-container clearfix" id="ImgUpload" multiple>
        </li>
    		</ul>
    	</div>
		<div class="input-group" id ="div-rtid"  style="padding-bottom: 10px;">
		  <span class="input-group-addon" id="basic-addon1">类型ID</span>
		  <input id="rtid" type="text" disabled="disabled" class="form-control" placeholder="房间类型ID" aria-describedby="basic-addon1">
		  <span class="input-group-addon" id="basic-addon1">类型名称</span>
		  <input id="rtname" type="text" class="form-control" placeholder="房间类型名称" aria-describedby="basic-addon1">
		</div>
		<div class="input-group" id ="div-price">
		  <span class="input-group-addon" id="basic-addon1">初始价格</span>
		  <input  id="rtinitprice"  type="text" class="form-control" placeholder="房间初始价格" aria-describedby="basic-addon1">
		</div>


      </div>
      <div class="modal-footer">
        <button type="button" class="md-close btn btn-default" id="close-input">Close</button>
        <button type="button" class="btn btn-primary" onclick="updatert()">Save changes</button>
      </div>
    </div>
  </div>
	
	
  <div class="md-overlay"></div>
</body>
<script>
	function checkIn() { //确定入住
		console.log("调用checkIn");
		var rmid =  $("#rmid").val();
		var price = $("#price").val();
		var idcard = $("#idcard").val();
		var name = $("#name").val();
		var intime = $("#intime").val();
		var outtime = $("#outtime").val();
		
		var ord ={
			'ord.room.rmName':rmid,
			'ord.cus.cusName':name,
			'ord.cus.cusCid':idcard,
			'ord.inDate':intime,
			'ord.outDate':outtime,				
			'ord.rmDayPrice':price,				
		}
		$.ajax({
			url : 'addOneordAction.action',
			type : 'post',
			data : ord,
			dataType : "json",
			success: function(data) {
				alert("入住成功!");
				$("#checkIn").trigger('click');
			}
		});
		 
	}
	function updatert() { 
		console.log("调用updatert");
		var rtid= $("#rtid").val();
		var rtname =  $("#rtname").val();
		var initprice = $("#rtinitprice").val();
		
		
		var roomtype ={
		    'roomtype.rmTpId':rtid,
			'roomtype.rmTpName':rtname,
			'roomtype.rmTpInitPrice':initprice,
					
		}
		$.ajax({
			url : 'doupdateroomTypeAction.action',
			type : 'post',
			data : roomtype,
			dataType : "json",
			success: function(data) {
				alert("修改成功!");
				/* var typeList = '<div class="col-sm-6 col-md-4">'+
				    			'<div class="thumbnail">'+
							      '<img src="./images/3.jpg" height="300" width="400" alt="...">'+
							      '<div class="caption">'+
							        '<h3>双标</h3>'+
							        '<p>价格：40$</p>'+
							        '<p><a <c:if test="${otherAuthRoomType != true}">  style="display: none;" </c:if> href="javascript:void(0);" class="md-trigger btn btn-primary" role="button" data-modal="modal-10">修改</a></p>'+
							      '</div>'+
							    '</div>'+
							  '</div>'; */
			    console.log(data);
				$("#type-"+data.rmTpId).children('.thumbnail').children('img').attr('src',"./upload/"+data.rmTpPic);
			    $("#type-"+data.rmTpId).children('.thumbnail').children('.caption').children('h3').text(data.rmTpName);	
			    $("#type-"+data.rmTpId).children('.thumbnail').children('.caption').children('p').eq(0).text("价格："+data.rmTpInitPrice);
				$("#close-input").trigger("click");
			}
		});
		 
	}
	$("#close-input").bind('click',function(){
		$("#ImgUpload")[0].value = '';
		/*$("#ImgUpload").outerHTML = $("#ImgUpload").outerHTML;*/
		console.log($("#ImgUpload")[0].files);
		$(".diyUploadHover").remove();
	})
	
	$(".main").load("loadPageAction", {
		"ask" : "data"
	});
	//load(url,data,function(response,status,xhr))
	//$(".main").load("pageAllstuAction.action",{start:"1",pageSize:${tagpageSize}.val()});
	//一级菜单主体内容修改
	$(".nav-left .metismenu>li").click(function() {
		var $uri = $(this).find("a").data("uri");
		if ($uri != "none") {//没有二级菜单
			$(".main").html(""); //情况div.main 内容

			$(".main").load("loadPageAction", {
				"ask" : $uri
			});
		}
	});
	//二级菜单主体内容修改
	$(".nav-left .metismenu>li ul li").click(function() {
		var $uri = $(this).find("a").data("uri");
		var $uri1 = $(this).find("a").data("uri1");
		//console.log("$uri"+$uri);
		//console.log("$uri1"+$uri1);
		$(".main").html("");
		if ($uri == "none") {
			$(".main").load($uri1, {
				start : "1",
				pageSize : "10"
			});
		} else {
			console.log("$uri" + $uri);
			$(".main").load("loadPageAction", {
				"ask" : $uri
			});
		}

	});
	$("#menu").metisMenu();
</script>
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
</html>

