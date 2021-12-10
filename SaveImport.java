import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveImport {

	void userSave(ArrayList<User> userL) {// 저장하기 위한 메드 입니다.
		String as1 = ""; // 유저 정보를 한 줄의 문자열로 저장합니다.
		String as2 = ""; // 상품 정보를 한 줄의 문자열로 저장합니다.
		String as3 = ""; // 구매 내역을 한 줄의 문자열로 저장합니다.
		String separator1 = "//";// 유저 항목 분리를 위한 구분자 입니다.
		String separator2 = "//";// 상품 항목 분리를 위한 구분자 입니다.
		String separator3 = "*!*\n";//일반상품과 좌석 상품의 분리를 위한 구분자입니다.
		String filePath = "c:\\javaTxt\\userList.txt"; // 컴퓨터에 유저 정보를 저장할 위치를 담고 있습니다.
		for (int a1 = 0; a1 < userL.size(); a1++) { // 유저 배열의 길이만큼 반복합니다.
			String id = userL.get(a1).getId();
			String pw = userL.get(a1).getPw();
			as1 += id;
			as1 += separator1;
			as1 += pw;
			as1 += separator1;
			as1 += userL.get(a1).getName();
			as1 += separator1;
			as1 += userL.get(a1).getGender();
			as1 += separator1;
			as1 += userL.get(a1).getBirthDate();
			as1 += separator1;
			as1 += userL.get(a1).getPhoneNumber();
			as1 += separator1;
			as1 += userL.get(a1).getAddress();
			as1 += separator1;
			as1 += userL.get(a1).geteMail();
			as1 += separator1;
			as1 += userL.get(a1).getPwQuestion();
			as1 += "\n"; // 개행문자를 더하여 유저와 다른유저의 정보를 구분해 줍니다.
			for(int k = 0; k < userL.get(a1).pos.product_b.size(); k++) { // 일반 상품의 정보를 불러와 한 줄의 문자열 배열로 만듭니다. 각 항목을 분리해줄 구분자로//을 넣습니다. 
				as2 += userL.get(a1).pos.product_b.get(k).getProduct_name();
				as2 += separator2;
				as2 += userL.get(a1).pos.product_b.get(k).getProduct_price();
				as2 += separator2;
				as2 += userL.get(a1).pos.product_b.get(k).getProduct_num();
				as2 += separator2;
				as2 += userL.get(a1).pos.product_b.get(k).getProduct_Uprice();
				as2 += separator2;
				as2 += userL.get(a1).pos.product_b.get(k).getProduct_description();
				as2 += separator2;
				as2 += userL.get(a1).pos.product_b.get(k).getProduct_discount();
				as2 += "\n"; // 상품과 상품을 구분해줄수 있도록 개행문자를 추가합니다. 
			}
			as2 += separator3; // 일반상품, 유통기간이 있는상품, 좌석이 있는 상품 (정보)배열을 구분하기 위해 구분자로 *!*를 추가합니다.
			
			for(int k = 0; k < userL.get(a1).pos.expirationDate_b.size(); k++) {// 유통기간이 있는 상품의 정보를 불러와 한 줄의 문자열 배열로 만듭니다. 각 항목을 분리해줄 구분자로//을 넣습니다. 
				as2 += userL.get(a1).pos.expirationDate_b.get(k).getProduct_name();
				as2 += separator2;
				as2 += userL.get(a1).pos.expirationDate_b.get(k).getProduct_price();
				as2 += separator2;
				as2 += userL.get(a1).pos.expirationDate_b.get(k).getProduct_num();
				as2 += separator2;
				as2 += userL.get(a1).pos.expirationDate_b.get(k).getProduct_Uprice();
				as2 += separator2;
				as2 += userL.get(a1).pos.expirationDate_b.get(k).getProduct_description();
				as2 += separator2;
				as2 += userL.get(a1).pos.expirationDate_b.get(k).getProduct_discount();
				as2 += separator2;
				as2 += userL.get(a1).pos.expirationDate_b.get(k).getExDate();
				as2 += "\n"; // 상품과 상품을 구분해줄수 있도록 개행문자를 추가합니다. 
			}
			as2 += separator3; // 일반상품, 유통기간이 있는상품, 좌석이 있는 상품 (정보)배열을 구분하기 위해 구분자로 *!*를 추가합니다.
			
			for(int k = 0; k < userL.get(a1).pos.seatCheck_b.size(); k++) { // 좌석정보를 가지고있는 상품 정보를 불러와 한 줄의 문자열 배열로 만듭니다. 각 항목을 분리해줄 구분자로//을 넣습니다. 
				int abc = 0; // 구분문자 추가 여부를 결정하는 변수입니다.
				as2 += userL.get(a1).pos.seatCheck_b.get(k).getProduct_name();
				as2 += separator2;
				as2 += userL.get(a1).pos.seatCheck_b.get(k).getProduct_price();
				as2 += separator2;
				as2 += userL.get(a1).pos.seatCheck_b.get(k).getProduct_num();
				as2 += separator2;
				as2 += userL.get(a1).pos.seatCheck_b.get(k).getProduct_Uprice();
				as2 += separator2;
				as2 += userL.get(a1).pos.seatCheck_b.get(k).getProduct_description();
				as2 += separator2;
				as2 += userL.get(a1).pos.seatCheck_b.get(k).getProduct_discount();
				for(int movie1 = 0; movie1< 20; movie1++) {
					if ((userL.get(a1).pos.seatCheck_b.get(k).getSeetc(movie1))==false) { // 예매가 완료된 좌석의 번호를 불러와 한 줄의 문자열로 저장합니다. 좌석과 다른 좌석의 번호는 구분자"." 으로 설정하였습니다. 
						if(abc == 0) {
							as2 += movie1;
							abc ++;
						} else {
							as2 += ".";
							as2 += movie1;;
						}
					}
				}
				as2 += "\n"; // 상품과 상품을 구분해줄수 있도록 개행문자를 추가합니다. 
			}
			for(int k = 0; k < userL.get(a1).pos.report_b.purchaseList.size(); k++) { // 구매내역을 불러와 문자열로 저장합니다.
				as3 += userL.get(a1).pos.report_b.purchaseList.get(k);
				as3 += "\n";  // 상품과 상품을 구분해줄수 있도록 개행문자를 추가합니다. 
			}

			
			try {
				FileWriter fileWriter = new FileWriter("c:\\javaTxt\\"+id+pw+"Product.txt"); // 유저 아이디와+비밀번호+Product.txt 이 파일 이름이 됩니다. 이 파일은 상품 정보를 저장합니다.
				fileWriter.write(as2);
				fileWriter.close();
			} catch (IOException e) { //예외 발생시 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileWriter fileWriter = new FileWriter("c:\\javaTxt\\"+id+pw+"PurchaseList.txt"); // 유저 아이디와+비밀번호+PurchaseList 이 파일 이름이 됩니다. 이 파일은 구매내역을 저장합니다.
				fileWriter.write(as3);
				fileWriter.close();
			} catch (IOException e) {//예외 발생시 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			FileWriter fileWriter = new FileWriter(filePath);// "c:\\javaTxt\\userList.txt"이 파일 이름 입니다.. 이 파일은 유저 정보를 저장합니다.
			fileWriter.write(as1);

			fileWriter.close();
		} catch (IOException e) { //예외 발생시 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void userImport(ArrayList<User> userL) {// 저장된 정보를 불러오기 위한 메서드 입니다.
		try{/// 예외처리를 위한
            File file = new File("c:\\\\javaTxt\\\\userList.txt"); // 파일 객체 생성 // 유저 정보를 담고 있는 파일을 불러옵니다.
            FileReader filereader = new FileReader(file); // 입력 스트림 생성
            BufferedReader bufReader = new BufferedReader(filereader); // 입력 버퍼 생성
            String line = ""; // 버퍼로 부터 한줄씩 받을 문자열을 저장할 변수입니다.
            while((line = bufReader.readLine()) != null){ // 문자열을 한줄씩 불러옵니다. 개행문자를 기준으로 합니다. 정보가 없을경우 실행하지 않습니다.
            	int ui = 0;
            	String[] strArr = line.split("//"); // 구분자를 이용해 분리한 후 문자열 배열에 순서대로 넣어줍니다.
            	
            	userL.add(new User(strArr[0], strArr[1], strArr[2], strArr[3], strArr[4], strArr[5], strArr[6],
            			strArr[7], strArr[8])); // 유저 정보를 불러와 user배열에 저장합니다.

                File file1 = new File("c:\\\\javaTxt\\\\"+strArr[0]+strArr[1]+"Product.txt"); // 해당 유저의 상품 정보를 담고 있는 파일들 불러옵니다.
                FileReader filereader1 = new FileReader(file1);
                BufferedReader bufReader1 = new BufferedReader(filereader1);
                String line1 = "";// 버퍼로부터 한줄씩 받을 문자열을 저장할 변수입니다.
                
                while((line1 = bufReader1.readLine()) != null){
                	int sArr = 0; // 좌석상품과 유통기간 상품 일반상품을 구분하여 갹체 배열에 넣어주기 위해 0이면 일반상품객체 생성을 1이면 유통기간 객체생성을 2이면 좌석 객체생성을 합니다.
                	int seatn = 0;// 영화 좌석 정보를 넣어주기 위해 수정할 영화 배열의 번호를 저장합니다.int seatn = 0;// 영화 좌석 정보를 넣어주기 위해 수정할 영화 배열의 번호를 저장합니다.
                	if(line1.equals("*!*")) { // 일반상품, 유통기간이 있는상품, 좌석이 있는 상품 (정보)배열을 구분자 *!*로 구분하여 해당하는 배열에 넣어주기 위해 추가하였숩니다.
                		sArr++;
                	}else {
                		if(sArr == 0) { // 일반상품일 경우입니다.
                			String[] strArr1 = line1.split("//");
                			userL.get(ui).pos.productPlus(strArr1[0], Integer.parseInt(strArr1[1]), Integer.parseInt(strArr1[2]), Integer.parseInt(strArr1[3]),
                					strArr1[4], Integer.parseInt(strArr1[5]));
                    	}else if (sArr == 1) { // 유통기간이 있는 상품일 경우입니다.
                    		String[] strArr1 = line1.split("//");
                    		userL.get(ui).pos.productPlus(strArr1[0], Integer.parseInt(strArr1[1]), Integer.parseInt(strArr1[2]), Integer.parseInt(strArr1[3]),
                    				strArr1[4], Integer.parseInt(strArr1[5]), strArr1[6]);
						}else if (sArr == 2) { // 좌석정보를 가지고 있는 상품일 경우입니다.
							String[] strArr1 = line1.split("//");
							userL.get(ui).pos.productSeatPlus(strArr1[0], Integer.parseInt(strArr1[1]), Integer.parseInt(strArr1[3]), strArr1[4], Integer.parseInt(strArr1[5]));
							String[] strArr2 = strArr1[6].split("\\.");
							for(int k = 0; k < strArr2.length; k++) { // 구매되어 있는 좌석을 불러와서 업로드해 줍니다. 
								userL.get(ui).pos.seatCheck_b.get(seatn).setSeetc(Integer.parseInt(strArr2[k]));
							}
							++seatn; //다음 영화로 접근할 수 있도록 숫자를 증가해 줍니다.
						}
                	}

                }
                bufReader1.close();
                
                File file2 = new File("c:\\\\javaTxt\\\\"+strArr[0]+strArr[1]+"PurchaseList.txt"); // 구매내역을 저장하고있는 파일주소입니다.
                FileReader filereader2 = new FileReader(file2);
                BufferedReader bufReader2 = new BufferedReader(filereader2);
                String line2 = "";
                while((line2 = bufReader2.readLine()) != null){ // 구매장부 파일을 불러와 구매장부 배열에 저장해줍니다.
                	userL.get(ui).pos.report_b.setPurchaseList(line2);
                }
                
                bufReader2.close();
                ++ui;
            }           
            bufReader.close();
        }catch (FileNotFoundException e) { //예외 발생시 
            // TODO: handle exception
        }catch(IOException e){ //예외 발생시 
            System.out.println(e);
        }
	}

	public static void main(String[] args) {
	}

}
