package org.apache.commons.collections4.keyvalue;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.HashMap;
import java.util.Map;

public class keyvalue_TiedMapEntry_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCode_withNonNullKeyAndValue() {
        // Arrange
        Map<Object, Object> map = new HashMap<>();
        Object key = new Object();
        Object value = new Object();
        map.put(key, value);
        
        TiedMapEntry entry = new TiedMapEntry(map, key);
        
        // Act
        int hashCode = entry.hashCode();
        
        // Assert
        assertNotNull(entry);
        assertEquals(key.hashCode() ^ value.hashCode(), hashCode);
    }

    @Test(timeout = 4000)
    public void testHashCode_withNullKey() {
        // Arrange
        Map<Object, Object> map = new HashMap<>();
        Object value = new Object();
        Object key = null;
        map.put(key, value);
        
        TiedMapEntry entry = new TiedMapEntry(map, key);
        
        // Act
        int hashCode = entry.hashCode();
        
        // Assert
        assertNotNull(entry);
        assertEquals(0 ^ value.hashCode(), hashCode);
    }

    @Test(timeout = 4000)
    public void testHashCode_withNullValue() {
        // Arrange
        Map<Object, Object> map = new HashMap<>();
        Object key = new Object();
        Object value = null;
        map.put(key, value);
        
        TiedMapEntry entry = new TiedMapEntry(map, key);
        
        // Act
        int hashCode = entry.hashCode();
        
        // Assert
        assertNotNull(entry);
        assertEquals(key.hashCode() ^ 0, hashCode);
    }

}