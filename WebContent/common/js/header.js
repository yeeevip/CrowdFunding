/**
 * 
 */

/**
 * header 搜索框弹出
 */


function sToBig(){
	var sdiv=document.getElementById('search-box');
	var adiv=document.getElementById('searchBth');
	var indiv=document.getElementById('search-input');
	indiv.onfocus=function(){
		adiv.style.backgroundPosition="8px -534px";
		adiv.style.backgroundColor="#fff";	
		sdiv.className+=" itemSearch-focus";		
	}
	indiv.onblur=function(){
		adiv.style.backgroundPosition="";
		adiv.style.backgroundColor="";
        sdiv.className = sdiv.className.replace(' itemSearch-focus', '');//用空白替换掉' itemSearch-focus'
	}
}

/**
 * 回到顶部
 */



window.onscroll = function () {
	var toTop= document.getElementById('SiteGoTopBtn');
	var aa = document.body.scrollTop+document.documentElement.scrollTop;
	var a=true;
    if (aa > 300) {
        toTop.style.display = "block";
    }
    else {
        toTop.style.display = "none";
    } 
   

    toTop.onclick = function(){
    	//alert();
    	    
        var timer=setInterval(function(){
        	document.documentElement.scrollTop=document.documentElement.scrollTop-30;
        	if(document.documentElement.scrollTop==0)  clearInterval(timer);
        }
        ,1);		 
    }
   
    //console.log(document.body.scrollTop);


}








