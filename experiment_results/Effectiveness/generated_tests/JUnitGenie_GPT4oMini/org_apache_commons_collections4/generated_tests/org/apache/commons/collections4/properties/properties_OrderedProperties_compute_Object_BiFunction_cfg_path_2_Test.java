package org.apache.commons.collections4.properties;
import org.apache.commons.collections4.properties.OrderedProperties;
import org.junit.Test;
import java.util.function.BiFunction;
import static org.junit.Assert.assertNotNull;

public class properties_OrderedProperties_compute_Object_BiFunction_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testComputeWithNonNullResult() {
        OrderedProperties orderedProperties = new OrderedProperties();
        Object key = new Object();
        BiFunction<Object, Object, Object> remappingFunction = (oldValue, newValue) -> newValue;

        try {
            Object result = orderedProperties.compute(key, remappingFunction);
            assertNotNull("The compute method should return a non-null result", result);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}