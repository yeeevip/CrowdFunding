/**
 * 
 */
/*****菜单切换**********///
var f_display = function(divId){
	var c_displays =  document.querySelectorAll(".c_display");
	for(var i=0;i<c_displays.length;i++){
		//console.log(c_displays);
		c_displays[i].style.display="none";
	}
	document.querySelector("#"+divId).style.display="";
}


$(document).ready(function(){
	
	
	
	/**
	 * 用户管理
	 */
	$("#user_menu").click(function(){
	

		$.ajax({	
		url:"adminUser.jhtml",
		async: true,   //是否为异步请求
	    cache: false,  //是否缓存结果
	    type: "POST", //请求方式为POST);
	    dataType: "json",   //服务器返回的数据是什么类型 
		success: function(user){
			var a = 0;
			//console.log($(".tbg_tr").length);
			if($(".u_tbg_tr").length == user.length) return;
			for(var i=0;i<user.length;i++){

			$("#user_tbody").append(
					"<tr class='u_tbg_tr'>"+
					"<td><input name='user' user_index="+user[i].id+" class='table_checkbox' type='checkbox'></td>"+
            		"<td>"+user[i].id+"</td>"+
            		"<td>"+user[i].user_name+"</td>"+
            		"<td>"+user[i].email+"</td>"+
            		"<td>"+user[i].sex+"</td>"+
            		"<td>"+user[i].real_name+"</td>"+
            		"<td>"+user[i].id_number+"</td>"+
            		"<td>"+user[i].age+"</td>"+
            		"<td>"+user[i].phone+"</td>"+
            		"<td>"+user[i].date_of_registration+"</td>"+
            	"</tr>");
//				$("#table_checkboxBOx").append("<div class='table_checkbox_box'>"+
//			    						"<input user_index="+user[i].id+" class='table_checkbox' type='checkbox' >"+
//			"</div>");
//				
//				$(".table_checkbox_box").height($(".u_tbg_tr:eq(i)").height());

			}
		}
	});

		
	})
			
	/**
	 * 用户全选取消
	 */
		$("#u_allCheck").click(function(){

//			alert($("#u_allCheck").prop("checked"));
		if($("#u_allCheck").prop("checked"))
				$(".u_tbg_tr input[name='user']").attr("checked","checked");
		else
			$(".u_tbg_tr input[name='user']").removeAttr("checked","checked");
			

		})
	
	/**
	 * 项目管理
	 */
	$("#project_menu").click(function(){
		

		$.ajax({	
		url:"adminProject.jhtml",
		async: true,   //是否为异步请求
	    cache: false,  //是否缓存结果
	    type: "POST", //请求方式为POST);
	    dataType: "json",   //服务器返回的数据是什么类型 
		success: function(project){
			console.log(project[1].projectcategory);
			if($(".p_tbg_tr").length == project.length) return;
			for(var i=0;i<project.length;i++)
			$("#project_tbody").append(
					"<tr class='p_tbg_tr'>"+
					"<td><input user_index="+project[i].project_id+" class='table_checkbox' type='checkbox'></td>"+
            		"<td>"+project[i].project_id+"</td>"+
            		"<td>"+project[i].user_id+"</td>"+
            		"<td>"+project[i].projectcategory.category_name+"</td>"+
            		"<td>"+project[i].title+"</td>"+
            		"<td>"+project[i].total_fund_raising+"</td>"+
            		"<td>"+project[i].days_raising+"</td>"+
            		"<td>"+project[i].has_fund_raising+"</td>"+
            		"<td></td>"+
            		"<td></td>"+
            		"<td>"+project[i].is_audits+"</td>"+
            		"<td>查看</td>"+
            	"</tr>");
		}
	});
	})
	
		/**
	 * 项目全选取消
	 */
		$("#p_allCheck").click(function(){

//			alert($("#u_allCheck").prop("checked"));
		if($("#p_allCheck").prop("checked"))
				$(".p_tbg_tr input").attr("checked","checked");
		else
			$(".p_tbg_tr input").removeAttr("checked","checked");
			

		})
		
	
		
	
	
})

/**
	 * 项目管理菜单切换
	 */
		function projectAll(){
				$("#all_projects").show();
				$("#no_audits").hide();
		}
		function projectNo(){
			$("#all_projects").hide();
			$("#no_audits").show();
			
			$.ajax({
				url		:		"auditsProject.jhtml",
				async	:		true,
				cache	:		false,
				type	:		"get",
				dataType:		"json",
				success	:		function(project){
					
					if($(".p_tbg_tr.shenhe").length == project.length) return;
					for(var i=0;i<project.length;i++)
						
					$("#project_tbody_audits").append(
							"<tr class='p_tbg_tr shenhe'>"+
							"<td><input user_index="+project[i].project_id+" class='table_checkbox' type='checkbox'></td>"+
		            		"<td>"+project[i].project_id+"</td>"+
		            		"<td>"+project[i].user_id+"</td>"+
		            		"<td>"+project[i].projectcategory.category_name+"</td>"+
		            		"<td>"+project[i].title+"</td>"+
		            		"<td>"+project[i].total_fund_raising+"</td>"+
		            		"<td>"+project[i].days_raising+"</td>"+
		            		"<td>"+project[i].has_fund_raising+"</td>"+
		            		"<td></td>"+
		            		"<td></td>"+
		            		"<td>"+project[i].is_audits+"</td>"+
		            		"<td><a target='_blank' href='shenhe.jhtml?id="+project[i].project_id+"'>去审核</a></td>"+
		            	"</tr>");
				
				}
			});
		}
		