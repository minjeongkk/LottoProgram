package StringAddCalculator;

import StringAddCalculator.StringAddCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getString_기본_또는_커스텀(){
        String result = StringAddCalculator.getString("1,2,3");
        assertThat(result).isEqualTo("1,2,3");

        String result2 = StringAddCalculator.getString("//;\n1;2;3");
        assertThat(result2).isEqualTo("1;2;3");
    }

    @Test
    public void splitString_하나_또는_여러개(){
        String[] result = StringAddCalculator.splitString("1");
        String[] expected =new String[]{"1"};
        assertThat(result).isEqualTo(expected);

        String[] result2 = StringAddCalculator.splitString("1,2,3");
        String[] expected2 =new String[]{"1","2","3"};
        assertThat(result2).isEqualTo(expected2);

        String[] result3 = StringAddCalculator.splitString("1:2:3:4");
        String[] expected3 =new String[]{"1","2","3","4"};
        assertThat(result3).isEqualTo(expected3);
    }

    @Test
    public void convertToInt_양수_또는_음수(){
        int[] result = StringAddCalculator.convertToInt(new String[]{"1","2","3","4"});
        int[] expected = new int[]{1,2,3,4};
        assertThat(result).isEqualTo(expected);

        assertThatThrownBy(() -> StringAddCalculator.convertToInt(new String[]{"-1","2","3","4"}))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void convertToInt_문자(){
        assertThatThrownBy(() -> StringAddCalculator.convertToInt(new String[]{"1","d","3","4"}))
                .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> StringAddCalculator.convertToInt(new String[]{"1","dd","3","4"}))
                .isInstanceOf(RuntimeException.class);
    }
}
