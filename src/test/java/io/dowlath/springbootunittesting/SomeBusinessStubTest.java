package io.dowlath.springbootunittesting;

import io.dowlath.springbootunittesting.SomeBusinessImpl;
import io.dowlath.springbootunittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author Dowlath
 * @create 7/14/2020 8:45 PM
 */

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}

class SomeDataServiceSingValueStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {5};
    }
}

public class SomeBusinessStubTest {
    @Test
    public void calculateSumUsingDataService_basic(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int result = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,result);
    }
    @Test
    public void calculateSumUsingDataService_Empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());
        int result = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult,result);
    }
    @Test
    public void calculateSumUsingDataService_oneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceSingValueStub());
        int result = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult,result);
    }
}
