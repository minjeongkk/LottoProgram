package lottoSecond.Model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTicketTest {
    @Test
    public void setBonusBall_실패(){
        List<Integer> lottonums = Arrays.asList(1, 2, 3, 7, 8, 9);
        int bonusBall = 1;
        WinningTicket winningTicket = new WinningTicket(lottonums);
        assertThatThrownBy(() -> {winningTicket.checkBonusNum(bonusBall);})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void setBonusBall_성공(){
        List<Integer> lottonums = Arrays.asList(1, 2, 3, 7, 8, 9);
        int bonusBall = 10;
        WinningTicket winningTicket = new WinningTicket(lottonums);
        winningTicket.checkBonusNum(bonusBall);
        assertThat(winningTicket.getBonusBall()).isEqualTo(10);
    }

    @Test
    public void setNums_실패_중복(){
        List<Integer> lottonums = Arrays.asList(1, 2, 3, 7, 8, 8);
        WinningTicket winningTicket = new WinningTicket(lottonums);
        assertThat(winningTicket.getLottoNums()).isEqualTo(Arrays.asList(1, 2, 3, 7, 8, 9));
    }

    @Test
    public void setNums_실패_범위벗어남(){
        List<Integer> lottonums = Arrays.asList(1, 2, 3, 7, 8, 50);
        WinningTicket winningTicket = new WinningTicket(lottonums);
        assertThat(winningTicket.getLottoNums()).isEqualTo(Arrays.asList(1, 2, 3, 7, 8, 9));
    }

    @Test
    public void setNums_실패_개수(){
        List<Integer> lottonums = Arrays.asList(1, 2, 3);
        WinningTicket winningTicket = new WinningTicket(lottonums);
        assertThat(winningTicket.getLottoNums()).isEqualTo(Arrays.asList(1, 2, 3, 7, 8, 9));
    }

    @Test
    public void setNums_성공(){
        List<Integer> lottonums = Arrays.asList(1, 2, 3, 7, 8, 9);
        WinningTicket winningTicket = new WinningTicket(lottonums);
        assertThat(winningTicket.getLottoNums()).isEqualTo(Arrays.asList(1, 2, 3, 7, 8, 9));
    }
}