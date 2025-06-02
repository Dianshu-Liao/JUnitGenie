package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.SingletonMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_SingletonMap_toString__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToString() {
        // Create a SingletonMap instance with a key and a value
        SingletonMap<String, String> singletonMap = new SingletonMap<>("key", "value");

        // Expected output when calling toString
        String expectedOutput = "{key=value}";

        // Call the toString method and verify the output
        String actualOutput = singletonMap.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testToStringWithSelfReferenceKey() {
        // Create a SingletonMap instance where the key is the map itself
        SingletonMap<String, String> singletonMap = new SingletonMap<>("key", "value");
        SingletonMap<SingletonMap<String, String>, String> selfReferencingMap = new SingletonMap<>(singletonMap, "value");

        // Expected output when calling toString
        String expectedOutput = "{key=value}";

        // Call the toString method and verify the output
        String actualOutput = selfReferencingMap.toString();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testToStringWithSelfReferenceValue() {
        // Create a SingletonMap instance where the value is the map itself
        SingletonMap<String, String> singletonMap = new SingletonMap<>("key", "value");
        SingletonMap<String, SingletonMap<String, String>> selfReferencingMap = new SingletonMap<>("key", singletonMap);

        // Expected output when calling toString
        String expectedOutput = "{key=value}";

        // Call the toString method and verify the output
        String actualOutput = selfReferencingMap.toString();
        assertEquals(expectedOutput, actualOutput);
    }


}