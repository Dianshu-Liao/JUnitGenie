package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.InternCache;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_InternCache_intern_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInternWithLockClear() {
        InternCache internCache = new InternCache();
        String input = "testString";

        // Fill the cache to reach the DEFAULT_MAX_ENTRIES limit
        for (int i = 0; i < 280; i++) {
            internCache.intern("string" + i);
        }

        // Now, when we call intern, it should attempt to clear the cache
        try {
            String result = internCache.intern(input);
            assertNotNull(result);
            assertEquals(input.intern(), result);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}