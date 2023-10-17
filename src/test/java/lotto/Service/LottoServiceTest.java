package lotto.Service;

import lotto.Model.LottoTicket;
import lotto.Model.Money;
import lotto.Model.Rank;
import lotto.Model.WinningTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    @Test
    void countLotto() {
        LottoService lottoService = new LottoService();
        Money money = new Money("12000");

        int actual = lottoService.countLotto(money);
        assertThat(actual).isEqualTo(12);
    }

    @Test
    void countMatchValue_1등() {
        LottoService lottoService = new LottoService();

        List<LottoTicket> lottoList = new ArrayList<>();
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1,2,3,4,5,6));
        winningTicket.checkBonusNum("7");

        lottoList.add(new LottoTicket(Arrays.asList(1,2,3,4,5,6)));
        lottoList.add(new LottoTicket(Arrays.asList(1,2,3,4,5,7)));
        lottoList.add(new LottoTicket(Arrays.asList(1,2,3,4,5,8)));
        Map<Rank, Integer> results = lottoService.countMatchValue(winningTicket, lottoList);

        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void countMatchValue_2등() {
        LottoService lottoService = new LottoService();

        List<LottoTicket> lottoList = new ArrayList<>();
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1,2,3,4,5,6));
        winningTicket.checkBonusNum("7");

        lottoList.add(new LottoTicket(Arrays.asList(1,2,3,4,5,6)));
        lottoList.add(new LottoTicket(Arrays.asList(1,2,3,4,5,7)));
        lottoList.add(new LottoTicket(Arrays.asList(1,2,3,4,5,7)));
        Map<Rank, Integer> results = lottoService.countMatchValue(winningTicket, lottoList);

        assertThat(results.get(Rank.SECOND)).isEqualTo(2);
    }

    @Test
    void calculateRate() {
        LottoService lottoService = new LottoService();
        float expected = 0f;
        float actual = lottoService.calculateRate(0);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkResult_손해() {
        LottoService lottoService = new LottoService();
        String expected = "손해";
        String actual = lottoService.checkResult(0.35f);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void checkResult_이득() {
        LottoService lottoService = new LottoService();
        String expected = "이득";
        String actual = lottoService.checkResult(1.35f);
        assertThat(actual).isEqualTo(expected);
    }
}
