<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="/struts-tags" prefix="s"%>
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
	
<link rel="stylesheet" href="<%=basePath%>css/globle.css">
<link rel="stylesheet" href="<%=basePath%>css/component1.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
<style>
	.thumbnail img{
		width: 300px;
		height: 200px;
		overflow:hidden;
	}
	
	.diyUploadHover .viewThumb .diyControl {
		padding: 0;
	}
	</style>
    <!--全局公用样式-->
</head>
<body>
	<div class="container">
	<div class="row"> 
		<!-- 遍历房间类型集合显示所有类型======================================================================== -->
		
			<c:forEach items="${allrmtp}" var="rmtp">
				<div class="col-sm-6 col-md-4" id="type-${rmtp.rmTpId}">
				    <div class="thumbnail">
				      <img  height="300" width="400" src="./upload/${rmtp.rmTpPic}"/>
				      <div class="caption">
				        <h3>${rmtp.rmTpName }</h3>
				        <p>价格：${rmtp.rmTpInitPrice }</p>
				        <p><input type="button"  <c:if test="${otherAuthRoomType != true}">  style="display: none;" </c:if>  class="md-trigger btn btn-primary btn-addType" 
				        data-modal="modal-10"  data-whatever="${rmtp.rmTpId}" value="修改"></p>
				      </div>
				    </div>
			  	</div>
			</c:forEach>
		
	  <div class="col-sm-6 col-md-4">
	    <button class="thumbnail md-trigger" id="addroomtype" role="button" data-modal="modal-10">
	      <img src="./images/add.jpg" height="400" width="400">
	    </button>
	  </div>
	</div>
</div>
<script type="text/javascript">
		/* function edit() {
			$("form[name=updateOrAddroomTypeAction]").submit(function() {
			})
		} */
		$("#addroomtype").bind('click',function(){
			  $("#div-rtid").children("#rtid").val("")
			  $("#div-rtid").children('#rtname').val("")
			  $("#div-price").children('#rtinitprice').val("")
		})
		$(".btn-addType").bind('click',function(){
			console.log("gotogetone");
	        var button = $(this) // 触发事件的按钮  
	        var rmTpId = button.data('whatever') // 解析出whatever内容  
	        var modal = $("#modal-10")  //获得模态框本身
	        $.ajax({
				url : 'updateOrAddroomTypeAction',
				type : 'post',
				data :{"rmTpId":rmTpId},
				dataType : "json",
				success: function(data) {
					console.log("getONE成功啦")
				/* 	console.log(getMyDate(data.inDate));
					console.log(getMyDate(data.outDate)); */
					console.log(data.rmTpPic);
					var myArray=new Array();
					myArray=data.rmTpPic.split(" ");
					console.log(myArray);
					/* modal.find("#imageId1").attr("src","./upload/"+myArray[0]);
					modal.find("#imageId2").attr("src","./upload/"+myArray[1]);
					modal.find("#imageId3").attr("src","./upload/"+myArray[2]);
					modal.find("#imageId4").attr("src","./upload/"+myArray[3]);
					modal.find("#imageId5").attr("src","./upload/"+myArray[4]); */
					var imgList = "";
					for(var i=0;i<myArray.length-1;i++) {
						var j = i;
						imgList += '<li class="diyUploadHover">'+ 					
							'<div class="viewThumb">'+					    
							'<input type="hidden">'+					    
							'<div class="diyBar">'+ 							
								'<div class="diyProgress">0%</div>'+ 					   
							'</div>'+ 					    
							'<p class="diyControl">'+
							'<span class="diyLeft OldLeft"><i></i></span><span class="diyCancel OldCancel"><i></i>'+
							'</span><span class="diyRight OldRight"><i></i>'+
							'</span>'+
							'</p>'+				
							'<img src="./upload/'+myArray[j]+'">'+
							'</div>'+ 				
							'</li>';
					}
					$(".upload-ul").prepend(imgList);
					modal.find('#rtid').val(data.rmTpId);
					modal.find('#rtname').val(data.rmTpName);
					modal.find('#rtinitprice').val(data.rmTpInitPrice);
				}
		});
		 }) 
    
</script>
</body>
<script src="<%=basePath%>js/imgupload.js"></script>
<script src="<%=basePath%>js/classie.js"></script>
<script src="<%=basePath%>js/modalEffects.js"></script>
</html>