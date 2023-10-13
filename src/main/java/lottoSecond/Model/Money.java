package lottoSecond.Model;

public class Money {
    private int inputMoney = 0;

    public Money(){}

    public Money(String inputValue){
        if(isMoney(inputValue)){
            inputMoney = Integer.parseInt(inputValue);
        }
    }

    public int getMoney(){
        return inputMoney;
    }

    public boolean isMoney(String inputValue){
        if (inputValue == null || inputValue.isEmpty() || !inputValue.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new RuntimeException("숫자를 입력해주세요.");
        }
        if (Integer.parseInt(inputValue) < 0) {
            throw new RuntimeException("양수를 입력해주세요.");
        }
        return true;
    }
}
