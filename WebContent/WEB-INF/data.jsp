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
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/data.css">
</head>
<body>
	<article class="htmleaf-container">
		<!-- <header class="htmleaf-header">
		</header> -->
		<div class="htmleaf-content">
				<c:forEach items="${indexDate}" var="idate">
					<div class="part" style="margin-right: 40px;margin-left: 40px; text-align:center;">
						<!-- 在data-amount中填入  被定数量/总数（注意是小数）-->
						<canvas id="waterbubble<c:out value="${idate.index}"/>" data-amount='<c:out value="${idate.ratio}"/>'></canvas>
						<div><c:out value="${idate.roomType}"/></div>
					</div>
				</c:forEach>
			<%-- <div  class="line2">
				<div class="part">
					<canvas id="waterbubble3" data-amount="0.5"></canvas>
					<div>单豪</div>
				</div>
				<div class="part">
					<canvas id="waterbubble4" data-amount="0.9"></canvas>
					<div>双豪</div>
				</div>
				<div class="part">
					<canvas id="waterbubble5" data-amount="0.6"></canvas>
					<div>家庭</div>
				</div>
			</div> --%>
		</div>
		<footer class="htmleaf-footer"></footer>
	</article>
	<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
	<script src="<%=basePath%>js/waterbubble.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/data.js" type="text/javascript"></script>
</body>
</html>