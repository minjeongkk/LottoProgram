package lotto.Service;

import lotto.Model.*;
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
        LottoNo lottoNo1 = new LottoNo("1");
        LottoNo lottoNo2 = new LottoNo("2");
        LottoNo lottoNo3 = new LottoNo("3");
        LottoNo lottoNo4 = new LottoNo("4");
        LottoNo lottoNo5 = new LottoNo("5");
        LottoNo lottoNo6 = new LottoNo("6");
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(lottoNo1,lottoNo2,lottoNo3,
                lottoNo4,lottoNo5,lottoNo6));
        winningTicket.checkBonusNum("7");

        LottoNo myLottoNo1 = new LottoNo("1");
        LottoNo myLottoNo2 = new LottoNo("2");
        LottoNo myLottoNo3 = new LottoNo("3");
        LottoNo myLottoNo4 = new LottoNo("4");
        LottoNo myLottoNo5 = new LottoNo("5");
        LottoNo myLottoNo6 = new LottoNo("6");

        lottoList.add(new LottoTicket(Arrays.asList(myLottoNo1,myLottoNo2,myLottoNo3,
                myLottoNo4,myLottoNo5,myLottoNo6)));
        Map<Rank, Integer> results = lottoService.countMatchValue(winningTicket, lottoList);

        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void countMatchValue_2등() {
        LottoService lottoService = new LottoService();

        List<LottoTicket> lottoList = new ArrayList<>();
        LottoNo lottoNo1 = new LottoNo("1");
        LottoNo lottoNo2 = new LottoNo("2");
        LottoNo lottoNo3 = new LottoNo("3");
        LottoNo lottoNo4 = new LottoNo("4");
        LottoNo lottoNo5 = new LottoNo("5");
        LottoNo lottoNo6 = new LottoNo("6");
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(lottoNo1,lottoNo2,lottoNo3,
                                                        lottoNo4,lottoNo5,lottoNo6));
        winningTicket.checkBonusNum("7");

        LottoNo myLottoNo1 = new LottoNo("1");
        LottoNo myLottoNo2 = new LottoNo("2");
        LottoNo myLottoNo3 = new LottoNo("3");
        LottoNo myLottoNo4 = new LottoNo("4");
        LottoNo myLottoNo5 = new LottoNo("5");
        LottoNo myLottoNo6 = new LottoNo("7");

        lottoList.add(new LottoTicket(Arrays.asList(myLottoNo1,myLottoNo2,myLottoNo3,
                                        myLottoNo4,myLottoNo5,myLottoNo6)));
        Map<Rank, Integer> results = lottoService.countMatchValue(winningTicket, lottoList);

        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
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
