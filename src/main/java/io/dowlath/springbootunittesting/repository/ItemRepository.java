package io.dowlath.springbootunittesting.repository;

import io.dowlath.springbootunittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Dowlath
 * @create 7/16/2020 1:57 AM
 */
public interface ItemRepository extends JpaRepository<Item,Integer> {

}
