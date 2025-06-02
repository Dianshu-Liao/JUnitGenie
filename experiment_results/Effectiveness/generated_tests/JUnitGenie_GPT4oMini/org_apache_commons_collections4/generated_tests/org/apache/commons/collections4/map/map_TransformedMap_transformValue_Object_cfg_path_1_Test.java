package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.TransformedMap;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

public class map_TransformedMap_transformValue_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testTransformValue_withValidObject() {
        // Create a Transformer that modifies the input object
        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return input.toString() + "_transformed";
            }
        };

        // Create an instance of TransformedMap using reflection
        TransformedMap<Object, Object> transformedMap = null;
        try {
            Class<?> clazz = TransformedMap.class;
            Method constructor = clazz.getDeclaredMethod("transformedMap", java.util.Map.class, Transformer.class, Transformer.class);
            constructor.setAccessible(true);
            transformedMap = (TransformedMap<Object, Object>) constructor.invoke(null, new HashMap<>(), transformer, transformer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Access the protected method transformValue using reflection
        try {
            Method method = TransformedMap.class.getDeclaredMethod("transformValue", Object.class);
            method.setAccessible(true);
            Object result = method.invoke(transformedMap, "testObject");
            assertEquals("testObject_transformed", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testTransformValue_withNullObject() {
        // Create a Transformer that modifies the input object
        Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
            @Override
            public Object transform(Object input) {
                return input != null ? input.toString() + "_transformed" : null;
            }
        };

        // Create an instance of TransformedMap using reflection
        TransformedMap<Object, Object> transformedMap = null;
        try {
            Class<?> clazz = TransformedMap.class;
            Method constructor = clazz.getDeclaredMethod("transformedMap", java.util.Map.class, Transformer.class, Transformer.class);
            constructor.setAccessible(true);
            transformedMap = (TransformedMap<Object, Object>) constructor.invoke(null, new HashMap<>(), transformer, transformer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Access the protected method transformValue using reflection
        try {
            Method method = TransformedMap.class.getDeclaredMethod("transformValue", Object.class);
            method.setAccessible(true);
            Object result = method.invoke(transformedMap, null);
            assertEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}