package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.InternCache;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_InternCache_intern_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testInternWithLockClear() {
        InternCache internCache = new InternCache(280, 0.75f, 280); // Using constructor with parameters
        String input = "testString";

        // Fill the cache to trigger the clear
        for (int i = 0; i < 300; i++) {
            internCache.intern("string" + i);
        }

        try {
            String result = internCache.intern(input);
            assertNotNull(result);
            assertEquals(input.intern(), result);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

}