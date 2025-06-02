package org.apache.commons.collections4.properties;
import org.apache.commons.collections4.properties.OrderedProperties;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class properties_OrderedProperties_put_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutMethod() {
        OrderedProperties orderedProperties = new OrderedProperties();
        Object key = "testKey";
        Object value = "testValue";

        // Call the put method
        Object result = null;
        try {
            result = orderedProperties.put(key, value);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Verify that the result is not null
        assertNotNull(result);
    }

}