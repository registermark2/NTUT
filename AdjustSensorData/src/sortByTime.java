
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class sortByTime {

	public void getEvery10Value(String path, int month, int firstday, int lastday, int SheetNumber, int colone, int coltwo) throws EncryptedDocumentException, InvalidFormatException, IOException {
		List<List<String>> listtemp = new ArrayList<>();
		readExcel re = new readExcel();
		listtemp = re.readExcelselect(path, SheetNumber, colone, coltwo);
		String tempmonth ="";
		String temp = Integer.toString(month);
		if(month<10) {
			tempmonth = "0"+ month;
		}
		Map<String,String> map = new LinkedHashMap<String, String>();
//		put key and null value 
		for(int day =firstday; day<lastday; day++) {
			for(int hour=0 ; hour<24;hour++) {
				for(int min=0;min<60;min+=10) {
					if(day<10)	{
						if(hour<10) {
							if(min==0) {
								map.put("2018-"+tempmonth+"-"+"0"+day+" "+"0"+hour+":"+"0"+min+":00", "null");
							}else {
								map.put("2018-"+tempmonth+"-"+"0"+day+" "+"0"+hour+":"+min+":00", "null");
							}
						}else if(hour>=10){
							if(min==0) {
								map.put("2018-"+tempmonth+"-"+day+" "+hour+":"+"0"+min+":00", "null");
							}else {
								map.put("2018-"+tempmonth+"-"+day+" "+hour+":"+min+":00", "null");
							}
						}
					}
					else if(day>10){
						if(hour<10) {
							if(min==0) {
								map.put("2018-"+tempmonth+"-"+day+" "+"0"+hour+":"+"0"+min+":00", "null");
							}else {
								map.put("2018-"+tempmonth+"-"+day+" "+"0"+hour+":"+min+":00", "null");
							}
						}else if(hour>=10){
							if(min==0) {
								map.put("2018-"+tempmonth+"-"+day+" "+hour+":"+"0"+min+":00", "null");
							}else {
								map.put("2018-"+tempmonth+"-"+day+" "+hour+":"+min+":00", "null");
							}
						}
					}	
				}
			}
		}
		for (Map.Entry entry : map.entrySet()) {
			   System.out.println("Key : " + entry.getKey() + " Value : "
			    + entry.getValue());
			  }
		
		
		for(int time = 0;time<listtemp.get(0).size(); time++) {
			if(map.containsKey(listtemp.get(0).get(time))) {
				map.put(listtemp.get(0).get(time), listtemp.get(1).get(time));
			}
		}
		List<String> listtime = new ArrayList<>();
		List<String> listvalue = new ArrayList<>();
		List<List<String>> listall = new ArrayList<>();
		
		for(Entry<String, String> entry:map.entrySet()) {
			listtime.add(entry.getKey());
			listvalue.add(entry.getValue());
		}
		listall.add(listtime);
		listall.add(listvalue);
		
		
		write_To_excel we = new write_To_excel();
		we.writeToExcel(listall, path, "10¤ÀÄÁ¤@µ§");
		
	}
	
}
