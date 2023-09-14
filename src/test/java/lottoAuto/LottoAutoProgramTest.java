package lottoAuto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoAutoProgramTest {

    @Test
    public void checkInputValue_양수가_아닌_경우() {
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();

        assertThatThrownBy(() -> lottoAutoProgram.checkInputValue(null))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoAutoProgram.checkInputValue(""))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoAutoProgram.checkInputValue("string"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void countLotto(){
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();

        int actual = lottoAutoProgram.countLotto(12000);
        assertThat(actual).isEqualTo(12);
    }
}