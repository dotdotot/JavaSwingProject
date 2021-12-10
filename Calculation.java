import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.*;
import java.text.*;

// TODO 상품 선택
class CalculationMain extends JFrame {
	// TODO 상품 선택 정보
	User user = new User();

	CalculationMain(User u) {
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("계산");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 상품 선택 정보(이전)
		RoundedButton backButton = new RoundedButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new Main(user);
			}
		});

		// TODO 상품 선택 정보(좌석상품)
		JButton seatButton = new JButton("좌석 상품");
		seatButton.setBounds(40, 50, 150, 80);
		seatButton.setBackground(Color.WHITE);
		seatButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new SeatProductAll(user);
			}
		});

		// TODO 상품 선택 정보(일반상품)
		JButton normalButton = new JButton("일반 상품");
		normalButton.setBounds(200, 50, 150, 80);
		normalButton.setBackground(Color.WHITE);
		normalButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new NormalProduct(user);
			}
		});

		c.add(backButton);
		c.add(seatButton);
		c.add(normalButton);

		setSize(400, 200);
		setVisible(true);
	}
}

// TODO 좌석상품Class
class SeatProductAll extends JFrame {
	// TODO 좌석상품 정보
	User user = new User();
	ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	ArrayList<ArrayList<JButton>> buttonListList = new ArrayList<ArrayList<JButton>>();
	int buttonListListIndex = 0;
	int visibleButtonIndex = 0;

	public SeatProductAll(User u) {
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("좌석상품");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 좌석상품 이전
		JButton backButton = new JButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductsManager_Main(user);
			}
		});

		// TODO 좌석상품 판넬추가 함수(return은 상품의 총 개수를 리턴함)
		int maxIndex = productPanel();

		// TODO 좌석상품 각각의 상품 버튼에 마우스리스너 추가
		int index = 0;
		for (int i = 0; i < buttonListList.size(); i++) {
			for (int ii = 0; ii < 8; ii++) {
				buttonListList.get(i).get(ii).addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						JButton b = (JButton) e.getSource();
						String productNamePrice = b.getText();

						setVisible(false);
						new SeatProduct(user, productNamePrice);
					}
				});
				if (index == maxIndex - 1) {
					break;
				}
				index++;
			}
		}

		// TODO 좌석상품 상품목록
		Font productFont = new Font("이텔릭체", Font.PLAIN, 30);
		JLabel ProdcutListTextLabel = new JLabel("상품 목록");
		ProdcutListTextLabel.setFont(productFont);
		ProdcutListTextLabel.setBounds(280, 10, 150, 30);

		// TODO 좌석상품 상품페이지
		JLabel productPageLabel = new JLabel("1page | " + String.valueOf(panelList.size()) + "page");
		productPageLabel.setBounds(560, 293, 150, 20);

		// TODO 좌석상품 페이지 이전
		JButton pageBackButton = new JButton("이전");
		pageBackButton.setBounds(270, 300, 60, 25);
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

		// TODO 좌석상품 페이지 다음
		JButton pageNextButton = new JButton("다음");
		pageNextButton.setBounds(370, 300, 60, 25);
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

		c.add(ProdcutListTextLabel);
		c.add(productPageLabel);
		c.add(backButton);
		c.add(pageBackButton);
		c.add(pageNextButton);

		setSize(710, 400);
		setVisible(true);
	}

	// TODO 좌석상품 productPanel()
	public int productPanel() {
		String productText = "";
		for (int i = 0; i < user.pos.seatCheck_b.size(); i++) {
			productText += user.pos.seatCheck_b.get(i).getProduct_name() + "  "
					+ user.pos.seatCheck_b.get(i).getProduct_price() + "원/";
		}

		// System.out.println(productText);

		// /을 구분자로 잘라서 productArr에 저장
		String productArr[] = productText.split("/");

		// System.out.println("상품의 총 개수 : " + productArr.length);

		// 판넬 생성 개수 확인
		int panelNum = productArr.length / 8;
		if (productArr.length % 8 != 0) {
			panelNum++;
		}

		// 판넬 생성
		for (int i = 0; i < panelNum; i++) {
			panel();
		}

		// 컨테이너에 부착 후 안보이게 설정
		for (int i = 0; i < panelList.size(); i++) {
			super.add(panelList.get(i));
			panelList.get(i).setVisible(false);
		}

		// 일반상품 버튼 라벨링
		int index = 0;
		for (int i = 0; i < buttonListListIndex; i++) {
			for (int ii = 0; ii < 8; ii++) {
				buttonListList.get(i).get(ii).setText(productArr[index]);
				if (index == productArr.length - 1) {
					break;
				}
				index++;
			}
		}

		panelList.get(0).setVisible(true);
		return productArr.length;
	}

	// TODO 좌석상품 Panel()
	public void panel() {
		JPanel productPanel = new JPanel();
		productPanel.setBackground(Color.WHITE);
		productPanel.setBounds(50, 50, 600, 240);
		productPanel.setLayout(null);

		JButton one = new JButton("");
		one.setBounds(10, 10, 270, 50);
		one.setBackground(Color.WHITE);
		JButton two = new JButton("");
		two.setBounds(320, 10, 270, 50);
		two.setBackground(Color.WHITE);
		JButton three = new JButton("");
		three.setBounds(10, 65, 270, 50);
		three.setBackground(Color.WHITE);
		JButton four = new JButton("");
		four.setBounds(320, 65, 270, 50);
		four.setBackground(Color.WHITE);
		JButton five = new JButton("");
		five.setBounds(10, 120, 270, 50);
		five.setBackground(Color.WHITE);
		JButton six = new JButton("");
		six.setBounds(320, 120, 270, 50);
		six.setBackground(Color.WHITE);
		JButton seven = new JButton("");
		seven.setBounds(10, 175, 270, 50);
		seven.setBackground(Color.WHITE);
		JButton eight = new JButton("");
		eight.setBounds(320, 175, 270, 50);
		eight.setBackground(Color.WHITE);

		productPanel.add(one);
		productPanel.add(two);
		productPanel.add(three);
		productPanel.add(four);
		productPanel.add(five);
		productPanel.add(six);
		productPanel.add(seven);
		productPanel.add(eight);

		ArrayList<JButton> a = new ArrayList<JButton>();
		a.add(one);
		a.add(two);
		a.add(three);
		a.add(four);
		a.add(five);
		a.add(six);
		a.add(seven);
		a.add(eight);
		buttonListList.add(a);

		buttonListListIndex += 1;
		panelList.add(productPanel);
	}
}

// TODO 좌석Class
class SeatProduct extends JFrame {
	// TODO 좌석Class 정보
	User user = new User();
	int seatIndex;

	public SeatProduct(User u, String productNamePrice) {
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("좌석상품");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 좌석Class 이전
		JButton backButton = new JButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new CalculationMain(user);
			}
		});

		// TODO 좌석Class 좌석이름
		Font seatFont = new Font("이텔릭체", Font.PLAIN, 30);
		JLabel seatTextLabel = new JLabel("좌석");
		seatTextLabel.setFont(seatFont);
		seatTextLabel.setBounds(320, 20, 100, 50);

		for (int i = 0; i < user.pos.seatCheck_b.size(); i++) {
			if (productNamePrice.equals(user.pos.seatCheck_b.get(i).getProduct_name() + "  "
					+ user.pos.seatCheck_b.get(i).getProduct_price() + "원")) {
				seatIndex = i;
			}
		}

		// TODO 좌석Class 좌석(1~20)
		JButton seat_1_Button = new JButton("1");
		seat_1_Button.setBounds(85, 250, 80, 40);
		seat_1_Button.setBackground(Color.WHITE);
		seat_1_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 0;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(1) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(1) == false) {
			seat_1_Button.setBackground(Color.RED);
			seat_1_Button.setEnabled(false);
		}

		JButton seat_2_Button = new JButton("2");
		seat_2_Button.setBounds(175, 250, 80, 40);
		seat_2_Button.setBackground(Color.WHITE);
		seat_2_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 1;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(2) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(2) == false) {
			seat_2_Button.setBackground(Color.RED);
			seat_2_Button.setEnabled(false);
		}

		JButton seat_3_Button = new JButton("3");
		seat_3_Button.setBounds(310, 250, 80, 40);
		seat_3_Button.setBackground(Color.WHITE);
		seat_3_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 2;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(3) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(3) == false) {
			seat_3_Button.setBackground(Color.RED);
			seat_3_Button.setEnabled(false);
		}

		JButton seat_4_Button = new JButton("4");
		seat_4_Button.setBounds(435, 250, 80, 40);
		seat_4_Button.setBackground(Color.WHITE);
		seat_4_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 3;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(4) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(4) == false) {
			seat_4_Button.setBackground(Color.RED);
			seat_4_Button.setEnabled(false);
		}

		JButton seat_5_Button = new JButton("5");
		seat_5_Button.setBounds(525, 250, 80, 40);
		seat_5_Button.setBackground(Color.WHITE);
		seat_5_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 4;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(5) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(5) == false) {
			seat_5_Button.setBackground(Color.RED);
			seat_5_Button.setEnabled(false);
		}

		JButton seat_6_Button = new JButton("6");
		seat_6_Button.setBounds(85, 195, 80, 40);
		seat_6_Button.setBackground(Color.WHITE);
		seat_6_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 5;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(6) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(6) == false) {
			seat_6_Button.setBackground(Color.RED);
			seat_6_Button.setEnabled(false);
		}

		JButton seat_7_Button = new JButton("7");
		seat_7_Button.setBounds(175, 195, 80, 40);
		seat_7_Button.setBackground(Color.WHITE);
		seat_7_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 6;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(7) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(7) == false) {
			seat_7_Button.setBackground(Color.RED);
			seat_7_Button.setEnabled(false);
		}

		JButton seat_8_Button = new JButton("8");
		seat_8_Button.setBounds(310, 195, 80, 40);
		seat_8_Button.setBackground(Color.WHITE);
		seat_8_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 7;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(8) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(8) == false) {
			seat_8_Button.setBackground(Color.RED);
			seat_8_Button.setEnabled(false);
		}

		JButton seat_9_Button = new JButton("9");
		seat_9_Button.setBounds(435, 195, 80, 40);
		seat_9_Button.setBackground(Color.WHITE);
		seat_9_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 8;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(9) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(9) == false) {
			seat_9_Button.setBackground(Color.RED);
			seat_9_Button.setEnabled(false);
		}

		JButton seat_10_Button = new JButton("10");
		seat_10_Button.setBounds(525, 195, 80, 40);
		seat_10_Button.setBackground(Color.WHITE);
		seat_10_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 9;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(10) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(10) == false) {
			seat_10_Button.setBackground(Color.RED);
			seat_10_Button.setEnabled(false);
		}

		JButton seat_11_Button = new JButton("11");
		seat_11_Button.setBounds(85, 140, 80, 40);
		seat_11_Button.setBackground(Color.WHITE);
		seat_11_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 10;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(11) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(11) == false) {
			seat_11_Button.setBackground(Color.RED);
			seat_11_Button.setEnabled(false);
		}

		JButton seat_12_Button = new JButton("12");
		seat_12_Button.setBounds(175, 140, 80, 40);
		seat_12_Button.setBackground(Color.WHITE);
		seat_12_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 11;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(12) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(12) == false) {
			seat_12_Button.setBackground(Color.RED);
			seat_12_Button.setEnabled(false);
		}

		JButton seat_13_Button = new JButton("13");
		seat_13_Button.setBounds(310, 140, 80, 40);
		seat_13_Button.setBackground(Color.WHITE);
		seat_13_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 12;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(13) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(13) == false) {
			seat_13_Button.setBackground(Color.RED);
			seat_13_Button.setEnabled(false);
		}

		JButton seat_14_Button = new JButton("14");
		seat_14_Button.setBounds(435, 140, 80, 40);
		seat_14_Button.setBackground(Color.WHITE);
		seat_14_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 13;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(14) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(14) == false) {
			seat_14_Button.setBackground(Color.RED);
			seat_14_Button.setEnabled(false);
		}

		JButton seat_15_Button = new JButton("15");
		seat_15_Button.setBounds(525, 140, 80, 40);
		seat_15_Button.setBackground(Color.WHITE);
		seat_15_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 14;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(15) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(15) == false) {
			seat_15_Button.setBackground(Color.RED);
			seat_15_Button.setEnabled(false);
		}

		JButton seat_16_Button = new JButton("16");
		seat_16_Button.setBounds(85, 85, 80, 40);
		seat_16_Button.setBackground(Color.WHITE);
		seat_16_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 15;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(16) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(16) == false) {
			seat_16_Button.setBackground(Color.RED);
			seat_16_Button.setEnabled(false);
		}

		JButton seat_17_Button = new JButton("17");
		seat_17_Button.setBounds(175, 85, 80, 40);
		seat_17_Button.setBackground(Color.WHITE);
		seat_17_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 16;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(17) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(17) == false) {
			seat_17_Button.setBackground(Color.RED);
			seat_17_Button.setEnabled(false);
		}

		JButton seat_18_Button = new JButton("18");
		seat_18_Button.setBounds(310, 85, 80, 40);
		seat_18_Button.setBackground(Color.WHITE);
		seat_18_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 17;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(18) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(18) == false) {
			seat_18_Button.setBackground(Color.RED);
			seat_18_Button.setEnabled(false);
		}

		JButton seat_19_Button = new JButton("19");
		seat_19_Button.setBounds(435, 85, 80, 40);
		seat_19_Button.setBackground(Color.WHITE);
		seat_19_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 18;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(19) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(19) == false) {
			seat_19_Button.setBackground(Color.RED);
			seat_19_Button.setEnabled(false);
		}

		JButton seat_20_Button = new JButton("20");
		seat_20_Button.setBounds(525, 85, 80, 40);
		seat_20_Button.setBackground(Color.WHITE);
		seat_20_Button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int index = 19;
				if (user.pos.seatCheck_b.get(seatIndex).getSeetc(20) == false) {

				} else {
					setVisible(false);
					new CalculationSeatPay(user, productNamePrice, index);
				}
			}
		});
		if (user.pos.seatCheck_b.get(seatIndex).getSeetc(20) == false) {
			seat_20_Button.setBackground(Color.RED);
			seat_20_Button.setEnabled(false);
		}

		// 구매한 좌석 빨간색 체크

		c.add(backButton);
		c.add(seatTextLabel);

		c.add(seat_1_Button);
		c.add(seat_2_Button);
		c.add(seat_3_Button);
		c.add(seat_4_Button);
		c.add(seat_5_Button);

		c.add(seat_6_Button);
		c.add(seat_7_Button);
		c.add(seat_8_Button);
		c.add(seat_9_Button);
		c.add(seat_10_Button);

		c.add(seat_11_Button);
		c.add(seat_12_Button);
		c.add(seat_13_Button);
		c.add(seat_14_Button);
		c.add(seat_15_Button);

		c.add(seat_16_Button);
		c.add(seat_17_Button);
		c.add(seat_18_Button);
		c.add(seat_19_Button);
		c.add(seat_20_Button);

		setSize(710, 400);
		setVisible(true);
	}

}

// TODO 일반Class
class NormalProduct extends JFrame {
	User user = new User();
	ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	ArrayList<ArrayList<JButton>> buttonListList = new ArrayList<ArrayList<JButton>>();
	int buttonListListIndex = 0;
	int visibleButtonIndex = 0;

	public NormalProduct(User u) {
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("일반상품");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 일반Class 이전
		JButton backButton = new JButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new CalculationMain(user);
			}
		});

		// TODO 일반Class 판넬추가 함수(return은 상품의 총 개수를 리턴함)
		int maxIndex = productPanel();

		// TODO 일반Class 각각의 상품 버튼에 마우스리스너 추가
		int index = 0;
		for (int i = 0; i < buttonListList.size(); i++) {
			for (int ii = 0; ii < 8; ii++) {
				buttonListList.get(i).get(ii).addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						JButton j = (JButton) e.getSource();
						String text = j.getText();

						setVisible(false);
						new ProductBuyNum(user, text);
					}
				});
				if (index == maxIndex - 1) {
					break;
				}
				index++;
			}
		}

		// TODO 일반Class 상품목록
		Font productFont = new Font("이텔릭체", Font.PLAIN, 30);
		JLabel ProdcutListTextLabel = new JLabel("상품 목록");
		ProdcutListTextLabel.setFont(productFont);
		ProdcutListTextLabel.setBounds(280, 10, 150, 30);

		// TODO 일반Class 상품페이지
		JLabel productPageLabel = new JLabel("1page | " + String.valueOf(panelList.size()) + "page");
		productPageLabel.setBounds(560, 293, 150, 20);

		// TODO 일반Class 페이지 이전
		JButton pageBackButton = new JButton("이전");
		pageBackButton.setBounds(270, 300, 60, 25);
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
		// TODO 일반Class 페이지 다음
		JButton pageNextButton = new JButton("다음");
		pageNextButton.setBounds(370, 300, 60, 25);
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

		c.add(ProdcutListTextLabel);
		c.add(productPageLabel);
		c.add(backButton);
		c.add(pageBackButton);
		c.add(pageNextButton);

		setSize(710, 400);
		setVisible(true);
	}

	// TODO 일반Class productPanel()
	public int productPanel() {
		String productText = "";
		for (int i = 0; i < user.pos.expirationDate_b.size(); i++) {
			productText += user.pos.expirationDate_b.get(i).getProduct_name() + "  "
					+ user.pos.expirationDate_b.get(i).getProduct_price() + "원/";
		}
		for (int i = 0; i < user.pos.product_b.size(); i++) {
			productText += user.pos.product_b.get(i).getProduct_name() + "  "
					+ user.pos.product_b.get(i).getProduct_price() + "원/";
		}

		String productArr[] = productText.split("/");

		// System.out.println("상품의 총 개수 : " + productArr.length);

		// 생성해야하는 판넬의 개수를 알아내는 코드
		int panelNum = productArr.length / 8;
		if (productArr.length % 8 != 0) {
			panelNum++;
		}

		// 판넬 생성
		for (int i = 0; i < panelNum; i++) {
			panel();
		}

		// 모든 판넬을 안보이도록 설정
		for (int i = 0; i < panelList.size(); i++) {
			super.add(panelList.get(i));
			panelList.get(i).setVisible(false);
		}

		// 버튼 라벨링
		int index = 0;
		for (int i = 0; i < buttonListList.size(); i++) {
			System.out.println((i + 1) + "번 페이지");
			for (int ii = 0; ii < 8; ii++) {
				buttonListList.get(i).get(ii).setText(productArr[index]);
				if (index == productArr.length - 1) {
					break;
				}
				index++;
			}
		}

		// 첫번째 판넬만 보이도록 설정
		panelList.get(0).setVisible(true);
		// 총 상품의 개수 리턴
		return productArr.length;
	}

	// TODO 일반Class Panel()
	public void panel() {
		JPanel productPanel = new JPanel();
		productPanel.setBackground(Color.WHITE);
		productPanel.setBounds(50, 50, 600, 240);
		productPanel.setLayout(null);

		JButton one = new JButton("");
		one.setBounds(10, 10, 270, 50);
		one.setBackground(Color.WHITE);
		JButton two = new JButton("");
		two.setBounds(320, 10, 270, 50);
		two.setBackground(Color.WHITE);
		JButton three = new JButton("");
		three.setBounds(10, 65, 270, 50);
		three.setBackground(Color.WHITE);
		JButton four = new JButton("");
		four.setBounds(320, 65, 270, 50);
		four.setBackground(Color.WHITE);
		JButton five = new JButton("");
		five.setBounds(10, 120, 270, 50);
		five.setBackground(Color.WHITE);
		JButton six = new JButton("");
		six.setBounds(320, 120, 270, 50);
		six.setBackground(Color.WHITE);
		JButton seven = new JButton("");
		seven.setBounds(10, 175, 270, 50);
		seven.setBackground(Color.WHITE);
		JButton eight = new JButton("");
		eight.setBounds(320, 175, 270, 50);
		eight.setBackground(Color.WHITE);

		productPanel.add(one);
		productPanel.add(two);
		productPanel.add(three);
		productPanel.add(four);
		productPanel.add(five);
		productPanel.add(six);
		productPanel.add(seven);
		productPanel.add(eight);

		ArrayList<JButton> a = new ArrayList<JButton>();
		a.add(one);
		a.add(two);
		a.add(three);
		a.add(four);
		a.add(five);
		a.add(six);
		a.add(seven);
		a.add(eight);
		buttonListList.add(a);

		buttonListListIndex += 1;
		panelList.add(productPanel);
	}
}

// TODO 일반상품 구매 수량Class
class ProductBuyNum extends JFrame {
	User user = new User();

	int index;
	boolean expirationProduct;
	String t;
	ProductBuyNum(User u, String text) {
		t= text;
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("일반상품");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 일반상품 수량Class 이전
		JButton backButton = new JButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new CalculationMain(user);
			}
		});
		System.out.println(text);
		index = 0;
		expirationProduct = false;

		System.out.println("들어온 텍스트 : " + text + " 사이즈 | 유통기한 있는 상품 : " + user.pos.expirationDate_b.size()
				+ "개 / 유통기한 없는 상품 : " + user.pos.product_b.size());
		// 유통기한 존재하는 상품인지 확인
		for (int i = 0; i < user.pos.expirationDate_b.size(); i++) {
			System.out.println(user.pos.expirationDate_b.get(i).getProduct_name() + "  "
					+ user.pos.expirationDate_b.get(i).getProduct_price() + "원");

			if (text.equals(user.pos.expirationDate_b.get(i).getProduct_name() + "  "
					+ user.pos.expirationDate_b.get(i).getProduct_price() + "원")) {
				System.out.println("유통기한이 존재하는 상품 들어왔습니다.");
				text = user.pos.expirationDate_b.get(i).getProduct_name() + "  "
						+ user.pos.expirationDate_b.get(i).getProduct_price() + "원";
				index = i;
				expirationProduct = true;
				break;
			}
		}
		// 유통기한이 존재하지 않는 상품인지 확인
		if (expirationProduct == false) {
			for (int i = 0; i < user.pos.product_b.size(); i++) {
				System.out.println(user.pos.product_b.get(i).getProduct_name() + "  "
						+ user.pos.product_b.get(i).getProduct_price() + "원");
				if (text.equals(user.pos.product_b.get(i).getProduct_name() + "  "
						+ user.pos.product_b.get(i).getProduct_price() + "원")) {
							System.out.println("유통기한이 존재하지 않는 상품 들어왔습니다.");
					text = user.pos.product_b.get(i).getProduct_name() + "  "
							+ user.pos.product_b.get(i).getProduct_price() + "원";
					index = i;
					break;
				}
			}
		}

		System.out.println("확인 후 텍스트 : " + text);

		// 수량 입력받는 곳 제목
		JLabel numLabel = new JLabel("수량 : ");
		numLabel.setBounds(80, 70, 50, 30);

		// 수량 입력받는 곳
		JTextField num = new JTextField("1");
		num.setBounds(130, 70, 50, 30);
		num.setEditable(false);

		// +
		JButton plusNum = new JButton("+");
		plusNum.setBackground(Color.WHITE);
		plusNum.setBounds(80, 110, 60, 30);
		plusNum.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 유통기한이 존재하는 상품
				if (expirationProduct == true) {
					System.out.println("유통기한이 존재하는 상품이네요");
					System.out.println(user.pos.expirationDate_b.get(index).getProduct_name() + " "
							+ user.pos.expirationDate_b.get(index).getProduct_num());
					int max = user.pos.expirationDate_b.get(index).getProduct_num();
					int n = Integer.parseInt(num.getText());

					if (max != n) {
						num.setText(String.valueOf(n + 1));
					}
				}
				// 유통기한이 존재하지 않는 상품
				else {
					System.out.println("유통기한이 존재하지 않는 상품이네요");
					System.out.println(user.pos.product_b.get(index).getProduct_name() + " "
							+ user.pos.product_b.get(index).getProduct_num());
					int max = user.pos.product_b.get(index).getProduct_num();
					int n = Integer.parseInt(num.getText());
					if (max != n) {
						num.setText(String.valueOf(n + 1));
					}
				}
			}
		});

		// -
		JButton minusNum = new JButton("-");
		minusNum.setBackground(Color.WHITE);
		minusNum.setBounds(140, 110, 60, 30);
		minusNum.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 유통기한이 존재하는 상품
				if (expirationProduct == false) {
					int n = Integer.parseInt(num.getText());
					if (n != 1) {
						num.setText(String.valueOf(n - 1));
					}
				}
				// 유통기한이 존재하지 않는 상품
				else {
					int n = Integer.parseInt(num.getText());
					if (n != 1) {
						num.setText(String.valueOf(n - 1));
					}
				}
			}
		});

		// 계산하기
		JButton cal = new JButton("계산하기");
		cal.setBackground(Color.WHITE);
		cal.setBounds(230, 60, 100, 50);
		cal.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				int n = Integer.parseInt(num.getText());
				// 유통기한이 존재하는 상품
				if (expirationProduct == true) {
					System.out.println("유통기한이 존재하는 상품의 계산을 진행하겠습니다.");
					user.pos.productBuy(t,n);
					System.out.println(user.pos.report_b.purchaseList.size());

					setVisible(false);
					new CalculationPay(user,t,n);
				}
				// 유통기한이 존재하지 않는 상품
				else {
					System.out.println("유통기한이 존재하지 않는 상품의 계산을 진행하겠습니다.");
					user.pos.productBuy(t,n);
					System.out.println(user.pos.report_b.purchaseList.size());

					setVisible(false);
					new CalculationPay(user,t,n);
				}
			}
		});

		c.add(backButton);
		c.add(numLabel);
		c.add(num);
		c.add(plusNum);
		c.add(minusNum);
		c.add(cal);

		setSize(400, 200);
		setVisible(true);
	}
}

// TODO 좌석상품 계산
class CalculationSeatPay extends JFrame {
	User user = new User();

	public CalculationSeatPay(User u, String productNamePrice, int index) {
		System.out.println("좌석상품 계산하는 폼입니다.");
		System.out.println(productNamePrice + " " + index);
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("결제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 좌석상품계산Class 이전
		JButton backButton = new JButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new Main(user);
			}
		});

		// TODO 좌석상품계산Class 현금
		JButton cashButton = new JButton("현금");
		cashButton.setBounds(40, 50, 150, 80);
		cashButton.setBackground(Color.WHITE);
		cashButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				user.pos.productBuy(productNamePrice, index);
				System.out.println(user.pos.report_b.purchaseList.size());

				calculation(productNamePrice, index);
				setVisible(false);
				new CalculationReceiptCash(user,productNamePrice,index);
			}
		});

		// TODO 좌석상품계산Class 카드
		JButton cardButton = new JButton("카드");
		cardButton.setBounds(200, 50, 150, 80);
		cardButton.setBackground(Color.WHITE);
		cardButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				user.pos.productBuy(productNamePrice, index);
				System.out.println(user.pos.report_b.purchaseList.size());

				calculation(productNamePrice, index);
				setVisible(false);
				new CalculationReceiptCard(user,productNamePrice,index);
			}
		});

		c.add(backButton);
		c.add(cashButton);
		c.add(cardButton);

		setSize(400, 200);
		setVisible(true);
	}

	// TODO 좌석상품 bool 변경
	void calculation(String productNamePrice, int index) {
		int a = 0;
		for (int i = 0; i < user.pos.seatCheck_b.size(); i++) {
			System.out.println(user.pos.seatCheck_b.get(i).getProduct_name());
			if (productNamePrice.equals(user.pos.seatCheck_b.get(i).getProduct_name() + "  "
					+ user.pos.seatCheck_b.get(i).getProduct_price() + "원")) {
				a = i;
			}
		}
		user.pos.seatCheck_b.get(a).setSeetc(index + 1);
		System.out.println("boolean 성공적으로 변경");
	}
}

// TODO 상품계산Class
class CalculationPay extends JFrame {
	User user = new User();

	public CalculationPay(User u,String productNamePrice, int index) {
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("결제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 상품계산Class 이전
		JButton backButton = new JButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new Main(user);
			}
		});

		// TODO 상품계산Class 현금
		JButton cashButton = new JButton("현금");
		cashButton.setBounds(40, 50, 150, 80);
		cashButton.setBackground(Color.WHITE);
		cashButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new CalculationReceiptCash(user, productNamePrice, index);
			}
		});

		// TODO 상품계산Class 카드
		JButton cardButton = new JButton("카드");
		cardButton.setBounds(200, 50, 150, 80);
		cardButton.setBackground(Color.WHITE);
		cardButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new CalculationReceiptCard(user, productNamePrice, index);
			}
		});

		c.add(backButton);
		c.add(cashButton);
		c.add(cardButton);

		setSize(400, 200);
		setVisible(true);
	}
}

// TODO 계산 후 영수증Class(카드)
class CalculationReceiptCard extends JFrame {
	User user = new User();

	CalculationReceiptCard(User u,String productNamePrice,int index) {
		user = u;

		
		System.out.println("카드 영수증 폼입니다.");
		System.out.println(productNamePrice + " " + index);

		int productIndex = 0;
        boolean expirationDate = false;
        boolean product = false;
        boolean seat = false;

        // 유통기한 상품인지 검사
        if(expirationDate == false){
            for(int i = 0; i < user.pos.expirationDate_b.size();i++){
                if(productNamePrice.equals(user.pos.expirationDate_b.get(i).getProduct_name() + "  " + user.pos.expirationDate_b.get(i).getProduct_price()+"원")){
                    productIndex = i;
                    expirationDate = true;
                    break;
                }
            }
        }
        // 유통기한 x 상품인지 검사
        if (product == false){
            for(int i = 0; i < user.pos.product_b.size();i++){
                if(productNamePrice.equals(user.pos.product_b.get(i).getProduct_name() + "  " + user.pos.product_b.get(i).getProduct_price()+"원")){
                    productIndex = i;
                    product = true;
                    break;
                }
            }
        }
        // 좌석상품인지 검사
        if (seat == false){
            for(int i = 0; i < user.pos.seatCheck_b.size();i++){
                if(productNamePrice.equals(user.pos.seatCheck_b.get(i).getProduct_name() + "  " + user.pos.seatCheck_b.get(i).getProduct_price()+"원")){
                    productIndex = i;
                    seat = true;
                    break;
                }
            }
        }

		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("카드 영수증");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		Font shopFont = new Font("Dialog", Font.PLAIN, 35);
		JLabel shopName = new JLabel(user.getName() + "의 영화관");
		shopName.setFont(shopFont);
		shopName.setBounds(225, 10, 300, 50);

		Font cardPayFont = new Font("Dialog", Font.PLAIN, 25);
		JLabel cardPay = new JLabel("카드(고객용)");
		cardPay.setFont(cardPayFont);
		cardPay.setBounds(10, 80, 300, 30);

		JLabel phoneNumber = new JLabel("T-010-9206-9486");
		phoneNumber.setBounds(10, 110, 300, 30);
		JLabel representative = new JLabel("대표이름 : " + user.getName());
		representative.setBounds(10, 130, 300, 30);

		Font e = new Font("Dialog", Font.PLAIN, 15);
		JLabel explanation = new JLabel("소비자와 함께하는 "+ user.getName() +"대표입니다.");
		JLabel explanation1 = new JLabel("환불은 반드시 영수증을 지참하여");
		JLabel explanation2 = new JLabel("환불을 진행하셔야 어려움이 없습니다.");
		JLabel explanation3 = new JLabel("영수증을 잃어버리거나 환불 번호를 잊는다면");
		JLabel explanation4 = new JLabel("환불이 불가할 수 있으니 주의하시길 바라겠습니다.");
		explanation.setFont(e);
		explanation1.setFont(e);
		explanation2.setFont(e);
		explanation3.setFont(e);
		explanation4.setFont(e);
		explanation.setBounds(10, 200, 400, 30);
		explanation1.setBounds(10, 225, 400, 30);
		explanation2.setBounds(10, 250, 400, 30);
		explanation3.setBounds(10, 275, 400, 30);
		explanation4.setBounds(10, 300, 400, 30);

		Date date = new Date();
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy-MM-dd/HH-mm-ss");
		SimpleDateFormat refundFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String t = yearFormat.format(date);
		String r = refundFormat.format(date);

		JLabel time = new JLabel(t);
		time.setBounds(200, 110, 200, 30);

		Font f1 = new Font("Serif", Font.PLAIN, 20);
		JLabel refundNumber = new JLabel("환불번호 : " + r);
		refundNumber.setBounds(200, 130, 200, 30);

		JLabel productName = new JLabel("이름   : ");
		productName.setBounds(470, 110, 200, 30);
		productName.setFont(f1);
		JLabel productNum = new JLabel("수량   : ");
		productNum.setBounds(470, 130, 200, 30);
		productNum.setFont(f1);
		JLabel x = new JLabel("-----------------------------");
		x.setBounds(470, 160, 300, 30);
		x.setFont(f1);
		JLabel price = new JLabel("가격   : ");
		price.setBounds(470, 190, 200, 30);
		price.setFont(f1);
		JLabel discountPrice = new JLabel("할인금액 : ");
		discountPrice.setBounds(470, 220, 200, 30);
		discountPrice.setFont(f1);
		JLabel surtax = new JLabel("부과세  : ");
		surtax.setBounds(470, 250, 200, 30);
		surtax.setFont(f1);
		JLabel resultPrice = new JLabel("총합   : ");
		resultPrice.setBounds(470, 280, 200, 30);
		resultPrice.setFont(f1);

		JButton mainButton = new JButton("메인");
		mainButton.setBounds(630, 10, 60, 25);
		mainButton.setBackground(Color.WHITE);
		mainButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new Main(user);
			}
		});

		// 유통기한 o 상품
		if(expirationDate == true){
			System.out.println("유통기한이 존재하는 상품이라 판단 영수증을 출력하겠습니다.");
			productName.setText("이름   : " + user.pos.expirationDate_b.get(productIndex).getProduct_name());
			productNum.setText("수량   : " + index);

			int resultPriceNum = Integer.valueOf(user.pos.expirationDate_b.get(productIndex).getProduct_price() * index);
			int costPriceNum = (int)(resultPriceNum/1.1);
			int surtaxNum =  resultPriceNum - costPriceNum;

			price.setText("가격   : " + costPriceNum + "원");
			surtax.setText("부과세  : " + surtaxNum + "원");
			resultPrice.setText("총합   : " + resultPriceNum + "원");
		}
		// 유통기한 x 상품
		if(product == true){
			System.out.println("유통기한이 존재하지 않는 상품이라 판단 영수증을 출력하겠습니다.");
			productName.setText("이름   : " + user.pos.product_b.get(productIndex).getProduct_name());
			productNum.setText("수량   : " + index);

			int resultPriceNum = Integer.valueOf(user.pos.product_b.get(productIndex).getProduct_price() * index);
			int costPriceNum = (int)(resultPriceNum/1.1);
			int surtaxNum =  resultPriceNum - costPriceNum;

			price.setText("가격   : " + costPriceNum + "원");
			surtax.setText("부과세  : " + surtaxNum + "원");
			resultPrice.setText("총합   : " + resultPriceNum + "원");
		}
		// 좌석 상품
		if (seat == true){
			System.out.println("좌석 상품이라고 판단 영수증을 출력하겠습니다.");
			productName.setText("이름   : " + user.pos.seatCheck_b.get(productIndex).getProduct_name());
			productNum.setText("좌석번호 : " + index);

			int resultPriceNum = Integer.valueOf(user.pos.seatCheck_b.get(productIndex).getProduct_price());
			int costPriceNum = (int)(resultPriceNum/1.1);
			int surtaxNum =  resultPriceNum - costPriceNum;

			price.setText("가격   : " + costPriceNum + "원");
			surtax.setText("부과세  : " + surtaxNum + "원");
			resultPrice.setText("총합   : " + resultPriceNum + "원");
		}

		c.add(shopName);
		c.add(cardPay);
		c.add(phoneNumber);
		c.add(representative);
		c.add(explanation);
		c.add(explanation1);
		c.add(explanation2);
		c.add(explanation3);
		c.add(explanation4);
		c.add(time);
		c.add(refundNumber);
		c.add(productName);
		c.add(productNum);
		c.add(x);
		c.add(price);
		c.add(discountPrice);
		c.add(surtax);
		c.add(resultPrice);
		c.add(mainButton);

		setSize(710, 400);
		setVisible(true);
	}

}

// TODO 계산 후 영수증Class(현금)
class CalculationReceiptCash extends JFrame {
	User user = new User();

	CalculationReceiptCash(User u,String productNamePrice,int index) {
		user = u;
		System.out.println("현금 영수증 폼입니다.");
		System.out.println(productNamePrice + " " + index);

		int productIndex = 0;
        boolean expirationDate = false;
        boolean product = false;
        boolean seat = false;

        // 유통기한 상품인지 검사
        if(expirationDate == false){
            for(int i = 0; i < user.pos.expirationDate_b.size();i++){
                if(productNamePrice.equals(user.pos.expirationDate_b.get(i).getProduct_name() + "  " + user.pos.expirationDate_b.get(i).getProduct_price()+"원")){
                    productIndex = i;
                    expirationDate = true;
                    break;
                }
            }
        }
        // 유통기한 x 상품인지 검사
        if (product == false){
            for(int i = 0; i < user.pos.product_b.size();i++){
                if(productNamePrice.equals(user.pos.product_b.get(i).getProduct_name() + "  " + user.pos.product_b.get(i).getProduct_price()+"원")){
                    productIndex = i;
                    product = true;
                    break;
                }
            }
        }
        // 좌석상품인지 검사
        if (seat == false){
            for(int i = 0; i < user.pos.seatCheck_b.size();i++){
                if(productNamePrice.equals(user.pos.seatCheck_b.get(i).getProduct_name() + "  " + user.pos.seatCheck_b.get(i).getProduct_price()+"원")){
                    productIndex = i;
                    seat = true;
                    break;
                }
            }
        }
		
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("카드 영수증");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		Font shopFont = new Font("Dialog", Font.PLAIN, 35);
		JLabel shopName = new JLabel(user.getName() + "의 영화관");
		shopName.setFont(shopFont);
		shopName.setBounds(225, 10, 300, 50);

		Font cardPayFont = new Font("Dialog", Font.PLAIN, 25);
		JLabel cardPay = new JLabel("현금(소득공제용)");
		cardPay.setFont(cardPayFont);
		cardPay.setBounds(10, 80, 300, 30);

		JLabel phoneNumber = new JLabel("T-010-9206-9486");
		phoneNumber.setBounds(10, 110, 300, 30);
		JLabel representative = new JLabel("대표이름 : " + user.getName());
		representative.setBounds(10, 130, 300, 30);

		Font e = new Font("Dialog", Font.PLAIN, 15);
		JLabel explanation = new JLabel("소비자와 함께하는 " + user.getName() + "대표입니다.");
		JLabel explanation1 = new JLabel("환불은 반드시 영수증을 지참하여");
		JLabel explanation2 = new JLabel("환불을 진행하셔야 어려움이 없습니다.");
		JLabel explanation3 = new JLabel("영수증을 잃어버리거나 환불 번호를 잊는다면");
		JLabel explanation4 = new JLabel("환불이 불가할 수 있으니 주의하시길 바라겠습니다.");
		explanation.setFont(e);
		explanation1.setFont(e);
		explanation2.setFont(e);
		explanation3.setFont(e);
		explanation4.setFont(e);
		explanation.setBounds(10, 200, 400, 30);
		explanation1.setBounds(10, 225, 400, 30);
		explanation2.setBounds(10, 250, 400, 30);
		explanation3.setBounds(10, 275, 400, 30);
		explanation4.setBounds(10, 300, 400, 30);

		Date date = new Date();
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy-MM-dd/HH-mm-ss");
		SimpleDateFormat refundFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String t = yearFormat.format(date);
		String r = refundFormat.format(date);

		JLabel time = new JLabel(t);
		time.setBounds(200, 110, 200, 30);

		Font f1 = new Font("Serif", Font.PLAIN, 20);
		JLabel refundNumber = new JLabel("환불번호 : " + r);
		refundNumber.setBounds(200, 130, 200, 30);

		JLabel productName = new JLabel("이름   : ");
		productName.setBounds(470, 110, 200, 30);
		productName.setFont(f1);
		JLabel productNum = new JLabel("수량   : ");
		productNum.setBounds(470, 130, 200, 30);
		productNum.setFont(f1);
		JLabel x = new JLabel("-----------------------------");
		x.setBounds(470, 160, 300, 30);
		x.setFont(f1);
		JLabel price = new JLabel("가격   : ");
		price.setBounds(470, 190, 200, 30);
		price.setFont(f1);
		JLabel discountPrice = new JLabel("할인금액 : ");
		discountPrice.setBounds(470, 220, 200, 30);
		discountPrice.setFont(f1);
		JLabel surtax = new JLabel("부과세  : ");
		surtax.setBounds(470, 250, 200, 30);
		surtax.setFont(f1);
		JLabel resultPrice = new JLabel("총합   : ");
		resultPrice.setBounds(470, 280, 200, 30);
		resultPrice.setFont(f1);

		JButton mainButton = new JButton("메인");
		mainButton.setBounds(630, 10, 60, 25);
		mainButton.setBackground(Color.WHITE);
		mainButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new Main(user);
			}
		});

		// 유통기한 o 상품
		if(expirationDate == true){
			System.out.println("유통기한이 존재하는 상품이라 판단 영수증을 출력하겠습니다.");
			productName.setText("이름   : " + user.pos.expirationDate_b.get(productIndex).getProduct_name());
			productNum.setText("수량   : " + index);

			int resultPriceNum = Integer.valueOf(user.pos.expirationDate_b.get(productIndex).getProduct_price() * index);
			int costPriceNum = (int)(resultPriceNum/1.1);
			int surtaxNum =  resultPriceNum - costPriceNum;

			price.setText("가격   : " + costPriceNum + "원");
			surtax.setText("부과세  : " + surtaxNum + "원");
			resultPrice.setText("총합   : " + resultPriceNum + "원");
		}
		// 유통기한 x 상품
		if(product == true){
			System.out.println("유통기한이 존재하지 않는 상품이라고 판단 영수증을 출력하겠습니다.");
			productName.setText("이름   : " + user.pos.product_b.get(productIndex).getProduct_name());
			productNum.setText("수량   : " + index);

			int resultPriceNum = Integer.valueOf(user.pos.product_b.get(productIndex).getProduct_price() * index);
			int costPriceNum = (int)(resultPriceNum/1.1);
			int surtaxNum =  resultPriceNum - costPriceNum;

			price.setText("가격   : " + costPriceNum + "원");
			surtax.setText("부과세  : " + surtaxNum + "원");
			resultPrice.setText("총합   : " + resultPriceNum + "원");
		}
		// 좌석 상품
		if (seat == true){
			System.out.println("좌석 상품이라고 판단 영수증을 출력하겠습니다.");
			productName.setText("이름   : " + user.pos.seatCheck_b.get(productIndex).getProduct_name());
			productNum.setText("좌석번호 : " + index);

			int resultPriceNum = Integer.valueOf(user.pos.seatCheck_b.get(productIndex).getProduct_price());
			int costPriceNum = (int)(resultPriceNum/1.1);
			int surtaxNum =  resultPriceNum - costPriceNum;

			price.setText("가격   : " + costPriceNum + "원");
			surtax.setText("부과세  : " + surtaxNum + "원");
			resultPrice.setText("총합   : " + resultPriceNum + "원");
		}

		c.add(shopName);
		c.add(cardPay);
		c.add(phoneNumber);
		c.add(representative);
		c.add(explanation);
		c.add(explanation1);
		c.add(explanation2);
		c.add(explanation3);
		c.add(explanation4);
		c.add(time);
		c.add(refundNumber);
		c.add(productName);
		c.add(productNum);
		c.add(x);
		c.add(price);
		c.add(discountPrice);
		c.add(surtax);
		c.add(resultPrice);
		c.add(mainButton);

		setSize(710, 400);
		setVisible(true);
	}
}
// 1,100,000(합계금액) / 1.1 = 1,000,000(공급가액)

public class Calculation {
	public static void main(String[] args) {
		User u = new User();
		new ProductBuyNum(u, "ㅇㅇ");
	}
}