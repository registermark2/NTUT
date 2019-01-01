import java.io.File;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;

public class callExcelMacro {
	public void callExcelMacro(File file, String macroName) {
		   ComThread.InitSTA();
	       final ActiveXComponent excel = new ActiveXComponent("Excel.Application");

	    try {
	        // This will open the excel if the property is set to true
	        // excel.setProperty("Visible", new Variant(true));

	        final Dispatch workbooks = excel.getProperty("Workbooks")
	                .toDispatch();
	        final Dispatch workBook = Dispatch.call(workbooks, "Open",
	                file.getAbsolutePath()).toDispatch();

	        // Calls the macro
	        com.jacob.com.Variant result = Dispatch.call(excel, "Run", new com.jacob.com.Variant(macroName));

	        // Saves and closes
//	        Dispatch.call(workBook, "Save");
	        com.jacob.com.Variant f = new com.jacob.com.Variant(true);
	        Dispatch.call(workBook, "Close", f);

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    	excel.invoke("Quit");
	    	ComThread.Release();
	    }
 }	
}
