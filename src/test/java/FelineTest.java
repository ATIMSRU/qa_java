package com.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    private Feline feline;  // Тестируемый объект

    @Before
    public void setUp() throws Exception {
        // Создаем шпионский объект Feline, чтобы использовать его методы вместе с моком
        feline = spy(new Feline());  // Создаем шпиона для реального объекта Feline
    }

    @Test
    public void testGetKittens() {
        // Проверяем, что метод getKittens() возвращает 1 котенка без мокирования
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCustomCount() {
        // Проверяем, что метод getKittens(int) возвращает переданное количество котят
        int kittensCount = 5;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

    @Test
    public void testEatMeat() throws Exception {
        // Создаем мок для метода getFood, чтобы контролировать его поведение
        doReturn(List.of("Животные", "Птицы", "Рыба")).when(feline).getFood("Хищник");

        // Проверяем, что метод eatMeat() возвращает правильный список пищи
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);

        // Проверяем, что getFood("Хищник") был вызван
        verify(feline).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        // Проверяем, что метод getFamily() возвращает "Кошачьи"
        assertEquals("Кошачьи", feline.getFamily());
    }
}
