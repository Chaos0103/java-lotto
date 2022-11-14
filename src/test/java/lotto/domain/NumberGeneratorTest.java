package lotto.domain;

import lotto.domain.impl.NumberGeneratorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Constants.*;
import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {

    private final NumberGenerator numberGenerator = new NumberGeneratorImpl();

    @Test
    @DisplayName("생성된 숫자는 6개이다.")
    void numbersSize() {
        List<Integer> numbers = numberGenerator.createRandomNumbers();

        assertThat(numbers.size()).isEqualTo(LOTTO_NUMBERS_COUNT);
    }

    @Test
    @DisplayName("생성된 숫자는 1~45사이의 숫자이다.")
    void numbersRange() {
        List<Integer> numbers = numberGenerator.createRandomNumbers();

        numbers.forEach(number ->
                assertThat(number).isBetween(NUMBER_MIN_RANGE, NUMBER_MAX_RANGE));
    }
}