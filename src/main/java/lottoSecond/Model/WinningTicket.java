package lottoSecond.Model;

import java.util.List;
/*
* 지난주 로또 당첨 번호와 보너스볼을 담은 클래스
* */
public class WinningTicket {
    private List<Integer> lottoNums;
    private int bonusNum;

    public WinningTicket(List<Integer> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public int getBonusBall() {
        return bonusNum;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    public void checkBonusNum(String inputValue){
        if (inputValue == null || inputValue.isEmpty() || !inputValue.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new RuntimeException("숫자를 입력해주세요.");
        }
        if (Integer.parseInt(inputValue) < 1 || Integer.parseInt(inputValue) > 45) {
            throw new RuntimeException("1~45 사이의 숫자를 입력해주세요.");
        }
        if (isMatched(Integer.parseInt(inputValue),lottoNums)==1){
            throw new RuntimeException("중복되지 않은 숫자를 입력해주세요.");
        }
        this.bonusNum = Integer.parseInt(inputValue);
    }

    public int isMatched(int lottoNum, List<Integer> lotto) {
        if (lotto.contains(lottoNum)) {
            return 1;
        }
        return 0;
    }
}
