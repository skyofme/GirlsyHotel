<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
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
				<div class="panel-heading">添加房间类型信息表</div>
				<div class="panel-body">
					<div class="table-responsive">
						<form class="form-horizontal" action="addroomTypeAllAction.action" name="add" method="post">
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">房间名字</label>
								<div class="col-sm-10">
									<input type="text" name="rm.rmName" class="form-control"
										id="inputName" placeholder="请输入房间名字">
								</div>
							</div>
								<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">今日价格</label>
								<div class="col-sm-10">
									<input type="text" name="rm.rmPrice" class="form-control"
										id="inputName" placeholder="请输入价格" >
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
								</div>
							</div>
   						    <%-- <div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">添加图片</label>
								<div class="col-sm-10">
								 <s:form action="addupload2.action" enctype="multipart/form-data" method="post">
    								<input type="file" name="upload" multiple="multiple"/>
    								<s:submit name="submit" value="上传文件"/>  	
    							 </s:form>
    							 </div>
   							 </div>  --%>
   							 <div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button class="btn btn-default"  onclick="add()">添加</button>
								</div>
							</div>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript">
		function add() {
			$("form[name=add]").submit(function() {
			})
		}
	</script>
</body>
</html>