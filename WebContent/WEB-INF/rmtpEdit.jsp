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
				<div class="panel-heading">修改房间类型信息表</div>
				<div class="panel-body">
					<div class="table-responsive">
						<form class="form-horizontal" action="editroomTypeAllAction.action" name="edit" method="post"
						target="_self">
							<div class="form-group">
									<%-- <td>${r.rmId}</td>
									<td>${r.rmName}</td>
									<td>${r.roomType.rmTpName}</td>
									<td>${r.roomType.rmTpInitPrice}</td>
									<td>${r.roomType.rmTpPic}</td> --%>
								<label for="inputName" class="col-sm-2 control-label">房间ID</label>
								<div class="col-sm-10">
									<input type="text" name="rm.rmId" class="form-control"
										id="inputName" value="${rm.rmId}"  readonly="readonly">
								</div>
							</div>
								<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">房间号</label>
								<div class="col-sm-10">
									<input type="text" name="rm.rmName" class="form-control"
										id="inputName" value="${rm.rmName} ">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">房间类型</label>
								<div class="col-sm-10">
									<select class="form-control" name="rm.roomType.rmTpId">
										<c:forEach items="${rmtplist}" var="rmtp">
											<c:choose>
												<c:when test="${rm.roomType.rmTpId==rmtp.rmTpId }">
													<option value="${rmtp.rmTpId }" selected="selected">${rmtp.rmTpName}</option>
												</c:when>
												<c:otherwise>
													<option value="${rmtp.rmTpId }">${rmtp.rmTpName}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
									<%-- <input type="text" name="roomtype.rmTpName" class="form-control"
										id="inputName" value="${rm.roomType.rmTpName}"> --%>
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">房间原价</label>
								<div class="col-sm-10">
									<input type="text" name="rm.roomType.rmTpInitPrice" class="form-control"
										id="inputName" value="${rm.roomType.rmTpInitPrice} ">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">每日价格</label>
								<div class="col-sm-10">
									<input type="text" name="rm.rmPrice" class="form-control"
										id="inputName" value="${rm.rmPrice} ">
								</div>
							</div>
							<%-- <div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">房间图片</label>
								<div class="col-sm-10">
									<input type="text" name="roomtype.rmTpPic" class="form-control"
										id="inputName" value="${rm.roomType.rmTpPic}">
								</div>
							</div> --%>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button class="btn btn-default" onclick="edit()">修改</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function edit() {
			$("form[name=edit]").submit(function() {
			})
		}
	</script>
	
</body>
</html>