package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_lastIndexOf_char_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testLastIndexOf() {
        // Setup
        StrBuilder strBuilder = new StrBuilder("hello world");
        strBuilder.size = 11; // Set size to match the string length
        strBuilder.buffer = new char[] {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};

        // Test case: character found at the end
        int result = strBuilder.lastIndexOf('d', 10);
        assertEquals(10, result);

        // Test case: character found in the middle
        result = strBuilder.lastIndexOf('l', 10);
        assertEquals(9, result);

        // Test case: character not found
        result = strBuilder.lastIndexOf('x', 10);
        assertEquals(-1, result);

        // Test case: startIndex is out of bounds (greater than size)
        result = strBuilder.lastIndexOf('o', 15);
        assertEquals(4, result);

        // Test case: startIndex is negative
        result = strBuilder.lastIndexOf('o', -1);
        assertEquals(-1, result);
    }

}