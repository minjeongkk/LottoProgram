package lotto.View;

import lotto.message.PrintMessage;
import lotto.Model.LottoTicket;
import lotto.Model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printOutputLottoCount(int manualCount, int count) {
        System.out.printf(PrintMessage.OUTPUT_PURCHASE_LOTTOCOUNT, manualCount, count);
    }

    public static void printOutputLottoList(List<LottoTicket> list){
        for (LottoTicket nums : list) {
            System.out.println(nums.toString());
        }
    }

    public static void printOutputResult(Map<Rank, Integer> matchNums, float rateOfReturn, String result) {
        System.out.println(PrintMessage.OUTPUT_RESULT);
        System.out.println(PrintMessage.OUTPUT_LINE);
        System.out.printf(PrintMessage.OUTPUT_MATCH_LOTTO, Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), matchNums.get(Rank.FIFTH));
        System.out.printf(PrintMessage.OUTPUT_MATCH_LOTTO, Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), matchNums.get(Rank.FOURTH));
        System.out.printf(PrintMessage.OUTPUT_MATCH_LOTTO, Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), matchNums.get(Rank.THIRD));
        System.out.printf(PrintMessage.OUTPUT_MATCH_LOTTO_BONUSBALL, Rank.SECOND.getCountOfMatch(), Rank.SECOND.getWinningMoney(), matchNums.get(Rank.SECOND));
        System.out.printf(PrintMessage.OUTPUT_MATCH_LOTTO, Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), matchNums.get(Rank.FIRST));
        System.out.printf(PrintMessage.OUTPUT_YIELD_RATE_OF_RETURN, rateOfReturn, result);
    }
}
