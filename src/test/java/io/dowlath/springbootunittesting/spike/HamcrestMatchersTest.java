package io.dowlath.springbootunittesting.spike;

import org.assertj.core.internal.Integers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @Author Dowlath
 * @create 7/16/2020 12:31 PM
 */
public class HamcrestMatchersTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12,15,45);

        // Hamcrest
        assertThat(numbers , hasSize(3));
        assertThat(numbers , hasItems(12,45));
        assertThat(numbers , everyItem(greaterThan(10)));
        assertThat(numbers , everyItem(lessThan(50)));

        assertThat("",isEmptyString());
        assertThat("ABCDE",containsString("BCD"));
        assertThat("ABCDE",startsWith("ABC"));
        assertThat("ABCDE",endsWith("DE"));

    }

}
