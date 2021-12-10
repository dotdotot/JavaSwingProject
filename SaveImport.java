import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveImport {

	void userSave(ArrayList<User> userL) {// �����ϱ� ���� �޵� �Դϴ�.
		String as1 = ""; // ���� ������ �� ���� ���ڿ��� �����մϴ�.
		String as2 = ""; // ��ǰ ������ �� ���� ���ڿ��� �����մϴ�.
		String as3 = ""; // ���� ������ �� ���� ���ڿ��� �����մϴ�.
		String separator1 = "//";// ���� �׸� �и��� ���� ������ �Դϴ�.
		String separator2 = "//";// ��ǰ �׸� �и��� ���� ������ �Դϴ�.
		String separator3 = "*!*\n";//�Ϲݻ�ǰ�� �¼� ��ǰ�� �и��� ���� �������Դϴ�.
		String filePath = "c:\\javaTxt\\userList.txt"; // ��ǻ�Ϳ� ���� ������ ������ ��ġ�� ��� �ֽ��ϴ�.
		for (int a1 = 0; a1 < userL.size(); a1++) { // ���� �迭�� ���̸�ŭ �ݺ��մϴ�.
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
			as1 += "\n"; // ���๮�ڸ� ���Ͽ� ������ �ٸ������� ������ ������ �ݴϴ�.
			for(int k = 0; k < userL.get(a1).pos.product_b.size(); k++) { // �Ϲ� ��ǰ�� ������ �ҷ��� �� ���� ���ڿ� �迭�� ����ϴ�. �� �׸��� �и����� �����ڷ�//�� �ֽ��ϴ�. 
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
				as2 += "\n"; // ��ǰ�� ��ǰ�� �������ټ� �ֵ��� ���๮�ڸ� �߰��մϴ�. 
			}
			as2 += separator3; // �Ϲݻ�ǰ, ����Ⱓ�� �ִ»�ǰ, �¼��� �ִ� ��ǰ (����)�迭�� �����ϱ� ���� �����ڷ� *!*�� �߰��մϴ�.
			
			for(int k = 0; k < userL.get(a1).pos.expirationDate_b.size(); k++) {// ����Ⱓ�� �ִ� ��ǰ�� ������ �ҷ��� �� ���� ���ڿ� �迭�� ����ϴ�. �� �׸��� �и����� �����ڷ�//�� �ֽ��ϴ�. 
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
				as2 += "\n"; // ��ǰ�� ��ǰ�� �������ټ� �ֵ��� ���๮�ڸ� �߰��մϴ�. 
			}
			as2 += separator3; // �Ϲݻ�ǰ, ����Ⱓ�� �ִ»�ǰ, �¼��� �ִ� ��ǰ (����)�迭�� �����ϱ� ���� �����ڷ� *!*�� �߰��մϴ�.
			
			for(int k = 0; k < userL.get(a1).pos.seatCheck_b.size(); k++) { // �¼������� �������ִ� ��ǰ ������ �ҷ��� �� ���� ���ڿ� �迭�� ����ϴ�. �� �׸��� �и����� �����ڷ�//�� �ֽ��ϴ�. 
				int abc = 0; // ���й��� �߰� ���θ� �����ϴ� �����Դϴ�.
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
					if ((userL.get(a1).pos.seatCheck_b.get(k).getSeetc(movie1))==false) { // ���Ű� �Ϸ�� �¼��� ��ȣ�� �ҷ��� �� ���� ���ڿ��� �����մϴ�. �¼��� �ٸ� �¼��� ��ȣ�� ������"." ���� �����Ͽ����ϴ�. 
						if(abc == 0) {
							as2 += movie1;
							abc ++;
						} else {
							as2 += ".";
							as2 += movie1;;
						}
					}
				}
				as2 += "\n"; // ��ǰ�� ��ǰ�� �������ټ� �ֵ��� ���๮�ڸ� �߰��մϴ�. 
			}
			for(int k = 0; k < userL.get(a1).pos.report_b.purchaseList.size(); k++) { // ���ų����� �ҷ��� ���ڿ��� �����մϴ�.
				as3 += userL.get(a1).pos.report_b.purchaseList.get(k);
				as3 += "\n";  // ��ǰ�� ��ǰ�� �������ټ� �ֵ��� ���๮�ڸ� �߰��մϴ�. 
			}

			
			try {
				FileWriter fileWriter = new FileWriter("c:\\javaTxt\\"+id+pw+"Product.txt"); // ���� ���̵��+��й�ȣ+Product.txt �� ���� �̸��� �˴ϴ�. �� ������ ��ǰ ������ �����մϴ�.
				fileWriter.write(as2);
				fileWriter.close();
			} catch (IOException e) { //���� �߻��� 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileWriter fileWriter = new FileWriter("c:\\javaTxt\\"+id+pw+"PurchaseList.txt"); // ���� ���̵��+��й�ȣ+PurchaseList �� ���� �̸��� �˴ϴ�. �� ������ ���ų����� �����մϴ�.
				fileWriter.write(as3);
				fileWriter.close();
			} catch (IOException e) {//���� �߻��� 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			FileWriter fileWriter = new FileWriter(filePath);// "c:\\javaTxt\\userList.txt"�� ���� �̸� �Դϴ�.. �� ������ ���� ������ �����մϴ�.
			fileWriter.write(as1);

			fileWriter.close();
		} catch (IOException e) { //���� �߻��� 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void userImport(ArrayList<User> userL) {// ����� ������ �ҷ����� ���� �޼��� �Դϴ�.
		try{/// ����ó���� ����
            File file = new File("c:\\\\javaTxt\\\\userList.txt"); // ���� ��ü ���� // ���� ������ ��� �ִ� ������ �ҷ��ɴϴ�.
            FileReader filereader = new FileReader(file); // �Է� ��Ʈ�� ����
            BufferedReader bufReader = new BufferedReader(filereader); // �Է� ���� ����
            String line = ""; // ���۷� ���� ���پ� ���� ���ڿ��� ������ �����Դϴ�.
            while((line = bufReader.readLine()) != null){ // ���ڿ��� ���پ� �ҷ��ɴϴ�. ���๮�ڸ� �������� �մϴ�. ������ ������� �������� �ʽ��ϴ�.
            	int ui = 0;
            	String[] strArr = line.split("//"); // �����ڸ� �̿��� �и��� �� ���ڿ� �迭�� ������� �־��ݴϴ�.
            	
            	userL.add(new User(strArr[0], strArr[1], strArr[2], strArr[3], strArr[4], strArr[5], strArr[6],
            			strArr[7], strArr[8])); // ���� ������ �ҷ��� user�迭�� �����մϴ�.

                File file1 = new File("c:\\\\javaTxt\\\\"+strArr[0]+strArr[1]+"Product.txt"); // �ش� ������ ��ǰ ������ ��� �ִ� ���ϵ� �ҷ��ɴϴ�.
                FileReader filereader1 = new FileReader(file1);
                BufferedReader bufReader1 = new BufferedReader(filereader1);
                String line1 = "";// ���۷κ��� ���پ� ���� ���ڿ��� ������ �����Դϴ�.
                
                while((line1 = bufReader1.readLine()) != null){
                	int sArr = 0; // �¼���ǰ�� ����Ⱓ ��ǰ �Ϲݻ�ǰ�� �����Ͽ� ��ü �迭�� �־��ֱ� ���� 0�̸� �Ϲݻ�ǰ��ü ������ 1�̸� ����Ⱓ ��ü������ 2�̸� �¼� ��ü������ �մϴ�.
                	int seatn = 0;// ��ȭ �¼� ������ �־��ֱ� ���� ������ ��ȭ �迭�� ��ȣ�� �����մϴ�.int seatn = 0;// ��ȭ �¼� ������ �־��ֱ� ���� ������ ��ȭ �迭�� ��ȣ�� �����մϴ�.
                	if(line1.equals("*!*")) { // �Ϲݻ�ǰ, ����Ⱓ�� �ִ»�ǰ, �¼��� �ִ� ��ǰ (����)�迭�� ������ *!*�� �����Ͽ� �ش��ϴ� �迭�� �־��ֱ� ���� �߰��Ͽ����ϴ�.
                		sArr++;
                	}else {
                		if(sArr == 0) { // �Ϲݻ�ǰ�� ����Դϴ�.
                			String[] strArr1 = line1.split("//");
                			userL.get(ui).pos.productPlus(strArr1[0], Integer.parseInt(strArr1[1]), Integer.parseInt(strArr1[2]), Integer.parseInt(strArr1[3]),
                					strArr1[4], Integer.parseInt(strArr1[5]));
                    	}else if (sArr == 1) { // ����Ⱓ�� �ִ� ��ǰ�� ����Դϴ�.
                    		String[] strArr1 = line1.split("//");
                    		userL.get(ui).pos.productPlus(strArr1[0], Integer.parseInt(strArr1[1]), Integer.parseInt(strArr1[2]), Integer.parseInt(strArr1[3]),
                    				strArr1[4], Integer.parseInt(strArr1[5]), strArr1[6]);
						}else if (sArr == 2) { // �¼������� ������ �ִ� ��ǰ�� ����Դϴ�.
							String[] strArr1 = line1.split("//");
							userL.get(ui).pos.productSeatPlus(strArr1[0], Integer.parseInt(strArr1[1]), Integer.parseInt(strArr1[3]), strArr1[4], Integer.parseInt(strArr1[5]));
							String[] strArr2 = strArr1[6].split("\\.");
							for(int k = 0; k < strArr2.length; k++) { // ���ŵǾ� �ִ� �¼��� �ҷ��ͼ� ���ε��� �ݴϴ�. 
								userL.get(ui).pos.seatCheck_b.get(seatn).setSeetc(Integer.parseInt(strArr2[k]));
							}
							++seatn; //���� ��ȭ�� ������ �� �ֵ��� ���ڸ� ������ �ݴϴ�.
						}
                	}

                }
                bufReader1.close();
                
                File file2 = new File("c:\\\\javaTxt\\\\"+strArr[0]+strArr[1]+"PurchaseList.txt"); // ���ų����� �����ϰ��ִ� �����ּ��Դϴ�.
                FileReader filereader2 = new FileReader(file2);
                BufferedReader bufReader2 = new BufferedReader(filereader2);
                String line2 = "";
                while((line2 = bufReader2.readLine()) != null){ // ������� ������ �ҷ��� ������� �迭�� �������ݴϴ�.
                	userL.get(ui).pos.report_b.setPurchaseList(line2);
                }
                
                bufReader2.close();
                ++ui;
            }           
            bufReader.close();
        }catch (FileNotFoundException e) { //���� �߻��� 
            // TODO: handle exception
        }catch(IOException e){ //���� �߻��� 
            System.out.println(e);
        }
	}

	public static void main(String[] args) {
	}

}
