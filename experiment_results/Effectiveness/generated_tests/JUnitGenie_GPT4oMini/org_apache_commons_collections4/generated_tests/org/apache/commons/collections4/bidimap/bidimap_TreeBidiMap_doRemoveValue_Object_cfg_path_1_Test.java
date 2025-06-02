package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class bidimap_TreeBidiMap_doRemoveValue_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDoRemoveValueReturnsNullWhenNodeIsNull() {
        try {
            // Arrange
            TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();
            String valueToRemove = "nonExistentValue"; // Value that does not exist in the map

            // Access the private method using reflection
            Method method = TreeBidiMap.class.getDeclaredMethod("doRemoveValue", Object.class);
            method.setAccessible(true);

            // Act
            Object result = method.invoke(bidiMap, valueToRemove);

            // Assert
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}