package DBabout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBControlmain {

	static String file = "C:\\�_��\\�p��\\�B�A���w����\\���ո�Ʈwoutput.txt";
	
	public static void main(String[] args) throws ClassNotFoundException{
		String driver = "com.mysql.jdbc.Driver";
		//localhost�������A�]�i�H�Υ��aip�a�}�N���A3306��MySQL��Ʈw���w�]�𸹡A��user�����n�s�u����Ʈw�W
		String url = "jdbc:mysql://140.124.60.169:3306/cwb_ac";
		//��J��Ʈw���ϥΪ̦W�ٸ�K�X
		String username = "root";
		String password = "hk4xu;6g4";
		String sql = "SELECT * FROM cwb_ac.WaterLevel_10M_WRA_2016 ;";//�s�g�n���檺sql�y�y�A���B���quser���d�ߩҦ��ϥΪ̪���T
		
		
		List<String> data = new ArrayList<>();
		
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);//DriverManager.getConnection(url,username,password);//�إ߳s�u����
			Statement st = con.createStatement();//�إ�sql���檫��
			ResultSet rs = st.executeQuery(sql);//����sql�y�y�ê�^���G��
			
			while(rs.next())/*�ﵲ�G���i��M����X*/{
				if(rs.getString(2).equals("1660H009")) {
					System.out.println("time: "+ rs.getString(1)+"  station: " + rs.getString(2)+ " value: " + rs.getString(3));//�q�L�C���и�����o���
					data.add(rs.getString(1));
					data.add(rs.getString(2));
					data.add(rs.getString(3));
					writeText wt = new writeText();
					wt.appendWriteAndSambal(file, rs.getString(1),4);
					wt.appendWriteAndSambal(file, rs.getString(2),4);
					wt.appendWriteAndSambal(file, rs.getString(3),5);
				}
			}
			//��������������
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
