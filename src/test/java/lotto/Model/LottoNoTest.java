package lotto.Model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNoTest {
    @Test
    public void checkLottoNo_실패_null(){
        assertThatThrownBy(() -> {new LottoNo(null);})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void checkLottoNo_실패_빈문자(){
        assertThatThrownBy(() -> {new LottoNo("");})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void checkLottoNo_실패_문자(){
        assertThatThrownBy(() -> new LottoNo("2번"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void checkLottoNo_실패_범위(){
        assertThatThrownBy(() -> new LottoNo("50"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void checkLottoNo_성공(){
        LottoNo lottoNo = new LottoNo("2");
        assertThat(lottoNo.getLottoNo()).isEqualTo(2);
    }
}
