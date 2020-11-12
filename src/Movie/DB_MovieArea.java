package Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_MovieArea {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private final static int DATA_NUM = 70;
	private Movie[] movies = new Movie[DATA_NUM];
	
	public DB_MovieArea() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/movieArea_DOK?serverTimezone=Asia/Seoul","root","mirim2");
			st = con.createStatement();
		}catch (Exception e) {
			System.out.println("데이터 베이스 연결 오류:"+e.getMessage());
		}
	}
	
	public boolean MakeMovie_Area_songpagoo(String m_name, String m_hall, String m_time, String m_day ) {
		try{
			String SQL = "INSERT INTO songpagoo(m_name,m_hall,m_time,m_day)"
					+"VALUES(\""+m_name+"\",\""+m_hall+"\",\""+m_time+"\",\""+m_day+"\");";
			System.out.println(SQL);
			int success = st.executeUpdate(SQL);
			
			if(success == 1) {
				return true;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean MakeMovie_Area_(String m_name, String m_hall, String m_time, String m_day ) {
		try{
			String SQL = "INSERT INTO songpagoo(m_name,m_hall,m_time,m_day)"
					+"VALUES(\""+m_name+"\",\""+m_hall+"\",\""+m_time+"\",\""+m_day+"\");";
			System.out.println(SQL);
			int success = st.executeUpdate(SQL);
			
			if(success == 1) {
				return true;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}
}
