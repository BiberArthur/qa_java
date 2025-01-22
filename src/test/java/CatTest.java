package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

import java.util.List;

public class CatTest {

    @Test
    public void testGetSound() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound(), "Кошка должна издавать звук 'Мяу' а не что либо другое");
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(felineMock);
        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food); // поправил, почему-то твои комментарии безвозвратно удаляются(
    }
}
