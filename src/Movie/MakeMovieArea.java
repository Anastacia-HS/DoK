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
	String[] hall1_time = {"8��", "11��", "13��", "15�� 30�� ", "17��", "20�� ", "22�� 20��"};
	String[] hall2_time = {"9��", "11��", "1��3 40��" ,"16��" ,"18�� 15�� ", "15�� ", "23�� "};
	String[] hall3_time = {"7��", "9�� 50�� ", "11�� 20�� " ,"14�� " ,"16�� 10�� " ,"18�� 30��", "20�� ", "22�� 30��"};
	String[] hall4_time = {"7�� 40��", "9�� ", "12�� ", "13�� 50�� ", "15�� 45�� ", "18�� ", "20�� 10��"};
	String[] hall5_time = {"9�� 30��", "12�� ", "14��10�� ", "17�� 5�� ", "19�� 10�� ", "21�� ", "23�� 40��"};
	
	int random;
	
	public MakeMovieArea() {
		DB_MovieInfo connection1 = new DB_MovieInfo();
		DB_MovieArea connection2 = new DB_MovieArea();
		movie = connection1.getMovieInfoAll("rating");
		
		for(int i=0; i<1; i++) {
			random = (int)(Math.random()*70);
			System.out.println(connection2.MakeMovie_Area_songpagoo(movie[random].getM_name(), "1��", hall1_time[i], "2020-12-01"));
			//System.out.println(movie[random].getM_name());
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MakeMovieArea();
	}

}
