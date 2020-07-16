package io.dowlath.springbootunittesting.service;

import io.dowlath.springbootunittesting.model.Item;
import io.dowlath.springbootunittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Dowlath
 * @create 7/15/2020 9:23 PM
 */
@Component
public class ItemBusinessService {
    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardCodedItem() {
        return new Item(1,"Ball",10,100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> items = itemRepository.findAll();
        for(Item item : items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}
