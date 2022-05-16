package com.example.lion;


import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class LionExeptionTest {
    private final String sex;

    public LionExeptionTest(String sex){
        this.sex = sex;
    }
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Feline feline;
    Lion lion;

    @Parameterized.Parameters
    public static Object[] illegalSex() {
        return new Object[]{
                "",
                "sdg",
                "142",
        };
    }

    @Test(expected = Exception.class)
    public void lionShouldReturnException() throws Exception{
        this.lion = new Lion(sex,feline);
    }


}
