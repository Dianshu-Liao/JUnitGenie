package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class map_Flat3Map_size__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSizeWithNonNullDelegateMap() {
        // Arrange
        AbstractHashedMap<String, String> delegateMap = new AbstractHashedMap<>();
        delegateMap.put("key1", "value1");
        Flat3Map flat3Map = new Flat3Map(delegateMap);

        // Act
        int result = flat3Map.size();

        // Assert
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithNullDelegateMap() {
        // Arrange
        Flat3Map flat3Map = new Flat3Map();

        // Act
        int result = flat3Map.size();

        // Assert
        assertEquals(0, result);
    }

}