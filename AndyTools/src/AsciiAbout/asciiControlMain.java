package AsciiAbout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Tools.fileRead;
import Tools.testTools;

public class asciiControlMain {

	static String path ="C:\\�_��\\�p��\\���ҳ���\\�T�����\\�x�n�����ϥ_��_�I���(TM97)\\29\\dm1d0000.asc"; 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		List<String> temp = new ArrayList<>();
		
		fileRead fr = new fileRead();
		temp = fr.fileRead(path);
		
		for(int i=0 ; i<12;i++) {
			System.out.println(temp.get(i));
		}
	}
}
