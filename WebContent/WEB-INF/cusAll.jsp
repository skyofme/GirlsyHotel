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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>显示所有的客户信息</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<!-- Advanced Tables -->
			<div class="panel panel-default">
				<div class="panel-heading">客户信息表</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<tr>
								<th>客户编号</th>
								<th>客户姓名</th>
								<th>客户身份证号</th>								
								<th>操作</th>
							</tr>
							<c:forEach items="${clist}" var="cus">
								<tr>
									<td>${cus.cusId}</td>
									<td>${cus.cusName}</td>
									<td>${cus.cusCid}</td>							
									<td><a href="javascript:void(0)"
										onclick="dodel(this,'doDelcusAction.action')">删除</a> <a
										href="javascript:void(0)"
										onclick="dohref(this,'editcusAction.action')">修改</a> <a
										href="javascript:void(0)"
										onclick="dohref(this,'getInfocusAction.action')">详细</a></td>
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
					$(".main").load("pageAllcusAction.action", {
						"start" : page,
						"pageSize" : pageSize
					});
				}
				function dohref(ele,page){
					//获取当前行的 id
					var $cusId=$(ele).parents("tr").find("td:eq(0)").text();
					//console.log("sid"+$sid);
					$(".main").load(page,{"cusId":$cusId});
				}
				function dodel(ele,page){
					//获取当前行的 id
					var $cusId=$(ele).parents("tr").find("td:eq(0)").text();
				/* 	var flag=confirm("是否删除？");
					if(flag){ */
						$(".main").load(page,{"cusId":$cusId});
					/* } */
				}
			</script>
</body>
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
</html>