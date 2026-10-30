import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Отчеты Allure")
@Feature("Проверка калькулятора")
public class AllureTests {

        @Test
        @Story("Сложение двух чисел")
        @DisplayName("Проверка сложения")
        @Description("Проверяем, что калькулятор правильно складывает числа")
        void additionTest() {

            int result = addNumbers(5, 3);

            attachLog(5,3,result);
            assertEquals(8, result);
        }

    @Test
    @Story("Умножение двух чисел")
    @DisplayName("Проверка умножения")
    @Description("Проверяем, что калькулятор правильно умножает числа")
    void multipliTest() {

        int result = multipliNumbers(2, 3);

        attachLog(2,3,result);
        assertEquals(6, result);
    }

    @Step("Умножение числа {first} и {second}")
    int multipliNumbers(int first, int second) {
        return first * second;
    }

        @Step("Складываем числа {first} и {second}")
        int addNumbers(int first, int second) {
            return first + second;
        }

        @Test
        @Story("Проверка отрицательного сценария")
        @DisplayName("Проверка неправильного результата")
        void failedTest() {

            int result = addNumbers(5, 3);

            assertEquals(10, result);
        }


    @Attachment(
            value = "Лог вычисления",
            type = "text/plain",
            fileExtension = ".txt"
    )
    public String attachLog(int first, int second, int result) {
        return "Первое число: " + first +
                "\nВторое число: " + second +
                "\nРезультат сложения: " + result;
    }
}

