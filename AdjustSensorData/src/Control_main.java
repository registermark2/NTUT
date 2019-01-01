import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.omg.CORBA.TIMEOUT;

public class Control_main {
	public static String name ="胡椒蝦";
	public static String readExcelpath ="G:\\北科\\EMIC\\20180919\\屏東823to829\\屏東823to829\\整理後資料\\"+name+".xlsx";
	public static String writeExcelpath ="G:\\北科\\EMIC\\20180919\\屏東823to829\\屏東823to829\\整理後資料\\"+name+".xlsx";
	public static String newSheetName = name+"平均10291505";
	public static int timecount = 0;
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		List<List<String>> sensor_all = new ArrayList<>();
		List<List<String>> store_time_value = new ArrayList<>();
		List<String> time = new ArrayList<>();//store time 
		List<String> value = new ArrayList<>();//store value
		List<String> excel_output_time = new ArrayList<>();
		List<String> excel_output_value = new ArrayList<>();
		
//		=================================
//		#readexcel and get data
		readExcel re = new readExcel();
		sensor_all = re.readExcelselect(readExcelpath);
//		System.out.println(sensor_all);
//		=================================
//		#check data if 
		int timecount = 0;
		time = sensor_all.get(0);
		value = sensor_all.get(1);
//		======================================
		for (int day = 22; day < 30 ; day++) {//==============
//		======================================
			
			for(int hour = 0 ; hour<24;hour++) {
				int hour_count=0;
				float sum = 0;
				for(int min = 10 ; min <=60 ;min+=10) {
//					hour_count+=compare(day,hour,min,sensor_all.get(0),sensor_all.get(1),hour_count,timecount);	
//					System.out.print(" "+timecount);
					//		====10點之前的整點
					if(hour<10) {
						if(min==60) {
							if(hour !=9) {
								hour = hour+1;
								String show = "2018-08-"+day+" "+"0"+hour+":"+"00:00";
								System.out.println("比較:"+show+" 被比較:"+time.get(timecount));
								
								if(time.get(timecount).equals(show)) {
	//								System.out.print("比較成功!!: "+"2018-08-"+day+" "+"0"+hour+":"+"00:00");
	//								System.out.println(" 123");
									if(value.get(timecount).equals(null)) {	
										continue;
									}else if(!value.get(timecount).equals("null")) {
										sum +=Float.parseFloat(value.get(timecount));
										hour_count++;
										timecount++;
									}
	//								System.out.println("timecount:"+timecount);
	//								System.out.println("hour_count"+hour_count);
								}
								hour = hour -1 ;
							}else if(hour==9) {
								hour = hour+1;
								String show = "2018-08-"+day+" "+hour+":"+"00:00";
								System.out.println("比較:"+show+" 被比較:"+time.get(timecount));
								
								if(time.get(timecount).equals(show)) {
	//								System.out.print("比較成功!!: "+"2018-08-"+day+" "+"0"+hour+":"+"00:00");
	//								System.out.println(" 123");
									if(value.get(timecount).equals(null)) {	
										continue;
									}else if(!value.get(timecount).equals("null")){
										sum +=Float.parseFloat(value.get(timecount));
										hour_count++;
										timecount++;
									}
	//								System.out.println("timecount:"+timecount);
	//								System.out.println("hour_count"+hour_count);
								}
								hour = hour -1 ;
							}
							
						}
						else if(min<60){
							String show1 = "2018-08-"+day+" "+"0"+hour+":"+min+":00";
							System.out.println("比較:"+show1+" 被比較:"+time.get(timecount));
							
							if(time.get(timecount).equals(show1)) {
//								System.out.println("2018-08-"+day+" "+"0"+hour+":"+min+":00");
								if(value.get(timecount).equals(null)) {	
									continue;
								}else if(!value.get(timecount).equals("null")) {
									sum +=Float.parseFloat(value.get(timecount));
									hour_count++;
									timecount++;
								}
//								System.out.println("timecount"+timecount);
//								System.out.println("hour_count"+hour_count);
							}
						}

					//		====10點之後的整點
					}else {
						if(min==60) {
							if(hour !=23) {
								hour = hour +1 ;
								String show2 = "2018-08-"+day+" "+hour+":"+"00:00";
								System.out.println("比較:"+show2+" 被比較:"+time.get(timecount));
								
								if(time.get(timecount).equals(show2)) {
	//								System.out.print("2018-08-"+day+" "+hour+":"+"00:00");
	//								System.out.println(" 123");
									if(value.get(timecount).equals(null)) {	
										continue;
									}else if(!value.get(timecount).equals("null")) {
										sum +=Float.parseFloat(value.get(timecount));
										hour_count++;
										timecount++;
									}
	//								System.out.println("timecount"+timecount);
	//								System.out.println("hour_count"+hour_count);
								}
								hour = hour -1 ;
							}else if(hour==23) {
//								hour = hour +1 ;
								day+=1;
								String show2 = "2018-08-"+day+" "+"00"+":"+"00:00";
								System.out.println("比較:"+show2+" 被比較:"+time.get(timecount));
								
								if(time.get(timecount).equals(show2)) {
	//								System.out.print("2018-08-"+day+" "+hour+":"+"00:00");
//									System.out.println(" 123");
									if(value.get(timecount).equals(null)) {	
										continue;
									}else if(!value.get(timecount).equals("null")) {
										sum +=Float.parseFloat(value.get(timecount));
										hour_count++;
										timecount++;
									}
	//								System.out.println("timecount"+timecount);
	//								System.out.println("hour_count"+hour_count);
								}
								day-=1;
//								hour = hour -1 ;
							}
						}else if(min<60) {
							String show3 = "2018-08-"+day+" "+hour+":"+min+":00";
							System.out.println("比較:"+show3+" 被比較:"+time.get(timecount));
							
							if(time.get(timecount).equals(show3)) {
//								System.out.println("2018-08-"+day+" "+hour+":"+min+":00");
								if(value.get(timecount).equals(null)) {	
									continue;
								}else if(!value.get(timecount).equals("null")) {
									sum +=Float.parseFloat(value.get(timecount));
									hour_count++;
									timecount++;
								}
//								System.out.println("timecount"+timecount);
//								System.out.println("hour_count"+hour_count);
							}
						}
					}
				}
				if(hour==23) {
					System.out.print("2018-08-"+day+" "+"00:00:00");
					excel_output_time.add("2018-08-"+day+" "+"00:00:00");
				}else {
					System.out.print("2018-08-"+day+" "+(hour+1)+":00:00");
					excel_output_time.add("2018-08-"+day+" "+(hour+1)+":00:00");
				}
				float finalvalue = sum / hour_count;
				System.out.print("    這小時"+hour_count+"筆資料");
				System.out.print("     每小時水位總和:"+sum);
				System.out.println("   每小時平均水位:"+finalvalue);
				if(String.valueOf(finalvalue).equals("NaN")){
					excel_output_value.add("0.0");
				}else if (String.valueOf(finalvalue).equals("null")) {
					excel_output_value.add("0.0");
				}else {
					excel_output_value.add(String.valueOf(finalvalue));
				}
			}	
		}
		store_time_value.add(excel_output_time);
		store_time_value.add(excel_output_value);
		write_To_excel we = new write_To_excel();
		we.writeToExcel(store_time_value, writeExcelpath, newSheetName);
	}
}


