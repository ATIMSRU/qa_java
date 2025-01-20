package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;  // Пол для параметризированного теста
    private final boolean expectedHasMane;  // Ожидаемый результат для гривы
    private Feline mockFeline;  // Мок для класса Feline
    private Lion lion;  // Тестируемый объект

    // Конструктор для параметризированного теста
    public LionParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        // Параметры для теста: Пол льва и ожидание наличия гривы
        return Arrays.asList(new Object[][]{
                {"Самец", true},   // Для самца ожидаем, что грива есть
                {"Самка", false}   // Для самки ожидаем, что гривы нет
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

}
