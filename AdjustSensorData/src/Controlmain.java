

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Controlmain {

	public static String excelreadpath = "G:\\�_��\\EMIC\\20180919\\�̪F823to829\\�̪F823to829\\��z����\\�J�Խ�.xlsx";
	public static String excelwritepath ="G:\\�_��\\EMIC\\20180919\\�̪F823to829\\�̪F823to829\\��z����\\�J�Խ�.xlsx";
//	public static int Sheet = 0;
//	public static int colone = 1;
//	public static int coltwo = 2;

	public static String SheetName = "�J�Խ��C�p����3";
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
//		sortByTime st = new sortByTime();
//		st.getEvery10Value(excelreadpath, 8, 23, 30, 0, 1, 2);
//===============value========================
		calcuExcel ce = new calcuExcel();
		List<String> calcutemp = new ArrayList<>();
		calcutemp = ce.avgExcelEvery10time(excelreadpath, 1, 0, 1);
		System.out.println("calcutemp: "+calcutemp);
//	=============time=========================	
		productTime pt = new productTime();
		List<String> timetemp = new ArrayList<>();
		timetemp = pt.productTime(8, 23, 30);

		
////	=================================================		
//		
		List<List<String>> output = new ArrayList<>();
		output.add(timetemp);
		output.add(calcutemp);
//		System.out.println("timesize:"+timetemp.size()); 
//		System.out.println("calcusize:"+calcutemp.size()); 
		write_To_excel we = new write_To_excel();
		we.writeToExcel(output, excelwritepath, SheetName);
		
	}
}
