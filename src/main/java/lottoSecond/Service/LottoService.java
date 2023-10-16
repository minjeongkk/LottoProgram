package lottoSecond.Service;

import lottoSecond.Model.*;

import java.text.DecimalFormat;
import java.util.*;

public class LottoService {
    private final int ZERO = 0;
    private final int ONE = 1;
    private final int LOTTO_MONEY = 1000;
    private final float RATE_ZERO = 0f;
    private final int RATE_STANDARD = 1;
    private final String DECIMAL_PATTERN = "0.00";
    private final String STRING_BENEFIT = "이득";
    private final String STRING_LOSS = "손해";


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

    public WinningTicket inputBeforeLotto() {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        LottoStore lottoStore = new LottoStore();
        List<Integer> nums = lottoStore.splitNums(inputValue);
        return new WinningTicket(nums);
    }

    public void inputBonusNum(WinningTicket winningTicket) {
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        winningTicket.checkBonusNum(inputValue);
    }

    public Map<Rank, Integer> countMatchValue(WinningTicket winningTicket, List<LottoTicket> lottoTicketList) {
        for (LottoTicket lottoTicket : lottoTicketList) {
            Rank rank = lottoTicket.checkRank(winningTicket);
            countRanks.replace(rank, countRanks.get(rank) + ONE);
        }
        return countRanks;
    }

    public float calculateRate(int size) {
        if (size == ZERO) {
            return RATE_ZERO;
        }
        int earnMoney = 0;
        for (Rank rank : Rank.values()) {
            earnMoney += countRanks.get(rank) * rank.getWinningMoney();
        }
        DecimalFormat df = new DecimalFormat(DECIMAL_PATTERN);
        String earnRate = df.format((float) earnMoney / (size * LOTTO_MONEY));
        return Float.parseFloat(earnRate);
    }

    public String checkResult(float rate) {
        if (rate < RATE_STANDARD) {
            return STRING_LOSS;
        }
        return STRING_BENEFIT;
    }

}
