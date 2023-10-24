package seminars.third.length;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LengthTest {
    @Test
    void getCycleLength (){
        // Подготовка
        Lengther lengther = new Lengther();

        // Вызов метода
        double result = lengther.getLength(10);

        // Проверка утверждения
        assertThat(result).isEqualTo(62.83185307179586, offset(0.0001));
    }
}
