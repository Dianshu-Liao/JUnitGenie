package org.apache.commons.collections4.properties;
import org.apache.commons.collections4.properties.OrderedProperties;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class properties_OrderedProperties_remove_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveKeyValue() {
        OrderedProperties properties = new OrderedProperties();
        properties.put("key1", "value1");
        
        // Ensure the key-value pair exists before removal
        assertTrue(properties.remove("key1", "value1"));
        
        // Verify that the key is removed
        assertTrue(properties.remove("key1", "value1") == false);
    }

}