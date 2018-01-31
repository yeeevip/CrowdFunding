/**
 * 
 */

$(document).ready(function(){
	
	showScroll();//显示悬浮导航
	

	$("#fabiao_pl").click(function(){
// 		int a = ${sessionScope.user.id};
// 		alert(a);
		
		
		var $content = $("#pl_content").val();//评论内容
		
		if($content == null || $content ==""){
			alert("请填写评论内容！");
			return;
		}else if(userSession){
			alert("您还没有登陆呢，请先登陆！！！");
			return;
		}
    
//     	$.getJSON('newComment.jhtml', function(data){
//     		alert("11111");
//     		console.log(data);
//     	});
    
    	
    	$.ajax({
            url: "newComment.jhtml",//要请求的服务器url 
            //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取 
            //data:{method:"ajaxTest",val:value},  
            data: {
                content: $("#pl_content").val(),
               
            },
            async: true,   //是否为异步请求
            cache: false,  //是否缓存结果
            type: "POST", //请求方式为POST
            dataType: "json",   //服务器返回的数据是什么类型 
            success: function(user){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型) 
               
            	console.log(user);
            
            //alert($(".pl_contentBox").length);
            if($(".pl_contentBox").length==5){
            $(".pl_contentBox:last").remove();}
            
            $("#plcontentBox").prepend("<div class='pl_contentBox'>"+"<div class='content_tx'>"+
                    	"<a href='javascript:;'><img src='' /></a>"+
                    "</div>"+
                    "<a href='javascript:;' class='content_nc'>用户ID"+user.id+"</a>"+
                    "<p class='content_text'>"+$content+"</p>"+
                    "<div class='content_img'>"+
                    	"<div class='contentIBox'>"+
                        	"<img src='' />"+
                        "</div>"+
                    "</div>"+
                    "<div class='pl_days'>"+
                    	"<span class='timeSpan'>3天前</span>"+
                        "<a href='javascript:;' class='to_pl'>评论(0)</a>"+
                    "</div>"+
               "</div>");
            
            }
          });
    	
    	
		
	});
	
	
	
	var vv ;
	var dd = $(".NumInner input");
	/*	$("a.det_btn1").click(function(){
		var url = window.location.href;
// 		window.open(url);
		$(".xqPageBox").hide();
		$(".zhifuInnerBox").show();
	})
    */
	$(".NumInner a:eq(0)").click(function(){
		
		
		dd.val(parseInt($(".NumInner input").val()) - 1) ;
		$(".shdzForm_xnBox .ng-binding").text(dd.val()*vv);
	})
	$(".NumInner a:eq(1)").click(function(){
		
		$(".NumInner input").val(parseInt($(".NumInner input").val()) + 1) ;
		$(".shdzForm_xnBox .ng-binding").text(dd.val()*vv);
	})
	
	//提交订单效果
	
	$(".supportVal_A").click(function(){
		$(this).hide();
		$(".tjdd_item").slideUp();
		$(this).parent().parent().addClass("cur");
		$(this).parent().parent().show();
		$(".tjddCont h3.tjdd_h3").hide();
		$(".tjddCont a.tjdd_h3").show();
		$(".tjddCont").slideDown();
		vv = $(this).parent().parent().find("input[name='repay_money']").val();
		
	})
	$(".tjddCont a.tjdd_h3").click(function(){
		$(".tjdd_item").slideDown();
		$(".tjdd_item").removeClass("cur");
		$(".supportVal_A").show();
		$(".tjddCont:last").slideUp();
	})
	
	
	//提交订单 ajax
	$(".tjdd_submitBtn").click(function(){
		if(userSession){
			alert("请登录!!!");
			return;
		}
		var address = $("select[name='province'] option:selected").text()+"|"+$("select[name='city'] option:selected").text()+"|"
						+$("select[name='district'] option:selected").text()+"|"+$("input[name='address']").val();
		
		layer.confirm('确定要提交订单吗？', {
			  btn: ['确定','取消'], //按钮
			 // closeBtn:0
			}, function(){
			$.ajax({
				url			:		"saveOrder.jhtml",
				data		:		{
										projectRepay_id	: $("input[name='repay_id']").val(),
										pay_count		: $("input[name='pay_count']").val(),
										receiver		: $("input[name='receiver']").val(),
										address			: address,
										phone			: $("input[name='phone']").val(),
										is_defaultReceive:$("input[name='is_defaultReceive']").val()
					
									},
				async		:		true,
				cache		:		false,
				type		:		"POST",
				dataType	:		"json",
				success		:		function(data){
					//data = eval('('+data+')');
					
					if(data.code=="0"){
						layer.confirm(data.msg, {
							  btn: ['确定'], //按钮
							  closeBtn:0
							}, function(){
							  //layer.msg('的确很重要', {icon: 1});
								//var index = layer.getFrameIndex(window.name); 
								//var index = layer.alert();
								//layer.close(index);
								
						        //parent.layer.close(index);
								window.location.href='showPerson.jhtml';
							});
					}else{
						var index =layer.confirm(data.msg, {
							  btn: ['确定'], //按钮
							  closeBtn:0
							}, function(){
								var index = layer.alert();
								layer.close(index);
							});
					}
				}
			});
			});
	});
	
	
})

function showScroll() {
        $(window).scroll(function () {
            var scrollValue = $(window).scrollTop();
            scrollValue > 800 ? $('.xqTab').css("position","fixed").css("top","0") : $('.xqTab').css("position","").css("top","");
        });
        
}

//使用新地址

function newAddressForm(){
	var htmlStr = '<div id="newReceive" class="shdzForm_swBox">'
			+'<div class="tjdd_formItem">'
			+'<div class="tjddQHFGBox left">'
			+'<span><input name="receiver" type="text" class="tjdd_QHInput w200" placeholder="姓名"></span>'
			+'</div>'
			+'<div class="tjddQHFGBox right">'
			+'<span><input name="phone" class="tjdd_QHInput" style="width:200px;" type="text" placeholder="手机号"></span>'
			+'</div>'
			+'</div>'
			+'<div class="tjdd_formItem">'
			+'<div class="tjddSelectBox left">'
			+'<select name="province">'
			+'<option>请选择</option>'
			+'</select>'
			+'</div>'
			+'<div class="tjddSelectBox right">'
			+'<select name="city">'
			+'<option>请选择</option>'
			+'</select>'
			+'</div>'
			+'<div class="tjddSelectBox right" style="margin-top:10px">'
			+'<select name="district">'
			+'<option>请选择</option>'
			+'</select>'
			+'</div>'
			+'</div>'
			+'<div class="tjdd_formItem">'
			+'<div class="tjddQHFGBox">'
			+'<span><input name="address" class="tjdd_QHInput w400" style="width:440px;" type="text" placeholder="详细地址"></span>'
			+'</div>'
			+'</div>'
	
			+'</div>';
	
	$("#defultReceive").remove();
	$("#newReceive").remove();
	$(".shdzListBox").after(htmlStr);
	getProvince(0,$("select[name='province']"));//所有省份
	$("#newReceive").on("change", "select[name='province']", function () {        
		getProvince($(this).val(),$("select[name='city']"));
		});
	$("#newReceive").on("change", "select[name='city']", function () {        
		getProvince($(this).val(),$("select[name='district']"));
		})

	
}

