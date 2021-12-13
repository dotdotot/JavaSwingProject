디자인 - 월요일 수정예정
각각의 폼에 버튼 바꾸기 - 추후 수정예정

유저와 상품에 대한 정보를 저장하는 Class를 만들고 저장하고 불러오기까지 정상적으로 되는지 확인하기

// 데모데이터
	// User user = new User("123", "123", "김준석", "남", "1998-03-08", "010-9206-9486", "대전 서구 도마동 543-16",
	// 		"dotdotot203@naver.com", "보물 1호는?", "돈");
			
	// // 상품 데모데이터 추가
	// user.pos.productPlus("홈런볼", 1500, 100, 1000, "홈런볼과자", 0, "20220108");
	// user.pos.productPlus("썬칩", 1800, 150, 800, "바삭바삭한 과자", 5, "20220307");
	// user.pos.productPlus("바나나킥", 1200, 60, 500, "바나나맛 과자", 0, "20220307");
	// user.pos.productPlus("오예스", 4500, 10, 3000, "초콜릿 빵 같은 과자", 10, "20220307");
	// user.pos.productPlus("누네띠네", 800, 300, 300, "누네띠네과자", 0, "20220307");
	// user.pos.productPlus("새우깡", 1400, 100, 800, "어디서나 먹을 수 있는 중독성있는 과자", 0, "20220309");
	// user.pos.productPlus("매운새우깡", 1600, 100, 900, "어디서나 먹을 수 있는 중독성있는 매운과자", 0, "20220307");
	// user.pos.productPlus("빈츠", 2300, 40, 1500, "먹어본 사람들만 아는 과자", 0, "20220307");
	// user.pos.productPlus("웨하스", 900, 100, 400, "중독성 진짜.. 대박임", 0, "20220824");
	// user.pos.productPlus("기념품", 10000, 3, 6500, "기념품입니다", 0);

	// // 영화 데모데이터 추가
	// user.pos.productSeatPlus("라스트 나잇 인 소호", 8000, 5000, "패션 디자이너의 꿈을 가지고 상경한 한 소녀!", 0);
	// user.pos.productSeatPlus("연애 빠진 로맨스1", 8000, 5000, "로맨승", 0);
	// user.pos.productSeatPlus("라스트 나잇 인 소호2", 8000, 5000, "나잇", 0);
	// user.pos.productSeatPlus("라스트 나잇 인 소호3", 8000, 5000, "인", 0);
	// user.pos.productSeatPlus("스파이더맨", 8000, 5000, "스파이더맨2", 0);
	// user.pos.productSeatPlus("유체이탈자", 8000, 5000, "유체이탈자3", 0);
	// user.pos.productSeatPlus("리슨", 8000, 5000, "리슨1", 0);
	// user.pos.productSeatPlus("듄", 8000, 5000, "듄0", 0);
	// user.pos.productSeatPlus("태일이", 8000, 5000, "태일이55", 0);

	// // 장부 데모데이터 추가
	// user.pos.report_b.setPurchaseList("19980308112208.김.1200.1.500");
	// user.pos.report_b.setPurchaseList("20180430090000.준.1200.1.500");
	// user.pos.report_b.setPurchaseList("20180722063000.석.1200.1.500");
	// user.pos.report_b.setPurchaseList("20191225063000.김김.1200.1.500");
	// user.pos.report_b.setPurchaseList("20200108073144.준준.1200.1.500");
	// user.pos.report_b.setPurchaseList("20210930001507.석석.1200.1.500");
	// user.pos.report_b.setPurchaseList("20211201002300.김김김.1200.1.500");
	// user.pos.report_b.setPurchaseList("20211211043027.준준준.1200.1.500");
	// user.pos.report_b.setPurchaseList("20211222150000.석석석.1200.1.500");

	// userList.add(user);


    // // 회원가입 후 수정된 ArrayList를 가져와야하므로 가져오는 생성자
	// Login(ArrayList<User> user) {
	// 	userList = user;
	// 	// 메인 호출
	// 	this.main(null);
	// }