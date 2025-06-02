package org.apache.commons.collections4.keyvalue;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class keyvalue_TiedMapEntry_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        TiedMapEntry entry = new TiedMapEntry(null, "value");
        assertTrue(entry.equals(entry)); // Testing the case where obj is the same instance
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        TiedMapEntry entry = new TiedMapEntry(null, "value");
        String differentTypeObject = "Not a Map.Entry";
        assertFalse(entry.equals(differentTypeObject)); // Testing the case where obj is not an instance of Map.Entry
    }

    @Test(timeout = 4000)
    public void testEquals_EqualEntries() {
        TiedMapEntry entry1 = new TiedMapEntry(null, "value");
        TiedMapEntry entry2 = new TiedMapEntry(null, "value");
        assertTrue(entry1.equals(entry2)); // Testing the case where both entries are equal
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        TiedMapEntry entry = new TiedMapEntry(null, "value");
        assertFalse(entry.equals(null)); // Testing the case where obj is null
    }

}