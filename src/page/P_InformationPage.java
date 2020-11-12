package page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Movie.DB_MovieInfo;
import User.DB_userInfo;
import User.User;

public class P_InformationPage extends JFrame{
	
	//pos
	private final static int PaddingLeft = 50;
	private final static int PaddingTop = 130;
	private final static int USER_WIDTH = 250;
	private final static int USER_Padding = 140;

	
	//font
	private Font font1 = new Font(null,Font.BOLD,15);
	
	//��ü
	private User user;
	
	//component
	private JPanel panel = new JPanel();
	//JLabel profile = new JLabel("������");
	//JLabel name = new JLabel("�̸�");
	//JButton btn_change = new JButton("+");
	JLabel id = new JLabel("���̵�");
	JLabel currnet_password = new JLabel("���� ��й�ȣ");
	JLabel new_password = new JLabel("�ű� ��й�ȣ");
	JLabel birthday = new JLabel("�������");
	JLabel phone = new JLabel("��ȭ��ȣ");
	JLabel taste = new JLabel("��ȭ ����");
	
	JLabel userID = new JLabel();
	JPasswordField input_current_password = new JPasswordField();
	JPasswordField input_new_password = new JPasswordField();
	JLabel userBirthday = new JLabel();
	JTextField input_phone = new JTextField();
	String[] string_taste = {"����", "���", "�θǽ�", "������", "�ִϸ��̼�", "�׼�", "SF"};
	JCheckBox[] checkbox_taste = new JCheckBox[7];
	JButton btn_finish = new JButton("����");
	

	public P_InformationPage(User user) {
		
		this.user = user;
		/*
		 * //������ ���� profile.setBounds(PaddingLeft, PaddingTop, 200, 200);
		 * profile.setOpaque(true); profile.setBackground(Color.RED);
		 * panel.add(profile);
		 * 
		 * //�̸� name.setBounds(PaddingLeft, PaddingTop + 210, 200, 50);
		 * name.setOpaque(true); name.setBackground(Color.GREEN);
		 * name.setText(user.getUserName()); panel.add(name);
		 */
		
		//���̵�
		id.setBounds(PaddingLeft, PaddingTop, 130, 50);
		id.setOpaque(true);
		id.setBackground(Color.CYAN);
		id.setFont(font1);
		panel.add(id);
		
		userID.setBounds(PaddingLeft+USER_Padding, PaddingTop, USER_WIDTH, 50);
		userID.setOpaque(true);
		userID.setBackground(Color.yellow);
		userID.setText(user.getUserID());
		//userID.setFont(font1);
		panel.add(userID);
		
		//current ��й�ȣ
		currnet_password.setBounds(PaddingLeft, PaddingTop+60, 130, 50);
		currnet_password.setOpaque(true);
		currnet_password.setBackground(Color.CYAN);
		panel.add(currnet_password);
		
		input_current_password.setBounds(PaddingLeft+USER_Padding, PaddingTop+60, USER_WIDTH, 50);
		input_current_password.setOpaque(true);
		input_current_password.setBackground(Color.YELLOW);
		panel.add(input_current_password);
		
		//new ��й�ȣ
		new_password.setBounds(PaddingLeft, PaddingTop+120, 130, 50);
		new_password.setOpaque(true);
		new_password.setBackground(Color.CYAN);
		panel.add(new_password);
		
		input_new_password.setBounds(PaddingLeft+USER_Padding, PaddingTop+120, USER_WIDTH, 50);
		input_new_password.setOpaque(true);
		input_new_password.setBackground(Color.YELLOW);
		panel.add(input_new_password);
		
		//������� : yyyy-mm-dd
		birthday.setBounds(PaddingLeft, PaddingTop + 180, 130, 50);
		birthday.setOpaque(true);
		birthday.setBackground(Color.CYAN);
		panel.add(birthday);
		
		userBirthday.setBounds(PaddingLeft+USER_Padding, PaddingTop + 180, USER_WIDTH, 50);
		userBirthday.setOpaque(true);
		userBirthday.setBackground(Color.YELLOW);
		userBirthday.setText(user.getUseryymmdd());
		panel.add(userBirthday);
		
		
		//��ȭ��ȣ
		phone.setBounds(PaddingLeft , PaddingTop + 240, 130, 50);
		phone.setOpaque(true);
		phone.setBackground(Color.CYAN);
		panel.add(phone);
		
		input_phone.setBounds(PaddingLeft+USER_Padding , PaddingTop + 240, USER_WIDTH, 50);
		input_phone.setOpaque(true);
		input_phone.setBackground(Color.YELLOW);
		input_phone.setText(user.getUserPhone());
		panel.add(input_phone);
			
		//��ȭ ����
		taste.setBounds(PaddingLeft, PaddingTop + 300, 130, 50);
		taste.setOpaque(true);
		taste.setBackground(Color.CYAN);
		panel.add(taste);
		
		
		int x = 0;
		int y= PaddingTop+240;
		for(int i = 0; i < checkbox_taste.length; i++) {
			checkbox_taste[i] = new JCheckBox(string_taste[i]);
			if(i%2==0) {
				x = PaddingLeft+USER_Padding;
				y+=60;
			}else {
				x = PaddingLeft+USER_Padding+150;
			}
			checkbox_taste[i].setBounds(x, y , 130, 50);
			checkbox_taste[i].setOpaque(true);
			checkbox_taste[i].setBackground(Color.LIGHT_GRAY);
			panel.add(checkbox_taste[i]);
		}
		
		//����
		btn_finish.setBounds(150, PaddingTop + 575, 300, 50);
		btn_finish.setOpaque(true);
		btn_finish.setBackground(Color.YELLOW);
		btn_finish.addActionListener(new BtnEvent());
		panel.add(btn_finish);
		
		add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		setSize(600, 900);
		setVisible(true);
	}
	class BtnEvent implements ActionListener{
		private String currentPassword = input_current_password.getText();
		private String newPassword = input_new_password.getText();
		private String Phone = input_phone.getText();
		
		//private User user = new User();
		
		DB_userInfo connection = new DB_userInfo();
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = user.getUserID();
			String current_pw = input_current_password.getText(); 
			String new_pw = input_new_password.getText(); 
			String phone = input_phone.getText();
			
			
			// TODO Auto-generated method stub
			if(e.getSource() == btn_finish)
			{
				if(id.isEmpty() && new_pw.isEmpty() && phone.isEmpty()) {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
				}else if(current_pw.equals(user.getUserPassword())){
					JOptionPane.showMessageDialog(null, "���� ��й�ȣ�� ��ġ ���� �ʽ��ϴ�.");
				}
				else {
					connection.updateUserInfo(id,new_pw, phone);
					user = connection.getUserInfo(id);
					dispose();
					new MyPage(user);
				}
					
				
				
			}
		}
		
	}

}
