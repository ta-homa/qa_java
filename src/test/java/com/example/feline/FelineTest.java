package com.example.feline;

import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Animal animal;

    Feline feline = new Feline();

    @Test
    public void eatMeatShouldReturnTrue() throws Exception {
        Mockito.when(animal.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),feline.eatMeat());
    }

    @Test
    public void getFamilyShouldFelineTrue() {
        String actuial = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected,actuial);
    }

    @Test
    public void getKittensShouldOne() {
        assertEquals(1,feline.getKittens());
    }

    @Test
    public  void getKittensShouldSeveral(){
        int[] kittensCount =  new int[] {1,2,3};
        int actual;
        for (int i=0;i<kittensCount.length;i++){
            actual = feline.getKittens(kittensCount[i]);
            assertEquals(kittensCount[i],actual);
        }
    }

}