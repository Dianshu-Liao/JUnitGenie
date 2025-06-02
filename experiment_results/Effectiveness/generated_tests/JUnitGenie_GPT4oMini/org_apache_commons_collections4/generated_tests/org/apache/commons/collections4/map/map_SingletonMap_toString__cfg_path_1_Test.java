package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.SingletonMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_SingletonMap_toString__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToString() {
        // Create a SingletonMap with a key and a value that are not equal to the instance itself
        SingletonMap<String, String> singletonMap = new SingletonMap<>("key", "value");

        // Expected output when toString() is called
        String expectedOutput = "{key=value}";

        // Call the toString method and verify the output
        String actualOutput = null;
        try {
            actualOutput = singletonMap.toString();
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        assertEquals(expectedOutput, actualOutput);
    }

}