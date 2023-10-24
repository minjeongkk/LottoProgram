package lotto.Model;

import java.util.*;

public class LottoStore {
    private static final int MIN_LOTTONUM = 1;
    private static final int MAX_LOTTONUM = 45;
    private static final String INT_REGEX = "[+-]?\\d*(\\.\\d+)?";
    private static final int LOTTO_SIZE = 6;
    static final String ERROR_INPUT_NUM = "숫자를 입력해주세요.";
    static final String ERROR_INPUT_SIZE = "6개의 숫자를 입력해주세요.";
    static final String ERROR_INPUT_DUCPLICATED = "중복되지 않은 숫자를 입력해주세요.";
    static final String ERROR_INPUT_OVER = "구매 로또 개수를 초과하였습니다.";
    static final List<LottoNo> nums = new ArrayList<>();

    public LottoStore() {
        for (int i = MIN_LOTTONUM; i <= MAX_LOTTONUM; i++) {
            nums.add(new LottoNo(String.valueOf(i)));
        }
    }

    public int checkManualLottoSize(String numStr, int count) {
        if (numStr == null || numStr.isEmpty() || !numStr.matches(INT_REGEX)) {
            throw new RuntimeException(ERROR_INPUT_NUM);
        }
        if (Integer.parseInt(numStr)>count){
            throw new RuntimeException(ERROR_INPUT_OVER);
        }
        return Integer.parseInt(numStr);
    }

    public List<LottoNo> splitNums(String nums) {
        String[] strings = nums.split(",");
        List<LottoNo> results = new ArrayList<>();
        for (String string : strings) {
            LottoNo lottoNo = new LottoNo(string.trim());
            checkDuplicated(results, lottoNo);
            results.add(lottoNo);
        }
        checkLottoSize(results);
        Collections.sort(results);
        return results;
    }

    public void checkDuplicated(List<LottoNo> inputLotto, LottoNo lottoNo) {
        int result = 0;
        for (LottoNo inputLottoNo : inputLotto) {
            result += inputLottoNo.isMatched(lottoNo);
        }
        if (result != 0) {
            throw new RuntimeException(ERROR_INPUT_DUCPLICATED);
        }
    }

    public void checkLottoSize(List<LottoNo> beforeLotto) {
        if (beforeLotto.size()!=LOTTO_SIZE){
            throw new RuntimeException(ERROR_INPUT_SIZE);
        }
    }

    public LottoTicket createLotto() {
        Collections.shuffle(nums);

        List<LottoNo> lottoNums = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            String getLottoNum = String.valueOf(nums.get(i).getLottoNo());
            lottoNums.add(new LottoNo(getLottoNum));
        }

        Collections.sort(lottoNums);

        return new LottoTicket(lottoNums);
    }
}
