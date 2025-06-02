package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.InternCache;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_InternCache_intern_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIntern() {
        InternCache internCache = new InternCache();
        String input = "testString";
        String expected = input.intern();

        // Call the focal method
        String result = null;
        try {
            result = internCache.intern(input);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the result
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testInternWithLock() {
        InternCache internCache = new InternCache();
        String input = "testStringWithLock";
        
        // Simulate the condition where the lock is held
        // This is a simple test case, in a real scenario you might need to use threads to hold the lock
        String result = null;
        try {
            result = internCache.intern(input);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the result
        assertEquals(input.intern(), result);
    }

}