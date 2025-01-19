package com.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

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

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodPredator() throws Exception {
        // Проверяем, что метод getFood возвращает правильный список для "Хищник"
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = animal.getFood("Хищник");

        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testGetFoodUnknown() throws Exception {
        // Проверяем, что метод getFood выбрасывает исключение для неизвестного вида животного
        animal.getFood("Некорректный вид");
    }

    @Test
    public void testGetFamily() {
        // Проверяем, что метод getFamily возвращает правильную строку
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();

        assertEquals(expectedFamily, actualFamily);
    }
}
