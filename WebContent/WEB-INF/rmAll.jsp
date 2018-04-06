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
<base href="<%=basePath%>">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>css/component1.css">
<style>
* {
	margin: 0;
	padding: 0;
}

tbody tr {
	font: normal 15px "microsoft yahei";
}

.table1 {
	border: 2px solid #ccc;
}

.table-top {
	height: 20px;
}
</style>
<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
</head>
<body>
	<div class="table-top"></div>
	<div class="container" style="margin-bottom: 20px;">
		<form>
			<div class="dropdown">
				<button class="btn btn-default dropdown-toggle" type="button"
					id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true"><c:if test="${roomtypeFlag}">${roomType}</c:if>
				<c:if test="${!roomtypeFlag}">所有房间</c:if><span class="caret"></span>
				</button>
			
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					
					<c:forEach items="${rmmmTypeList}" var="rmmm">
						<li><a href="javascript:void()" onclick="dopage(1,'${rmmm}')">${rmmm}</a></li>
					</c:forEach>
					<li><a href="javascript:void()" onclick="dopage(1,'所有房间')">所有房间</a></li>
				</ul>
			</div>
		</form>
	</div>

	<div class="container">
		<table class="table table-hover table1">
			<thead>
				<tr class="row text-center bg-success">
					<td class="col-md-2">ID</td>
					<td class="col-md-2">房间号</td>
					<td class="col-md-3">类型</td>
					<td class="col-md-2">价格</td>
					<td class="col-md-3">是否可定</td>
				</tr>
			</thead>
			<tbody id="table-tbody">
			<c:forEach items="${rlist}" var="r">
				<tr class="row text-center">
					<td class="col-md-2">${r.rmId}</td>
					<td class="col-md-2">${r.rmName}</td>
					<td class="col-md-3">${r.roomType.rmTpName}</td>
					<td class="col-md-2">${r.rmPrice}</td>
					<td class="col-md-3"><input type="button"
						class="md-trigger btn btn-success" id="ruzhubutton" value="入住" data-modal="modal-8"
						 <c:if test="${r.rmState eq '在住'}"> disabled="disabled" </c:if>
						></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<nav aria-label="">
			<ul class="pager">
				<li><a href="javascript:void()" onclick="dopage(${startrr-1},'showpre')">Previous</a></li>${startrr}
				<li><a href="javascript:void()" onclick="dopage(${startrr+1},'showpre')">Next</a></li>
			</ul>
		</nav>
	</div>
</body>

<script src="<%=basePath%>js/classie.js"></script>
<script src="<%=basePath%>js/modalEffects.js"></script>
 <script>
 /* var arr = new array();
 arr[0] = "heiil";
  */
//权限判断
var auth = "${addOrd}";
if(auth != "true"){
	$("#ruzhubutton").attr("disabled", true); 
} 

 function dopage(page,type) {
	 console.log("dopage");
	 if(type=='showpre'){
		 type = $("#dropdownMenu1").text();}
	 else{
		 page = 1;
		 $("#dropdownMenu1").text(type);//设置下拉列表选中的值
	 }
		$(".main").load("getAllroomAction.action", {
			"start" : page,"pageSize" : 5, "type" : type,"first":false
		});
	} 

</script>
</html>