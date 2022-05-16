package com.example.lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Feline feline;
    Lion lion;

    @Before
    public void setUp() throws Exception {
        this.lion = new Lion(sex,feline);
    }

    @Parameterized.Parameters
    public static Object[][] sexLion() {
        return new Object[][]{
                {"Самец",true},
                {"Самка",false}
        };
    }

    @Test
    public void getKittensShouldOne() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1,lion.getKittens());
    }

    @Test
    public void doesHaveManeShouldReturnTrue() {
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(hasMane,actual);
    }

    @Test
    public void getFoodShouldReturn() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(feline.getFood("Хищник"),lion.getFood());

    }
}