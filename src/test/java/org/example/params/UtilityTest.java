package org.example.params;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

//asserThat(actual).<verify>(expected
//verify sa acepete in totdeauna

public class UtilityTest {
    @ParameterizedTest   //-> needs test data surce
    @ValueSource(ints = {1,3,5,7,9,-33,-21})
    void test_IsOdd_happy_path(int number) {
        assertThat(Utility.isOdd(number))
                .withFailMessage("Numarul trebuie sa fie impar")
                .isTrue();
    }
    @ParameterizedTest
    @ValueSource(doubles = {2.3,2.5,-2.0,-22.12})
    void test_roundDouble(  Double imput){
        double expected = Math.round(imput);   //rotunjeste la integer -> 2,3,2,-2,-22
        assertThat(Utility.roundDouble(imput))
                .isEqualTo(expected);
    }
    //to do : modify ti check String va Sting
    @ParameterizedTest
    @ValueSource(strings= {"121", "madam", "apa", "Ana", "hello"})
    void test_isPalondrome(String imput) {
        String expected = new StringBuilder(imput).reverse().toString();
        assertThat(Utility.isPalindrome(imput))
                .isEqualTo(expected.equalsIgnoreCase(imput));

    }

    @ParameterizedTest
    @CsvSource(value = {"   test; TEST","tEST;TEST", "Java;JAVA"},delimiter = ';')
    void test_UpperCase(String imput ,String expected) {
        assertThat(Utility.toUppercase(imput))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("primeNumbersProvider")
    void  test_isPrime1(int input, boolean expected) {
        assertThat(Utility.isPrime(input))
                .isEqualTo(expected);

    }

    static Stream<Arguments>primeNumbersProvider() {
        return Stream.of(
                Arguments.of(2,true),
                Arguments.of(13,true),
                Arguments.of(6,false),
                Arguments.of(-12,false),
                Arguments.of(-7,false)
        );

    }

    @ParameterizedTest
    @ArgumentsSource(PrimeNumberArgsProvider)
    void testIsPrime2(int imput,boolean expected) {
        assertThat(Utility.isPrime(imput))
                .isEqualTo(expected)
  }

}
