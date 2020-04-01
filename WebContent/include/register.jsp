<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css">
</head>
<body>
<!-- 引入公共header -->
<%@ include file="/common/header.jsp"%>


<div class="bg_white bg_login" style="background-image: url(${pageContext.request.contextPath }/img/login_bg.jpg)">
	<div class="page_warp">
		<div class="login_form">
			<div class="login_main l">
				<div class="login_t">注册</div>
				<div class="login_con">
					<form action="/${pageContext.request.contextPath }/register.jhtml" method="post" id="regForm" class="zj_form" novalidate="novalidate">
						<ul class="reg_box">
							<li><i style="font-size:20px;font-weight:bold;line-height:55px;color:#fff;">${err_msg }${both_error }${code_error }</i></li>
						
							<li>
								<span class="login_name">手机</span>
								<div class="login_val">
								<input class="txt" id="Account" name="name" placeholder="输入您的手机号" type="text" value="">
								</div>
							</li>
							<li>
								<span class="login_name">密码</span>
								<div class="login_val">
								<input class="txt" id="Password" name="password" placeholder="输入您的密码" type="text">
								</div>
							</li>
							<li>
							<span class="login_name">确认密码</span>
							<div class="login_val">
							<input class="txt" id="ConfirmPassword" name="ConfirmPassword" placeholder="确认密码" type="text">
							</div>
							</li>
							<li>
							<span class="login_name">验证码</span>
							<div class="login_val imgcode">
							<input type="text" name="code" id="code" class="txt sort_txt" placeholder="输入图形验证码">
							<img class="getCodeBtn" style="cursor: pointer; background:#fff; vertical-align:middle" src="${pageContext.request.contextPath }/code.jhtml" id="VerifyImage2" title="看不清？点击换一个" onclick="javascript:this.src='${pageContext.request.contextPath }/code.jhtml;'+new Date().getMilliseconds()">
							</div>
							</li>
							<!--
							<li>
							<span class="login_name">动态验证码</span>
							<div class="login_val">
							<input type="text" placeholder="输入手机验证码" class="login-mobile-code txt sort_txt " id="phoneCode" name="phoneCode">
							<span class="sendCode"><input type="button" value="发送" onclick="SendCode('Account', 'code', 'sendCode','')" id="sendCode" class="login_btn zx_btn" style="width:150px; border:none; height:32px; line-height:32px; font-size:16px;"></span>
							</div>
							</li>
							-->
							<li class="note">
							<span class="login_name"></span>
							<div class="login_val">
							<label>
							<input type="checkbox" checked="checked" name="agree" id="agree">我已经阅读并接受<a href="javascript:;" onclick="OnUnfold()">《众筹之家服务条款》</a>
							</label>
							</div>
							</li>
							<li class="btn">
							<span class="login_name"></span>
							<div class="login_val">
							<input type="submit" value="注册" style="font-size: 20px;" class="login_btn zx_btn">
							</div> 
							</li>
							<li class="login_tips">
							<span class="login_name"></span>
							<div class="login_val">已注册账号，<a href="login.jsp">直接登录</a></div>
							</li>
						</ul>
					</form>
				</div>
			</div>
<div class="login_side r">
	<div class="login_t">其他方式登录</div>
			<div class="login_con">
				<div class="otherLogin cf"><a href="javascript:;" title="qq" class="other_icon"><i class="zczj icon_qq"></i><span>使用腾讯QQ登录</span></a>
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