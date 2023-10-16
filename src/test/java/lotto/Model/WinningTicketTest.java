package lotto.Model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTicketTest {
    @Test
    public void setBonusBall_실패_문자(){
        List<Integer> lottonums = Arrays.asList(1, 2, 3, 7, 8, 9);
        String bonusBall = "ㄱ";
        WinningTicket winningTicket = new WinningTicket(lottonums);
        assertThatThrownBy(() -> {winningTicket.checkBonusNum(bonusBall);})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void setBonusBall_실패_범위(){
        List<Integer> lottonums = Arrays.asList(1, 2, 3, 7, 8, 9);
        String bonusBall = "100";
        WinningTicket winningTicket = new WinningTicket(lottonums);
        assertThatThrownBy(() -> {winningTicket.checkBonusNum(bonusBall);})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void setBonusBall_실패_중복(){
        List<Integer> lottonums = Arrays.asList(1, 2, 3, 7, 8, 9);
        String bonusBall = "1";
        WinningTicket winningTicket = new WinningTicket(lottonums);
        assertThatThrownBy(() -> {winningTicket.checkBonusNum(bonusBall);})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void setBonusBall_성공(){
        List<Integer> lottonums = Arrays.asList(1, 2, 3, 7, 8, 9);
        String bonusBall = "10";
        WinningTicket winningTicket = new WinningTicket(lottonums);
        winningTicket.checkBonusNum(bonusBall);
        assertThat(winningTicket.getBonusBall()).isEqualTo(10);
    }
}