<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理中心</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/personal.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
<link type="text/css" rel="stylesheet" href="css/admin.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="admin.js"></script>

<script type="text/javascript">
	

</script>
</head>
<body>
<!-- 顶部部begin -->
<div class="a_top">
    	<span>
        	欢迎登陆管理员中心
        </span>
</div>
<!-- 顶部end -->
 
<div class="grzxBox">
	<div class="personalBox" style="width:1200px;">
    	<div class="personalBox_left">
    		
    		<div class="personalBox_left_box">            	
        		<h3>开始</h3>
            	<div class="personalBox_left_m">
            		<a href="javascript:f_display('a_shouye')">首页</a>
            	</div>       		
            </div>
        	<div class="personalBox_left_box">            	
        		<h3>用户</h3>
            	<div class="personalBox_left_m">
            		<a href="javascript:f_display('a_yonghu')" id="user_menu">用户管理</a>
            	</div>       		
            </div>
            <div class="personalBox_left_box">            	
        		<h3>订单</h3>
            	<div class="personalBox_left_m">
            		<a href="javascript:f_display('a_dingdan')" >订单管理</a>
            	</div>       		
            </div>
            <div class="personalBox_left_box">            	
        		<h3>项目</h3>
            	<div class="personalBox_left_m">
            		<a href="javascript:f_display('a_project')" id="project_menu">项目管理</a>
            	</div>       		
            </div>
            <div class="personalBox_left_box">            	
        		<h3>项目类别</h3>
            	<div class="personalBox_left_m">
            		<a href="javascript:f_display('a_leibie')">项目类别管理</a>
            	</div>       		
            </div>
        </div>
        
        <div class="personalBox_right" style="width:1070px;">
        	
			<!--欢迎页begin-->
			<div class="admin_welcome c_display" id="a_shouye">
				<div class="welinfo">
			    	<b>Admin上午好，欢迎来到后台管理中心</b>
			        (1324459373@qq.com)
			        <a href="javascript:;">账号设置</a>
			    </div>
			    <div class="welinfo">
			    	<i>您上次登陆的时间为：2016.10.23 22:00</i>
			    </div>
			</div>
			<!--欢迎页end-->
			
			<!--用户管理begin-->
			<div class="personalBox_box c_display " style="display:none" id="a_yonghu">
				<ul class="right_box1_ul">
			    	<li>全部用户</li>
			        <li>VIP用户</li>
			        <li>管理员账户</li>
			    </ul>
			    <form class="xiangmu_search">
				    <ul>
				    	<li>
				        	<select class="pd-type">
				            	<option>--按性别查找--</option>
				                <option>男</option>
				                <option>女</option>
				            </select>
				        </li>
				        <li>
				        	<select class="pd-type">
				            	<option>--按年龄查找--</option>
				                <option>0-18周岁</option>
				                <option>19-30周岁</option>
				                <option>30-50周岁</option>
				                <option>50-70周岁</option>
				                <option>70周岁以上岁</option>
				            </select>
				        </li>
				        <li>
				        	<select class="pd-type">
				            	<option>--按注册时间查找--</option>
				                <option>从早到晚</option>
				                <option>从晚到早</option>
				            </select>
				        </li>
				        <li>
				        	<input type="text" placeholder="可输入关键字" />
				        </li>
				        <li>
				        	<a href="javascript:;" type="submit" class="search_btn">查询</a>
				        </li>
				    </ul>
			    </form>
			    <div class="project-checked">
				    <div class="l">
				    	<label><input  id="u_allCheck" type="checkbox"  name="check" value="111" />全选/取消</label>
				  	</div>
				  	<div class=" r">
				        <a class="checked_ed" id="Js-outputAll" href="javascript:;">全部导出</a>
				        <a class="checked_ed" id="Js-outputItems" href="javascript:;">导出</a>
				        <a class="checked_ed" href="javascript:;">添加</a>
				        <a class="checked_ed" href="javascript:;">删除</a>
				        <a class="checked_ed" href="javascript:;">修改</a>
			        </div>                                    
			     </div>
			    <div class="grzx_xiangmu_table">
			    				<div  style="width:20px;float:left;margin-right:1px;padding-top:34px;" id="table_checkboxBOx">
<!-- 									<div class="table_checkbox_box"><input user_index="21" class="table_checkbox" type="checkbox"></div> -->
			    				</div>
						    	<table id="user_table" style="float:left;">
						    		<colgroup>
						    			<col width="2%">
						    			<col width="8%">
						    			<col width="10%">
						    			<col width="14%">
						    			<col width="5%">
						    			<col width="6%">
						    			<col width="13%">
						    			<col width="6%">
						    			
						    			<col width="10%">
						    			<col width="11%">
						    		</colgroup>
						        	<thead>
						            	<tr class="bg_tr">
						            		<td></td>
						                    <td>用户编号</td>
						                    <td>用户名</td>
						                    <td>邮箱</td>
						                    <td>性别</td>
						                    <td>真实姓名</td>
						                    <td>身份证号</td>
						                    <td>年龄</td>
						                    <td>电话</td>						                    
						                    <td>注册时间</td>
						                 </tr>
						            </thead>
						            
				            <tbody id="user_tbody">
				            	<tr class="trfirst"><td colspan="9"></td></tr>
		            
<!-- 				<tr class="u_tbg_tr"> -->
<!-- 						<td><input user_index="21" class="table_checkbox" type="checkbox"></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 						<td></td> -->
<!-- 				</tr> -->

						            </tbody>
						        </table>
				</div>
			    
			    
			    <div class=""	>
			    	<div class="m-page">
			    		<div class=wraper>
				    		<ul class="item1">
				    			<li class="item1-num"><input type="button" value="&nbsp<&nbsp上一页"></li>
				    			
				    			<li class="item1-num"><input type="button" value="下一页&nbsp>&nbsp"></li>
				    		</ul>
				    		<div class="total">
				    			共1页&nbsp,&nbsp&nbsp
				    		</div>
				    		<div class="item2">
				    			<span class="i_text">到第</span>
				    			<input type="number" min="1" max="100" value="1" class="i_input">
				    			<span class="i_text">页</span>
				    			<input type="button" value="确定" class="i_span">
				    		</div>
				    	</div>
			    	</div>
			    </div>
			    
			</div>
			<!--用户管理end-->




			<!--订单管理begin-->
			<div class="c_display" style="display:none" id="a_dingdan">
				<ul class="right_box1_ul">
			    	<li>全部订单</li>
			        <li>已发货</li>
			        <li>退款中</li>
			    </ul>
			    <form class="xiangmu_search">
				    <ul>
				    	<li>
				        	<select class="pd-type">
				            	<option>-按状态--</option>
				                <option>已支付</option>
				                <option>未支付</option>
				            </select>
				        </li>
				        <li>
				        	<select class="pd-type">
				            	<option>--按金额查找--</option>
				                <option>0-90元</option>
				                <option>91-200元</option>
				                <option>201-500元</option>
				                <option>501-1000元</option>
				                <option>1000元以上</option>
				            </select>
				        </li>
				        <li>
				        	<select class="pd-type">
				            	<option>--按创建时间查找--</option>
				                <option>从早到晚</option>
				                <option>从晚到早</option>
				            </select>
				        </li>
				        <li>
				        	<input type="text" placeholder="可输入关键字" />
				        </li>
				        <li>
				        	<a href="javascript:;" type="submit" class="search_btn">查询</a>
				        </li>
				    </ul>
			    </form>
			    <div class="project-checked">
				    <div class="l">
				    	<label><input type="checkbox" />全选/取消</label>
				  	</div>
				  	<div class=" r">
				        <a class="checked_ed" id="Js-outputAll" href="javascript:;">全部导出</a>
				        <a class="checked_ed" id="Js-outputItems" href="javascript:;">导出</a>
				        <a class="checked_ed" href="javascript:;">添加</a>
				        <a class="checked_ed" href="javascript:;">删除</a>
				        <a class="checked_ed" href="javascript:;">修改</a>
			        </div>                                    
			     </div>
			    <div class="grzx_xiangmu_table">
						    	<table>
						    		<colgroup>
						    			<col widtd="">
						    			<col width="15%">
						    			<col width="15%">
						    			<col width="8%">
						    			<col width="5%">
						    			<col width="20%">
						    			<col width="10%">
						    			<col width="12%">
						    			<col width="4%">
						    			
						    		</colgroup>
						        	<thead>
						            	<tr class="bg_tr">
						            		<td></td>
						                    <td>订单编号</td>
						                    <td>项目名称</td>
						                    
						                    
						                    <td>下单金额</td>
						                    <td>收货人</td>
						                    <td>收货地址</td>
						                    <td>电话</td>
						                    <td>创建时间</td>
						                    <td>是否付款</td>
						                 </tr>
						            </thead>
						        </table>
						    </div>
			    	<div class=""	>
			    	<div class="m-page">
			    		<div class=wraper>
				    		<ul class="item1">
				    			<li class="item1-num"><input type="button" value="&nbsp<&nbsp上一页"></li>
				    			
				    			<li class="item1-num"><input type="button" value="下一页&nbsp>&nbsp"></li>
				    		</ul>
				    		<div class="total">
				    			共1页&nbsp,&nbsp&nbsp
				    		</div>
				    		<div class="item2">
				    			<span class="i_text">到第</span>
				    			<input type="number" min="1" max="100" value="1" class="i_input">
				    			<span class="i_text">页</span>
				    			<input type="button" value="确定" class="i_span">
				    		</div>
				    	</div>
			    	</div>
			    </div>
			
			</div>
			<!--订单管理end-->
			
			
			<!--项目管理begin-->
			<div class="c_display" style="display:none" id="a_project">
				<ul  class="right_box1_ul">
			    	<li><a href="javascript:projectAll()">全部项目</a></li>
			        <li><a href="javascript:projectNo();">待审核项目</a></li>
			        <li>已成功项目</li>
			    </ul>
			    
			  <div id="all_projects">
			    <form class="xiangmu_search">
				    <ul>
				    	<li>
				        	<select class="pd-type">
				            	<option>--按项目类型查找--</option>
				                <option>公益</option>
				                <option>出版</option>
				                <option>娱乐</option>
				            </select>
				        </li>
				        <li>
				        	<select class="pd-type">
				            	<option>--按集资金额--</option>
				                <option>0-1000元</option>
				                <option>1001-5000元</option>
				                <option>5001-10000元</option>
				                <option>10001-100000元</option>
				                <option>100000元以上</option>
				            </select>
				        </li>
				        <li>
				        	<select class="pd-type">
				            	<option>--按发起时间查找--</option>
				                <option>从早到晚</option>
				                <option>从晚到早</option>
				            </select>
				        </li>
				        <li>
				        	<input type="text" placeholder="可输入关键字" />
				        </li>
				        <li>
				        	<a href="javascript:;" type="submit" class="search_btn">查询</a>
				        </li>
				    </ul>
			    </form>
			    <div class="project-checked">
				    <div class="l">
				    	<label><input type="checkbox" id="p_allCheck" />全选/取消</label>
				  	</div>
				  	<div class=" r">
				        <a class="checked_ed" id="Js-outputAll" href="javascript:;">全部导出</a>
				        <a class="checked_ed" id="Js-outputItems" href="javascript:;">导出</a>
				        <a class="checked_ed" href="javascript:;">添加</a>
				        <a class="checked_ed" href="javascript:;">删除</a>
				        <a class="checked_ed" href="javascript:;">修改</a>
			        </div>                                    
			     </div>
			    <div class="grzx_xiangmu_table">
						    	<table>
						    		<colgroup>
						    			<col width="2%">
						    			<col width="15%">
						    			<col width="6%">
						    			<col width="5%">
						    			<col width="20%">
						    			<col width="6%">
						    			<col width="4%">
						    			<col width="6%">
						    			<col width="10%">
						    			<col width="3%">
						    			<col width="3%">
						    			<col width="5%">
						    		</colgroup>
						        	<thead>
						            	<tr class="bg_tr">
						            		<td></td>
						                    <td>项目编号</td>
						                    <td>发起人</td>
						                    <td>项目类别</td>
						                    <td>名称</td>
						                    <td>目标金额</td>
						                    <td>总天数</td>
						                    <td>已筹金额</td>
						                    <td>发起时间</td>
						                    <td>是否完成</td>
						                    <td>是否审核</td>
						                    <td>项目详情</td>
						                    
						                 </tr>
						            </thead>
						            <tbody id="project_tbody">
						            	<tr class="trfirst"><td colspan="9"></td></tr>
						 
						            </tbody>
						        </table>
						    </div>
						</div>
						
				<div id="no_audits" style="display:none">
						
				<form class="xiangmu_search">
				    <ul>
				    	<li>
				        	<select class="pd-type">
				            	<option>--按项目类型查找--</option>
				                <option>公益</option>
				                <option>出版</option>
				                <option>娱乐</option>
				            </select>
				        </li>
				        <li>
				        	<select class="pd-type">
				            	<option>--按集资金额--</option>
				                <option>0-1000元</option>
				                <option>1001-5000元</option>
				                <option>5001-10000元</option>
				                <option>10001-100000元</option>
				                <option>100000元以上</option>
				            </select>
				        </li>
				        <li>
				        	<select class="pd-type">
				            	<option>--按发起时间查找--</option>
				                <option>从早到晚</option>
				                <option>从晚到早</option>
				            </select>
				        </li>
				        <li>
				        	<input type="text" placeholder="可输入关键字" />
				        </li>
				        <li>
				        	<a href="javascript:;" type="submit" class="search_btn">查询</a>
				        </li>
				    </ul>
			    </form>
			    <div class="project-checked">
				    <div class="l">
				    	<label><input type="checkbox" id="p_allCheck" />全选/取消</label>
				  	</div>
				  	<div class=" r">
				        <a class="checked_ed" id="Js-outputAll" href="javascript:;">全部导出</a>
				        <a class="checked_ed" id="Js-outputItems" href="javascript:;">导出</a>
				        <a class="checked_ed" href="javascript:;">添加</a>
				        <a class="checked_ed" href="javascript:;">删除</a>
				        <a class="checked_ed" href="javascript:;">修改</a>
			        </div>                                    
			     </div>
			    <div class="grzx_xiangmu_table">
						    	<table>
						    		<colgroup>
						    			<col width="2%">
						    			<col width="15%">
						    			<col width="6%">
						    			<col width="5%">
						    			<col width="20%">
						    			<col width="6%">
						    			<col width="4%">
						    			<col width="6%">
						    			<col width="10%">
						    			<col width="3%">
						    			<col width="3%">
						    			<col width="5%">
						    		</colgroup>
						        	<thead>
						            	<tr class="bg_tr">
						            		<td></td>
						                    <td>项目编号</td>
						                    <td>发起人</td>
						                    <td>项目类别</td>
						                    <td>名称</td>
						                    <td>目标金额</td>
						                    <td>总天数</td>
						                    <td>已筹金额</td>
						                    <td>发起时间</td>
						                    <td>是否完成</td>
						                    <td>是否审核</td>
						                    <td>项目详情</td>
						                    
						                 </tr>
						            </thead>
						            <tbody id="project_tbody_audits">
						            	<tr class="trfirst"><td colspan="9"></td></tr>
						 
						            </tbody>
						        </table>
						    </div>
						</div>
						
			    	<div class=""	>
			    	<div class="m-page">
			    		<div class=wraper>
				    		<ul class="item1">
				    			<li class="item1-num"><input type="button" value="&nbsp<&nbsp上一页"></li>
				    			
				    			<li class="item1-num"><input type="button" value="下一页&nbsp>&nbsp"></li>
				    		</ul>
				    		<div class="total">
				    			共1页&nbsp,&nbsp&nbsp
				    		</div>
				    		<div class="item2">
				    			<span class="i_text">到第</span>
				    			<input type="number" min="1" max="100" value="1" class="i_input">
				    			<span class="i_text">页</span>
				    			<input type="button" value="确定" class="i_span">
				    		</div>
				    	</div>
			    	</div>
			    </div>
			 
			</div>
			<!--项目管理end-->
			
			
			<!--项目类别管理begin-->
			<div class="c_display" style="display:none" id="a_leibie">
				<ul  class="right_box1_ul">
			    	<li>项目类别管理</li>
			        
			    </ul>
			    
			    <div class="project-checked">
				    <div class="l">
				    	<label><input type="checkbox" />全选/取消</label>
				  	</div>
				  	<div class=" r">
				        <a class="checked_ed" id="Js-outputAll" href="javascript:;">全部导出</a>
				        <a class="checked_ed" id="Js-outputItems" href="javascript:;">导出</a>
				        <a class="checked_ed" href="javascript:;">添加</a>
				        <a class="checked_ed" href="javascript:;">删除</a>
				        <a class="checked_ed" href="javascript:;">修改</a>
			        </div>                                    
			     </div>
			    <div class="grzx_xiangmu_table">
						    	<table>
						    		<colgroup>
						    			<col width="15%">
						    			<col width="10%">
						    			<col width="18%">
						    			<col width="12%">
						    			<col width="12%">
						    			<col width="6%">
						    			<col width="8%">
						    			
						    		</colgroup>
						        	<thead>
						            	<tr class="bg_tr">
						                    <td>类别编号</td>
						                    <td>类别名</td>
						                    <td>备注</td>
						                    <td>添加时间</td>
						                    <td>修改时间</td>
						                    <td>项目数</td>
						                    <td>操作人</td>
						                 </tr>
						            </thead>
						        </table>
				</div>
			    	
			    
			</div>
			<!--项目类别管理end-->


        
        </div>
    </div>
</div>

<!-- 底部begin -->
<div class="a_bottom"></div>
<!-- 底部end -->

</body>
</html>