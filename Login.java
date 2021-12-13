import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// TODO 로그인Class
public class Login extends JFrame {
	// TODO 정보
	public static ArrayList<User> userList = new ArrayList<User>();

	// TODO Login
	Login(User u) {
		SaveImport s = new SaveImport();
		s.save(userList);

		System.out.println("로그인 폼");

		// 프레임 제목, 메인 프레임 종료시 이벤트 프레임도 종료하도록 설정
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);

		// TODO 인사
		Font welcomeFont = new Font("궁서체", Font.PLAIN, 30);
		Font textFont = new Font("이텔릭체", Font.ITALIC, 12);
		JLabel welcome = new JLabel("Heading");
		welcome.setBounds(50, 70, 200, 30);
		welcome.setFont(welcomeFont);
		JLabel text1 = new JLabel("Lorem ipsum dolor sit amet, consectetur");
		text1.setBounds(50, 120, 300, 20);
		text1.setFont(textFont);
		JLabel text2 = new JLabel("adipisicing elit, sed do eiusmod tempor");
		text2.setBounds(50, 140, 300, 20);
		text2.setFont(textFont);
		JLabel text3 = new JLabel("incididunt ut labore et dolore magna aliqua.");
		text3.setBounds(50, 160, 300, 20);
		text3.setFont(textFont);
		// 인사 색깔 설정
		welcome.setForeground(Color.WHITE);
		text1.setForeground(Color.WHITE);
		text2.setForeground(Color.WHITE);
		text3.setForeground(Color.WHITE);

		// TODO ID
		Font idFont = new Font("이텔릭체", Font.ITALIC, 13);
		JTextField idTextField = new JTextField();
		idTextField.setBounds(410, 100, 250, 40);
		idTextField.setBackground(Color.WHITE);
		idTextField.setFont(idFont);

		// TODO PW
		Font pwFont = new Font("이텔릭체", Font.ITALIC, 13);
		JPasswordField pwTextField = new JPasswordField();
		pwTextField.setBounds(410, 160, 250, 40);
		pwTextField.setBackground(Color.WHITE);
		pwTextField.setFont(pwFont);

		// TODO 회원가입
		RoundedButton joinMembershipButton = new RoundedButton("회원가입");
		joinMembershipButton.setBounds(50, 240, 250, 40);
		joinMembershipButton.setBackground(Color.WHITE);
		joinMembershipButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new JoinMemberShip(userList);
			}
		});

		// TODO 로그인
		RoundedButton loginButton = new RoundedButton("로그인");
		loginButton.setBounds(410, 240, 250, 40);
		loginButton.setBackground(Color.WHITE);
		loginButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String id = idTextField.getText();
				String pw = pwTextField.getText();
				boolean check = false;
				User user = new User();

				// userList에 id와 pw가 존재하는지 확인
				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).getId().equals(id)) {
						if (userList.get(i).getPw().equals(pw)) {
							user = userList.get(i);
							check = true;
							break;
						}
					}
				}

				// 로그인 성공
				if (check == true) {
					setVisible(false);
					new Main(user);
				}
				// 로그인 실패
				else {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 틀렸습니다.");
				}
			}
		});

		// TODO 아이디 찾기
		RoundedButton findIdButton = new RoundedButton("아이디 찾기");;
		findIdButton.setBounds(50, 290, 250, 40);
		findIdButton.setBackground(Color.WHITE);
		findIdButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new FindId(userList);
			}
		});

		// TODO 비밀번호 찾기
		RoundedButton findpwButton = new RoundedButton("비밀번호 찾기");
		findpwButton.setBounds(410, 290, 250, 40);
		findpwButton.setBackground(Color.WHITE);
		findpwButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new FindPw(userList);
			}
		});

		c.add(welcome);
		c.add(text1);
		c.add(text2);
		c.add(text3);
		c.add(idTextField);
		c.add(pwTextField);
		c.add(joinMembershipButton);
		c.add(loginButton);
		c.add(findIdButton);
		c.add(findpwButton);
		// c.add(saveExitButton);

		// TODO 배경화면 함수 호출
		backgroundImage();

		// TODO 사이즈설정 및 프레임 설정 변경
		setSize(710, 400);
		setResizable(false); // 크기 변경 불가능하도록 함
		setVisible(true); // 창 표시

	}

	// TODO Login
	Login(ArrayList<User> arrayListUser) {
		userList = arrayListUser;

		SaveImport s = new SaveImport();
		s.save(userList);

		System.out.println("로그인 폼");

		// 프레임 제목, 메인 프레임 종료시 이벤트 프레임도 종료하도록 설정
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);

		// TODO 인사
		Font welcomeFont = new Font("궁서체", Font.PLAIN, 30);
		Font textFont = new Font("이텔릭체", Font.ITALIC, 12);
		JLabel welcome = new JLabel("Heading");
		welcome.setBounds(50, 70, 200, 30);
		welcome.setFont(welcomeFont);
		JLabel text1 = new JLabel("Lorem ipsum dolor sit amet, consectetur");
		text1.setBounds(50, 120, 300, 20);
		text1.setFont(textFont);
		JLabel text2 = new JLabel("adipisicing elit, sed do eiusmod tempor");
		text2.setBounds(50, 140, 300, 20);
		text2.setFont(textFont);
		JLabel text3 = new JLabel("incididunt ut labore et dolore magna aliqua.");
		text3.setBounds(50, 160, 300, 20);
		text3.setFont(textFont);
		// 인사 색깔 설정
		welcome.setForeground(Color.WHITE);
		text1.setForeground(Color.WHITE);
		text2.setForeground(Color.WHITE);
		text3.setForeground(Color.WHITE);

		// TODO ID
		Font idFont = new Font("이텔릭체", Font.ITALIC, 13);
		JTextField idTextField = new JTextField();
		idTextField.setBounds(410, 100, 250, 40);
		idTextField.setBackground(Color.WHITE);
		idTextField.setFont(idFont);

		// TODO PW
		Font pwFont = new Font("이텔릭체", Font.ITALIC, 13);
		JPasswordField pwTextField = new JPasswordField();
		pwTextField.setBounds(410, 160, 250, 40);
		pwTextField.setBackground(Color.WHITE);
		pwTextField.setFont(pwFont);

		// TODO 회원가입
		RoundedButton joinMembershipButton = new RoundedButton("회원가입");
		joinMembershipButton.setBounds(50, 240, 250, 40);
		joinMembershipButton.setBackground(Color.WHITE);
		joinMembershipButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new JoinMemberShip(userList);
			}
		});

		// TODO 로그인
		RoundedButton loginButton = new RoundedButton("로그인");
		loginButton.setBounds(410, 240, 250, 40);
		loginButton.setBackground(Color.WHITE);
		loginButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String id = idTextField.getText();
				String pw = pwTextField.getText();
				boolean check = false;
				User user = new User();

				// userList에 id와 pw가 존재하는지 확인
				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).getId().equals(id)) {
						if (userList.get(i).getPw().equals(pw)) {
							user = userList.get(i);
							check = true;
							break;
						}
					}
				}

				// 로그인 성공
				if (check == true) {
					setVisible(false);
					new Main(user);
				}
				// 로그인 실패
				else {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 틀렸습니다.");
				}
			}
		});

		// TODO 아이디 찾기
		RoundedButton findIdButton = new RoundedButton("아이디 찾기");;
		findIdButton.setBounds(50, 290, 250, 40);
		findIdButton.setBackground(Color.WHITE);
		findIdButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new FindId(userList);
			}
		});

		// TODO 비밀번호 찾기
		RoundedButton findpwButton = new RoundedButton("비밀번호 찾기");
		findpwButton.setBounds(410, 290, 250, 40);
		findpwButton.setBackground(Color.WHITE);
		findpwButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new FindPw(userList);
			}
		});

		c.add(welcome);
		c.add(text1);
		c.add(text2);
		c.add(text3);
		c.add(idTextField);
		c.add(pwTextField);
		c.add(joinMembershipButton);
		c.add(loginButton);
		c.add(findIdButton);
		c.add(findpwButton);
		// c.add(saveExitButton);

		// TODO 배경화면 함수 호출
		backgroundImage();

		// TODO 사이즈설정 및 프레임 설정 변경
		setSize(710, 400);
		setResizable(false); // 크기 변경 불가능하도록 함
		setVisible(true); // 창 표시

	}

	// TODO 배경화면 함수
	// 12월~2월 겨울 3월~5월 봄 6월~8월 여름 9월~11월 가을
	// 신정(1/1) 삼일정(3/1) 어린이날(5/5) 현충일(6/6) 광복절(8/15) 개천절(10/3) 한글날(10/9) 성탄절(12/25)
	public void backgroundImage() {
		Date now = new Date();
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		String month = monthFormat.format(now);
		String day = dayFormat.format(now);

		JLabel background = new JLabel();
		// TODO 봄
		if (month.equals("03") || month.equals("04") || month.equals("05")) {
			background = new JLabel(new ImageIcon("images/봄.jpg"));
			if (month.equals("03") && day.equals("01")) {
				background = new JLabel(new ImageIcon("images/삼일절.jpg"));
			}
			if (month.equals("05") && day.equals("05")) {
				background = new JLabel(new ImageIcon("images/어린이날.jpg"));
			}
		}
		// TODO 여름
		else if (month.equals("06") || month.equals("07") || month.equals("08")) {
			background = new JLabel(new ImageIcon("images/여름.jpg"));
			if (month.equals("06") && day.equals("06")) {
				background = new JLabel(new ImageIcon("images/현충일.jpg"));
			}
			if (month.equals("06") && day.equals("08")) {
				background = new JLabel(new ImageIcon("images/로봇.jpg"));
			}
			if (month.equals("08") && day.equals("15")) {
				background = new JLabel(new ImageIcon("images/광복절.jpg"));
			}
		}
		// TODO 가을
		else if (month.equals("09") || month.equals("10") || month.equals("11")) {
			background = new JLabel(new ImageIcon("images/가을.jpg"));
			if (month.equals("10") && day.equals("03")) {
				background = new JLabel(new ImageIcon("images/개천절.jpg"));
			}
			if (month.equals("10") && day.equals("09")) {
				background = new JLabel(new ImageIcon("images/한글날.jpg"));
			}
		}
		// TODO 겨울
		else if (month.equals("12") || month.equals("01") || month.equals("02")) {
			background = new JLabel(new ImageIcon("images/겨울.jpg"));
			if (month.equals("12") && day.equals("25")) {
				background = new JLabel(new ImageIcon("images/성탄절.jpg"));
			}
			if (month.equals("01") && day.equals("01")) {
				background = new JLabel(new ImageIcon("images/새해.jpg"));
			}
		}
		background.setBounds(0, 0, 710, 400);
		super.add(background);
	}

	// public void save(){
	// 	SaveImport save = new SaveImport();
	// 	save.userSave(userList);
	// }

	// public void load(){
		// SaveImport s = new SaveImport();
		// userList = s.userImport(userList);
	// }

	public static void main(String[] args) {
		ArrayList<User> arrayUser = new ArrayList<User>();
		SaveImport s = new SaveImport();
		s.load(arrayUser);

		new Login(arrayUser);
	}

}
