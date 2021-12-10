package posProject;

public class TestCode {

	public static void main(String[] args) {
		
		// 좌석체크를 테스트하기 위한 부분입니다.
		SeatCheck_b a = new SeatCheck_b("부산행",15000,5000,"스릴공포 영화입니다.",5);
		for(int b = 0; b<20; b++) {
			System.out.println(b+"번"+ a.seetc[b]);
		}
		a.setSeetc(5);
		for(int b = 0; b<20; b++) {
			System.out.println(b+"번"+ a.seetc[b]);
		}
		a.setSeetc(5);
		for(int b = 0; b<20; b++) {
			System.out.println(b+"번"+ a.seetc[b]);
		}
		
		
		// 보고서 클래스 테스트 부분입니다.
		Report_b a12= new Report_b();
		a12.setPurchaseList("20211111234430.삼다수.1200.10.500");
		a12.setPurchaseList("20211111234490.삼다수.1200.1.500");
		a12.setPurchaseList("20211205245530.삼다수.1200.1.500");
		a12.setPurchaseList("20211205246030.삼다수.2000.4.500");
		System.out.println(a12.day());
		System.out.println(a12.month());
		System.out.println(a12.year());
		System.out.println(a12.endPurchaseLis());
		a12.delPurchaseLis("20211205246030");
		System.out.println(a12.day());
		System.out.println(a12.month());
		System.out.println(a12.year());
		System.out.println(a12.endPurchaseLis());
		
		System.out.println("----------------------------------------------------------");
		// 종합 코드 테스트 부분입니다.
		MoviePos_b pos = new MoviePos_b();
		pos.productPlus("우유",15000, 5,5000,"그냥 우유이다.",0);
		pos.productPlus("과자",15000, 5,5000,"과자이다.",0);
		pos.productPlus("고기",15000, 5,5000,"고기이다.",0);
		pos.productPlus("생선",15000, 5,5000,"생선이다.",0);
		pos.productPlus("팝콘",15000, 5,5000,"달달한 팝콘이다.",0);
		
		pos.productSeatPlus("부산행1",15000,5000,"스릴공포 영화입니다.",10);
		pos.productSeatPlus("부산행2",15000,5000,"스릴공포 영화입니다.",10);
		pos.productSeatPlus("부산행3",15000,5000,"스릴공포 영화입니다.",10);
		pos.productSeatPlus("부산행4",15000,5000,"스릴공포 영화입니다.",10);
		pos.productSeatPlus("부산행5",15000,5000,"스릴공포 영화입니다.",10);
		pos.report_b.setPurchaseList("20211020246030.우유.5000.3.500");
		pos.report_b.setPurchaseList("20211022246030.과자.5000.2.500");
		pos.report_b.setPurchaseList("20211105246030.고기.5000.1.500");
		pos.report_b.setPurchaseList("20211205246030.생선.5000.5.500");
		pos.report_b.setPurchaseList("20211205246030.팝콘.5000.2.500");
		pos.report_b.setPurchaseList("20211205246030.부산행.15000.1.5000.15");
		System.out.println(pos.report_b.day());
		System.out.println(pos.report_b.month());
		System.out.println(pos.report_b.year());
		pos.report_b.delPurchaseLis("20211205246030");
		System.out.println(pos.report_b.day());
		System.out.println(pos.report_b.month());
		System.out.println(pos.report_b.year());
		pos.report_b.delPurchaseLis("20211205246030");
		System.out.println(pos.report_b.day());
		System.out.println(pos.report_b.month());
		System.out.println(pos.report_b.year());
		
	}

}
