package org.apache.commons.collections4.properties;
import org.apache.commons.collections4.properties.OrderedProperties;
import org.junit.Test;
import static org.junit.Assert.*;

public class properties_OrderedProperties_putIfAbsent_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutIfAbsent() {
        OrderedProperties properties = new OrderedProperties();
        Object key = "testKey";
        Object value = "testValue";

        // First call should add the key and return null
        Object result = properties.putIfAbsent(key, value);
        assertNull(result);

        // Verify that the key was added using the get method
        assertNotNull(properties.get(key));

        // Second call with the same key should return the existing value
        Object existingValue = properties.putIfAbsent(key, "newValue");
        assertEquals(value, existingValue); // The value should be the same as the first call
    }


}