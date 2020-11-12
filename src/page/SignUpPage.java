package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import User.DB_userInfo;

public class SignUpPage extends JFrame {

	// DB
	DB_userInfo conection = new DB_userInfo();

	// size
	private Dimension size = new Dimension();// ����� �����ϱ� ���� ��ü ����
	
	// ��ġ
	private final static int C_X = Main.SCREEN_WIDTH / 2 - 250;
	private final static int ID_Y = 150;
	private final static int PW_Y = ID_Y+150;
	private final static int PWCheck_Y = PW_Y+150;
	private final static int Name_Y = PWCheck_Y+150;
	private final static int Birth_Y = Name_Y+150;
	private final static int Gender_Y = Birth_Y+150;
	private final static int Phone_Y = Gender_Y+150;
	private final static int Taste_Y = Phone_Y+150;
	// private final static int TasteCB_Y = 1300;
	private final static int SignUP_Y = 1850;
	private final static int TopMargin_Y = 80;
	private final static int Taste_N = 6;
	private final static int PanelHeight = Main.SCREEN_HEIGHT * 2 ;

	// component
	private JScrollPane scroll;
	private JPanel panel = new JPanel();
	private ImageIcon imgLogo = new ImageIcon("src/imges/dok.png"); // �ΰ� �̹���
	private JLabel logo = new JLabel();
	private JLabel id = new JLabel("���̵�*");
	private JLabel password = new JLabel("��й�ȣ*");
	private JLabel password_check = new JLabel("��й�ȣ ��Ȯ��*");
	private JLabel name = new JLabel("�̸�*");
	private JLabel birthday = new JLabel("�������(8�ڸ�)�� �Է����ּ���*");
	private JLabel gender = new JLabel("������ �Է����ּ���*");
	private JLabel phone = new JLabel("��ȭ��ȣ�� �Է����ּ���*");
	private JLabel jlTaste = new JLabel("������ �������ּ���(�ִ�2��)");
	//private String[] hint = {"�̸�","�������(8�ڸ�)"};
	private JTextField input_id = new JTextField();
	private JPasswordField input_password = new JPasswordField();
	private JPasswordField input_passwordCheck = new JPasswordField();
	private JTextField input_name = new JTextField();
	private JTextField input_birtyday = new JTextField();
	private ButtonGroup input_gender = new ButtonGroup();
	private JRadioButton woman = new JRadioButton("����");
	private JRadioButton man = new JRadioButton("����");
	private JTextField input_phone = new JTextField();
	private JCheckBox[] checkbox_taste = new JCheckBox[Taste_N];
	private JButtonT btn_signUp = new JButtonT();

	
	//����
	private String[] string_taste = new String[] { "�׼�", "�θǽ�", "����", "��Ÿ��", "SF-�������", "������" };
	private int n = 0;
	private String userID, userPassword, userPasswordCheck, userName,useryymmdd,userGender, userPhone,userTaste1, userTaste2;


	// font
	private Font font1 = new Font(null, Font.BOLD, 20);
	private Font font2 = new Font(null, Font.PLAIN, 20);

	public SignUpPage() {

		super("ȸ������");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		getContentPane().setLayout(null); // ���̾ƿ� null
		setVisible(true);

		// Panel ����� ����
		size.setSize(Main.SCREEN_WIDTH, PanelHeight);

		// �г�
		// jp.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT*2);
		panel.setLayout(null);
		panel.setPreferredSize(size);
		panel.setBackground(Color.WHITE);

		// ��ũ�� �г�
		JScrollPane scrollPanel = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		add(scrollPanel);

		// �ΰ�
		logo.setIcon(imgLogo);
		logo.setBounds(Main.SCREEN_WIDTH / 2 - 100, 30, 200, 100);
		panel.add(logo);

		// ���̵� label
		id.setBounds(C_X, ID_Y, 200, 100);
		id.setFont(font1);
		panel.add(id);

		// ���̵� textField
		input_id.setBounds(C_X, ID_Y + TopMargin_Y, 500, 50);
		input_id.setFont(font2);
		panel.add(input_id);

		// ��й�ȣ label
		password.setBounds(C_X, PW_Y, 200, 100);
		password.setFont(font1);
		panel.add(password);

		// ��й�ȣ textField
		input_password.setBounds(C_X, PW_Y + TopMargin_Y, 500, 50);
		input_password.setFont(font2);
		panel.add(input_password);

		// ��й�ȣ ��Ȯ�� label
		password_check.setBounds(C_X, PWCheck_Y, 200, 100);
		password_check.setFont(font1);
		panel.add(password_check);

		// ��й�ȣ ��Ȯ�� textField
		input_passwordCheck.setBounds(C_X, PWCheck_Y + TopMargin_Y, 500, 50);
		input_passwordCheck.setFont(font2);
		panel.add(input_passwordCheck);

		// �̸� label
		name.setBounds(C_X, Name_Y, 200, 100);
		name.setFont(font1);
		panel.add(name);

		// �̸� textField
		input_name.setBounds(C_X, Name_Y + TopMargin_Y, 500, 50);
		input_name.setFont(font2);
		panel.add(input_name);

		// ������� label
		birthday.setBounds(C_X, Birth_Y, 500, 100);
		birthday.setFont(font1);
		panel.add(birthday);

		// ������� textField
		input_birtyday.setBounds(C_X, Birth_Y + TopMargin_Y, 500, 50);
		input_birtyday.setFont(font2);
		panel.add(input_birtyday);
		
		
		//���� label
		gender.setBounds(C_X, Gender_Y,300,100);
		gender.setFont(font1);
		panel.add(gender);
		
		//����m radio
		man.setBounds(C_X,Gender_Y+TopMargin_Y,100,50);
		man.setFont(font2);
		man.addItemListener(new RadioButtonEvent());
		input_gender.add(man);
		panel.add(man);
		
		//����w radio
		woman.setBounds(C_X+110,Gender_Y+TopMargin_Y,100,50);
		woman.setFont(font2);
		woman.addItemListener(new RadioButtonEvent());
		input_gender.add(woman);
		panel.add(woman);

		// ��ȭ��ȣ label
		phone.setBounds(C_X, Phone_Y, 300, 100);
		phone.setFont(font1);
		panel.add(phone);

		// ��ȭ��ȣ textField
		input_phone.setBounds(C_X, Phone_Y + TopMargin_Y, 500, 50);
		input_phone.setFont(font2);
		panel.add(input_phone);

		// ���� label
		jlTaste.setBounds(C_X, Taste_Y, 300, 100);
		jlTaste.setFont(font1);
		panel.add(jlTaste);

		// ���� checkbox
		for (int i = 0; i < Taste_N; i++) {
			checkbox_taste[i] = new JCheckBox();
			checkbox_taste[i].setText(string_taste[i]);
			checkbox_taste[i].setFont(font2);
			checkbox_taste[i].setFocusPainted(false);
			// setBorderPainted(false);
			checkbox_taste[i].setBackground(Color.PINK);
			checkbox_taste[i].setBounds(C_X, Taste_Y + (TopMargin_Y) * (i + 1), 150, 50);
			panel.add(checkbox_taste[i]);
			checkbox_taste[i].addItemListener(new CheckBoxEvent());
		}

		// ȸ������
		btn_signUp.setText("ȸ������");
		btn_signUp.setFont(font1);
		btn_signUp.setBounds(C_X, SignUP_Y, 500, 100);
		panel.add(btn_signUp);

		// ȸ������ ������
		btn_signUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				userID = input_id.getText();
				userPassword = input_password.getText();
				userPasswordCheck = input_passwordCheck.getText();
				userName = input_name.getText();
				useryymmdd = input_birtyday.getText();
				userPhone = input_phone.getText();
				
				
				JOptionPane message =new JOptionPane();//�޽��� �ڽ� ��ü
				
				//�����Ͱ� ����ִ��� Ȯ��
				if(userID.isEmpty() || userPassword.isEmpty() || userPasswordCheck.isEmpty()|| userName.isEmpty() || useryymmdd.isEmpty()
						|| userGender.isEmpty() || userPhone.isEmpty()) {
					message.showMessageDialog(null, "�Էµ��� ���� ������ �ֽ��ϴ�.");			
				}else {//��� �����Ͱ� �ԷµǾ����� ����
					if(!(userPassword.equals(userPasswordCheck))) {
						message.showMessageDialog(null,"��й�ȣ�� ��ġ ���� �ʽ��ϴ�." );
					}else {
						boolean success = conection.addUser(userID, userPassword, userName, useryymmdd, userGender,userPhone, userTaste1, userTaste2);
						if(success) {
							message.showMessageDialog(null,"ȸ�����Կ� �����߽��ϴ�!" );
							new LoginPage();
							dispose();
						}else {
							message.showMessageDialog(null,"��ġ�ϴ� ���̵� �ֽ��ϴ�." );
						}
						//System.out.println(coneection.addUser(userID, userPassword, userName, useryymmdd, userGender,userPhone, userTaste1, userTaste2));
					}
				}
				//
				
			}
		});

	}
	

	//������ư ������
	class RadioButtonEvent implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(man.isSelected()) {
				userGender = "����";
			}else {
				userGender = "����";
			}
		}
	
	}
	
	// üũ�ڽ� ������
	class CheckBoxEvent implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				n -= 1;
			} else {
				if (n < 2) {
					if (n == 0) {
						for (int i = 0; i < Taste_N; i++) {
							if (e.getItem() == checkbox_taste[i]) {
								userTaste1 = string_taste[i];
							}
						}
					} else {
						for (int i = 0; i < Taste_N; i++) {
							if (e.getItem() == checkbox_taste[i]) {
								userTaste2 = string_taste[i];
							}
						}
					}
					n += 1;
				} else {
					for (int i = 0; i < Taste_N; i++) {
						if (e.getItem() == checkbox_taste[i]) {
							checkbox_taste[i].setSelected(false);
						}
					}
					n = 2;
				}
			}
		}

	}
}
