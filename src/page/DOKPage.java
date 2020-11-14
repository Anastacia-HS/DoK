package page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import User.User;

public class DOKPage extends CategoryFrame {
	
	
	//pos
	private final static int movieN = 4;
	
	//component
	private JPanel panel = new JPanel();
	private JLabel boxoffice = new JLabel();
	private JButton btn_plusMovie = new JButton();
	private JButton[] btn_Movies = new JButton[movieN];
	private ImageIcon[] img_logo = new ImageIcon[movieN];
	private JLabel[] movieName = new JLabel[4];
	
	private ImageIcon imgMore = new ImageIcon("src/imges/more.png");
	private ImageIcon imgBoxoffice = new ImageIcon("src/imges/boxoffice.png");
	
	//Design
	Font font1 = new Font("나눔바른고딕", Font.PLAIN, 20); 
	Font font2 = new Font("휴먼둥근헤드라인", Font.PLAIN, 35);
	Font font3 = new Font("휴먼둥근헤드라인", Font.PLAIN, 20);
	
	public DOKPage(User user) {
		super("DOK");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);//레이아웃 null
		setVisible(true);
		
	
		
		this.user = user;
		
		
		//Panel
		panel.setBackground(Color.WHITE);
		panel.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		panel.setLayout(null);
		add(panel);
		
		//박스 오피스 Label
		boxoffice.setBounds(200,80,200,50);
		boxoffice.setIcon(imgBoxoffice);
		boxoffice.setOpaque(false);
		panel.add(boxoffice);
		
		//더 많은 영화 보기 Lable
		btn_plusMovie.setIcon(imgMore);
		btn_plusMovie.setBorderPainted(false);
		btn_plusMovie.setOpaque(true);
		btn_plusMovie.setBackground(Color.WHITE);
		btn_plusMovie.setBounds(Main.SCREEN_WIDTH-350,120,200,50);
		panel.add(btn_plusMovie);
		
		
		//영화 차트 버튼
		for(int i=0; i<movieN; i++) {
			int x = 300*(i)+ 180;
			btn_Movies[i] = new JButton();
			btn_Movies[i].setOpaque(true);
			btn_Movies[i].setBackground(Color.BLACK);
			btn_Movies[i].setBounds(x, 200, 250, 400);
			panel.add(btn_Movies[i]);
		}
		
		for(int i = 0; i < movieName.length; i++) {
			int x = 300*(i)+ 180;
			movieName[i] = new JLabel("어쩌구 저쩌구");
			movieName[i].setBounds(x, 615, 250, 30);
			movieName[i].setFont(font3);
			movieName[i].setHorizontalAlignment(JLabel.CENTER);
			panel.add(movieName[i]);
		}
		
	}
}
