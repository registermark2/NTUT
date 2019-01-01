
import com.aspose.*;
import com.aspose.cells.ImageFormat;
import com.aspose.cells.ImageOrPrintOptions;
import com.aspose.cells.SheetRender;
import com.aspose.cells.TiffCompression;
import com.aspose.cells.Worksheet;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;

import java.io.*;
import java.util.List;
import javax.imageio.stream.ImageOutputStream;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.Variant;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class control_main {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		
		System.out.println("Start");
        File file = new File("C:\\Users\\Andy\\Desktop\\test\\test.xlsm");
        String macroName = "exporting";
        callExcelMacro cE = new callExcelMacro();
        cE.callExcelMacro(file, macroName);
        System.out.println("Finished");
        
	}
}
