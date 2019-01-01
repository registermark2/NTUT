

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class write_To_excel {
	
	public void writeToExcel(List<List<String>> value,String path,String newSheetName){
		String excelFilePath = path;
	    
    	try {
        	FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        	XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(inputStream);

        	XSSFSheet newSheet = workbook.createSheet(newSheetName);
           
        	int rowNum = 0;
	        System.out.println("\nCreating excel");

	        for(int i=0 ;i<value.get(0).size();i++) {
	            Row row = newSheet.createRow(i);
	            Cell cell0 = row.createCell(0);
	            cell0.setCellValue(value.get(0).get(i));
	            Cell cell1 = row.createCell(1);
	            cell1.setCellValue(value.get(1).get(i));
	        }
	        
        	FileOutputStream outputStream = new FileOutputStream(path);
        	workbook.write(outputStream);
        	System.out.print("end");
        	workbook.close();
        	outputStream.close();
        	
    	} 	catch 	(IOException | EncryptedDocumentException
            	| InvalidFormatException ex) {
        	ex.printStackTrace();
    	}
	}
	public void writeToNewSheet(List<List<String>> value,String path,String newSheetName){
		
	    
		try {
        	FileInputStream inputStream = new FileInputStream(new File(path));
        	XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(inputStream);

        	XSSFSheet newSheet = workbook.createSheet(newSheetName);
           
        	int rowNum = 0;
	        System.out.println("\nCreating excel");

	        for(int i=0 ;i<value.get(0).size();i++) {
	            Row row = newSheet.createRow(i);
	            Cell cell0 = row.createCell(0);
	            cell0.setCellValue(value.get(0).get(i));
	            Cell cell1 = row.createCell(1);
	            cell1.setCellValue(value.get(1).get(i));
	        }
	        
        	FileOutputStream outputStream = new FileOutputStream(path);
        	workbook.write(outputStream);
        	System.out.print("end");
        	workbook.close();
        	outputStream.close();
        	
    	} 	catch 	(IOException | EncryptedDocumentException
            	| InvalidFormatException ex) {
        	ex.printStackTrace();
    	}
	}


}
