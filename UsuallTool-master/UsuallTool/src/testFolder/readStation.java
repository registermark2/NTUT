package testFolder;

import java.io.IOException;
import java.util.Map;

import asciiFunction.AsciiBasicControl;



public class readStation {
	public void readStation (String folderPath ,String[] list, int Ascii_number, Map Station) throws IOException {
		AsciiBasicControl ac = new AsciiBasicControl(folderPath+list[Ascii_number]);
		String show1 = ac.getValue(ac.getPosition(162443.8311, 2551162.0524)[0]-1,ac.getPosition(162443.8311, 2551162.0524)[1]-1);
		String show2 = ac.getValue(ac.getPosition(162443.8311, 2551162.0524)[0], ac.getPosition(162443.8311, 2551162.0524)[1]-1);
		String show3 = ac.getValue(ac.getPosition(162443.8311, 2551162.0524)[0]+1, ac.getPosition(162443.8311, 2551162.0524)[1]-1);
		String show4 = ac.getValue(ac.getPosition(162443.8311, 2551162.0524)[0]-1, ac.getPosition(162443.8311, 2551162.0524)[1]);
		String show5 = ac.getValue(ac.getPosition(162443.8311, 2551162.0524)[0], ac.getPosition(162443.8311, 2551162.0524)[1]);
		String show6 = ac.getValue(ac.getPosition(162443.8311, 2551162.0524)[0]+1, ac.getPosition(162443.8311, 2551162.0524)[1]);
		String show7 = ac.getValue(ac.getPosition(162443.8311, 2551162.0524)[0]-1, ac.getPosition(162443.8311, 2551162.0524)[1]+1);
		String show8 = ac.getValue(ac.getPosition(162443.8311, 2551162.0524)[0], ac.getPosition(162443.8311, 2551162.0524)[1]+1);
		String show9 = ac.getValue(ac.getPosition(162443.8311, 2551162.0524)[0]+1, ac.getPosition(162443.8311, 2551162.0524)[1]+1);
		
		System.out.println("number"+Ascii_number+": "+show1+" "+show2+" "+show3+" "+show4+" "+show5+" "+show6+" "+show7+" "+show8+" "+show9);
	
	}
}
