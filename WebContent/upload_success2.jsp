<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>文件上传</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>

	您所上传的文件是：
	<s:if test="uploadFileName!=null">
		<s:iterator value="uploadFileName" id="name">
			<s:property value="name" /><br />
		</s:iterator>
	</s:if>
	<br />
	<hr/>
	文件类型：
	<s:if test="uploadContentType!=null">
		<s:iterator value="uploadContentType" id="type">
			<s:property value="type" /><br />
		</s:iterator>
	</s:if>
	<br />
	<hr/>
	图片：
	<s:if test="imgsArry!=null">
     <s:iterator value="imgsArry" status="img">
     	文件数量：<s:property value="#img.count"/><br />
     	文件名：<s:property value="imgsArry[#img.index]"/><br />
     	图片：<img width=150 height=100 src="<s:property value="'upload/'+imgsArry[#img.index]"/>" /><br />
     </s:iterator>
	</s:if>
</body>
</html>
