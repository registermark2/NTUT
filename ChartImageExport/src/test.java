import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.omg.CORBA.TIMEOUT;

public class test {
	
	public static String path ="G:\\�_��\\EMIC\\20180919\\�̪F823to829\\�̪F823to829\\���L��.xlsx";
	
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		for (int day = 22; day < 24 ; day++) {
			for(int hour = 0 ; hour<24;hour++) {
				int hour_count=0;
				for(int min = 10 ; min <=60 ;min+=10) {
					
					
					//		====10�I���e�����I
					if(hour<10) {
						if(min==60) {
							if(hour !=9) {
								hour = hour+1;
								String show = "2018-08-"+day+" "+"0"+hour+":"+"00:00";
								System.out.println("���:"+show);
								hour = hour-1;
							}else if(hour==9) {
								hour = hour+1;
								String show = "2018-08-"+day+" "+hour+":"+"00:00";
								System.out.println("���:"+show);
								hour = hour-1;
							}
						}
						if(min<60){
							String show1 = "2018-08-"+day+" "+"0"+hour+":"+min+":00";
							System.out.println("���:"+show1);
							
						}

					//		====10�I���᪺���I
					}else {
						if(min==60) {
							if(hour !=23) {
								hour = hour+1;
								String show2 = "2018-08-"+day+" "+hour+":"+"00:00";
								System.out.println("���:"+show2);
								hour = hour-1;
							}else if(hour==23) {
								day+=1;
								String show = "2018-08-"+day+" "+"00"+":"+"00:00";
								System.out.println("���:"+show);
								day-=1;
							}
						}
						if(min<60) {
							String show3 = "2018-08-"+day+" "+hour+":"+min+":00";
							System.out.println("���:"+show3);
						}
						
					}
				}
			}
		}
	}
}

