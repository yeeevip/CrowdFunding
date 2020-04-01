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

<script type="text/javascript">
$(document).ready(function(){})

</script>

<title></title>
</head>
<body>

<div class="pj_fq">
	
    <!--项目信息begin-->
   	<div class="fq_bodyBox" style="min-height:100%">
	   	<div class="fq_bodyMainBox" style="width:890px">
	        
	        <!--项目详细描述begin-->
	        <div id="updateProjectProgress">
	        <input type="hidden" name="projectId" value="${project_id }">
	      
	        <div class="fq_body1 xxr3"">
	        	
	            	
	                
	               <div class="fq_body1_content">
	               <form id="detail_info">
	                <input type="hidden" name="detailCount" value="3">
	                	<div class="fq_body_ul detail">
<!-- 		                	<form> -->
		                    	 
		                      
		                        <div class="text_body">
		                        	<textarea  name="detail_content1" ></textarea>
		                        </div>
		                        
		                        
		                        <div class="upload_detital_pic"> 
		                        	
		                        </div>

		                        
		                        
		                        <div id="content_picBox">
		                       
									<div class="content_picBox">
								    	<div class="pic_top">
								        	<span class="content_pic_span">上传照片(可选)</span>
								            
								        </div>
								        <div calss="pic_bottom">
								        	<div class="input_btn">
								        		
								        		<div class="button_pic"><input type="file" class="uploadPic" id="uploadPic1"/></div>
								        	</div>
								            <p class="pic_bottom_p">支持JPG、GIF、PNG格式的图片，不超过1M大小</p>
								        </div>
								    </div>
								    
								</div>
							
		                        
<!-- 		                    </form> -->
	                    </div>
	                
	
	                </form>
	             </div>   
	
	                
	            </div>
	            
	           </div>
	       
	        
	        <!--项目详细描述end-->
	        

	        
	  
	        
	    </div>
	    <!--项目信息end-->
	    <div class="fq_footer" style="width:890px">
	    	
	        <a href="javascript:updateProjectProcess();" class=" big btn  btn-blue ">发布</a>
	    </div>
	</div>
</div>
<!--项目发起end-->


</body>
</html>