package io.dowlath.springbootunittesting;

import io.dowlath.springbootunittesting.data.SomeDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author Dowlath
 * @create 7/14/2020 8:45 PM
 */


@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks  // if you use InjectMocks no need to use @Before, remove @Before block
    //SomeBusinessImpl business = new SomeBusinessImpl();
    SomeBusinessImpl business;

    @Mock
    //SomeDataService dataServiceMock = mock(SomeDataService.class);
    SomeDataService dataServiceMock;

    // if you use InjectMocks no need to use @Before, remove @Before block
    /*@Before
    public void before(){
        business.setSomeDataService(dataServiceMock);
    }*/

    @Test
    public void calculateSumUsingDataService_basic(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        assertEquals(6,business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_Empty(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0,business.calculateSumUsingDataService());
    }
    @Test
    public void calculateSumUsingDataService_oneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5,business.calculateSumUsingDataService());
    }
}
