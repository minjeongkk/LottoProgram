package lotto.Model;

import java.util.Arrays;
import java.util.List;

/*
 * 로또 한장의 정보를 담은 클래스
 *
 * 로또 번호, 당첨 등수
 * */
public class LottoTicket {
    private final List<LottoNo> lottoNums;
    private Rank rank;
    private static final int IS_MATCHED = 1;
    private static final int ZERO = 0;

    public LottoTicket(List<LottoNo> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public List<LottoNo> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return lottoNums.toString();
    }

    /*
     * 하나의 로또에서 당첨 등수를 매기는 함수
     * */
    public Rank checkRank(WinningTicket winningTicket) {
        int winningMoney = ZERO;
        boolean isMatchedBonus = false;
        for (LottoNo lottoNum : this.lottoNums) {
            winningMoney += isMatched(lottoNum, winningTicket.getLottoNums());    // 일치하면 1 더함
        }
        if (isMatched(winningTicket.getBonusBall(), this.lottoNums) == IS_MATCHED) {    // 보너스 번호가 일치하는지 확인
            isMatchedBonus = true;
        }
        this.rank = Rank.valueOf(winningMoney, isMatchedBonus);
        return this.rank;
    }

    /*
     * 로또에 일치하는 번호가 있는지 확인하는 함수
     *
     * 있으면 1 리턴, 없으면 0 리턴
     * */
    public int isMatched(LottoNo lottoNo, List<LottoNo> lotto) {
        int result = ZERO;
        for (LottoNo no : lotto) {
            result += lottoNo.isMatched(no);
        }
        return result;
    }
}