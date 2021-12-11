import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// TODO 내 정보Class
public class MyInformation extends JFrame {
    // TODO 정보
	User user = new User();

	public MyInformation() {
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("내 정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// 이전
		JButton backButton = new JButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new Main(user);
			}
		});

		// 이름
		JLabel nameLabel = new JLabel("이름 : " + user.getName());
		nameLabel.setBounds(10, 50, 200, 20);

		// 생년월일
		JLabel birthLabel = new JLabel("생년월일 : " + user.getBirthDate());
		birthLabel.setBounds(10, 80, 200, 20);

		// 성별
		JLabel genderLabel = new JLabel("성별 : " + user.getGender());
		genderLabel.setBounds(10, 110, 200, 20);

		// 아이디
		JLabel idLabel = new JLabel("아이디 : " + user.getId());
		idLabel.setBounds(10, 140, 200, 20);

		// 비밀번호
		JLabel pwLabel = new JLabel("비밀번호 : " + user.getPw());
		pwLabel.setBounds(10, 170, 200, 20);

		// 비밀번호찾기 질문
		JLabel findPwQLabel = new JLabel("비밀번호찾기 질문 : " + user.getPwQuestion());
		findPwQLabel.setBounds(10, 200, 200, 20);

		// 비밀번호찾기 답변
		JLabel findPwLabel = new JLabel("비밀번호찾기 답변 : " + user.getPwQuestionAnswer());
		findPwLabel.setBounds(10, 230, 200, 20);

		// 전화번호
		JLabel phoneLabel = new JLabel("전화번호 : " + user.getPhoneNumber());
		phoneLabel.setBounds(10, 260, 200, 20);

		// 이메일
		JLabel emailLabel = new JLabel("이메일 : " + user.geteMail());
		emailLabel.setBounds(10, 290, 200, 20);

		// 관리자 전화번호
		JLabel managerPhoneLabel = new JLabel("관리자 전화번호 : 010-9206-9486");
		managerPhoneLabel.setBounds(510, 340, 200, 20);

		c.add(backButton);
		c.add(nameLabel);
		c.add(birthLabel);
		c.add(genderLabel);
		c.add(idLabel);
		c.add(pwLabel);
		c.add(findPwQLabel);
		c.add(findPwLabel);
		c.add(phoneLabel);
		c.add(emailLabel);
		c.add(managerPhoneLabel);

		setSize(710, 400);
		setVisible(true);
	}

	public MyInformation(User u) {
		System.out.println("내 정보 폼");
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("내 정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 이전
		JButton backButton = new JButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new Main(user);
			}
		});

		// TODO 이름
		JLabel nameLabel = new JLabel("이름 : " + user.getName());
		nameLabel.setBounds(10, 50, 300, 20);

		// TODO 생년월일
		JLabel birthLabel = new JLabel("생년월일 : " + user.getBirthDate());
		birthLabel.setBounds(10, 80, 300, 20);

		// TODO 성별
		JLabel genderLabel = new JLabel("성별 : " + user.getGender());
		genderLabel.setBounds(10, 110, 300, 20);

		// TODO 아이디
		JLabel idLabel = new JLabel("아이디 : " + user.getId());
		idLabel.setBounds(10, 140, 300, 20);

		// TODO 비밀번호
		JLabel pwLabel = new JLabel("비밀번호 : " + user.getPw());
		pwLabel.setBounds(10, 170, 300, 20);

		// TODO 비밀번호찾기 질문
		JLabel findPwQLabel = new JLabel("비밀번호찾기 질문 : " + user.getPwQuestion());
		findPwQLabel.setBounds(10, 200, 500, 20);

		// TODO 비밀번호찾기 답변
		JLabel findPwLabel = new JLabel("비밀번호찾기 답변 : " + user.getPwQuestionAnswer());
		findPwLabel.setBounds(10, 230, 500, 20);

		// TODO 전화번호
		JLabel phoneLabel = new JLabel("전화번호 : " + user.getPhoneNumber());
		phoneLabel.setBounds(10, 260, 300, 20);

		// TODO 이메일
		JLabel emailLabel = new JLabel("이메일 : " + user.geteMail());
		emailLabel.setBounds(10, 290, 300, 20);

		// TODO 관리자 전화번호
		JLabel managerPhoneLabel = new JLabel("관리자 전화번호 : 010-9206-9486");
		managerPhoneLabel.setBounds(510, 340, 200, 20);

		c.add(backButton);
		c.add(nameLabel);
		c.add(birthLabel);
		c.add(genderLabel);
		c.add(idLabel);
		c.add(pwLabel);
		c.add(findPwQLabel);
		c.add(findPwLabel);
		c.add(phoneLabel);
		c.add(emailLabel);
		c.add(managerPhoneLabel);

		setSize(710, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
	}
}
