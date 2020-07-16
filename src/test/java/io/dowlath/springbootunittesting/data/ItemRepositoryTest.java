package io.dowlath.springbootunittesting.data;

import io.dowlath.springbootunittesting.model.Item;
import io.dowlath.springbootunittesting.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

/**
 * @Author Dowlath
 * @create 7/16/2020 9:53 AM
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void testFindAll(){
        List<Item> items = repository.findAll();
        assertEquals(3,items.size());
    }
}
