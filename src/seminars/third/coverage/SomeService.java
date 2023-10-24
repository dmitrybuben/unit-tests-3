package seminars.third.coverage;

public class SomeService {

    /*Создайте набор тестов, полностью покрывающих все ветви кода функции fizzBuzz.
    Эта функция принимает на вход число и возвращает "Fizz", если число делится на 3, "Buzz",
    если число делится на 5, и "FizzBuzz", если число делится на 15.
    Если число не делится ни на 3, ни на 5, ни на 15, функция возвращает входное число в виде строки.*/

    /**
     * 3.1. Метод возвращает Fizz для чисел кратных 3, Buzz для кратных 5, и FizzBuzz для кратных 3 и 5 одновременно
     */
    public String fizzBuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) return "FizzBuzz";
        else if (i % 3 == 0) return "Fizz";
        else if (i % 5 == 0) return "Buzz";
        else return "i";
    }
    /*Разработайте тесты для метода firstLast6, где на вход подается массив чисел,
    а метод возвращает true, если первое или последнее число в массиве равно 6, иначе false.*/
        /**
         * 3.2. Метод возвращает true для массивов, которые начинаются или заканчиваются 6,
         * и false - если 6 нет ни в начале ни в конце массива
         */
    public boolean firstLast6(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        return nums[0] == 6 || nums[nums.length-1] == 6;
    }

    /**
     * 3.3. Метод подсчета скидки
     */
    public double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("Purchase amount can't be less than 0");
        }
        if (discountAmount < 0) {
            throw new IllegalArgumentException("Discount amount can't be less than 0");
        }
        if (discountAmount > 100) {
            throw new IllegalArgumentException("Discount amount can't be more than 100");
        }
        else return purchaseAmount - purchaseAmount * (double) discountAmount /100;
    }

    /**
     * 3.4. Метод принимает на вход 3 числа (int a, b, c). Нужно вернуть их сумму. Однако, если одно из значений равно 13,
     * то оно не учитывается в сумме. Так, например, если b равно 13, то считается сумма только a и c.
     */

    public int calculateThreeNumbersSum(int a, int b, int c) {
        int result = 0;
        if (a != 13) result += a;
        if (b != 13) result += b;
        if (c != 13) result += c;
        return result;
    }
}