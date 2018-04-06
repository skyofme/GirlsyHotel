<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
<title>显示所有的客户信息</title>
</head>
<body style="height: 1000px">
	<div class="row">
		<div class="col-md-12">
			<!-- Advanced Tables -->
			<div class="panel panel-default">
				<div class="panel-heading">修改客户信息表</div>
				<div class="panel-body">
					<div class="table-responsive">
						<form class="form-horizontal" action="doeditcusAction.action" method="post">
							<div class="form-group">
								<label for="inputCusid" class="col-sm-2 control-label">编号</label>
								<div class="col-sm-10">
									<input type="text" name="cus.cusId" class="form-control"
										id="inputCusid" value="${cusId}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-10">
									<input type="text" name="cus.cusName" class="form-control"
										id="inputName" placeholder="请输入姓名" value="${cus.cusName}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputID" class="col-sm-2 control-label">身份证号</label>
								<div class="col-sm-10">
									<input type="text" name="cus.cusCid" class="form-control"
										id="inputID" placeholder="请输入身份证号" value="${cus.cusCid}">
								</div>
							</div>														
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button class="btn btn-default" >修改</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>