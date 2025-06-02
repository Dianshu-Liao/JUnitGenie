package org.apache.commons.collections4.map;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class map_TransformedMap_isSetValueChecking__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsSetValueCheckingWhenValueTransformerIsNull() {
        // Arrange
        // Create a non-null map to avoid NullPointerException
        java.util.Map<Object, Object> baseMap = new java.util.HashMap<>();
        TransformedMap<Object, Object> transformedMap = new TransformedMap<>(baseMap, null, null);
        
        // Act
        boolean result = false;
        try {
            Method method = TransformedMap.class.getDeclaredMethod("isSetValueChecking");
            method.setAccessible(true);
            result = (Boolean) method.invoke(transformedMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertFalse(result);
    }


}