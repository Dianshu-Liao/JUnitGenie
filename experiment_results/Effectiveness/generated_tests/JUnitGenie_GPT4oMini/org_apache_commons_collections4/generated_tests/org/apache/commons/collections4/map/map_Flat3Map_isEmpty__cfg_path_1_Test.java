package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class map_Flat3Map_isEmpty__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsEmptyWhenDelegateMapIsNull() {
        // Arrange
        Flat3Map flat3Map = new Flat3Map(); // Using the default constructor
        // Ensure that delegateMap is null (default behavior)

        // Act
        boolean result = flat3Map.isEmpty();

        // Assert
        assertTrue(result); // Expecting isEmpty to return true since size() should return 0
    }

}