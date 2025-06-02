package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_lastIndexOf_char_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testLastIndexOf_withValidStartIndex() {
        StrBuilder strBuilder = new StrBuilder("hello");
        strBuilder.size = 5; // Set size to match the string length
        strBuilder.buffer = new char[] {'h', 'e', 'l', 'l', 'o'};
        
        int result = strBuilder.lastIndexOf('l', 4);
        assertEquals(3, result); // Last index of 'l' should be 3
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withStartIndexOutOfBounds() {
        StrBuilder strBuilder = new StrBuilder("hello");
        strBuilder.size = 5; // Set size to match the string length
        strBuilder.buffer = new char[] {'h', 'e', 'l', 'l', 'o'};
        
        int result = strBuilder.lastIndexOf('l', 10);
        assertEquals(3, result); // Should return last index of 'l' which is 3
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withNegativeStartIndex() {
        StrBuilder strBuilder = new StrBuilder("hello");
        strBuilder.size = 5; // Set size to match the string length
        strBuilder.buffer = new char[] {'h', 'e', 'l', 'l', 'o'};
        
        int result = strBuilder.lastIndexOf('l', -1);
        assertEquals(-1, result); // Should return -1 for negative start index
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withCharacterNotFound() {
        StrBuilder strBuilder = new StrBuilder("hello");
        strBuilder.size = 5; // Set size to match the string length
        strBuilder.buffer = new char[] {'h', 'e', 'l', 'l', 'o'};
        
        int result = strBuilder.lastIndexOf('x', 4);
        assertEquals(-1, result); // Should return -1 as 'x' is not in the string
    }

}