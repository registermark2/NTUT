import java.util.ArrayList;
import java.util.List;

public class productTime {
	public static int count =1;
	public List<String> productTime(int month, int firstday, int lastday){
		List<String> timetemp = new ArrayList<>();
		
		String tempmonth ="";
		String temp = Integer.toString(month);
		if(month<10) {
			tempmonth = "0"+ month;
		}
		
		
		for(int day =firstday; day<lastday; day++) {
			for(int hour=0 ; hour<24;hour++) {
				
					if(day<10)	{
						if(hour<10) {
							if(count==1) {
								count=0;
								continue;
							}else if(count!=1){
								System.out.print("count"+count);
								timetemp.add("2018-"+tempmonth+"-"+"0"+day+" "+"0"+hour+":"+"00:00");
							}
						}else if(hour>=10){
							timetemp.add("2018-"+tempmonth+"-"+day+" "+hour+":"+"00:00");
						}
					}
					else if(day>=10){
						if(hour<10) {
							if(count==1) {
								count=0;
								continue;
							}else if(count!=1){
								timetemp.add("2018-"+tempmonth+"-"+day+" "+"0"+hour+":"+"00:00");
							}
						}else if(hour>=10){
							timetemp.add("2018-"+tempmonth+"-"+day+" "+hour+":"+"00:00");
						}
					}	
			}
		}
		return timetemp;	
	}
}
