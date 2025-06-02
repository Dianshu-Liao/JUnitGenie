package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.InternCache;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_InternCache_intern_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testIntern() {
        InternCache internCache = new InternCache(); // Using default constructor
        String input = "testString";
        
        // Call the intern method
        String result = internCache.intern(input);
        
        // Verify the result
        assertEquals(input.intern(), result);
    }

}