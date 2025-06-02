package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.SingletonMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_SingletonMap_toString__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToString_KeyIsNotThis() {
        SingletonMap singletonMap = new SingletonMap("key", "value");
        try {
            String result = singletonMap.toString();
            assertEquals("{key=value}", result); // Expected format
        } catch (Exception e) {
            // Handle the unexpected exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToString_ValueIsNotThis() {
        SingletonMap singletonMap = new SingletonMap(new Object(), "value");
        try {
            String result = singletonMap.toString();
            // Test with a non-equal value reference
            assertEquals("{(this Map)=value}", result); // Expected format with this reference
        } catch (Exception e) {
            // Handle the unexpected exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToString_KeyValueAreThis() {
        // Create a SingletonMap with a key and value that are both the same object
        Object keyValue = new Object();
        SingletonMap singletonMap = new SingletonMap(keyValue, keyValue);
        try {
            String result = singletonMap.toString();
            assertEquals("{(this Map)=(this Map)}", result); // Expect both to refer to 'this'
        } catch (Exception e) {
            // Handle the unexpected exception
            e.printStackTrace();
        }
    }


}