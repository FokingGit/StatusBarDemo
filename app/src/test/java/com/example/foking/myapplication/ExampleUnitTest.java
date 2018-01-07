package com.example.foking.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testArray() {
        int x = 2;
        int i = (x++) / 3;
        //先进行其他运算,再进行自增或者自减
        System.out.println(i);
    }

    @Test
    public void testSwitch() {
        int x = 4;
        int j = 0;
        switch (x) {
            case 1:
                j++;
            case 2:
                j++;
            case 3:
                j++;
            case 4:
                System.out.println("case 4");
                j++;
            case 5:
                System.out.println("case 5");
                j++;
            default:
                j++;
        }

        System.out.println(j);
    }

}