import java.util.*;

import posProject.*;
import java.io.*;

public class SaveImport {

    public void save(ArrayList<User> userList) {

        try {
            FileWriter fstream = new FileWriter("c:\\javaTxt\\userList_Product.txt");
            String userData = "";

            for (int i = 0; i < userList.size(); i++) {
                userData = "";
                String userDString = "!@";

                String id = userList.get(i).getId();
                userData += id + userDString;

                String pw = userList.get(i).getPw();
                userData += pw + userDString;

                String name = userList.get(i).getName();
                userData += name + userDString;

                String gender = userList.get(i).getGender();
                userData += gender + userDString;

                String birthDate = userList.get(i).getBirthDate();
                userData += birthDate + userDString;

                String phoneNumber = userList.get(i).getPhoneNumber();
                userData += phoneNumber + userDString;

                String address = userList.get(i).getAddress();
                userData += address + userDString;

                String eMail = userList.get(i).geteMail();
                userData += eMail + userDString;

                String pwQuestion = userList.get(i).getPwQuestion();
                userData += pwQuestion + userDString;

                String pwQuestionAnswer = userList.get(i).getPwQuestionAnswer();
                userData += pwQuestionAnswer + userDString;

                // System.out.println("product_b : " + userList.get(i).pos.product_b.size() + " / expir : "
                //         + userList.get(i).pos.expirationDate_b.size()
                //         + " /seatCheck : " + userList.get(i).pos.seatCheck_b.size() + " /report : "
                //         + userList.get(i).pos.report_b.purchaseList.size());

                for (int ii = 0; ii < userList.get(i).pos.product_b.size(); ii++) {
                    String productDString = "!#";

                    String product_name = userList.get(i).pos.product_b.get(ii).getProduct_name(); // 상품이름
                    userData += product_name + productDString;

                    int product_price = userList.get(i).pos.product_b.get(ii).getProduct_price(); // 상품가격
                    userData += product_price + productDString;

                    int product_num = userList.get(i).pos.product_b.get(ii).getProduct_num(); // 상품수량
                    userData += product_num + productDString;

                    int product_Uprice = userList.get(i).pos.product_b.get(ii).getProduct_Uprice(); // 상품단가
                    userData += product_Uprice + productDString;

                    String product_description = userList.get(i).pos.product_b.get(ii).getProduct_description(); // 상품설명
                    userData += product_description + productDString;

                    int product_discount = userList.get(i).pos.product_b.get(ii).getProduct_discount();
                    userData += product_discount + productDString;
                }

                for (int ii = 0; ii < userList.get(i).pos.expirationDate_b.size(); ii++) {
                    String expirationDString = "!%";

                    String expiration_name = userList.get(i).pos.expirationDate_b.get(ii).getProduct_name(); // 상품이름
                    userData += expiration_name + expirationDString;

                    int expiration_price = userList.get(i).pos.expirationDate_b.get(ii).getProduct_price(); // 상품가격
                    userData += expiration_price + expirationDString;

                    int expiration_num = userList.get(i).pos.expirationDate_b.get(ii).getProduct_num(); // 상품수량
                    userData += expiration_num + expirationDString;

                    int expiration_Uprice = userList.get(i).pos.expirationDate_b.get(ii).getProduct_Uprice(); // 상품단가
                    userData += expiration_Uprice + expirationDString;

                    String expiration_description = userList.get(i).pos.expirationDate_b.get(ii)
                            .getProduct_description(); // 상품설명
                    userData += expiration_description + expirationDString;

                    int expiration_discount = userList.get(i).pos.expirationDate_b.get(ii).getProduct_discount();
                    userData += expiration_discount + expirationDString;

                    String expiration_exDate = userList.get(i).pos.expirationDate_b.get(ii).getExDate();
                    userData += expiration_exDate + expirationDString;
                }

                for (int ii = 0; ii < userList.get(i).pos.seatCheck_b.size(); ii++) {
                    String seatDString = "!&";

                    String seat_name = userList.get(i).pos.seatCheck_b.get(ii).getProduct_name(); // 상품이름
                    userData += seat_name + seatDString;

                    int seat_price = userList.get(i).pos.seatCheck_b.get(ii).getProduct_price(); // 상품가격
                    userData += seat_price + seatDString;

                    int seat_num = userList.get(i).pos.seatCheck_b.get(ii).getProduct_num(); // 상품수량
                    userData += seat_num + seatDString;

                    int seat_Uprice = userList.get(i).pos.seatCheck_b.get(ii).getProduct_Uprice(); // 상품단가
                    userData += seat_Uprice + seatDString;

                    String seat_description = userList.get(i).pos.seatCheck_b.get(ii).getProduct_description(); // 상품설명
                    userData += seat_description + seatDString;

                    int seat_discount = userList.get(i).pos.seatCheck_b.get(ii).getProduct_discount();
                    userData += seat_discount + seatDString;

                    for (int iii = 0; iii < 20; iii++) {
                        userData += userList.get(i).pos.seatCheck_b.get(ii).getSeetc(iii + 1) + seatDString;
                    }
                }

                for (int ii = 0; ii < userList.get(i).pos.report_b.purchaseList.size(); ii++) {
                    String purchaseDString = "@#";

                    if (ii == userList.get(i).pos.report_b.purchaseList.size() - 1) {
                        userData += userList.get(i).pos.report_b.purchaseList.get(ii);
                        break;
                    }
                    userData += userList.get(i).pos.report_b.purchaseList.get(ii) + purchaseDString;

                }

                userData += "\n";
                // System.out.println(userData);
                fstream.write(userData);
            }

            fstream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void load(ArrayList<User> userList) {
        try {
            // 파일 객체 생성
            File file = new File("c:\\javaTxt\\userList_Product.txt");
            // 입력 스트림 생성
            FileReader filereader = new FileReader(file);
            // 입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                // System.out.println();
                // System.out.println("userArr");
                String[] userArr = line.split("!@");
                // for (int i = 0; i < userArr.length; i++) {
                //     System.out.println(userArr[i]);
                // }
                User u1 = new User(userArr[0], userArr[1], userArr[2], userArr[3], userArr[4], userArr[5], userArr[6],
                        userArr[7], userArr[8], userArr[9]);

                // System.out.println();
                // System.out.println("productArr");
                String[] productArr = userArr[userArr.length - 1].split("!#");
                // for (int i = 0; i < productArr.length; i++) {
                //     System.out.println(productArr[i]);
                // }
                for (int i = 0; i < productArr.length - 1; i++) {
                    String product_name = productArr[i]; // 상품이름
                    ++i;
                    int product_price = Integer.parseInt(productArr[i]); // 상품가격
                    ++i;
                    int product_num = Integer.parseInt(productArr[i]); // 상품수량
                    ++i;
                    int product_Uprice = Integer.parseInt(productArr[i]); // 상품단가
                    ++i;
                    String product_description = productArr[i]; // 상품설명
                    ++i;
                    int product_discount = Integer.parseInt(productArr[i]);

                    Product_b p1 = new Product_b(product_name, product_price, product_num, product_Uprice,
                            product_description, product_discount);
                    u1.pos.product_b.add(p1);
                }

                // System.out.println();
                // System.out.println("expirationArr");
                String[] expirationArr = productArr[productArr.length - 1].split("!%");
                // for (int i = 0; i < expirationArr.length; i++) {
                //     System.out.println(expirationArr[i]);
                // }
                for (int i = 0; i < expirationArr.length - 1; i++) {
                    String product_name = expirationArr[i]; // 상품이름
                    ++i;
                    int product_price = Integer.parseInt(expirationArr[i]); // 상품가격
                    ++i;
                    int product_num = Integer.parseInt(expirationArr[i]); // 상품수량
                    ++i;
                    int product_Uprice = Integer.parseInt(expirationArr[i]); // 상품단가
                    ++i;
                    String product_description = expirationArr[i]; // 상품설명
                    ++i;
                    int product_discount = Integer.parseInt(expirationArr[i]);
                    ++i;
                    String exDate = expirationArr[i];

                    ExpirationDate_b e1 = new ExpirationDate_b(product_name, product_price, product_num, product_Uprice,
                            product_description, product_discount, exDate);
                    u1.pos.expirationDate_b.add(e1);
                }

                // System.out.println();
                // System.out.println("seat");
                String[] seatArr = expirationArr[expirationArr.length - 1].split("!&");
                // for (int i = 0; i < seatArr.length; i++) {
                //     System.out.println(seatArr[i]);
                // }
                for (int i = 0; i < seatArr.length - 1; i++) {
                    String product_name = seatArr[i]; // 상품이름
                    ++i;
                    int product_price = Integer.parseInt(seatArr[i]); // 상품가격
                    ++i;
                    int product_num = Integer.parseInt(seatArr[i]); // 상품수량
                    ++i;
                    int product_Uprice = Integer.parseInt(seatArr[i]); // 상품단가
                    ++i;
                    String product_description = seatArr[i]; // 상품설명
                    ++i;
                    int product_discount = Integer.parseInt(seatArr[i]);
                    ++i;

                    SeatCheck_b s1 = new SeatCheck_b(product_name, product_price, product_Uprice, product_description,
                            product_discount);

                    for (int ii = 0; ii < 20; ii++) {
                        if (seatArr[i].equals("false")) {
                            s1.setSeetc(ii + 1);
                        }
                        if (ii != 19) {
                            i++;
                        }
                    }

                    u1.pos.seatCheck_b.add(s1);
                }

                // System.out.println();
                // System.out.println("pruchase");
                String[] pruchaseArr = seatArr[seatArr.length - 1].split("@#");
                // for (int i = 0; i < pruchaseArr.length; i++) {
                //     System.out.println(pruchaseArr[i]);
                // }
                for (int i = 0; i < pruchaseArr.length; i++) {
                    String pruchase = pruchaseArr[i];
                    u1.pos.report_b.purchaseList.add(pruchase);
                }

                userList.add(u1);
            }

            // .readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        // ArrayList<User> user = new ArrayList<User>();
        // User u1 = new User("123", "123", "김준석", "남", "1998-03-08", "010-9206-9486", "대전 서구 도마동 543-16",
        //         "dotdotot203@naver.com", "보물 1호는?", "돈");

        // // 상품 데모데이터 추가
        // u1.pos.productPlus("홈런볼", 1500, 100, 1000, "홈런볼과자", 0, "20220108");
        // u1.pos.productPlus("썬칩", 1800, 150, 800, "바삭바삭한 과자", 5, "20220307");
        // u1.pos.productPlus("바나나킥", 1200, 60, 500, "바나나맛 과자", 0, "20220307");
        // u1.pos.productPlus("오예스", 4500, 10, 3000, "초콜릿 빵 같은 과자", 10, "20220307");
        // u1.pos.productPlus("누네띠네", 800, 300, 300, "누네띠네과자", 0, "20220307");
        // u1.pos.productPlus("새우깡", 1400, 100, 800, "어디서나 먹을 수 있는 중독성있는 과자", 0, "20220309");
        // u1.pos.productPlus("매운새우깡", 1600, 100, 900, "어디서나 먹을 수 있는 중독성있는 매운과자", 0, "20220307");
        // u1.pos.productPlus("빈츠", 2300, 40, 1500, "먹어본 사람들만 아는 과자", 0, "20220307");
        // u1.pos.productPlus("웨하스", 900, 100, 400, "중독성 진짜.. 대박임", 0, "20220824");
        // u1.pos.productPlus("기념품", 10000, 3, 6500, "기념품입니다", 0);

        // // 영화 데모데이터 추가
        // u1.pos.productSeatPlus("라스트 나잇 인 소호", 8000, 5000, "패션 디자이너의 꿈을 가지고 상경한 한 소녀!", 0);
        // u1.pos.productSeatPlus("연애 빠진 로맨스1", 8000, 5000, "로맨승", 0);
        // u1.pos.productSeatPlus("라스트 나잇 인 소호2", 8000, 5000, "나잇", 0);
        // u1.pos.productSeatPlus("라스트 나잇 인 소호3", 8000, 5000, "인", 0);
        // u1.pos.productSeatPlus("스파이더맨", 8000, 5000, "스파이더맨2", 0);
        // u1.pos.productSeatPlus("유체이탈자", 8000, 5000, "유체이탈자3", 0);
        // u1.pos.productSeatPlus("리슨", 8000, 5000, "리슨1", 0);
        // u1.pos.productSeatPlus("듄", 8000, 5000, "듄0", 0);
        // u1.pos.productSeatPlus("태일이", 8000, 5000, "태일이55", 0);

        // // 장부 데모데이터 추가
        // u1.pos.report_b.setPurchaseList("19980308112208.김.1200.1.500");
        // u1.pos.report_b.setPurchaseList("20180430090000.준.1200.1.500");
        // u1.pos.report_b.setPurchaseList("20180722063000.석.1200.1.500");
        // u1.pos.report_b.setPurchaseList("20191225063000.김김.1200.1.500");
        // u1.pos.report_b.setPurchaseList("20200108073144.준준.1200.1.500");
        // u1.pos.report_b.setPurchaseList("20210930001507.석석.1200.1.500");
        // u1.pos.report_b.setPurchaseList("20211201002300.김김김.1200.1.500");
        // u1.pos.report_b.setPurchaseList("20211211043027.준준준.1200.1.500");
        // u1.pos.report_b.setPurchaseList("20211222150000.석석석.1200.1.500");

        // user.add(u1);

        // User u2 = new User("234", "234", "박윤애", "여", "1969-02-10", "010-5005-4307", "서울",
        //         "dbsdo3378@naver.com", "보물 1호는?", "가족");

        // // 상품 데모데이터 추가
        // u2.pos.productPlus("홈런볼", 1500, 100, 1000, "홈런볼과자", 0, "20220108");
        // u2.pos.productPlus("썬칩", 1800, 150, 800, "바삭바삭한 과자", 5, "20220307");
        // u2.pos.productPlus("바나나킥", 1200, 60, 500, "바나나맛 과자", 0, "20220307");
        // u2.pos.productPlus("오예스", 4500, 10, 3000, "초콜릿 빵 같은 과자", 10, "20220307");
        // u2.pos.productPlus("누네띠네", 800, 300, 300, "누네띠네과자", 0, "20220307");
        // u2.pos.productPlus("새우깡", 1400, 100, 800, "어디서나 먹을 수 있는 중독성있는 과자", 0, "20220309");
        // u2.pos.productPlus("매운새우깡", 1600, 100, 900, "어디서나 먹을 수 있는 중독성있는 매운과자", 0, "20220307");
        // u2.pos.productPlus("빈츠", 2300, 40, 1500, "먹어본 사람들만 아는 과자", 0, "20220307");
        // u2.pos.productPlus("웨하스", 900, 100, 400, "중독성 진짜.. 대박임", 0, "20220824");
        // u2.pos.productPlus("기념품", 10000, 3, 6500, "기념품입니다", 0);

        // // 영화 데모데이터 추가
        // u2.pos.productSeatPlus("라스트 나잇 인 소호", 8000, 5000, "패션 디자이너의 꿈을 가지고 상경한 한 소녀!", 0);
        // u2.pos.productSeatPlus("연애 빠진 로맨스1", 8000, 5000, "로맨승", 0);
        // u2.pos.productSeatPlus("라스트 나잇 인 소호2", 8000, 5000, "나잇", 0);
        // u2.pos.productSeatPlus("라스트 나잇 인 소호3", 8000, 5000, "인", 0);
        // u2.pos.productSeatPlus("스파이더맨", 8000, 5000, "스파이더맨2", 0);
        // u2.pos.productSeatPlus("유체이탈자", 8000, 5000, "유체이탈자3", 0);
        // u2.pos.productSeatPlus("리슨", 8000, 5000, "리슨1", 0);
        // u2.pos.productSeatPlus("듄", 8000, 5000, "듄0", 0);
        // u2.pos.productSeatPlus("태일이", 8000, 5000, "태일이55", 0);

        // // 장부 데모데이터 추가
        // u2.pos.report_b.setPurchaseList("19980308112208.김.1200.1.500");
        // u2.pos.report_b.setPurchaseList("20180430090000.준.1200.1.500");
        // u2.pos.report_b.setPurchaseList("20180722063000.석.1200.1.500");
        // u2.pos.report_b.setPurchaseList("20191225063000.김김.1200.1.500");
        // u2.pos.report_b.setPurchaseList("20200108073144.준준.1200.1.500");
        // u2.pos.report_b.setPurchaseList("20210930001507.석석.1200.1.500");
        // u2.pos.report_b.setPurchaseList("20211201002300.김김김.1200.1.500");
        // u2.pos.report_b.setPurchaseList("20211211043027.준준준.1200.1.500");
        // u2.pos.report_b.setPurchaseList("20211222150000.석석석.1200.1.500");

        // user.add(u2);

        // SaveImport s = new SaveImport();
        // s.save(user);
        // s.load(user);

        // System.out.println("user : " + user.size() + " /product : " + user.get(0).pos.product_b.size()
        //         + " /expiration : " + user.get(0).pos.expirationDate_b.size() + " /seatcheck : "
        //         + user.get(0).pos.seatCheck_b.size() + " /report : " + user.get(0).pos.report_b.purchaseList.size());

        // System.out.println(user.get(2).getId() + " " + user.get(2).getPw() + " " + user.get(2).getName() + "product : " + user.get(2).pos.product_b.size()
        // + " /expiration : " + user.get(2).pos.expirationDate_b.size() + " /seatcheck : "
        // + user.get(2).pos.seatCheck_b.size() + " /report : " + user.get(2).pos.report_b.purchaseList.size());

        // System.out.println(user.get(3).getId() + " " + user.get(3).getPw() + " " + user.get(3).getName() + "product : " + user.get(3).pos.product_b.size()
        // + " /expiration : " + user.get(3).pos.expirationDate_b.size() + " /seatcheck : "
        // + user.get(3).pos.seatCheck_b.size() + " /report : " + user.get(3).pos.report_b.purchaseList.size());
    }
}
