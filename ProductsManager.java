import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import posProject.ExpirationDate_b;
import posProject.Product_b;
import posProject.SeatCheck_b;

import java.util.*;

// TODO 상품선택Class
class ProductsManager_Main extends JFrame {
	// TODO 정보
	User user = new User();

	ProductsManager_Main(User u) {
		System.out.println("물품 관리 폼");
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("물품 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 이전
		RoundedButton backButton = new RoundedButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new Main(user);
			}
		});

		// TODO 좌석상품
		RoundedButton seatButton = new RoundedButton("좌석 상품");
		seatButton.setBounds(40, 50, 150, 80);
		seatButton.setBackground(Color.WHITE);
		seatButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new SeatProductManager(user);
			}
		});

		// TODO 일반상품
		RoundedButton normalButton = new RoundedButton("일반 상품");
		normalButton.setBounds(200, 50, 150, 80);
		normalButton.setBackground(Color.WHITE);
		normalButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new NormalProductManager(user);
			}
		});

		c.add(backButton);
		c.add(seatButton);
		c.add(normalButton);

		backgroundImage();

		setSize(400, 200);
		setVisible(true);
	}

	public void backgroundImage() {
		JLabel background = new JLabel();
        background = new JLabel(new ImageIcon("images/image_4.jpg"));
		background.setBounds(0, 0, 400, 200);
		super.add(background);
	}
}

// TODO 좌석상품Class
class SeatProductManager extends JFrame {
	// TODO 좌석상품 정보
	User user = new User();
	ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	ArrayList<ArrayList<JButton>> buttonListList = new ArrayList<ArrayList<JButton>>();
	int buttonListListIndex = 0;
	int visibleButtonIndex = 0;

	public SeatProductManager(User u) {
		System.out.println("좌석상품 폼");
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
		RoundedButton backButton = new RoundedButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductsManager_Main(user);
			}
		});

		// TODO 좌석상품 상품추가
		RoundedButton newProductButton = new RoundedButton("상품추가");
		newProductButton.setBounds(600, 10, 90, 25);
		newProductButton.setBackground(Color.WHITE);
		newProductButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new seatProductAdd(user);
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
						new SeatInformation(user, productNamePrice);
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
		RoundedButton pageBackButton = new RoundedButton("이전");
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
		RoundedButton pageNextButton = new RoundedButton("다음");
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
		c.add(newProductButton);
		c.add(pageBackButton);
		c.add(pageNextButton);

		backgroundImage();

		setSize(710, 400);
		setVisible(true);
	}

	public void backgroundImage() {
		JLabel background = new JLabel();
        background = new JLabel(new ImageIcon("images/image_2.jpg"));
		background.setBounds(0, 0, 710, 400);
		super.add(background);
	}

	// TODO 좌석상품 productPanel()
	public int productPanel() {
		// String productText = "홈런볼 1300원/와 2500원/고구마 3000원";
		String productText = "";
		for (int i = 0; i < user.pos.seatCheck_b.size(); i++) {
			productText += user.pos.seatCheck_b.get(i).getProduct_name() + "  "
					+ user.pos.seatCheck_b.get(i).getProduct_price() + "원/";
		}

		System.out.println(productText);

		// /을 구분자로 잘라서 productArr에 저장
		String productArr[] = productText.split("/");

		System.out.println("상품의 총 개수 : " + productArr.length);

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

// TODO 일반상품Class
class NormalProductManager extends JFrame {
	// TODO 일반상품 정보
	User user = new User();
	ArrayList<JPanel> panelList = new ArrayList<JPanel>();
	ArrayList<ArrayList<JButton>> buttonListList = new ArrayList<ArrayList<JButton>>();
	int buttonListListIndex = 0;
	int visibleButtonIndex = 0;

	public NormalProductManager(User u) {
		System.out.println("일반상품 폼");
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

		// TODO 일반상품 이전
		RoundedButton backButton = new RoundedButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductsManager_Main(user);
			}
		});

		// TODO 일반상품 상품추가
		RoundedButton newProductButton = new RoundedButton("상품추가");
		newProductButton.setBounds(600, 10, 90, 25);
		newProductButton.setBackground(Color.WHITE);
		newProductButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductAddChoice(user);
			}
		});

		// TODO 일반상품 판넬추가 함수(return은 상품의 총 개수를 리턴함)
		int maxIndex = productPanel();

		// TODO 일반상품 각각의 상품 버튼에 마우스리스너 추가
		int index = 0;
		for (int i = 0; i < buttonListListIndex; i++) {
			for (int ii = 0; ii < 8; ii++) {
				buttonListList.get(i).get(ii).addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						JButton b = (JButton) e.getSource();
						String productNamePrice = b.getText();

						setVisible(false);
						new ProductInformation(user, productNamePrice);
					}
				});
				if (index == maxIndex - 1) {
					break;
				}
				index++;
			}
		}

		// TODO 일반상품 상품목록
		Font productFont = new Font("이텔릭체", Font.PLAIN, 30);
		JLabel ProdcutListTextLabel = new JLabel("상품 목록");
		ProdcutListTextLabel.setFont(productFont);
		ProdcutListTextLabel.setBounds(265, 10, 150, 30);

		// TODO 일반상품 상품페이지
		JLabel productPageLabel = new JLabel("1page | " + String.valueOf(panelList.size()) + "page");
		productPageLabel.setBounds(560, 293, 150, 20);

		// TODO 일반상품 페이지 이전
		RoundedButton pageBackButton = new RoundedButton("이전");
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
		// TODO 일반상품 페이지 다음
		RoundedButton pageNextButton = new RoundedButton("다음");
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
		c.add(newProductButton);
		c.add(pageBackButton);
		c.add(pageNextButton);

		backgroundImage();

		setSize(710, 400);
		setVisible(true);
	}

	public void backgroundImage() {
		JLabel background = new JLabel();
        background = new JLabel(new ImageIcon("images/image_2.jpg"));
		background.setBounds(0, 0, 710, 400);
		super.add(background);
	}

	// TODO 일반상품 productPanel()
	public int productPanel() {
		String productText = "";

		// 일반상품 모두 하나의 String에 담음
		for (int i = 0; i < user.pos.expirationDate_b.size(); i++) {
			productText += user.pos.expirationDate_b.get(i).getProduct_name() + "  "
					+ user.pos.expirationDate_b.get(i).getProduct_price() + "원/";
		}
		for (int i = 0; i < user.pos.product_b.size(); i++) {
			productText += user.pos.product_b.get(i).getProduct_name() + "  "
					+ user.pos.product_b.get(i).getProduct_price() + "원/";
		}

		// 위 코드에서 가지고있는 String 변수를 /를 구분자로 잘라 배열에 저장
		String productArr[] = productText.split("/");
		System.out.println("상품의 총 개수 : " + productArr.length);

		// 생성해야하는 판넬의 개수를 가져오는 코드
		int panelNum = productArr.length / 8;
		if (productArr.length % 8 != 0) {
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
			for (int ii = 0; ii < 8; ii++) {
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

// TODO 좌석상품추가Class
class seatProductAdd extends JFrame {
	// TODO 상품추가 정보
	User user = new User();

	boolean p = false;
	boolean up = false;
	boolean d = false;

	seatProductAdd(User u) {
		System.out.println("상품 추가 폼");

		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("상품 추가");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 상품상세정보 이전
		RoundedButton backButton = new RoundedButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductsManager_Main(user);
			}
		});

		Font font = new Font("이텔릭체", Font.PLAIN, 20);

		JLabel pNameLabel = new JLabel("영화이름");
		pNameLabel.setBounds(90, 30, 200, 30);
		pNameLabel.setFont(font);
		JTextField pNameTextField = new JTextField();
		pNameTextField.setBounds(90, 60, 400, 30);

		JLabel pPriceLabel = new JLabel("영화가격");
		pPriceLabel.setBounds(90, 90, 200, 30);
		pPriceLabel.setFont(font);
		JTextField pPriceTextField = new JTextField();
		pPriceTextField.setBounds(90, 120, 400, 30);

		JLabel puPriceLabel = new JLabel("영화단가");
		puPriceLabel.setBounds(90, 150, 200, 30);
		puPriceLabel.setFont(font);
		JTextField pUPriceteTextField = new JTextField();
		pUPriceteTextField.setBounds(90, 180, 400, 30);

		JLabel pDescriptionLabel = new JLabel("영화설명");
		pDescriptionLabel.setBounds(90, 210, 200, 30);
		pDescriptionLabel.setFont(font);
		JTextField pDescriptionTextField = new JTextField();
		pDescriptionTextField.setBounds(90, 240, 400, 30);

		JLabel pDiscountLabel = new JLabel("할인율");
		pDiscountLabel.setBounds(90, 270, 200, 30);
		pDiscountLabel.setFont(font);
		JTextField pDiscountTextField = new JTextField();
		pDiscountTextField.setBounds(90, 300, 400, 30);

		// TODO 좌석상품 추가
		RoundedButton newProductButton = new RoundedButton("상품추가");
		newProductButton.setBounds(600, 10, 90, 25);
		newProductButton.setBackground(Color.WHITE);
		newProductButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String name = pNameTextField.getText();
				String price = pPriceTextField.getText();
				String uprice = pUPriceteTextField.getText();
				String description = pDescriptionTextField.getText();
				String discount = pDiscountTextField.getText();

				// String int int int String int
				int priceNum = priceNumberFormatException(price);
				int upriceNum = uPriceNumberFormatException(uprice, price);
				int discountNum = discountNumberFormatException(discount);

				if (p == true && up == true && d == true) {
					SeatCheck_b s = new SeatCheck_b(name, priceNum, upriceNum, description, discountNum);
					user.pos.seatCheck_b.add(s);

					JOptionPane.showMessageDialog(null, "좌석상품이 추가되었습니다.");
					setVisible(false);
					new Main(user);
				}
			}
		});

		c.add(backButton);
		c.add(pNameLabel);
		c.add(pNameTextField);
		c.add(pPriceLabel);
		c.add(pPriceTextField);
		c.add(puPriceLabel);
		c.add(pUPriceteTextField);
		c.add(pDescriptionLabel);
		c.add(pDescriptionTextField);
		c.add(pDiscountLabel);
		c.add(pDiscountTextField);
		c.add(newProductButton);

		backgroundImage();

		setSize(710, 400);
		setVisible(true);
	}

	public void backgroundImage() {
		JLabel background = new JLabel();
        background = new JLabel(new ImageIcon("images/image_2.jpg"));
		background.setBounds(0, 0, 710, 400);
		super.add(background);
	}

	public int priceNumberFormatException(String text) {
		int num = 0;
		try {
			num = Integer.parseInt(text);
			p = true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "가격은 정수형으로 해주세요 ex)1000");
			p = false;
		}
		return num;
	}

	public int uPriceNumberFormatException(String text, String text2) {
		int num = 0;
		int num2 = 0;
		try {
			num = Integer.parseInt(text);
			num2 = Integer.parseInt(text2);

			if (num > num2) {
				JOptionPane.showMessageDialog(null, "단가는 가격보다 높을 수 없습니다.");
				up = false;
			} else {
				up = true;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "단가는 정수형으로 해주세요 ex)1000");
			up = false;
		}
		return num;
	}

	public int discountNumberFormatException(String text) {
		int num = 0;
		try {
			num = Integer.parseInt(text);
			if (num < 1 && num > 100) {
				JOptionPane.showMessageDialog(null, "할인율은 1~100 사이여야 합니다.");
			} else {
				d = true;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "할인율은 정수형으로 해주세요 ex)50");
			d = false;
		}
		return num;
	}
}

// TODO 상품 추가 선택 폼Class
class ProductAddChoice extends JFrame {
	User user = new User();

	ProductAddChoice(User u) {
		user = u;
		System.out.println("상품 추가 선택 폼");
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("상품 추가 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 상품상세정보 이전
		RoundedButton backButton = new RoundedButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductsManager_Main(user);
			}
		});

		// TODO 유통기한 상품
		RoundedButton seatButton = new RoundedButton("유통기한 상품");
		seatButton.setBounds(40, 50, 150, 80);
		seatButton.setBackground(Color.WHITE);
		seatButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductAddExpiration(user);
			}
		});

		// TODO 일반상품
		RoundedButton normalButton = new RoundedButton("일반 상품");
		normalButton.setBounds(200, 50, 150, 80);
		normalButton.setBackground(Color.WHITE);
		normalButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductAddNormal(user);
			}
		});

		c.add(backButton);
		c.add(seatButton);
		c.add(normalButton);

		backgroundImage();

		setSize(400, 200);
		setVisible(true);
	}

	public void backgroundImage() {
		JLabel background = new JLabel();
        background = new JLabel(new ImageIcon("images/image_4.jpg"));
		background.setBounds(0, 0, 400, 200);
		super.add(background);
	}
}

// TODO 유통기한 상품 추가Class
class ProductAddExpiration extends JFrame {
	// String int int int String int String
	// TODO 상품추가 정보
	User user = new User();

	boolean p = false;
	boolean n = false;
	boolean up = false;
	boolean d = false;

	ProductAddExpiration(User u) {
		System.out.println("유통기한 추가 폼");

		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("상품 추가");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 상품상세정보 이전
		RoundedButton backButton = new RoundedButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductsManager_Main(user);
			}
		});

		Font font = new Font("이텔릭체", Font.PLAIN, 15);

		JLabel pNameLabel = new JLabel("상품이름");
		pNameLabel.setBounds(90, 10, 200, 20);
		pNameLabel.setFont(font);
		JTextField pNameTextField = new JTextField();
		pNameTextField.setBounds(90, 30, 400, 30);

		JLabel pPriceLabel = new JLabel("상품가격");
		pPriceLabel.setBounds(90, 60, 200, 20);
		pPriceLabel.setFont(font);
		JTextField pPriceTextField = new JTextField();
		pPriceTextField.setBounds(90, 80, 400, 30);

		JLabel pNumLabel = new JLabel("상품수량");
		pNumLabel.setBounds(90, 110, 200, 20);
		pNumLabel.setFont(font);
		JTextField pNumTextField = new JTextField();
		pNumTextField.setBounds(90, 130, 400, 30);

		JLabel puPriceLabel = new JLabel("상품단가");
		puPriceLabel.setBounds(90, 160, 200, 20);
		puPriceLabel.setFont(font);
		JTextField pUPriceteTextField = new JTextField();
		pUPriceteTextField.setBounds(90, 180, 400, 30);

		JLabel pDescriptionLabel = new JLabel("상품설명");
		pDescriptionLabel.setBounds(90, 210, 200, 20);
		pDescriptionLabel.setFont(font);
		JTextField pDescriptionTextField = new JTextField();
		pDescriptionTextField.setBounds(90, 230, 400, 30);

		JLabel pDiscountLabel = new JLabel("할인율");
		pDiscountLabel.setBounds(90, 260, 200, 20);
		pDiscountLabel.setFont(font);
		JTextField pDiscountTextField = new JTextField();
		pDiscountTextField.setBounds(90, 280, 400, 30);

		JLabel expriationLabel = new JLabel("유통기한 ex)1998년03월08일");
		expriationLabel.setBounds(90, 310, 400, 30);
		expriationLabel.setFont(font);

		JLabel yearLabel = new JLabel("년");
		yearLabel.setBounds(150, 330, 20, 30);
		JTextField yearTextField = new JTextField();
		yearTextField.setBounds(90, 330, 50, 30);
		JLabel monthLabel = new JLabel("월");
		monthLabel.setBounds(240, 330, 50, 30);
		JTextField monthTextField = new JTextField();
		monthTextField.setBounds(180, 330, 50, 30);
		JLabel dayLabel = new JLabel("일");
		dayLabel.setBounds(330, 330, 50, 30);
		JTextField dayTextField = new JTextField();
		dayTextField.setBounds(270, 330, 50, 30);

		// TODO 일반상품 추가
		RoundedButton newProductButton = new RoundedButton("상품추가");
		newProductButton.setBounds(600, 10, 90, 25);
		newProductButton.setBackground(Color.WHITE);
		newProductButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String name = pNameTextField.getText();
				String price = pPriceTextField.getText();
				String num = pNumTextField.getText();
				String uprice = pUPriceteTextField.getText();
				String description = pDescriptionTextField.getText();
				String discount = pDiscountTextField.getText();
				String yearMonthDay = yearTextField.getText() + monthTextField.getText() + dayTextField.getText();

				// String int int int String int
				int priceNum = priceNumberFormatException(price);
				int numNum = numNumberFormatException(num);
				int upriceNum = uPriceNumberFormatException(uprice, price);
				int discountNum = discountNumberFormatException(discount);

				if (p == true && up == true && d == true) {
					ExpirationDate_b s = new ExpirationDate_b(name, priceNum, numNum, upriceNum, description,
							discountNum, yearMonthDay);
					user.pos.expirationDate_b.add(s);

					JOptionPane.showMessageDialog(null, "유통기한 상품이 추가되었습니다.");
					setVisible(false);
					new Main(user);
				}
			}
		});

		c.add(backButton);
		c.add(pNameLabel);
		c.add(pNameTextField);
		c.add(pPriceLabel);
		c.add(pPriceTextField);
		c.add(pNumLabel);
		c.add(pNumTextField);
		c.add(puPriceLabel);
		c.add(pUPriceteTextField);
		c.add(pDescriptionLabel);
		c.add(pDescriptionTextField);
		c.add(pDiscountLabel);
		c.add(pDiscountTextField);
		c.add(newProductButton);
		c.add(expriationLabel);
		c.add(yearLabel);
		c.add(yearTextField);
		c.add(monthLabel);
		c.add(monthTextField);
		c.add(dayLabel);
		c.add(dayTextField);

		backgroundImage();

		setSize(710, 400);
		setVisible(true);
	}

	public void backgroundImage() {
		JLabel background = new JLabel();
        background = new JLabel(new ImageIcon("images/image_2.jpg"));
		background.setBounds(0, 0, 710, 400);
		super.add(background);
	}

	public int priceNumberFormatException(String text) {
		int num = 0;
		try {
			num = Integer.parseInt(text);
			p = true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "가격은 정수형으로 해주세요 ex)1000");
			p = false;
		}
		return num;
	}

	public int numNumberFormatException(String text) {
		int num = 0;
		try {
			num = Integer.parseInt(text);
			n = true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "수량은 정수형으로 해주세요 ex)100");
			n = false;
		}
		return num;
	}

	public int uPriceNumberFormatException(String text, String text2) {
		int num = 0;
		int num2 = 0;
		try {
			num = Integer.parseInt(text);
			num2 = Integer.parseInt(text2);

			if (num > num2) {
				JOptionPane.showMessageDialog(null, "단가는 가격보다 높을 수 없습니다.");
				up = false;
			} else {
				up = true;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "단가는 정수형으로 해주세요 ex)1000");
			up = false;
		}
		return num;
	}

	public int discountNumberFormatException(String text) {
		int num = 0;
		try {
			num = Integer.parseInt(text);
			if (num < 1 && num > 100) {
				JOptionPane.showMessageDialog(null, "할인율은 1~100 사이여야 합니다.");
			} else {
				d = true;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "할인율은 정수형으로 해주세요 ex)50");
			d = false;
		}
		return num;
	}

}

// TODO 일반상품추가 Class
class ProductAddNormal extends JFrame {
	// String int int int String int String
	// TODO 상품추가 정보
	User user = new User();

	boolean p = false;
	boolean n = false;
	boolean up = false;
	boolean d = false;

	ProductAddNormal(User u) {
		System.out.println("일반상품 추가 폼");

		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("상품 추가");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 상품상세정보 이전
		RoundedButton backButton = new RoundedButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductsManager_Main(user);
			}
		});

		Font font = new Font("이텔릭체", Font.PLAIN, 15);

		JLabel pNameLabel = new JLabel("상품이름");
		pNameLabel.setBounds(90, 10, 200, 20);
		pNameLabel.setFont(font);
		JTextField pNameTextField = new JTextField();
		pNameTextField.setBounds(90, 30, 400, 30);

		JLabel pPriceLabel = new JLabel("상품가격");
		pPriceLabel.setBounds(90, 60, 200, 20);
		pPriceLabel.setFont(font);
		JTextField pPriceTextField = new JTextField();
		pPriceTextField.setBounds(90, 80, 400, 30);

		JLabel pNumLabel = new JLabel("상품수량");
		pNumLabel.setBounds(90, 110, 200, 20);
		pNumLabel.setFont(font);
		JTextField pNumTextField = new JTextField();
		pNumTextField.setBounds(90, 130, 400, 30);

		JLabel puPriceLabel = new JLabel("상품단가");
		puPriceLabel.setBounds(90, 160, 200, 20);
		puPriceLabel.setFont(font);
		JTextField pUPriceteTextField = new JTextField();
		pUPriceteTextField.setBounds(90, 180, 400, 30);

		JLabel pDescriptionLabel = new JLabel("상품설명");
		pDescriptionLabel.setBounds(90, 210, 200, 20);
		pDescriptionLabel.setFont(font);
		JTextField pDescriptionTextField = new JTextField();
		pDescriptionTextField.setBounds(90, 230, 400, 30);

		JLabel pDiscountLabel = new JLabel("할인율");
		pDiscountLabel.setBounds(90, 260, 200, 20);
		pDiscountLabel.setFont(font);
		JTextField pDiscountTextField = new JTextField();
		pDiscountTextField.setBounds(90, 280, 400, 30);

		// TODO 일반상품 추가
		RoundedButton newProductButton = new RoundedButton("상품추가");
		newProductButton.setBounds(600, 10, 90, 25);
		newProductButton.setBackground(Color.WHITE);
		newProductButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String name = pNameTextField.getText();
				String price = pPriceTextField.getText();
				String num = pNumTextField.getText();
				String uprice = pUPriceteTextField.getText();
				String description = pDescriptionTextField.getText();
				String discount = pDiscountTextField.getText();

				// String int int int String int
				int priceNum = priceNumberFormatException(price);
				int numNum = numNumberFormatException(num);
				int upriceNum = uPriceNumberFormatException(uprice, price);
				int discountNum = discountNumberFormatException(discount);

				if (p == true && n == true && up == true && d == true) {
					Product_b s = new Product_b(name, priceNum, numNum, upriceNum, description, discountNum);
					user.pos.product_b.add(s);

					JOptionPane.showMessageDialog(null, "일반상품이 추가되었습니다.");
					setVisible(false);
					new Main(user);
				}
			}
		});

		c.add(backButton);
		c.add(pNameLabel);
		c.add(pNameTextField);
		c.add(pPriceLabel);
		c.add(pPriceTextField);
		c.add(pNumLabel);
		c.add(pNumTextField);
		c.add(puPriceLabel);
		c.add(pUPriceteTextField);
		c.add(pDescriptionLabel);
		c.add(pDescriptionTextField);
		c.add(pDiscountLabel);
		c.add(pDiscountTextField);
		c.add(newProductButton);

		backgroundImage();

		setSize(710, 400);
		setVisible(true);
	}

	public void backgroundImage() {
		JLabel background = new JLabel();
        background = new JLabel(new ImageIcon("images/image_2.jpg"));
		background.setBounds(0, 0, 710, 400);
		super.add(background);
	}

	public int priceNumberFormatException(String text) {
		int num = 0;
		try {
			num = Integer.parseInt(text);
			p = true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "가격은 정수형으로 해주세요 ex)1000");
			p = false;
		}
		return num;
	}

	public int numNumberFormatException(String text) {
		int num = 0;
		try {
			num = Integer.parseInt(text);
			n = true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "수량은 정수형으로 해주세요 ex)100");
			n = false;
		}
		return num;
	}

	public int uPriceNumberFormatException(String text, String text2) {
		int num = 0;
		int num2 = 0;
		try {
			num = Integer.parseInt(text);
			num2 = Integer.parseInt(text2);

			if (num > num2) {
				JOptionPane.showMessageDialog(null, "단가는 가격보다 높을 수 없습니다.");
				up = false;
			} else {
				up = true;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "단가는 정수형으로 해주세요 ex)1000");
			up = false;
		}
		return num;
	}

	public int discountNumberFormatException(String text) {
		int num = 0;
		try {
			num = Integer.parseInt(text);
			if (num < 1 && num > 100) {
				JOptionPane.showMessageDialog(null, "할인율은 1~100 사이여야 합니다.");
			} else {
				d = true;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "할인율은 정수형으로 해주세요 ex)50");
			d = false;
		}
		return num;
	}
}

// TODO 유통기한 상품 상세정보Class
class ProductInformation extends JFrame {
	// TODO 상품상세정보 정보
	User user = new User();

	int index;
	ProductInformation(User u, String productNamePrice) {
		System.out.println("일반상품 상세정보 폼");
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("일반상품 상세정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 상품상세정보 이전
		RoundedButton backButton = new RoundedButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductsManager_Main(user);
			}
		});

		boolean expirationProduct = false;
		for (int i = 0; i < user.pos.expirationDate_b.size(); i++) {
			if (productNamePrice.equals(user.pos.expirationDate_b.get(i).getProduct_name() + "  "
					+ user.pos.expirationDate_b.get(i).getProduct_price() + "원")) {
				index = i;
				expirationProduct = true;
				break;
			}
		}
		if (expirationProduct == false) {
			for (int i = 0; i < user.pos.product_b.size(); i++) {
				if (productNamePrice.equals(user.pos.product_b.get(i).getProduct_name() + "  "
						+ user.pos.product_b.get(i).getProduct_price() + "원")) {
					index = i;
					break;
				}
			}
		}

		// TODO 상품상세정보 상품이름
		JLabel productName = new JLabel();
		productName.setBounds(10, 50, 300, 20);

		// TODO 상품상세정보 상품가격
		JLabel productPrice = new JLabel();
		productPrice.setBounds(10, 80, 300, 20);

		// TODO 상품상세정보 수량
		JLabel productNum = new JLabel();
		productNum.setBounds(10, 110, 300, 20);

		// TODO 상품상세정보 단가
		JLabel productUnitPrice = new JLabel();
		productUnitPrice.setBounds(10, 140, 300, 20);

		// TODO 상품상세정보 상품설명
		JLabel productExplan = new JLabel();
		productExplan.setBounds(10, 170, 300, 20);

		// TODO 상품상세정보 할인율
		JLabel productDiscount = new JLabel();
		productDiscount.setBounds(10, 200, 300, 20);

		// TODO 상품상세정보 유통기한
		JLabel productExpiationDate = new JLabel();
		productExpiationDate.setBounds(10, 230, 300, 20);

		// TODO 관리자 전화번호
		JLabel managerPhoneLabel = new JLabel("관리자 전화번호 : 010-9206-9486");
		managerPhoneLabel.setBounds(510, 340, 200, 20);

		// TODO 상품 삭제버튼
		RoundedButton deleteProductButton = new RoundedButton("상품삭제");
		deleteProductButton.setBounds(600, 10, 90, 25);
		deleteProductButton.setBackground(Color.WHITE);

		// 유통기한 상품
		if (expirationProduct == true) {
			productName.setText("상품이름 : " + user.pos.expirationDate_b.get(index).getProduct_name());
			productPrice.setText("상품가격 : " + Integer.toString(user.pos.expirationDate_b.get(index).getProduct_price()));
			productNum.setText("상품수량 : " + Integer.toString(user.pos.expirationDate_b.get(index).getProduct_num()));
			productUnitPrice
					.setText("상품단가 : " + Integer.toString(user.pos.expirationDate_b.get(index).getProduct_Uprice()));
			productExplan.setText("상품설명 : " + user.pos.expirationDate_b.get(index).getProduct_description());
			productDiscount
					.setText("할인율 : " + Integer.toString(user.pos.expirationDate_b.get(index).getProduct_discount()));
			productExpiationDate.setText("유통기한 : " + user.pos.expirationDate_b.get(index).getExDate());

			deleteProductButton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					user.pos.expirationDate_b.remove(index);
					JOptionPane.showMessageDialog(null, "유통기한 상품을 삭제했습니다.");
					setVisible(false);
					new Main(user);
				}
			});
		}
		// 유통기한 없는 상품
		else {
			productName.setText("상품이름 : " + user.pos.product_b.get(index).getProduct_name());
			productPrice.setText("상품가격 : " + Integer.toString(user.pos.product_b.get(index).getProduct_price()));
			productNum.setText("상품수량 : " + Integer.toString(user.pos.product_b.get(index).getProduct_num()));
			productUnitPrice.setText("상품단가 : " + Integer.toString(user.pos.product_b.get(index).getProduct_Uprice()));
			productExplan.setText("상품설명 : " + user.pos.product_b.get(index).getProduct_description());
			productDiscount.setText("할인율 : " + Integer.toString(user.pos.product_b.get(index).getProduct_discount()));

			deleteProductButton.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					user.pos.product_b.remove(index);
					JOptionPane.showMessageDialog(null, "유통기한 없는 상품을 삭제했습니다.");
					setVisible(false);
					new Main(user);
				}
			});
		}

		c.add(backButton);
		c.add(productName);
		c.add(productPrice);
		c.add(productNum);
		c.add(productUnitPrice);
		c.add(productExplan);
		c.add(productDiscount);
		c.add(productExpiationDate);
		c.add(deleteProductButton);

		backgroundImage();

		setSize(710, 400);
		setVisible(true);
	}

	public void backgroundImage() {
		JLabel background = new JLabel();
        background = new JLabel(new ImageIcon("images/image_2.jpg"));
		background.setBounds(0, 0, 710, 400);
		super.add(background);
	}
}

// TODO 좌석 상품 상세정보Class
class SeatInformation extends JFrame {
	// TODO 좌석 상품상세정보 정보
	User user = new User();

	int index;

	SeatInformation(User u, String productNamePrice) {
		System.out.println("좌석상품 상세정보 폼");
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("좌석상품 상세정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 좌석 상품상세정보 이전
		RoundedButton backButton = new RoundedButton("이전");
		backButton.setBounds(10, 10, 60, 25);
		backButton.setBackground(Color.WHITE);
		backButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new ProductsManager_Main(user);
			}
		});

		for (int i = 0; i < user.pos.seatCheck_b.size(); i++) {
			if (productNamePrice.equals(user.pos.seatCheck_b.get(i).getProduct_name() + "  "
					+ user.pos.seatCheck_b.get(i).getProduct_price() + "원")) {
				index = i;
				break;
			}
		}

		// TODO 좌석 상품상세정보 상품이름
		JLabel productName = new JLabel("영화이름 : " + user.pos.seatCheck_b.get(index).getProduct_name());
		productName.setBounds(10, 50, 300, 20);

		// TODO 좌석 상품상세정보 상품가격
		JLabel productPrice = new JLabel(
				"영화가격 : " + Integer.toString(user.pos.seatCheck_b.get(index).getProduct_price()));
		productPrice.setBounds(10, 80, 300, 20);

		// TODO 좌석 상품상세정보 수량
		JLabel productNum = new JLabel("남은 좌석 : " + Integer.toString(user.pos.seatCheck_b.get(index).getProduct_num()));
		productNum.setBounds(10, 110, 300, 20);

		// TODO 좌석 상품상세정보 단가
		JLabel productUnitPrice = new JLabel(
				"영화단가 : " + Integer.toString(user.pos.seatCheck_b.get(index).getProduct_Uprice()));
		productUnitPrice.setBounds(10, 140, 300, 20);

		// TODO 좌석 상품상세정보 상품설명
		JLabel productExplan = new JLabel("상품설명 : " + user.pos.seatCheck_b.get(index).getProduct_description());
		productExplan.setBounds(10, 170, 300, 20);

		// TODO 좌석 상품상세정보 할인율
		JLabel productDiscount = new JLabel(
				"할인율 : " + Integer.toString(user.pos.seatCheck_b.get(index).getProduct_discount()));
		productDiscount.setBounds(10, 200, 300, 20);

		// TODO 좌석 관리자 전화번호
		JLabel managerPhoneLabel = new JLabel("관리자 전화번호 : 010-9206-9486");
		managerPhoneLabel.setBounds(510, 340, 300, 20);

		// TODO 좌석상품 삭제버튼
		RoundedButton deleteProductButton = new RoundedButton("상품삭제");
		deleteProductButton.setBounds(600, 10, 90, 25);
		deleteProductButton.setBackground(Color.WHITE);
		deleteProductButton.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				user.pos.seatCheck_b.remove(index);
				JOptionPane.showMessageDialog(null, "좌석 상품을 삭제했습니다.");
				setVisible(false);
				new Main(user);
			}
		});

		c.add(backButton);
		c.add(productName);
		c.add(productPrice);
		c.add(productNum);
		c.add(productUnitPrice);
		c.add(productExplan);
		c.add(productDiscount);
		c.add(deleteProductButton);

		backgroundImage();

		setSize(710, 400);
		setVisible(true);
	}

	public void backgroundImage() {
		JLabel background = new JLabel();
        background = new JLabel(new ImageIcon("images/image_2.jpg"));
		background.setBounds(0, 0, 710, 400);
		super.add(background);
	}
}

public class ProductsManager {
	public static void main(String[] args) {
	}
}
