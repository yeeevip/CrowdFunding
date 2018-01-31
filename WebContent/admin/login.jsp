<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登陆页面</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/admin.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">

</head>
<body>

<!--管理员登陆页面begin-->

	<div class="a_top">
    	<span>
        	欢迎登陆管理员中心
        </span>
    </div>
    <div class="bg_login" style="background-image: url(${pageContext.request.contextPath }/img/login_bg.jpg)">
    	<div class="page_warp">
        	<div class=""></div>
            <div class="login_form">
            	<div class="login_admin_f">
            		<div class="login_t">管理员登陆</div>
	            	<form>
	            		<div class="tab_login">
						</div>
	                	<ul class="tab_login_box">
	                    	
	                        <li><i class="icon_i1"></i><input class="txt" type="text" placeholder="请输入用户名" /></li>
	                        <li><i class="icon_i2"></i><input class="txt" type="text" placeholder="请输入密码" /></li>
	                        <li class="remP">
	                        	
	                            <label><input type="checkbox" />记住密码</label>
	                            <label class="r" ><a style="color: #fff;" href="javascript:;">忘记密码</a></label>
	                        </li>
	                        <li class="login_bnt_li"><input type="button" value="登陆" class="login_btn zx_btn"  onclick="javascript:window.location='${pageContext.request.contextPath }/admin/main.jsp'"  /></li>
	                    </ul>
	                </form>
	            </div>
            </div>
        </div>
    </div>
    <div class="a_bottom"></div>

<!--管理员登陆页面end-->


</body>
</html>