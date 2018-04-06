/*
* @Author: Administrator
* @Date:   2017-12-25 21:25:47
* @Last Modified by:   Administrator
* @Last Modified time: 2017-12-25 21:25:59
*/

		var wColor = ['rgba(25, 139, 201, 1)','rgba(39, 174, 97, 1)','rgba(245, 215, 110, 1)','rgba(255, 204, 225, 0.8)','rgba(208, 194, 248, 1)']
		var tColor = ['rgba(06, 85, 128, 0.8)','rgba(14, 71, 39, 0.8)','rgba(211, 84, 0, 0.8)','rgba(155, 104, 125, 1)','rgba(111, 84, 155, 0.8)'];
		for(var i = 0;i<$(".part").length;i++) {
			var j = i;
			var c = j%5;
			var text = ($(".part").eq(j).children('canvas').eq(0).data("amount"))*100+"%";
			$(".part").eq(j).children('canvas').eq(0).waterbubble({
			    radius: 100,
			    lineWidth: 5,
			    data: $(".part").eq(j).children('canvas').eq(0).data("amount"),
			    waterColor: wColor[c],
			    textColor: tColor[c],
			    txt: text,
			    font: 'bold 30px "Microsoft YaHei"',
			    wave: true,
			    animation: true
			});
		}
		
		
/*
		$('#waterbubble1').waterbubble({
		    radius: 100,
		    lineWidth: 5,
		    data: $('#waterbubble1').data("amount"),
		    waterColor: 'rgba(25, 139, 201, 1)',
		    textColor: 'rgba(06, 85, 128, 0.8)',
		    txt: ($('#waterbubble1').data("amount"))*100+"%",
		    font: 'bold 30px "Microsoft YaHei"',
		    wave: true,
		    animation: true
		});
		$('#waterbubble2').waterbubble({
		    radius: 100,
		    lineWidth: 5,
		    data: $('#waterbubble2').data("amount"),
		    waterColor: 'rgba(39, 174, 97, 1)',
		    textColor: 'rgba(14, 71, 39, 0.8)',
		    txt: ($('#waterbubble2').data("amount"))*100+"%",
		    font: 'bold 30px "Microsoft YaHei"',
		    wave: true,
		    animation: true
		});
		$('#waterbubble3').waterbubble({
		    radius: 100,
		    lineWidth: 5,
		    data: $('#waterbubble3').data("amount"),
		    waterColor: 'rgba(245, 215, 110, 1)',
		    textColor: 'rgba(211, 84, 0, 0.8)',
		    txt: ($('#waterbubble3').data("amount"))*100+"%",
		    font: 'bold 30px "Microsoft YaHei"',
		    wave: true,
		    animation: true
		});
		$('#waterbubble4').waterbubble({
		    radius: 100,
		    lineWidth: 5,
		    data: $('#waterbubble4').data("amount"),
		    waterColor: 'rgba(255, 204, 225, 0.8)',
		    textColor: 'rgba(155, 104, 125, 1)',
		    txt: ($('#waterbubble4').data("amount"))*100+"%",
		    font: 'bold 30px "Microsoft YaHei"',
		    wave: true,
		    animation: true
		});
		$('#waterbubble5').waterbubble({
		    radius: 100,
		    lineWidth: 5,
		    data: $('#waterbubble5').data("amount"),
		    waterColor: 'rgba(208, 194, 248, 1)', 
		    textColor: 'rgba(111, 84, 155, 0.8)',
		    txt: ($('#waterbubble5').data("amount"))*100+"%",
		    font: 'bold 30px "Microsoft YaHei"',
		    wave: true,
		    animation: true
		});*/
