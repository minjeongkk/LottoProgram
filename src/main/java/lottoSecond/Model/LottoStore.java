package lottoSecond.Model;

import java.util.*;

public class LottoStore {
    private static final int MIN_LOTTONUM = 1;
    private static final int MAX_LOTTONUM = 45;
    private static final String INT_REGEX = "[+-]?\\d*(\\.\\d+)?";
    private static final int LOTTO_SIZE = 6;
    static final String ERROR_INPUT_NUM = "숫자를 입력해주세요.";
    static final String ERROR_INPUT_RANGE = "1~45 사이의 숫자를 입력해주세요.";
    static final String ERROR_INPUT_DUCPLICATED = "중복되지 않은 숫자를 입력해주세요.";
    static final List<Integer> nums = new ArrayList<>();

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

    public void checkLottoNum(String numStr) {
        if (numStr == null || numStr.isEmpty() || !numStr.matches(INT_REGEX)) {
            throw new RuntimeException(ERROR_INPUT_NUM);
        }
        if ((Integer.parseInt(numStr) < MIN_LOTTONUM || Integer.parseInt(numStr) > MAX_LOTTONUM)) {
            throw new RuntimeException(ERROR_INPUT_RANGE);
        }
    }

    public void checkLottoSize(List<Integer> beforeLotto) {
        Set<Integer> checkSize = new HashSet<>();
        for (int i = 0; i < beforeLotto.size(); i++) {
            checkSize.add(beforeLotto.get(i));
        }
        if (checkSize.size() != LOTTO_SIZE) {
            throw new RuntimeException(ERROR_INPUT_DUCPLICATED);
        }
    }

    public void setLottoStore(){
        for (int i = MIN_LOTTONUM; i <= MAX_LOTTONUM; i++) {
            nums.add(i);
        }
    }

    public LottoTicket createLotto() {
        Collections.shuffle(nums);

//        List<Integer> lottoNums = nums.subList(0, LOTTO_SIZE);
        List<Integer> lottoNums = null;
        for (int i=0; i<LOTTO_SIZE; i++){
            lottoNums.add(nums.get(i));
        }
        Collections.sort(lottoNums);

        return new LottoTicket(lottoNums);
    }
}
