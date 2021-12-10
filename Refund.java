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
		System.out.println("환불 폼");
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
                boolean target = user.pos.productRefund(transaction);
				// 환불 성공
				if (target) {
					// 환불 성공 
					JOptionPane.showMessageDialog(null, "환불이 되었습니다.");
					setVisible(false);
					new Main(user);
				}
				// 환불 실패
				else {
					// 환불 실패 
					JOptionPane.showMessageDialog(null, "환불번호가 틀렸습니다.");
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

public class Refund {
	public static void main(String[] args) {
	}
}
