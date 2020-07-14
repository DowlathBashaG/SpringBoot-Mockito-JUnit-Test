package io.dowlath.springbootunittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author Dowlath
 * @create 7/14/2020 8:45 PM
 */
public class SomeBusinessTest {
    @Test
    public void calculateSum_Basic(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult,result);
    }
    @Test
    public void calculateSum_Empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult,result);
    }
}
