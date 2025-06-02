package org.apache.commons.lang3.text;
import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;

public class text_StrBuilder_endsWith_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEndsWith_ValidString_True() {
        StrBuilder strBuilder = new StrBuilder("HelloWorld");
        boolean result = strBuilder.endsWith("World");
        assertEquals(true, result);
    }

    @Test(timeout = 4000)
    public void testEndsWith_ValidString_False() {
        StrBuilder strBuilder = new StrBuilder("HelloWorld");
        boolean result = strBuilder.endsWith("Hello");
        assertEquals(false, result);
    }

    @Test(timeout = 4000)
    public void testEndsWith_EmptyString_True() {
        StrBuilder strBuilder = new StrBuilder("HelloWorld");
        boolean result = strBuilder.endsWith("");
        assertEquals(true, result);
    }

    @Test(timeout = 4000)
    public void testEndsWith_NullString_False() {
        StrBuilder strBuilder = new StrBuilder("HelloWorld");
        boolean result = strBuilder.endsWith(null);
        assertEquals(false, result);
    }

    @Test(timeout = 4000)
    public void testEndsWith_StringLongerThanBuffer_False() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        boolean result = strBuilder.endsWith("HelloWorld");
        assertEquals(false, result);
    }

}