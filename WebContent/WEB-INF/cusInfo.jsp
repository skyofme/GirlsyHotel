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
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title></title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<!-- Advanced Tables -->
			<div class="panel panel-default">
				<div class="panel-heading">订单信息表</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<tr>
								<th>订单编号</th>
								<th>房间号码</th>
								<th>房间类型</th>
								<th>入住时间</th>
								<th>离开时间</th>
								<th>入住天数</th>
								<th>订单总价</th>								
								<th>订单状态</th>
							</tr>
							<c:forEach items="${olist}" var="o">
								<tr>
									<td>${o.ordId}</td>
									<td>${o.room.rmName}</td>
									<td>${o.room.roomType.rmTpName}</td>
									<td>${o.inDate}</td>
									<td>${o.outDate}</td>
									<td>${o.totalDay}</td>	
									<td>${o.totalPrice}</td>						
									<td>${o.ordState}</td>
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
					$(".main").load("getInfocusAction.action", {
						"start" : page,
						"pageSize" : pageSize
					});
				}				
			</script>  
</body>
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
</html>