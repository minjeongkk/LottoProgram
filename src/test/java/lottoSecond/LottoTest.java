package lottoSecond;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void checkRank_2등_3등() {
        List<Integer> winningLotto = Arrays.asList(1,2,3,4,5,6);
        int bonusNum = 7;
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        Rank rank = lotto.checkRank(winningLotto, bonusNum);
        assertThat(rank).isEqualTo(Rank.SECOND);

        List<Integer> winningLotto2 = Arrays.asList(1,2,3,4,5,6);
        int bonusNum2 = 7;
        Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,5,8));
        Rank rank2 = lotto2.checkRank(winningLotto2, bonusNum2);
        assertThat(rank2).isEqualTo(Rank.THIRD);
    }
}