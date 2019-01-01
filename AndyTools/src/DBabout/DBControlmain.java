package DBabout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBControlmain {

	static String file = "C:\\北科\\峰哥\\翡翠水庫測試\\測試資料庫output.txt";
	
	public static void main(String[] args) throws ClassNotFoundException{
		String driver = "com.mysql.jdbc.Driver";
		//localhost指本機，也可以用本地ip地址代替，3306為MySQL資料庫的預設埠號，“user”為要連線的資料庫名
		String url = "jdbc:mysql://140.124.60.169:3306/cwb_ac";
		//填入資料庫的使用者名稱跟密碼
		String username = "root";
		String password = "hk4xu;6g4";
		String sql = "SELECT * FROM cwb_ac.WaterLevel_10M_WRA_2016 ;";//編寫要執行的sql語句，此處為從user表中查詢所有使用者的資訊
		
		
		List<String> data = new ArrayList<>();
		
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);//DriverManager.getConnection(url,username,password);//建立連線物件
			Statement st = con.createStatement();//建立sql執行物件
			ResultSet rs = st.executeQuery(sql);//執行sql語句並返回結果集
			
			while(rs.next())/*對結果集進行遍歷輸出*/{
				if(rs.getString(2).equals("1660H009")) {
					System.out.println("time: "+ rs.getString(1)+"  station: " + rs.getString(2)+ " value: " + rs.getString(3));//通過列的標號來獲得資料
					data.add(rs.getString(1));
					data.add(rs.getString(2));
					data.add(rs.getString(3));
					writeText wt = new writeText();
					wt.appendWriteAndSambal(file, rs.getString(1),4);
					wt.appendWriteAndSambal(file, rs.getString(2),4);
					wt.appendWriteAndSambal(file, rs.getString(3),5);
				}
			}
			//關閉相關的物件
			if(rs != null)
			{
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(st != null){
				try{
					st.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(con !=null){
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
//		for(String show : data) {
//			System.out.println(show);
//		}
	}
}
