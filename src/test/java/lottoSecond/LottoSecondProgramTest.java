package lottoSecond;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoSecondProgramTest {

    @Test
    public void checkInputValue_양수가_아닌_경우() {
        LottoSecondProgram lottoSecondProgram = new LottoSecondProgram();

        assertThatThrownBy(() -> lottoSecondProgram.checkInputValue(null))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoSecondProgram.checkInputValue(""))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoSecondProgram.checkInputValue("string"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void countLotto() {
        LottoSecondProgram lottoSecondProgram = new LottoSecondProgram();

        int actual = lottoSecondProgram.countLotto(12000);
        assertThat(actual).isEqualTo(12);
    }

    @Test
    public void splitNums_숫자가_아닌_경우(){
        LottoSecondProgram lottoSecondProgram = new LottoSecondProgram();
        assertThatThrownBy(() -> lottoSecondProgram.splitNums("abcd"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitNums_범위_벗어난_경우(){
        LottoSecondProgram lottoSecondProgram = new LottoSecondProgram();
        assertThatThrownBy(() -> lottoSecondProgram.splitNums("46, 47, 48, 49, 50, -1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitNums_개수6개_아닌_경우(){
        LottoSecondProgram lottoSecondProgram = new LottoSecondProgram();
        assertThatThrownBy(() -> lottoSecondProgram.splitNums("1,2"))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoSecondProgram.splitNums("1, 2, 1, 2, 1, 2"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void printResult() {
        LottoSecondProgram lottoSecondProgram = new LottoSecondProgram();
        String expected = "손해";
        String actual = lottoSecondProgram.checkResult(0.35f);
        assertThat(actual).isEqualTo(expected);

        String expected2 = "이득";
        String actual2 = lottoSecondProgram.checkResult(1.35f);
        assertThat(actual2).isEqualTo(expected2);
    }

    @Test
    public void checkBonusNum_예외처리(){
        LottoSecondProgram lottoSecondProgram = new LottoSecondProgram();

        List<Integer> winningLotto = Arrays.asList(1,2,3,4,5,6);
        assertThatThrownBy(() -> lottoSecondProgram.checkBonusNum(null,winningLotto))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoSecondProgram.checkBonusNum("",winningLotto))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoSecondProgram.checkBonusNum("string",winningLotto))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoSecondProgram.checkBonusNum(String.valueOf(-1),winningLotto))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoSecondProgram.checkBonusNum(String.valueOf(46),winningLotto))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoSecondProgram.checkBonusNum(String.valueOf(1),winningLotto))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void checkBonusNum_성공(){
        LottoSecondProgram lottoSecondProgram = new LottoSecondProgram();

        List<Integer> winningLotto = Arrays.asList(1,2,3,4,5,6);
        int bonusNum = lottoSecondProgram.checkBonusNum(String.valueOf(7),winningLotto);
        assertThat(bonusNum).isEqualTo(7);
    }
}