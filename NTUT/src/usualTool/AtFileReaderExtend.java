package usualTool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AtFileReaderExtend extends AtFileReader{
	private List<String> fileContain = new ArrayList<String>();
	private String fileAdd = null;
	private BufferedReader br;
	
	public AtFileReaderExtend(String fileAdd, String encode) throws IOException {
		super(fileAdd, encode);//just at extentd use ,but it no use
		
		this.br = new BufferedReader(new InputStreamReader(new FileInputStream(fileAdd), encode));
		this.fileAdd = fileAdd;
		String tempt;
		while ((tempt = br.readLine()) != null) {
			this.fileContain.add(tempt);
		}
		br.close();
		// TODO Auto-generated constructor stub
	}


	public String[][] getCsv() {
		return this.fileContain.stream().map(e -> e.split("\\s+")).collect(Collectors.toList()).parallelStream()
				.toArray(String[][]::new);
	
	}
	public String[][] getCsvComma() {
		return this.fileContain.stream().map(e -> e.split(",")).collect(Collectors.toList()).parallelStream()
				.toArray(String[][]::new);
	}
	public void getCsvStation() {
		
	}
}
