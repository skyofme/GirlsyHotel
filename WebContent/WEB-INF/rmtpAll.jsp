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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>显示所有房间类型信息</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<!-- Advanced Tables -->
			<div class="panel panel-default">
				<div class="panel-heading">房间类型信息表</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover" >
							<tr align="center">
								<th>房间编号</th>
								<th>房间号</th>
								<th>房间类型</th>
								<th>房间原价</th>
								<th>每日价格</th>
								<!-- <th>房间图片</th> -->
								<th>操作</th>
							</tr>
							<c:forEach items="${rtlist}" var="rm">
								<tr align="center">
									<td>${rm.rmId}</td>
									<td>${rm.rmName}</td>
									<td>${rm.roomType.rmTpName}</td>
									<td>${rm.roomType.rmTpInitPrice}</td>
									<td>${rm.rmPrice}</td>
									<%-- <td>${rm.roomType.rmTpPic}</td> --%>
									<td> <a <c:if test="${otherAuthRoom != true}"> hidden="true" </c:if>
										href="javascript:void(0)"
										onclick="doupdate(this,'doeditroomTypeAllAction.action')">修改</a>
										</td>
								</tr>
							</c:forEach>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-offset-1 col-md-3">
			<label for="pageSize">页码：</label> <select name="pagesize"
				class="input-sm" id="pageSize">
				<c:forEach begin="10" end="50" step="10" var="i">
					<c:choose>
						<c:when test="${i==pageSize}">
							<option value="${i}" selected="selected">${i}</option>
						</c:when>
						<c:otherwise>
							<option value="${i}">${i}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
		<div class="col-md-offset-5 col-md-3">
			<button class="btn" onclick="dopage(1)">首页</button>
			<button class="btn" onclick="dopage(${start-1})">上一页</button>
			<button class="btn" onclick="dopage(${start+1})">下一页</button>
		</div>
	</div>

	<script>
		function dopage(page) {
			var pageSize = $("select[name=pagesize]").val();
			$(".main").load("pageAllroomTypeAction.action", {
				"start" : page,
				"pageSize" : pageSize
			});
		}
		
		function doupdate(ele,page){
			$(".main").load(page);
			/* //获取当前行的 id
			var $rmId=$(ele).parents("tr").find("td:eq(0)").text();
			var $rmName=$(ele).parents("tr").find("td:eq(1)").text();
			var $rmTpName=$(ele).parents("tr").find("td:eq(2)").text();
			var $rmInitPrice=$(ele).parents("tr").find("td:eq(3)").text();
			var $rmTpPic=$(ele).parents("tr").find("td:eq(4)").text();
			console.log("rmId=="+$rmId);
			$(".main").load(page,{"rm.rmId":$rmId,"rm.rmName":$rmName,"rm.roomType.rmTpName":$rmTpName,
							"rm.roomType.rmInitPrice":$rmInitPrice,"rm.roomType.rmTpPic":$rmTpPic}); */
			//只需要传id
			var $rmId = $(ele).parents("tr").find("td:eq(0)").text();
			$(".main").load(page,{"rm.rmId":$rmId});
		}
		
		function dodel(ele,page){
			//获取当前行的 id
			var $rmId=$(ele).parents("tr").find("td:eq(0)").text();
		   var flag=confirm("是否删除？");
			if(flag){ 
				$(".main").load(page,{"rm.rmId":$rmId});
		   }
		}
	</script>
			
		
</body>
<script src="<%=basePath%>js/imgupload.js"></script>
<script src="<%=basePath%>js/classie.js"></script>
<script src="<%=basePath%>js/modalEffects.js"></script>
</html>