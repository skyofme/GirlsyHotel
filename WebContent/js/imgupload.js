/*
* @Author: Administrator
* @Date:   2017-12-30 15:37:15
* @Last Modified by:   Administrator
* @Last Modified time: 2017-12-30 15:44:30
*/
$(function(){
		var $fileInput = $(".upload-pick");
		window.inputFiles = new Array();
    	$(".upload-ul").on('click','.diyUploadHover .viewThumb .diyControl .diyCancel',function(){
    		$(this).parents('.diyUploadHover').remove();
    	})
    	$(".upload-ul").on('click','.diyUploadHover .viewThumb .diyControl .diyLeft',function(){
    		OldleftLi($(this).parents('.diyUploadHover').prev(),$(this).parents('.diyUploadHover'));
    	})
    	$(".upload-ul").on('click','.diyUploadHover .viewThumb .diyControl .diyRight',function(){
    		OldrightLi($(this).parents('.diyUploadHover').next(), $(this).parents('.diyUploadHover'));
    	})
    	
		$("#ImgUpload").change(function(){
	        console.log($("#ImgUpload")[0].files);
	        for(var i=0;i<$("#ImgUpload")[0].files.length;i++){
	        	createBox($fileInput,$("#ImgUpload")[0].files[i],i);
	        }	
	    });
		$("#getImg").on('click',function(){
			OrderImg();
		});
		//排好顺序
	    function OrderImg(){
	    	arr = [];
	    	//var $(".diyUploadHover");
	    	var len = $(".diyUploadHover").size();//获取span标签的个数
			for(var index = 0; index < len; index++){//创建一个数字数组
				arr[index] = index;
			}	    	
	    	$.each(arr, function(i){//循环得到不同的id的值
				var idValue = $(".diyUploadHover").eq(i).attr("id")||'';
				//console.log($(".diyUploadHover").eq(i).attr("id"));
				if(idValue != ''){
					arr[i] = 1;
					var index = idValue.split("_")[1];
					window.inputFiles.push($("#ImgUpload")[0].files[index]);
				}else {
					arr[i] = 0;
					var imgsrc = $(".diyUploadHover").eq(i).children('.viewThumb').children('img').attr('src');
					window.inputFiles.push(imgsrc);
				}
	    	});
	    	console.log(arr);
	    	console.log(window.inputFiles[3]);
		}
		//创建文件操作div;
	    function createBox( $fileInput, file,i) {
	        var $parentFileBox = $fileInput.parents(".upload-ul");
	        var file_len=$parentFileBox.children(".diyUploadHover").length;
	        //添加子容器;
	        var li = '<li id="fileBox_'+i+'" class="diyUploadHover"> \
						<div class="viewThumb">\
						    <input type="hidden">\
						    <div class="diyBar"> \
								<div class="diyProgress">0%</div> \
						    </div> \
						    <p class="diyControl"><span class="diyLeft"><i></i></span><span class="diyCancel"><i></i></span><span class="diyRight"><i></i></span></p>\
						</div> \
					</li>';

	        //$parentFileBox.append( li );
	        $(".upload-pick").before( li );
	        
	        if ( file.type.split("/")[0] != 'image' ) {
	            var liClassName = getFileTypeClassName( file.name.split(".").pop() );
	            $fileBox.addClass(liClassName);
	            return;
	        }
	        var $fileBox = $parentFileBox.find('#fileBox_'+i);
	        var reader = new FileReader();
        	reader.readAsDataURL(file);
        	reader.onload = function (e) { 
        		//txshow.src = this.result; 
        		//alert(this.result); 
        		$fileBox.find('.viewThumb').append('<img src="'+this.result+'" >');
        	}	        
	    }
		$(".OldCancel").on('click',function(){
			$(this).parents('.diyUploadHover').remove();
		});
		$(".OldLeft").on('click',function(){
			OldleftLi($(this).parents('.diyUploadHover').prev(),$(this).parents('.diyUploadHover'));
		});
		$(".OldRight").on('click',function(){
			OldrightLi($(this).parents('.diyUploadHover').next(), $(this).parents('.diyUploadHover'));
		});

		//左移事件;
	    function OldleftLi ($leftli, $li) {
	        $li.insertBefore($leftli);
	    }
	    //右移事件;
	    function OldrightLi ($rightli, $li) {
	        $li.insertAfter($rightli);
	    }
	    
		    //取消事件;
	    function removeLi ( $li ,file_id ,webUploader) {
	        $li.remove();
	    }

	    //左移事件;
	    function leftLi ($leftli, $li) {
	        $li.insertBefore($leftli);
	    }

	    //右移事件;
	    function rightLi ($rightli, $li) {
	        $li.insertAfter($rightli);
	    }
	});
	