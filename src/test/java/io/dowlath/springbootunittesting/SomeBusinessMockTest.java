package io.dowlath.springbootunittesting;

import io.dowlath.springbootunittesting.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author Dowlath
 * @create 7/14/2020 8:45 PM
 */


public class SomeBusinessMockTest {

    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @Before
    public void before(){
        business.setSomeDataService(dataServiceMock);
    }

    @Test
    public void calculateSumUsingDataService_basic(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
       // business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateSumUsingDataService_Empty(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
       // business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void calculateSumUsingDataService_oneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
       // business.setSomeDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult,actualResult);
    }
}
