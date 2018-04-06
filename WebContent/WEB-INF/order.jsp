<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="s" uri="/struts-tags" %>
  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">   
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css">

<link rel="stylesheet" href="<%=basePath%>css/component1.css">
	<style>
		.button-hidden {
			display: none;
		}
		.input-display {
			width: 60px;
			height: 40px;
		}
		.input-date {
			width: 100px;
			height: 40px;
		}
		 .container {
			width: 100%;
		} 
		.top-div {
			height: 60px;
			text-align: center;
		}
	</style>
</head>
<body class="main">
	<div class="top-div"><h3>订单管理</h3></div>
	<div class="container" style="font-size: 12px;">
		<table class="table table-hover table1">
		<thead>
			<tr class="row text-center bg-success">
				<td class="col-md-1">订单号</td>
				<td class="col-md-1">入住人</td>
				<td class="col-md-1">房间号</td>
				<td class="col-md-1">入住时间</td>
				<td class="col-md-2">退房时间</td>
				<td class="col-md-1">房间单价</td>
				<td class="col-md-1">入住天数</td>
				<td class="col-md-1">订单总价</td>
				<td class="col-md-1">住房状态</td>
				<td class="col-md-3">操作</td>
			</tr>
		</thead>
		<tbody id="shouldRemove">
			<c:forEach items="${ordlist}" var="ord">
				<tr class="row text-center" data-uri="1">
					<td class="col-md-1"><input type="hidden" disabled="disabled" value="${ord.ordId}"><p>${ord.ordId}</p></td>
					<td class="col-md-1"><input type="hidden" disabled="disabled" value="${ord.cus.cusName }"><p>${ord.cus.cusName }</p></td>
					<td class="col-md-1"><input type="hidden" value="${ord.room.rmName }"><p>${ord.room.rmName }</p></td>
					<td class="col-md-1"><input type="hidden" value="${ord.inDate }"><p>${ord.inDate }</p></td>
					<td class="col-md-2"><input type="hidden" value="${ord.outDate }"><p>${ord.outDate }</p></td>
					<td class="col-md-1"><input type="hidden" value="${ord.rmDayPrice }"><p>${ord.rmDayPrice }</p></td>
					<td class="col-md-1"><input type="hidden" disabled="disabled" value="${ord.totalDay}"><p id="${ord.ordId}totalDay">${ord.totalDay}</p></td>
					<td class="col-md-1"><input type="hidden" disabled="disabled" value="${ord.totalPrice}"><p id="${ord.ordId}totalPrice">${ord.totalPrice}</p></td>
					<td class="col-md-1"><input type="hidden" value="${ord.ordState}"><p>${ord.ordState}</p></td>
					<td class="col-md-3">
						<button id="updateOrdButton" type="button" class="btn btn-success edit-td updateOrd" >修改</button>	
						<button type="text" class="btn btn-info button-hidden button-confirm updateOrd">✔</button>
						<button type="text" class="btn btn-warning button-hidden button-cancel updateOrd">✘</button>
						<input type="button" class="md-trigger btn btn-success getModal" value="详情"  data-modal="modal-3" data-whatever="${ord.ordId}">
					</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<nav aria-label="">
	  		<ul class="pager">
	    		<li><a href="javascript:void(0)" onclick="dopage(${start-1})">Previous</a></li>
	    		<li><a href="javascript:void(0)" onclick="dopage(${start+1})">Next</a></li>
	  		</ul>
		</nav>
	</div>
	
</body>
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>

<script src="<%=basePath%>js/classie.js"></script>
<script src="<%=basePath%>js/modalEffects.js"></script>
<script type="text/javascript">
	//权限判断
	var auth = "${updateOrd}";
	if(auth != "true"){
		$(".updateOrd").attr("disabled", true); 
	} 
	 function dopage(page) {
		$(".main").load("getAllordAction.action", {
			"start" : page,
		});
	} 
	var data = new Array();
	$(".edit-td").click(function(){
		data[0] = $(this).parent().parent().children('td').eq(0).children('p').text();
		data[1] = $(this).parent().parent().children('td').eq(1).children('p').text();
		data[2] = $(this).parent().parent().children('td').eq(2).children('p').text();
		data[3] = $(this).parent().parent().children('td').eq(3).children('p').text();
		data[4] = $(this).parent().parent().children('td').eq(4).children('p').text();
		data[5] = $(this).parent().parent().children('td').eq(5).children('p').text();
		data[6] = $(this).parent().parent().children('td').eq(6).children('p').text();
		data[7] = $(this).parent().parent().children('td').eq(7).children('p').text();
		data[8] = $(this).parent().parent().children('td').eq(8).children('p').text();
		$(this).parent().parent().children('td').eq(0).children('input').attr('type','text').addClass('input-display');
		$(this).parent().parent().children('td').eq(1).children('input').attr('type','text').addClass('input-display');
		$(this).parent().parent().children('td').eq(2).children('input').attr('type','text').addClass('input-display');
		$(this).parent().parent().children('td').eq(3).children('input').attr('type','date').addClass('input-date');
		$(this).parent().parent().children('td').eq(4).children('input').attr('type','date').addClass('input-date');
		$(this).parent().parent().children('td').eq(5).children('input').attr('type','text').addClass('input-display');
		$(this).parent().parent().children('td').eq(6).children('input').attr('type','text').addClass('input-display');
		$(this).parent().parent().children('td').eq(7).children('input').attr('type','text').addClass('input-display');
		$(this).parent().parent().children('td').eq(8).children('input').attr('type','text').addClass('input-display');
		$(this).parent().parent().children('td').eq(9).children('button').eq(0).toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(9).children('button').eq(1).toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(9).children('button').eq(2).toggleClass('button-hidden');
	
		$(this).parent().parent().children('td').eq(0).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(1).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(2).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(3).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(4).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(5).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(6).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(7).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(8).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(9).children('p').toggleClass('button-hidden');
	});
	$(".button-cancel").click(function(){
		$(this).parent().parent().children('td').eq(0).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(1).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(2).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(3).children('input').attr('type','hidden').addClass('input-date');
		$(this).parent().parent().children('td').eq(4).children('input').attr('type','hidden').addClass('input-date');
		$(this).parent().parent().children('td').eq(5).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(6).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(7).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(8).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(9).children('button').eq(0).toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(9).children('button').eq(1).toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(9).children('button').eq(2).toggleClass('button-hidden');
	
		$(this).parent().parent().children('td').eq(0).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(1).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(2).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(3).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(4).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(5).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(6).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(7).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(8).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(9).children('p').toggleClass('button-hidden');
	
		$(this).parent().parent().children('td').eq(0).children('p').text(data[0]);
		$(this).parent().parent().children('td').eq(1).children('p').text(data[1]);
		$(this).parent().parent().children('td').eq(2).children('p').text(data[2]);
		$(this).parent().parent().children('td').eq(3).children('p').text(data[3]);
		$(this).parent().parent().children('td').eq(4).children('p').text(data[4]);
		$(this).parent().parent().children('td').eq(5).children('p').text(data[5]);
		$(this).parent().parent().children('td').eq(6).children('p').text(data[6]);
		$(this).parent().parent().children('td').eq(7).children('p').text(data[7]);
		$(this).parent().parent().children('td').eq(8).children('p').text(data[8]);
		
	
		$(this).parent().parent().children('td').eq(0).children('input').val(data[0]);
		$(this).parent().parent().children('td').eq(1).children('input').val(data[1]);
		$(this).parent().parent().children('td').eq(2).children('input').val(data[2]);
		$(this).parent().parent().children('td').eq(3).children('input').val(data[3]);
		$(this).parent().parent().children('td').eq(4).children('input').val(data[4]);
		$(this).parent().parent().children('td').eq(5).children('input').val(data[5]);
		$(this).parent().parent().children('td').eq(6).children('input').val(data[6]);
		$(this).parent().parent().children('td').eq(7).children('input').val(data[7]);
		$(this).parent().parent().children('td').eq(8).children('input').val(data[8]);
		
		
	});
		$(".getModal").bind('click',function(){
			console.log("gotogetone");
	        var button = $(this) // 触发事件的按钮  
	        var ordId = button.data('whatever') // 解析出whatever内容  
	        var modal = $("#modal-3")  //获得模态框本身
	        $.ajax({
				url : 'getOneordAction.action',
				type : 'post',
				data :{"ordId":ordId},
				dataType : "json",
				success: function(data) {
					console.log("getONE成功啦")
					console.log(getMyDate(data.inDate));
					console.log(getMyDate(data.outDate));
					modal.find('#ordId').val(data.ordId);
					modal.find('#ordCusName').val(data.cus.cusName);
					modal.find('#ordCusCid').val(data.cus.cusCid);
					modal.find('#ordRmName').val(data.room.rmName);
					modal.find('#ordInDate').val(getMyDate(data.inDate));
					modal.find('#ordOutDate').val(getMyDate(data.outDate));
					modal.find('#ordDayPrice').val(data.rmDayPrice);
					modal.find('#ordTotalDay').val(data.totalDay);
					modal.find('#ordTotalPrice').val(data.totalPrice);
					modal.find('#ordRoomTypeName').val(data.room.roomType.rmTpName);
					var flag = "否";
					if(data.room.roomType.rmTpInitPrice != data.rmDayPrice)
						flag = "是，原价为"+data.room.roomType.rmTpInitPrice;
					modal.find('#modifyPriceFlag').val(flag);
					modal.find('#ordState').val(data.ordState);
				
				}
		});
        

        /* modal.find('.modal-title').text('Message To ' + recipient)  //更改将title的text
		
        modal.find('.modal-body input').val(recipient) */
    }) 
    function getMyDate(str){  
            var oDate = new Date(str),  
            oYear = oDate.getFullYear(),  
            oMonth = oDate.getMonth()+1,  
            oDay = oDate.getDate(), 
            oTime = oYear +'-'+ oMonth +'-'+ oDay;//最后拼接时间  
            return oTime;  
        };  
    
	$(".button-confirm").click(function(){
		$(this).parent().parent().children('td').eq(0).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(1).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(2).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(3).children('input').attr('type','hidden').addClass('input-date');
		$(this).parent().parent().children('td').eq(4).children('input').attr('type','hidden').addClass('input-date');
		$(this).parent().parent().children('td').eq(5).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(6).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(7).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(8).children('input').attr('type','hidden').addClass('input-display');
		$(this).parent().parent().children('td').eq(9).children('button').eq(0).toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(9).children('button').eq(1).toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(9).children('button').eq(2).toggleClass('button-hidden');
	
		$(this).parent().parent().children('td').eq(0).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(1).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(2).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(3).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(4).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(5).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(6).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(7).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(8).children('p').toggleClass('button-hidden');
		$(this).parent().parent().children('td').eq(9).children('p').toggleClass('button-hidden');
	
		$(this).parent().parent().children('td').eq(0).children('p').text($(this).parent().parent().children('td').eq(0).children('input').val());
		$(this).parent().parent().children('td').eq(1).children('p').text($(this).parent().parent().children('td').eq(1).children('input').val());
		$(this).parent().parent().children('td').eq(2).children('p').text($(this).parent().parent().children('td').eq(2).children('input').val());
		$(this).parent().parent().children('td').eq(3).children('p').text($(this).parent().parent().children('td').eq(3).children('input').val());
		$(this).parent().parent().children('td').eq(4).children('p').text($(this).parent().parent().children('td').eq(4).children('input').val());
		$(this).parent().parent().children('td').eq(5).children('p').text($(this).parent().parent().children('td').eq(5).children('input').val());
		$(this).parent().parent().children('td').eq(6).children('p').text($(this).parent().parent().children('td').eq(6).children('input').val());
		$(this).parent().parent().children('td').eq(7).children('p').text($(this).parent().parent().children('td').eq(7).children('input').val());
		$(this).parent().parent().children('td').eq(8).children('p').text($(this).parent().parent().children('td').eq(8).children('input').val());
		
		var ordState = $(this).parent().parent().children('td').eq(8).children('input').val();
		var rmName = $(this).parent().parent().children('td').eq(2).children('input').val();
		var indate = $(this).parent().parent().children('td').eq(3).children('input').val();
		var oudate = $(this).parent().parent().children('td').eq(4).children('input').val();
		indate = new Date(indate).getTime();
		oudate = new Date(oudate).getTime();
		console.log(indate+"aaa"+oudate);
		
		var rmNameList = ${ordGetAllRoom};
		
		var thisele = $(this);
		
		//判断房间号是否正确
		var rmNameFlag = "false";
		for(var i=0,len=rmNameList.length;i<len;i++){
		       if(rmNameList[i] == rmName){
		    	   rmNameFlag = "true";
		    	   break;
		    	   }
		}
		
		//判断入住日期是否正确
		if(indate>=oudate){
			alert("请入住日期或者退房日期是否有误");
			$(this).parent().parent().children('td').eq(3).children('p').text(data[3]);
			$(this).parent().parent().children('td').eq(3).children('input').val(data[3]);
			$(this).parent().parent().children('td').eq(4).children('p').text(data[4]);
			$(this).parent().parent().children('td').eq(4).children('input').val(data[4]);
		}
		
		if(rmNameFlag == "false"){
			alert("请检查房间号是否有误");
			$(this).parent().parent().children('td').eq(2).children('p').text(data[2]);
			$(this).parent().parent().children('td').eq(2).children('input').val(data[2]);
		}
		if(ordState != "在住" && ordState != "已退" &&ordState != "取消" ){
			alert("住房状态只能为[在住]、[已退]、[取消]");
			$(this).parent().parent().children('td').eq(8).children('p').text(data[8]);
			$(this).parent().parent().children('td').eq(8).children('input').val(data[8]);
			
		}
		 
		var ord ={
				'ord.ordId':$(this).parent().parent().children('td').eq(0).children('input').val(),
				'ord.room.rmName':$(this).parent().parent().children('td').eq(2).children('p').text(),
				'ord.cus.cusName':$(this).parent().parent().children('td').eq(1).children('input').val(),
				'ord.inDate':$(this).parent().parent().children('td').eq(3).children('input').val(),
				'ord.outDate':$(this).parent().parent().children('td').eq(4).children('input').val(),				
				'ord.rmDayPrice':$(this).parent().parent().children('td').eq(5).children('input').val(),				
				'ord.ordState':	$(this).parent().parent().children('td').eq(8).children('p').text()		
		}
		
		$.ajax({
			url : 'updateordAction.action',
			type : 'post',
			data : ord,
			dataType : "json",
			success: function(data) {
				var d = data.totalPrice;
				console.log(d);
				thisele.parent().parent().children('td').eq(6).children('p').text(data.totalDay);
				thisele.parent().parent().children('td').eq(5).children('p').text(data.rmDayPrice);
				thisele.parent().parent().children('td').eq(6).children('input').val(data.totalDay);
				thisele.parent().parent().children('td').eq(5).children('input').val(data.rmDayPrice);

				thisele.parent().parent().children('td').eq(7).children('p').text(data.totalPrice);
				thisele.parent().parent().children('td').eq(7).children('input').val(data.totalPrice);
				console.log("成功啦");
			}
		});
		data[0] = $(this).parent().parent().children('td').eq(0).children('p').text();
		data[1] = $(this).parent().parent().children('td').eq(1).children('p').text();
		data[2] = $(this).parent().parent().children('td').eq(2).children('p').text();
		data[3] = $(this).parent().parent().children('td').eq(3).children('p').text();
		data[4] = $(this).parent().parent().children('td').eq(4).children('p').text();
		data[5] = $(this).parent().parent().children('td').eq(5).children('p').text();
		data[6] = $(this).parent().parent().children('td').eq(6).children('p').text();
		data[7] = $(this).parent().parent().children('td').eq(7).children('p').text();
		data[8] = $(this).parent().parent().children('td').eq(8).children('p').text();
	});
</script>
<%-- <script src="<%=basePath%>js/editTd.js"> --%>

</html>