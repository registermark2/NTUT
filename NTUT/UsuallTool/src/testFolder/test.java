package testFolder;

import java.io.IOException;

import Global.station;
import asciiFunction.AsciiBasicControl;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		AsciiBasicControl ac = new AsciiBasicControl("C:\\北科\\軒哥\\海棠颱風\\Scale1_Output27");
		
		System.out.println(ac.getPosition(162443.8311, 2551162.0524));
		
		
	}
}
