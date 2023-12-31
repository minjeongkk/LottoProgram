package lotto.Model;

import lotto.message.ErrorMessage;

import java.util.List;
/*
 * 지난주 로또 당첨 번호와 보너스볼을 담은 클래스
 * */
public class WinningTicket {
    private List<LottoNo> lottoNums;
    private LottoNo bonusNum;
    private static final int IS_MATCHED = 1;
    private static final int IS_NOT_MATCHED = 0;

    public WinningTicket(List<LottoNo> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public LottoNo getBonusBall() {
        return bonusNum;
    }

    public List<LottoNo> getLottoNums() {
        return lottoNums;
    }

    public void checkBonusNum(String inputValue) {
        LottoNo inputLottoNo = new LottoNo(inputValue);
        if (isMatched(inputLottoNo, lottoNums) == IS_MATCHED) {
            throw new RuntimeException(ErrorMessage.ERROR_INPUT_DUCPLICATED);
        }
        this.bonusNum = inputLottoNo;
    }

    public int isMatched(LottoNo lottoNum, List<LottoNo> lotto) {
        if (lotto.contains(lottoNum)) {
            return IS_MATCHED;
        }
        return IS_NOT_MATCHED;
    }
}
