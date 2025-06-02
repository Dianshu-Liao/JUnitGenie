package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.SingletonMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_SingletonMap_get_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetReturnsValueWhenKeyIsEqual() {
        // Arrange
        String key = "testKey";
        String value = "testValue";
        SingletonMap<String, String> singletonMap = new SingletonMap<>(key, value);
        
        // Act
        String result = singletonMap.get(key);
        
        // Assert
        assertEquals(value, result);
    }

    @Test(timeout = 4000)
    public void testGetReturnsNullWhenKeyIsNotEqual() {
        // Arrange
        String key = "testKey";
        String value = "testValue";
        SingletonMap<String, String> singletonMap = new SingletonMap<>(key, value);
        
        // Act
        String result = singletonMap.get("differentKey");
        
        // Assert
        assertEquals(null, result);
    }

}