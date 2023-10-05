package lottoAuto;

import java.text.DecimalFormat;
import java.util.*;

public class LottoAutoProgram {
    private final int[] winnings = new int[]{5000, 50000, 1500000, 2000000000};     // 로또 상금 (3개 일치, 4개 일치, 5개 일치, 6개 일치)

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
     * 구입한 개수만큼 지난주 로또 번호 일치 개수 세는 함수
     *
     * 3개, 4개, 5개, 6개의 번호가 일치하는 로또 개수의 배열을 반환
     * */
    public int[] countMatchValue(int[] lottoNums, List<List<Integer>> lottoList) {
        List<Integer> countLists = new ArrayList<>();
        int[] matchCounts = new int[]{0, 0, 0, 0};
        for (int i = 0; i < lottoList.size(); i++) {
            countLists.add(checkMatchLottoNum(lottoNums, lottoList.get(i)));
        }
        for (int i = 0; i < matchCounts.length; i++) {
            matchCounts[i] = Collections.frequency(countLists, i + 3);
        }
        return matchCounts;
    }

    /*
     * 하나의 로또에서 일치하는 번호 개수를 세는 함수
     * */
    public int checkMatchLottoNum(int[] lottoNums, List<Integer> lotto) {
        int sum = 0;
        for (int i = 0; i < lottoNums.length; i++) {
            sum += isMatched(lottoNums[i], lotto);    // 일치하면 1 더함
        }
        return sum;
    }

    /*
     * 구매한 로또에 지난주 로또 번호와 일치하는 번호가 있는지 확인하는 함수
     *
     * 있으면 1 리턴, 없으면 0 리턴
     * */
    public int isMatched(int lottoNum, List<Integer> lotto) {
        if (lotto.contains(lottoNum)) {
            return 1;
        }
        return 0;
    }

    /*
     * 수익률 계산하는 함수
     *
     * (당첨 금액)/(구입 금액)으로 계산하여 소수점 둘째자리까지 표시
     * */
    public float calculateRate(int size, int[] match) {
        if (size ==0){
            return 0f;
        }
        int earnMoney = 0;
        for (int i = 0; i < match.length; i++) {
            earnMoney += match[i] * winnings[i];
        }
        DecimalFormat df = new DecimalFormat("0.00");
        String earnRate = df.format((float) earnMoney / size * 1000);
        return Float.parseFloat(earnRate);
    }

    /*
     * 수익률로 손해, 이득을 판단하는 함수 (기준은 1)
     * */
    public String checkResult(float rate) {
        if (rate < 1) {
            return "손해";
        }
        return "이득";
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

        // 로또 일치 개수 계산
        int[] match = countMatchValue(lottoNums, lottoList);

        // 수익률 계산 및 통계 결과 출력
        float rate = calculateRate(size, match);
        String result = checkResult(rate);
        lottoAutoProgramUI.printResult(match, rate, result);
    }
}
