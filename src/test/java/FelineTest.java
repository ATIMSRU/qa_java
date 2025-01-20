package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FelineTest {

    private Feline feline;  // Тестируемый объект

    @Before
    public void setUp() throws Exception {
        // Используем реальный объект Feline, так как у него нет внешних зависимостей, требующих мокирования
        feline = new Feline();  // Создаем реальный объект Feline
    }

    @Test
    public void testGetKittens() {
        // Проверяем, что метод getKittens() возвращает 1 котенка
        assertEquals(1, feline.getKittens());  // Ожидаем, что метод вернет 1 котенка
    }

    @Test
    public void testGetKittensWithCustomCount() {
        // Проверяем, что метод getKittens(int) возвращает переданное количество котят
        int kittensCount = 5;
        assertEquals(kittensCount, feline.getKittens(kittensCount));  // Проверяем, что метод вернет 5 котят
    }

    @Test
    public void testEatMeatReturnsCorrectFood() throws Exception {
        // Мокаем метод getFood в Feline, так как он вызывается в eatMeat
        Feline mockFeline = mock(Feline.class);
        // Мокаем только метод getFood для возвращения нужного списка пищи
        doReturn(List.of("Животные", "Птицы", "Рыба")).when(mockFeline).getFood("Хищник");

        // Вызов метода eatMeat() с использованием замоканного объекта
        List<String> food = feline.eatMeat();  // Используем замоканный объект

        // Проверяем результат, который должен быть возвращен
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);  // Проверяем результат
    }

    @Test
    public void testEatMeatCallsGetFood() throws Exception {
        // Создаём частичный мок-объект Feline
        Feline spyFeline = spy(new Feline());

        // Вызов метода eatMeat(), который должен вызвать getFood
        spyFeline.eatMeat();

        // Проверяем, что метод getFood был вызван с аргументом "Хищник"
        verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        // Проверяем, что метод getFamily() возвращает "Кошачьи"
        assertEquals("Кошачьи", feline.getFamily());  // Ожидаем, что метод вернет "Кошачьи"
    }
}
