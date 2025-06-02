package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_lastIndexOf_char_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testLastIndexOfWithValidStartIndex() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.lastIndexOf('l', 4);
        assertEquals(3, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOfWithStartIndexOutOfBounds() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.lastIndexOf('l', 10);
        assertEquals(3, result); // should return the last index of 'l'
    }

    @Test(timeout = 4000)
    public void testLastIndexOfWithNegativeStartIndex() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.lastIndexOf('l', -1);
        assertEquals(-1, result); // should return -1 for negative start index
    }

    @Test(timeout = 4000)
    public void testLastIndexOfWithCharacterNotFound() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.lastIndexOf('x', 4);
        assertEquals(-1, result); // should return -1 if character is not found
    }

}