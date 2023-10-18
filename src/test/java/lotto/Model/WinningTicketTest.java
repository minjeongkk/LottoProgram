package lotto.Model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTicketTest {
    @Test
    public void setBonusBall_실패_문자(){
        LottoNo lottoNo1 = new LottoNo("1");
        LottoNo lottoNo2 = new LottoNo("2");
        LottoNo lottoNo3 = new LottoNo("3");
        LottoNo lottoNo4 = new LottoNo("4");
        LottoNo lottoNo5 = new LottoNo("5");
        LottoNo lottoNo6 = new LottoNo("6");
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(lottoNo1,lottoNo2,lottoNo3,
                lottoNo4,lottoNo5,lottoNo6));

        String bonusBall = "ㄱ";
        assertThatThrownBy(() -> {winningTicket.checkBonusNum(bonusBall);})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void setBonusBall_실패_범위(){
        LottoNo lottoNo1 = new LottoNo("1");
        LottoNo lottoNo2 = new LottoNo("2");
        LottoNo lottoNo3 = new LottoNo("3");
        LottoNo lottoNo4 = new LottoNo("4");
        LottoNo lottoNo5 = new LottoNo("5");
        LottoNo lottoNo6 = new LottoNo("6");
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(lottoNo1,lottoNo2,lottoNo3,
                lottoNo4,lottoNo5,lottoNo6));

        String bonusBall = "100";
        assertThatThrownBy(() -> {winningTicket.checkBonusNum(bonusBall);})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void setBonusBall_실패_중복(){
        LottoNo lottoNo1 = new LottoNo("1");
        LottoNo lottoNo2 = new LottoNo("2");
        LottoNo lottoNo3 = new LottoNo("3");
        LottoNo lottoNo4 = new LottoNo("4");
        LottoNo lottoNo5 = new LottoNo("5");
        LottoNo lottoNo6 = new LottoNo("6");
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(lottoNo1,lottoNo2,lottoNo3,
                lottoNo4,lottoNo5,lottoNo6));

        String bonusBall = "1";
        assertThatThrownBy(() -> {winningTicket.checkBonusNum(bonusBall);})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void setBonusBall_성공(){
        LottoNo lottoNo1 = new LottoNo("1");
        LottoNo lottoNo2 = new LottoNo("2");
        LottoNo lottoNo3 = new LottoNo("3");
        LottoNo lottoNo4 = new LottoNo("4");
        LottoNo lottoNo5 = new LottoNo("5");
        LottoNo lottoNo6 = new LottoNo("6");
        WinningTicket winningTicket = new WinningTicket(Arrays.asList(lottoNo1,lottoNo2,lottoNo3,
                lottoNo4,lottoNo5,lottoNo6));

        String bonusBall = "10";
        winningTicket.checkBonusNum(bonusBall);
        assertThat(winningTicket.getBonusBall().getLottoNo()).isEqualTo(10);
    }
}