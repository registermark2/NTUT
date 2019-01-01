import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;




public class calcuExcel {
	
	public List<String> avgExcelEvery10time(String path ,int SheetNumber, int colone, int coltwo) throws EncryptedDocumentException, InvalidFormatException, IOException {
		readExcel re = new readExcel();
		List<List<String>> listtemp = new ArrayList<>();//read excel and store
		List<String> valuestore = new ArrayList<>();
		listtemp = re.readExcelselect(path, SheetNumber, colone, coltwo);
		
		float sum= 0;
		float avg= 0;
		int count= 0;
		int count_null= 0;
		
		
		
		
		for(int i = 0 ;i<listtemp.get(1).size();i++) {
//			System.out.println("value: "+listtemp.get(1).get(i)+" ");
//			System.out.println("size: "+listtemp.get(1).size());
			if(listtemp.get(1).get(i).equals("null")) {
//				System.out.println("¸õ¹L");
				count_null++;
			}else {
				sum+=Float.valueOf(listtemp.get(1).get(i));
				count_null++;
				count++;
//				System.out.println("123");
			}
			if(count_null==6) {
				System.out.println("sum: "+sum);
				avg = sum/count;
				valuestore.add(String.valueOf(avg));
				count=0;
				count_null=0;
				sum =0;
			}
		}
//		System.out.print("valuestore_size: "+valuestore.size());
		
		
		List<List<String>> listwrite = new ArrayList<>();//value store and write to excel
//		write_To_excel we = new write_To_excel();
//		
//		we.writeToExcel(listwrite, excelwritepath, SheetName);
		return valuestore;
		
		
	}
}
