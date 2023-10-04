package lottoSecond;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void valueOf_2등_3등() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);

        Rank rank2 = Rank.valueOf(5, false);
        assertThat(rank2).isEqualTo(Rank.THIRD);
    }
}