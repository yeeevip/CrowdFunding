<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/faqi.css">
<link type="text/css" rel="stylesheet" href="css/project.css">
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/shenhe.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }MS/static/vendors/sweetalert/sweetalert.css">
<script type="text/javascript" src="/CrowdFoundingMS/static/vendors/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		var project_id = $("input[name='project_id']").val();
		
		$(".shenheBtn").click(function(){

			$.ajax({
				url		:		"/CrowdFoundingMS/admin/crowdfunding/dmwhproject/"+project_id+"/passAudits",
				async	:		true,
				cache	:		false,
				data	:		{},
				type	:		"post",
				success	:		function(data){
					swal(data,"", "");
				}
			});
		});
		$(".shenheBtnreject").click(function(){

			$.ajax({
				url		:		"/CrowdFoundingMS/admin/crowdfunding/dmwhproject/"+project_id+"/rejectAudits",
				async	:		true,
				cache	:		false,
				data	:		{},
				type	:		"post",
				success	:		function(data){
					swal(data, "", "");
				}
			});
		})
	})
</script>
</head>
<body>

<div class="xqPage">
	<div class="mainXqBox">
			<div class="xqPageBox">
		        <!--预览begin-->
			<div class="fq_body1 xxr5">
				<div class="xqPageBox">
				<div class="xqTitle" style="height:50px;color:blue">
			        	<div class="xqTitText" >
			                	<div class="text_h3_box">
			                    	<p class="text_h3">身份信息部分↓↓↓↓</p>
			                    </div>
			            </div>
			            
			    </div>
			  
			  <c:choose> 
			  <c:when test="${project.initiatorPersonInfo!=null }">
			   <div class="shenfenBox">
			    	<div class="basicInfo">
						<ul class="fq_body_ul" style="text-align:center">
	                        <li style="height:25px;"><span>姓名</span><span>：</span>${project.initiatorPersonInfo.name }</li>
	                        <li style="height:25px;"><span>身份证号</span><span>：</span>${project.initiatorPersonInfo.IDnumber }</li>
	                        <li style="height:25px;"><span>手机</span><span>：</span>${project.initiatorPersonInfo.phone }</li>
	                        <li style="height:25px;"><span>地址</span><span>：</span></li>
	                    </ul>
			    	
			    </div>
			    
			    <div class="imgInfo" >
			    			<div style="width:451px"><span>身份证正面：</span><div class="imgInfo_item"><img style="height:302px;width:450px" src="${project.initiatorPersonInfo.szimg }"/></div></div>
	                    	<div style="width:451px"><span>身份证反面：</span><div class="imgInfo_item"><img  style="height:302px;width:450px" src="${project.initiatorPersonInfo.sfimg }"/></div></div>
			    	</div>
			   </div>
			   </c:when>
			    <c:when test="${project.initiatorCompanyInfo!=null }">
			    <div class="shenfenBox">
			    	<div class="basicInfo">
						<ul class="fq_body_ul" style="text-align:center">
	                        <li style="height:25px;"><span>企业名称</span><span>：</span>${project.initiatorCompanyInfo.firmName }</li>
	                        <li style="height:25px;"><span>营业执照号</span><span>：</span>${project.initiatorCompanyInfo.businessNumber }</li>
	                        <li style="height:25px;"><span>法定代表人</span><span>：</span>${project.initiatorCompanyInfo.slanderName }</li>
	                        <li style="height:25px;"><span>公司注册地址</span><span>：</span>${project.initiatorCompanyInfo.address }</li>
	                        <li style="height:25px;"><span>联系人姓名</span><span>：</span>${project.initiatorCompanyInfo.contactName }</li>
	                        <li style="height:25px;"><span>联系人手机号</span><span>：</span>${project.initiatorCompanyInfo.contactPhone }</li>
	                    </ul>
			    	
			    </div>
			    
			    <div class="imgInfo">
			    			<div><span>营业执照：</span><div class="imgInfo_item"></div></div>
	                    	<div><span>组织机构代码证：</span><div class="imgInfo_item"></div></div>
	                    	<div><span>税务登记证：</span><div class="imgInfo_item"></div></div>
			    	</div>
			   </div>
			   </c:when>
			   </c:choose>
			    
				<div class="xqTitle" style="height:50px;color:blue">
			        	<div class="xqTitText">
			                	<div class="text_h3_box">
			                    	<p class="text_h3">项目内容部分↓↓↓↓</p>
			                    </div>
			            </div>
			            
			  	</div>
			    	<!--标题封面begin-->
			        <div class="xqTitle">
			        	<div class="xqTitText">
			            	<input type="hidden" name="project_id" value="${project.project_id }">
			                	<div class="text_h3_box">
			                    	<p class="text_h3">${project.title }</p>
			                    </div>
			                    <div class="text_span">
			                    	<span class="txt1">发起人</span>
			                        <span class="txt2">用户xxxxxx</span>
			                        <span class=txt3>联系我</span>
			                    </div>
			                
			            </div>
			            
			        </div>
			        <div class="xqDetailBox">
			            	<span></span>
			            	<div class="det_left">
			                	<img src="${project.img_name }" />
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
			                            	<span class="ftP">${project.has_fund_raising }</span>
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
			                                <b>${project.total_fund_raising }</b>
			                            </div>
			                        </div>
			                    </div>
			                    <div class="det_Btn_box">
			                    	<a href="javascript:;" style="background-color:#999" class="det_btn1" >立即支持</a>
			                        <div class="det_btn2Box">
			                        	<a href="javascript:;" style="background-color:#999"  class="det_btn2">分享</a>
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
			                    <c:forEach items="${project.projectdetail }" var="pdr">
                    				<div class="xqTextTitle">
			                            <p class="xqTextTitle_p"></p>
			                            <div class="xqLeftTitleInner">
			                                <h2>${pdr.title }</h2>
			                            </div>
                            
                       				 </div>
                     			   ${pdr.content }
                   				 </c:forEach>
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
				                        <input  style="background-color:#999"  type="button" value="立即支持"  class="wszc_subBtn"/>
				                    </div>
			                    
				                    
				                    <c:forEach items="${project.projectRepay }" var="pr" >
	                    <div class="zcje_ItemBox">
	                    	<h3 class="zcje_h3"><b>¥${pr.money }</b>73人已支持</h3>
	                        <div class="zcje_title">${pr.title }</div>
	                        <p class="zcje_textP">${pr.content }</p>
	                        <div class="zcjeFooter">
	                        	<p class="">回报方式：<b>${pr.type }</b></p>
	                            <p class="">预计回报发送时间：<b>项目成功结束后${pr.time }内</b></p>
	                        </div>
	                        <div class="">
	                        	<span class=""></span>
	                            <a href="javascript:;" class=""></a>
	                        </div>
	                    </div>
	          </c:forEach>
			                    </div>
			                    <!--支持金额列表end-->
			                    <a href="javascript:;"  style="background-color:#999"  class="sub_btn">支持此项目</a>
			                </div>
			                <!--右侧end-->
			            </div>
			       </div>
			       <!--正文end-->
			    </div>
			  </div>
		        <!--预览end-->
		  </div>      
	</div>
</div>
	    <div class="fq_footer">
	    	<a style="width:280px" href="javascript:;" class="mr12 btn big btn-grey shenheBtnreject">审核不通过</a>
	        <a style="width:280px;background-color:#50abf2" href="javascript:;" class="btn-grey big btn shenheBtn">通过审核</a>
	       
	    </div>

</body>
</html>