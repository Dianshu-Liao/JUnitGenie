package org.apache.commons.collections4.splitmap;
import org.apache.commons.collections4.splitmap.TransformedSplitMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class splitmap_TransformedSplitMap_transformMap_Map_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testTransformMap() {
        try {
            // Create an instance of TransformedSplitMap using reflection
            Map<String, Integer> inputMap = new HashMap<>();
            inputMap.put("one", 1);
            inputMap.put("two", 2);
            TransformedSplitMap transformedSplitMap = new TransformedSplitMap(inputMap, 
                obj -> obj.toString(), // transformKey
                obj -> (Integer) obj * 2 // transformValue
            );

            // Access the protected method transformMap using reflection
            Method method = TransformedSplitMap.class.getDeclaredMethod("transformMap", Map.class);
            method.setAccessible(true);

            // Invoke the method
            Map<String, Integer> result = (Map<String, Integer>) method.invoke(transformedSplitMap, inputMap);

            // Expected result
            Map<String, Integer> expectedResult = new HashMap<>();
            expectedResult.put("one", 2);
            expectedResult.put("two", 4);

            // Assert the result
            assertEquals(expectedResult, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}