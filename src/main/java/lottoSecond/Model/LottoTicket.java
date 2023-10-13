package lottoSecond.Model;

import java.util.List;

/*
* 로또 한장의 정보를 담은 클래스
*
* 로또 번호, 당첨 등수
* */
public class LottoTicket {
    private final List<Integer> lottoNums;
    private Rank rank;

    public LottoTicket(List<Integer> lottoNums) {
        this.lottoNums = lottoNums;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    @Override
    public String toString() {
        return lottoNums.toString();
    }

    /*
     * 하나의 로또에서 당첨 등수를 매기는 함수
     * */
    public Rank checkRank(List<Integer> winningLotto, int bonusNum){
        int winningMoney = 0;
        boolean bonus = false;
        for (Integer lottoNum : this.lottoNums) {
            winningMoney += isMatched(lottoNum, winningLotto);    // 일치하면 1 더함
        }
        if (isMatched(bonusNum, this.lottoNums)==1){    // 보너스 번호가 일치하는지 확인
            bonus = true;
        }
        this.rank = Rank.valueOf(winningMoney, bonus);
        return this.rank;
    }

    /*
     * 로또에 일치하는 번호가 있는지 확인하는 함수
     *
     * 있으면 1 리턴, 없으면 0 리턴
     * */
    public int isMatched(int lottoNum, List<Integer> lotto) {
        if (lotto.contains(lottoNum)) {
            return 1;
        }
        return 0;
    }
}