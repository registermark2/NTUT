
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeText wt = new writeText();
		String text ="234";
		String filename ="C:\\北科\\峰哥\\翡翠水庫測試\\測試資料庫output.txt";
		String format ="UTF-8";
		
		wt.writeText(text, filename, format, false);
	}

}
