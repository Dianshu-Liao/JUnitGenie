package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.CompositeMap;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.Map;
import java.util.Set;

public class map_CompositeMap_entrySet__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEntrySet() {
        // Arrange
        CompositeMap<String, String> compositeMap = new CompositeMap<>();

        // Act
        Set<Map.Entry<String, String>> entries = null;
        try {
            entries = compositeMap.entrySet();
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert
        assertNotNull(entries);
    }


}