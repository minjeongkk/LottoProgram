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
}