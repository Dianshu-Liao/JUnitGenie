package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_StringUtils_getBytesUnchecked_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetBytesUnchecked_ThrowsIllegalStateException() {
        String inputString = "test";
        String invalidCharset = "invalidCharset"; // This charset will cause UnsupportedEncodingException

        try {
            StringUtils.getBytesUnchecked(inputString, invalidCharset);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Expected exception
            assertEquals(invalidCharset, e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalStateException but got " + e.getClass().getSimpleName());
        }
    }

}