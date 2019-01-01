import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Control_main {

	private static final String driver = "com.mysql.cj.jdbc.Driver";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			String username = args[0];//username
//			String password = args[1];//password
//			String sql = args[2];//sql
//			String url = args[3];//url_sql_ip
//			String args5 = args[4];//
			String filename = "C:\\北科\\峰哥\\翡翠水庫測試\\測試資料庫output.txt";
			String format ="UTF-8";
			
			ArrayList<String> store_Mysql_data = new ArrayList();
			//localhost指本機，也可以用本地ip地址代替，3306為MySQL資料庫的預設埠號，“user”為要連線的資料庫名
			String url = "jdbc:mysql://140.124.60.169:3306/cwb_ac";
			//填入資料庫的使用者名稱跟密碼
			
			String username = "root";
			String password = "hk4xu;6g4";
//			String sql = "select * from cwb_ac.RaderRCLY_10M_CWB_"+years+" where recdate between '"+years+"-01-01 00:00:00' and '"+years+"-10-16 23:50:00';";//編寫要執行的sql語句，此處為從user表中查詢所有使用者的資訊
			String sql ="SELECT * FROM cwb_ac.QpesumsObs_10M_CWB_2018;";
			try{
				Class.forName(driver);//載入驅動程式，此處運用隱式註冊驅動程式的方法
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			try{
				Connection con = DriverManager.getConnection(url,username,password);//建立連線物件
				Statement st = con.createStatement();//建立sql執行物件
				ResultSet rs = st.executeQuery(sql);//執行sql語句並返回結果集
				
				while(rs.next()) {//對結果集進行遍歷輸出
//					System.out.println("username: "+rs.getString(1));//通過列的標號來獲得資料
					store_Mysql_data.add(rs.getString("recdate"));
					System.out.println("recdate: "+rs.getString("recdate"));//通過列名來獲得資料
//					System.out.println("userage: "+rs.getInt("userage"));
					writeText wt = new writeText();
					wt.writeText(rs.getString("recdate"), filename, format, false);
				}
				//關閉相關的物件
				if(rs != null){
					try{
						rs.close();
					}
					catch(SQLException e){
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
//			return store_Mysql_data;
		}	
}
