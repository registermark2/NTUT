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
			String filename = "C:\\�_��\\�p��\\�B�A���w����\\���ո�Ʈwoutput.txt";
			String format ="UTF-8";
			
			ArrayList<String> store_Mysql_data = new ArrayList();
			//localhost�������A�]�i�H�Υ��aip�a�}�N���A3306��MySQL��Ʈw���w�]�𸹡A��user�����n�s�u����Ʈw�W
			String url = "jdbc:mysql://140.124.60.169:3306/cwb_ac";
			//��J��Ʈw���ϥΪ̦W�ٸ�K�X
			
			String username = "root";
			String password = "hk4xu;6g4";
//			String sql = "select * from cwb_ac.RaderRCLY_10M_CWB_"+years+" where recdate between '"+years+"-01-01 00:00:00' and '"+years+"-10-16 23:50:00';";//�s�g�n���檺sql�y�y�A���B���quser�����d�ߩҦ��ϥΪ̪���T
			String sql ="SELECT * FROM cwb_ac.QpesumsObs_10M_CWB_2018;";
			try{
				Class.forName(driver);//���J�X�ʵ{���A���B�B���������U�X�ʵ{������k
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			try{
				Connection con = DriverManager.getConnection(url,username,password);//�إ߳s�u����
				Statement st = con.createStatement();//�إ�sql���檫��
				ResultSet rs = st.executeQuery(sql);//����sql�y�y�ê�^���G��
				
				while(rs.next()) {//�ﵲ�G���i��M����X
//					System.out.println("username: "+rs.getString(1));//�q�L�C���и�����o���
					store_Mysql_data.add(rs.getString("recdate"));
					System.out.println("recdate: "+rs.getString("recdate"));//�q�L�C�W����o���
//					System.out.println("userage: "+rs.getInt("userage"));
					writeText wt = new writeText();
					wt.writeText(rs.getString("recdate"), filename, format, false);
				}
				//��������������
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