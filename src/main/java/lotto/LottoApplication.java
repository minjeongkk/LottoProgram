package lotto;

import lotto.Controller.LottoController;
import lotto.Model.LottoTicket;
import lotto.Model.Rank;
import lotto.Model.WinningTicket;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {
        // 로또 프로그램 시작
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}