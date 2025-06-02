package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_indexOf_char_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIndexOf_ValidCharacter() {
        StrBuilder strBuilder = new StrBuilder("hello");
        strBuilder.size = 5; // Set size directly for testing
        strBuilder.buffer = new char[] {'h', 'e', 'l', 'l', 'o'};
        
        int result = strBuilder.indexOf('l', 0);
        assertEquals(2, result);
    }

    @Test(timeout = 4000)
    public void testIndexOf_CharacterNotFound() {
        StrBuilder strBuilder = new StrBuilder("hello");
        strBuilder.size = 5; // Set size directly for testing
        strBuilder.buffer = new char[] {'h', 'e', 'l', 'l', 'o'};
        
        int result = strBuilder.indexOf('x', 0);
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOf_StartIndexOutOfBounds() {
        StrBuilder strBuilder = new StrBuilder("hello");
        strBuilder.size = 5; // Set size directly for testing
        strBuilder.buffer = new char[] {'h', 'e', 'l', 'l', 'o'};
        
        int result = strBuilder.indexOf('l', 10);
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOf_StartIndexNegative() {
        StrBuilder strBuilder = new StrBuilder("hello");
        strBuilder.size = 5; // Set size directly for testing
        strBuilder.buffer = new char[] {'h', 'e', 'l', 'l', 'o'};
        
        int result = strBuilder.indexOf('l', -1);
        assertEquals(2, result);
    }

}