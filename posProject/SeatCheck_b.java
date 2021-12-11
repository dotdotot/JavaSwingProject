package posProject;

import java.util.Arrays;

// TODO 좌석체크Class (MoviePos)
public class SeatCheck_b extends Product_b {
    public boolean[] seetc = new boolean[20];

    // 매개변수를 받는 생성자
    public SeatCheck_b(String name, int price, int uprice, String description, int discount) {
        // 부모클래스의 생성자를 호출합니다. 수량은 20개로 설정합니다.
        super(name, price, 20, uprice, description, discount);
        // 모든좌석을 true로 설정합니다.
        Arrays.fill(seetc, true);
    }

    // TODO 좌석의 상태를 확인하는 메소드
    public boolean getSeetc(int num) {
        // 좌석의 상태를 알기위한 메소드로 매개변수로 좌석의 번호를 입력받습니다. 좌석이 예매가 된 상태인 경우 flase를 반환하고 비어있는 좌석의
        // 경우에는 true를 반환합니다.
        // 배열의 경우에는 시작값이 0이므로 사용자가 입력해준 숫자에서 1을 뺌니다.
        return seetc[num - 1];

    }

    // TODO 좌석의 상태를 변경하는 메소드
    public void setSeetc(int num) {
        // 매개변수로 좌석의 번호를 입력받습니디. 좌석이 true일 경우false로 변경하고 false일 경우 true로 변경합니다.
        if (seetc[num - 1] == true) {
            seetc[num - 1] = false;
        } else {
            seetc[num - 1] = true;
        }
    }

}
