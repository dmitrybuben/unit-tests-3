package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainHWTest {
    // HW 3.1. Нужно покрыть тестами метод на 100%
    // Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).

    MainHW hw;

    @BeforeEach
    void setUp(){
        hw = new MainHW();
    }

    @ParameterizedTest
    @CsvSource({"1, false", "2, true", "3, false", "4, true"})
    void checkOddOrEvenNumber(int number, boolean expected) {
        boolean actual = hw.OddOrEvenNumber(number);
        assertEquals(expected, actual);
    }

    // HW 3.2. Нужно написать метод который проверяет, попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
    // покрыть тестами метод на 100%

    @ParameterizedTest
    @CsvSource({"24, false", "25, false", "26, true", "50, true", "99, true", "100, false", "101, false"})
    void checkNumberInsideInterval (int number, boolean expected) {
        boolean actual = hw.NumberInsideInterval(number);
        assertEquals(expected,actual);
    }
}
