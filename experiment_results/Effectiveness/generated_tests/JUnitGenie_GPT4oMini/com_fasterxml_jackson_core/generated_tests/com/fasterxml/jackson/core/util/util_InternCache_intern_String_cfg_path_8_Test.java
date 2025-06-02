package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.InternCache;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_InternCache_intern_String_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testInternWithNullResult() {
        InternCache internCache = new InternCache();
        String input = "testString";
        
        // Simulating the scenario where get(input) returns null
        // This is done by ensuring the cache is empty before the call
        String result = internCache.intern(input);
        
        // The expected result should be the interned string
        assertEquals(input.intern(), result);
    }

}