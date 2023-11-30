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

    public int countLotto(){
        InputView.printInputMoney();
        Money money = lottoService.inputMoney();
        return lottoService.countLotto(money);
    }

    public List<LottoTicket> buyLotto(int count) {
        InputView.printInputManualNums();
        int manualCount = lottoService.inputManualLotto(count);
        InputView.printInputManualLottoNums();
        List<LottoTicket> lottoTicketList = lottoService.buyManualLottoTickets(manualCount);
        lottoTicketList = lottoService.buyLottoTickets(lottoTicketList, count - manualCount);
        OutputView.printOutputLottoCount(manualCount, count);
        OutputView.printOutputLottoList(lottoTicketList);
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

    public void run(){
        int count = countLotto();
        List<LottoTicket> myLottoTicket = buyLotto(count);
        WinningTicket winningTicket = setWinningTicket();
        Map<Rank, Integer> matchLotto = matchLotto(winningTicket, myLottoTicket);
        printResult(myLottoTicket.size(), matchLotto);
    }

}
