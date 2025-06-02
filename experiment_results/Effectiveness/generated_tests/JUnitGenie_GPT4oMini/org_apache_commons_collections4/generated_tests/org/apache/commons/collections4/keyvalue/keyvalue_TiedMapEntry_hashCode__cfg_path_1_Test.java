package org.apache.commons.collections4.keyvalue;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.HashMap;
import java.util.Map;

public class keyvalue_TiedMapEntry_hashCode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCode() {
        // Setup
        Map<Object, Object> map = new HashMap<>();
        Object key = new Object();
        Object value = new Object();
        map.put(key, value);
        
        TiedMapEntry entry = new TiedMapEntry(map, key);
        
        // Ensure that the key and value are not null
        assertNotNull(entry.getKey());
        assertNotNull(entry.getValue());

        // Execute
        int hashCode = entry.hashCode();

        // Verify
        int expectedHashCode = (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        assertEquals(expectedHashCode, hashCode);
    }

}