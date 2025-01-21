package com.example;

import java.util.List;

public class Lion {

    private final Feline feline;
    private final boolean hasMane;

    // Конструктор с инъекцией зависимости для Feline
    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            this.hasMane = true;
        } else if ("Самка".equals(sex)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
        this.feline = feline;
    }

    // Получить количество детенышей
    public int getKittens() {
        return feline.getKittens();
    }

    // Узнать, есть ли грива
    public boolean doesHaveMane() {
        return hasMane;
    }

    // Получить список пищи
    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}