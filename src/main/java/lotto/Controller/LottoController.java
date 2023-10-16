package lotto.Controller;

import lotto.Model.LottoTicket;
import lotto.Model.Money;
import lotto.Model.Rank;
import lotto.Model.WinningTicket;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public List<LottoTicket> buyLotto() {
        InputView.printInputMoney();
        Money money = lottoService.inputMoney();
        int count = lottoService.countLotto(money);
        List<LottoTicket> lottoTicketList = lottoService.buyLottoTickets(count);
        OutputView.printOutputLottoList(count, lottoTicketList);
        return lottoTicketList;
    }

    public WinningTicket setWinningTicket() {
        InputView.printInputLottoNums();
        WinningTicket winningTicket = lottoService.inputBeforeLotto();
        InputView.printInputBonus();
        lottoService.inputBonusNum(winningTicket);
        return winningTicket;
    }

    public Map<Rank, Integer> matchLotto(WinningTicket winningTicket, List<LottoTicket> lottoTickets) {
        return lottoService.countMatchValue(winningTicket, lottoTickets);
    }

    public void printResult(int count, Map<Rank, Integer> countRanks) {
        float rate = lottoService.calculateRate(count);
        String result = lottoService.checkResult(rate);
        OutputView.printOutputResult(countRanks, rate, result);
    }


}
