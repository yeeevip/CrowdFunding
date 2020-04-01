<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/search.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$(".searchB_lib a").click(function(){
		$(".searchB_lib a").each(function(){
			$(this).removeClass("cur");
		});
		$(this).addClass("cur");
	});
	
	
})
</script>

</head>
<body>
<%@ include file="/common/header.jsp"%>


<!--搜索结果显示页面begin-->
<div class="cf_searchTop">
	<div class="searchTBox">
    	<div class="searchTMainBox">
        	<div class="searchB_lib">
            	<label>行业筛选：</label>
                <a href="${pageContext.request.contextPath }/search.jhtml" class="">全部</a>
                <a href="${pageContext.request.contextPath }/search.jhtml?projectType=1" class="">公益</a>
                <a href="${pageContext.request.contextPath }/search.jhtml?projectType=2" class="">农业</a>
                <a href="${pageContext.request.contextPath }/search.jhtml?projectType=3" class="">出版</a>
                <a href="${pageContext.request.contextPath }/search.jhtml?projectType=4" class="">娱乐</a>
                <a href="${pageContext.request.contextPath }/search.jhtml?projectType=5" class="">艺术</a>
                <a href="${pageContext.request.contextPath }/search.jhtml?projectType=6" class="">其他</a>
            </div>
            <div class="searchB_lib">
            	<label>项目进程：</label>
                <a href="javascript:;" class="cur">全部</a>
                <a href="javascript:;" class="">众筹中</a>
                
                <a href="javascript:;" class="">成功结束</a>
            </div>
            <div class="searchB_lib">
            	<label>项目排序：</label>
                <a href="javascript:;" class="cur">默认</a>
                <a href="javascript:;" class="">最新上线<b></b></a>
                <a href="javascript:;" class="">目标金额<b></b></a>
                <a href="javascript:;" class="">支持人数<b></b></a>
                <a href="javascript:;" class="">筹资额<b></b></a>
            </div>
        </div>
    </div>
</div>


<div class="searchItem">
	<div class="searchIMainBox">
	
	<c:forEach items="${projects }" var="p">
	
    	<div class="searchCard">
        	<a href="project.jhtml?id=${p.project_id }" class="siteCardItemImgA"><img src="${p.img_name }" /></a>
            <div class="searchCtext">
            	
                	<div class="searchCT_p">
                    	<h3><a href="project.jhtml?id=${p.project_id }" class="siteCTH3">${p.title }</a></h3>
                        <p class="siteCardIC_p">${p.blurb }</p>
                    </div>
                <div class="searchCFooter">
                	<div class="searchCF_bq">
                    	<!-- <a href="javascript:;">浙江</a>
                        <a href="javascript:;">温州</a>
                        <a href="javascript:;">健康</a>
                        <a href="javascript:;">生态</a> -->
                    </div>
                     <fmt:formatNumber type="number" var="a" value="${p.has_fund_raising/p.total_fund_raising*100}" pattern="0.00" maxFractionDigits="2"/> 
                    <div class="searchCF_jd">
                    	<div class="jd_now" style="width:${a }%;"></div>
                    </div>
                    <div class="searchCF_je">
                    	<div class="ftDiv">
                        	<p class="ftP">￥${p.has_fund_raising }</p>
                            <p class="scP">已筹款</p>
                        </div>
                        <div class="scDiv">
                        	<!-- <p class="ftP">12</p>
                            <p class="scP">支持数</p> -->
                        </div>
                        <div class="thDiv">
                        	<p class="ftP">${a }%</p>
                            <p class="scP">筹款进度</p>
                        </div>
                    </div>
                </div>
                     
        </div>
    </div>
    
    </c:forEach>
    
    
    
</div>
</div>

<div class="searchPage">
	<div class="searchPBox">
    	<div class="searchPMainBox">
    	
			<%
					Integer count=(Integer)request.getAttribute("count");
					Integer pageTotal=(int)Math.ceil(count/20);				
					double p=count;
					if(Math.ceil(p/20)>pageTotal){pageTotal++;}
					%>
    	
    	<%for(int i=0;i<pageTotal;i++){ %>
        	<a href="${pageContext.request.contextPath }/search.jhtml?projectType=${projectType}&&page=<%=i+1 %>" class="normalPage cu"><%=i+1 %></a>
      <%} %>
            <!-- <span class="dianhaoSpan">...</span> -->
            <a href="javascript:;" class="nextPage"></a>
        </div>
    </div>
</div>
<!--搜索结果显示页面end-->
<%@ include file="/common/footer.jsp"%>
</body>
</html>