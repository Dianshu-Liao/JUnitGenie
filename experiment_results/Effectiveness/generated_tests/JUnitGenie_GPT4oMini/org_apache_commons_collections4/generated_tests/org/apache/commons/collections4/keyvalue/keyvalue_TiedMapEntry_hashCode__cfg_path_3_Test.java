package org.apache.commons.collections4.keyvalue;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class keyvalue_TiedMapEntry_hashCode__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHashCodeWithNullKeyAndValue() {
        // Create a map that does not contain the specified key
        java.util.Map<Object, Object> map = new java.util.HashMap<>();
        Object key = null; // key must be null
        TiedMapEntry entry = new TiedMapEntry(map, key);

        // Since the key is null, getKey() should return null
        // and getValue() should also return null as the map does not contain the key
        int expectedHashCode = 0; // Expected hash code when both key and value are null
        assertEquals(expectedHashCode, entry.hashCode());
    }

}