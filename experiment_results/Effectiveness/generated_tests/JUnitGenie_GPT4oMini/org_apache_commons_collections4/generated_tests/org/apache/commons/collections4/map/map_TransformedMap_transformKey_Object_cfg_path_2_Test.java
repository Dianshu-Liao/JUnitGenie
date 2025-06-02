package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.TransformedMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class map_TransformedMap_transformKey_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTransformKeyWithKeyTransformer() {
        // Create a Transformer that modifies the key
        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return input.toString() + "_transformed";
            }
        };

        // Create a map and a TransformedMap with the transformer
        Map<Object, Object> map = new HashMap<>();
        TransformedMap<Object, Object> transformedMap = new TransformedMap<>(map, transformer, transformer);

        // Use reflection to access the protected method
        try {
            Method method = TransformedMap.class.getDeclaredMethod("transformKey", Object.class);
            method.setAccessible(true);

            // Test the transformKey method
            Object inputKey = "key";
            Object expectedOutput = "key_transformed";
            Object actualOutput = method.invoke(transformedMap, inputKey);

            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTransformKeyWithNullTransformer() {
        // Create a TransformedMap with a null transformer
        Map<Object, Object> map = new HashMap<>();
        TransformedMap<Object, Object> transformedMap = new TransformedMap<>(map, null, null);

        // Use reflection to access the protected method
        try {
            Method method = TransformedMap.class.getDeclaredMethod("transformKey", Object.class);
            method.setAccessible(true);

            // Test the transformKey method
            Object inputKey = "key";
            Object actualOutput = method.invoke(transformedMap, inputKey);

            // Since the transformer is null, the output should be the same as the input
            assertEquals(inputKey, actualOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}