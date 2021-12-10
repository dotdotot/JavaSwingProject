import posProject.*;
public class User {
	// 아이디,비밀번호,이름,성별,생년월일,전화번호,주소,이메일,비밀번호찾기 질문, 비밀번호찾기 답변
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String birthDate;
	private String phoneNumber;
	private String address;
	private String eMail;
	private String pwQuestion;
	private String pwQuestionAnswer;
	public MoviePos_b pos;
	// 가게 class 변수

	// TODO 기본 생성자
	public User() {
		pos = new MoviePos_b();
	}

	// TODO 이메일을 제외한 매개변수를 받는 생성자
	public User(String id, String pw, String name, String gender, String birthDate, String phoneNumber, String address,
			String pwQuestion, String pwQuestionAnswer) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.pwQuestion = pwQuestion;
		this.pwQuestionAnswer = pwQuestionAnswer;
		pos = new MoviePos_b();
	}

	// TODO 모든 매개변수를 받는 생성자
	public User(String id, String pw, String name, String gender, String birthDate, String phoneNumber, String address,
			String eMail, String pwQuestion, String pwQuestionAnswer) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.eMail = eMail;
		this.pwQuestion = pwQuestion;
		this.pwQuestionAnswer = pwQuestionAnswer;
		pos = new MoviePos_b();
	}

	// 이름을 반환하는 함수
	public String getId() {
		return id;
	}

	// 이름을 수정하는 함수
	public void setId(String id) {
		this.id = id;
	}

	// 비밀번호를 반환하는 함수
	public String getPw() {
		return pw;
	}

	// 비밀번호를 수정하는 함수
	public void setPw(String pw) {
		this.pw = pw;
	}

	// 이름을 반환하는 함수
	public String getName() {
		return name;
	}

	// 이름을 수정하는 함수
	public void setName(String name) {
		this.name = name;
	}

	// 성별을 반환하는 함수
	public String getGender() {
		return gender;
	}

	// 성별을 수정하는 함수
	public void setGender(String gender) {
		this.gender = gender;
	}

	// 생년월일을 반환하는 함수
	public String getBirthDate() {
		return birthDate;
	}

	// 생년월일을 수정하는 함수
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	// 전화번호를 반환하는 함수
	public String getPhoneNumber() {
		return phoneNumber;
	}

	// 전화번호를 수정하는 함수
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// 주소를 반환하는 함수
	public String getAddress() {
		return address;
	}

	// 주소를 수정하는 함수
	public void setAddress(String address) {
		this.address = address;
	}

	// 이메일을 반환하는 함수
	public String geteMail() {
		return eMail;
	}

	// 이메일을 수정하는 함수
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	// 비밀번호찾기 질문을 반환하는 함수
	public String getPwQuestion() {
		return pwQuestion;
	}

	// 비밀번호찾기 질문을 수정하는 함수
	public void setPwQuestion(String pwQuestion) {
		this.pwQuestion = pwQuestion;
	}

	// 비밀번호찾기 답변을 반환하는 함수
	public String getPwQuestionAnswer() {
		return pwQuestionAnswer;
	}

	// 비밀번호찾기 답변을 수정하는 함수
	public void setPwQuestionAnswer(String pwQuestionAnswer) {
		this.pwQuestionAnswer = pwQuestionAnswer;
	}

}