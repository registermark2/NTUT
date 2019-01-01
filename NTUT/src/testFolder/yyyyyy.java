package testFolder;

import java.io.IOException;

import javax.naming.OperationNotSupportedException;

import FEWS.Rinfall.BUI.BuiTranslate;
import usualTool.AtFileWriter;

public class yyyyyy {

	public static void main(String[] args) throws OperationNotSupportedException, IOException {
		// TODO Auto-generated method stub

		BuiTranslate BT =new BuiTranslate("C:\\北科\\專題生\\Rainfall\\Kao_Z4_Rainfall.xml");
		new AtFileWriter(BT.getBuiRainfall() , "C:\\北科\\專題生\\BUI\\0823_Z4.BUI").textWriter("");
		
	}

}
