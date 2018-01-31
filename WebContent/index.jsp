<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>首页</title>
<link type="text/css" rel="stylesheet" href="css/index.css">
<script language="JavaScript" src="${pageContext.request.contextPath }/js/index.js"></script>
</head>
<body>
<!-- 引入公共header -->
<%@ include file="/common/header.jsp"%>



	<!--bannner-begin-->
<div class="indexBanner" id="indexBanner">
	<div class="indexBannerView">
		<ul >
	    	<li><img src="img/banner/banner1.jpg" /></li>
	        <li><img src="img/banner/banner2.jpg" /></li>
	        <li><img src="img/banner/banner3.jpg" /></li>
	        <li><img src="img/banner/banner4.jpg" /></li>
	        <li><img src="img/banner/banner5.jpg" /></li>
	        <li><img src="img/banner/banner6.jpg" /></li>
	    </ul>
	    <div class="indexBPage" id="indexBPage">
	    	<a href="javascript:;" class="pre"></a>
	        <a href="javascript:;" class="next"></a>
	    </div>
	</div>	
</div>
<!--banner-end-->


	<!--热门推荐-->
<div class="indexZCWrap">
 	<div class="mainInnerBox">
    	<h3 class="indexZCH3">热门推荐</h3>
		  <ul class="indexZCLabel_ul">
		      <li class="siteIlB_item"><a href="javascript:;" class="site_ALink">最新上线</a></li>
		      <li class="geban siteIlB_item">/</li>
		      <li class="siteIlB_item"><a href="javascript:;" class="site_ALink">公益</a></li>
		      <li class="geban siteIlB_item">/</li>
		      <li class="siteIlB_item"><a href="javascript:;" class="site_ALink">农业</a></li>
		      <li class="geban siteIlB_item">/</li>
		      <li class="siteIlB_item"><a href="javascript:;" class="site_ALink">出版</a></li>
		      <li class="geban siteIlB_item">/</li>
		      <li class="siteIlB_item"><a href="javascript:;" class="site_ALink">娱乐</a></li>
		      <li class="geban siteIlB_item">/</li>
		      <li class="siteIlB_item"><a href="javascript:;" class="site_ALink">艺术</a></li>
		      <li class="moreA siteIlB_item"><a href="javascript:;">更多&gt;</a></li>      
		  </ul> 
        <!--卡片列begin表-->
        <div class="indCardListWrap">
        


        
			<div class="indCardItem">
				<a href="project.jhtml?id=${gy.get(3).project_id }" class="siteCardItemImgA"><img src="${gy.get(3).img_name }" /></a>
			    <div class="indCardICBox">
			    	<div class="indCardICText">
			        	<a href="project.jhtml?id=${gy.get(3).project_id }" class="siteCardICH3">${gy.get(3).title }</a>
			            <p class="siteCardIC_p ind">${gy.get(3).blurb }</p>
			        </div>
			        <div class="siteCardFBox">
			        	<div class="siteCardFLabelBox">
			            	<<!-- a href="javascript:;">北京</a>
			                <a href="javascript:;">我行我素</a> -->
			            </div>
<fmt:formatNumber type="number" var="a" value="${gy.get(3).has_fund_raising/gy.get(3).total_fund_raising*100}" pattern="0.00" maxFractionDigits="2"/>  
			            <div class="siteCardRatio">
			            	<div class="siteCardRatioInner" style="width:${a}%"></div>
			            </div>
			            <div class="siteCardFData">
			            	<div class="ftDiv">
			                	<p class="ftP">￥${gy.get(3).has_fund_raising}</p>
			                    <p class="scP">已筹款</p>
			                </div>
			                <div class="scDiv">
			                	<!-- <p class="ftP">149</p>
			                    <p class="scP">支持数</p> -->
			                </div>
			                <div class="thDiv">
			                
			                
			                	<p class="ftP">${a}%</p>
			                	
			               
			                    <p class="scP">筹款进度</p> 
			                </div>
			            </div>
			        	
			        </div>
			    </div>
			</div>
			


			<div class="indCardItem">
				<a href="project.jhtml?id=${cb.get(1).project_id }" class="siteCardItemImgA"><img src="${cb.get(1).img_name }" /></a>
			    <div class="indCardICBox">
			    	<div class="indCardICText">
			        	<a href="project.jhtml?id=${cb.get(1).project_id }" class="siteCardICH3">${cb.get(1).title }</a>
			            <p class="siteCardIC_p ind">${cb.get(1).blurb }</p>
			        </div>
			        <div class="siteCardFBox">
			        	<div class="siteCardFLabelBox">
			            	<!-- <a href="javascript:;">北京</a>
			                <a href="javascript:;">我行我素</a> -->
			            </div>
<fmt:formatNumber type="number" var="a" value="${cb.get(1).has_fund_raising/cb.get(1).total_fund_raising*100}" pattern="0.00" maxFractionDigits="2"/> 			            
			            <div class="siteCardRatio">
			            	<div class="siteCardRatioInner" style="width:${a}%"></div>
			            </div>
			            <div class="siteCardFData">
			            	<div class="ftDiv">
			                	<p class="ftP">￥${cb.get(1).has_fund_raising}</p>
			                    <p class="scP">已筹款</p>
			                </div>
			                <div class="scDiv">
			                	<!-- <p class="ftP">149</p>
			                    <p class="scP">支持数</p> -->
			                </div>
			                <div class="thDiv">
			                	<p class="ftP">${a}%</p>
			                    <p class="scP">筹款进度</p>
			                </div>
			            </div>
			        	
			        </div>
			    </div>
			</div>




			<div class="indCardItem">
				<a href="project.jhtml?id=${ys.get(2).project_id }" class="siteCardItemImgA"><img src="${ys.get(2).img_name }" /></a>
			    <div class="indCardICBox">
			    	<div class="indCardICText">
			        	<a href="project.jhtml?id=${ys.get(2).project_id }" class="siteCardICH3">${ys.get(2).title }</a>
			            <p class="siteCardIC_p ind">${ys.get(2).blurb }</p>
			        </div>
			        <div class="siteCardFBox">
			        	<div class="siteCardFLabelBox">
			            	<!-- <a href="javascript:;">北京</a>
			                <a href="javascript:;">我行我素</a> -->
			            </div>
			            <div class="siteCardRatio">
<fmt:formatNumber type="number" var="a" value="${ys.get(2).has_fund_raising/ys.get(2).total_fund_raising*100}" pattern="0.00" maxFractionDigits="2"/>			            
			            	<div class="siteCardRatioInner" style="width:${a}%"></div>
			            </div>
			            <div class="siteCardFData">
			            	<div class="ftDiv">
			                	<p class="ftP">￥${ys.get(2).has_fund_raising }</p>
			                    <p class="scP">已筹款</p>
			                </div>
			                <div class="scDiv">
			                	<!-- <p class="ftP">149</p>
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



			
			
		</div>
        <!--卡片列表end-->
        <a href="search.jhtml" class="indCardListMoreA btn_Alink">浏览更多项目</a>
        
    </div>
</div>
	<!--热门推荐end-->
    
    	<!--公益众筹begin-->
<div class="indexZCWrap">
 	<div class="mainInnerBox">
    	<h3 class="indexZCH3">公益众筹</h3>
        <ul class="indexZCLabel_ul siteIlb_box"></ul>
        <!--卡片列begin表-->
        <div class="indCardListWrap">
        
        <c:forEach items="${gy }" begin="0" end="2" var="gy1">
        
			<div class="indCardItem">
				<a href="project.jhtml?id=${gy1.project_id }" class="siteCardItemImgA"><img src="${gy1.img_name }" /></a>
			    <div class="indCardICBox">
			    	<div class="indCardICText">
			        	<a href="project.jhtml?id=${gy1.project_id }" class="siteCardICH3">${gy1.title }</a>
			            <p class="siteCardIC_p ind">${gy1.blurb }</p>
			        </div>
			        <div class="siteCardFBox">
			        	<div class="siteCardFLabelBox">
			            	<!-- <a href="javascript:;">北京</a>
			                <a href="javascript:;">我行我素</a> -->
			            </div>
			            <div class="siteCardRatio">
<fmt:formatNumber type="number" var="a" value="${gy1.has_fund_raising/gy1.total_fund_raising*100}" pattern="0.00" maxFractionDigits="2"/>			            
			            	<div class="siteCardRatioInner" style="width:${a}%"></div>
			            </div>
			            <div class="siteCardFData">
			            	<div class="ftDiv">
			                	<p class="ftP">￥${gy1.has_fund_raising }</p>
			                    <p class="scP">已筹款</p>
			                </div>
			                <div class="scDiv">
			                	<!-- <p class="ftP">149</p>
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
        <!--卡片列表end-->
        <a href="search.jhtml?projectType=1" class="indCardListMoreA btn_Alink">浏览更多项目</a>
        
    </div>
</div>
	<!--公益众筹end-->
    
    
    <!--农业众筹begin-->
<div class="indexZCWrap">

 	<div class="mainInnerBox">
    	<h3 class="indexZCH3">农业众筹</h3>
        <ul class="indexZCLabel_ul siteIlb_box"></ul>
        <!--卡片列begin表-->
        <div class="indCardListWrap">
<c:forEach items="${ny }" begin="0" end="2" var="ny1">        
			<div class="indCardItem">
				<a href="project.jhtml?id=${ny1.project_id }" class="siteCardItemImgA"><img src="${ny1.img_name }" /></a>
			    <div class="indCardICBox">
			    	<div class="indCardICText">
			        	<a href="project.jhtml?id=${ny1.project_id }" class="siteCardICH3">${ny1.title }</a>
			            <p class="siteCardIC_p ind">${ny1.blurb }</p>
			        </div>
			        <div class="siteCardFBox">
			        	<div class="siteCardFLabelBox">
			            	<!-- <a href="javascript:;">北京</a>
			                <a href="javascript:;">我行我素</a> -->
			            </div>
			            <div class="siteCardRatio">
<fmt:formatNumber type="number" var="a" value="${ny1.has_fund_raising/ny1.total_fund_raising*100}" pattern="0.00" maxFractionDigits="2"/>			            
			            	<div class="siteCardRatioInner" style="width:${a}%"></div>
			            </div>
			            <div class="siteCardFData">
			            	<div class="ftDiv">
			                	<p class="ftP">￥${ny1.has_fund_raising }</p>
			                    <p class="scP">已筹款</p>
			                </div>
			                <div class="scDiv">
			                	<!-- <p class="ftP">149</p>
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
        <!--卡片列表end-->
        <a href="search.jhtml?projectType=2" class="indCardListMoreA btn_Alink">浏览更多项目</a>
        
    </div>
</div>
	<!--农业众筹end-->
    
    
    <!--出版众筹begin-->
<div class="indexZCWrap">
 	<div class="mainInnerBox">
    	<h3 class="indexZCH3">出版众筹</h3>
        <ul class="indexZCLabel_ul siteIlb_box"></ul>
        <!--卡片列begin表-->
        <div class="indCardListWrap">
  <c:forEach items="${cb }" begin="0" end="2" var="cb1">   
			<div class="indCardItem">
				<a href="project.jhtml?id=${cb1.project_id }" class="siteCardItemImgA"><img src="${cb1.img_name }" /></a>
			    <div class="indCardICBox">
			    	<div class="indCardICText">
			        	<a href="project.jhtml?id=${cb1.project_id }" class="siteCardICH3">${cb1.title }</a>
			            <p class="siteCardIC_p ind">${cb1.blurb }</p>
			        </div>
			        <div class="siteCardFBox">
			        	<div class="siteCardFLabelBox">
			            	<!-- <a href="javascript:;">北京</a>
			                <a href="javascript:;">我行我素</a> -->
			            </div>
			            <div class="siteCardRatio">
<fmt:formatNumber type="number" var="a" value="${cb1.has_fund_raising/cb1.total_fund_raising*100}" pattern="0.00" maxFractionDigits="2"/>			            
			            	<div class="siteCardRatioInner" style="width:${a}%"></div>
			            </div>
			            <div class="siteCardFData">
			            	<div class="ftDiv">
			                	<p class="ftP">￥${cb1.has_fund_raising }</p>
			                    <p class="scP">已筹款</p>
			                </div>
			                <div class="scDiv">
			                	<!-- <p class="ftP">149</p>
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
        <!--卡片列表end-->
        <a href="search.jhtml?projectType=3" class="indCardListMoreA btn_Alink">浏览更多项目</a>
        
    </div>
</div>
	<!--出版众筹end-->   
    
    
    <!--艺术众筹begin-->
<div class="indexZCWrap">
 	<div class="mainInnerBox">
    	<h3 class="indexZCH3">艺术众筹</h3>
        <ul class="indexZCLabel_ul siteIlb_box"></ul>
        <!--卡片列begin表-->
        <div class="indCardListWrap">
<c:forEach items="${ys }" begin="0" end="2" var="ys1">       
			<div class="indCardItem">
				<a href="project.jhtml?id=${ys1.project_id }" class="siteCardItemImgA"><img src="${ys1.img_name }" /></a>
			    <div class="indCardICBox">
			    	<div class="indCardICText">
			        	<a href="project.jhtml?id=${ys1.project_id }" class="siteCardICH3">${ys1.title }</a>
			            <p class="siteCardIC_p ind">${ys1.blurb }</p>
			        </div>
			        <div class="siteCardFBox">
			        	<div class="siteCardFLabelBox">
			            	<!-- <a href="javascript:;">北京</a>
			                <a href="javascript:;">我行我素</a> -->
			            </div>
			            <div class="siteCardRatio">
<fmt:formatNumber type="number" var="a" value="${ys1.has_fund_raising/ys1.total_fund_raising*100}" pattern="0.00" maxFractionDigits="2"/>			            
			            	<div class="siteCardRatioInner" style="width:${a}%"></div>
			            </div>
			            <div class="siteCardFData">
			            	<div class="ftDiv">
			                	<p class="ftP">￥${ys1.has_fund_raising }</p>
			                    <p class="scP">已筹款</p>
			                </div>
			                <div class="scDiv">
			                	<!-- <p class="ftP">149</p>
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
        <!--卡片列表end-->
        <a href="search.jhtml?projectType=4" class="indCardListMoreA btn_Alink">浏览更多项目</a>
        
    </div>
</div>
	<!--艺术众筹end--> 



<!-- 引入公共footer -->
<%@ include file="/common/footer.jsp"%>


</body>
<script type="text/javascript">

lunbo();//轮播滚动
</script>

</html>