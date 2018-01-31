/**
 * 
 */

function getProvince(pid,obj){
	$.get("getProvince?pid="+pid,function(data){
		date =  eval('(' + data + ')');
		obj.find("option").remove();
		obj.append('<option value="-1">请选择</option>');
		for(var i in date){
			obj.append('<option value="'+date[i].id+'">'+date[i].name+'</option>');
		}
	});
}