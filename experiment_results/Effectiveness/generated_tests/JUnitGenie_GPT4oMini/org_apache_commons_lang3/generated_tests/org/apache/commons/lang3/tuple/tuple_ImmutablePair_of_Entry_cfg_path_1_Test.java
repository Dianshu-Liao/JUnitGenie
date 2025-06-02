package org.apache.commons.lang3.tuple;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import java.util.AbstractMap;
import java.util.Map;

public class tuple_ImmutablePair_of_Entry_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testOf_NullEntry() {
        // Test case for null Map.Entry
        Map.Entry<String, String> nullEntry = null;
        ImmutablePair<String, String> result = ImmutablePair.of(nullEntry);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testOf_ValidEntry() {
        // Test case for a valid Map.Entry
        Map.Entry<String, String> validEntry = new AbstractMap.SimpleEntry<>("key", "value");
        ImmutablePair<String, String> result = ImmutablePair.of(validEntry);
        assertNotNull(result);
        assertEquals("key", result.getLeft());
        assertEquals("value", result.getRight());
    }


}