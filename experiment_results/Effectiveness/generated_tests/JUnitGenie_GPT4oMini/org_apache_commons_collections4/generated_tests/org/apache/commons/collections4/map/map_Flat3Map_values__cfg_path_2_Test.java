package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.Collection;

public class map_Flat3Map_values__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testValuesWithNonNullDelegateMap() {
        // Arrange
        AbstractHashedMap<String, String> delegateMap = new AbstractHashedMap<>();
        delegateMap.put("key1", "value1");
        Flat3Map<String, String> flat3Map = new Flat3Map<>(delegateMap);

        // Act
        Collection<String> values = flat3Map.values();

        // Assert
        assertNotNull(values);
    }

    @Test(timeout = 4000)
    public void testValuesWithNullDelegateMap() {
        // Arrange
        Flat3Map<String, String> flat3Map = new Flat3Map<>(null); // Pass null to the constructor

        // Act
        Collection<String> values = flat3Map.values();

        // Assert
        assertNotNull(values);
    }

}