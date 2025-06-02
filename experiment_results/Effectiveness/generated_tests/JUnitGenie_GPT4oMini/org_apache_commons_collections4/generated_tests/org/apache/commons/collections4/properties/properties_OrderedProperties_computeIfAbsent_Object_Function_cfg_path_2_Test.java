package org.apache.commons.collections4.properties;
import org.apache.commons.collections4.properties.OrderedProperties;
import org.junit.Test;
import java.util.function.Function;
import static org.junit.Assert.assertNotNull;

public class properties_OrderedProperties_computeIfAbsent_Object_Function_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testComputeIfAbsent() {
        OrderedProperties orderedProperties = new OrderedProperties();
        Object key = "testKey";
        Function<Object, Object> mappingFunction = (k) -> "testValue";

        // Call the focal method
        Object result = null;
        try {
            result = orderedProperties.computeIfAbsent(key, mappingFunction);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Verify the result is not null
        assertNotNull(result);
    }

}