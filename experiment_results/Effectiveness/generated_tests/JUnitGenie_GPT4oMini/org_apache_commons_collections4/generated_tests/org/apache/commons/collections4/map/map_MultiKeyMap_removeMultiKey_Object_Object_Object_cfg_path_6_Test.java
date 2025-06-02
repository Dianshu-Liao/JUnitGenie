package org.apache.commons.collections4.map;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class map_MultiKeyMap_removeMultiKey_Object_Object_Object_cfg_path_6_Test {



    @Test(timeout = 4000)
    public void testRemoveMultiKeyWithNullKeys() {
        // Arrange
        MultiKeyMap<Object, String> multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>(null), "value1");

        // Act
        Object removedValue = multiKeyMap.removeMultiKey(new MultiKey<>(null), new MultiKey<>(null), new MultiKey<>(null));

        // Assert
        assertEquals("value1", removedValue); // Expecting to get the value associated with null key
    }


}
