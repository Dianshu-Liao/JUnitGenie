package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.Flat3Map;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.Collection;

public class map_Flat3Map_values__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValuesWhenDelegateMapIsNull() {
        // Arrange
        Flat3Map<String, String> flat3Map = new Flat3Map<>();

        // Act
        Collection<String> values = flat3Map.values();

        // Assert
        assertNotNull(values);
    }


}