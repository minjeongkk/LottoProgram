package lottoSecond.Service;

import lottoSecond.Model.*;

import java.util.*;

public class LottoService {
    private final int ZERO = 0;
    private final int LOTTO_MONEY = 1000;

    private final Map<Rank, Integer> countRanks = new HashMap<Rank, Integer>();

    public LottoService() {
        for (Rank rank : Rank.values()) {
            countRanks.put(rank, ZERO);
        }
    }

    public Money inputMoney() {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.next();
        return new Money(inputValue);
    }

    public int countLotto(Money money) {
        return money.getMoney() / LOTTO_MONEY;
    }

    public List<LottoTicket> buyLottoTickets(int count) {
        LottoStore lottoStore = new LottoStore();
        lottoStore.setLottoStore();
        List<LottoTicket> purchaseLottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LottoTicket lottoTicket = lottoStore.createLotto();    // 로또 1개 생성
            purchaseLottoTickets.add(lottoTicket);
        }
        return purchaseLottoTickets;
    }
}
