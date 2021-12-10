import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// TODO 환불
class Refund_Main extends JFrame {
	//TODO 정보
	User user = new User();
	// TODO 거래번호 입력
	JLabel transactionNumberLabel = new JLabel("거래번호");
	JTextField transactionNumberTextField = new JTextField();

	public Refund_Main(User u) {
		user = u;
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("환불");
		// 메인 스레드 종료 뺐음

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		// TODO 취소
		JButton cancelButton = new JButton("취소");
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setBounds(10, 10, 60, 30);
		cancelButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				new Main(user);
			}
		});

		// TODO 환불 
		JButton refundButton = new JButton("환불");
		refundButton.setBackground(Color.WHITE);
		refundButton.setBounds(320, 10, 60, 30);
		refundButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String transaction = transactionNumberTextField.getText();
                boolean target = true;
                
                

				// 환불 성공
				if (target) {
					// 장부에서 제외하고 수량을 줄이는 코드가 들어가야함

					// ------------------------------------

					// 환불 성공 폼
					setVisible(false);
					new RefundSuccess();
				}
				// 환불 실패
				else {
					// 환불 실패 폼
					setVisible(false);
					new RefundFail();
				}
			}
		});

		transactionNumberLabel.setBounds(10, 70, 200, 20);
		transactionNumberTextField.setBounds(80, 70, 200, 20);

		c.add(cancelButton);
		c.add(refundButton);
		c.add(transactionNumberLabel);
		c.add(transactionNumberTextField);

		setSize(400, 200);
		setVisible(true);
	}
}

// TODO 환불 성공
class RefundSuccess extends JFrame {
	public RefundSuccess() {
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("환불 성공");

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		Font textFont = new Font("이텔릭체", Font.ITALIC, 80);

		JLabel success = new JLabel("성공!!");
		success.setFont(textFont);
		success.setBounds(80, 40, 250, 80);

		c.add(success);

		setSize(400, 200);
		setVisible(true);
	}
}

// TODO 환불 실패
class RefundFail extends JFrame {
	public RefundFail() {
		// 제목 설정, 메인 스레드 종료시 이벤트 스레드도 종료하도록 설정
		setTitle("환불 실패");

		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);

		// Main컨테이너 이름을 c로 설정, 배치관리자 삭제, 백그라운드 설정
		Container c = getContentPane();
		c.setLayout(null);
		// 일단 하얀색으로 배경색 설정, 추후 이미지로 바꿀 예정
		c.setBackground(Color.WHITE);

		Font textFont = new Font("이텔릭체", Font.ITALIC, 80);

		JLabel success = new JLabel("실패..");
		success.setFont(textFont);
		success.setBounds(80, 40, 250, 80);

		c.add(success);

		setSize(400, 200);
		setVisible(true);
	}
}

public class Refund {
	public static void main(String[] args) {
	}
}
