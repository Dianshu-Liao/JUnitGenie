package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class map_MultiKeyMap_removeAll_Object_Object_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testRemoveAll_EmptyMap() {
        // Setup
        MultiKeyMap<Object, Object> multiKeyMap = new MultiKeyMap<>(new AbstractHashedMap<>()); // Create an instance with an empty AbstractHashedMap

        // Execute
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3");

        // Verify
        assertFalse(modified); // Expecting false as no keys are present to remove
    }

}