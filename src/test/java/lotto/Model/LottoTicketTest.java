package lotto.Model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    void checkRank_2등_3등() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1,2,3,4,5,10));
        winningTicket.checkBonusNum("6");
        Rank rank = lottoTicket.checkRank(winningTicket);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void checkRank_3등(){
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,8));
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(1,2,3,4,5,10));
        winningTicket.checkBonusNum("11");
        Rank rank = lottoTicket.checkRank(winningTicket);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
}