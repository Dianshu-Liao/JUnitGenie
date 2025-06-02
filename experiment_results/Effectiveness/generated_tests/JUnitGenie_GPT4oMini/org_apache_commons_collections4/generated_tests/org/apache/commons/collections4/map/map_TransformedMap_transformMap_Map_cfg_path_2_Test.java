package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.TransformedMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class map_TransformedMap_transformMap_Map_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTransformMapWithNonEmptyMap() {
        // Create a sample map to test
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("one", 1);
        inputMap.put("two", 2);

        // Create an instance of TransformedMap using reflection
        TransformedMap<String, Integer> transformedMap = new TransformedMap<>(inputMap, 
            key -> key.toUpperCase(), 
            value -> value * 2);

        try {
            // Access the protected method transformMap using reflection
            Method method = TransformedMap.class.getDeclaredMethod("transformMap", Map.class);
            method.setAccessible(true);
            Map<String, Integer> result = (Map<String, Integer>) method.invoke(transformedMap, inputMap);

            // Verify the result
            assertEquals(2, (int) result.get("ONE"));
            assertEquals(4, (int) result.get("TWO"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTransformMapWithEmptyMap() {
        // Create an empty map to test
        Map<String, Integer> inputMap = new HashMap<>();

        // Create an instance of TransformedMap using reflection
        TransformedMap<String, Integer> transformedMap = new TransformedMap<>(inputMap, 
            key -> key.toUpperCase(), 
            value -> value * 2);

        try {
            // Access the protected method transformMap using reflection
            Method method = TransformedMap.class.getDeclaredMethod("transformMap", Map.class);
            method.setAccessible(true);
            Map<String, Integer> result = (Map<String, Integer>) method.invoke(transformedMap, inputMap);

            // Verify that the result is the same as the input for an empty map
            assertEquals(inputMap, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}