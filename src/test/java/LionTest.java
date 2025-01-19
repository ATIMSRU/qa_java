package com.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LionTest {

    private Feline mockFeline;  // Мок для класса Feline
    private Lion lion;  // Тестируемый объект

    @Before
    public void setUp() throws Exception {
        // Создаем мок для Feline
        mockFeline = mock(Feline.class);

        // Создаем объект Lion, инжектируем мок
        lion = new Lion("Самец", mockFeline);
    }

    @Test
    public void testGetKittens() {
        // Ожидаем, что метод getKittens() у Feline вернет 3
        when(mockFeline.getKittens()).thenReturn(3);

        // Проверяем, что метод getKittens() у Lion возвращает правильное количество котят
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testDoesHaveMane() {
        // Проверяем, что у самца есть грива
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        // Ожидаем, что метод getFood() у Feline вернет список хищников
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Проверяем, что метод getFood() у Lion работает корректно
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        // Проверяем, что при передаче некорректного пола выбрасывается исключение
        new Lion("Некорректный пол", mockFeline);
    }
}
