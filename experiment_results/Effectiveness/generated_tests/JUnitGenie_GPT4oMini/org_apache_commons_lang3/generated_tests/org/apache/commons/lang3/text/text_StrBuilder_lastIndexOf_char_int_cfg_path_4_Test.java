package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_lastIndexOf_char_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testLastIndexOf_withStartIndexGreaterThanSize() {
        StrBuilder strBuilder = new StrBuilder("example");
        int result = strBuilder.lastIndexOf('e', 10); // startIndex is greater than size
        assertEquals(0, result); // Should return the last index of 'e', which is 0
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withNegativeStartIndex() {
        StrBuilder strBuilder = new StrBuilder("example");
        int result = strBuilder.lastIndexOf('e', -1); // startIndex is negative
        assertEquals(-1, result); // Should return -1
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_whenCharacterFound() {
        StrBuilder strBuilder = new StrBuilder("example");
        int result = strBuilder.lastIndexOf('e', 6); // startIndex within range and character exists
        assertEquals(6, result); // Should return index of 'e' at the end
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_whenCharacterNotFound() {
        StrBuilder strBuilder = new StrBuilder("example");
        int result = strBuilder.lastIndexOf('z', 6); // Character not in the string
        assertEquals(-1, result); // Should return -1
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withStartIndexAtSize() {
        StrBuilder strBuilder = new StrBuilder("example");
        int result = strBuilder.lastIndexOf('e', 7); // startIndex equal to size
        assertEquals(0, result); // Should return last index of 'e'
    }

}