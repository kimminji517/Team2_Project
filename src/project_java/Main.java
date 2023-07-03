package project_java;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import Server.Protocol;
import project_admin.AdminMain;
import UserDB.DAO;
import UserDB.VO;

public class Main extends JFrame{
	public CardLayout cardLayout;
	public JPanel cardJPanel;
	public VO vo;
	Login_My_Infomodify login_My_Infomodify;
	
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	public Main() {
		super("PERSONAL PLANNER");
		cardJPanel = new JPanel();
		cardLayout = new CardLayout();
		cardJPanel.setLayout(cardLayout);

		// 로그인 후
		// 객체 선언
		// 로그인 전
		Login_Main login_Main = new Login_Main(this);
		Login_Register login_Register = new Login_Register(this);
		Id_Search id_Search = new Id_Search(this);
		Pw_Search pw_Search = new Pw_Search(this);
		// PwChange_login pwChange_login = new PwChange_login(this);
		// 로그인 전
		cardJPanel.add("login_Main", login_Main);
		cardJPanel.add("login_Register", login_Register);
		cardJPanel.add("id_Search", id_Search);
		cardJPanel.add("pw_Search", pw_Search);
		// cardJPanel.add("pwChange_login", pwChange_login);

		add(cardJPanel);

		cardLayout.show(cardJPanel, "login_Main");

		setSize(1000, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public void Main2() {
		login_My_Infomodify = new Login_My_Infomodify(this);
		Login_My_PWmodify login_My_PWmodify = new Login_My_PWmodify(this);
		Login_Withdrawal login_Withdrawal = new Login_Withdrawal(this);

		// 리뷰 객체 선언
		AllReview allReview = new AllReview(this);
		MyReview myReview = new MyReview(this);

		// 플래너 객체 선언
		Planner_Create planner_Create = new Planner_Create(this);
		Planner_InsertSpot planner_InsertSpot = new Planner_InsertSpot(this);
		Planner_Select planner_Select = new Planner_Select(this);

		// 관리자 객체 선언
		AdminMain adminMain = new AdminMain(this);

		// 카드 패널 추가

		// 로그인 후
		cardJPanel.add("login_My_Infomodify", login_My_Infomodify);
		cardJPanel.add("login_My_PWmodify", login_My_PWmodify);
		cardJPanel.add("login_Withdrawal", login_Withdrawal);

		// 리뷰
		cardJPanel.add("allReview", allReview);
		cardJPanel.add("myReview", myReview);

		// 플래너
		cardJPanel.add("planner_Create", planner_Create);
		cardJPanel.add("planner_InsertSpot", planner_InsertSpot);
		cardJPanel.add("planner_Select", planner_Select);

		// 관리자
		cardJPanel.add("admin_greeting", adminMain.adminHome);
		cardJPanel.add("admin_places", adminMain.adminPlaces);
		cardJPanel.add("admin_users", adminMain.adminUsers);
		cardJPanel.add("admin_reviews", adminMain.adminReview);
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					new Main();
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
