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
     * 지난 주 로또 번호 입력하는 함수
     *
     * 6개의 숫자 배열로 반환
     * */
    public int[] inputBeforeLotto() {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        int[] nums = splitNums(inputValue);
        return nums;
    }

    /*
     * 문자열로 입력한 로또 번호를 구분자(,) 를 기준으로 자르고 숫자로 변환하는 함수
     *
     * 숫자가 아닌 경우, 숫자 범위를 벗어나는 경우, 로또 번호의 개수가 6개가 아닌 경우, 번호가 중복된 경우 예외처리
     * */
    public int[] splitNums(String nums) {
        String[] strings = nums.split(",");
        int[] results = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            checkLottoNum(strings[i].trim());
            results[i] = Integer.parseInt(strings[i].trim());
        }
        checkLottoSize(results);
        return results;
    }

    /*
     * 로또 번호를 확인하는 함수
     *
     * 숫자가 아닌 경우, 범위를 벗어나는 경우 예외처리
     * */
    public void checkLottoNum(String numStr) {
        if (numStr == null || numStr.isEmpty() || !numStr.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new RuntimeException("숫자를 입력해주세요.");
        }
        if ((Integer.parseInt(numStr) < 1 || Integer.parseInt(numStr) > 45)) {
            throw new RuntimeException("1~45 사이의 숫자를 입력해주세요.");
        }
    }

    /*
     * 로또 번호의 개수를 확인하는 함수
     *
     * 중복되지 않은 번호가 6개가 아니면 예외처리
     * */
    public void checkLottoSize(int[] beforeLotto) {
        Set<Integer> checkSize = new HashSet<>();
        for (int i = 0; i < beforeLotto.length; i++) {
            checkSize.add(beforeLotto[i]);
        }
        if (checkSize.size() != 6) {
            throw new RuntimeException("중복되지 않은 6개의 숫자를 입력해주세요.");
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

        // 구입로또 개수 셈
        int size = countLotto(money);

        // 구입 개수만큼 로또 생성 및 출력
        List<List<Integer>> lottoList = buyLotto(size);
        lottoAutoProgramUI.printPurchaseList(size, lottoList);

        // 지난 주 로또 번호 입력
        lottoAutoProgramUI.printInputNumbers();
        int[] lottoNums = inputBeforeLotto();

    }
}
