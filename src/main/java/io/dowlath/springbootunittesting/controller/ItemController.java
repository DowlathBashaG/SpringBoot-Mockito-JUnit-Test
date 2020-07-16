package io.dowlath.springbootunittesting.controller;

import io.dowlath.springbootunittesting.model.Item;
import io.dowlath.springbootunittesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Dowlath
 * @create 7/15/2020 7:35 PM
 */
@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1,"Ball",10,100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return businessService.retrieveHardCodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> itemAllItems(){
        return businessService.retrieveAllItems();
    }

}
