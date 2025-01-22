package com.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LionTest {

    @Test
    public void testLionMane() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", felineMock);
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        assertEquals(1, felineMock.getKittens());
    }

    @Test
    public void testLionWithFemaleSex() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testLionInvalidSex() {
        Feline felineMock = Mockito.mock(Feline.class);
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", felineMock);
        });

        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}

