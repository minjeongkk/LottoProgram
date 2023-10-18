package lotto.Model;

public class LottoNo implements Comparable<LottoNo>{
    private int lottoNo;
    private static final int MIN_LOTTONUM = 1;
    private static final int MAX_LOTTONUM = 45;
    private static final String INT_REGEX = "[+-]?\\d*(\\.\\d+)?";
    static final String ERROR_INPUT_NUM = "숫자를 입력해주세요.";
    static final String ERROR_INPUT_RANGE = "1~45 사이의 숫자를 입력해주세요.";
    private static final int IS_MATCHED = 1;
    private static final int IS_NOT_MATCHED = 0;
    private static final int ZERO = 0;

    public LottoNo(String numStr) {
        if(checkLottoNo(numStr)){
            lottoNo = Integer.parseInt(numStr);
        }
    }

    @Override
    public String toString(){
        return String.valueOf(lottoNo);
    }

    public int getLottoNo() {
        return lottoNo;
    }

    private boolean checkLottoNo(String numStr) {
        if (numStr == null || numStr.isEmpty() || !numStr.matches(INT_REGEX)) {
            throw new RuntimeException(ERROR_INPUT_NUM);
        }
        if ((Integer.parseInt(numStr) < MIN_LOTTONUM || Integer.parseInt(numStr) > MAX_LOTTONUM)) {
            throw new RuntimeException(ERROR_INPUT_RANGE);
        }
        return true;
    }

    @Override
    public int compareTo(LottoNo o) {
        return getLottoNo() - o.getLottoNo();
    }

    public int isMatched(LottoNo o){
        if (getLottoNo()-o.getLottoNo()==ZERO){
            return IS_MATCHED;
        }
        return IS_NOT_MATCHED;
    }

}
