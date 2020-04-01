<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
/**$(function(){
	$(".login_btn").click(function(){
			
		$.ajax({
			   type:"post",//请求方式
			   cache: false,
			   url:"/CrowdFounding/login.jhtml",//发送请求地址
			   data:{//发送给数据库的数据
			   Account:$("#Account").val(),
			   Password:$("#Password").val()
			   },
			   
		
			
		}		
	);
})**/
</script>
</head>
<body>
<!-- 引入公共header -->
<%@ include file="/common/header.jsp"%>




<div class="bg_login" style="background-image: url(${pageContext.request.contextPath }/img/login_bg.jpg)">
<div class="page_warp">
<div class="login_form">
<div class="login_main l">
<div class="login_t">
登录
<div>


<div class="tab_login">
</div>
<i class="login_b">${both_error }${user_error }${code_error }</i>

<form action="${pageContext.request.contextPath }/login.jhtml" id="login_pt" method="post">
<input type="hidden" name="re" value="${param.re }">

<ul class="tab_login_box" style="display:">


<li>
<i class="icon_i1"></i>
<input class="txt" id="Account" name="name" placeholder="输入账号/邮箱" type="text">
</li>
<li>
<i class="icon_i2"></i>
<input class="txt" id="Password" name="password" placeholder="请输入密码" type="password">
</li>

<li>
<i class="icon_i3"></i>
<input type="text" class="txt" id="ImgCode" name="code" placeholder="请输入验证码">

<img class="getCodeBtn" style="cursor: pointer; background:#fff; vertical-align:middle"
 src="${pageContext.request.contextPath }/code.jhtml" id="VerifyImage2" title="看不清？点击换一个"
 onclick="javascript:this.src='${pageContext.request.contextPath }/code.jhtml;'+new Date().getMilliseconds()">
</li>

<li class="remP">
<label for="remPwd" class="l">
<input id="remPwd" type="checkbox" value="true"><input name="Remember" type="hidden" value="false"><span>记住密码</span>
</label>
<a href="javascript:;" class="r forgetPwd">忘记密码</a>
</li>

<li class="login_bnt_li">
<input type="submit" value="登录" class="login_btn zx_btn">
</li>
<li class="login_tips">还没有账号，<a href="javascript:;">立即注册</a></li>
</ul>
</form>
</div>
</div>
</div>



<div class="login_side r">
<div class="login_t">其他方式登录</div>
<div class="login_con">
<div class="otherLogin"><a href="javascript:;" title="qq" class="other_icon"><i class="zczj icon_qq"></i><span>使用腾讯QQ登录</span></a>
</div>
</div>
</div>
</div>
</div>
</div>



<!-- 引入公共footer -->
<%@ include file="/common/footer.jsp"%>
</body>
</html>