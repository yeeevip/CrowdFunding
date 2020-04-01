<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/project.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
<script type="text/javascript">
var userSession = ${sessionScope.user == null};

</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/project.js"></script>
  </head>
  
  <body>
   <!-- 引入公共header -->
<%@ include file="/common/header.jsp"%>
<!--项目详情页begin-->
<div class="xqPage">
  <div class="mainXqBox">
  	<!-- 提交订单begin -->
  <div class="zhifuInnerBox">
  	<div class="submitOrderPage">
  		
  		<div class="subMinBox">
  			<div class="ui-view-container">
  				<div class="slide-container">
  					<div class="tjddCont">
  						<a class="tjdd_h3" style="display:none">请选择其他支持项</a>
  						<h3 class="tjdd_h3">请选择支持项</h3>
  						<div class="tjdd_list">
  						
<!--   							<div class="tjdd_item"> -->
<!--   								<div class="wyzz_h3">感谢您的支持</div> -->
<!--   								<p class="support_inforP">感谢您的支持，您将收到我们寄出的信件或贺卡，这份支持将助我们的梦想飞的更高更远。</p> -->
<!--   								<div class="wyzz_Cont"> -->
<!--   									<a href="javascript:;" class="wyzz_ItemA cur">¥ 1</a> -->
<!--   									<a href="javascript:;" class="wyzz_ItemA">¥ 5</a> -->
<!--   									<a href="javascript:;" class="wyzz_ItemA">¥ 10</a> -->
<!--   									<div class="wyzz_inputBox"><label>其他&nbsp;¥</label><input type="text" class="wyzz_input"></div> -->
<!--   									<a href="javascript:;" class="supportVal_A">立即支持</a> -->
<!--   								</div> -->
<!--   							</div> -->
  						 <c:forEach items="${pr }" var="pr" >
  							<div class="tjdd_item">
  							<input type="hidden" name="repay_id" value="${pr.id }">
  							<input type="hidden" name="repay_money" value="${pr.money }">
  								<div class="supportABox">
  									<a href="javascript:;" class="supportVal_A">支持￥${pr.money }</a>
  								</div>
  								<h3 class="support_h3">¥${pr.money }
  									<b><span class="ng-binding">125</span>ren支持</b>
  								</h3>
  								<div class="support_title">${pr.title }</div>
  								<p class="support_inforP ">${pr.content }</p>
  								<div class="supportFooter">
									<div class="supportFLeft">
										<p>回报方式：<b>${pr.type}回报</b></p>
									</div>
									
									<div class="supportFLeft">
										<p>&nbsp;&nbsp;&nbsp;&nbsp;回报时间：<b>项目成功结束后${pr.time}天内</b></p>
									</div>
									
									<div class="supportFRight"></div>
									
								</div>
  							</div>
  						</c:forEach>
  							
  
  							
  						</div>
  					</div>
  				</div>
  			</div>
  			
  			<div class="tjddCont" style="display:none">
  				<div class="tjdd_QHCont">
  					<div class="NumBox">
  						<span>份数</span>
  						<div class="NumInner">
  							<a href="javascript:;" class=""></a>
  							<input name="pay_count" type="text" value="0">
  							<a href="javascript:;" class="next"></a>
  						</div>
  					</div>
  					<div class="AddressBox">
  						<div class="shxx_h3">收货信息</div>
  						<div class="shdzListBox">
  							<div class="shdzListItem checked"><a href="javascript:newAddressForm();"><i class="flag_i"></i>使用新地址</a></div>
  						</div>
  				<c:if test="${receiveInfo != null }">
  						<div id="defultReceive" class="shdzForm_swBox">
  							<div class="tjdd_formItem">
  								<div class="tjddQHFGBox left">
  									<span>收货人：${receiveInfo.receiver}</span>
  								</div>
  								<div class="tjddQHFGBox left" style="margin-left:20px">
  									<span>手机号：${receiveInfo.phone}</span>
  								</div>
  							</div>
  							<div class="tjdd_formItem">
  								<div class="tjddQHFGBox">
  									<span>地址：${receiveInfo.address}</span>
  								</div>
  							</div>
  							
  						</div>
  						
  					</c:if>
  						
  					<c:if test="${receiveInfo == null }">	
  						
  						<div id="newReceive" class="shdzForm_swBox">
  						<input name="is_defaultReceive" type="hidden" value="0" >
  							<div class="tjdd_formItem">
  								<div class="tjddQHFGBox left">
  									<span><input name="receiver" type="text" class="tjdd_QHInput w200" placeholder="姓名"></span>
  								</div>
  								<div class="tjddQHFGBox right">
  									<span><input name="phone" class="tjdd_QHInput" style="width:200px;" type="text" placeholder="手机号"></span>
  								</div>
  							</div>
  							<div class="tjdd_formItem">
  								<div class="tjddSelectBox left">
  									<select name="province">
  										<option>请选择</option>
  									</select>
  								</div>
  								<div class="tjddSelectBox right">
  									<select name="city">
  										<option>请选择</option>
  									</select>
  								</div>
  								<div class="tjddSelectBox right" style="margin-top:10px">
  									<select name="district">
  										<option>请选择</option>
  									</select>
  								</div>
  							</div>
  							<div class="tjdd_formItem">
  								<div class="tjddQHFGBox">
  									<span><input name="address" class="tjdd_QHInput w400" style="width:440px;" type="text" placeholder="详细地址"></span>
  								</div>
  							</div>
  							
  						</div>
  						
  				</c:if>
  						<div class="shdzForm_xnBox">
  							<div><p class="zj_valP">支付<span><b>￥</b><span class="ng-binding">0</span></span></p></div>
  							<div style="height:80px;"><input type="button" class="tjdd_submitBtn" value="提交订单"></div>
  						</div>
  						
  					</div>
  				</div>
  			</div>
  			
  		</div>
  		
  	</div>
  </div>
  	<!-- 提交订单 end-->
  </div>
</div>
<!--项目详情页end-->
<!-- 引入公共footer -->
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
