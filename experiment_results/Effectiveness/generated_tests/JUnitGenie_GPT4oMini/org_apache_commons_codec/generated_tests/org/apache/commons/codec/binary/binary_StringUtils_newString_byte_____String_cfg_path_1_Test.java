package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_StringUtils_newString_byte_____String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNewStringWithValidInput() {
        byte[] bytes = "Hello".getBytes();
        String charsetName = "UTF-8";
        String result = StringUtils.newString(bytes, charsetName);
        assertEquals("Hello", result);
    }

    @Test(timeout = 4000)
    public void testNewStringWithNullBytes() {
        byte[] bytes = null;
        String charsetName = "UTF-8";
        String result = StringUtils.newString(bytes, charsetName);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testNewStringWithUnsupportedEncoding() {
        byte[] bytes = "Hello".getBytes();
        String charsetName = "unsupported-charset";
        try {
            StringUtils.newString(bytes, charsetName);
            fail("Expected an IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals(charsetName, e.getMessage());
        }
    }

}