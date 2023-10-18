package lotto.View;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_NUMS = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_LAST_LOTTONUMS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_LAST_BONUSBALL = "보너스 볼을 입력해 주세요.";

    public static void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }
    public static void printInputManualNums() {
        System.out.println(INPUT_MANUAL_NUMS);
    }
    public static void printInputManualLottoNums() {
        System.out.println(INPUT_MANUAL_LOTTO_NUMS);
    }

    public static void printInputLottoNums() {
        System.out.println(INPUT_LAST_LOTTONUMS);
    }

    public static void printInputBonus() {
        System.out.println(INPUT_LAST_BONUSBALL);
    }
}
