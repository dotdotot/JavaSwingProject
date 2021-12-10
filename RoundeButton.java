import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

// TODO 새로운 버튼
class RoundedButton extends JButton {
	public RoundedButton() {
		super();
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		decorate();
	}

	public RoundedButton(Action action) {
		super(action);
		decorate();
	}

	public RoundedButton(Icon icon) {
		super(icon);
		decorate();
	}

	public RoundedButton(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		// 외곽선 삭제, 투명하게 설정
		setBorderPainted(false);
		setOpaque(false);
	}

	// swingComponent 오버라이딩 (스윙 컴포넌트 그리기)
	@Override
	protected void paintComponent(Graphics g) {
		// 255 247 242
		Color c = new Color(255, 247, 242); // TODO 배경색 결정
		// 247 99 12
		Color o = new Color(247, 99, 12); // TODO 글자색 결정
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;

		// 화질이 좋아지도록 설정
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// 눌러졌다면
		if (getModel().isArmed()) {
			graphics.setColor(c.darker());
		} 
		// 마우스가 올라간 상태라면
		else if (getModel().isRollover()) {
			graphics.setColor(c.brighter());
		} 
		// 아무 상태도 아니라면
		else {
			graphics.setColor(c);
		}

		// fillRoundRect를 이용하여 가로,세로크기만큼 10의 둥글기를 가지도록 설정
		graphics.fillRoundRect(0, 0, width, height, 10, 10);

		// grapgics의 지정된 폰트의 폰트 시학을 가져옴
		FontMetrics fontMetrics = graphics.getFontMetrics();
		// grapgics의 글자 위치를 가져옴
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		// 버튼의 텍스트 위치 설정
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		// 세부 설정
		graphics.setColor(o);
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}

class form_710_400_Button extends JButton {
	public form_710_400_Button() {
		super();
		decorate();
	}

	public form_710_400_Button(String text) {
		super(text);
		decorate();
	}

	public form_710_400_Button(Action action) {
		super(action);
		decorate();
	}

	public form_710_400_Button(Icon icon) {
		super(icon);
		decorate();
	}

	public form_710_400_Button(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		// 외곽선 삭제, 투명하게 설정
		setBorderPainted(false);
		setOpaque(false);
	}

	// swingComponent 오버라이딩 (스윙 컴포넌트 그리기)
	@Override
	protected void paintComponent(Graphics g) {
		// 255 247 242
		Color c = new Color(255, 247, 242); // TODO 배경색 결정
		// 247 99 12
		Color o = new Color(247, 99, 12); // TODO 글자색 결정
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;

		// 화질이 좋아지도록 설정
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// 눌러졌다면
		if (getModel().isArmed()) {
			graphics.setColor(c.darker());
		} 
		// 마우스가 올라간 상태라면
		else if (getModel().isRollover()) {
			graphics.setColor(c.brighter());
		} 
		// 아무 상태도 아니라면
		else {
			graphics.setColor(c);
		}

		// fillRoundRect를 이용하여 가로,세로크기만큼 10의 둥글기를 가지도록 설정
		graphics.fillRoundRect(0, 0, width, height, 10, 10);

		// grapgics의 지정된 폰트의 폰트 시학을 가져옴
		FontMetrics fontMetrics = graphics.getFontMetrics();
		// grapgics의 글자 위치를 가져옴
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		// 버튼의 텍스트 위치 설정
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		// 세부 설정
		graphics.setColor(o);
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}

class form_400_200_Button extends JButton {
	public form_400_200_Button() {
		super();
		decorate();
	}

	public form_400_200_Button(String text) {
		super(text);
		decorate();
	}

	public form_400_200_Button(Action action) {
		super(action);
		decorate();
	}

	public form_400_200_Button(Icon icon) {
		super(icon);
		decorate();
	}

	public form_400_200_Button(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		// 외곽선 삭제, 투명하게 설정
		setBorderPainted(false);
		setOpaque(false);
	}

	// swingComponent 오버라이딩 (스윙 컴포넌트 그리기)
	@Override
	protected void paintComponent(Graphics g) {
		// 255 247 242
		Color c = new Color(255, 247, 242); // TODO 배경색 결정
		// 247 99 12
		Color o = new Color(247, 99, 12); // TODO 글자색 결정
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;

		// 화질이 좋아지도록 설정
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// 눌러졌다면
		if (getModel().isArmed()) {
			graphics.setColor(c.darker());
		} 
		// 마우스가 올라간 상태라면
		else if (getModel().isRollover()) {
			graphics.setColor(c.brighter());
		} 
		// 아무 상태도 아니라면
		else {
			graphics.setColor(c);
		}

		// fillRoundRect를 이용하여 가로,세로크기만큼 10의 둥글기를 가지도록 설정
		graphics.fillRoundRect(0, 0, width, height, 10, 10);

		// grapgics의 지정된 폰트의 폰트 시학을 가져옴
		FontMetrics fontMetrics = graphics.getFontMetrics();
		// grapgics의 글자 위치를 가져옴
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		// 버튼의 텍스트 위치 설정
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		// 세부 설정
		graphics.setColor(o);
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}
