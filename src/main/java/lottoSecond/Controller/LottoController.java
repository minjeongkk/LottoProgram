package lottoSecond.Controller;

import lottoSecond.Model.LottoTicket;
import lottoSecond.Model.Money;
import lottoSecond.Model.WinningTicket;
import lottoSecond.Service.LottoService;
import lottoSecond.View.InputView;
import lottoSecond.View.OutputView;

import java.util.List;

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

}
