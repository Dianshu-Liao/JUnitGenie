package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_indexOf_char_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIndexOf_ValidCharacter() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.indexOf('e', 0);
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOf_CharacterNotFound() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.indexOf('x', 0);
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOf_StartIndexOutOfBounds() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.indexOf('e', 10);
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOf_NegativeStartIndex() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.indexOf('e', -1);
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOf_StartIndexAtZero() {
        StrBuilder strBuilder = new StrBuilder("hello");
        int result = strBuilder.indexOf('h', 0);
        assertEquals(0, result);
    }

}