package com.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class LionParamTest {

    private Feline mockFeline;  // Мок для класса Feline
    private Lion lion;  // Тестируемый объект
    private String sex;  // Пол для параметризированного теста
    private boolean expectedHasMane;  // Ожидаемый результат для гривы

    // Конструктор для параметризированного теста
    public LionParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        // Параметры для теста: Пол льва и ожидание наличия гривы
        return Arrays.asList(new Object[][] {
                { "Самец", true },   // Для самца ожидаем, что грива есть
                { "Самка", false }   // Для самки ожидаем, что гривы нет
        });
    }

    @Before
    public void setUp() throws Exception {
        // Создаем мок для Feline
        mockFeline = mock(Feline.class);

        // Создаем объект Lion с параметризованным полом
        lion = new Lion(sex, mockFeline);
    }

    @Test
    public void testDoesHaveMane() {
        // Проверяем, что наличие гривы соответствует ожидаемому результату
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        // Ожидаем, что метод getFood() у Feline вернет список хищников
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // Проверяем, что метод getFood() у Lion работает корректно
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
