package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class bidimap_TreeBidiMap_putAll_Map_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPutAll() {
        // Arrange
        TreeBidiMap<String, String> bidiMap = new TreeBidiMap<>();
        Map<String, String> mapToPut = new HashMap<>();
        mapToPut.put("key1", "value1");
        mapToPut.put("key2", "value2");

        // Act
        try {
            bidiMap.putAll(mapToPut);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }

        // Assert
        // Verify that the entries were added correctly
        assert bidiMap.get("key1").equals("value1");
        assert bidiMap.get("key2").equals("value2");
    }

}