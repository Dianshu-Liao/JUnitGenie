package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class binary_StringUtils_newString_byte_____String_cfg_path_3_Test {

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
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testNewString_UnsupportedEncoding() {
        byte[] bytes = {72, 101, 108, 108, 111}; // Represents "Hello" in bytes
        String charsetName = "unsupported-charset"; // This should trigger the exception
        try {
            StringUtils.newString(bytes, charsetName);
        } catch (IllegalStateException e) {
            // Expected exception
            assertEquals("unsupported-charset", e.getMessage());
        }
    }

}