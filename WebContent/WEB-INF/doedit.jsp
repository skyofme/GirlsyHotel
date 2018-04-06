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
<title>显示所有的学员信息</title>
</head>
<body style="margin-top:200px">
	<div class="row">
		<div class="col-md-12">
			<!-- Advanced Tables -->
			<div class="panel panel-default">
				<div class="panel-heading">修改员工信息表</div>
				<div class="panel-body">
					<div class="table-responsive">
						<form class="form-horizontal" action="editallAction.action"
							name="add" method="post" target="_self">
							<div class="form-group">
								<label for="inputSid" class="col-sm-2 control-label">员工编号</label>
								<div class="col-sm-10">
									<input type="text" name="emp.empId" class="form-control"
										id="inputSid" value="${empId}" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">员工姓名</label>
								<div class="col-sm-10">
									<input type="text" name="emp.empName" class="form-control"
										id="inputName" placeholder="请输入姓名" value="${emp.empName}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">员工年龄</label>
								<div class="col-sm-10">
									<input type="text" name="emp.empAge" class="form-control"
										id="inputName" placeholder="请输入年龄" value="${emp.empAge}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">入职时间</label>
								<div class="col-sm-10">
									<input type="text" name="emp.empDate" class="form-control"
										id="inputName" placeholder="请输入入职时间" value="${emp.empDate}" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">员工薪资</label>
								<div class="col-sm-10">
									<input type="text" name="emp.empSal" class="form-control"
										id="inputName" placeholder="请输入薪资" value="${emp.empSal}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">性别</label>
								<div class="col-sm-10">
									<c:if test="${emp.empSex=='男'}">
										<label class="radio-inline"> <input type="radio"
											name="emp.empSex" value="男" checked="checked"> 男
										</label>
										<label class="radio-inline"> <input type="radio"
											name="emp.empSex" value="女"> 女
										</label>
									</c:if>
									<c:if test="${emp.empSex=='女'}">
										<label class="radio-inline"> <input type="radio"
											name="emp.empSex" value="男"> 男
										</label>
										<label class="radio-inline"> <input type="radio"
											name="emp.empSex" value="女" checked="checked"> 女
										</label>
									</c:if>
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">员工电话</label>
								<div class="col-sm-10">
									<input type="text" name="emp.empTel" class="form-control"
										id="inputName" placeholder="请输入电话号码" value="${emp.empTel}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputClsName" class="col-sm-2 control-label">职位</label>
								<div class="col-sm-10">
									<select class="form-control" name="emp.dep.depId">
										<c:forEach items="${deplist}" var="dep">
											<c:choose>
												<c:when test="${emp.dep.depId==dep.depId }">
													<option value="${dep.depId }" selected="selected">${dep.depName}</option>
												</c:when>
												<c:otherwise>
													<option value="${dep.depId}">${dep.depName}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>	
									</select>									
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button class="btn btn-default" onclick="doadd()" >修改</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function doadd() {
			$("form[name=add]").submit(function() {
			})
		}
	</script>
</body>
</html>