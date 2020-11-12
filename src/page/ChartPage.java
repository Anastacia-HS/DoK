package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import Movie.DB_MovieInfo;
import Movie.Movie;
import User.User;


public class ChartPage extends CategoryFrame {
	
	//pos
	private final static int Padding_Left = 130;
	private final static int Padding_Top = 50;
	private final static int right_Padding_Left = 25;
	private final static int right_Padding_Top = 30;
	private final static double Panel_Height = Main.SCREEN_HEIGHT * 1.4 ;
	
	// size
	private Dimension size = new Dimension();// ����� �����ϱ� ���� ��ü ����
	
	//��ü
	private DB_MovieInfo moive_connect = new DB_MovieInfo();
	private Movie[] movies;

	
	//component
	private JPanel jpanel = new JPanel();
	private JPanel selectPanel = new JPanel();
	private JLabel jlgenre = new JLabel("�帣");
	private String[] string_genre = {"��ü", "����", "���", "�θǽ�", "������", "�ִϸ��̼�", "�׼�", "SF"};
	//private JComboBox comboBox = new JComboBox(string_genre);
	private JButton btn_rating = new JButton("����");
	private JButton btn_audience = new JButton("���� ��");
	private JButton btn_openday = new JButton("���� ��¥");
	private JButton btn_ganada = new JButton("������ ��");
	private JLabel[][] jlposter = new JLabel[2][4];
	private JLabel[][] jlmovie_info = new JLabel[2][4];
	private JLabel[] jlrank = new JLabel[8];
	private JLabel[] jlopen_day = new JLabel[8];
	private JLabel[] jlRaing = new JLabel[8];
	private JLabel[] jlrank_name = new JLabel[8];
	private ImageIcon imgPoster = new ImageIcon();
	
	private ButtonGroup g = new ButtonGroup();
	private JRadioButton[] radioGenre = new JRadioButton[8];
	
	
	
	ChartEvent listener = new ChartEvent();
	
	//Design
	Font m_name_font = new Font("�����ٸ����", Font.PLAIN, 25);
	Font m_rank_font = new Font("�����ٸ����", Font.BOLD, 20);
	Font option_font = new Font("�����ٸ����", Font.PLAIN, 15);
	Font fontMain = new Font("�޸յձ�������", Font.PLAIN, 25);
	Font fontContent = new Font("�޸յձ�������", Font.PLAIN, 17);
	
	public ChartPage() {
		
	}
	
	public ChartPage(User user) {
		super("��ȭ ��Ʈ");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//���̾ƿ� null
		setVisible(true);
		
		//��ȭ DB����
		this.movies = moive_connect.getMovieInfoAll("rating");
		this.user = user;
		
		
		//�帣
		jlgenre.setBounds(right_Padding_Left, right_Padding_Top, 75, 40);
		jlgenre.setFont(fontMain); jlgenre.setHorizontalAlignment(JLabel.CENTER);
		selectPanel.add(jlgenre);
		
		for(int i = 0; i < string_genre.length; i++) {
			radioGenre[i] = new JRadioButton(string_genre[i]);
			radioGenre[i].setBounds(right_Padding_Left + 25, right_Padding_Top + 50 + (i * 35), 100, 30);
			radioGenre[i].setOpaque(true);
			radioGenre[i].setBackground(Color.WHITE);
			radioGenre[i].setFont(option_font);
			g.add(radioGenre[i]);
			selectPanel.add(radioGenre[i]);
		}
		 
		
		//����
		btn_rating.setBounds(right_Padding_Left, right_Padding_Top + 375, 150, 40);
		btn_rating.setBackground(Color.WHITE);
		btn_rating.setFont(fontMain);
		btn_rating.setHorizontalAlignment(JButton.LEFT);
		btn_rating.setFocusPainted(false);
		btn_rating.setBorderPainted(false);
		btn_rating.addActionListener(new ChartEvent());
		selectPanel.add(btn_rating);
		
		//���� ��
		btn_audience.setBounds(right_Padding_Left, right_Padding_Top + 440, 150, 40);
		btn_audience.setBackground(Color.WHITE);
		btn_audience.setFont(fontMain);
		btn_audience.setHorizontalAlignment(JButton.LEFT);
		btn_audience.setFocusPainted(false);
		btn_audience.setBorderPainted(false);
		btn_audience.addActionListener(new ChartEvent());
		selectPanel.add(btn_audience);
		
		//������¥
		btn_openday.setBounds(right_Padding_Left, right_Padding_Top + 505, 150, 40);
		btn_openday.setBackground(Color.WHITE);
		btn_openday.setFont(fontMain);
		btn_openday.setHorizontalAlignment(JButton.LEFT);
		btn_openday.setFocusPainted(false);
		btn_openday.setBorderPainted(false);
		btn_openday.addActionListener(new ChartEvent());
		selectPanel.add(btn_openday);
	
		//������
		btn_ganada.setBounds(right_Padding_Left, right_Padding_Top + 570, 150, 40);
		btn_ganada.setBackground(Color.WHITE);
		btn_ganada.setFont(fontMain);
		btn_ganada.setHorizontalAlignment(JButton.LEFT);
		btn_ganada.setFocusPainted(false);
		btn_ganada.setBorderPainted(false);
		btn_ganada.addActionListener(new ChartEvent());
		selectPanel.add(btn_ganada);
		
		//1~8 ���� 
		for(int i = 0; i < jlrank.length; i++) {
			jlrank[i] = new JLabel((i + 1) + "");
			
			if(i < 4) {
				jlrank[i].setBounds(Padding_Left - 10 + (i * 260), Padding_Top, 40, 40);
				
			}else {
				jlrank[i].setBounds(Padding_Left -10 +((i-(jlrank.length/2)) * 260), Padding_Top+500, 40, 40);
			}
			jlrank[i].setOpaque(true);
			jlrank[i].setBackground(Color.PINK);
			jlrank[i].setFont(m_rank_font);
			jlrank[i].setHorizontalAlignment(JLabel.CENTER);
			jpanel.add(jlrank[i]);
		}
		
		int n=0;
		
		//��ȭ ��Ʈ��
		for(int i = 0; i < jlposter.length; i++) {
			for(int j = 0; j < jlposter[i].length; j++) {
				String src = "src/imges/"+movies[n].getM_name()+".jpg";
				//String src = "src/imges/�ܿ� �ձ�.jpg";
				imgPoster = new ImageIcon(src);
				jlposter[i][j] = new JLabel(imgPoster);
				jlposter[i][j].setBounds(Padding_Left - 10 + (j * 260), Padding_Top + (i * 500), 230, 330);
				jlposter[i][j].setOpaque(true);
				jlposter[i][j].setBackground(Color.GRAY);
				jlposter[i][j].addMouseListener(listener);
				jpanel.add(jlposter[i][j]);
				n++;
			}
		}
		
		//��ȭ ���� ���(���콺 �÷�����)
		
		  for(int i = 0; i < jlmovie_info.length; i++) {
			  for(int j = 0; j <jlmovie_info[i].length; j++) {
				  jlmovie_info[i][j] = new JLabel();
				  jlmovie_info[i][j].setBounds(Padding_Left - 10 + (j * 260), Padding_Top + (i * 500), 230, 330); 
				  jlmovie_info[i][j].setOpaque(true);
				  jlmovie_info[i][j].setBackground(Color.RED);
				  jlmovie_info[i][j].addMouseListener(listener);
				  jpanel.add(jlmovie_info[i][j]); 
			  }
		 }
		 
		
		//��ȭ �̸�,������
		for(int i = 0; i < jlrank_name.length; i++) {
			jlrank_name[i] = new JLabel();
			jlRaing[i] = new JLabel();
			jlopen_day[i] = new JLabel();
			if(i < 4) {
				jlrank_name[i].setBounds(5+Padding_Left - 10 + (i * 260), Padding_Top+330, 225, 40);
				jlRaing[i].setBounds(5+Padding_Left - 10 + (i * 260), Padding_Top+370, 60, 40);
				jlopen_day[i].setBounds(65+Padding_Left - 10 + (i * 260), Padding_Top+370, 160, 40);
			}else {
				jlrank_name[i].setBounds(10+Padding_Left -10 +((i-(jlrank.length/2)) * 260), Padding_Top+500+330 ,225, 40);
				jlRaing[i].setBounds(10+Padding_Left -10 +((i-(jlrank.length/2)) * 260), Padding_Top+500+370, 60, 40);
				jlopen_day[i].setBounds(70+Padding_Left -10 +((i-(jlrank.length/2)) * 260), Padding_Top+500+370, 160, 40);
			}
			//�̸�
			jlrank_name[i].setText(movies[i].getM_name());
			jlrank_name[i].setFont(m_name_font);
			//jlrank_name[i].setOpaque(true);
			//jlrank_name[i].setBackground(Color.YELLOW);
			jpanel.add(jlrank_name[i]);
			//����
			jlRaing[i].setText("����"+movies[i].getRating());
			jlRaing[i].setFont(option_font);
			//jlRaing[i].setOpaque(true);
			//jlRaing[i].setBackground(Color.GREEN);
			jpanel.add(jlRaing[i]);
			//������
			jlopen_day[i].setText("  ������"+movies[i].getOpen_day());
			jlopen_day[i].setFont(option_font);
			//jlopen_day[i].setOpaque(true);
			//jlopen_day[i].setBackground(Color.RED);
			jpanel.add(jlopen_day[i]);
			
		}
		
		//Panel_movie
		size.setSize(Main.SCREEN_WIDTH, Panel_Height);
		jpanel.setBackground(Color.WHITE);
		jpanel.setPreferredSize(size);
		jpanel.setLayout(null);
		
		//panel_select
		selectPanel.setBounds((int)(Main.SCREEN_WIDTH*0.8), (int) (Main.SCREEN_HEIGHT*0.25), (int)(Main.SCREEN_WIDTH*0.2), Main.SCREEN_HEIGHT);
		selectPanel.setBackground(Color.WHITE);
		selectPanel.setLayout(null);
		add(selectPanel);
		
		JScrollPane sp = new JScrollPane(jpanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(0, (int) (Main.SCREEN_HEIGHT*0.25), (int)(Main.SCREEN_WIDTH*0.8), Main.SCREEN_HEIGHT);
		add(sp);
		
		
	}
	//��Ʈ �׼� �̺�Ʈ
	class ChartEvent implements ActionListener, MouseListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String calumn = null;
			
			/*+for(int i = 1; i < string_genre.length; i++) {
				System.out.println(comboBox.getSelectedIndex());
				if(comboBox.getSelectedIndex() == i) {
					System.out.println("���� zd");
					calumn = "rating";
				}
			}*/
			
			if(e.getSource() == btn_rating) {
				calumn = "rating";
			}else if(e.getSource()==btn_audience) {
				calumn = "audience";
			}else if(e.getSource()==btn_openday) {
				calumn = "open_day";
			}else if(e.getSource()==btn_ganada) {
				calumn ="m_name";
			}
			
			
			
			/*if(radioGenre.getSelectedIndex() == 0) {//all
				movies = moive_connect.getMovieInfoAll(calumn);
			}else {
				for(int i=1; i<string_genre.length; i++) {//������
					if(radioGenre.getSelectedIndex() == i)
						movies = moive_connect.getMovieInfo(string_genre[i],calumn);
				}
			}*/
			
			
			//label �̸� set
			for(int i=0; i<jlrank_name.length; i++) {
				jlrank_name[i].setText(movies[i].getM_name());
			}
			//poster �̹��� set
			int n=0;
			for(int i=0; i<jlposter.length; i++) {
				for(int j=0; j<jlposter[i].length; j++) {
					String src = "src/imges/"+movies[n].getM_name()+".jpg";
					//String src = "src/imges/�ܿ� �ձ�.jpg";
					imgPoster = new ImageIcon(src);
					jlposter[i][j].setIcon(imgPoster);
					n++;
				}
			}
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
		}
		
		
		//���콺�� ��� �ö���� ��
		@Override
		public void mouseEntered(MouseEvent e) {
			//JLabel l = (JLabel)e.getSource();

			for(int i = 0; i < jlposter.length; i++) {
				for(int j = 0; j < jlposter[i].length; j++) {
					if(e.getSource() == jlposter[i][j]) {
						//movie_info[i][j].setVisible(true);
						jlposter[i][j].setVisible(false);
					}
				}
			}
		}
		
		//���콺�� ��� �������� ��
		@Override
		public void mouseExited(MouseEvent e) {
			//JLabel l = (JLabel)e.getSource();
			
			for(int i = 0; i < jlposter.length; i++) {
				for(int j = 0; j < jlposter[i].length; j++) {
					if(e.getSource() == jlposter[i][j]) {
						//movie_info[i][j].setVisible(false);
						jlposter[i][j].setVisible(true);
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