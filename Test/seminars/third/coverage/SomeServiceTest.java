package seminars.third.coverage;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/*Создайте набор тестов, полностью покрывающих все ветви кода функции fizzBuzz.
    Эта функция принимает на вход число и возвращает "Fizz", если число делится на 3, "Buzz",
    если число делится на 5, и "FizzBuzz", если число делится на 15.
    Если число не делится ни на 3, ни на 5, ни на 15, функция возвращает входное число в виде строки.*/

class  SomeServiceTest {
   // 3.1.
    SomeService service;

    @BeforeEach
    void setUp(){
        service = new SomeService();
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9,12})
    void multipleThreeNotFiveReturnsFizz(int i) {
        String res = service.fizzBuzz(i);

        assertEquals(res, "Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5,10,20,25})
    void multipleFiveNotTreeReturnsBuzz(int i) {
        String res = service.fizzBuzz(i);

        assertEquals(res, "Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15,30,45,60})
    void multipleFifteenReturnsFizzBuzz(int i) {
        String res = service.fizzBuzz(i);

        assertEquals(res, "FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {4,7,8,13})
    void multipleNotThreeNotFiveNotFifteenReturnsInput(int i) {
        String res = service.fizzBuzz(i);

        assertEquals(res, "i");
    }

    /*Разработайте тесты для метода firstLast6, где на вход подается массив чисел,
    а метод возвращает true, если первое или последнее число в массиве равно 6, иначе false.
    Как вариант - все тестовые методы для этой задачи можно сделать через
    @ParameterizedTest
    @CsvSource(value = {0,6,0},{array},{array},type == int[].class)
    */

    @Test
    void checkNullableArray(){
        boolean res = service.firstLast6(null);

        assertFalse(res);
    }

    @Test
    void checkIfEmptyArray() {
        boolean res = service.firstLast6(new int[]{});

        assertFalse(res);
    }

    @Test
    void checkWithoutSixArray() {
        boolean res = service.firstLast6(new int[]{0,0,0});

        assertFalse(res);
    }

    @Test
    void checkFirstSixArray() {
        boolean res = service.firstLast6(new int[]{6,0,0});

        assertTrue(res);
    }

    @Test
    void checkLastLastSixArray() {
        boolean res = service.firstLast6(new int[]{0,0,6});

        assertTrue(res);
    }

    @Test
    void checkFirstLastSixArray() {
        boolean res = service.firstLast6(new int[]{6,0,6});

        assertTrue(res);
    }

    @Test
    void checkContainsSixArray() {
        boolean res = service.firstLast6(new int[]{0,6,0});

        assertFalse(res);
    }

    /**
     * 3.3. Метод подсчета скидки
     */
    @ParameterizedTest
    @CsvSource(value = {"100, 50", "200, 50", "1000, 20"})
    void CalculateDiscountPositive(double purchaseAmount, int discountAmount) {
        double res = service.calculatingDiscount(purchaseAmount,discountAmount);

        assertThat(res).isEqualTo(purchaseAmount - purchaseAmount * (double) discountAmount /100);
    }

    @ParameterizedTest
    @CsvSource(value = {"-100, 50", "-200, 50", "-1000, 20"})
    void checkCalculateAmountNegative(double purchaseAmount, int discountAmount) {
        Exception exc = assertThrows(IllegalArgumentException.class,
                () -> service.calculatingDiscount(purchaseAmount, discountAmount));
        assertEquals(exc.getMessage(),"Purchase amount can't be less than 0");

    }

    @ParameterizedTest
    @CsvSource(value = {"100, -50", "200, -50", "1000, -20"})
    void checkCalculateDiscountNegative(double purchaseAmount, int discountAmount) {
        Exception exc = assertThrows(IllegalArgumentException.class,
                () -> service.calculatingDiscount(purchaseAmount, discountAmount));
        assertThat(exc.getMessage()).isEqualTo("Discount amount can't be less than 0");
    }

    @ParameterizedTest
    @CsvSource(value = {"100, 150", "200, 150", "1000, 120"})
    void checkCalculateOverDiscountNegative(double purchaseAmount, int discountAmount) {
        Exception exc = assertThrows(IllegalArgumentException.class,
                () -> service.calculatingDiscount(purchaseAmount, discountAmount));
        assertEquals(exc.getMessage(),"Discount amount can't be more than 100");
    }

    /**
     * 3.4. Метод принимает на вход 3 числа (int a, b, c). Нужно вернуть их сумму. Однако, если одно из значений равно 13,
     * то оно не учитывается в сумме. Так, например, если b равно 13, то считается сумма только a и c.
     */

    @Test
    void checkSumThreeNumbersPositive() {
        int res = service.calculateThreeNumbersSum(1,2,3);

        assertEquals(res, 6);
    }

    @Test
    void checkTwoNumbersSum() {
        assertEquals(service.calculateThreeNumbersSum(13, 1, 2), 3);
        assertEquals(service.calculateThreeNumbersSum(1, 13, 2), 3);
        assertEquals(service.calculateThreeNumbersSum(1, 2, 13), 3);
    }

    @Test
    void checkOneNumbersSum() {
        assertEquals(service.calculateThreeNumbersSum(13, 13, 3), 3);
        assertEquals(service.calculateThreeNumbersSum(3, 13, 13), 3);
        assertEquals(service.calculateThreeNumbersSum(13, 3, 13), 3);

    }

    @Test
    void checkZeroSum() {
        assertEquals(service.calculateThreeNumbersSum(13,13,13), 0);
    }

    /*как вариант

    @ParameterizedTest
    @CsvSource({"13,1,2","1,13,2","1,2,13","13,13,3","3,13,13","13,3,13"})
    void checkNumbersSum(int a, int b, int c) {
        assertEquals(service.calculateThreeNumbersSum(a,b,c), 3);
    }*/

}