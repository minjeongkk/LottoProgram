package lottoSecond;

import java.util.List;
import java.util.Map;

public class LottoSecondProgramUI {
    public void printInputString() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseList(int num, List<Lotto> list) {
        System.out.println(num + "개를 구입했습니다.");
        for (int i = 0; i < list.size(); i++) {
            Lotto nums = list.get(i);
            System.out.println(nums.toString());
        }
    }

    public void printInputNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printInputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printResult(Map<Rank, Integer> matchNums, float rateOfReturn, String result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", matchNums.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50000원)- %d개\n", matchNums.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1500000원)- %d개\n", matchNums.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원) - %d개\n", matchNums.get(Rank.SECOND));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", matchNums.get(Rank.FIRST));
        System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", rateOfReturn, result);
    }
}