package com.example.lionAlex;

import com.example.Feline;
import com.example.LionAlex;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.*;

public class LionAlexTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Feline feline;
    LionAlex lionAlex;

    @Before
    public void setUp() throws Exception {
        lionAlex = new LionAlex(feline);
    }

    @Test
    public void getFriends() {
        assertEquals(List.of("Марти", "Глория", "Мелман"),lionAlex.getFriends());
    }

    @Test
    public void getPlaceOfLiving() {
        assertEquals("Нью-Йоркский зоопарк",lionAlex.getPlaceOfLiving());
    }

    @Test
    public void getKittens() {
        assertEquals(0,lionAlex.getKittens());
    }
}