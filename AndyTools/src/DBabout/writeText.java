package DBabout;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class writeText {
	public static void appendWriteAndSambal(String file, String content, int num) {
		BufferedWriter out = null;
		String sambal ="";
		try {
			switch (num) {
				case 1:
					sambal = "\r\n";
					break;
				case 2:
					sambal = "\t";
					break;
				case 3:
					sambal = "\\n";
					break;
				case 4:
					sambal = ",";
					break;
				case 5:
					sambal = ",\r";
					break;
			}
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			out.write(content + sambal);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
