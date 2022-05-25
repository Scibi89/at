package com;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ExampleTest {

    @Test
    void shouldThrowException() {
        assertThatThrownBy(
                        () -> {
                            final List<String> list = Arrays.asList("String one", "String two");
                            list.get(2);
                        })
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void isOdd_ShouldReturnTrueForOddNumbers(final int number) {
        assertThat(isOdd(number)).isTrue();
    }

    public boolean isOdd(final int number) {
        return number % 2 != 0;
    }

    @ParameterizedTest(name = "uppercase={0}, expected={2} ")
    @MethodSource("countriesAndBrands")
    void shouldLowerCase(final String uppercase, final String expected) {
        assertThat(uppercase.toLowerCase()).isEqualTo(expected);
    }

    private static Stream<Arguments> countriesAndBrands() {
        return Stream.of(Arguments.of("EE", "ee"), Arguments.of("AA", "aa"));
    }
}
