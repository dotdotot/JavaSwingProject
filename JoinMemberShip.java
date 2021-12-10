import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class JoinMemberShip extends JFrame {
    public static ArrayList<User> userList = new ArrayList<User>();
    // TODO 아이디
    // 아이디를 표시하는 레이블, 아이디를 입력받는 텍스트필드
    // 아이디를 성공적으로 입력했을 때 나타내는 레이블
    JLabel idLabel = new JLabel("아이디");
    JTextField id = new JTextField("", 20);
    JLabel idCheckText = new JLabel("성공");
    // TODO 비밀번호
    // 비밀번호를 표시하는 레이블, 비밀번호를 입력받는 텍스트필드
    // 비밀번호를 성공적으로 입력했을 때 나타내는 레이블
    JLabel pwLabel = new JLabel("비밀번호");
    JTextField pw = new JTextField("", 20);
    JLabel pwCheckText = new JLabel("안전");
    // TODO 비밀번호 재확인
    // 비밀번호 재확인을 표시하는 레이블, 비밀번호 재확인을 입력받는 텍스트필드
    // 비밀번호 재확인을 성공적으로 입력했을 때 나타내는 레이블
    JLabel pwCheckLabel = new JLabel("비밀번호 확인");
    JTextField pwCheck = new JTextField("", 20);
    JLabel pwCheckTextLabel = new JLabel("동일");
    // TODO 이름
    // 이름을 표시하는 레이블, 이름을 입력받는 텍스트필드
    // 이름을 성공적으로 입력했을 때 나타내는 레이블
    JLabel nameLabel = new JLabel("이름");
    JTextField name = new JTextField("", 20);
    JLabel nameCheckText = new JLabel("성공");
    // TODO 성별
    // 성별을 표시하는 레이블, 성별을 입력받는 그룹, 성별을 나타내는 라디오버튼(남,여)
    JLabel genderLabel = new JLabel("성별");
    ButtonGroup group = new ButtonGroup();
    JRadioButton man = new JRadioButton("남");
    JRadioButton woman = new JRadioButton("여");
    // TODO 생년월일
    // 생년월일을 표시하는 레이블, 생년월일을 입력받는 텍스트필드
    // 생년월일을 성공적으로 입력했을 때 나타내는 레이블
    JLabel birthDateLabel = new JLabel("생년월일");
    JTextField birthDate = new JTextField("2021-11-01", 20);
    JLabel birthDateText = new JLabel("성공");
    // TODO 연락처
    // 연락처를 표시하는 레이블, 연락처를 입력받는 텍스트필드
    // 연락처를 성공적으로 입력했을 때 나타내는 레이블
    JLabel phoneNumberLabel = new JLabel("전화번호");
    JTextField phoneNumber = new JTextField("010-1234-5678", 20);
    JLabel phoneNumberText = new JLabel("성공");
    // TODO 주소
    // 주소를 표시하는 레이블, 주소를 입력받는 텍스트필드
    // 주소를 성공적으로 입력했을 때 나타내는 레이블
    JLabel addressLabel = new JLabel("주소");
    JTextField address = new JTextField("", 20);
    JLabel addressText = new JLabel("주소 성공");
    // TODO 이메일
    // 이메일을 표시하는 레이블, 이메일을 입력받는 텍스트필드
    JLabel eMailLabel = new JLabel("이메일(선택)");
    JTextField eMail = new JTextField("", 20);
    // TODO 비밀번호 질문
    // 비밀번호 질문 배열, 비밀번호 질문을 나타내는 레이블
    // 비밀번호 질문을 나타내는 콤보박스
    String[] pwQuestionArr = { "기억에 남는 추억의 장소는?", "자신의 인생 좌우명은?", "자신의 보물 제1호는", "가장 기억에 남는 선생님 성함은?",
            "인상 깊게 읽은 책 이름은?", "초등학교 때 기억에 남는 짝궁 이름은?", "받았던 선물 중 기억에 남는 독특한 선물은?", "유년시절 가장 생각나는 친구 이름은?",
            "내가 좋아하는 캐릭터는?", "자신이 두번째로 존경하는 인물은?", "자신이 다녔던 초등학교 이름은?", "자신이 다녔던 중학교 이름은?", "자신이 다녔던 고등학교 이름은?", };
    JLabel pwQuestionLabel = new JLabel("비밀번호 찾기 질문/답변");
    JComboBox<String> pwQuestion = new JComboBox<String>(pwQuestionArr);
    // TODO 비밀번호 질문 답변
    // 비밀번호 질문에 대한 답변을 입력받는 텍스트필드
    // 비밀번호 질문에 대한 답변을 성공적으로 입력했을 때 나타내는 레이블
    JTextField pwQuestionAnswer = new JTextField("", 20);
    JLabel pwQuestionAnswerText = new JLabel("성공");
    // TODO 회원가입 버튼
    // 회원가입 버튼, 회원가입 성공시 나타나는 레이블
    JButton joinMerbership = new JButton("회원가입");
    JLabel joinMerbershipText = new JLabel("성공");

    public JoinMemberShip(ArrayList<User> user) {
        System.out.println("회원가입 폼");
        userList = user;
        // 제목 설정, 메인 스레드 종료시 이벤트 스레드 종료하도록 설정
        setTitle("회원가입");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 프레임을 화면 중앙에 배치
        setLocationRelativeTo(null);

        // 컨테이너의 이름을 c로 설정, 배치관리자 삭제
        Container c = getContentPane();
        c.setLayout(null);

        // 배경색 임시 하얀색
        c.setBackground(Color.WHITE);

        // TODO 폰트 설정(실패,성공,보통)
        Color failColor = new Color(250, 0, 0);
        Color successColor = new Color(34, 139, 34);
        Color normalColor = new Color(255, 165, 0);

        // TODO 아이디 추가 설정
        // 아이디를 나타내는 레이블의 위치와 크기설정
        idLabel.setBounds(20, 40, 100, 30);
        // 아이디를 입력받는 텍스트필드의 위치와 크기설정 및 마우스리스너 부착, 키 리스너 부착
        id.setBounds(100, 40, 200, 30);
        id.addMouseListener(new MyMouseListener());
        id.addKeyListener(new KeyAdapter() {
            // 키를 뗄때
            public void keyReleased(KeyEvent e) {
                // id에 공백을 넣지 못하도록 설정
                String idText = id.getText();
                idText = idText.replaceAll(" ", "");
                id.setText(idText);

                if (idText.equals("")) {
                    return;
                }

                // 아직 아무도 회원가입을 안했으면 아무 아이디나 사용가능, 색깔설정, 창 표시
                if (userList.size() == 0) {
                    idCheckText.setText("사용가능");
                    idCheckText.setForeground(successColor);
                    idCheckText.setVisible(true);
                }
                // 회원가입을 누군가 한 상태라면
                else {
                    // 유저의 인원만큼 반복하는 반복문
                    for (int i = 0; i < userList.size(); i++) {
                        // 한 유저의 아이디와 동일하다면
                        if (userList.get(i).getId().equals(idText)) {
                            // 중복되었다고 레이블 구현, 색깔설정, 창 표시
                            idCheckText.setText("사용불가");
                            idCheckText.setForeground(failColor);
                            idCheckText.setVisible(true);
                        }
                        // 한 유저의 아이디와 동일하지 않다면
                        else {
                            // 중복안되었다고 레이블 구현, 색깔설정, 창 표시
                            idCheckText.setText("사용가능");
                            idCheckText.setForeground(successColor);
                            idCheckText.setVisible(true);
                        }
                    }
                }
            }
        });
        // 아이디를 성공적으로 입력했을 때 나타나는 레이블의 위치설정, 창을 표시하지 않도록 설정(기본설정)
        idCheckText.setBounds(320, 40, 200, 30);
        idCheckText.setVisible(false);

        // TODO 비밀번호 추가 설정
        // 비밀번호를 나타내는 레이블의 위치와 크기설정
        pwLabel.setBounds(20, 80, 100, 30);
        // 비밀번호릉 입력받는 텍스트필드의 위치와 크기설정, 마우스리스너 부착, 키 리스너 부착
        pw.setBounds(100, 80, 200, 30);
        pw.addMouseListener(new MyMouseListener());
        pw.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                // 처음부터 공백을 입력하지 못하도록 설정
                String pwText = pw.getText();
                pwText = pwText.replaceAll(" ", "");
                pw.setText(pwText);
                if (pwText.equals("")) {
                    return;
                }

                // 만약 비밀번호에 특수문자가 들어간 상태라면
                if (pwText.contains("~") || pwText.contains("!") || pwText.contains("@") || pwText.contains("#")
                        || pwText.contains("$") || pwText.contains("%") || pwText.contains("^") || pwText.contains("&")
                        || pwText.contains("*") || pwText.contains("(") || pwText.contains(")") || pwText.contains("<")
                        || pwText.contains(">") || pwText.contains("?") || pwText.contains("|") || pwText.contains("{")
                        || pwText.contains("}")) {
                    // 비밀번호 길이가 10자리가 넘는다면
                    if (pwText.length() > 10) {
                        // 안전(색깔설정, 창 표시)
                        pwCheckText.setText("안전");
                        pwCheckText.setForeground(successColor);
                        pwCheckText.setVisible(true);
                    }
                    // 특수문자는 들어갔지만 비밀번호 길이가 10자리가 넘지 않는다면
                    else {
                        // 보통(색깔설정, 창 표시)
                        pwCheckText.setText("보통");
                        pwCheckText.setForeground(normalColor);
                        pwCheckText.setVisible(true);
                    }
                }
                // 비밀번호에 특수문자가 들어가지 않은 상태라면
                else {
                    // 위험(색깔 설정, 창 표시)
                    pwCheckText.setText("위험");
                    pwCheckText.setForeground(failColor);
                    pwCheckText.setVisible(true);
                }
            }
        });
        // 비밀번호를 성공적으로 입력했을 때 나타나는 레이블의 위치와 크기 설정, 창은 기본적으로 안보이도록 설정
        pwCheckText.setBounds(320, 80, 200, 30);
        pwCheckText.setVisible(false);

        // TODO 비밀번호 재확인 추가 설정
        // 비밀번호를 재확인하는 레이블의 위치와 크기설정
        pwCheckLabel.setBounds(20, 120, 100, 30);
        // 비밀번호를 재확인하는 텍스트 필드의 위치와 크기설정, 마우스리스너 부착, 키 리스너 부착
        pwCheck.setBounds(100, 120, 200, 30);
        pwCheck.addMouseListener(new MyMouseListener());
        pwCheck.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                // 만약 비밀번호가 동일하다면
                if (pwCheck.getText().equals(pw.getText())) {
                    // 비밀번호가 동일하다는 레이블 구현, 색깔 설정, 창 표시
                    pwCheckTextLabel.setText("일치");
                    pwCheckTextLabel.setForeground(successColor);
                    pwCheckTextLabel.setVisible(true);
                }
                // 비밀번호가 동일하지 않다면
                else {
                    // 비밀번호가 동일하지 않다는 레이블 구현, 색깔 설정, 창 표시
                    pwCheckTextLabel.setText("불일치");
                    pwCheckTextLabel.setForeground(failColor);
                    pwCheckTextLabel.setVisible(true);
                }
            }
        });
        // 비밀번호를 성공적으로 재확인 했을 때 나타나는 레이블의 위치와 크기 설정, 창은 기본적으로 안보이도록 설정
        pwCheckTextLabel.setBounds(320, 120, 200, 30);
        pwCheckTextLabel.setVisible(false);

        // TODO 이름 추가 설정
        // 이름을 나타내는 레이블의 위치와 크기 설정
        nameLabel.setBounds(20, 160, 100, 30);
        // 이름을 입력받는 텍스트 필드의 위치와 크기 설정, 마우스리스너 부착, 키 리스너 부착
        name.setBounds(100, 160, 200, 30);
        name.addMouseListener(new MyMouseListener());
        name.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = name.getText();

                // 만약 이름을 입력받는 텍스트 필드가 비어있다면
                if (text.equals("")) {
                    // 정확하지 않다는 레이블 구현, 색깔 설정, 창 표시
                    nameCheckText.setText("불가");
                    nameCheckText.setForeground(failColor);
                    nameCheckText.setVisible(true);
                }
                // 이름을 입력받는 텍스트 필드가 비어있지 않다면
                else {
                    // 정확하다는 레이블 구현, 색깔 설정, 창 표시
                    nameCheckText.setText("가능");
                    nameCheckText.setForeground(successColor);
                    nameCheckText.setVisible(true);
                }
            }
        });
        // 이름을 성공적으로 입력했을 때 나타나는 레이블의 위치와 크기 설정, 창은 기본적으로 안보이도록 설정
        nameCheckText.setBounds(320, 160, 200, 30);
        nameCheckText.setVisible(false);

        // TODO 성별 추가 설정
        // 성별을 나타내는 레이블의 위치와 크기 설정
        genderLabel.setBounds(20, 200, 100, 30);
        // 남자 라디오 버튼의 위치와 크기 설정, 여자 라디오 버튼의 위치와 크기 설정
        man.setBounds(100, 200, 50, 30);
        woman.setBounds(150, 200, 50, 30);

        // 생년월일 추가 설정
        // 생년월일을 나타내는 레이블의 위치와 크기 설정
        birthDateLabel.setBounds(20, 240, 100, 30);
        // 생년월일을 입력받는 텍스트 필드의 위치와 크기 설정, 마우스 리스너 부착, 키 리스너 부착
        birthDate.setBounds(100, 240, 200, 30);
        birthDate.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // 만약 생년월일이 참고용으로 나타내는 데모 데이터와 동일하다면
                if (birthDate.getText().equals("2021-11-01"))
                    // 마우스를 클릭했을 때 지우기
                    birthDate.setText("");
                // 만약 휴대폰 넘버가 비어있다면
                if (phoneNumber.getText().equals(""))
                    // 참고용으로 나타내는 데모 데이터를 띄워주기
                    phoneNumber.setText("010-1234-5678");
            }
        });
        birthDate.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                String text = birthDate.getText();

                // 생년월일을 입력받는 곳이 비어있다면
                if (text.equals("")) {
                    // 정확하지 않다는 레이블 구현, 색깔 설정, 창 표시
                    birthDateText.setText("불가");
                    birthDateText.setForeground(failColor);
                    birthDateText.setVisible(true);
                }
                // 생년월일을 입력받는 곳이 비어있지 않다면
                else {
                    // 정확하다는 레이블 구현, 색깔 설정, 창 표시
                    birthDateText.setText("가능");
                    birthDateText.setForeground(successColor);
                    birthDateText.setVisible(true);
                }
            }
        });
        // 생년월일을 성공적으로 입력했을 때 나타나는 레이블의 위치와 크기설정, 창 표시
        birthDateText.setBounds(320, 240, 200, 30);
        birthDateText.setVisible(false);

        // TODO 휴대폰번호 추가 설정
        // 휴대폰번호를 나타내는 레이블의 위치와 크기 설정
        phoneNumberLabel.setBounds(20, 280, 100, 30);
        // 휴대폰번호를 입력받는 텍스트 필드의 위치와 크기 설정, 마우스 리스너 부착, 키 리스너 부착
        phoneNumber.setBounds(100, 280, 200, 30);
        phoneNumber.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // 생년월일을 입력받는 레이블이 비어있다면
                if (birthDate.getText().equals(""))
                    // 참고용으로 보여주는 데모 데이터로 교체해줌
                    birthDate.setText("2021-11-01");
                // 휴대폰번호를 입력받는 레이블이 데모 데이터 상태라면
                if (phoneNumber.getText().equals("010-1234-5678"))
                    // 마우스를 눌렀을 때 값이 없어지도록 설정
                    phoneNumber.setText("");
            }
        });
        phoneNumber.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = phoneNumber.getText();

                // 만약 전화번호를 입력받는 레이블이 비어있다면
                if (text.equals("")) {
                    // 정확하지 않다는 레이블 구현, 색깔 설정, 창 표사
                    phoneNumberText.setText("불가");
                    phoneNumberText.setForeground(failColor);
                    phoneNumberText.setVisible(true);
                }
                // 전화번호를 입력받는 레이블이 비어있지 않다면
                else {
                    // 정확하다는 레이블 구현, 색깔 설정, 창 표시
                    phoneNumberText.setText("가능");
                    phoneNumberText.setForeground(successColor);
                    phoneNumberText.setVisible(true);
                }
            }
        });
        // 전화번호를 성공적으로 입력했을 때 나타나는 레이블의 위치와 크기 설정, 창은 기본적으로 안보이도록 설정
        phoneNumberText.setBounds(320, 280, 200, 30);
        phoneNumberText.setVisible(false);

        // TODO 주소 추가 설정
        // 주소를 나타내는 레이블의 위치와 크기 설정
        addressLabel.setBounds(20, 320, 100, 30);
        // 주소를 입력받는 텍스트 필드의 위치와 크기 설정, 마우스 리스너 부착, 키 리스너 부착
        address.setBounds(100, 320, 200, 30);
        address.addMouseListener(new MyMouseListener());
        address.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = address.getText();
                // 만약 주소를 입력받는 텍스트 필드가 비어있다면
                if (text.equals("")) {
                    // 정확하지 않다는 레이블 구현, 색깔 설정, 창 표시
                    addressText.setText("불가");
                    addressText.setForeground(failColor);
                    addressText.setVisible(true);
                }
                // 주소를 입력받는 텍스트 필드가 비어있지 않다면
                else {
                    // 정확하다는 레이블 구현, 색깔 설정, 창 표시
                    addressText.setText("가능");
                    addressText.setForeground(successColor);
                    addressText.setVisible(true);
                }
            }
        });
        // 주소를 성공적으로 입력했을 때 나타나는 레이블의 위치와 크기 설정, 창은 기본적으로 안보이도록 설정
        addressText.setBounds(320, 320, 200, 30);
        addressText.setVisible(false);

        // TODO 이메일 추가 설정
        // 이메일을 나타내는 레이블의 위치와 크기 설정
        eMailLabel.setBounds(20, 360, 100, 30);
        // 이메일을 입력받는 텍스트 필드의 위치와 크기 설정, 마우스 리스너 부착
        eMail.setBounds(100, 360, 200, 30);
        eMail.addMouseListener(new MyMouseListener());

        // TODO 비밀번호찾기 질문 추가 설정
        // 비밀번호찾기 질문을 나타내는 레이블의 위치와 크기 설정
        pwQuestionLabel.setBounds(20, 400, 200, 30);
        // 비밀번호찾기 질문을 보여주는 콤보박스의 위치와 크기 설정
        pwQuestion.setBounds(20, 440, 300, 30);

        // TODO 비밀번호찾기 답변 추가 설정
        // 비밀번호찾기 답변을 입력받는 텍스트 필드의 위치와 크기 설정, 마우스 리스너 부착, 키 리스너 부착
        pwQuestionAnswer.setBounds(20, 480, 300, 30);
        pwQuestionAnswer.addMouseListener(new MyMouseListener());
        pwQuestionAnswer.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = pwQuestionAnswer.getText();

                // 만약 비밀번호찾기 답변을 입력받는 텍스트 필드가 비어있다면
                if (text.equals("")) {
                    // 정확하지 않다는 레이블 구현, 색깔 설정, 창 표시
                    pwQuestionAnswerText.setText("불가");
                    pwQuestionAnswerText.setForeground(failColor);
                    pwQuestionAnswerText.setVisible(true);
                }
                // 비밀번호찾기 답변을 나타내는 텍스트 필드가 비어있지 않다면
                else {
                    // 정확하다는 레이블 구현, 색깔 설정, 창 표시
                    pwQuestionAnswerText.setText("가능");
                    pwQuestionAnswerText.setForeground(successColor);
                    pwQuestionAnswerText.setVisible(true);
                }
            }
        });
        // 비밀번호를 성공적으로 입력했을 때 나타나는 레이블의 위치와 크기 설정, 창은 기본적으로 안보이도록 설정
        pwQuestionAnswerText.setBounds(340, 480, 200, 30);
        pwQuestionAnswerText.setVisible(false);

        // TODO 회원가입 버튼 추가 설정
        // 회원가입 버튼의 위치와 크기설정 액션 리스너 부착
        joinMerbership.setBackground(Color.WHITE);
        joinMerbership.setBounds(130, 520, 100, 50);
        joinMerbership.addActionListener(new MyActionListener());
        // 회원가입을 성공적으로 완료했을 때 나타나는 레이블의 위치와 크기 설정, 창은 기본적으로 안보이도록 설정
        joinMerbershipText.setBounds(250, 530, 200, 30);
        joinMerbershipText.setVisible(false);

        // TODO 이전
        JButton backButton = new JButton("이전");
        backButton.setBounds(10, 10, 60, 25);
        backButton.setBackground(Color.WHITE);
        backButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new Login(user);
            }
        });

        // 이전버튼 컨테이너 부착
        c.add(backButton);

        // id에 관련된 컴포넌트들 컨테이너에 부착
        c.add(idLabel);
        c.add(id);
        c.add(idCheckText);

        // pw에 관련된 컴포넌트들 컨테이너에 부착
        c.add(pwLabel);
        c.add(pw);
        c.add(pwCheckText);

        // pwCheck에 관련된 컴포넌트들 컨테이너에 부착
        c.add(pwCheckLabel);
        c.add(pwCheck);
        c.add(pwCheckTextLabel);

        // name에 관련된 컴포넌트들 컨테이너에 부착
        c.add(nameLabel);
        c.add(name);
        c.add(nameCheckText);

        // 성별에 관련된 컴포넌트들 컨테이너에 부착
        c.add(genderLabel);
        group.add(man);
        group.add(woman);
        c.add(man);
        c.add(woman);

        // 생년월일에 관련된 컴포넌트들 컨테이너에 부착
        c.add(birthDateLabel);
        c.add(birthDate);
        c.add(birthDateText);

        // 전화번호에 관련된 컴포넌트들 컨테이너에 부착
        c.add(phoneNumberLabel);
        c.add(phoneNumber);
        c.add(phoneNumberText);

        // 주소에 관련된 컴포넌트들 컨테이너에 부착
        c.add(addressLabel);
        c.add(address);
        c.add(addressText);

        // 이메일에 관련된 컴포넌트들 컨테이너에 부착
        c.add(eMailLabel);
        c.add(eMail);

        // 비밀번호찾기 질문에 관련된 컴포넌트들 컨테이너에 부착
        c.add(pwQuestionLabel);
        c.add(pwQuestion);

        // 비밀번호찾기 답변에 관련된 컴포넌트들 컨테이너에 부착
        c.add(pwQuestionAnswer);
        c.add(pwQuestionAnswerText);

        // 회원가입에 관련된 컴포넌트들 컨테이너에 부착
        c.add(joinMerbership);
        c.add(joinMerbershipText);

        // 사이즈 설정(350,550), 창 출력
        setSize(400, 630);
        setVisible(true);

        // 콘솔창에 출력하기 위해서 실행
        // programRun();
    }

    // TODO 공통 마우스리스너
    // 생년월일과 전화번호는 데모 데이터를 보여주는데 사용자가 데모 데이터를 삭제하고 아무것도 입력하지 않은 경우 다시 데모 데이터를 보여주도록
    // 설정
    class MyMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            // 생년월일을 입력받는 텍스트 필드가 비어있다면
            if (birthDate.getText().equals("")) {
                // 생년월일을 입력받는 텍스트 필드에 데모 데이터를 추가
                birthDate.setText("2021-11-01");
            }
            // 전화번호를 입력받는 텍스트 필드가 비어있다면
            if (phoneNumber.getText().equals("")) {
                // 전화번호를 입력받는 텍스트 필드에 데모 데이터를 추가
                phoneNumber.setText("010-1234-5678");
            }
        }
    }

    // TODO 회원가입 액션리스너
    // 회원가입에 관련된 항목들을 모두 기재하고 회원가입 버튼을 눌렀을 때 회원가입이 되도록 설정
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // 회원가입 관련된 항목들의 내용들을 전부 받아옴
            String idTextTemp = id.getText();
            String pwTextTemp = pw.getText();
            String nameTextTemp = name.getText();
            String genderTextTemp = "남자";
            if (man.isSelected()) {
                genderTextTemp = "남자";
            } else if (woman.isSelected()) {
                genderTextTemp = "여자";
            }
            String birthDateTextTemp = birthDate.getText();
            String phoneNumberTextTemp = phoneNumber.getText();
            String addressTextTemp = address.getText();
            String eMailTextTemp = eMail.getText();
            String pwQuestionTextTemp = pwQuestion.getSelectedItem().toString();
            String pwQuestionAnswerTextTemp = pwQuestionAnswer.getText();

            // 색깔 설정
            Color color = new Color(139, 0, 0);
            Color failColor = new Color(255, 0, 0);

            // 항목들을 기재하지 않았을 경우 체크하는 변수
            // 항목들을 잘못 기입했을 경우 체크하는 변수
            boolean emptyLabel = true;
            boolean falutLabel = true;

            // 항목들을 기재하지 않았을 경우 대응하는 코드들
            // 항목의 상태를 나타내는 레이블의 내용을 변경 (작성)
            // 항목의 상태를 나타내는 레이블의 색깔 변경
            // 항목의 상태를 나타내는 레이블의 창 표시
            // 모두 성공적으로 기입을 하였다면 emptyLabel을 false상태로 변경
            if (idCheckText.isVisible() == false) {
                idCheckText.setText("작성");
                idCheckText.setForeground(failColor);
                idCheckText.setVisible(true);
            } else if (pwCheckText.isVisible() == false) {
                pwCheckText.setText("작성");
                pwCheckText.setForeground(failColor);
                pwCheckText.setVisible(true);
            } else if (pwCheckTextLabel.isVisible() == false) {
                pwCheckTextLabel.setText("작성");
                pwCheckTextLabel.setForeground(failColor);
                pwCheckTextLabel.setVisible(true);
            } else if (nameCheckText.isVisible() == false) {
                nameCheckText.setText("작성");
                nameCheckText.setForeground(failColor);
                nameCheckText.setVisible(true);
            } else if (birthDateText.isVisible() == false) {
                birthDateText.setText("작성");
                birthDateText.setForeground(failColor);
                birthDateText.setVisible(true);
            } else if (phoneNumberText.isVisible() == false) {
                phoneNumberText.setText("작성");
                phoneNumberText.setForeground(failColor);
                phoneNumberText.setVisible(true);
            } else if (addressText.isVisible() == false) {
                addressText.setText("작성");
                addressText.setForeground(failColor);
                addressText.setVisible(true);
            } else if (pwQuestionAnswerText.isVisible() == false) {
                pwQuestionAnswerText.setText("작성");
                pwQuestionAnswerText.setForeground(failColor);
                pwQuestionAnswerText.setVisible(true);
            } else {
                emptyLabel = false;
            }

            // 항목들을 잘못 기재했을 경우 대응하는 코드들
            // 항목의 상태를 나타내는 레이블의 내용을 변경 (작성)
            // 항목의 상태를 나타내는 레이블의 색깔 변경
            // 항목의 상태를 나타내는 레이블의 창 표시
            // 모두 성공적으로 기입을 하였다면 falutLabel을 false상태로 변경
            if (idCheckText.getText() == "사용불가") {
                idCheckText.setText("재작성");
                idCheckText.setForeground(color);
                idCheckText.setVisible(true);
            } else if (pwCheckText.getText() == "위험") {
                pwCheckText.setText("재작성");
                pwCheckText.setForeground(color);
            } else if (pwCheckTextLabel.getText().equals("불일치")) {
                pwCheckTextLabel.setText("재작성");
                pwCheckTextLabel.setForeground(color);
            } else if (nameCheckText.getText().equals("불가")) {
                nameCheckText.setText("재작성");
                nameCheckText.setForeground(color);
            } else if (genderTextTemp.equals("")) {
                idCheckText.setText("재작성");
            } else if (birthDateText.equals("불가")) {
                birthDateText.setText("재작성");
                birthDateText.setForeground(color);
            } else if (phoneNumberText.getText().equals("불가")) {
                phoneNumberText.setText("재작성");
                phoneNumberText.setForeground(color);
            } else if (addressText.getText().equals("불가")) {
                addressText.setText("재작성");
                addressText.setForeground(color);
            } else if (pwQuestionAnswerText.getText().equals("불가")) {
                pwQuestionAnswerText.setText("재작성");
                pwQuestionAnswerText.setForeground(color);
            } else {
                falutLabel = false;
            }

            // 항목들이 모두 정상적으로 기재했다면
            if (emptyLabel == false && falutLabel == false) {
                // User의 객체를 생성하고 생성자에 회원가입 관련해서 받아온 내용들을 매개변수로 넣어줌
                User user = new User(idTextTemp, pwTextTemp, nameTextTemp, genderTextTemp, birthDateTextTemp,
                        phoneNumberTextTemp, addressTextTemp, eMailTextTemp, pwQuestionTextTemp,
                        pwQuestionAnswerTextTemp);
                // ArrayList로 생성된 userList에 객체추가
                userList.add(user);

                // 회원가입을 성공적으로 했을 경우 나타내는 레이블의 색깔
                Color c = new Color(0, 255, 0);

                // 회원가입을 성공적으로 했을 경우 나타내는 레이블의 문자열변경, 색깔 설정, 창 표시
                joinMerbershipText.setText("회원가입 성공!!");
                joinMerbershipText.setBackground(c);
                joinMerbershipText.setVisible(true);

                setVisible(false);
                new Login(userList);
            }
        }
    }

    // TODO 콘솔 출력
    // 회원가입한 User의 내용들을 콘솔로 출력하기 위해 만든 메소드
    public void programRun() {
        Scanner scan = new Scanner(System.in);
        // 무한반복문
        while (true) {
            System.out.print("1. 로그인 2.종료 : ");
            String text = scan.next();

            // 입력받은 값이 "1"이라면 로그인
            if (text.equals("1")) {
                // 아이디와 비밀번호를 입력받음
                System.out.print("아이디 : ");
                String idTemp = scan.next();
                System.out.print("비밀번호 : ");
                String pwTemp = scan.next();

                // ArrayList에 있는 User들 중 아이디와 비밀번호가 동일한 객체를 조회하고 index번호를 변수에 받아옴
                boolean idCheck = false;
                boolean pwCheck = false;
                int index = -1;
                // ArrayList에 있는 객체들의 개수만큼 반복
                for (int i = 0; i < userList.size(); i++) {
                    if (idTemp.equals(userList.get(i).getId())) {
                        idCheck = true;
                    }
                    if (idCheck == true && pwTemp.equals(userList.get(i).getPw())) {
                        pwCheck = true;
                        index = i;
                        break;
                    }
                    idCheck = false;
                    pwCheck = false;

                    // 최종적으로 한 객체의 아이디와 비밀번호가 사용자가 입력한 아이디와 비밀번호와 동일해야 boolean 변수가 모두 true상태로 변하고
                    // index 번호를 받아온 뒤 반복문이 종료됨
                }

                if (idCheck == false && pwCheck == false)
                    System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");

                // boolean변수가 모두 true상태라면 로그인 성공
                if (idCheck == true && pwCheck == true) {
                    // 무한반복문
                    while (true) {
                        System.out.print("1. 나의 모든 정보 보기 2. 로그인 화면으로 돌아가기 : ");
                        text = scan.next();

                        // 입력받은 값이 "1"이 라면 유저의 모든 정보를 출력
                        if (text.equals("1")) {
                            System.out.println("아이디 : " + userList.get(index).getId());
                            System.out.println("비밀번호 : " + userList.get(index).getPw());
                            System.out.println("이름 : " + userList.get(index).getName());
                            System.out.println("성별 : " + userList.get(index).getGender());
                            System.out.println("생년월일 : " + userList.get(index).getBirthDate());
                            System.out.println("휴대폰번호 : " + userList.get(index).getPhoneNumber());
                            System.out.println("주소 : " + userList.get(index).getAddress());
                            System.out.println("이메일 : " + userList.get(index).geteMail());
                            System.out.println("비밀번호찾기 질문 : " + userList.get(index).getPwQuestion());
                            System.out.println("비밀번호찾기 답변 : " + userList.get(index).getPwQuestionAnswer());
                        }
                        // 입력받은 값이 "2"라면 로그인 화면으로 돌아감
                        else if (text.equals("2")) {
                            System.out.println("-----     -----");
                            System.out.println("로그인 화면으로 돌아갑니다");
                            System.out.println("-----     -----");
                            break;
                        }
                    }
                }
            }
            // 입력받은 값이 "2"라면 프로그램을 종료(메인 스레드도 같이 종료)
            else if (text.equals("2")) {
                System.out.println("-----     -----");
                System.out.println("프로그램 종료(메인스레드도 종료합니다)");
                System.out.println("-----     -----");
                System.exit(ABORT);
                break;

            }
        }

        scan.close();
    }

    public static void main(String[] args) {
    }
}