package org.apache.commons.collections4.keyvalue;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;
import org.junit.Test;
import static org.junit.Assert.*;

public class keyvalue_TiedMapEntry_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        TiedMapEntry entry = new TiedMapEntry(null, "value");
        assertTrue(entry.equals(entry));
    }

    @Test(timeout = 4000)
    public void testEquals_NonMapEntryObject() {
        TiedMapEntry entry = new TiedMapEntry(null, "value");
        Object nonMapEntry = new Object();
        assertFalse(entry.equals(nonMapEntry));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentKeyValue() {
        TiedMapEntry entry1 = new TiedMapEntry(null, "value1");
        TiedMapEntry entry2 = new TiedMapEntry(null, "value2");
        assertFalse(entry1.equals(entry2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameKeyDifferentValue() {
        TiedMapEntry entry1 = new TiedMapEntry(null, "value");
        TiedMapEntry entry2 = new TiedMapEntry(null, "value");
        assertTrue(entry1.equals(entry2));
    }

}