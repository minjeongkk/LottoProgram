package lotto.Model;

import lotto.message.ErrorMessage;

public class Money {
    private int inputMoney = 0;
    private static final String INT_REGEX = "[+-]?\\d*(\\.\\d+)?";

    public Money() {
    }

    public Money(String inputValue) {
        if (isMoney(inputValue)) {
            inputMoney = Integer.parseInt(inputValue);
        }
    }

    public int getMoney() {
        return inputMoney;
    }

    public boolean isMoney(String inputValue) {
        if (inputValue == null || inputValue.isEmpty() || !inputValue.matches(INT_REGEX)) {
            throw new RuntimeException(ErrorMessage.ERROR_INPUT_NUM);
        }
        if (Integer.parseInt(inputValue) < 0) {
            throw new RuntimeException(ErrorMessage.ERROR_INPUT_POSITIVE);
        }
        return true;
    }
}
