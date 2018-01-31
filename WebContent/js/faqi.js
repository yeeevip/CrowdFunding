/**
 * 发起项目 提交信息到后台
 */


$(document).ready(function(){
	
	
//	var startText = {"detail_content1":"11111",
//					"detail_content2":"22222",
//					"detail_content3":"33333"
//											};
//	for(var a in startText){
//		alert(startText[a]);
//	}
		
	

	

	//上传封面图片 并显示
	$("#set_cover").uploadify({
        'swf'					: 'js/uploadify/uploadify.swf',
        'uploader'				: 'upload_cover.jhtml',//后台处理程序的相对路径，默认值uploadify.php
        'onInit'				: function () {$(".uploadify-queue").hide();},     //载入时触发，将flash设置到最小
            
//          'removeTimeout' 	: 1000,
//         'queueID' 			: 'custom-queue',//进度条
        'buttonText' 			: '',//默认值SELECT FILES，定义按钮的文字
//        'buttonClass' 		: 'some-class',//自定义的样式类名,设置按钮的样式类，注意：样式的hover也设置下
        'auto'					:true,//auto:布尔类型，设置为true时，选择文件后将自动上传，设置为false则需要调用上传方法触发
        'multi'					:false,//默认值true，是否允许多文件上传。
        'uploadLimit' 			: 100,//默认值999，上传的最大文件数
//         'checkExisting' 		: '/uploadify/check-exists.php',//定义后台检测文件是否存的程序，存在返回1，不存在返回0
        'fileTypeDesc' 			: 'Image Files',
        'fileTypeExts' 			: '*.gif; *.jpg; *.png',//默认值*.*，定义可以上传的文件类型
//        'formData'      		: {'someKey' : 'someValue', 'someOtherKey' : 1},//JSON类型，默认为Empty Object包含额外数据的JSON对象，在上传文件时通过POST或get方式发送给服务端。
        'height'   				: 60,//默认30，单位像素，上传按钮的高度
        'width'    				: 500,//默认值120，单位为像素，上传按钮的宽度
        'method'   				: 'post',//默认值post，表单提交的方式。
//         'progressData' 		: 'percentage',//默认值percentage，上传数据时有queue显示的进度显示方式，两个类型percentage’ 和 ‘speed’.
        'onSelectError' 		: function() {alert(this.queueData.errorMsg);},//没有重写默认事件的情况下，可使用this.queueData.errorMsg返回详细的错误信息。
            
                
        'onUploadComplete' 		: function(file) { }, //上传完成发生,指提交完成

      
        'onUploadError' 		: function(file, errorCode, errorMsg, errorString) { 
            console.log(file); 
        },
        
        'onUploadSuccess' 		: function(file, data, response) {
        	console.log(data);        
/*    		$("#cover_show").remove();
    		$("#show_cover").prepend('<img id="cover_show" width="400px" height="300px" src=>');*/
        	
        	$("#cover_show").remove();
        	$("#show_cover").prepend('<img id="cover_show" width="400px" height="300px" src='+data+'>');
//            alert('The file ' + file.name + ' was successfully uploaded with a response of ' + response + ':' + data);
        },////上传成功，上传成功后触发，还3个参数,file：上传成功的文件对象,data：服务端返回的数据,response：响应服务端返回的成功信息true，如返回false，则在successTimeout后呈现响应。

        
    });
	
	
	
    /**
     * 详情图片
     */

	 $(".uploadPic").each(function(){

		 var div = $(this).parent().parent().parent().parent().parent().parent().find(".upload_detital_pic");
		 
		 $(this).uploadify({
		    	'swf'				: 'js/uploadify/uploadify.swf',
		    	 'uploader'			: 'upload_detail.jhtml',//后台处理程序的相对路径，默认值uploadify.php
		    	'height'   			: 67,
		    	'width'				:67,
		    	/*'removeTimeout' 	: 10000,*/
		    	'buttonText' 		: '',   //默认值SELECT FILES，定义按钮的文字(非同时)
		        'uploadLimit' 		: 100,//默认值999，上传的最大文件数
		        'auto'				:true,//auto:布尔类型，设置为true时，选择文件后将自动上传，设置为false则需要调用上传方法触发
		        'multi'				:false,//默认值true，是否允许多文件上传。
		        'method'   			: 'post',//默认值post，表单提交的方式。
		        'fileTypeDesc' 		: 'Image Files',
		        'fileTypeExts' 		: '*.gif; *.jpg; *.png',//默认值*.*，定义可以上传的文件类型
		        'onInit'			: function () {$(".uploadify-queue").hide();},//载入时触发，将不显示进度条
		        'onUploadSuccess' 	: function(file, data, response) { 
		        	div.append('<img src='+data+'>');
		        },
		    })
	 });
	 
	 
	 
	    /**
	     * 身份证 公司 图片
	     */

		 $(".uplodify_in_repeat_0person").each(function(){

			 var div = $(this).parent().parent().find(".material-list-pic");
			 
			 $(this).uploadify({
			    	'swf'				: 'js/uploadify/uploadify.swf',
			    	 'uploader'			: 'upload_IDphoto.jhtml',//后台处理程序的相对路径，默认值uploadify.php
			    	'height'   			: 67,
			    	'width'				:67,
			    	/*'removeTimeout' 	: 10000,*/
			    	'buttonText' 		: '',   //默认值SELECT FILES，定义按钮的文字(非同时)
			        'uploadLimit' 		: 100,//默认值999，上传的最大文件数
			        'auto'				:true,//auto:布尔类型，设置为true时，选择文件后将自动上传，设置为false则需要调用上传方法触发
			        'multi'				:false,//默认值true，是否允许多文件上传。
			        'method'   			: 'post',//默认值post，表单提交的方式。
			        'fileTypeDesc' 		: 'Image Files',
			        'fileTypeExts' 		: '*.gif; *.jpg; *.png',//默认值*.*，定义可以上传的文件类型
			        'onInit'			: function () {$(".uploadify-queue").hide();},//载入时触发，将不显示进度条
			        'onUploadSuccess' 	: function(file, data, response) { 
			        	div.empty();
			        	div.append('<img id="shenfenxinxi" src='+data+'>');
			        },
			    })
		 });

	
/*	$("#set_cover").change(function(e){
//		var str = $(this).val();
		var url = getFileUrl("set_cover");
		
		$("#show_cover").prepend('<img width="400px" height="300px" src='+url+'>');
		

		alert("1111");
		
		
//		var arr=str.split('\\');//注split可以用字符或字符串分割 
//		var my=arr[arr.length-1];//这就是要取得的图片名称 
		
//		console.log($("#basis_info input[name=cover_img]").val());
	})*/

	
	//项目类型选项
	$(".fq_lxItem a").click(function(){
		$(".fq_lxItem a").removeClass("cur");
		$(this).addClass("cur");
	})
	//表单填写切换
	$(".fq_topBox li").click(function(){
		$(".fq_topBox li").removeClass("curr")
		$(this).addClass("curr");
	});

	/**
	 * 提交
	 */
    
	$(".submitSH").click(function(){
		
		
		layer.confirm('确定要提交项目吗？', {
			  btn: ['确定','取消'], //按钮
			 // closeBtn:0
			}, function(){
			  //layer.msg('的确很重要', {icon: 1});
				
//				var img ="";
//				re = new RegExp("\n", "g");
//				for(var i=0;i<$("#detail_info textarea").length;i++){
//					for(var j=0;j<$(".upload_detital_pic img").length;j++){
//						img = img + "<img src="+$('.upload_detital_pic img')[i].attr('src') +" class='lazy' style='width:670px; height:10px' />";
//						$("#detail_info textarea")[i].val("<b>"+$("#detail_info textarea")[i].val().replace(re,"</b><b>")+
//								"</b>"+img);
//					}
//				}

					addTextArray();//保存开始的文本

					textToHtml($("#detail_info textarea")); //textare的value转htnl
			    	var proRuestl_1 = $("#basis_info").serializeJson();//数据序列化
			    	var project_type = $(".fq_lxItem a.cur").attr("index");//项目类别
			    	
			    	proRuestl_1.project_type = project_type;
			    	var proRuestl_2= $("#detail_info").serializeJson();//数据序列化
			    	var cover_img = $("#cover_show").attr("src");//项目封面路径
			    	proRuestl_1.cover_img = cover_img;
			    	var proRuestl_3= $("#repay_info").serializeJson();//数据序列化
			    	var repay_type1 = $("#repay_info input[name=repay_type1]:checked").val();
			    	proRuestl_3.repay_type1 = repay_type1;
			    	
			    	var proRuestl_4= $("#identityInfo").serializeJson();//数据序列化
			    	var szimg = $("img#shenfenxinxi:eq(0)").attr("src");
			    	var sfimg = $("img#shenfenxinxi:eq(1)").attr("src");//alert($("img#shenfenxinxi").length);
			    	proRuestl_4.szimg = szimg;
			    	proRuestl_4.sfimg = sfimg;
			    
			    	

			    	var param;

			    	param = $.extend(proRuestl_1,proRuestl_2,proRuestl_3,proRuestl_4);
			    	
			    	 console.log(param);

//				return;//test
				
				$.ajax({
					url:"issueProject.jhtml",
					data:param,

					async:true,
					cache:false,
					type: "POST", //请求方式为POST
					dataType:"",
					success:function(data){
						data = eval('('+data+')');
						if(data.code=="0"){
							layer.confirm(data.msg, {
								  btn: ['确定'], //按钮
								  closeBtn:0
								}, function(){
								  //layer.msg('的确很重要', {icon: 1});
//									var index = parent.layer.getFrameIndex(window.name); 
//							        parent.layer.close(index);
									window.location.href='showPerson.jhtml';
								});
						}else{
							var index =layer.confirm(data.msg, {
								  btn: ['确定'], //按钮
								  closeBtn:0
								}, function(){
								  //layer.msg('的确很重要', {icon: 1});
//									var index = parent.layer.getFrameIndex(window.name); 
//							        parent.layer.close(index);
								//	window.location.href='showPerson.jhtml';
									layer.close(index);
								});
						}
						
						
						
						
						renewText();
					}
				});
				
			});
		
		
//		if(confirm("确定要发布项目吗？")){
//			
//
//			
//		}

		
		
	})
	
	
	
})

			/**
 * //序列化多个表单
 */
$.fn.serializeJson = function() {
	var serializeObj = {};
	var array = this.serializeArray();
	var str = this.serialize();
	$(array).each(
			function() {
				if (serializeObj[this.name]) {
					if ($.isArray(serializeObj[this.name])) {
						serializeObj[this.name].push(this.value);
					} else {
						serializeObj[this.name] = [ serializeObj[this.name],
								this.value ];
					}
				} else {
					serializeObj[this.name] = this.value;
				}
			});
	return serializeObj;
}


var textArr = new Array();//一开始的textarea
/**
 * 保存开始textarea纯文本的val
 */
function addTextArray(){
	textArr = [];
	$("#detail_info textarea").each(function(){

		textArr.push($(this).val());	
		
	})
	
}
/**
 * 回复开始的textarea
 */
function renewText(){
	for(var i=0;i<$("#detail_info textarea").length;i++){
		$("#detail_info textarea:eq("+i+")").val(textArr[i]);
//		alert(textArr[i]);
	}
}
	


/**
 * 详情内容+图片转换成html
 */

function textToHtml(obj){
	var img ="";
	
	re = new RegExp("\n", "g");
	obj.each(function(){
		//alert($(this).parent().parent().find("img").length);
		
		$(this).parent().parent().find("img").each(function(){
			//var $this = $(this).parent().parent().find("img");

			img = img + "<img src='"+$(this).attr("src") +"' class='lazy' style='width:670px; height:100%' />";	
			
		})
		$(this).val("<p>"+$(this).val().replace(re,"</p><p>")+"</p>"+img);
		
		img ="";//清空
		
	})
}

/**
 * 预览页  数据
 */

function yulan(){
	$(".xqText").children().remove();
	addTextArray();
	$(".det_left img").attr("src",$("#show_cover img").attr("src"));//封面
	$(".text_h3").text($("#basis_info input[name=p_title]").val());//标题
	$(".jindu_s .s_s b").text($("#basis_info input[name=days_raising]").val()+"天");//筹资天数
	$(".jindu_s .s_m b").text("￥"+$("#basis_info input[name=total_fund_raising]").val());//筹资总额
	textToHtml($("#detail_info textarea"));//textare的value转htnl
	
	for(var i=0;i<$(".fq_body_ul.detail").length;i++){
		var title = "";
		var content = "";
		//alert($("#detail_info textarea")[i].value);
		title = $(".text_title input")[i].value;
		content = $("#detail_info textarea")[i].value;

		$(".xqText").append('<div class="xqTextTitle">'+
		                            '<p class="xqTextTitle_p"></p>'+
		                            '<div class="xqLeftTitleInner">'+'<h2>'+title+'</h2>'+'</div>'+'</div>'+content);
	}
	
	
	$(".zcje_ItemBox").remove();
	for(var i=0;i<$("input[name='repayCount']").val();i++){
		var title = "";
		var content = "";
//		alert($("#detail_info textarea")[i].value);
		title = $("input[name='repay_title"+(i+1)+"']").val();
		content = $("textarea[name='repay_content"+(i+1)+"']").val();
		var money = $("input[name='repay_money"+(i+1)+"']").val();
		var time = $("input[name='repay_time"+(i+1)+"']").val();
		var htmlStr = '<div class="zcje_ItemBox">'
			+'<h3 class="zcje_h3"><b>¥'+money+'</b>0人已支持</h3>'
			+'<div class="zcje_title">'+title+'</div>'
			+'<p class="zcje_textP">'+content+'</p>'
			+'<div class="zcjeFooter">'
			+'<p class="">回报方式：<b></b></p>'
			+'<p class="">预计回报发送时间：<b>项目结束后立即'+time+'天内</b></p>'
			+'</div>'
			+'<div class="">'
			+'<span class=""></span>'
			+' <a href="javascript:;" class=""></a>'
			+'</div>'
			+'</div>';
		
		$(".zcjeBox").append(htmlStr);
	}
	renewText();
//	alert(textArr[0]);
}
    
//添加新的回报
var countRepay = 1 ;
function addRepay(){
	var htmlStr = '<div>'
		+'<div style="width:660px;margin:0 auto;"><h3 class="return-tit">回报'+(countRepay+1)+'</h3></div>'
		+'<div class="fq_body_ul">'
		+'<ul style="margin-top:20px">'
		+'<li >'
		+'<label>回报类型：</label>'
		+'<input  name="repay_type'+(countRepay+1)+'" value="实物" type="radio" style="width:17px;" checked /><span style="padding-left:10px;padding-right:20px;">实物回报(回报需要邮寄)</span>'
		+'<input  name="repay_type'+(countRepay+1)+'" value="虚拟" type="radio" style="width:17px;" /><span style="padding-left:10px;">虚拟回报(回报无要邮寄)</span>'
		+'</li>'
		+'<li>'
		+'<label>支持金额：</label>'
		+'<input  name="repay_money'+(countRepay+1)+'" type="text" value="0" placeholder="输入用户支持的金额(必填)"  /><em>元</em>'
		+'</li>'
		+'<li>'
		+'<label>回报标题：</label>'
		+'<input  name="repay_title'+(countRepay+1)+'" type="text" placeholder="输入回报标题（必填）" />'
		+'</li>'
		+'<li>'
		+'<label>回报内容：</label>'
		+'<textarea  name="repay_content'+(countRepay+1)+'" style="width:450px;height:80px;padding:5px 10px;" placeholder="回报内容（必填）"></textarea>'
		+'</li>'
		+'<li>'
		+'<label>回报时间：</label>'
		+'<input  name="repay_time'+(countRepay+1)+'" type="text" placeholder="0" value="0"  /><em>天</em>'
		+'</li>'
		+'</ul>'
		+'<div class="hb_save" style="border-bottom: 2px solid #e3e3e3;">'
		+'<a href="javascript:removeRepay();" style="" class=" removeRepay btn-blue small btn mr12">删除</a>'
		+'<a href="javascript:;" class="btn-grey small btn mr12">保存</a>'
		+'</div>'
		+'</div>'
		+'</div>';
	
	$("#repay_info").append(htmlStr);
	countRepay++;
	$("input[name='repayCount']").val(countRepay);
	
	$(".hb_save").off("click", ".removeRepay");
	$(".hb_save").on("click", ".removeRepay", function () {        
		$(this).parent().parent().parent().remove();
		console.log(countRepay);
		countRepay--;
		console.log(countRepay);
		$("input[name='repayCount']").val(countRepay);
		});

	
}


//更新项目最新动态
function updateProjectProcess(){
	
	

	addTextArray();//保存开始的文本

	textToHtml($("#detail_info textarea")); //textare的value转htnl
	
	//内容
	var projectId = $("#updateProjectProgress input[name='projectId']").val();
	var content = $("#updateProjectProgress textarea[name='detail_content1']").val();
	
	
	
	
	
	$.ajax({
		url:"updateProjectProgressAction",
		data:{projectId:projectId,content:content},

		async:true,
		cache:false,
		type: "POST", //请求方式为POST
		dataType:"",
		success:function(data){
			//alert(data);
			data = eval('('+data+')');
			
			if(data.code=="0"){
				layer.confirm(data.msg, {
					  btn: ['确定'], //按钮
					  closeBtn:0
					}, function(){
					  //layer.msg('的确很重要', {icon: 1});
						var index = parent.layer.getFrameIndex(window.name); 
				        parent.layer.close(index);
						//window.location.href='showPerson.jhtml';
					});
			}else{
				var index =layer.confirm(data.msg, {
					  btn: ['确定'], //按钮
					  closeBtn:0
					}, function(){
					  //layer.msg('的确很重要', {icon: 1});
//						var index = parent.layer.getFrameIndex(window.name); 
//				        parent.layer.close(index);
					//	window.location.href='showPerson.jhtml';
						layer.close(index);
					});
			}
			
			
			
			
			renewText();
		}
	});
	

	
	
/*	

	//询问框
	layer.confirm('发布成功', {
	  btn: ['确定'], //按钮
	  closeBtn:0
	}, function(){
	  //layer.msg('的确很重要', {icon: 1});
		var index = parent.layer.getFrameIndex(window.name); 
        parent.layer.close(index);
	});
*/
	
}

