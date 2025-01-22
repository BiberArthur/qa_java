package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


public class FelineParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 5})
    public void testGetKittensWithParameter(int expectedKittens) {
        Feline feline = new Feline();
        assertEquals(expectedKittens, feline.getKittens(expectedKittens));
    }
}
