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
    public void countLotto() {
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();

        int actual = lottoAutoProgram.countLotto(12000);
        assertThat(actual).isEqualTo(12);
    }

    @Test
    public void createLotto() {
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();
        List<Integer> list = lottoAutoProgram.createLotto();
        assertThat(list.size()).isEqualTo(6);
    }

    @Test
    public void splitNums_숫자가_아닌_경우(){
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();
        assertThatThrownBy(() -> lottoAutoProgram.splitNums("abcd"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitNums_범위_벗어난_경우(){
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();
        assertThatThrownBy(() -> lottoAutoProgram.splitNums("46, 47, 48, 49, 50, -1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitNums_개수6개_아닌_경우(){
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();
        assertThatThrownBy(() -> lottoAutoProgram.splitNums("1,2"))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoAutoProgram.splitNums("1, 2, 1, 2, 1, 2"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void countMatchValue() {
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();
        int[] expected = new int[]{1, 1, 0, 0};

        int[] lottoNums = new int[]{1, 2, 3, 4, 5, 6};
        List<List<Integer>> lottoList = new ArrayList<>();
        lottoList.add(Arrays.asList(1, 2, 3, 7, 8, 9));
        lottoList.add(Arrays.asList(1, 2, 3, 4, 43, 41));
        lottoList.add(Arrays.asList(12, 22, 32, 44, 42, 10));
        int[] result = lottoAutoProgram.countMatchValue(lottoNums, lottoList);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void calculateRate() {
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();
        float expected = 0.36f;
        float actual = lottoAutoProgram.calculateRate(14000, new int[]{1, 0, 0, 0});
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void printResult() {
        LottoAutoProgram lottoAutoProgram = new LottoAutoProgram();
        String expected = "손해";
        String actual = lottoAutoProgram.checkResult(0.35f);
        assertThat(actual).isEqualTo(expected);

        String expected2 = "이득";
        String actual2 = lottoAutoProgram.checkResult(1.35f);
        assertThat(actual2).isEqualTo(expected2);
    }
}