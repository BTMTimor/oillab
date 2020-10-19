
$(function(){
	//手机端菜单栏特效 开始
	$(document).ready(function(){
		// 浏览器的高度
		var height = $(window).height();
		// 浏览器的高度加在类名为box的DIV 上
		$(".navmain").height(height)
	})
	//点击menuOpen显示MNenuMain菜单
	$('#menuOpen').on('click', function(){
		var  menuNav=document.getElementById('MNenuMain');
		menuNav.style.display="block";
		//一开始直接隐藏菜单
		$(".SonContent").hide();
		//给标题添加点击事件
		$(".mbut").click(function () {
			//当点击的时候,打开菜单,同时其他的菜单隐藏
			$(this).next().slideDown().parent().siblings().children(".SonContent").slideUp();
		}).first().next().slideDown();
		//默认之后第一个菜单打开
	})
	$('#menuClose').on('click', function(){
		var  menuNav=document.getElementById('MNenuMain');
		$("#MNenuMain").delay(100).fadeOut("hide");
		//menuNav.style.display="none";
	})
	//手机端菜单栏特效 结束
	
	//打开顶部搜索框
	$('#searchBut').on('click', function(){
		$("#searchDiv").delay(500).fadeIn("show");
		$("#CommonMask").delay(500).fadeIn("show");
	})
	//关闭顶部搜索框
	$('#CommonMask').on('click', function(){
		$("#searchDiv").delay(500).fadeOut("hide");
		$("#CommonMask").delay(500).fadeOut("hide");
	})
	//首页-打开视频
	$('#openVideoBut').on('click', function(){
		$("#videoDiv").delay(300).fadeIn("show");
		$("#CommonMask").delay(200).fadeIn("show");
	})
	//首页-关闭视频
	$('#CommonMask').on('click', function(){
		$("#videoDiv").delay(400).fadeOut("hide");
		$("#CommonMask").delay(500).fadeOut("hide");
	})
	
	//顶部搜索关键词不能为空
	$('#serachText').on('click', function(){
		var serachKey = $("#serachKey").val();
		var url = '/why/list.html?key='+serachKey;
		//alert(1);
		if(serachKey === ''){
			$("#UpdateHint").fadeIn("slow");
		  	$("#UpdateHint").delay(3000).fadeOut("hide");
		  	$('#UpdateHint').html('<span>关键词不能为空</span>');
		}else{
			window.setTimeout(location.href = url, 100);
		}
	})
})



