package org.apache.commons.collections4.properties;
import org.apache.commons.collections4.properties.OrderedProperties;
import org.junit.Test;
import static org.junit.Assert.*;

public class properties_OrderedProperties_put_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutMethod() {
        OrderedProperties orderedProperties = new OrderedProperties();
        
        // Test case where put returns null (new key)
        Object key = "newKey";
        Object value = "newValue";
        Object result = orderedProperties.put(key, value);
        assertNull(result); // Since it's a new key, put should return null
        
        // Instead of accessing orderedKeys directly, we can use the size method to check if the key was added
        assertEquals(1, orderedProperties.size()); // Check if the size increased
        
        // Test case where put returns a value (existing key)
        Object existingKey = "existingKey";
        Object existingValue = "existingValue";
        orderedProperties.put(existingKey, existingValue); // Add existing key-value pair
        Object result2 = orderedProperties.put(existingKey, "updatedValue");
        assertNotNull(result2); // Since the key already exists, put should return the old value
        assertEquals(existingValue, result2); // Check if the returned value is the old value
    }


}