package org.apache.commons.collections4.properties;
import org.apache.commons.collections4.properties.OrderedProperties;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class properties_OrderedProperties_remove_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveKeyValueExists() {
        OrderedProperties properties = new OrderedProperties();
        properties.put("key1", "value1");
        properties.put("key2", "value2");

        // Test removing an existing key-value pair
        boolean result = properties.remove("key1", "value1");
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testRemoveKeyValueDoesNotExist() {
        OrderedProperties properties = new OrderedProperties();
        properties.put("key1", "value1");

        // Test removing a non-existing key-value pair
        boolean result = properties.remove("key1", "value2");
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testRemoveKeyValueWithNoKey() {
        OrderedProperties properties = new OrderedProperties();

        // Test removing a key-value pair when no keys exist
        boolean result = properties.remove("key1", "value1");
        assertFalse(result);
    }

}