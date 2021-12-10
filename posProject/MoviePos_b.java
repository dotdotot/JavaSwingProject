package posProject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.*;

// TODO 영화class
public class MoviePos_b {
    // 영화 포스기에 필요한 대부분의 기능을 구현합니다.
    public List<Product_b> product_b = new ArrayList<Product_b>();
    public List<ExpirationDate_b> expirationDate_b = new ArrayList<ExpirationDate_b>();
    public List<SeatCheck_b> seatCheck_b = new ArrayList<SeatCheck_b>();
    public Report_b report_b = new Report_b();

    // TODO 유통기한이 없는 상품 메소드
    public void productPlus(String name, int price, int pnum, int uprice, String description, int discount) {
        product_b.add(new Product_b(name, price, pnum, uprice, description, discount));
    }

    // TODO 유통기한이 있는 상품 메소드
    public void productPlus(String name, int price, int pnum, int uprice, String description, int discount,
            String exDate) {
        expirationDate_b.add(new ExpirationDate_b(name, price, pnum, uprice, description, discount, exDate));
    }

    // TODO 좌석이 있는 상품 메소드
    public void productSeatPlus(String name, int price, int uprice, String description, int discount) {
        seatCheck_b.add(new SeatCheck_b(name, price, uprice, description, discount));
    }

    // TODO 상품 삭제 메서드
    public void productMinus() {
        // 좌석이 있는 상품과 없는 상품을 분리하는가?? 상품 삭제시 기존 상품을 띄어주고 선택을 하는 가 ??
        // 상품의 상세정보가 들어가는가??
    }

    // TODO 상품 수량 마이너스 + 장부추가
    public void productBuy(String text, int index) {
        Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateFormet = format.format(now);

        int productIndex = 0;
        boolean expirationDate = false;
        boolean product = false;
        boolean seat = false;

        // 유통기한 상품인지 검사
        if(expirationDate == false){
            for(int i = 0; i < expirationDate_b.size();i++){
                if(text.equals(expirationDate_b.get(i).getProduct_name() + "  " + expirationDate_b.get(i).getProduct_price()+"원")){
                    productIndex = i;
                    expirationDate = true;
                    break;
                }
            }
        }
        // 유통기한 x 상품인지 검사
        if (product == false){
            for(int i = 0; i < product_b.size();i++){
                if(text.equals(product_b.get(i).getProduct_name() + "  " + product_b.get(i).getProduct_price()+"원")){
                    productIndex = i;
                    product = true;
                    break;
                }
            }
        }
        // 좌석상품인지 검사
        if (seat == false){
            for(int i = 0; i < seatCheck_b.size();i++){
                if(text.equals(seatCheck_b.get(i).getProduct_name() + "  " + seatCheck_b.get(i).getProduct_price()+"원")){
                    productIndex = i;
                    seat = true;
                    break;
                }
            }
        }
        
        // 위에 코드에서 나온 결과로 수량 - 
        if(expirationDate == true){
            // 장부기록용
            dateFormet = dateFormet + "." + expirationDate_b.get(productIndex).getProduct_name() + "." + expirationDate_b.get(productIndex).getProduct_price()
            + "." + index + "." + expirationDate_b.get(productIndex).getProduct_Uprice();
            report_b.setPurchaseList(dateFormet);

            // 수량 -
            int expirationDateNum = expirationDate_b.get(productIndex).getProduct_num() - index;
            expirationDate_b.get(productIndex).setProduct_num(expirationDateNum);
        }else if (product == true){
            // 장부기록용
            dateFormet = dateFormet + "." + product_b.get(productIndex).getProduct_name() + "." + product_b.get(productIndex).getProduct_price()
            + "." + index + "." + product_b.get(productIndex).getProduct_Uprice();
            report_b.setPurchaseList(dateFormet);
            // 수량 -
            int productNum = product_b.get(productIndex).getProduct_num() - index;
            product_b.get(productIndex).setProduct_num(productNum);
        }
        // 좌석 상품이라면 배열을 수정해야함
        else if (seat == true){
            // 장부추가용
            System.out.println("dd");
            //
            dateFormet = dateFormet + "." + seatCheck_b.get(productIndex).getProduct_name() + "." + seatCheck_b.get(productIndex).getProduct_price()
            + ".1." + seatCheck_b.get(productIndex).getProduct_Uprice() + "." + index;
            //
            System.out.println("oo");

            report_b.setPurchaseList(dateFormet);
        }
    }

    // TODO 환불 메소드
    public boolean productRefund(String orderNumber) {
        // 매개변수로 주문번호14자리를 받습니다. 리턴값으로는 Ture면 환불성공 false면 실패입니다.
        // 기능은 장부에 있는 매출을 삭제합나다. 해당 영수증이 영화매출이라면 좌석을 취소하고 상품이라면 수량을 팔린만큼 다시 추가해줍니다.

        // 환불 성공과 실패여부 저장하는 변수
        boolean a = false;
        // 구매내역 클래스에서 구분자로 분리한 환불내용을 받기위한 문자열 배열입니다.
        String[] number;
        // 해당 주문번호가 존재하는지를 확인합니다.
        String report = report_b.getPurchaseList(orderNumber);
        if (report.equals("주문번호와 일치하는 내역이 없습니다")) {
            a = false;
        } else {
            // 주문을 환불하는 메소드를 호출합니다. 호출시 환불한 정보를 구분자로 분리하여 배열로 반환합니다. 반환한 정보를 number배열에
            // 넣었습니다.
            number = report_b.delPurchaseLis(orderNumber);
            // 배열의 길이가 6이면 영화 주문내역으로 영화 좌석을 취소해 줍니다.
            if (number.length == 6) {
                int seatN = Integer.parseInt(number[5]);
                int pn = Integer.parseInt(number[3]);
                for (int i = 0; i < seatCheck_b.size(); i++) {
                    if (number[1].equals(seatCheck_b.get(i).getProduct_name())) {
                        int pnum = seatCheck_b.get(i).getProduct_num();
                        seatCheck_b.get(i).setProduct_num(pnum + 1); // 영화 수량을 증가합니다.
                        seatCheck_b.get(i).setSeetc(seatN); // 영화 좌석을 빈 좌석으로 변경합니다.
                        a = true;
                        break;
                    }
                }
            }
            // 배열의 길이가 5 이므로 일반 상품입니다. 따라서 수량만을 다시 더해줍니다.
            else if (number.length == 5) {
                int pn = Integer.parseInt(number[3]);
                for (int i = 0; i < expirationDate_b.size(); i++) {
                    if (number[1].equals(expirationDate_b.get(i).getProduct_name())) {
                        int pnum = expirationDate_b.get(i).getProduct_num();
                        expirationDate_b.get(i).setProduct_num(pnum + pn);
                        a = true;
                        break;
                    }
                }
                for (int k = 0; k < product_b.size(); k++) {
                    if (number[1].equals(product_b.get(k).getProduct_name())) {
                        int pnum = product_b.get(k).getProduct_num();
                        product_b.get(k).setProduct_num(pnum + pn);
                        a = true;
                        break;
                    }
                }
            }
        }
        return a;
    }
}
