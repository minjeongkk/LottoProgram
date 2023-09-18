package lottoAuto;

import java.util.*;

public class LottoAutoProgram {
    /*
     * 구입 금액 입력하는 함수
     * */
    public int inputMoney() {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.next();
        checkInputValue(inputValue);    // 입력값 유효성 검증
        return Integer.parseInt(inputValue);
    }

    /*
     * 구입 금액 입력값 유효성 검증 함수
     *
     * 숫자가 아닌 경우, 양수가 아닌 경우 예외 처리
     * */
    public void checkInputValue(String inputValue) {
        if (inputValue == null || inputValue.isEmpty() || !inputValue.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new RuntimeException("숫자를 입력해주세요.");
        }
        if (Integer.parseInt(inputValue) < 0) {
            throw new RuntimeException("양수를 입력해주세요.");
        }
    }

    /*
    * 로또(자동) 프로그램 동작 함수
    * */
    public void run() {
        LottoAutoProgramUI lottoAutoProgramUI = new LottoAutoProgramUI();
        lottoAutoProgramUI.printInputString();

        // 구입 금액 입력
        int money = inputMoney();
    }
}
