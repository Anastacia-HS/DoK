package page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import User.DB_userInfo;
import User.User;

public class LoginPage extends JFrame{
	//위치 
	private final static int C_X = 90;
	private final static int IDLable_Y = 125;
	private final static int IDTextF_Y = 125;
	private final static int PWLable_Y = 175;
	private final static int PWTextF_Y = 175;
	private final static int LoginBtn_Y = 250;
	
	
	private  User user = new User();
	
	//component
	private JPanel jp = new JPanel();
	private JLabel jlId = new JLabel("ID");
	private JTextField jtId = new JTextField();
	private JLabel jlPw = new JLabel("PassWord");
	private JPasswordField jtPw = new JPasswordField();
	private JButton jbtnLogin = new JButton();
	private JButton jbtnSignUp = new JButton();
	private ImageIcon imgLogin = new ImageIcon("src/imges/login.png");
	private ImageIcon imgSignUp = new ImageIcon("src/imges/signup.png");
	private JLabel jlLogo = new JLabel("DoK");
	
	
	
	private DB_userInfo connection = new DB_userInfo();	//DB연결 클래스
	private String userID,userPassword;
	
	//font
	protected Font Logo = new Font("Franklin Gothic Heavy", Font.PLAIN, 75);
	private Font font1 = new Font("나눔바른고딕", Font.BOLD, 20);
	private Font font2 = new Font("나눔바른고딕", Font.PLAIN, 20);
	
	public LoginPage() {
		super("Login");
		setSize(500, 350);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//레이아웃 null
		setVisible(true);	
		
		//패널
		jp.setBounds(0,0, 500, 350);
		jp.setBackground(Color.WHITE);
		jp.setLayout(null);
		add(jp);
		
		//로고 이미지 label
		/*
		 * jlLogo.setIcon(imgLogo);
		jlLogo.setBounds(300, 125,200,100);
		jp.add(jlLogo);
		*/
		
		jlLogo.setBounds(175, 10, 300, 100);
		jlLogo.setFont(Logo);
		jp.add(jlLogo);
		
		
		//아이디 label
		jlId.setBounds(C_X,IDLable_Y,50,50);
		jlId.setFont(font1);
		jp.add(jlId);
		
		//아이디 textField
		jtId.setBounds(C_X + 50, IDTextF_Y, 300, 40);
		jtId.setFont(font2);
		jp.add(jtId);
		
		//패스워드 label
		jlPw.setBounds(C_X - 55,PWLable_Y,100,50);
		jlPw.setFont(font1);
		jp.add(jlPw);
		
		//패스워드 textField
		jtPw.setBounds(C_X + 50, PWTextF_Y,300,40);
		jtPw.setFont(font2);
		jp.add(jtPw);
		
		//로그인 버튼
		/*jbtnLogin.setText("로그인");
		jbtnLogin.setFont(font1);
		jbtnLogin.setBounds(C_X + 30,LoginBtn_Y,125,40);
		jp.add(jbtnLogin);*/
		jbtnLogin.setIcon(imgLogin);
		jbtnLogin.setBounds(C_X + 15,LoginBtn_Y,125,40);
		jbtnLogin.setBorderPainted(false);
		jp.add(jbtnLogin);
		
		//회원가입 버튼
		/*jbtnSingUp.setText("회원가입");
		jbtnSingUp.setBounds(C_X + 165,LoginBtn_Y,125,40);
		jbtnSingUp.setFont(font1);
		jp.add(jbtnSingUp);*/
		jbtnSignUp.setIcon(imgSignUp);
		jbtnSignUp.setBounds(C_X + 165,LoginBtn_Y,125,40);
		jbtnSignUp.setBorderPainted(false);
		jp.add(jbtnSignUp);
		
		jbtnLogin.addActionListener(new EventHandler());
		jbtnSignUp.addActionListener(new EventHandler());
			
	}
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbtnLogin) {//로그인 버튼
				
				userID = jtId.getText();
				userPassword = jtPw.getText();
				//System.out.println(connection.getUserInfo(userID).getUserID());
				boolean success = connection.isUser(userID, userPassword);
				if(success) {//성공
					user = connection.getUserInfo(userID);
					new DOKPage(user);
					
					setVisible(false);
				}else {
					JOptionPane message =new JOptionPane();//메시지 박스 객체
					message.showMessageDialog(null,"아이디 또는 패스워드가 맞지 않습니다. 확인 후  입력해주세요" );
				}
				
				
			}else if(e.getSource() == jbtnSignUp) {//회원가입 버튼
				new SignUpPage();
				//dispose();
				//setVisible(false);
			}
			
		}
	}
}


