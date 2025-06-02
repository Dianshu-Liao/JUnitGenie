package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_lastIndexOf_char_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testLastIndexOf_ValidCharacter() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.lastIndexOf('l', 4);
        assertEquals(3, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_CharacterNotFound() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.lastIndexOf('x', 4);
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.lastIndexOf('l', 10);
        assertEquals(3, result); // Should return the last index of 'l'
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NegativeStartIndex() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.lastIndexOf('l', -1);
        assertEquals(-1, result); // Should return -1 for negative start index
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyBuffer() {
        StrBuilder strBuilder = new StrBuilder("");
        int result = strBuilder.lastIndexOf('a', 0);
        assertEquals(-1, result); // Should return -1 for empty buffer
    }

}