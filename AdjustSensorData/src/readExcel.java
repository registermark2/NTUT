import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readExcel {
		List<String> sensor_data_time = new ArrayList<>();
		List<String> sensor_data_value = new ArrayList<>();
		List<List<String>> sensor_all = new ArrayList<>();
		
	public List<List<String>> readExcelselect(String path) throws EncryptedDocumentException, InvalidFormatException, IOException {

		
		Workbook workbook = WorkbookFactory.create(new File(path));
		Sheet sheet = workbook.getSheetAt(0);

		Sheet readsheet = workbook.getSheetAt(0);
		int rsRows = readsheet.getLastRowNum();
		int rsColumns = readsheet.getDefaultRowHeight();
//		
		for (int i = 1; i < rsRows; i++) {
			Row row = sheet.getRow(i);
			Cell cell1 = row.getCell(1);
			Cell cell2 = row.getCell(2);
			DataFormatter formatter = new DataFormatter();
			String time = formatter.formatCellValue(cell1);
			String value = formatter.formatCellValue(cell2);
//			System.out.print(cell1);
//			System.out.println(" "+cell2);
			sensor_data_time.add(time);
			sensor_data_value.add(value);
			
		}
		sensor_all.add(sensor_data_time);
		sensor_all.add(sensor_data_value);
		
//		System.out.print(sensor_data_time);
		return sensor_all;
	}
	public List<List<String>> readExcelselect(String path,int SheetNumber,int colone,int coltwo) throws EncryptedDocumentException, InvalidFormatException, IOException {

		
		Workbook workbook = WorkbookFactory.create(new File(path));
		Sheet sheet = workbook.getSheetAt(SheetNumber);

		Sheet readsheet = workbook.getSheetAt(SheetNumber);
		int rsRows = readsheet.getLastRowNum();
		int rsColumns = readsheet.getDefaultRowHeight();
		
		for (int i = 1; i < rsRows; i++) {
			Row row = sheet.getRow(i);
			Cell cell1 = row.getCell(colone);
			Cell cell2 = row.getCell(coltwo);
			DataFormatter formatter = new DataFormatter();
			String time = formatter.formatCellValue(cell1);
			String value = formatter.formatCellValue(cell2);
//			System.out.print(cell1);
//			System.out.println(" "+cell2);
			sensor_data_time.add(time);
			sensor_data_value.add(value);
			
		}
		sensor_all.add(sensor_data_time);
		sensor_all.add(sensor_data_value);
//		
//		System.out.println("sensor_all"+sensor_all);
		return sensor_all;
	}
}
