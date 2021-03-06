package testFolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import asciiFunction.AsciiBasicControl;



public class readStation {
		
	public List<String> readStation (String folderPath ,String[] list, int Ascii_number, String[] StationCoordinate) throws IOException {
		List<String> data = new ArrayList<>();
		AsciiBasicControl ac = new AsciiBasicControl(folderPath+list[Ascii_number]);
		String show1 = ac.getValue(ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[0]-1,ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[1]-1);
		String show2 = ac.getValue(ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[0], ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[1]-1);
		String show3 = ac.getValue(ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[0]+1, ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[1]-1);
		String show4 = ac.getValue(ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[0]-1, ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[1]);
		String show5 = ac.getValue(ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[0], ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[1]);
		String show6 = ac.getValue(ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[0]+1, ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[1]);
		String show7 = ac.getValue(ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[0]-1, ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[1]+1);
		String show8 = ac.getValue(ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[0], ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[1]+1);
		String show9 = ac.getValue(ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[0]+1, ac.getPosition(Double.parseDouble(StationCoordinate[1]), Double.parseDouble(StationCoordinate[2]))[1]+1);
		
//		System.out.println("number"+Ascii_number+": "+show1+" "+show2+" "+show3+" "+show4+" "+show5+" "+show6+" "+show7+" "+show8+" "+show9);
	
		
		data.add(show1);
		data.add(show2);
		data.add(show3);
		data.add(show4);
		data.add(show5);
		data.add(show6);
		data.add(show7);
		data.add(show8);
		data.add(show9);
		
		return data;
		
	}
}
