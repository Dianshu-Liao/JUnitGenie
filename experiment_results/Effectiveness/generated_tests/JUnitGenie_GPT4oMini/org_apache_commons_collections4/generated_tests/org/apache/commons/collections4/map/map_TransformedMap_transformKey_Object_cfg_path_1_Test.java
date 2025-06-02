package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.TransformedMap;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class map_TransformedMap_transformKey_Object_cfg_path_1_Test {

    private static class TestTransformer implements Transformer<Object, Object> {
        @Override
        public Object transform(Object input) {
            return "Transformed: " + input;
        }
    }
    
    @Test(timeout = 4000)
    public void testTransformKeyWithTransformer() {
        // Create an instance of TransformedMap using reflection to access the protected constructor
        try {
            TransformedMap<Object, Object> transformedMap = 
                (TransformedMap<Object, Object>) TransformedMap.class.getDeclaredConstructor(
                    java.util.Map.class, Transformer.class, Transformer.class)
                    .newInstance(new java.util.HashMap<>(), new TestTransformer(), null);

            // Prepare the input for the transformKey method
            Object input = "TestKey";

            // Access the protected method transformKey via reflection
            Method method = TransformedMap.class.getDeclaredMethod("transformKey", Object.class);
            method.setAccessible(true);

            // Invoke the method and get the result
            Object result = method.invoke(transformedMap, input);

            // Assert the expected outcome
            assertEquals("Transformed: TestKey", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTransformKeyWithoutTransformer() {
        // Create an instance of TransformedMap where keyTransformer is null
        try {
            TransformedMap<Object, Object> transformedMap = 
                (TransformedMap<Object, Object>) TransformedMap.class.getDeclaredConstructor(
                    java.util.Map.class, Transformer.class, Transformer.class)
                    .newInstance(new java.util.HashMap<>(), null, null);

            // Prepare the input to be passed to transformKey
            Object input = "TestKey";
            
            // Access the protected method transformKey via reflection
            Method method = TransformedMap.class.getDeclaredMethod("transformKey", Object.class);
            method.setAccessible(true);
            
            // Invoke the method and get the result
            Object result = method.invoke(transformedMap, input);

            // Assert the expected outcome
            assertEquals("TestKey", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}