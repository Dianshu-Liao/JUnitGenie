package org.apache.commons.collections4.properties;
import org.apache.commons.collections4.properties.OrderedProperties;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class properties_OrderedProperties_putIfAbsent_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutIfAbsent() {
        OrderedProperties properties = new OrderedProperties();
        Object key = "testKey";
        Object value = "testValue";

        // First call should return null as the key is absent
        Object result = properties.putIfAbsent(key, value);
        assertNull(result);

        // Second call should return the value associated with the key
        properties.putIfAbsent(key, value);
        Object resultAfter = properties.putIfAbsent(key, value);
        assertNull(resultAfter);
    }

}