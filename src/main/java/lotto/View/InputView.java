package lotto.View;

import lotto.message.PrintMessage;

public class InputView {
    public static void printInputMoney() {
        System.out.println(PrintMessage.INPUT_MONEY);
    }
    public static void printInputManualNums() {
        System.out.println(PrintMessage.INPUT_MANUAL_NUMS);
    }
    public static void printInputManualLottoNums() {
        System.out.println(PrintMessage.INPUT_MANUAL_LOTTO_NUMS);
    }

    public static void printInputLottoNums() {
        System.out.println(PrintMessage.INPUT_LAST_LOTTONUMS);
    }

    public static void printInputBonus() {
        System.out.println(PrintMessage.INPUT_LAST_BONUSBALL);
    }
}
