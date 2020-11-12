package Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class MakeMovieArea {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	Movie[] movie = new Movie[70];
	String[] hall1_time = {"8시", "11시", "13시", "15시 30분 ", "17시", "20시 ", "22시 20분"};
	String[] hall2_time = {"9시", "11시", "1시3 40분" ,"16시" ,"18시 15분 ", "15시 ", "23시 "};
	String[] hall3_time = {"7시", "9시 50분 ", "11시 20분 " ,"14시 " ,"16시 10분 " ,"18시 30분", "20시 ", "22시 30분"};
	String[] hall4_time = {"7시 40분", "9시 ", "12시 ", "13시 50분 ", "15시 45분 ", "18시 ", "20시 10분"};
	String[] hall5_time = {"9시 30분", "12시 ", "14시10분 ", "17시 5분 ", "19시 10분 ", "21시 ", "23시 40분"};
	
	int random;
	
	public MakeMovieArea() {
		DB_MovieInfo connection1 = new DB_MovieInfo();
		DB_MovieArea connection2 = new DB_MovieArea();
		movie = connection1.getMovieInfoAll("rating");
		
		for(int i=0; i<1; i++) {
			random = (int)(Math.random()*70);
			System.out.println(connection2.MakeMovie_Area_songpagoo(movie[random].getM_name(), "1관", hall1_time[i], "2020-12-01"));
			//System.out.println(movie[random].getM_name());
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MakeMovieArea();
	}

}
