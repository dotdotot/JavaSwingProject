package posProject;

// TODO 유통기간class
public class ExpirationDate_b extends Product_b {
    // 유통기간
    private String exDate;

    // 매개변수를 받는 생성자
    public ExpirationDate_b(String name, int price, int pnum, int uprice, String description, int discount,
            String exDate) {
        // 부모 class 생성자 호출
        super(name, price, pnum, uprice, description, discount);
        this.exDate = exDate;
    }

    // TODO 유통기한 getter
    public String getExDate() {
        return exDate;
    }

    // TODO 유통기한 setter
    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

}
