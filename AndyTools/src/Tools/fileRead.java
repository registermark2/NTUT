package Tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileRead {
	public List<String> fileRead(String path) throws IOException {
		List<String> temp = new ArrayList<>();

		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			while ((line = br.readLine()) != null) {
				String[] arr = line.split("\\s+");
				for (String ss : arr) {
					temp.add(ss);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return temp;
	}
}
