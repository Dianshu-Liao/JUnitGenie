package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.TransformedMap;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class map_TransformedMap_transformValue_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTransformValueWithNullValueTransformer() throws Exception {
        // Arrange
        // Create a non-null map to avoid NullPointerException
        java.util.Map<Object, Object> baseMap = new java.util.HashMap<>();
        TransformedMap<Object, Object> transformedMap = new TransformedMap<>(baseMap, null, null);
        Method method = TransformedMap.class.getDeclaredMethod("transformValue", Object.class);
        method.setAccessible(true);
        
        // Act
        Object result = method.invoke(transformedMap, new Object());

        // Assert
        assertEquals(new Object(), result);
    }


}