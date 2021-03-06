package Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_MovieInfo {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private final static int DATA_NUM = 70;
	private Movie[] movies = new Movie[DATA_NUM];
	
	
	public DB_MovieInfo() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/movieInfo_DOK?serverTimezone=Asia/Seoul","root","mirim2");
			st = con.createStatement();
		}catch (Exception e) {
			System.out.println("데이터 베이스 연결 오류:"+e.getMessage());
		}
	}

	
	public Movie[] getMovieInfoAll(String calumn) {
		
		try {
			String SQL = "select* from movie order by "+calumn+" desc";
			
			rs = st.executeQuery(SQL);
			int n=0;
			while(rs.next()) {
				/*
				 * System.out.println(rs.getString("m_name"));
				 * System.out.println(rs.getString("genre"));
				 * System.out.println(rs.getString("open_day"));
				 * System.out.println(rs.getInt("audience"));
				 * System.out.println(rs.getDouble("rating"));
				 */
				
				movies[n] = new Movie();
				movies[n].setM_name(rs.getString("m_name"));
				movies[n].setGenre(rs.getString("genre"));
				movies[n].setOpen_day(rs.getString("open_day"));
				movies[n].setAudience(rs.getInt("audience"));
				movies[n].setRating(rs.getDouble("rating"));
				
				n++;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DBMovieInfo데이터베이스 검색 오류:"+ e.getLocalizedMessage());
		}
		return movies;
	}
public Movie[] getMovieInfo(String genr,String calum) {
		
		try {
			String SQL = "select* from movie where genre like '"+genr +"' order by "+ calum+" desc";
		
			rs = st.executeQuery(SQL);
			int n=0;
			while(rs.next() ) {
				/*
				 * System.out.println(rs.getString("m_name"));
				 * System.out.println(rs.getString("genre"));
				 * System.out.println(rs.getString("open_day"));
				 * System.out.println(rs.getInt("audience"));
				 * System.out.println(rs.getDouble("rating"));
				 */
				
				movies[n] = new Movie();
				movies[n].setM_name(rs.getString("m_name"));
				movies[n].setGenre(rs.getString("genre"));
				movies[n].setOpen_day(rs.getString("open_day"));
				movies[n].setAudience(rs.getInt("audience"));
				movies[n].setRating(rs.getDouble("rating"));
				
				n++;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DBMovieInfo데이터베이스 검색 오류:"+ e.getLocalizedMessage());
		}
		return movies;
	} 
}
