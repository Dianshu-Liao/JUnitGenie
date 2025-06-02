package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.SingletonMap;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class map_SingletonMap_get_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetWithNonEqualKey() {
        // Arrange
        Object key = new Object(); // This key should not equal the key in the SingletonMap
        Object value = new Object();
        SingletonMap<Object, Object> singletonMap = new SingletonMap<>(key, value);

        // Act
        Object result = singletonMap.get(new Object()); // Pass a different key

        // Assert
        try {
            assertNull(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}