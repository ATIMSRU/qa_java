package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    private Animal animal;  // Тестируемый объект

    @Before
    public void setUp() {
        // Создаем объект Animal
        animal = new Animal();
    }

    @Test
    public void testGetFoodHerbivore() throws Exception {
        // Проверяем, что метод getFood возвращает правильный список для "Травоядное"
        List<String> expectedFood = List.of("Трава", "Различные растения");
        List<String> actualFood = animal.getFood("Травоядное");

        // Добавлено поясняющее сообщение
        assertEquals("Список пищи для травоядного некорректен", expectedFood, actualFood);
    }

    @Test
    public void testGetFoodPredator() throws Exception {
        // Проверяем, что метод getFood возвращает правильный список для "Хищник"
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = animal.getFood("Хищник");

        // Добавлено поясняющее сообщение
        assertEquals("Список пищи для хищника некорректен", expectedFood, actualFood);
    }

    @Test
    public void testGetFoodUnknown() {
        // Проверяем, что метод getFood выбрасывает исключение для неизвестного вида животного
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Некорректный вид");
        });
        // Проверяем, что сообщение об ошибке соответствует ожидаемому
        String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void testGetFamily() {
        // Проверяем, что метод getFamily возвращает правильную строку
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();

        // Добавлено поясняющее сообщение
        assertEquals("Семейства животных некорректны", expectedFamily, actualFamily);
    }
}
