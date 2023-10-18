package lotto.Model;

import lotto.Service.LottoService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    void checkRank_2등() {
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

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(myLottoNo1,myLottoNo2,myLottoNo3,
                myLottoNo4,myLottoNo5,myLottoNo6));
        Rank rank = lottoTicket.checkRank(winningTicket);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void checkRank_3등(){
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
        LottoNo myLottoNo6 = new LottoNo("8");

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(myLottoNo1,myLottoNo2,myLottoNo3,
                myLottoNo4,myLottoNo5,myLottoNo6));
        Rank rank = lottoTicket.checkRank(winningTicket);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }
}