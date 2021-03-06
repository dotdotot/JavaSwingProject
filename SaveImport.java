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

                    String product_name = userList.get(i).pos.product_b.get(ii).getProduct_name(); // ????????????
                    userData += product_name + productDString;

                    int product_price = userList.get(i).pos.product_b.get(ii).getProduct_price(); // ????????????
                    userData += product_price + productDString;

                    int product_num = userList.get(i).pos.product_b.get(ii).getProduct_num(); // ????????????
                    userData += product_num + productDString;

                    int product_Uprice = userList.get(i).pos.product_b.get(ii).getProduct_Uprice(); // ????????????
                    userData += product_Uprice + productDString;

                    String product_description = userList.get(i).pos.product_b.get(ii).getProduct_description(); // ????????????
                    userData += product_description + productDString;

                    int product_discount = userList.get(i).pos.product_b.get(ii).getProduct_discount();
                    userData += product_discount + productDString;
                }

                for (int ii = 0; ii < userList.get(i).pos.expirationDate_b.size(); ii++) {
                    String expirationDString = "!%";

                    String expiration_name = userList.get(i).pos.expirationDate_b.get(ii).getProduct_name(); // ????????????
                    userData += expiration_name + expirationDString;

                    int expiration_price = userList.get(i).pos.expirationDate_b.get(ii).getProduct_price(); // ????????????
                    userData += expiration_price + expirationDString;

                    int expiration_num = userList.get(i).pos.expirationDate_b.get(ii).getProduct_num(); // ????????????
                    userData += expiration_num + expirationDString;

                    int expiration_Uprice = userList.get(i).pos.expirationDate_b.get(ii).getProduct_Uprice(); // ????????????
                    userData += expiration_Uprice + expirationDString;

                    String expiration_description = userList.get(i).pos.expirationDate_b.get(ii)
                            .getProduct_description(); // ????????????
                    userData += expiration_description + expirationDString;

                    int expiration_discount = userList.get(i).pos.expirationDate_b.get(ii).getProduct_discount();
                    userData += expiration_discount + expirationDString;

                    String expiration_exDate = userList.get(i).pos.expirationDate_b.get(ii).getExDate();
                    userData += expiration_exDate + expirationDString;
                }

                for (int ii = 0; ii < userList.get(i).pos.seatCheck_b.size(); ii++) {
                    String seatDString = "!&";

                    String seat_name = userList.get(i).pos.seatCheck_b.get(ii).getProduct_name(); // ????????????
                    userData += seat_name + seatDString;

                    int seat_price = userList.get(i).pos.seatCheck_b.get(ii).getProduct_price(); // ????????????
                    userData += seat_price + seatDString;

                    int seat_num = userList.get(i).pos.seatCheck_b.get(ii).getProduct_num(); // ????????????
                    userData += seat_num + seatDString;

                    int seat_Uprice = userList.get(i).pos.seatCheck_b.get(ii).getProduct_Uprice(); // ????????????
                    userData += seat_Uprice + seatDString;

                    String seat_description = userList.get(i).pos.seatCheck_b.get(ii).getProduct_description(); // ????????????
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
            // ?????? ?????? ??????
            File file = new File("c:\\javaTxt\\userList_Product.txt");
            // ?????? ????????? ??????
            FileReader filereader = new FileReader(file);
            // ?????? ?????? ??????
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
                    String product_name = productArr[i]; // ????????????
                    ++i;
                    int product_price = Integer.parseInt(productArr[i]); // ????????????
                    ++i;
                    int product_num = Integer.parseInt(productArr[i]); // ????????????
                    ++i;
                    int product_Uprice = Integer.parseInt(productArr[i]); // ????????????
                    ++i;
                    String product_description = productArr[i]; // ????????????
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
                    String product_name = expirationArr[i]; // ????????????
                    ++i;
                    int product_price = Integer.parseInt(expirationArr[i]); // ????????????
                    ++i;
                    int product_num = Integer.parseInt(expirationArr[i]); // ????????????
                    ++i;
                    int product_Uprice = Integer.parseInt(expirationArr[i]); // ????????????
                    ++i;
                    String product_description = expirationArr[i]; // ????????????
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
                    String product_name = seatArr[i]; // ????????????
                    ++i;
                    int product_price = Integer.parseInt(seatArr[i]); // ????????????
                    ++i;
                    int product_num = Integer.parseInt(seatArr[i]); // ????????????
                    ++i;
                    int product_Uprice = Integer.parseInt(seatArr[i]); // ????????????
                    ++i;
                    String product_description = seatArr[i]; // ????????????
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

            // .readLine()??? ?????? ??????????????? ?????? ?????????.
            bufReader.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        ArrayList<User> user = new ArrayList<User>();
        User u1 = new User("123", "123", "?????????", "???", "1998-03-08", "010-9206-9486", "?????? ?????? ????????? 543-16",
                "dotdotot203@naver.com", "?????? 1???????", "???");

        // ?????? ??????????????? ??????
        u1.pos.productPlus("?????????", 1500, 100, 1000, "???????????????", 0, "20220108");
        u1.pos.productPlus("??????", 1800, 150, 800, "??????????????? ??????", 5, "20220307");
        u1.pos.productPlus("????????????", 1200, 60, 500, "???????????? ??????", 0, "20220307");
        u1.pos.productPlus("?????????", 4500, 10, 3000, "????????? ??? ?????? ??????", 10, "20220307");
        u1.pos.productPlus("????????????", 800, 300, 300, "??????????????????", 0, "20220307");
        u1.pos.productPlus("?????????", 1400, 100, 800, "???????????? ?????? ??? ?????? ??????????????? ??????", 0, "20220309");
        u1.pos.productPlus("???????????????", 1600, 100, 900, "???????????? ?????? ??? ?????? ??????????????? ????????????", 0, "20220307");
        u1.pos.productPlus("??????", 2300, 40, 1500, "????????? ???????????? ?????? ??????", 0, "20220307");
        u1.pos.productPlus("?????????", 900, 100, 400, "????????? ??????.. ?????????", 0, "20220824");
        u1.pos.productPlus("?????????", 10000, 3, 6500, "??????????????????", 0);

        // ?????? ??????????????? ??????
        u1.pos.productSeatPlus("????????? ?????? ??? ??????", 8000, 5000, "?????? ??????????????? ?????? ????????? ????????? ??? ??????!", 0);
        u1.pos.productSeatPlus("?????? ?????? ?????????1", 8000, 5000, "?????????", 0);
        u1.pos.productSeatPlus("????????? ?????? ??? ??????2", 8000, 5000, "??????", 0);
        u1.pos.productSeatPlus("????????? ?????? ??? ??????3", 8000, 5000, "???", 0);
        u1.pos.productSeatPlus("???????????????", 8000, 5000, "???????????????2", 0);
        u1.pos.productSeatPlus("???????????????", 8000, 5000, "???????????????3", 0);
        u1.pos.productSeatPlus("??????", 8000, 5000, "??????1", 0);
        u1.pos.productSeatPlus("???", 8000, 5000, "???0", 0);
        u1.pos.productSeatPlus("?????????", 8000, 5000, "?????????55", 0);

        // ?????? ??????????????? ??????
        u1.pos.report_b.setPurchaseList("19980308112208.???.1200.1.500");
        u1.pos.report_b.setPurchaseList("20180430090000.???.1200.1.500");
        u1.pos.report_b.setPurchaseList("20180722063000.???.1200.1.500");
        u1.pos.report_b.setPurchaseList("20191225063000.??????.1200.1.500");
        u1.pos.report_b.setPurchaseList("20200108073144.??????.1200.1.500");
        u1.pos.report_b.setPurchaseList("20210930001507.??????.1200.1.500");
        u1.pos.report_b.setPurchaseList("20211201002300.?????????.1200.1.500");
        u1.pos.report_b.setPurchaseList("20211211043027.?????????.1200.1.500");
        u1.pos.report_b.setPurchaseList("20211222150000.?????????.1200.1.500");

        user.add(u1);

        User u2 = new User("234", "234", "?????????", "???", "1969-02-10", "010-5005-4307", "??????",
                "dbsdo3378@naver.com", "?????? 1???????", "??????");

        // ?????? ??????????????? ??????
        u2.pos.productPlus("?????????", 1500, 100, 1000, "???????????????", 0, "20220108");
        u2.pos.productPlus("??????", 1800, 150, 800, "??????????????? ??????", 5, "20220307");
        u2.pos.productPlus("????????????", 1200, 60, 500, "???????????? ??????", 0, "20220307");
        u2.pos.productPlus("?????????", 4500, 10, 3000, "????????? ??? ?????? ??????", 10, "20220307");
        u2.pos.productPlus("????????????", 800, 300, 300, "??????????????????", 0, "20220307");
        u2.pos.productPlus("?????????", 1400, 100, 800, "???????????? ?????? ??? ?????? ??????????????? ??????", 0, "20220309");
        u2.pos.productPlus("???????????????", 1600, 100, 900, "???????????? ?????? ??? ?????? ??????????????? ????????????", 0, "20220307");
        u2.pos.productPlus("??????", 2300, 40, 1500, "????????? ???????????? ?????? ??????", 0, "20220307");
        u2.pos.productPlus("?????????", 900, 100, 400, "????????? ??????.. ?????????", 0, "20220824");
        u2.pos.productPlus("?????????", 10000, 3, 6500, "??????????????????", 0);

        // ?????? ??????????????? ??????
        u2.pos.productSeatPlus("????????? ?????? ??? ??????", 8000, 5000, "?????? ??????????????? ?????? ????????? ????????? ??? ??????!", 0);
        u2.pos.productSeatPlus("?????? ?????? ?????????1", 8000, 5000, "?????????", 0);
        u2.pos.productSeatPlus("????????? ?????? ??? ??????2", 8000, 5000, "??????", 0);
        u2.pos.productSeatPlus("????????? ?????? ??? ??????3", 8000, 5000, "???", 0);
        u2.pos.productSeatPlus("???????????????", 8000, 5000, "???????????????2", 0);
        u2.pos.productSeatPlus("???????????????", 8000, 5000, "???????????????3", 0);
        u2.pos.productSeatPlus("??????", 8000, 5000, "??????1", 0);
        u2.pos.productSeatPlus("???", 8000, 5000, "???0", 0);
        u2.pos.productSeatPlus("?????????", 8000, 5000, "?????????55", 0);

        // ?????? ??????????????? ??????
        u2.pos.report_b.setPurchaseList("19980308112208.???.1200.1.500");
        u2.pos.report_b.setPurchaseList("20180430090000.???.1200.1.500");
        u2.pos.report_b.setPurchaseList("20180722063000.???.1200.1.500");
        u2.pos.report_b.setPurchaseList("20191225063000.??????.1200.1.500");
        u2.pos.report_b.setPurchaseList("20200108073144.??????.1200.1.500");
        u2.pos.report_b.setPurchaseList("20210930001507.??????.1200.1.500");
        u2.pos.report_b.setPurchaseList("20211201002300.?????????.1200.1.500");
        u2.pos.report_b.setPurchaseList("20211211043027.?????????.1200.1.500");
        u2.pos.report_b.setPurchaseList("20211222150000.?????????.1200.1.500");

        user.add(u2);

        SaveImport s = new SaveImport();
        s.save(user);
        s.load(user);

        System.out.println("user : " + user.size() + " /product : " + user.get(0).pos.product_b.size()
                + " /expiration : " + user.get(0).pos.expirationDate_b.size() + " /seatcheck : "
                + user.get(0).pos.seatCheck_b.size() + " /report : " + user.get(0).pos.report_b.purchaseList.size());

        System.out.println(user.get(2).getId() + " " + user.get(2).getPw() + " " + user.get(2).getName() + "product : " + user.get(2).pos.product_b.size()
        + " /expiration : " + user.get(2).pos.expirationDate_b.size() + " /seatcheck : "
        + user.get(2).pos.seatCheck_b.size() + " /report : " + user.get(2).pos.report_b.purchaseList.size());

        System.out.println(user.get(3).getId() + " " + user.get(3).getPw() + " " + user.get(3).getName() + "product : " + user.get(3).pos.product_b.size()   
        + " /expiration : " + user.get(3).pos.expirationDate_b.size() + " /seatcheck : "
        + user.get(3).pos.seatCheck_b.size() + " /report : " + user.get(3).pos.report_b.purchaseList.size());
    }
}
