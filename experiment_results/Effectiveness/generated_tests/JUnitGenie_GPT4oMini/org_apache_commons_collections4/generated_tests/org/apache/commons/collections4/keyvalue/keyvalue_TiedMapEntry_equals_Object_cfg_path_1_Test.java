package org.apache.commons.collections4.keyvalue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;
import org.junit.Test;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class keyvalue_TiedMapEntry_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEqualsSameInstance() {
        TiedMapEntry<Integer, String> entry = new TiedMapEntry<>(new HashMap<>(), 1);
        assertTrue(entry.equals(entry));
    }

    @Test(timeout = 4000)
    public void testEqualsDifferentObjectType() {
        TiedMapEntry<Integer, String> entry = new TiedMapEntry<>(new HashMap<>(), 1);
        String otherObject = "Not a Map.Entry";
        assertFalse(entry.equals(otherObject));
    }

    @Test(timeout = 4000)
    public void testEqualsDifferentMapEntry() {
        Map.Entry<Integer, String> entry1 = new AbstractMap.SimpleEntry<>(1, "value");
        Map.Entry<Integer, String> entry2 = new AbstractMap.SimpleEntry<>(1, "otherValue");
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "value");
        TiedMapEntry<Integer, String> tiedEntry = new TiedMapEntry<>(map, 1);

        assertFalse(tiedEntry.equals(entry2));
    }

    @Test(timeout = 4000)
    public void testEqualsSameKeyAndValue() {
        Map.Entry<Integer, String> entry = new AbstractMap.SimpleEntry<>(1, "value");
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "value");
        TiedMapEntry<Integer, String> tiedEntry = new TiedMapEntry<>(map, 1);

        assertTrue(tiedEntry.equals(entry));
    }

}