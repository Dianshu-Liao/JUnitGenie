package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.InternCache;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_InternCache_intern_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIntern() {
        InternCache internCache = new InternCache(); // Using default constructor
        String input = "testString";
        
        // Call the intern method
        String result = internCache.intern(input);
        
        // Verify the result
        assertEquals(input.intern(), result);
    }

    @Test(timeout = 4000)
    public void testInternWithMaxEntries() {
        InternCache internCache = new InternCache(280, 0.75f, 280); // Using parameterized constructor
        String input = "testString";
        
        // Fill the cache to the maximum entries
        for (int i = 0; i < 280; i++) {
            internCache.intern("string" + i);
        }
        
        // Call the intern method
        String result = internCache.intern(input);
        
        // Verify the result
        assertEquals(input.intern(), result);
    }

}