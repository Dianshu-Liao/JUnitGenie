package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_StringUtils_newString_byte_____String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNewString_ValidInput() {
        byte[] bytes = {72, 101, 108, 108, 111}; // Represents "Hello" in bytes
        String charsetName = "UTF-8";
        String result = StringUtils.newString(bytes, charsetName);
        assertEquals("Hello", result);
    }

    @Test(timeout = 4000)
    public void testNewString_NullBytes() {
        byte[] bytes = null;
        String charsetName = "UTF-8";
        String result = StringUtils.newString(bytes, charsetName);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testNewString_UnsupportedEncoding() {
        byte[] bytes = {72, 101, 108, 108, 111}; // Represents "Hello" in bytes
        String charsetName = "unsupported-charset"; // Invalid charset
        try {
            StringUtils.newString(bytes, charsetName);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals(charsetName, e.getMessage());
        }
    }

}