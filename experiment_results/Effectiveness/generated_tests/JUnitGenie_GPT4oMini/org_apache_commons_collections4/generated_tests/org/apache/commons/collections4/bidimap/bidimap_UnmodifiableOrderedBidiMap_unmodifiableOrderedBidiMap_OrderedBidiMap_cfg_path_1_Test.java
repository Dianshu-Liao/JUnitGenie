package org.apache.commons.collections4.bidimap;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.bidimap.UnmodifiableOrderedBidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class bidimap_UnmodifiableOrderedBidiMap_unmodifiableOrderedBidiMap_OrderedBidiMap_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableOrderedBidiMap() {
        // Create a modifiable OrderedBidiMap instance
        DualHashBidiMap<String, Integer> modifiableMap = new DualHashBidiMap<String, Integer>();
        modifiableMap.put("one", 1);
        modifiableMap.put("two", 2);
        
        // Call the focal method
        OrderedBidiMap<String, Integer> unmodifiableMap = null;
        try {
            // Cast the modifiableMap to OrderedBidiMap to satisfy the method's parameter type
            unmodifiableMap = UnmodifiableOrderedBidiMap.unmodifiableOrderedBidiMap((OrderedBidiMap<String, Integer>) modifiableMap);
        } catch (Exception e) {
            fail("Exception should not be thrown for a modifiable OrderedBidiMap");
        }

        // Verify that the returned map is indeed unmodifiable
        assertNotNull(unmodifiableMap);
        assertEquals(2, unmodifiableMap.size());
        
        // Attempt to modify the unmodifiable map and expect an exception
        try {
            unmodifiableMap.put("three", 3);
            fail("Expected UnsupportedOperationException not thrown");
        } catch (UnsupportedOperationException e) {
            // Expected exception
        }
    }


}