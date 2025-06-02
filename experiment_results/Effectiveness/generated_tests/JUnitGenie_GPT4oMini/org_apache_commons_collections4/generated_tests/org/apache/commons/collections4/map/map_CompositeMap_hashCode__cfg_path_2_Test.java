package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.CompositeMap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class map_CompositeMap_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCode() {
        // Create a non-empty map to satisfy the constraints
        Map<String, String> map1 = new HashMap<>();
        map1.put("key1", "value1");

        // Create a CompositeMap with the non-empty map
        CompositeMap compositeMap = new CompositeMap(new Map[]{map1});

        // Calculate the expected hash code
        int expectedHashCode = map1.hashCode();

        // Call the hashCode method and assert the result
        int actualHashCode = compositeMap.hashCode();
        assertEquals(expectedHashCode, actualHashCode);
    }

}