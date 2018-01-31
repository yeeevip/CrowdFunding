package campsg.zhongchou.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	//去除小点的时间
	public static Date formatDate(Date date) throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.parse(df.format(date));
	}
	
	//计算距离现在多久
	public static String timeToNow(String dateTime) throws ParseException{
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date current = new Date();
		Date date = df.parse(dateTime);
		Long times = current.getTime() - date.getTime();
		
		if(times>0&&times<60*1000){
			return new Double(Math.floor(times/(1000))).intValue()+"秒前";
		}else if(times>=60*1000&&times<60*60*1000){
			return new Double(Math.floor(times/(60*1000))).intValue()+"分钟前";
		}else if(times>=60*60*1000&&times<24*60*60*1000){
			return new Double(Math.floor(times/(60*60*1000))).intValue()+"小时前";
		}/*else if(times>=24*60*60*1000&&times<200*24*60*60*1000){*/
			return new Double(Math.floor(times/(24*60*60*1000))).intValue()+"天前";
		/*}else{
			return dateTime.split(" ")[0];
		}*/
		
	}
	

}
