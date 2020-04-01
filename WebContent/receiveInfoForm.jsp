<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/faqi.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/faqi.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/personal.js"></script>

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

<title></title>
</head>
<body>

<div class="pj_fq">
	
    <!--项目信息begin-->
   	<div class="fq_bodyBox" style="min-height:100%">
	   	<div class="fq_bodyMainBox" style="width:600px">
	        
	 
	        
			 <!-- 个人begin -->
	       	 <div class="gerenInfo">
	        
	            <div class="fq_body1_content">
	                <form id="identityInfo"  method="post" >
              <input type="hidden" name="idType" value="个人">
	                    <ul class="fq_body_ul">
	                    	
	                    	
	                        
	                        <li>
	                            <label>收件人&nbsp;&nbsp;&nbsp;：</label>
	                            <input name="receiver" type="text"/>
	                            
	                        </li>
	                        <li>
	                            <label>联系电话：</label>
	                            <input name="phone" type="text" />
	                            
	                        </li>	                        
	                        <li>
	                            <label>邮编&nbsp;&nbsp;&nbsp;：</label>
	                            <input name="zipcode" type="text" />
	                            
	                        </li>
	                        <li class="province-selector" style="overflow:hidden">
	                            <label>所在地区：</label>
	                            <select name="province" class=""><option>请选择</option></select>
	                            <select name="city" class=""><option>请选择</option></select>

	                            
	                        </li>
	                        <li class="province-selector" style="overflow:hidden">
	                            <label>详细地址：</label>
	                            <input name="address" type="text"   />

	                            
	                        </li>
	                        
	                    </ul>
	                </form>
	            </div>
	           
	          
	       	 </div>
	       	 <!-- 个人end -->
	        
	  
	        
	    </div>
	    <!--项目信息end-->
	    <div class="fq_footer"  style="width:600px">
	    	
	        <a href="javascript:addReceiveInfo();" class=" big btn  btn-blue ">添加</a>
	    </div>
	</div>
</div>
<!--项目发起end-->


</body>
</html>