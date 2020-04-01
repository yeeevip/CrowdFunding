/**
 * 
 */

/*********个人中心页面切换******/

var f_display = function(divId){
	var c_displays =  document.querySelectorAll(".c_display");
	for(var i=0;i<c_displays.length;i++){
		
		c_displays[i].style.display="none";
	}
	document.querySelector("#"+divId).style.display="block";
}


/*****头像资料切换********/
function changeTXBox(a){
	if(a==1){
		document.getElementById('ziliaoBj').style.display="";
		document.getElementById('touxiangBj').style.display="none";
	}
	else if(a==2){
		document.getElementById('ziliaoBj').style.display="none";
		document.getElementById('touxiangBj').style.display="";
	}
}

function addReceiveInfo(){
	//内容
	var receiver = $("input[name='receiver']").val();
	var phone =$("input[name='phone']").val();
	var zipcode =$("input[name='zipcode']").val();
	var address =$("select[name='province'] option:selected").text()+"|"+$("select[name='city'] option:selected").text()+"|"+$("input[name='address']").val();

	$.ajax({
		url:"addReceiveInfo",
		data:{receiver:receiver,phone:phone,zipcode:zipcode,address:address},

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

		}
	});
}



/**修改资料***/

$(document).ready(function(){
	
	
	
	//初始化日历
	
	calender('#calender').init({    
	    //date : [2015,12,12], //设置默认显示年月日，默认当前年月日       
	    format : 'yyyy-MM-dd', //设置显示格式  
	    button : false ,//是否显示按钮    
	    left : 0, //追加left，默认0
	    top :0, //追加top，默认0
	    onload : function(){  } //初始化完成执行，this为当前创建的日历对象  
	},function(date){    
	    //回调函数    
	    this.value = date  ;  
	});
	
	
	
	//收货地址
	
	$(".new_shdzBtn").click(function(){
		

		layer.open({
		      type: 2,
		      title: '增加收货信息',
		      shadeClose: true,
		      shade: false,
		      maxmin: false, //开启最大化最小化按钮
		      area: ['600px', '400px'],
		      content: ['ReceiveInfoPage','no']
		    });

		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	$(".ziLiao_box_submit").click(function(){

    	var sex = $("#user_ziliao input[name='sex']:checked").val();//性别
    	var user_name = $("#user_ziliao input[name='user_name']").val();//用户名
    	var phone = $("#user_ziliao input[name='phone']").val();//手机
    	var email = $("#user_ziliao input[name='email']").val();//邮箱
    	var real_name = $("#user_ziliao input[name='real_name']").val();//真实姓名
    	var id_number = $("#user_ziliao input[name='id_number']").val();//身份证号码
    	
//    	alert(user_name);
		
    	$.ajax({
            url: "reviseUser.jhtml",//要请求的服务器url 
            //这是一个对象，表示请求的参数，两个参数：method=ajax&val=xxx，服务器可以通过request.getParameter()来获取 
            //data:{method:"ajaxTest",val:value},  
            data: {
            	sex: sex,
                user_name: user_name,
                phone: phone,
                email: email,
                real_name: real_name,
                id_number: id_number
               
            },
            async: true,   //是否为异步请求
            cache: false,  //是否缓存结果
            type: "POST", //请求方式为POST
            dataType: "json",   //服务器返回的数据是什么类型 
            success: function(result){  //这个方法会在服务器执行成功是被调用 ，参数result就是服务器返回的值(现在是json类型) 
            	console.log(result);
            	if(result)
            		alert("修改成功！！！");
            }
          });

	})
	
	/**
	 * 买家订单查询
	 */
	$("#myOrderShow").click(function(){
		$.ajax({
			url		:	"buyerOrder.jhtml",
			async	:	true,
			cache	:	false,
			type	:	"POST",
			dataType:	"json",
			success :	function(Ojson){
				$("#myOrderTbody").find("tr").remove();
				for(var i=0;i<Ojson.length;i++){
					
					var payState = "";
					if(Ojson[i].is_pay==0){
						payState="未支付"
					}
					if(Ojson[i].is_pay==1){
						payState="支付成功"
					}
					
					var html = '<tr class="trfirst"><td colspan="7"></td></tr>'+
                        	'<tr class="ftTr">'+
                        		'<td colspan="6">创建时间：'+Ojson[i].order_date+
                        			'<span class="dingdan">订单号码:'+Ojson[i].id+'</span><span  class="dingdan">发起人:'+Ojson[i].user_seller.user_name+'</span>'+
                        		'</td>'+
                        		'<td><a href="javascript:;" class="ftTr_delA" title="删除"></a></td>'+
                        	'</tr>'+
                        	'<tr class="inforTr">'+
                        		'<td>'+
                        			'<div class="ddImgBox"><a href="javascript:;" target="_blank"><img style="width:80px;height:60px;" src="'+Ojson[i].project.img_name+'"></a></div>'+
                        			'<div class="ddImgText"><a href="javascript:;" target="_blank">'+Ojson[i].project.title+'</a></div>'+
                        		'</td>'+
                        		'<td><div><p class="inforText_p gray">'+Ojson[i].project.is_audits+'</p></div></td>'+
                        	'	<td>'+
                        			'<div class="ddImgText"><a href="javascript:;" target="_blank" title="'+Ojson[i].projectrepay.title+'----'+Ojson[i].projectrepay.content+'">'+Ojson[i].projectrepay.title+'----'+Ojson[i].projectrepay.content+'</a></div>'+
                        		'</td>'+
                        		'<td><div><p class="inforText_p gray">'+Ojson[i].payPrice+'元</p></div></td>'+
                        		'<td><div><p class="inforText_p gray">'+Ojson[i].count+'</p></div></td>'+
                        		'<td><div><p class="inforText_p gray">'+payState+'</p></div></td>'+
                        		'<td class="btnTd">'+
                        			'<div class="operations">';
                        		
                        		if(Ojson[i].is_pay==1){
                        			html = html+'<a href="javascript:;" class="ddLastbtn_A">确认收货</a><a href="javascript:;" class="ddLastbtn_A">我要投诉</a></td></tr>';
                        		}else{
                        			html = html+'<a href="javascript:toPay('+Ojson[i].id+');" class="ddLastbtn_A">去支付</a></td></tr>';
                        		}
                        		
                        		
                        $("#myOrderTbody").append(html);
				}
			}
		});
	});
	
	/**
	 * 卖家订单管理
	 */
	$("#myProjectShow").click(function(){
	
		$.ajax({
			url			:		"sellerOrder.jhtml",
			async		:		true,
			cache		:   	false,
			type		:		"POST",
			dataType	:		"json",
			success		:		function(Ojson){
				$("#myProjectTbody").find("tr").remove();
				for(var i=0;i<Ojson.length;i++){
					
					var payState = "";
					if(Ojson[i].is_pay==0){
						payState="未支付"
					}
					if(Ojson[i].is_pay==1){
						payState="支付成功"
					}
					
					$("#myProjectTbody").append('<tr class="trfirst"><td colspan="4"></td></tr><tr class="u_tbg_tr" style="height:50px;margin-bottom:10px">'+
							'<td>'+Ojson[i].id+'</td>'+
							'<td>'+Ojson[i].project.title+'</td>'+
							'<td>'+Ojson[i].projectrepay.title+'</td>'+
							'<td>'+Ojson[i].user.user_name+'</td>'+
							'<td>'+Ojson[i].order_date+'</td>'+
							'<td>'+Ojson[i].count+'</td>'+
							'<td>'+Ojson[i].payPrice+'</td>'+
							'<td>'+Ojson[i].receiveInfo.receiver+'</td>'+
							'<td>'+Ojson[i].receiveInfo.address+'</td>'+
							'<td>'+Ojson[i].receiveInfo.phone+'</td>'+
							'<td>'+payState+'</td>'+
							'<td><a href="javascript:;" target="" class="search_btn">发货</a></td>'+
							
					'</tr>');
				}
				
			}
		});
	});
	
	
	
	/**
	 * 收货地址
	 */
	$("#showMyReceive").click(function(){
	
		$.ajax({
			url			:		"queryReceiveInfo",
			async		:		true,
			cache		:   	false,
			type		:		"POST",
			dataType	:		"json",
			success		:		function(Ojson){
				$("#myReceive_tbody").find("tr").remove();
				for(var i=0;i<Ojson.length;i++){
				
					var html = '<tr class="trfirst"><td colspan="4"></td></tr>'
						+'<tr class="u_tbg_tr" style="height:50px;margin-bottom:10px">'
						+'<td>'+Ojson[i].receiver+'</td>'
						+'<td>'+Ojson[i].address+'</td>'
						+'<td>'+Ojson[i].zippost+'</td>'
						+'<td>'+Ojson[i].phone+'</td>';
					if(Ojson[i].is_default=="0"){
						html =html +'<td><a   onclick="setDefaultReceiveInfo('+Ojson[i].id+')">设为默认</a></td></tr>';
					}else if(Ojson[i].is_default=="1"){
						html =html +'<td>默认</td></tr>';
					}else{
						html =html +'<td></td></tr>';
					}
					
					$("#myReceive_tbody").append(html);
							
				}
				
			}
		});
	});
	
	
	
	
	
	
	
	
	
	$("#myprojectFlip .fy_page").click(function(){
		
		//alert($(this).html());
		var $this = $(this);
		
		$.ajax({
			url			:		"getMyProjectPageShow",
			data		: {currentPage:$this.html()},
			async		:		true,
			cache		:   	false,
			type		:		"POST",
			dataType	:		"json",
			success		:		function(Ojson){
				
				$("#myprojectFlip .fy_page").removeClass("cur");
				
				$("#myProject_tbody_ajax").find("tr").remove();
				for(var i=0;i<Ojson.length;i++){
					var projectState = "";
					if(Ojson[i].is_audits==1&&Ojson[i].is_finish==0){
						projectState ="正在集资";
					}
					if(Ojson[i].is_audits==1&&Ojson[i].is_finish==-1 ){
						projectState = "集资失败";
					}
					if(Ojson[i].is_audits==1&&Ojson[i].is_finish==1 ){
						projectState = "集资成功";
					}
					if(Ojson[i].is_audits==0 ){
						projectState = "未审核";
					}
					if(Ojson[i].is_audits==-1 ){
						projectState = "未通过审核";
					}
					
					var percent=Ojson[i].has_fund_raising/Ojson[i].total_fund_raising*100;
					
					percent = percent.toFixed(2);
					
					
					
					$("#myProject_tbody_ajax").append('<tr class="trfirst"><td colspan="4"></td></tr>'
                        	+'<tr class="ftTr">'
                        	+'<td colspan="4">创建时间：'+Ojson[i].launch_date+'</td>'
                        	+'<td><a href="javascript:;" class="ftTr_delA" title="删除"></a></td>'
                        	+'</tr>'
                        	+'<tr class="inforTr" project_id="">'
                        	+'<td>'
                        	+'<div class="ddImgBox"><a href="javascript:;" target="_blank"><img style="width:80px;height:60px;" src="'+Ojson[i].img_name+'"></a></div>'
                        	+'<div class="ddImgText"><a href="javascript:;" target="_blank">'+Ojson[i].title+'</a></div>'
                        	+'</td>'
                        	+'<td>'
                        	+'<div>'
                        	+'<p class="inforText_p gray">'
                        	+projectState
                        	+'</p>'
                        	+'</div></td>'
                        	+'<td>'
                        	+'<p class="inforText_p ">目标：'+Ojson[i].total_fund_raising +'元</p>'
                        	
                        	+'<div class="inforRatioBox">'
                        	+'<div class="inforRatio"><div class="inner" style="width:'+percent+'%"></div></div>'
                        	+'<span>'+percent+'%</span> '
                        	+'</div>'
                        	+'</td>'
                        	+'<td><div><p class="inforText_p gray">不可结算</p></div></td>'
                        	+'<td class="btnTd">'
                        	+'<div class="operations">'
                        	+'<a href="javascript:goProjectProcess('+Ojson[i].project_id +');" target="_blank" class="ddLastbtn_A">更新最新进展</a>'
                        	
                        	+'</td>'
                        	+'</tr>');
				}
				$this.addClass("cur");
				
			}
		});
		
		
	});
		
	
})



//更新项目最新状态
function goProjectProcess(project_id){

	debugger

	layer.open({
	      type: 2,
	      title: '发布项目最新动态',
	      shadeClose: true,
	      shade: false,
	      maxmin: false, //开启最大化最小化按钮
	      area: ['893px', '600px'],
	      content: ['projectProcessPage?project_id='+project_id,'no']
	    });

	
}

function setDefaultReceiveInfo(receiveId){
	
	$.get("setDefaultReceiveInfo?receiveId="+receiveId,function(data){
		data = eval('('+data+')');
		
		if(data.code=="0"){
			layer.confirm(data.msg, {
				  btn: ['确定'], //按钮
				  closeBtn:0
				}, function(){
				  //layer.msg('的确很重要', {icon: 1});
					//var index = layer.getFrameIndex(window.name); 
					var index = layer.alert();
					layer.close(index);
					
			      //  parent.layer.close(index);
					//window.location.href='showPerson.jhtml';
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
	});
}




//去支付


function toPay(order_id){
	
	layer.confirm('确定要付款吗？', {
		  btn: ['确定','取消'], //按钮
		 // closeBtn:0
		}, function(){
		$.ajax({
			url			:		"toPay",
			data		:		{order_id:order_id},
			async		:		true,
			cache		:		false,
			type		:		"POST",
			dataType	:		"json",
			success		:		function(data){
				//data = eval('('+data+')');
				//alert(data);
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

}



