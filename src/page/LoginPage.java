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
	//��ġ 
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
	
	
	
	private DB_userInfo connection = new DB_userInfo();	//DB���� Ŭ����
	private String userID,userPassword;
	
	//font
	protected Font Logo = new Font("Franklin Gothic Heavy", Font.PLAIN, 75);
	private Font font1 = new Font("�����ٸ����", Font.BOLD, 20);
	private Font font2 = new Font("�����ٸ����", Font.PLAIN, 20);
	
	public LoginPage() {
		super("Login");
		setSize(500, 350);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//���̾ƿ� null
		setVisible(true);	
		
		//�г�
		jp.setBounds(0,0, 500, 350);
		jp.setBackground(Color.WHITE);
		jp.setLayout(null);
		add(jp);
		
		//�ΰ� �̹��� label
		/*
		 * jlLogo.setIcon(imgLogo);
		jlLogo.setBounds(300, 125,200,100);
		jp.add(jlLogo);
		*/
		
		jlLogo.setBounds(175, 10, 300, 100);
		jlLogo.setFont(Logo);
		jp.add(jlLogo);
		
		
		//���̵� label
		jlId.setBounds(C_X,IDLable_Y,50,50);
		jlId.setFont(font1);
		jp.add(jlId);
		
		//���̵� textField
		jtId.setBounds(C_X + 50, IDTextF_Y, 300, 40);
		jtId.setFont(font2);
		jp.add(jtId);
		
		//�н����� label
		jlPw.setBounds(C_X - 55,PWLable_Y,100,50);
		jlPw.setFont(font1);
		jp.add(jlPw);
		
		//�н����� textField
		jtPw.setBounds(C_X + 50, PWTextF_Y,300,40);
		jtPw.setFont(font2);
		jp.add(jtPw);
		
		//�α��� ��ư
		/*jbtnLogin.setText("�α���");
		jbtnLogin.setFont(font1);
		jbtnLogin.setBounds(C_X + 30,LoginBtn_Y,125,40);
		jp.add(jbtnLogin);*/
		jbtnLogin.setIcon(imgLogin);
		jbtnLogin.setBounds(C_X + 15,LoginBtn_Y,125,40);
		jbtnLogin.setBorderPainted(false);
		jp.add(jbtnLogin);
		
		//ȸ������ ��ư
		/*jbtnSingUp.setText("ȸ������");
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
			if(e.getSource()==jbtnLogin) {//�α��� ��ư
				
				userID = jtId.getText();
				userPassword = jtPw.getText();
				//System.out.println(connection.getUserInfo(userID).getUserID());
				boolean success = connection.isUser(userID, userPassword);
				if(success) {//����
					user = connection.getUserInfo(userID);
					new DOKPage(user);
					
					setVisible(false);
				}else {
					JOptionPane message =new JOptionPane();//�޽��� �ڽ� ��ü
					message.showMessageDialog(null,"���̵� �Ǵ� �н����尡 ���� �ʽ��ϴ�. Ȯ�� ��  �Է����ּ���" );
				}
				
				
			}else if(e.getSource() == jbtnSignUp) {//ȸ������ ��ư
				new SignUpPage();
				//dispose();
				//setVisible(false);
			}
			
		}
	}
}


