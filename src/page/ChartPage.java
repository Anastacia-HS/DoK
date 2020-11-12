package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Movie.DB_MovieInfo;
import Movie.Movie;
import User.User;


public class ChartPage extends CategoryFrame {
	
	//pos
	private final static int Padding_Left = 150;
	private final static int Padding_Top = 75;
	private final static double Panel_Height = Main.SCREEN_HEIGHT * 1.4 ;
	
	// size
	private Dimension size = new Dimension();// 사이즈를 지정하기 위한 객체 생성
	
	//객체
	private DB_MovieInfo connection = new DB_MovieInfo();
	private Movie[] movies;

	
	//component
	private JPanel panel = new JPanel();
	private JLabel genre = new JLabel("장르");
	private String[] string_genre = {"전체", "공포", "드라마", "로맨스", "스릴러", "애니메이션", "액션", "SF"};
	private JComboBox comboBox = new JComboBox(string_genre);
	private JButton rating = new JButton("평점");
	private JButton audience = new JButton("관객 수");
	private JButton open_day = new JButton("개봉 날짜");
	private JButton ganada = new JButton("가나다 순");
	private JLabel[][] poster = new JLabel[4][2];
	private JLabel[][] movie_info = new JLabel[4][2];
	private JLabel[] rank = new JLabel[8];
	private JLabel[] rank_name = new JLabel[8];
	
	ChartEvent listener = new ChartEvent();
	
	//Design
	Font m_name_font = new Font("나눔바른고딕", Font.PLAIN, 17);
	Font m_rank_font = new Font("나눔바른고딕", Font.BOLD, 20);
	Font option_font = new Font("나눔바른고딕", Font.PLAIN, 20);
	
	public ChartPage() {
		
	}
	
	public ChartPage(User user) {
		super("영화 차트");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//레이아웃 null
		setVisible(true);
		
		//영화 DB연결
		this.movies = connection.getMovieInfoAll("rating");
		this.user = user;
		
		//장르
		genre.setBounds(Padding_Left, Padding_Top, 75, 40);
		genre.setFont(option_font);
		genre.setHorizontalAlignment(JLabel.CENTER);
		panel.add(genre);
		
		comboBox.setBounds(Padding_Left + 75, Padding_Top, 200, 40);
		comboBox.setFont(m_name_font);
		panel.add(comboBox);
		
		//평점
		rating.setBounds(Padding_Left + 375, Padding_Top, 125, 40);
		rating.setBackground(Color.PINK);
		rating.setFont(option_font);
		rating.setHorizontalAlignment(JButton.CENTER);
		rating.addActionListener(new ChartEvent());
		panel.add(rating);
		
		//관객 수
		audience.setBounds(Padding_Left + 600, Padding_Top, 125, 40);
		audience.setBackground(Color.PINK);
		audience.setFont(option_font);
		audience.setHorizontalAlignment(JButton.CENTER);
		audience.addActionListener(new ChartEvent());
		panel.add(audience);
		
		//개봉날짜
		open_day.setBounds(Padding_Left + 825, Padding_Top, 125, 40);
		open_day.setBackground(Color.PINK);
		open_day.setFont(option_font);
		open_day.setHorizontalAlignment(JButton.CENTER);
		open_day.addActionListener(new ChartEvent());
		panel.add(open_day);
		
		//가나다
		ganada.setBounds(Padding_Left + 1050, Padding_Top, 125, 40);
		ganada.setBackground(Color.PINK);
		ganada.setFont(option_font);
		ganada.setHorizontalAlignment(JButton.CENTER);
		ganada.addActionListener(new ChartEvent());
		panel.add(ganada);
		
		//1~8 순위 
		for(int i = 0; i < rank.length; i++) {
			rank[i] = new JLabel((i + 1) + "");
			
			if(i < 4) {
				rank[i].setBounds(Padding_Left + 185 + (i * 325), Padding_Top + 140, 40, 40);
			}else {
				rank[i].setBounds(-965 + (i * 325), Padding_Top + 640, 40, 40);
			}
			
			
			rank[i].setOpaque(true);
			rank[i].setBackground(Color.PINK);
			rank[i].setFont(m_rank_font);
			rank[i].setHorizontalAlignment(JLabel.CENTER);
			panel.add(rank[i]);
		}
		
		for(int i = 0; i < poster.length; i++) {
			for(int j = 0; j < poster[i].length; j++) {
				poster[i][j] = new JLabel();
				
				poster[i][j].setBounds(Padding_Left - 10 + (i * 325), Padding_Top + 150 + (j * 500), 225, 300);
				poster[i][j].setOpaque(true);
				poster[i][j].setBackground(Color.GRAY);
				
				poster[i][j].addMouseListener(listener);
				panel.add(poster[i][j]);
			}
		}
		
		for(int i = 0; i < movie_info.length; i++) {
			for(int j = 0; j < movie_info[i].length; j++) {
				movie_info[i][j] = new JLabel();
				
				movie_info[i][j].setBounds(Padding_Left - 10 + (i * 325), Padding_Top + 150 + (j * 500), 225, 300);
				movie_info[i][j].setOpaque(true);
				
				movie_info[i][j].setBackground(Color.RED);
				movie_info[i][j].addMouseListener(listener);
				panel.add(movie_info[i][j]);
			}
		}
		
		for(int i = 0; i < rank_name.length; i++) {
			rank_name[i] = new JLabel();
			
			if(i < 4) {
				rank_name[i].setBounds(Padding_Left - 10 + (i * 325), Padding_Top + 465, 225, 40);
			}else {
				rank_name[i].setBounds(-1160 + (i * 325), Padding_Top + 965, 225, 40);
			}
			
			rank_name[i].setText(movies[i].getM_name());
			rank_name[i].setFont(m_name_font);
			rank_name[i].setHorizontalAlignment(JLabel.CENTER);
			panel.add(rank_name[i]);
		}
		
		//Panel
		size.setSize(Main.SCREEN_WIDTH, Panel_Height);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(size);
		panel.setLayout(null);
		
		JScrollPane sp = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(0, (int) (Main.SCREEN_HEIGHT*0.25), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		add(sp);
		
		
	}
	//차트 액션 이벤트
	class ChartEvent implements ActionListener, MouseListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String calumn = null;
			
			/*+for(int i = 1; i < string_genre.length; i++) {
				System.out.println(comboBox.getSelectedIndex());
				if(comboBox.getSelectedIndex() == i) {
					System.out.println("실행 zd");
					calumn = "rating";
				}
			}*/
			
			if(e.getSource() == rating) {
				calumn = "rating";
			}else if(e.getSource()==audience) {
				calumn = "audience";
			}else if(e.getSource()==open_day) {
				calumn = "open_day";
			}else if(e.getSource()==ganada) {
				calumn ="m_name";
			}
			
			
			
			if(comboBox.getSelectedIndex() == 0) {//all
				movies = connection.getMovieInfoAll(calumn);
			}else {
				for(int i=1; i<string_genre.length; i++) {//나머지
					if(comboBox.getSelectedIndex() == i)
						movies = connection.getMovieInfo(string_genre[i],calumn);
				}
			}
			
			
			//label 이름 set
			for(int i=0; i<rank_name.length; i++) {
				rank_name[i].setText(movies[i].getM_name());
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
		}
		
		
		//마우스가 대상에 올라왔을 때
		@Override
		public void mouseEntered(MouseEvent e) {
			//JLabel l = (JLabel)e.getSource();

			for(int i = 0; i < poster.length; i++) {
				for(int j = 0; j < poster[i].length; j++) {
					if(e.getSource() == poster[i][j]) {
						//movie_info[i][j].setVisible(true);
						poster[i][j].setVisible(false);
					}
				}
			}
		}
		
		//마우스가 대상에 나갔왔을 때
		@Override
		public void mouseExited(MouseEvent e) {
			//JLabel l = (JLabel)e.getSource();
			
			for(int i = 0; i < poster.length; i++) {
				for(int j = 0; j < poster[i].length; j++) {
					if(e.getSource() == poster[i][j]) {
						//movie_info[i][j].setVisible(false);
						poster[i][j].setVisible(true);
					}
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}