package com.example.cat;

import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CatTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Predator predator;
    @Mock
    Feline feline;
    Cat cat;

    @Before
    public void setUp() throws Exception {
        this.cat = new Cat(feline);
    }


    @Test
    public void getSoundShouldTrue() {
        assertEquals("Мяу",cat.getSound());
    }

    @Test
    public void getFoodShouldReturnList() throws Exception {
        when(predator.eatMeat()).thenReturn(List.of());
       Assert.assertEquals(List.of(),cat.getFood());
    }
}