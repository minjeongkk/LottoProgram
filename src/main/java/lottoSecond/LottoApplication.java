package lottoSecond;

import lottoSecond.Controller.LottoController;
import lottoSecond.Model.LottoTicket;
import lottoSecond.Model.Rank;
import lottoSecond.Model.WinningTicket;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {
        // 로또 프로그램 시작
        LottoController lottoController = new LottoController();
        List<LottoTicket> myLottoTicket = lottoController.buyLotto();
        WinningTicket winningTicket = lottoController.setWinningTicket();
        Map<Rank, Integer> matchLotto = lottoController.matchLotto(winningTicket, myLottoTicket);
        lottoController.printResult(myLottoTicket.size(), matchLotto);
    }
}