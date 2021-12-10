package posProject;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO 보고서Class
public class Report_b extends ProductPurchaseList_b {
    // 일, 월, 년, 순이익을 계산하는 클래스 입니다.
    public SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
    public SimpleDateFormat format2 = new SimpleDateFormat("yyyyMM");
    public SimpleDateFormat format3 = new SimpleDateFormat("yyyy");
    public Date time = new Date();
    public String time1 = format1.format(time);
    public String time2 = format2.format(time);
    public String time3 = format3.format(time);
    public int sum = 0;
    public int usum = 0;
    public int psum = 0;
    public String report;


    // TODO 당일 매출과 이익 문자열 반환
    public String day() {
        // 반환 형식 ex) 9200,6700 9200은 매출이고 6700원은 순이익 입니다.
        // 구분자는 . 입니다.
        for (int a = 0; a < purchaseList.size(); a++) {
            String[] strArr = purchaseList.get(a).split("\\.");
            String aa = strArr[0].substring(0, 8);
            if ((Integer.parseInt(aa)) == (Integer.parseInt(time1))) {
                int price = Integer.parseInt(strArr[2]);
                int num = Integer.parseInt(strArr[3]);
                int uprice = Integer.parseInt(strArr[4]);
                sum += price * num;
                usum += uprice * num;
            }
        }
        psum = sum - usum;
        report = sum + "," + psum;
        sum = 0;
        usum = 0;
        return report;
    }

    // TODO 월 매출과 이익 반환
    public String month() {
        // 반환 형식 9200,6700 9200은 매출이고 6700원은 순이익 입니다. 구분자는 , 입니다.
        for (int a = 0; a < purchaseList.size(); a++) {
            String[] strArr = purchaseList.get(a).split("\\.");
            String aa = strArr[0].substring(0, 6);
            if ((Integer.parseInt(aa)) == (Integer.parseInt(time2))) {
                int price = Integer.parseInt(strArr[2]);
                int num = Integer.parseInt(strArr[3]);
                int uprice = Integer.parseInt(strArr[4]);
                sum += price * num;
                usum += uprice * num;
            }
        }
        psum = sum - usum;
        report = sum + "," + psum;
        sum = 0;
        usum = 0;
        return report;
    }

    // TODO 연 매출과 이익을 문자열로 반환
    public String year() {
        // 반환 형식 9200,6700 9200은 매출이고 6700원은 순이익 입니다. 구분자는 , 입니다.
        for (int a = 0; a < purchaseList.size(); a++) {
            String[] strArr = purchaseList.get(a).split("\\.");
            String aa = strArr[0].substring(0, 4);
            if ((Integer.parseInt(aa)) == (Integer.parseInt(time3))) {
                int price = Integer.parseInt(strArr[2]);
                int num = Integer.parseInt(strArr[3]);
                int uprice = Integer.parseInt(strArr[4]);
                sum += price * num;
                usum += uprice * num;
            }
        }
        psum = sum - usum;
        report = sum + "," + psum;
        sum = 0;
        usum = 0;
        return report;
    }

}
