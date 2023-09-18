package lottoAuto;

import java.util.List;

public class LottoAutoProgramUI {
    public void printInputString() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseList(int num, List<List<Integer>> list) {
        System.out.println(num + "개를 구입했습니다.");
        for (int i = 0; i < list.size(); i++) {
            List<Integer> nums = list.get(i);
            System.out.println(nums.toString());
        }
    }

    public void printInputNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printResult(int[] matchNums, float rateOfReturn, String result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", matchNums[0]);
        System.out.printf("4개 일치 (50000원)- %d개\n", matchNums[1]);
        System.out.printf("5개 일치 (1500000원)- %d개\n", matchNums[2]);
        System.out.printf("6개 일치 (2000000000원)- %d개\n", matchNums[3]);
        System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", rateOfReturn, result);
    }
}
