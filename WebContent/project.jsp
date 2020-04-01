<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${p.title }</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/project.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/project.js"></script>
<script type="text/javascript">
var userSession = ${sessionScope.user == null};
</script>
</head>
<body>
<%@ include file="/common/header.jsp"%>

<!--项目详情页begin-->
<div class="xqPage">
  <div class="mainXqBox">
	<div class="xqPageBox">
    	<!--标题封面begin-->
        <div class="xqTitle">
        	<div class="xqTitText">
            	
                	<div class="text_h3_box">
                    	<p class="text_h3">${p.title }<p>
                    </div>
                    <div class="text_span">
                    	<span class="txt1">发起人</span>
                        <span class="txt2">用户id_${p.user_id}</span>
                        <!-- <span class=txt3>联系我</span> -->
                    </div>
                
            </div>
            
        </div>
        <div class="xqDetailBox">
            	<span></span>
            	<div class="det_left">
                	<img style="height: 400px;width: 534px;" src="${p.img_name }" />
                </div>
                <div class="det_right">
                	<div class="det_rightBox">
                    	<div class="detR_p">
                        	<p>
                            	<!-- <span class="ftP">1111</span>
                                <span class="scP">支持数</span> -->
                            </p>
                        </div>
                        <div class="detR_p">
                        	<p>
                            	<span class="ftP">¥${p.has_fund_raising }</span>
                                <span class="scP">已筹款</span>
                            </p>
                        </div>
                    </div>
                    <div class="det_jinduBox">
                    <fmt:formatNumber type="number" var="a" value="${p.has_fund_raising/p.total_fund_raising*100}" pattern="0.00" maxFractionDigits="2"/> 
                    	<div class="jindu_p">
                        	<p class="ftP">${a }%</p>
                        </div>
                        <div class="xqRatio">
                        	<div class="xqRatioInner " style="width:${a}%;"></div>
                        </div>
                        <div class="jindu_s">
                        	<div class="s_s">
                            	<span>剩余</span>
                                <b>${p.leftDays }</b>
                            </div>
                            <div class="s_m">
                            	<span>目标筹资</span>
                                <b>¥${p.total_fund_raising }</b>
                            </div>
                        </div>
                    </div>
                    <div class="det_Btn_box">
                    	<a href="orderPage?project=${p.project_id }" class="det_btn1" >立即支持</a>
                        <div class="det_btn2Box">
                        	<a href="javascript:;" class="det_btn2">分享</a>
                        </div>
                    </div>
                </div>
            </div>
        <!--标题封面end-->
        
        <!--导航栏begin-->
        <div class="xqTab" style="z-index:100">
        	<div class="tab_box">
            	<ul class="tab_ul">
                	<li><a href="#xqMain_left" class="tab_li">项目详情</a></li>
                    <li><a href="#xq_plBox" class="tab_li">评论（0）</a></li>
                    <li><a href="#xq_zcBox" class="tab_li">支持记录（0）</a></li>
                </ul>
            </div>
        </div>
        <!--导航栏end-->
        
        
        
       <!--正文begin-->
       <div class="xq_show">
       		<div class="xq_mainBox">
            	<!--左侧begin-->
            	<div id="xqMain_left" class="xqMain_left">
			        <!--分享begin-->
			        <div class="share-box">
			        	<div class="share_num"><span>分享</span></div>
			            
			         <ul class="share_right">
			               <li class="share_wechat"><i></i>微信</li>
			               <li class="share_qq"><i></i>qq空间</li>
			                <li class="share_weibo"><i></i>微博</li>
			           </ul>
			            
			        </div>
			        <!--分享end-->
			        
			        
                    <!--段落begin-->
                    <div class="xqText">
                   		 <div class="xqTextTitle">
                            <p class="xqTextTitle_p"></p>
                            <div class="xqLeftTitleInner">
                                <h2>项目最新进展</h2>
                            </div>
                            
                         </div>

								<div class="zxjz_NavOuterBox">
									<div class="zxjz_NavBox" id="progressList">
									
									
									<c:forEach items="${pp }" var="pp">
									
										<div class="zxjz_NavItem">
												<div class="zxjz_navItemInner">
													<h3 class="zxjz_navItem_h3">
														<a href="javascript:void(0);"
															onclick="siXin(368862,'鬼影人间');sitePop.showSixin(368862);"
															class="colorALink">${pp.pubUser }</a>发起人
													</h3>
													<p class="textP">
														${pp.content }
													</p>
													<div class="lastInner"></div>
													<div class="zxjzILBox">
														<p class="timeP">${pp.publishDate }</p>
														<i class="statusIcon gr"></i>
													</div>
												</div>
											</div>
									</c:forEach>
										
										
										
										
									</div>
									
									
								</div>
								
								




								<c:forEach items="${pd }" var="pdr">
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
                    
                    
                    <!--评论begin-->
                    <div id="xq_plBox" class="xq_plBox">
                    	<div class="xqTextTitle">
                        	<p class="xqTextTitle_p"></p>
                            <div class="xqLeftTitleInner">
                            	<h2>评论</h2>
                            </div>
                        </div>
                        <!--输入框begin-->
                        <form action="/CrowdFounding/newComment.jhtml" method="post">
                        <div class="pl_inputBox">
                        	<div class="pl_tx">
                            	<a href="javascript:;"><img src="" /></a>
                            </div>
                            <textarea id="pl_content" name="content" class="pl_area" placeholder="用户xxx，说点什么吧~~"></textarea>
                            <!--<span class="">用户xxx，说点什么吧~~</span>  -->
                            <div class="pl_cImg_box">
                            	<div class="cImg">
                                	<div class="img_btn">选择图片</div>
                                </div>
                                <span>最多5张</span>
                                <input type="button" class="img_btnFb" value="发布" id="fabiao_pl">
                            </div>
                        </div>
                        </form>
                        <!--输入框end-->
                        <!--评论内容begin-->
                        <div style="min-height:30px" id="plcontentBox">
                        <c:forEach items="${comments }" var="c" varStatus="sta">
	                        <div class="pl_contentBox">
	                        	<div class="content_tx">
	                            	<a href="javascript:;"><img src="" /></a>
	                            </div>
	                            <a href="javascript:;" class="content_nc">用户ID${c.user.id }</a>
	                            <p class="content_text">${c.content }</p>
	                            <div class="content_img">
	                            	<div class="contentIBox">
	                                	<img src="" />
	                                </div>
	                            </div>
	                            <div class="pl_days">
	                            	<span class="timeSpan">3天前</span>
	                                <a href="javascript:;" class="to_pl">评论(0)</a>
	                            </div>
	                        </div>
	                     </c:forEach>  
	                        
                        </div>
                        <!--评论内容end-->
                        
                        <!--分页begin-->
                        <div class="pl_fanye">
                        	<div class="fy_MainBox">
                            	
	                      	 <a class="fy_page">上一页</a>
                             <a class="fy_page cur">1</a>
                             <a class="fy_page">下一页</a>
                             
                            </div>
                        </div>
                        <!--分页页end-->
                    </div>
                    <!--评论end-->
                    
                    <!--支持记录begin-->
   <%--                  <div id="xq_zcBox" class="xq_zcBox">
                    	<div class="xqTextTitle">
                        	<p class="xqTextTitle_p"></p>
                            <div class="xqLeftTitleInner">
                            	<h2>支持记录</h2>
                            </div>
                        </div>
                        <div class="zcMainBox">
                        	<table class="zcBox_table">
                            	<colgroup>
                                	<col width="80px" />
                                    <col width="220px" />
                                    <col width="80px" />
                                    <col width="140px" />
                                    <col width="auto" />
                                </colgroup>
                            	<thead>
                                	<tr>
                                    	<th>订单序号</th>
                                        <th>支持者</th>
                                        <th>支持项</th>
                                        <th>数量(0)</th>
                                        <th>支持时间</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<tr>
                                    	<td class="numBold">254</td>
                                        <td class="numBold">用户_11545</td>
                                        <td class="numBold"><p class="yelBold">¥38</p></td>
                                        <td class="numBig">4</td>
                                        <td class="numBig">2016-11-04
11:24:29</td>
                                    </tr>
                                    <tr>
                                    	<td class="numBold">254</td>
                                        <td class="numBold">用户_11545</td>
                                        <td class="numBold"><p class="yelBold">¥38</p></td>
                                        <td class="numBig">4</td>
                                        <td class="numBig">2016-11-04
11:24:29</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <!--分页begin-->
                        <div class="pl_fanye">
                        	<div class="fy_MainBox">
                            	
	                      	 <a class="fy_page">上一页</a>
                             <a class="fy_page cur">1</a>
                             <a class="fy_page">下一页</a>
                             
                            </div>
                        </div> --%>
                        <!--分页页end-->                    
                    <!--  </div> -->
                    <!--支持记录end-->
                    <!-- <div class="xq_footerBox">
                    	<div class="foot_date">
                        	<p class="ftP">¥20,209</p>
                            <p class="fcP">已筹款</p>
                        </div>
                        <div class="foot_date">
                        	<p class="ftP">272</p>
                            <p class="fcP">支持数</p>
                        </div>
                        <div class="foot_date">
                        	<p class="ftP">35天</p>
                            <p class="fcP">剩余天数</p>
                        </div>
                        <a href="javascript:;">立即支持</a>
                    </div> -->
                    
			        <!--分享begin-->
			       <!--  <div class="share-box">
			        	<div class="share_num"><span>分享</span></div>
			            
			         <ul class="share_right">
			               <li class="share_wechat"><i></i>微信</li>
			               <li class="share_qq"><i></i>qq空间</li>
			                <li class="share_weibo"><i></i>微博</li>
			           </ul>
			            
			        </div> -->
			        <!--分享end-->
                    
                </div>
                <!--左侧end-->
                
                
                
                <!--右侧begin-->
                <div class="xq_rightBox">
                	<a href="javascript:;" class="yq_friend"><i></i>邀请朋友一起筹</a>
                    <!--支持金额列表-->
                    <div class="zcjeBox">
	                    <div>
	                    	<div>
	                        	<h3 class="wszc_h3">无私支持<b>49人已支持</b></h3>                            
	                        </div>
	                        <p class="zcje_textP">感谢您的无私奉献，这份支持将助我们的梦想飞的更高更远。</p>
	                        <div class="wszcLib">
	                        	<a href="javascript:;" class="cur">¥1</a>
	                            <a href="javascript:;">¥5</a>
	                            <a href="javascript:;">¥10</a>
	                        </div>
	                        <div class="wszc_qita">
	                        	<label>其他<b>¥</b></label>
	                            <input type="text" class="wszc_input" />
	                        </div>
	                        <input type="button" value="立即支持"  class="wszc_subBtn"/>
	                    </div>
                    
	         <c:forEach items="${pr }" var="pr" >
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
                    <a href="javascript:;" class="sub_btn">支持此项目</a>
                </div>
                <!--右侧end-->
            </div>
       </div>
       <!--正文end-->
    </div>





  </div>
</div>
<!--项目详情页end-->


<%@ include file="/common/footer.jsp"%>
</body>
</html>