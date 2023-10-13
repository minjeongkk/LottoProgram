package lottoSecond.Model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    public void createMoney_실패_null(){
        assertThatThrownBy(() -> {new Money(null);})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void createMoney_실패_빈문자(){
        assertThatThrownBy(() -> {new Money("");})
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void createMoney_실패_문자(){
        assertThatThrownBy(() -> new Money("2000원"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void createMoney_실패_음수(){
        assertThatThrownBy(() -> new Money("-2000"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void createMoney_성공(){
        Money money = new Money("2000");
        assertThat(money.isMoney("2000")).isTrue();
    }

    @Test
    public void getMoney(){
        Money money = new Money("2000");
        assertThat(money.getMoney()).isEqualTo(2000);
    }

}
