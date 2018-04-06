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
<title></title>
 <script src="http://www.my97.net/dp/My97DatePicker/WdatePicker.js"></script>
</head>
<body style="height: 1000px">
	<div class="row">
		<div class="col-md-12">
			<!-- Advanced Tables -->
			<div class="panel panel-default">
				<div class="panel-heading">添加员工信息表</div>
				<div class="panel-body">
					<div class="table-responsive">
						<form class="form-horizontal" action="addallAction.action" name="add" method="post">
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-10">
									<input type="text" name="emp.empName" class="form-control"
										id="inputName" placeholder="请输入姓名">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">年龄</label>
								<div class="col-sm-10">
									<input type="text" name="emp.empAge" class="form-control"
										id="inputName" placeholder="请输入年龄">
								</div>
							</div>
								<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">入职日期</label>
								<div class="col-sm-10">
									<input type="Date" name="emp.empDate" class="form-control"
										id="inputName" placeholder="请输入年龄" >
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">薪资</label>
								<div class="col-sm-10">
									<input type="text" name="emp.empSal" class="form-control"
										id="inputName" placeholder="请输入薪资">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">性别</label>
								<div class="col-sm-10">
									<label class="radio-inline"> <input type="radio"
										name="emp.empSex" value="男" checked="checked"> 男
									</label> <label class="radio-inline"> <input type="radio"
										name="emp.empSex" value="女"> 女
									</label>
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">电话</label>
								<div class="col-sm-10">
									<input type="text" name="emp.empTel" class="form-control"
										id="inputName" placeholder="请输入电话">
								</div>
							</div>
							<div class="form-group">
								<label for="inputClsName" class="col-sm-2 control-label">部门名称</label>
								<div class="col-sm-10">
									<select class="form-control" name="emp.dep.depId">
										<c:forEach items="${deplist}" var="dep">
											<option value="${dep.depId}">${dep.depName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button <c:if test="${otherAuthEmp != true}"> disabled="disabled" </c:if> class="btn btn-default" >添加</button>
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