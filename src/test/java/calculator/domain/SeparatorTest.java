package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SeparatorTest {
    @DisplayName("구분자 입력 성공")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n", "//(\n"})
    void separatorTest(String inputs) {
        //given
        //when, then
        assertThatCode(() -> new Separator(inputs)).doesNotThrowAnyException();
    }

    @DisplayName("커스텀 구분자 입력 실패: 길이 5자 초과")
    @ParameterizedTest
    @ValueSource(strings = {"//abcdef\n", "//123456\n"})
    void validateLengthTest(String inputs) {
        //given
        //when, then
        assertThatThrownBy(() -> new Separator(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 5자 이하여야 합니다.");
    }

    @DisplayName("커스텀 구분자 입력 실패 : 숫자 입력")
    @ParameterizedTest
    @ValueSource(strings = {"//1\n"})
    void validateLetterTest(String inputs) {
        //given
        //when, then
        assertThatThrownBy(() -> new Separator(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 숫자가 될 수 없습니다.");
    }

    @DisplayName("커스텀 구분자 입력 실패 : 쉼표, 콜론 입력")
    @ParameterizedTest
    @ValueSource(strings = {"//,\n", "//:\n"})
    void validateNotDefaultTest(String inputs) {
        //given
        //when, then
        assertThatThrownBy(() -> new Separator(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 기본 구분자 외의 문자여야 합니다.");
    }

    @DisplayName("문자열 분리 성공")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "//;\n1;2;3"})
    void splitBySeparatorTest(String inputs) {
        //given
        //when
        Separator separator = new Separator(inputs);
        String[] splitValue = separator.split(inputs);
        //then
        assertThat(splitValue).isEqualTo(new String[]{"1", "2", "3"});
    }
}
