package posProject;

// TODO 상품class
public class Product_b {
    // 상품의 데이터구조를 가지고있는 클래스입니다.
    private String product_name; // 상품이름
    private int product_price; // 상품가격
    private int product_num; // 상품수량
    private int product_Uprice; // 상품단가
    private String product_description; // 상품설명
    private int product_discount; // 할인율


    // TODO 매개변수 생성자
    public Product_b(String name, int price, int pnum, int uprice, String description, int discount) { // 생성자 입니다.
        product_name = name;
        product_price = price;
        product_num = pnum;
        product_Uprice = uprice;
        product_description = description;
        product_discount = discount;

    }

    // TODO 이름 getter,setter
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    // TODO 가격 getter,setter
    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    // TODO 수량 getter,setter
    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    // TODO 단가 getter,setter
    public int getProduct_Uprice() {
        return product_Uprice;
    }

    public void setProduct_Uprice(int product_Uprice) {
        this.product_Uprice = product_Uprice;
    }

    // TODO 설명 getter,setter
    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    // TODO 할인율 getter,setter
    public int getProduct_discount() {
        return product_discount;
    }

    public void setProduct_discount(int product_discount) {
        this.product_discount = product_discount;
    }
}
