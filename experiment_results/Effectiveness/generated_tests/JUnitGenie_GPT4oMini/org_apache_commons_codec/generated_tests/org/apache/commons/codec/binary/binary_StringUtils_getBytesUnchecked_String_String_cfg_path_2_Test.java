package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.io.UnsupportedEncodingException;

public class binary_StringUtils_getBytesUnchecked_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetBytesUnchecked_ValidInput() throws UnsupportedEncodingException {
        String inputString = "Hello";
        String charsetName = "UTF-8";
        byte[] expectedBytes = inputString.getBytes(charsetName);
        
        byte[] result = StringUtils.getBytesUnchecked(inputString, charsetName);
        
        assertArrayEquals(expectedBytes, result);
    }

    @Test(timeout = 4000)
    public void testGetBytesUnchecked_NullString() {
        String inputString = null;
        String charsetName = "UTF-8";
        
        byte[] result = StringUtils.getBytesUnchecked(inputString, charsetName);
        
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testGetBytesUnchecked_UnsupportedEncoding() {
        String inputString = "Hello";
        String charsetName = "unsupported-charset";
        
        try {
            StringUtils.getBytesUnchecked(inputString, charsetName);
        } catch (IllegalStateException e) {
            // Expected exception
        }
    }


}