package testFolder;

import java.io.IOException;

import javax.naming.OperationNotSupportedException;

import FEWS.Rinfall.BUI.BuiTranslate;
import usualTool.AtFileWriter;

public class yyyy {

	public static void main(String[] args) throws OperationNotSupportedException, IOException {
		// TODO Auto-generated method stub

		BuiTranslate BT =new BuiTranslate("C:\\Users\\ANDY\\Desktop\\Kao_Z1_Rainfall.xml");
		new AtFileWriter(BT.getBuiRainfall() , "C:\\Users\\ANDY\\\\Desktop\\r.BUI").textWriter("");
		
	}

}
