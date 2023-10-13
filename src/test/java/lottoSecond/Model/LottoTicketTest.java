package lottoSecond.Model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    void checkRank_2등_3등() {
        List<Integer> winningLotto = Arrays.asList(1,2,3,4,5,6);
        int bonusNum = 7;
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,7));
        Rank rank = lottoTicket.checkRank(winningLotto, bonusNum);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    void checkRank_3등(){
        List<Integer> winningLotto = Arrays.asList(1,2,3,4,5,6);
        int bonusNum = 7;
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,8));
        Rank rank = lottoTicket.checkRank(winningLotto, bonusNum);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
}