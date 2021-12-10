import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class MonthlyReport extends JFrame {
    // TODO 정보
	User user = new User();

	MonthlyReport(User u) {
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("월별 보고서");
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
		// TODO 날짜
		Date date = new Date();
		SimpleDateFormat yearFromat = new SimpleDateFormat("yyyy");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		String year = yearFromat.format(date);
		String month = monthFormat.format(date);

		// TODO 몇월
		JLabel monthLabel = new JLabel(year + "년 " + month + "월 보고서");
		monthLabel.setBounds(30, 100, 200, 20);

		// TODO 총 매출
		JLabel allSalesTextLabel = new JLabel("총 매출 : ");
		allSalesTextLabel.setBounds(30, 130, 80, 20);
		JLabel allSalesLabel = new JLabel("100,000,000");
		allSalesLabel.setBounds(80, 130, 80, 20);

		// TODO 순수익
		JLabel netProfitTextLabel = new JLabel("순수익  : ");
		netProfitTextLabel.setBounds(30, 160, 100, 20);
		JLabel netProfitLabel = new JLabel("30,000,000");
		netProfitLabel.setBounds(80, 160, 300, 20);

		c.add(backButton);
		c.add(monthLabel);
		c.add(allSalesTextLabel);
		c.add(allSalesLabel);
		c.add(netProfitTextLabel);
		c.add(netProfitLabel);

		setSize(710, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
	}
}
