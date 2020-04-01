<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" src="${pageContext.request.contextPath }/common/js/header.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/css/common.css"/>

</head>

<body>
<!--网站header begin-->
<div id="siteHTopBox" class="siteHTopBox">

	<div class="mainInnerBox">

		<div class="siteHtelBox">官方咨询电话							
        	<span>123-456-789</span>
        </div>

	<!--手机app&&联系电话 begin-->
		<div class="siteHRight">
			
         <a href="javascript:;" class="siteH_feedbackA btn_ALink">意见反馈</a>
         <a href="javascript:;" class="siteHCodeB btn_ALink">帮助中心</a>
		</div>
	<!--手机app&&联系电话 end-->
	</div>

</div>

<div class="siteMTopBox">
	<div class="mainInnerBox clearfix relative">
    	<a href="javascript:;" class="siteMIndexA">
        	<img src />
        </a>
        <div class="siteHNavBox clearfix">
        	<div class="siteHNavItem">
            	<a href="${pageContext.request.contextPath }" class="siteHNavItemA">首&nbsp;&nbsp;页</a>
            </div>
            <div class="siteHNavItem">
            	<a href="${pageContext.request.contextPath }/search.jhtml?projectType=-1" class="siteHNavItemA">奖励众筹</a>
            </div>
            <div class="siteHNavItem">
            	<a href="${pageContext.request.contextPath }/search.jhtml?projectType=1" class="siteHNavItemA">公益众筹</a>
            </div>
            <div class="siteHNavItem">
            	<a href="javascript:;" class="siteHNavItemA"></a>
            </div>
        </div>
        
        <a href="${pageContext.request.contextPath }/faqi.jsp" class="siteM_fqBtn btn_ALink">
        	<i></i>
            发起众筹
        </a>
        <c:if test="${sessionScope.user == null }">
        <div class="siteHLoginBox clearfix">
        	<a href="${pageContext.request.contextPath }/include/login.jsp" class="sitehH_login Js_showlogin">登陆</a>
            <span class="line"></span>
            <a href="${pageContext.request.contextPath }/include/register.jsp" class="siteH_register Js_showRegister">注册</a>
        </div>
        </c:if>
        <c:if test="${sessionScope.user != null }">
        <div class="siteHLoginBox clearfix">
        	<a href="${pageContext.request.contextPath }/showPerson.jhtml" class="sitehH_login Js_showlogin">个人中心</a>
            <span class="line"></span>
            <a href="logout.jhtml" class="siteH_register Js_showRegister">注销</a>
        </div>
        </c:if>
        <!--搜索begin-->
        <div class="siteMSearch siteIlB_box" id="search-box" tabindex="0">
	        <form style="width:100%" method="post" action="${pageContext.request.contextPath }/search.jhtml">
	        	<div class="search-input">
	        	
	            	<input type="text" class="siteMSearchInput siteIlB_item sitePHInput" id="search-input" name="key"  />
	            
	            </div>
	            <input type="submit" class="siteMSearchA siteIlB fr" style="border:none;" id="searchBth"/>
	        </form>               	            	
        </div>
        <!--搜索end-->
    </div>
</div>
<!--网站header end-->


<!--回到顶部  -->
<div class="SiteGoTopBox" style="display: none;" id="SiteGoTopBtn">
	<a href="javascript:;" class="btn_ALink"></a>
</div>
<!--回到顶部  -->

</body>
<script type="text/javascript" >
sToBig();//搜索框变大
</script>


</html>