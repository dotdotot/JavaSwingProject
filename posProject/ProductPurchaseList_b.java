package posProject;

import java.text.SimpleDateFormat;
import java.util.*;

// TODO 구매내역Class (MoviePos)
public class ProductPurchaseList_b {
    // 제품 구입 내역을 저장하고 반환하는 클래스 입니다.
    public List<String> purchaseList = new ArrayList<String>();
    public int sum = 0;
    public int usum = 0;

    // TODO 주문번호를 넣으면 주문내역 반환
    public String getPurchaseList(String orderNumber) {
        // 주문번호를 넣으면 해당하는 주문내역을 반환하는 메소드입니다. 만약 주문번호와 일치하는 주문내역이 없으면 "주문번호와 일치하는 내역이
        // 없습니다"를 반환합니다. 주문내역이 존재한다면"20211111234430.삼다수.1200.1.500" 형식의 문자열을 반환합니다.
        String purchase = "";
        if(purchaseList.size() == 0){
            purchase = "주문번호와 일치하는 내역이 없습니다";
        }

        for (int a = 0; a < purchaseList.size(); a++) {
            String[] strArr = purchaseList.get(a).split("\\.");
            if ((strArr[0]).equals(orderNumber)) {
                purchase = purchaseList.get(a);
                break;
            } else {
                purchase = "주문번호와 일치하는 내역이 없습니다";
            }
        }
        System.out.println(purchase);
        return purchase;
    }

    // TODO 주문기록 저장
    public void setPurchaseList(String string) {
        System.out.println(string + "의 기록을 저장하겠습니다.");
        // "20211111234430.삼다수.1200.1.500" 형식의 문자열을 매개변수로 받습니다.
        this.purchaseList.add(string);

        System.out.println("현재 저장된 장부 개수 : " + purchaseList.size());
    }

    // TODO 환불을 위한 메소드 반환값
    public String[] delPurchaseLis(String orderNumber) {
        // 환불을 위한 메소드로 반환값으로 환불 결과를 boolean형태로 반환합니다. 매개변수 값으로 주문번호인 14자리 숫자를 받습니다
        String[] strArr = null;
        for (int a = 0; a < purchaseList.size(); a++) {
            strArr = purchaseList.get(a).split("\\.");
            if ((strArr[0]).equals(orderNumber)) {
                purchaseList.remove(a);
                break;
            }
        }
        return strArr;
    }

    // TODO 마지막 주문의 주문내역 반환
    public String endPurchaseLis() {
        String endp = "";
        // "20211111234430.삼다수.1200.1.500"위 형식의 문자열로 반환합니다.
        if(purchaseList.size() == 0){
            endp = "주문내역이 없습니다.";
        }else{
            endp = purchaseList.get((purchaseList.size()) - 1);
        }
        return endp;
    }

    // TODO 월 주문내역 반환
    public String monthList(){
        String text = "";

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        String day = format.format(date);

        for(int i =0; i< purchaseList.size();i++){
            String str = purchaseList.get(i).substring(0,6);
            if(day.equals(str)){
                text += purchaseList.get(i) + "/";
            }
        }

        return text;
    }
    // TODO 년 주문내역 반환
    public String yearList(){
        String text = "";

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String day = format.format(date);

        for(int i =0; i< purchaseList.size();i++){
            String str = purchaseList.get(i).substring(0,4);
            if(day.equals(str)){
                text += purchaseList.get(i) + "/";
            }
        }

        return text;
    }
}
