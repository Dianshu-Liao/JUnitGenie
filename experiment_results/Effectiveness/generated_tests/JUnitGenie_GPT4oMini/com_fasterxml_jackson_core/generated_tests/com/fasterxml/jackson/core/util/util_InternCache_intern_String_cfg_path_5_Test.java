package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.InternCache;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_InternCache_intern_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testInternMethodWithClearingEntries() {
        InternCache internCache = new InternCache(100, 0.75f, 280); // Initialize with values that allow us to test clearing.
        String input = "testString";

        // Fill the cache to trigger clearing
        for (int i = 0; i < 300; i++) {
            internCache.intern("string" + i);
        }

        String result = null;
        try {
            result = internCache.intern(input);
        } catch (Exception e) {
            // handled Exception if any
        }

        // Check the expected behavior
        // Intern process, in this case, should return the interned string
        assertEquals(input.intern(), result);
    }

    @Test(timeout = 4000)
    public void testInternMethodWhenExists() {
        InternCache internCache = new InternCache();
        String input = "existingString";
        internCache.intern(input); // Intern the original string

        String result = null;
        try {
            result = internCache.intern(input); // Interning again should return the existing interned string
        } catch (Exception e) {
            // handled Exception if any
        }

        assertEquals(input.intern(), result); // Asserting that it returns the same interned string
    }

}