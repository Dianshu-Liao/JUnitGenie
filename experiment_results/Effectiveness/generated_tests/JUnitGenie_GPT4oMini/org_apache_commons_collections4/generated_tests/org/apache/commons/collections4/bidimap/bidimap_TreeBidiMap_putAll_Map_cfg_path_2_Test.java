package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class bidimap_TreeBidiMap_putAll_Map_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutAll() {
        // Arrange
        TreeBidiMap<String, Integer> bidiMap = new TreeBidiMap<>();
        Map<String, Integer> mapToPut = new HashMap<>();
        mapToPut.put("one", 1);
        mapToPut.put("two", 2);
        
        // Act
        try {
            bidiMap.putAll(mapToPut);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }

        // Assert
        // Verify that the entries were added correctly
        assert bidiMap.containsKey("one");
        assert bidiMap.get("one").equals(1);
        assert bidiMap.containsKey("two");
        assert bidiMap.get("two").equals(2);
    }

}