package page;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import User.User;


public class MyPage extends CategoryFrame{
	
	//pos
	private final static int POS_X_CENTER = Main.SCREEN_WIDTH/2-200;
	private final static int POS_X_LEFT = Main.SCREEN_WIDTH/2-650;
	private final static int POS_X_RIGHT = Main.SCREEN_WIDTH/2-200+400+50;
	private final static int PaddingTop = 100;

	
	//component
	private JLabel a = new JLabel();
	private JLabel b = new JLabel();
	private JLabel c = new JLabel();
	
	private JPanel panel = new JPanel();
	private JLabel profile_img = new JLabel("����");
	private JLabel name = new JLabel();
	private JLabel id = new JLabel("���̵�");
	private JLabel birthday = new JLabel("�������");
	private JLabel phone = new JLabel("��ȭ��ȣ");
	private JLabel taste = new JLabel("��ȭ ����");
	private JButton btn_modify_Info = new JButton("�������� ����");
	private JButton btn_modify_Profile = new JButton("������ ����");
	private JLabel profile = new JLabel("DOK ������");
	private JLabel userInfo = new JLabel("���� ����");
	private JLabel record_movie = new JLabel("�ֱ� ������ ��ȭ");
	private JLabel record_movieInfo = new JLabel();
	
	
	
	public MyPage() {}
	public MyPage(User user) {
		
		super("���� ������");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);//âũ�� ����x
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);//���̾ƿ� null
		setVisible(true);
		
		this.user = user;
		
		//������
		profile.setBounds(POS_X_LEFT,PaddingTop,300,50);
		profile.setOpaque(true);
		profile.setBackground(Color.YELLOW);
		profile.setFont(font3);
		panel.add(profile);
		
		//������ ����
		profile_img.setBounds(POS_X_LEFT, PaddingTop+60, 200, 200);
		profile_img.setOpaque(true);
		profile_img.setBackground(Color.RED);
		profile_img.setFont(font1);
		panel.add(profile_img);
		
		//����� �̸�
		name.setBounds(POS_X_LEFT, PaddingTop + 280, 200, 50);
		name.setOpaque(true);
		name.setBackground(Color.GREEN);
		name.setText("�̸�: "+user.getUserName());
		name.setFont(font1);
		panel.add(name);
		
		//������ ����btn
		btn_modify_Profile.setBounds(POS_X_LEFT,PaddingTop+280+50+10,200,50);
		btn_modify_Profile.setOpaque(true);
		btn_modify_Profile.setBackground(Color.GRAY);
		btn_modify_Profile.setFont(font1);
		btn_modify_Profile.addActionListener(new BtnEvent());
		panel.add(btn_modify_Profile);
		
		//���� ����
		userInfo.setBounds(POS_X_CENTER,PaddingTop,300,50);
		userInfo.setOpaque(true);
		userInfo.setBackground(Color.YELLOW);
		userInfo.setFont(font3);
		panel.add(userInfo);
		
		//���̵�
		id.setBounds(POS_X_CENTER, PaddingTop+60, 300, 40);
		id.setOpaque(true);
		id.setBackground(Color.WHITE);
		id.setFont(font1);
		id.setText("���̵�: "+user.getUserID());
		panel.add(id);
		
		//������� : yyyy-mm-dd
		birthday.setBounds(POS_X_CENTER, PaddingTop + 120, 300, 40);
		birthday.setOpaque(true);
		birthday.setBackground(Color.WHITE);
		birthday.setFont(font1);
		birthday.setText("�������: "+user.getUseryymmdd());
		panel.add(birthday);
		
		//��ȭ��ȣ
		phone.setBounds(POS_X_CENTER, PaddingTop + 180, 300, 40);
		phone.setOpaque(true);
		phone.setBackground(Color.WHITE);
		phone.setFont(font1);
		phone.setText("��ȭ��ȣ: "+user.getUserPhone());
		panel.add(phone);
		
		//��ȭ ����
		taste.setBounds(POS_X_CENTER, PaddingTop + 240, 300, 40);
		taste.setOpaque(true);
		taste.setBackground(Color.WHITE);
		taste.setFont(font1);
		taste.setText("��ȭ����: "+user.getUserTaste1());
		panel.add(taste);
		
		//������������btn
		btn_modify_Info.setBounds(POS_X_CENTER, PaddingTop+280+50+10, 200, 50);
		btn_modify_Info.setOpaque(true);
		btn_modify_Info.setBackground(Color.GRAY);
		btn_modify_Info.setFont(font1);
		btn_modify_Info.addActionListener(new BtnEvent());
		panel.add(btn_modify_Info);
		
	
		
		//�ֱ� ������ ��ȭ label
		record_movie.setBounds(POS_X_RIGHT, PaddingTop, 300, 50);
		record_movie.setOpaque(true);
		record_movie.setBackground(Color.YELLOW);
		record_movie.setFont(font3);
		panel.add(record_movie);
		
		//�ֱ� ������ ��ȭ
		record_movieInfo.setBounds(POS_X_RIGHT, PaddingTop + 40, 330, 350);
		record_movieInfo.setOpaque(true);
		record_movieInfo.setFont(font1);
		record_movieInfo.setBackground(Color.CYAN);
		panel.add(record_movieInfo);

		/////////
		a.setBackground(Color.MAGENTA);
		a.setOpaque(true);
		a.setBounds(POS_X_CENTER, (int) (Main.SCREEN_HEIGHT*0.1), 400, 440);
		panel.add(a);
		
		b.setBackground(Color.MAGENTA);
		b.setOpaque(true);
		b.setBounds(POS_X_LEFT, (int) (Main.SCREEN_HEIGHT*0.1), 400, 440);
		panel.add(b);
		
		c.setBackground(Color.MAGENTA);
		c.setOpaque(true);
		c.setBounds(POS_X_RIGHT, (int) (Main.SCREEN_HEIGHT*0.1), 400, 440);
		panel.add(c);
		////////
		
		
		//Panel
		panel.setBackground(Color.WHITE);
		panel.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		panel.setLayout(null);
		add(panel);
	}
	
	class BtnEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btn_modify_Info) {
				String pw = JOptionPane.showInputDialog(null,"��й�ȣ�� �Է����ּ���");
				if(pw.equals(user.getUserPassword())) {
					dispose();
					new P_InformationPage(user);
				}else {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
				
			}
		}
		
	}
	
}
