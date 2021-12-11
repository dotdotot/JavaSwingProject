import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import javax.swing.*;

public class MonthlyReport extends JFrame {
    // TODO 정보
	User user = new User();
	ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	ArrayList<ArrayList<JButton>> buttonListList = new ArrayList<ArrayList<JButton>>();
	int buttonListListIndex = 0;
	int visibleButtonIndex = 0;

	MonthlyReport(User u) {
		System.out.println("월별 보고서 폼");
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

		// 총 매출과 순수익 자르기
		String t = user.pos.report_b.month();
		String []tArr = t.split(",");

		// TODO 총 매출
		JLabel allSalesTextLabel = new JLabel("총 매출 : ");
		allSalesTextLabel.setBounds(30, 130, 80, 20);
		JLabel allSalesLabel = new JLabel(tArr[0] +"원");
		allSalesLabel.setBounds(80, 130, 80, 20);

		// TODO 순수익
		JLabel netProfitTextLabel = new JLabel("순수익  : ");
		netProfitTextLabel.setBounds(30, 160, 100, 20);
		JLabel netProfitLabel = new JLabel(tArr[1] + "원");
		netProfitLabel.setBounds(80, 160, 300, 20);

		// TODO 일반상품 판넬추가 함수(return은 상품의 총 개수를 리턴함)
		int maxIndex = productPanel();

		// TODO 일반상품 상품페이지
		JLabel productPageLabel = new JLabel("1page | " + String.valueOf(panelList.size()) + "page");
		productPageLabel.setBounds(575, 275, 150, 20);

		// TODO 일반상품 페이지 이전
		JButton pageBackButton = new JButton("이전");
		pageBackButton.setBounds(390, 300, 60, 25);
		pageBackButton.setBackground(Color.WHITE);
		pageBackButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panelList.get(visibleButtonIndex).setVisible(false);

				if (visibleButtonIndex == 0) {
					visibleButtonIndex = panelList.size() - 1;
				} else {
					visibleButtonIndex--;
				}

				panelList.get(visibleButtonIndex).setVisible(true);
				productPageLabel
						.setText((visibleButtonIndex + 1) + "page | " + String.valueOf(panelList.size()) + "page");
			}
		});
		// TODO 일반상품 페이지 다음
		JButton pageNextButton = new JButton("다음");
		pageNextButton.setBounds(490, 300, 60, 25);
		pageNextButton.setBackground(Color.WHITE);
		pageNextButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panelList.get(visibleButtonIndex).setVisible(false);

				if (visibleButtonIndex == panelList.size() - 1) {
					visibleButtonIndex = 0;
				} else {
					visibleButtonIndex++;
				}

				panelList.get(visibleButtonIndex).setVisible(true);
				productPageLabel
						.setText((visibleButtonIndex + 1) + "page | " + String.valueOf(panelList.size()) + "page");
			}
		});


		c.add(backButton);
		c.add(monthLabel);
		c.add(allSalesTextLabel);
		c.add(allSalesLabel);
		c.add(netProfitTextLabel);
		c.add(netProfitLabel);
		c.add(productPageLabel);
		c.add(pageBackButton);
		c.add(pageNextButton);

		setSize(710, 400);
		setVisible(true);
	}


	// TODO 일반상품 productPanel()
	public int productPanel() {
		String productArr[] = user.pos.report_b.monthList().split("/");
		System.out.println("상품의 총 개수 : " + productArr.length);

		// 생성해야하는 판넬의 개수를 가져오는 코드
		int panelNum = productArr.length / 4;
		if (productArr.length % 4 != 0) {
			panelNum++;
		}

		// 판넬 생성
		for (int i = 0; i < panelNum; i++) {
			panel();
		}

		// 판넬모두 안보이게 설정
		for (int i = 0; i < panelList.size(); i++) {
			super.add(panelList.get(i));
			panelList.get(i).setVisible(false);
		}

		// 일반상품 버튼 라벨링
		int index = 0;
		for (int i = 0; i < buttonListListIndex; i++) {
			for (int ii = 0; ii < 4; ii++) {
				buttonListList.get(i).get(ii).setText(productArr[index]);
				if (index == productArr.length - 1) {
					break;
				}
				index++;
			}
		}

		// 처음에는 첫번째 판넬만 보여지도록 설정
		panelList.get(0).setVisible(true);
		// 총 상품의 개수 리턴
		return productArr.length;
	}

	// TODO 일반상품 Panel()
	public void panel() {
		JPanel productPanel = new JPanel();
		productPanel.setBackground(Color.WHITE);
		productPanel.setBounds(280, 50, 380, 225);
		productPanel.setLayout(null);

		JButton one = new JButton("");
		one.setBounds(5, 5, 370, 50);
		one.setBackground(Color.WHITE);
		JButton two = new JButton("");
		two.setBounds(5, 60, 370, 50);
		two.setBackground(Color.WHITE);
		JButton three = new JButton("");
		three.setBounds(5, 115, 370, 50);
		three.setBackground(Color.WHITE);
		JButton four = new JButton("");
		four.setBounds(5, 170, 370, 50);
		four.setBackground(Color.WHITE);

		productPanel.add(one);
		productPanel.add(two);
		productPanel.add(three);
		productPanel.add(four);

		ArrayList<JButton> a = new ArrayList<JButton>();
		a.add(one);
		a.add(two);
		a.add(three);
		a.add(four);
		buttonListList.add(a);

		buttonListListIndex += 1;
		panelList.add(productPanel);
	}

	public static void main(String[] args) {
	}
}
