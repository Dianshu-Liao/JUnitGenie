package org.apache.commons.collections4.keyvalue;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

public class keyvalue_TiedMapEntry_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        Map<String, String> map = new HashMap<>();
        TiedMapEntry<String, String> entry = new TiedMapEntry<>(map, "key");
        assertTrue(entry.equals(entry));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        Map<String, String> map = new HashMap<>();
        TiedMapEntry<String, String> entry = new TiedMapEntry<>(map, "key");
        assertFalse(entry.equals("Not a Map.Entry"));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        Map<String, String> map = new HashMap<>();
        TiedMapEntry<String, String> entry = new TiedMapEntry<>(map, "key");
        assertFalse(entry.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualEntries() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        TiedMapEntry<String, String> entry1 = new TiedMapEntry<>(map, "key");
        TiedMapEntry<String, String> entry2 = new TiedMapEntry<>(map, "key");
        entry1.getValue(); // Ensure getValue() is called to satisfy constraints
        assertTrue(entry1.equals(entry2));
    }

    @Test(timeout = 4000)
    public void testEquals_EntriesWithDifferentValues() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("key", "value1");
        TiedMapEntry<String, String> entry1 = new TiedMapEntry<>(map1, "key");

        Map<String, String> map2 = new HashMap<>();
        map2.put("key", "value2");
        TiedMapEntry<String, String> entry2 = new TiedMapEntry<>(map2, "key");

        entry1.getValue(); // Ensure getValue() is called to satisfy constraints
        assertFalse(entry1.equals(entry2));
    }

}