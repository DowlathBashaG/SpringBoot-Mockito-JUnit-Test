package io.dowlath.springbootunittesting.service;

import io.dowlath.springbootunittesting.data.SomeDataService;
import io.dowlath.springbootunittesting.model.Item;
import io.dowlath.springbootunittesting.repository.ItemRepository;
import io.dowlath.springbootunittesting.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @Author Dowlath
 * @create 7/14/2020 8:45 PM
 */


@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business;

    @Mock
    private ItemRepository repositoryMock;

    @Test
    public void calculateSumUsingDataService_basic(){
        when(repositoryMock.findAll()).thenReturn(
                 Arrays.asList(new Item(2,"Item2",10,10) ,
                               new Item(2,"Item3",20,20))
                 );
        List<Item> items = business.retrieveAllItems();
        assertEquals(100,items.get(0).getValue());
        assertEquals(400,items.get(1).getValue());
    }
}
