/**
 * 首页轮播
 */
function lunbo()
{
	var oDiv=document.getElementById('indexBanner');
	var btnDiv=document.getElementById('indexBPage');
	var preBtn=btnDiv.getElementsByTagName('a')[0];
	var nextBtn=btnDiv.getElementsByTagName('a')[1];
	var oUl=oDiv.getElementsByTagName('ul')[0];
	
	function move(){
		
		oUl.style.left=oUl.offsetLeft-1600+'px';
		if(oUl.offsetLeft<-oUl.offsetWidth*(5/6))
		{
			oUl.style.left='0';	
		}	
		}
	var timer=setInterval(move,1500);

	oDiv.onmousemove=function()
	{
		clearInterval(timer);
		
		}
	oDiv.onmouseout=function()
	{
		timer=setInterval(move,1500);
		}
	
	/*****向左向右滚动按钮*****/
	var a=0;
	nextBtn.onclick=function(){
		var timer2=setInterval(function(){
			
			oUl.style.left=oUl.offsetLeft-50+'px';
			a+=50;
			
			if(a==1600){clearInterval(timer2);a=0;}
			if(oUl.style.left==-9600+'px'){
				oUl.style.left=0+'px';
			}
		},10);
	
	}
	preBtn.onclick=function(){
		var timer2=setInterval(function(){
			
			oUl.style.left=oUl.offsetLeft+50+'px';
			a+=50;
			
			if(a==1600){clearInterval(timer2);a=0;}
			if(oUl.style.left==1600+'px'){
				oUl.style.left=-8000+'px';
			}
		},10);
	
	}
}



