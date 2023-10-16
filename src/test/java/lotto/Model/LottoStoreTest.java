package lotto.Model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {
    @Test
    public void splitNums_숫자가_아닌_경우(){
        LottoStore lottoStore = new LottoStore();
        assertThatThrownBy(() -> lottoStore.splitNums("abcd"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitNums_범위_벗어난_경우(){
        LottoStore lottoStore = new LottoStore();
        assertThatThrownBy(() -> lottoStore.splitNums("46, 47, 48, 49, 50, -1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitNums_개수6개_아닌_경우(){
        LottoStore lottoStore = new LottoStore();
        assertThatThrownBy(() -> lottoStore.splitNums("1,2"))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> lottoStore.splitNums("1, 2, 1, 2, 1, 2"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitNums_중복되는_경우(){
        LottoStore lottoStore = new LottoStore();
        assertThatThrownBy(() -> lottoStore.splitNums("1, 2, 1, 2, 1, 2"))
                .isInstanceOf(RuntimeException.class);
    }

}