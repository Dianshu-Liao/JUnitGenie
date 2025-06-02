package org.apache.commons.collections4.multimap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.UnmodifiableMultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class multimap_UnmodifiableMultiValuedMap_unmodifiableMultiValuedMap_MultiValuedMap_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableMultiValuedMap_withNonUnmodifiableMap() {
        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        map.put("key1", "value1");
        map.put("key1", "value2");

        try {
            UnmodifiableMultiValuedMap<String, String> unmodifiableMap = 
                UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(map);
            assertNotNull(unmodifiableMap);
            assertEquals(2, unmodifiableMap.get("key1").size());
            assertTrue(unmodifiableMap.get("key1").contains("value1"));
            assertTrue(unmodifiableMap.get("key1").contains("value2"));
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    // Additional test cases can be added to cover more scenarios as needed.

}