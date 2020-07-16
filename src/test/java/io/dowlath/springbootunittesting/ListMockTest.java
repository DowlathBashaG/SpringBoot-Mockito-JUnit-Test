package io.dowlath.springbootunittesting;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dowlath
 * @create 7/15/2020 2:57 AM
 */

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());
    }
    @Test
    public void returnDifferentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }
    @Test
    // Defaults - numeric(0) , boolean(false) , Objects (null) , Collections(empty collection)
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(0));
        assertEquals(null,mock.get(1));
    }

    // Generic parameter
    @Test
    public void returnWithAnyParameters(){
        when(mock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(0));
        assertEquals("in28Minutes",mock.get(1));
    }

    @Test
    public void verificationBasics(){

        //SUT - System Under Test
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        //Verify
        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,never()).get(2);
    }

    @Test
    public void argumentCapturing(){
        // SUT
        mock.add("SomeString");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString",captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing(){
        // 3 times calling....so we need to give times(3)
        // SUT
        mock.add("SomeString1");
        mock.add("SomeString2");
        mock.add("SomeString3");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mock,times(3)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1",allValues.get(0));
        assertEquals("SomeString2",allValues.get(1));
        assertEquals("SomeString3",allValues.get(2));
    }

    @Test
    public void mocking(){
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size()); // 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); // 5

    }
    // you want to original dependency ...you can use spy , like real world example
    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0)); // Test0
        System.out.println(arrayListSpy.size()); // 1
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size()); // 3
        // original code was lost and would be return back override thenReturn method value
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5

        arrayListSpy.add("Test3");
        System.out.println(arrayListSpy.size()); // 5

        verify(arrayListSpy).add("Test3");
    }
}
