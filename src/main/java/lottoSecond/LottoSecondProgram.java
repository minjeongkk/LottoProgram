package lottoSecond;

import java.text.DecimalFormat;
import java.util.*;

public class LottoSecondProgram {
    /*
     * 당첨 등수 통계를 저장하기 위해 선언 및 초기화
     * */
    private final Map<Rank, Integer> countRanks = new HashMap<Rank, Integer>();
    public LottoSecondProgram() {
        for (Rank rank : Rank.values()){
            countRanks.put(rank,0);
        }
    }

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
    public List<Lotto> buyLotto(int size) {
        List<Lotto> purchaseLotto = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Lotto lotto = createLotto();    // 로또 1개 생성
            purchaseLotto.add(lotto);
        }
        return purchaseLotto;
    }

    /*
     * 로또 1개를 생성하는 함수
     *
     * 1~45 사이의 숫자가 있는 리스트를 섞어 6번째 숫자까지 반환
     * */
    public Lotto createLotto() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);

        List<Integer> lottoNums = nums.subList(0, 6);
        Collections.sort(lottoNums);

        return new Lotto(lottoNums);
    }

    /*
     * 지난 주 로또 번호 입력하는 함수
     *
     * 6개의 숫자 리스트로 반환
     * */
    public List<Integer> inputBeforeLotto() {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        List<Integer> nums = splitNums(inputValue);
        return nums;
    }

    /*
     * 보너스볼 입력 함수
     * */
    public int inputBonusNum(List<Integer> lottoNums){
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        return checkBonusNum(inputValue, lottoNums);
    }

    /*
     * 보너스볼 유효성 체크
     *
     * 1~45 사이의 숫자가 아닌 경우, 로또 번호와 중복되는 번호가 있는 경우 예외 처리
     * */
    public int checkBonusNum(String inputValue, List<Integer> lottoNums){
        if (inputValue == null || inputValue.isEmpty() || !inputValue.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new RuntimeException("숫자를 입력해주세요.");
        } else if (Integer.parseInt(inputValue) < 1 || Integer.parseInt(inputValue) > 45) {
            throw new RuntimeException("1~45 사이의 숫자를 입력해주세요.");
        } else if (isMatched(Integer.parseInt(inputValue),lottoNums)==1){
            throw new RuntimeException("중복되지 않은 숫자를 입력해주세요.");
        }
        return Integer.parseInt(inputValue);
    }

    /*
     * 문자열로 입력한 로또 번호를 구분자(,) 를 기준으로 자르고 숫자로 변환하는 함수
     *
     * 숫자가 아닌 경우, 숫자 범위를 벗어나는 경우, 로또 번호의 개수가 6개가 아닌 경우, 번호가 중복된 경우 예외처리
     * */
    public List<Integer> splitNums(String nums) {
        String[] strings = nums.split(",");
        List<Integer> results = new ArrayList<>();
        for (String string : strings) {
            checkLottoNum(string.trim());
            results.add(Integer.parseInt(string.trim()));
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
    public void checkLottoSize(List<Integer> beforeLotto) {
        Set<Integer> checkSize = new HashSet<>();
        for (int i = 0; i < beforeLotto.size(); i++) {
            checkSize.add(beforeLotto.get(i));
        }
        if (checkSize.size() != 6) {
            throw new RuntimeException("중복되지 않은 6개의 숫자를 입력해주세요.");
        }
    }


    /*
     * 로또에 일치하는 번호가 있는지 확인하는 함수
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
    public float calculateRate(int money) {
        int earnMoney = 0;
        for (Rank rank : Rank.values()) {
            earnMoney += countRanks.get(rank) * rank.getWinningMoney();
        }
        DecimalFormat df = new DecimalFormat("0.00");
        String earnRate = df.format((float) earnMoney / money);
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
     * 로또(2등) 프로그램 동작 함수
     * */
    public void run() {
        LottoSecondProgramUI lottoSecondProgramUI = new LottoSecondProgramUI();
        lottoSecondProgramUI.printInputString();

        // 구입 금액 입력
        int money = inputMoney();

        // 구입로또 개수 셈
        int size = countLotto(money);

        // 구입 개수만큼 로또 생성 및 출력
        List<Lotto> lottoList = buyLotto(size);
        lottoSecondProgramUI.printPurchaseList(size, lottoList);

        // 지난 주 로또 번호 입력
        lottoSecondProgramUI.printInputNumbers();
        List<Integer> lottoNums = inputBeforeLotto();

        // 보너스 번호 입력
        lottoSecondProgramUI.printInputBonus();
        int bonusNum = inputBonusNum(lottoNums);

        // 수익률 계산 및 통계 결과 출력
        float rate = calculateRate(money);
        String result = checkResult(rate);
        lottoSecondProgramUI.printResult(countRanks, rate, result);
    }
}