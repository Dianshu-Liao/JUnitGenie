package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.TransformedMap;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class map_TransformedMap_isSetValueChecking__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsSetValueCheckingWhenValueTransformerIsNull() {
        // Create an instance of TransformedMap using reflection
        TransformedMap<Object, Object> transformedMap = null;
        try {
            Class<?> clazz = TransformedMap.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor(java.util.Map.class, Transformer.class, Transformer.class);
            constructor.setAccessible(true);
            transformedMap = (TransformedMap<Object, Object>) constructor.newInstance(new java.util.HashMap<>(), null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Access the protected method isSetValueChecking using reflection
        try {
            Method method = TransformedMap.class.getDeclaredMethod("isSetValueChecking");
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(transformedMap);
            assertFalse(result); // Expecting false since valueTransformer is null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}