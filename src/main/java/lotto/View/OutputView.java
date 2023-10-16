package lotto.View;

import lotto.Model.LottoTicket;
import lotto.Model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String OUTPUT_PURCHASE_LOTTOCOUNT = "개를 구입했습니다.";
    private static final String OUTPUT_RESULT = "당첨 통계";
    private static final String OUTPUT_LINE = "---------";
    private static final String OUTPUT_MATCH_LOTTO = "%d개 일치 (%d원)- %d개\n";
    private static final String OUTPUT_MATCH_LOTTO_BONUSBALL = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static final String OUTPUT_YIELD_RATE_OF_RETURN = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";


    public static void printOutputLottoList(int count, List<LottoTicket> list) {
        System.out.println(count + OUTPUT_PURCHASE_LOTTOCOUNT);
        for (LottoTicket nums : list) {
            System.out.println(nums.toString());
        }
    }

    public static void printOutputResult(Map<Rank, Integer> matchNums, float rateOfReturn, String result) {
        System.out.println(OUTPUT_RESULT);
        System.out.println(OUTPUT_LINE);
        System.out.printf(OUTPUT_MATCH_LOTTO, Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), matchNums.get(Rank.FIFTH));
        System.out.printf(OUTPUT_MATCH_LOTTO, Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), matchNums.get(Rank.FOURTH));
        System.out.printf(OUTPUT_MATCH_LOTTO, Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), matchNums.get(Rank.THIRD));
        System.out.printf(OUTPUT_MATCH_LOTTO_BONUSBALL, Rank.SECOND.getCountOfMatch(), Rank.SECOND.getWinningMoney(), matchNums.get(Rank.SECOND));
        System.out.printf(OUTPUT_MATCH_LOTTO, Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), matchNums.get(Rank.FIRST));
        System.out.printf(OUTPUT_YIELD_RATE_OF_RETURN, rateOfReturn, result);
    }
}
