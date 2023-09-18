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
     * 구입 로또 개수를 세는 함수
     *
     * 로또 1개당 1000원으로 계산
     * */
    public int countLotto(int money) {
        int count = money / 1000;
        return count;
    }

    /*
     * 구매 개수만큼 로또를 사는 함수
     *
     * 구매한 로또의 값들을 리스트로 반환
     * */
    public List<List<Integer>> buyLotto(int size) {
        List<List<Integer>> purchaseLotto = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> lotto = createLotto();    // 로또 1개 생성
            purchaseLotto.add(lotto);
        }
        return purchaseLotto;
    }

    /*
     * 로또 1개를 생성하는 함수
     *
     * 1~45 사이의 숫자가 있는 리스트를 섞어 6번째 숫자까지 반환
     * */
    public List<Integer> createLotto() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);

        List<Integer> lottoNums = nums.subList(0, 6);
        Collections.sort(lottoNums);

        return lottoNums;
    }



    /*
    * 로또(자동) 프로그램 동작 함수
    * */
    public void run() {
        LottoAutoProgramUI lottoAutoProgramUI = new LottoAutoProgramUI();
        lottoAutoProgramUI.printInputString();

        // 구입 금액 입력
        int money = inputMoney();

        // 구입로또 개수 셈
        int size = countLotto(money);

        // 구입 개수만큼 로또 생성 및 출력
        List<List<Integer>> lottoList = buyLotto(size);
        lottoAutoProgramUI.printPurchaseList(size, lottoList);


    }
}
