package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.Set;

public class map_Flat3Map_keySet__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testKeySetWhenDelegateMapIsNotNull() {
        // Arrange
        AbstractHashedMap<String, String> delegateMap = new AbstractHashedMap<>();
        delegateMap.put("key1", "value1");
        Flat3Map<String, String> flat3Map = new Flat3Map<>(delegateMap);

        // Act
        Set<String> keySet = flat3Map.keySet();

        // Assert
        assertNotNull(keySet);
        // Additional assertions can be added to verify the contents of the keySet if needed
    }

    @Test(timeout = 4000)
    public void testKeySetWhenDelegateMapIsNull() {
        // Arrange
        Flat3Map<String, String> flat3Map = new Flat3Map<>(null); // Pass null to the constructor

        // Act
        Set<String> keySet = flat3Map.keySet();

        // Assert
        assertNotNull(keySet);
        // Additional assertions can be added to verify the contents of the keySet if needed
    }

}