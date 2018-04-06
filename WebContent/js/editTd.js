/*
* @Author: Administrator
* @Date:   2017-12-26 16:14:34
* @Last Modified by:   Administrator
* @Last Modified time: 2017-12-26 16:14:59
*/
var data = new Array();
		$(".edit-td").click(function(){
			data[0] = $(this).parent().parent().children('td').eq(0).children('p').text();
			data[1] = $(this).parent().parent().children('td').eq(1).children('p').text();
			data[2] = $(this).parent().parent().children('td').eq(2).children('p').text();
			data[3] = $(this).parent().parent().children('td').eq(3).children('p').text();
			data[4] = $(this).parent().parent().children('td').eq(4).children('p').text();
			data[5] = $(this).parent().parent().children('td').eq(5).children('p').text();
			data[6] = $(this).parent().parent().children('td').eq(6).children('p').text();
			data[7] = $(this).parent().parent().children('td').eq(7).children('p').text();
			$(this).parent().parent().children('td').eq(0).children('input').attr('type','text').addClass('input-display');
			$(this).parent().parent().children('td').eq(1).children('input').attr('type','text').addClass('input-display');
			$(this).parent().parent().children('td').eq(2).children('input').attr('type','text').addClass('input-display');
			$(this).parent().parent().children('td').eq(3).children('input').attr('type','date').addClass('input-date');
			$(this).parent().parent().children('td').eq(4).children('input').attr('type','date').addClass('input-date');
			$(this).parent().parent().children('td').eq(5).children('input').attr('type','text').addClass('input-display');
			$(this).parent().parent().children('td').eq(6).children('input').attr('type','text').addClass('input-display');
			$(this).parent().parent().children('td').eq(7).children('input').attr('type','text').addClass('input-display');
			$(this).parent().parent().children('td').eq(8).children('button').eq(0).toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(8).children('button').eq(1).toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(8).children('button').eq(2).toggleClass('button-hidden');

			$(this).parent().parent().children('td').eq(0).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(1).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(2).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(3).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(4).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(5).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(6).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(7).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(8).children('p').toggleClass('button-hidden');
		});
		$(".button-cancel").click(function(){
			$(this).parent().parent().children('td').eq(0).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(1).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(2).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(3).children('input').attr('type','hidden').addClass('input-date');
			$(this).parent().parent().children('td').eq(4).children('input').attr('type','hidden').addClass('input-date');
			$(this).parent().parent().children('td').eq(5).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(6).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(7).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(8).children('button').eq(0).toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(8).children('button').eq(1).toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(8).children('button').eq(2).toggleClass('button-hidden');

			$(this).parent().parent().children('td').eq(0).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(1).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(2).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(3).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(4).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(5).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(6).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(7).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(8).children('p').toggleClass('button-hidden');

			$(this).parent().parent().children('td').eq(0).children('p').text(data[0]);
			$(this).parent().parent().children('td').eq(1).children('p').text(data[1]);
			$(this).parent().parent().children('td').eq(2).children('p').text(data[2]);
			$(this).parent().parent().children('td').eq(3).children('p').text(data[3]);
			$(this).parent().parent().children('td').eq(4).children('p').text(data[4]);
			$(this).parent().parent().children('td').eq(5).children('p').text(data[5]);
			$(this).parent().parent().children('td').eq(6).children('p').text(data[6]);
			$(this).parent().parent().children('td').eq(7).children('p').text(data[7]);
		});
		$(".button-confirm").click(function(){
			$(this).parent().parent().children('td').eq(0).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(1).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(2).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(3).children('input').attr('type','hidden').addClass('input-date');
			$(this).parent().parent().children('td').eq(4).children('input').attr('type','hidden').addClass('input-date');
			$(this).parent().parent().children('td').eq(5).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(6).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(7).children('input').attr('type','hidden').addClass('input-display');
			$(this).parent().parent().children('td').eq(8).children('button').eq(0).toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(8).children('button').eq(1).toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(8).children('button').eq(2).toggleClass('button-hidden');

			$(this).parent().parent().children('td').eq(0).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(1).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(2).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(3).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(4).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(5).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(6).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(7).children('p').toggleClass('button-hidden');
			$(this).parent().parent().children('td').eq(8).children('p').toggleClass('button-hidden');

			$(this).parent().parent().children('td').eq(0).children('p').text($(this).parent().parent().children('td').eq(0).children('input').val());
			$(this).parent().parent().children('td').eq(1).children('p').text($(this).parent().parent().children('td').eq(1).children('input').val());
			$(this).parent().parent().children('td').eq(2).children('p').text($(this).parent().parent().children('td').eq(2).children('input').val());
			$(this).parent().parent().children('td').eq(3).children('p').text($(this).parent().parent().children('td').eq(3).children('input').val());
			$(this).parent().parent().children('td').eq(4).children('p').text($(this).parent().parent().children('td').eq(4).children('input').val());
			$(this).parent().parent().children('td').eq(5).children('p').text($(this).parent().parent().children('td').eq(5).children('input').val());
			$(this).parent().parent().children('td').eq(6).children('p').text($(this).parent().parent().children('td').eq(6).children('input').val());
			$(this).parent().parent().children('td').eq(7).children('p').text($(this).parent().parent().children('td').eq(7).children('input').val());
		});