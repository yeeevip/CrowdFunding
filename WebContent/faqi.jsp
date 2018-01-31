<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="css/faqi.css">
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/project.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="js/faqi.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2/js/Validform_v5.3.2.js"></script>
<link type="text/css" rel="stylesheet" href="js/Validform_v5.3.2/css/style.css">
<script type="text/javascript" src="js/common.js"></script>

<script>
$(document).ready(function(){
	$(".demoform").Validform();
	
//预览
	$(".fq_top").find("a.preview").click(function(){
		$(".fq_body1").hide();
		$(".xxr5").slideDown(300);
		$(".fq_footer").hide();
		
		yulan();
		
	}	);
	
});

//个人和企业切换
function pOrComChange($obj){
	
	$(".gerenInfo").hide();
	$(".qiyeInfo").hide();
	$obj.show();
	$obj.parent().find(".identity-type-hd a").removeClass("cur");
	$obj.parent().find(".identity-type-hd a:focus").addClass("cur");
	$(".fq_body1.xxr1 form").removeAttr("id");
	/* $(".fq_body1.xxr1 form:eq(1)").removeAttr("id"); */
	$obj.find("form").attr("id","identityInfo");
}

//顶部导航栏切换
function changeBox($obj){
	$(".fq_body1").hide();
	$obj.slideDown(300);
	$(".fq_footer").show();
	aCss();
}



//下一步上一步
function preB(){
	
	var aa = $(".fq_body1:visible");
// 	alert(aa.attr('class')!="fq_body1 xxr1");
	if(aa.attr('class')!="fq_body1 xxr1"){
		aa.hide();
		aa.prev().show();
		
	}
	aa = $(".fq_body1:visible");
	daoHang(aa);
	aCss();

}
function nextB(){
	
	var aa = $(".fq_body1:visible");
	
// 	alert(aa.attr('class')!="fq_body1 xxr3");
	if(aa.attr('class')!="fq_body1 xxr4"){
		aa.hide();
		aa.next().show();
		
	}
	aa = $(".fq_body1:visible");
	daoHang(aa);
	aCss();
	
}



//提交和下一步样式同时变化
function aCss(){
	if($(".fq_body1:visible").attr('class')!='fq_body1 xxr4')
	{
		$(".fq_footer a:eq(1)").show();
		
		$(".fq_footer a.submitSH").hide();
	}else{
		$(".fq_footer a:eq(1)").hide();
		
		$(".fq_footer a.submitSH").show();
	}
}
//导航栏变化
function daoHang(obj){
	$(".fq_topBox li").removeClass("curr");
	if(obj.attr('class')=="fq_body1 xxr1"){
		$(".fq_topBox li:eq(0)").addClass("curr");
	}else if(obj.attr('class')=="fq_body1 xxr2"){
		$(".fq_topBox li:eq(1)").addClass("curr");
	}else if(obj.attr('class')=="fq_body1 xxr3"){
		$(".fq_topBox li:eq(2)").addClass("curr");
	}else if(obj.attr('class')=="fq_body1 xxr4"){
		$(".fq_topBox li:eq(3)").addClass("curr");
	}
}

</script>

<title>发起项目</title>
</head>
<body>
<%@ include file="/common/header.jsp"%>
<!--项目发起begin-->
<div class="pj_fq">
	<div class="fq_top">
		<div class="fq_topBox">
	    	<ul>
	    		<a href="javascript:changeBox($('.xxr1'))"><li class="curr">基本信息</li></a>
	        	<a href="javascript:changeBox($('.xxr2'))"><li class="">项目信息</li></a>
	            <a href="javascript:changeBox($('.xxr3'))"><li>详细描述</li></a>
	            <a href="javascript:changeBox($('.xxr4'))"><li>回报设置</li></a>
	            
	        </ul>
	        <a href="javascript:;" class="preview">预览</a>
	    </div>
    </div>
    <!--项目信息begin-->
   	<div class="fq_bodyBox">
	   	<div class="fq_bodyMainBox">
	   		
	   		<!-- 基本信息begin -->
	        <div class="fq_body1 xxr1" >
	       
	            <div class="body1_h2Box"><h2 class="fq_body1_h2">选择你的身份类型</h2></div>
	            <ul class="identity-type-hd">
	                 <a href="javascript:pOrComChange($('.gerenInfo'))" class="cur">个人</a>
	                 <a href="javascript:pOrComChange($('.qiyeInfo'))">机构</a>
	            </ul>
	         <!-- 个人begin -->
	       	 <div class="gerenInfo">
	        
	            <div class="fq_body1_content">
	                <form id="identityInfo"  method="post" >
              <input type="hidden" name="idType" value="个人">
	                    <ul class="fq_body_ul">
	                    	
	                    	
	                        
	                        <li>
	                            <label>姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</label>
	                            <input name="name" type="text" placeholder="输入中文姓名，2~20个字符(需与结算时的银行卡开户名一致)" datatype="s5-16" errormsg="昵称至少5个字符,最多16个字符！" />
	                            
	                        </li>
	                        <li>
	                            <label>身份证号：</label>
	                            <input name="IDnumber" type="number" placeholder="二代身份证，输入数字或字母"  />
	                            
	                        </li>	                        
	                        <li>
	                            <label>手机号&nbsp;&nbsp;&nbsp;：</label>
	                            <input name="phone" type="number" placeholder="手机号，输入纯数字，10~15位数字"  />
	                            
	                        </li>
	                        <li class="province-selector" style="overflow:hidden">
	                            <label>所在地区：</label>
	                            <select name="province" class=""><option>省份</option></select>
	                            <select name="city" class=""><option>市/区</option></select>

	                            
	                        </li>
	                        
	                    </ul>
	                </form>
	            </div>
	            <div class="body1_h2Box"><h2 class="fq_body1_h2">上传相关材料</h2></div>
	            <ul class="fq_body_ul" style="padding-bottom:25px;">
	            	<div class="material-list">
	            		<span>个人身份证-正面</span>
	            		<div class="material-list-pic"></div>
	            		<div style="left:351px;height: 60px;width: 100px;position:absolute;">
	            			<div class="uplodify_in_repeat_0person-button">上传</div>
	            			<input style="opacity:0;" type="file" class="uplodify_in_repeat_0person"  id="uplodify_in_repeat_0person1">
	            			
	            		</div>
	            	</div>
	            	<div class="material-list">
	            		<span>个人身份证-反面</span>
	            		<div class="material-list-pic"></div>
	            		<div style="left:351px;height: 60px;width: 100px;position:absolute;">
	            			<div class="uplodify_in_repeat_0person-button">上传</div>
	            			<input style="opacity:0;" type="file" class="uplodify_in_repeat_0person" id="uplodify_in_repeat_0person2">
	            			
	            		</div>
	            	</div>
	            </ul>
	            <div class="body1_h2Box"><h2 class="fq_body1_h2">选择平台渠道费</h2></div>
	            <ul class="fq_body_ul" style="font-size: 14px;padding: 14px 0 0 10px;">
		            <i class="cur"></i>
		          	  渠道费 3.0% (用于支付给第三方支付机构，如众筹项目不成功，则不收取该笔费用。)
	            </ul>
	            
	            </form>
	       	 </div>
	       	 <!-- 个人end -->
	       	 
	          <!-- 企业信息begin -->
	       	 <div class="qiyeInfo" style="display:none;">  
	            <div class="fq_body1_content">
	                <form id=""  method="post" enctype="multipart/form-data">
                 <input type="hidden" name="idType" value="企业">
	                    <ul class="fq_body_ul" style="text-align:center">
	                    	

	                        
	                        <li>
	                            
	                            <input name="firmName" type="text" placeholder="输入企业/机构名称(需与结算时的银行卡开户名一致)"  />
	                            
	                        </li>
	                        <li>
	                            
	                            <input name="businessNumber" type="text" placeholder="请填写营业执照号或组织机构代码"  />
	                            
	                        </li>
	                        <li>
	                            
	                            <input name="slanderName" type="text" placeholder="法定代表人姓名"  />
	                            
	                        </li>
	                        <li>
	                            
	                            <input name="address" type="text" placeholder="企业/机构注册地址"  />
	                            
	                        </li>
	                        <li>
	                           
	                            <input name="contactName" type="text" placeholder="输入联系人姓名"  />
	                            
	                        </li>	                        
	                        <li>
	                           
	                            <input name="contactPhone" type="number" placeholder="输入联系人手机号"  />
	                            
	                        </li>
	                       
	                        
	                    </ul>
	                </form>
	            </div>
	            <div class="body1_h2Box"><h2 class="fq_body1_h2">上传相关材料</h2></div>
	            <ul class="fq_body_ul" style="padding-bottom:25px;">
	            	<div class="material-list">
	            		<span>营业执照:</span>
	            		<div class="material-list-pic"><img alt="" src=""></div>
	            		<div style="left:351px;height: 60px;width: 100px;position:absolute;">
	            			<div class="uplodify_in_repeat_0person-button">上传</div>
	            			<input style="opacity:0;" type="file" class="uplodify_in_repeat_0person" id="uplodify_in_repeat_0person3">
	            			
	            		</div>
	            	</div>
	            	<div class="material-list">
	            		<span>组织机构代码证:</span>
	            		<div class="material-list-pic"><img alt="" src=""></div>
	            		<div style="left:351px;height: 60px;width: 100px;position:absolute;">
	            			<div class="uplodify_in_repeat_0person-button">上传</div>
	            			<input style="opacity:0;" type="file" class="uplodify_in_repeat_0person" id="uplodify_in_repeat_0person4">
	            			
	            		</div>
	            	</div>
	            	<div class="material-list">
	            		<span>税务登记证:</span>
	            		<div class="material-list-pic"><img alt="" src=""></div>
	            		<div style="left:351px;height: 60px;width: 100px;position:absolute;">
	            			<div class="uplodify_in_repeat_0person-button">上传</div>
	            			<input style="opacity:0;" type="file" class="uplodify_in_repeat_0person" id="uplodify_in_repeat_0person5">
	            			
	            		</div>
	            	</div>
	            </ul>
	            <div class="body1_h2Box"><h2 class="fq_body1_h2">选择平台渠道费</h2></div>
	            <ul class="fq_body_ul" style="font-size: 14px;padding: 14px 0 0 10px;">
		            <i class="cur"></i>
		          	  渠道费 3.0% (用于支付给第三方支付机构，如众筹项目不成功，则不收取该笔费用。)
	            </ul>	       	 	
	       	 </div>
	       	 <!-- 企业信息end -->	       	 

	       	 
	       	
	      </div>	   		
	   		<!-- 基本信息end -->
	   	
	   	
	    	<!--项目信息begin-->
	        <div class="fq_body1 xxr2" style="display:none;" >
	            <div class="body1_h2Box"><h2 class="fq_body1_h2">创建你的详细信息</h2></div>
	            <div class="fq_body1_content">
	                <form id="basis_info"  method="post" enctype="multipart/form-data">
	                	
	                    <div  class="fq_body1_i">请选择你要创建的项目类型：</div>
	                    <div class="fq_lxItem">
	                    	<a index="1" href="javascript:;" class="cur">公益</a>
	                        <a index="2" href="javascript:;" class="">农业</a>
	                        <a index="3" href="javascript:;" class="">出版</a>
	                        <a index="5" href="javascript:;" class="">娱乐</a>
	                        <a index="4" href="javascript:;" class="">艺术</a>
	                        <a index="6" href="javascript:;" class="">其他</a>
	                    </div>                
	                    <ul class="fq_body_ul">
	                        <li>
	                            <label>设置封面：</label>
	                            <div id="show_cover" style="padding-left:95px;padding-top:0px;">
<!-- 	                            	<img width="400px" height="300px" src="http://localhost:8080/%J4}1H7MJTS[FEVV2PRUQ[S.jpg"> -->
		                            <div style="height: 60px; width: 500px; position: relative;">
		                            	
		                            	<div style="height: 60px; line-height: 60px; width: 500px;">
		                            	 
		                            		<div class="set_cover"><input  id="set_cover" name="cover_img" type="file" style="width:67px;height:63px; opacity:0"/></div>
		                            		<span class="set-cover-intro" >建议尺寸大小640*480，图片大小不要超过5M！</span>
		                            	</div>
		                            </div>	                            
	                            </div>
	                           
	                           
	                           
	                            
	                        </li>
	                        <li>
	                            <label>项目标题：</label>
	                            <input name="p_title" type="text" placeholder="给自己的项目取个响亮的名字吧，注意不要超过40汉子"  />
	                            
	                        </li>
	                        <li>
	                            <label>筹款目的：</label>
	                            <textarea  name="blurb" placeholder="一句话简单介绍下你的项目吧！" style="width:450px;height:80px;padding:5px 10px;"></textarea>
	                        </li>
	                        <li>
	                            <label>筹资金额：</label>
	                            <input  name="total_fund_raising" type="number" value="0" placeholder="请输入你需要筹资的金额，UI地500元！" /><em>元</em>
	                        </li>
	                        <li>
	                            <label>筹资天数：</label>
	                            <input  name="days_raising" type="number" value="0" placeholder="请输入你要筹资时间周期，10-90天!" /><em>天</em>
	                        </li>
	                    </ul>
	                </form>
	            </div>
	        </div>
	        <!--项目信息begin-->
	        
	        <!--项目详细描述begin-->
	      
	        <div class="fq_body1 xxr3" style="display:none;">
	        		<div class="body1_h2Box"><h2 class="fq_body1_h2">描述你的项目详情</h2></div>
	            	
	                
	               <div class="fq_body1_content">
	               <form id="detail_info">
	                <input type="hidden" name="detailCount" value="3">
	                	<div class="fq_body_ul detail">
<!-- 		                	<form> -->
		                    	<div class="text_top">
		                        	<span class="fs16">添加文本</span>
		                        	<a href="javascript:;" class="delete_it">保存</a>
		                            <a href="javascript:;" class="delete_it">删除</a>
		                            
		                        </div>
		                        <div class="text_title">
		                        	<input  name="detail_title1" type="text" placeholder="请在这里输入段落的标题" />
		                        </div>
		                        <div class="text_body">
		                        	<textarea  name="detail_content1" class="" placeholder="请在这里输入段落的正文，例如：介绍自己，介绍项目内容，为什么需要大家支持，项目进度等等"></textarea>
		                        </div>
		                        
		                        
		                        <div class="upload_detital_pic"> 
		                        	
		                        </div>

		                        
		                        
		                        <div id="content_picBox">
		                       
									<div class="content_picBox">
								    	<div class="pic_top">
								        	<span class="content_pic_span">上传照片</span>
								            <a href="javascript:" class="">删除</a>
								        </div>
								        <div calss="pic_bottom">
								        	<div class="input_btn">
								        		
								        		<div class="button_pic"><input type="file" class="uploadPic" id="uploadPic1"/></div>
								        	</div>
								            <p class="pic_bottom_p">支持JPG、GIF、PNG格式的图片，不超过1M大小</p>
								        </div>
								    </div>
								    
								</div>
							
		                        
<!-- 		                    </form> -->
	                    </div>
	                
	                
	                
	                <div class="fq_body_ul  detail">
<!-- 	                	<form> -->
	                    	<div class="text_top">
	                        	<span class="fs16">添加文本</span>
	                            <a href="javascript:;" class="delete_it">删除</a>
	                            <a href="javascript:;" class="delete_it">保存</a>
	                        </div>
	                        <div class="text_title">
	                        	<input  name="detail_title2" type="text" placeholder="为什么我需要你的支持及资金用途" />
	                        </div>
	                        <div class="text_body">
	                        	<textarea  name="detail_content2" class="" placeholder="请在这一部分说明你的项目不同寻常的特色，为什么需要大家的支持以及详细的资金用途，这会增加你项目的可信度并由此提高筹资的成功率。"></textarea>
	                        </div>
	                        
	                        <div class="upload_detital_pic"> 
		                        	
		                    </div>
		                        <div id="content_picBox">
		                       
									<div class="content_picBox">
								    	<div class="pic_top">
								        	<span class="content_pic_span">上传照片</span>
								            <a href="javascript:" class="">删除</a>
								        </div>
								        <div calss="pic_bottom">
								        	<div class="input_btn">
								        		
								        		<div class="button_pic"><input type="file" class="uploadPic" id="uploadPic2"/></div>
								        	</div>
								            <p class="pic_bottom_p">支持JPG、GIF、PNG格式的图片，不超过1M大小</p>
								        </div>
								    </div>
								    
								</div>	                        
<!-- 	                    </form> -->
	                </div>
	                
	                <div class="fq_body_ul  detail">
<!-- 	                	<form> -->
	                    	<div class="text_top">
	                        	<span class="fs16">添加文本</span>
	                            <a href="javascript:;" class="delete_it">删除</a>
	                            <a href="javascript:;" class="delete_it">保存</a>
	                        </div>
	                        <div class="text_title">
	                        	<input  name="detail_title3" type="text" placeholder="可能存在的风险" />
	                        </div>
	                        <div class="text_body">
	                        	<textarea  name="detail_content3" class="" placeholder="请在此标注你的项目在实施过程中可能存在的风险，让支持者对你的项目有全面而清晰的认识。"></textarea>
	                        </div>
	                        
	                        <div class="upload_detital_pic"> 
		                        	
		                     </div>
	                        
		                        <div id="content_picBox">
		                       
									<div class="content_picBox">
								    	<div class="pic_top">
								        	<span class="content_pic_span">上传照片</span>
								            <a href="javascript:" class="">删除</a>
								        </div>
								        <div calss="pic_bottom">
								        	<div class="input_btn">
								        		
								        		<div class="button_pic"><input type="file" class="uploadPic" id="uploadPic3"/></div>
								        	</div>
								            <p class="pic_bottom_p">支持JPG、GIF、PNG格式的图片，不超过1M大小</p>
								        </div>
								    </div>
								    
								</div>	                        
<!-- 	                    </form> -->
	                </div>
	                </form>
	             </div>   
	
	                
	            </div>
	       
	        
	        <!--项目详细描述end-->
	        
	        <!--回报设置begin-->
	        
		    <div class="fq_body1 xxr4" style="display:none;">
		        	<div class="body1_h2Box"><h2>设置你的回报信息</h2></div>
		            <div class="hb_tips">TIPS：回报信息是让用户支持你的项目，你给予一定的回报内容，可以是具体实物也可以是虚拟信息</div>
		            <div class="fq_body1_content">
		            <form id="repay_info" class="demoform">
		             <input type="hidden" name="repayCount" value="1">
		            	<div style="width:660px;margin:0 auto;"><h3 class="return-tit">回报1</h3></div>
		                <div class="fq_body_ul">
<!-- 		                	<form> -->
		                    	<ul>
		                            <li >
		                                <label>回报类型：</label>
		                                <input  name="repay_type1" value="实物" type="radio" style="width:17px;" checked /><span style="padding-left:10px;padding-right:20px;">实物回报(回报需要邮寄)</span>
		                                <input  name="repay_type1" value="虚拟" type="radio" style="width:17px;" /><span style="padding-left:10px;">虚拟回报(回报无要邮寄)</span>
		                            </li>
		                            <li>
		                            	<label>支持金额：</label>
		                                <input  name="repay_money1" type="number" value="0" placeholder="输入用户支持的金额(必填)"  /><em>元</em>
		                            </li>
		                            <li>
		                            	<label>回报标题：</label>
		                                <input  name="repay_title1" type="text" placeholder="输入回报标题（必填）" datatype="s5-16" errormsg="昵称至少5个字符,最多16个字符！"/>
		                             <!--   <label class="Validform_checktip"></label> -->
		                            </li>
		                            
		                            <li>
		                            	<label>回报内容：</label>
		                                <textarea  name="repay_content1" style="width:450px;height:80px;padding:5px 10px;" placeholder="回报内容（必填）" datatype="s5-16" errormsg="昵称至少5个字符,最多16个字符！"></textarea>
		                            </li>
		                            <li>
		                            	<label>回报时间：</label>
		                                <input  name="repay_time1" type="number" placeholder="0" value="0"  /><em>天</em><span style="padding-top:5px;padding-left:90px;" class="set-cover-intro">PS：回报时间是指项目集资成功后多少天之内给予回报</span>
		                            </li>
		                            <!-- <li>
		                            	<label>上传图片：</label>
		                                <input  name="" type="file" style="width:55px;height:20px; " />
		                                <span class="set-cover-intro">支持jpg、jpeg、png、gif格式，大小不超过500KB。</span>
		                            </li> -->
		                        </ul>
		                        <div class="hb_save" style="border-bottom: 2px solid #e3e3e3;">
		                        	<a href="javascript:;" style="" class="btn-blue small btn mr12">删除</a>
		                            <a href="javascript:;" class="btn-grey small btn mr12">保存</a>
		                        </div>
<!-- 		                    </form> -->
		                    <!-- <div class="hb_jixu">
		                    	<em>+</em></em><a href="javascript:addRepay();">继续添加新的回报</a>
		                    </div> -->
		                </div>
		                </form>
		                <div class="hb_jixu">
		                    	<em>+</em></em><a href="javascript:addRepay();">继续添加新的回报</a>
		                    </div>
		            </div>
		        </div>
	       
	        <!--回报设置end-->
	        
	        <!--预览begin-->
		<div class="fq_body1 xxr5" style="display:none;">
			<div class="xqPageBox">
		    	<!--标题封面begin-->
		        <div class="xqTitle">
		        	<div class="xqTitText">
		            	
		                	<div class="text_h3_box">
		                    	<p class="text_h3"></p>
		                    </div>
		                    <div class="text_span">
		                    	<span class="txt1">发起人</span>
		                        <span class="txt2">用户xxxxxx</span>
		                        <!-- <span class=txt3>联系我</span> -->
		                    </div>
		                
		            </div>
		            
		        </div>
		        <div class="xqDetailBox">
		            	<span></span>
		            	<div class="det_left">
		                	<img src="" />
		                </div>
		                <div class="det_right">
		                	<div class="det_rightBox">
		                    	<div class="detR_p">
		                        	<p>
		                            	<span class="ftP">0</span>
		                                <span class="scP">支持数</span>
		                            </p>
		                        </div>
		                        <div class="detR_p">
		                        	<p>
		                            	<span class="ftP">0</span>
		                                <span class="scP">已筹款</span>
		                            </p>
		                        </div>
		                    </div>
		                    <div class="det_jinduBox">
		                    	<div class="jindu_p">
		                        	<p class="ftP">0%</p>
		                        </div>
		                        <div class="xqRatio">
		                        	<div class="xqRatioInner " style="width:0;"></div>
		                        </div>
		                        <div class="jindu_s">
		                        	<div class="s_s">
		                            	<span>剩余</span>
		                                <b></b>
		                            </div>
		                            <div class="s_m">
		                            	<span>目标筹资</span>
		                                <b></b>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="det_Btn_box">
		                    	<a  style="background-color:#999;border:none;" href="javascript:;" class="det_btn1" >立即支持</a>
		                        <div class="det_btn2Box">
		                        	<a href="javascript:;" class="det_btn2"  style="background-color:#999;border:none;">分享</a>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        <!--标题封面end-->
		        
		        <!--导航栏begin-->
		        <div class="xqTab">
		        	<div class="tab_box">
		            	<ul class="tab_ul">
		                	<li><a href="javascript:;" class="tab_li">项目详情</a></li>
		                    <li><a href="javascript:;" class="tab_li">评论（0）</a></li>
		                    <li><a href="javascript:;" class="tab_li">支持记录（0）</a></li>
		                </ul>
		            </div>
		        </div>
		        <!--导航栏end-->
		        
		        
		        
		       <!--正文begin-->
		       <div class="xq_show">
		       		<div class="xq_mainBox">
		            	<!--左侧begin-->
		            	<div class="xqMain_left">
		                    <!--段落begin-->
		                    <div class="xqText">
<%-- 		                    <div class="xqText">
		                    <c:forEach items="${pd }" begin="0" end="${pd.size()-1}" var="pdr">
		                    	<div class="xqTextTitle">
		                            <p class="xqTextTitle_p"></p>
		                            <div class="xqLeftTitleInner">
		                                <h2>${pdr.title }</h2>
		                            </div>
		                            
		                        </div>
		                        ${pdr.content }
		                    </c:forEach>
		                    </div> --%>
		                    </div>
		                    <!--段落end-->
		                    
		                </div>
		                <!--左侧end-->
		                
		                
		                
		                <!--右侧begin-->
		                <div class="xq_rightBox">
		                	
		                    <!--支持金额列表-->
		                    <div class="zcjeBox">
			                    <div>
			                    	<div>
			                        	<h3 class="wszc_h3">无私支持<b>49人已支持</b></h3>                            
			                        </div>
			                        <p class="zcje_textP">感谢您的无私奉献，这份支持将助我们的梦想飞的更高更远。</p>
			                        <div class="wszcLib">
			                        	<a href="javascript:;" class="cur">¥1</a>
			                            <a href="javascript:;">¥1</a>
			                            <a href="javascript:;">¥1</a>
			                        </div>
			                        <div class="wszc_qita">
			                        	<label>其他<b>¥</b></label>
			                            <input type="text" class="wszc_input" />
			                        </div>
			                        <input  style="background-color:#999;border:none;" type="button" value="立即支持"  class="wszc_subBtn"/>
			                    </div>
		                    
			                    
			                   <!--  <div class="zcje_ItemBox">
			                    	<h3 class="zcje_h3"><b>¥45</b>0人已支持</h3>
			                        <div class="zcje_title">回报1</div>
			                        <p class="zcje_textP">正版书一本（可多份）</p>
			                        <div class="zcjeFooter">
			                        	<p class="">配送费用：<b>免运费</b></p>
			                            <p class="">预计回报发送时间：<b>项目结束后立即回报</b></p>
			                        </div>
			                        <div class="">
			                        	<span class=""></span>
			                            <a href="javascript:;" class=""></a>
			                        </div>
			                    </div> -->
		                    </div>
		                    <!--支持金额列表end-->
		                    <a href="javascript:;" class="sub_btn" style="background-color:#999;border:none;">支持此项目</a>
		                </div>
		                <!--右侧end-->
		            </div>
		       </div>
		       <!--正文end-->
		    </div>
		  </div>
	        <!--预览end-->
	        
	    </div>
	    <!--项目信息end-->
	    <div class="fq_footer">
	    	<a href="javascript:preB();" class="mr12 btn big btn-blue">上一步</a>
	        <a href="javascript:nextB();" class="btn-grey big btn">下一步</a>
	        <a href="javascript:;" class="btn-grey big btn submitSH" style="display:none">提交审核</a>
	    </div>
	</div>
</div>
<!--项目发起end-->



<%@ include file="/common/footer.jsp"%>
</body>

<script type="text/javascript">
$(document).ready(function(){
	getProvince(0,$("select[name='province']"));//所有省份
	$("select[name='province']").change(function(){
		getProvince($(this).val(),$("select[name='city']"));
	});
	
	$("select[name='city']").change(function(){
		getProvince($(this).val(),$("select[name='district']"));
	});
	


})
</script>
</html>