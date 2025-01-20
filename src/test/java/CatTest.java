package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        // Используем реальный объект Feline
        feline = new Feline();
        // Передаем его в конструктор Cat
        cat = new Cat(feline);
    }

    @Test
    public void testGetSound() {
        // Проверяем, что метод getSound у Cat возвращает правильный звук
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        // Проверяем, что метод getFood у Cat возвращает правильный список пищи
        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithException() throws Exception {
        // Проверяем, что метод getFood выбрасывает исключение для некорректного вида
        feline.getFood("Некорректный вид");
    }
}
