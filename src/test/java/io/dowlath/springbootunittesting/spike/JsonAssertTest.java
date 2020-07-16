package io.dowlath.springbootunittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * @Author Dowlath
 * @create 7/15/2020 9:08 PM
 */
public class JsonAssertTest {

    String actualResponse  = " {\"id\": 1,\n" +
            "  \"name\": \"Ball\",\n" +
            "  \"price\": 10,\n" +
            "  \"quantity\": 100\n" +
            "}";

    @Test
    public void jsonAssert() throws JSONException {
     String expectedResponse = "{\"id\": 1,\n" +
             "  \"name\": \"Ball\",\n" +
             "  \"price\": 10,\n" +
             "  \"quantity\": 100\n" +
             "}";
       // Strict true exact matches
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
      // Strict false even parameters are not matching it will execute and return values
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }
}
