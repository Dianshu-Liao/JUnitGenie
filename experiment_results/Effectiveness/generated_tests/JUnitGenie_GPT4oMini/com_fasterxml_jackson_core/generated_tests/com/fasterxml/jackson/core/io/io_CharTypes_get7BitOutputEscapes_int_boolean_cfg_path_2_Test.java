package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.CharTypes;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_CharTypes_get7BitOutputEscapes_int_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGet7BitOutputEscapesWithNonQuoteCharAndEscapeSlashFalse() {
        int quoteChar = 65; // 'A' character
        boolean escapeSlash = false;
        
        // Expected output based on the behavior of the method
        int[] expected = CharTypes.sOutputEscapes128; // Assuming this is the expected output for non-quote character
        
        // Call the focal method
        int[] result = CharTypes.get7BitOutputEscapes(quoteChar, escapeSlash);
        
        // Assert the result
        assertArrayEquals(expected, result);
    }

}