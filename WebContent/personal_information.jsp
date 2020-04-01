<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人信息</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/personal.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/project.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/calender/calender.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/date/calender.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/personal.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>


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

</head>



<body>
<%@ include file="/common/header.jsp"%>

<div class="grzxBox">

<div class="personalBox">
	<!--左侧导航栏begin-->
	<div class="personalBox_left" id="card_btn">
    	<div class="personalBox_left_box">
        	<h3>我的</h3>
            <div class="personalBox_left_m">
            	<a href="javascript:f_display('myLaunch')">我的发起</a>
            </div>
            <div class="personalBox_left_m">
            	<a href="javascript:f_display('myOrder')" id="myOrderShow">我的订单</a>
            </div>
            <div class="personalBox_left_m">
            	<a href="javascript:f_display('myProject')" id="myProjectShow">订单处理</a>
            </div>
            <div class="personalBox_left_m">
            	<a>我的关注</a>
            </div>
        </div>
        
        <div class="personalBox_left_box">
            <h3>消息</h3>
            <div class="personalBox_left_m">
                <a href="javascript:f_display('myPinglun')">我的评论</a>
            </div>
            <div class="personalBox_left_m">
                <a href="javascript:f_display('mySixin')">我的私信</a>
            </div>
        </div>
            
        <div class="personalBox_left_box">
           <h3>设置</h3>
           <div class="personalBox_left_m">
           	<a href="javascript:f_display('myZiliao')">个人资料</a>
           </div>
           <div class="personalBox_left_m">
           	<a href="javascript:f_display('myPassword')">修改密码</a>
           </div>
           <div class="personalBox_left_m">
           	<a href="javascript:f_display('myAddress')" id="showMyReceive">收货地址</a>
           </div> 
        </div>
            
    </div>
    <!--左侧信息栏end-->
    
    <!--右侧内容栏begin-->
    <div class="personalBox_right" >
    
    <!-- 我的发起begin -->
    
        	<div class="personalBox_right_box c_display" style="display:block;" id="myLaunch">
        	<ul class="right_box1_ul">
            	<li>我的发起</li>
                
            </ul>
            <div class="grzxTabItem">
            	<div class="grzx_ddList myLaunch_table">
                	<table>
                	
                		<colgroup>
                    		<col width="350px">
                    		<col width="100px">
                    		<col width="190px">
                    		<col width="100px">                   		
                    		<col wdith="auto">
                		</colgroup>
                    	<thead>
                        	<tr>
                        		<td>项目信息</td>
                            	<td>项目状态</td>
                           		<td>筹资进度</td>
								<td>结算状态</td>
                            	<td>操作</td>
                            </tr>
                        </thead>
                        <tbody class="launch_body" id="myProject_tbody_ajax">
                        
                      <c:forEach items="${projects }" var="p"> 
                        	<tr class="trfirst"><td colspan="4"></td></tr>
                        	<tr class="ftTr">
                        		<td colspan="4">创建时间：${p.launch_date }</td>
                        		<td><a href="javascript:;" class="ftTr_delA" title="删除"></a></td>
                        	</tr>
                        	<tr class="inforTr" project_id="">
                        		<td>
                        			<div class="ddImgBox"><a href="javascript:;" target="_blank"><img style="width:80px;height:60px;" src="${p.img_name }"></a></div>
                        			<div class="ddImgText"><a href="javascript:;" target="_blank">${p.title }</a></div>
                        		</td>
                        		<td>
                        			<div>
                        				<p class="inforText_p gray">
                        			<c:choose>
									   <c:when test="${p.is_audits==1&&p.is_finish==0}">
										正在集资
									   </c:when>
									   <c:when test="${p.is_audits==1&&p.is_finish==-1 }">
									 	  集资失败
									   </c:when>  
									   <c:when test="${p.is_audits==1&&p.is_finish==1 }">
									 	  集资成功
									   </c:when>
									   <c:when test="${p.is_audits==0 }">
									 	  未审核
									   </c:when>  
									   <c:when test="${p.is_audits==-1 }">
									 	  未通过审核
									   </c:when>    
								    </c:choose>
                        		
                        		 </p>
                        			</div></td>
                        		<td>
                        			<p class="inforText_p ">目标：${p.total_fund_raising }元</p>
                        			<fmt:formatNumber type="number" var="a" value="${p.has_fund_raising/p.total_fund_raising*100}" pattern="0.00" maxFractionDigits="2"/> 
                        			<div class="inforRatioBox">
                        				<div class="inforRatio"><div class="inner" style="width:${a}%"></div></div>
                        				<span>%${a}</span> 
                        			</div>
                        		</td>
                        		<td><div><p class="inforText_p gray">不可结算</p></div></td>
                        		<td class="btnTd">
                        			<div class="operations">
                        			<a href="javascript:goProjectProcess(${p.project_id });" target="" class="ddLastbtn_A">更新最新进展</a>
                        			<!-- <a href="javascript:;" target="_blank" class="ddLastbtn_B">编辑</a>
                        			<a href="javascript:;" target="_blank" class="ddLastbtn_B">预览</a></div> -->
                        		</td>
                        	</tr>
                       </c:forEach> 
                        	
                        </tbody>
                    </table>
                    <div class="pl_fanye">
                        	<div class="fy_MainBox" id="myprojectFlip">
                            	
	                      	<!--  <a class="fy_page">上一页</a> -->
	                      	 <c:forEach begin="0" end="${pageCount }" varStatus="status">
	                      	 	<c:choose>  
  
								   <c:when test="${status.index==0 }">
								 	  <a class="fy_page cur">${status.index+1 }</a>
								   </c:when>  
								     
								   <c:otherwise> 
								   	<a class="fy_page">${status.index+1 }</a>
								   </c:otherwise>  
								</c:choose>  

	                      	 </c:forEach>
                             
                             
                             
                           <!--   <a class="fy_page">下一页</a> -->
                             
                             
                            </div>
                        </div>
                </div>
            </div>
        </div>
    
    <!-- 我的发起end -->
    
    
    
    
    
    <!-- 我的订单begin -->
    	<div class="personalBox_right_box c_display"  style="display:none;" id="myOrder">
        	<ul class="right_box1_ul">
            	<li>全部订单</li>
                <!-- <li>未支付</li>
                <li>已支付</li> --> 
            </ul>
            <div class="grzxTabItem">
            	<div class="grzx_ddList">
                	<table>
                	
                		<colgroup>
                    		<col width="300px">
                    		<col width="60px">
                    		<col width="160px">
                    		<col width="80px">
                    		<col width="50px">
                    		<col width="90px">
                    		<col wdith="auto">
                		</colgroup>
                    	<thead>
                        	<tr>
                        		<td>项目信息</td>
                            	<td>项目状态</td>
                           		<td>回报信息</td>
                           		<td>支持金额</td>
                            	<td>支持份数</td>
                            	<td>状态</td>
                            	<td>操作</td>
                            </tr>
                        </thead>
                        <tbody class="launch_body" id="myOrderTbody">
<!--                         	<tr class="trfirst"><td colspan="7"></td></tr> -->
<!--                         	<tr class="ftTr"> -->
<!--                         		<td colspan="6">创建时间：2016-11-07 10:56:51 -->
<!--                         			<span class="dingdan">订单号码:</span><span  class="dingdan">发起人:</span> -->
<!--                         		</td> -->
<!--                         		<td><a href="javascript:;" class="ftTr_delA" title="删除"></a></td> -->
<!--                         	</tr> -->
<!--                         	<tr class="inforTr"> -->
<!--                         		<td> -->
<!--                         			<div class="ddImgBox"><a href="javascript:;" target="_blank"><img src=""></a></div> -->
<!--                         			<div class="ddImgText"><a href="javascript:;" target="_blank">标题标题标题</a></div> -->
<!--                         		</td> -->
<!--                         		<td><div><p class="inforText_p gray">审核中</p></div></td> -->
<!--                         		<td> -->
<!--                         			<p class="inforText_p ">目标：5000元</p> -->
<!--                         			<div class="inforRatioBox"> -->
<!--                         				<div class="inforRatio"><div class="inner" style="width:"></div></div> -->
<!--                         				<span>%0</span> -->
<!--                         			</div> -->
<!--                         		</td> -->
<!--                         		<td><div><p class="inforText_p gray">1元</p></div></td> -->
<!--                         		<td><div><p class="inforText_p gray">1</p></div></td> -->
<!--                         		<td><div><p class="inforText_p gray">未支付</p></div></td> -->
<!--                         		<td class="btnTd"> -->
<!--                         			<div class="operations"> -->
<!--                         			<a href="javascript:;" target="_blank" class="ddLastbtn_A">去支付</a> -->
                        			
<!--                         		</td> -->
<!--                         	</tr> -->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- 我的订单end -->
        
			        <!--个人信息begin-->
			
			<!--资料编辑begin-->
			<div class="personalBox_box  c_display" id="myZiliao" style="display:none;">
				<div class="personalbBox_box2_ziLiao">
			    	<ul class="right_box1_ul">
			        
			         	<li><a href="javascript:changeTXBox(1)">个人资料编辑</a></li>
			         	<li></li>
			            <li><a href="javascript:changeTXBox(2)">头像编辑</a></li>
			            
			        </ul>
			        <div class="ziLiao_form" id="ziliaoBj">
			       	  <form>
			            <ul id="user_ziliao">	
			            	<li>
			               		<label class="ziLiao_form_label"><span>*</span>昵称：</label>
			                	<input type="text" name="user_name" value="${user.user_name }" placeholder="请输入昵称"  />
			                </li>
			                <li>
			                	<label>性别：</label>
				                <div id="sex_ch">
				                	<input type="radio" name="sex" value="0" style="float:left;"/><span style="float:left;margin-top:7px;">男</span>
				                    <input type="radio" name="sex" value="1" style="float:left;"/><span style="float:left;margin-top:7px;">女</span>
				                    <input type="radio" name="sex" value="2" style="float:left;"/><span style="float:left;margin-top:7px;">保密</span>
				                </div>
			                </li>
			              	<li>
			                	<label><span>*</span>手机号：</label>
			                    <input type="text" value="${user.phone }" name="phone" placeholder="请输入手机号" />
			                 </li>
			                 <li>
			                 	<label><span>*</span>邮箱：</label>
			                    <input type="text" value="${user.email }" name="email" placeholder="请输入邮箱" />
			                 </li>
			                 <li>
			                 	<label><span>*</span>真实姓名：</label>
			                    <input type="text" value="${user.real_name }" name="real_name" placeholder="请输入真实姓名" />
			                 </li>
			                 <li>
			                 	<label><span>*</span>身份证：</label>
			                    <input type="text" value="${user.id_number }" name="id_number" placeholder="请输入身份证号：" />
			                 </li>
			                 <li>
			                 	<label>生日：</label>
			                    <input id="calender" type="text" value="" name=""/>
			                 </li>
			                 <li class="province-selector">
			                 	<label>所在地区：</label>
	                            <select name="province" class=""><option>请选择</option></select>
	                            <select name="city" class=""><option>请选择</option></select>
			                 </li>
			                 <li>
			                 	<label></label>
			                    <input type="button" value="保存" class="ziLiao_box_submit"/>
			                    
			                 </li>
			               </ul>  
			            </form>
			        </div>
			        	<!--资料编辑end-->
			        	
			        	<!--头像编辑begin-->
			<div class="grzx_touxiang"  style="display:none;" id="touxiangBj">
				<form>
			    	<div class="touxiang_sc">
			        	<div class="touxiang_sc_l">
			    			<p>设置你的头像</p>
			            	<p class="touxiang_yl"><img src="img/personal/icon.jpg" class="ylImage"/></p>
			            	<p style="padding-top:15px;">仅支持GIF、JPG、PNG图片</p>
			            </div>
			            
			            <div class="touxiang_sc_r">
			            	<p>头像预览（大小：200*200）</p>
			            	<div class="img_box">
			                	<div class="img_contbox"><img src="img/personal/icon.jpg" /></div>
			                </div>
			                <a href="javascript:;" class="sc_file">上传图片
			                	<input type="file" name="image" accept=".jpg,.png,.gif"/>
			                </a>
			            </div>
			        </div>
			        <div class="touxiang_bc">
			        	<input type="button" value="保存" class="ziLiao_box_submit" />
			        </div>
			    </form>
			</div>
			
			<!--头像编辑end-->
			    </div>

			<!--个人信息end-->
		</div>
		
			
			
			<!--修改密码begin-->
			<div class="personalBox_box  c_display" id="myPassword" style="display:none;">
				<ul class="right_box1_ul"><li>登陆密码修改</li></ul>
			    <div class="grzx_xiugai">
			    	<div class="xiugai_tishi">
			    		<img src="img/personal/tips-ico.jpg" class="img-pass">
			        	<span>修改登陆密码后，原密码将不能用来登陆。</span>
			        </div>
			        <div class="xiugai_form">
				    	<form>
				        	<ul>
				            	<li>
				                	<label>请输入旧密码：</label>
				                    <input type="text" />
				                </li>
				                <li>
				                	<label>请输入新密码：</label>
				                    <input type="text" />
				                </li>
				                <li>
				                	<label>请确认密码：</label>
				                    <input type="text" />
				                </li>
				                <li>
				                	<div>
				                		<input type="button" value="保存" class="ziLiao_box_submit" />
				                   </div>
				                </li>
				            </ul>
				        </form>
				    </div>
			    </div>
			</div>
			
			<!--修改密码end-->
			
			
			<!--个人中心项目管理begin-->
			<div class="personalBox_box c_display " style="display:none;" id="myProject">
				<ul class="right_box1_ul">
			    	<li>
			        	<a href="javascript:;">全部订单(0)</a>
			        </li>
			      <!--   <li>
			        	<a href="javascript:;">待发货（0）</a>
			        </li>
			        <li>
			        	<a href="javascript:;">已发货（0）</a>
			        </li> -->
			      <!--   <li>
			        	<a href="javascript:;">无需回报（0）</a>
			        </li>
			        <li>
			        	<a href="javascript:;">已收货（0）</a>
			        </li> -->
			    </ul>
			  
				    <form class="xiangmu_search">
				    	<ul>
				        	<li><input type="text" placeholder="可输入关键字进行查询" /></li>
				            <li><input type="text" placeholder="可输入订单号进行查询" /></li>
				            <li><input type="text" placeholder="可输入手机号进行查询" /></li>
				            <li><a href="javascript:;" type="submit" class="search_btn">查询</a></li>
				        </ul>
				    </form>
			   
			    <div class="grzx_xiangmu_table" >
			    	<table>
			    		<colgroup>
			    			
			    			<col width="8%">
			    			<col width="15%">
			    			<col width="10%">
			    			<col width="6%">
			    			<col width="8%">
			    			<col width="4%">
			    			<col width="6%">
			    			<col width="6%">
			    			<col width="17%">
			    		</colgroup>
			        	<thead>
			            	<tr class="bg_tr">
			                    <td>订单号</td>
			                    <td>项目名称</td>
			                    <td>回报名称</td>
			                    <td>支持者</td>
			                    <td>创建时间</td>
			                    <td>支持份数</td>
			                    <td>支持金额</td>      
			                    <td>收货人</td>
			                    <td>收货地址</td>
			                    <td>电话</td>
			                    <td>支付状态</td>
			                    <td>操作</td>
			                 </tr>
			            </thead>
			            
			            <tbody id="myProjectTbody">
			            	<!-- <tr class="trfirst"><td colspan="9"></td></tr> -->
<!-- 						    <tr class="u_tbg_tr"> -->
<!-- 									<td></td> -->
<!-- 									<td></td> -->
<!-- 									<td></td> -->
<!-- 									<td></td> -->
<!-- 									<td></td> -->
<!-- 									<td></td> -->
<!-- 									<td></td> -->
<!-- 									<td></td> -->
<!-- 									<td><a>发货</a></td> -->
									
<!-- 							</tr> -->
			            </tbody>
			            
			        </table>
			    </div>
			</div>
			
			<!--个人中心项目管理end-->
			
			<!--个人中心我的评论begin-->
			<div class="grzx_pinglun c_display"  style="display:none;" id="myPinglun">
				<ul class="right_box1_ul">
			    	<li><a href="javascript:;">收到的评论</a></li>
			        <li><a href="javascript:;">回复他人的评论</a></li>
			        <li><a href="javascript:;">对项目的评论</a></li>
			    </ul>
			    <div class="grzx_pinglunBox">暂无评论
			    	
			    </div>
			</div>
			<!--个人中心我的评论end-->
			
			<!--个人中心收货地址begin-->
			<div class="grzx_shAddress  c_display" style="display:none;" id="myAddress">
				<ul class="right_box1_ul">
			    	<li><a href="javascript:;">收货地址</a></li>
			    </ul>
			    <div class="grzx_ddList receiveinfotable">
			    	<table>
			    		<colgroup>
		                    <col width="12%">
		                   
		                    <col width="30%">
		                    <col width="15%">
		                    <col width="20%">
		                    <col wdith="auto">
               			</colgroup>
			        	<thead>
			        		
			            	<tr>
			                	<td>收件人</td>
			                    
			                    <td>详细地址</td>
			                    <td>邮编</td>
			                    <td>联系电话</td>
			                    <td>操作</td>
			                </tr>
			            </thead>
			            <tbody id="myReceive_tbody">
			           
							</tbody>
			        </table>
			        <input type="button" class="new_shdzBtn" value="新增地址" />
			    </div>
			</div>
			<!--个人中心收货地址eng-->
			
			<!--个人中心我的私信begin-->
			<div class="grzx_xiaoxi c_display" style="display:none;" id="mySixin">
				<ul class="right_box1_ul">
			    	<li><a href="javascript:;">收到的私信</a></li>
			        <li><a href="javascript:;">发出的私信</a></li>
			    </ul>
			    <div style="text-align: center;padding-top: 20px;">暂无私信</div>
			</div>
			<!--个人中心我的私信end-->
    </div>
    <!--右侧内容栏end-->
    
</div>


</div>

<%@ include file="/common/footer.jsp"%>

</body>


</html>