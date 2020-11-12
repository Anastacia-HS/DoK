package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import User.User;


public class Reservation_start_page extends CategoryFrame{
	private final static int PaddingLeft = 40;
	private final static int PaddingTop = 100;
	
	private final static double Panel_Height = 700;
	
	// size
	private Dimension size = new Dimension();// ����� �����ϱ� ���� ��ü ����
	
	
	//component
	private JPanel panel = new JPanel();
	private JPanel m_panel = new JPanel();
	private JPanel a_panel = new JPanel();
	private JPanel t_panel = new JPanel();
	
	
	//��ȭ
	private JLabel movie = new JLabel("��ȭ");
	private JPanel movielist = new JPanel();
	
	private JLabel[] poster = new JLabel[3];

	
	
	//����
	private JLabel area = new JLabel("����");
	private JButton seoul = new JButton("����");
	private JButton gyeonggi = new JButton("���");
	private JButton[] seoullist = new JButton[4];
	private JButton[] gyeonggilist = new JButton[4];
	private JLabel[] selectArea = new JLabel[2];
	
	
	//�ð�
	private JButton[] timetable = new JButton[7];
	private JLabel content = new JLabel();
	
	
	//Design
	Font font1 = new Font("�޸յձ�������", Font.PLAIN, 25);
	Font font2 = new Font("�޸յձ�������", Font.PLAIN, 20);
	
	public Reservation_start_page() {
		super("����");
		
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//���̾ƿ� null
		setVisible(true);
		setBackground(Color.WHITE);
		
		this.user = user;
		
		//��ȭ �г�
		m_panel.setBounds(PaddingLeft, PaddingTop, 400, 600);
		m_panel.setOpaque(true);
		m_panel.setBackground(Color.LIGHT_GRAY);
		m_panel.setLayout(null);
		panel.add(m_panel);
		
		movie.setBounds(5, 5, 60, 40);
		movie.setFont(font1);
		movie.setHorizontalAlignment(JLabel.CENTER);
		m_panel.add(movie);
		
		
		size.setSize(400, 600);
		
		
		
		movielist.setOpaque(true);
		movielist.setBackground(Color.DARK_GRAY);
		movielist.setLayout(null);
		movielist.setPreferredSize(size);
		JScrollPane sp = new JScrollPane(movielist, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(0, 75, 400, 350);
		m_panel.add(sp);
		
		for(int i = 0; i < poster.length; i++) {
			poster[i] = new JLabel();
			poster[i].setBounds(20 + (i * 130), 440, 100, 140);
			poster[i].setOpaque(true);
			poster[i].setBackground(Color.ORANGE);
			m_panel.add(poster[i]);
		}
		
		
		//����
		a_panel.setBounds(PaddingLeft + 425, PaddingTop, 450, 600);
		a_panel.setOpaque(true);
		a_panel.setBackground(Color.LIGHT_GRAY);
		a_panel.setLayout(null);
		panel.add(a_panel);
		
		area.setBounds(5, 5, 60, 40);
		area.setFont(font1);
		area.setHorizontalAlignment(JLabel.CENTER);
		a_panel.add(area);
		
		seoul.setBounds(0, 75, 225, 40);
		seoul.setOpaque(true);
		seoul.setFont(font2);
		seoul.setHorizontalAlignment(JButton.CENTER);
		seoul.addActionListener(new ReservationEvent());
		a_panel.add(seoul);
		
		gyeonggi.setBounds(225, 75, 225, 40);
		gyeonggi.setFont(font2);
		gyeonggi.setHorizontalAlignment(JButton.CENTER);
		gyeonggi.addActionListener(new ReservationEvent());
		a_panel.add(gyeonggi);
		
		seoullist[0] = new JButton("* ����");
		seoullist[1] = new JButton("* ����");
		seoullist[2] = new JButton("* ����");
		seoullist[3] = new JButton("* ȫ��");
		
		for(int i = 0; i < seoullist.length; i++) {
			seoullist[i].setBounds(10, 150 + (i * 60), 100, 40);
			seoullist[i].setFocusPainted(false);
			seoullist[i].setBorderPainted(false);
			seoullist[i].setOpaque(false);
			seoullist[i].setFont(font2);
			a_panel.add(seoullist[i]);
		}
		
		gyeonggilist[0] = new JButton("* ����");
		gyeonggilist[1] = new JButton("* ����");
		gyeonggilist[2] = new JButton("* ����");
		gyeonggilist[3] = new JButton("* �Ǳ�");
		
		for(int i = 0; i < seoullist.length; i++) {
			gyeonggilist[i].setVisible(false);
			gyeonggilist[i].setBounds(10, 150 + (i * 60), 100, 40);
			gyeonggilist[i].setFocusPainted(false);
			gyeonggilist[i].setBorderPainted(false);
			gyeonggilist[i].setOpaque(false);
			gyeonggilist[i].setFont(font2);
			a_panel.add(gyeonggilist[i]);
		}
		
		for(int i = 0; i < selectArea.length; i++) {
			selectArea[i] = new JLabel();
			selectArea[i].setBounds(50 + (i * 200), 440, 150, 150);
			selectArea[i].setOpaque(true);
			selectArea[i].setBackground(Color.ORANGE);
			a_panel.add(selectArea[i]);
		}
		
		//�ð�ǥ
		t_panel.setBounds(PaddingLeft + 900, PaddingTop, 500, 600);
		t_panel.setOpaque(true);
		t_panel.setBackground(Color.LIGHT_GRAY);
		t_panel.setLayout(null);
		panel.add(t_panel);
		
		for(int i = 0; i < timetable.length; i++) {
			timetable[i] = new JButton((i + 1) + "");			
			timetable[i].setBounds(0 + (i * (500 / 7)), 0, (500 / 7), (500 / 7));
			t_panel.add(timetable[i]);
		}
		
		content.setBounds(20, 100, 460, 125);
		content.setOpaque(true);
		content.setBackground(Color.YELLOW);
		t_panel.add(content);
		
		//Panel
		panel.setBackground(Color.WHITE);
		panel.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		panel.setLayout(null);
		add(panel);
		
		
	}
	
	
	public Reservation_start_page(User user) {	
		
		
	}
	
	public static void main(String[] args) {
		new Reservation_start_page();
	}
	
	class ReservationEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == seoul) {
				for(int i = 0; i < seoullist.length; i++) {
					gyeonggilist[i].setVisible(false);
					seoullist[i].setVisible(true);
					System.out.println("fff");
				}
			}else if(e.getSource() == gyeonggi) {
				for(int i = 0; i < seoullist.length; i++) {
					gyeonggilist[i].setVisible(true);
					seoullist[i].setVisible(false);
				}
			}
			
		}
	}
}
