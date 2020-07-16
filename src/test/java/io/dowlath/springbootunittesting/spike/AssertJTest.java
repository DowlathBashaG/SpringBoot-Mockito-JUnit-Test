package io.dowlath.springbootunittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @Author Dowlath
 * @create 7/16/2020 12:31 PM
 */

/*
    Less static codes and chaning is allowed here. But Hamcrest is not like that.
 */

public class AssertJTest {

    @Test
    public void learning(){

        List<Integer> numbers = Arrays.asList(12,15,45);

        // AssertJ
        assertThat(numbers).hasSize(3)
                           .contains(12,15,45)
                           .allMatch(x -> x > 10)  // everyItem greater than
                           .allMatch(x -> x < 50)  // everyItem less than
                           .noneMatch(x -> x <0) ; // none of matching

        assertThat("").isEmpty();

        assertThat("ABCDE").contains("BCD")
                                 .startsWith("ABC")
                                 .endsWith("DE");

    }

}
