package lottoAuto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void createLotto(){
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();
        List<Integer> list = lottoAutoProgram.createLotto();
        assertThat(list).allMatch(nums -> nums.size()==6);
    }

    @Test
    public void calculateRate(){
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();
        float expected = 0.35f;
        float actual = lottoAutoProgram.calculateRate(14000, new int[]{1,0,0,0});
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void printResult(){
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();
        String expected = "손해";
        String actual = lottoAutoProgram.checkResult(0.35f);
        assertThat(actual).isEqualTo(expected);
    }
}