package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.io.UnsupportedEncodingException;

public class StringUtils_getBytes_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetBytesWithNullString() throws UnsupportedEncodingException {
        // Given
        String string = null;
        String charset = "UTF-8"; // Charset can be any valid charset since we expect a null string.

        // When
        byte[] result = StringUtils.getBytes(string, charset);
        
        // Then
        assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result);
    }

    @Test(timeout = 4000)
    public void testGetBytesWithValidString() throws UnsupportedEncodingException {
        // Given
        String string = "Hello";
        String charset = "UTF-8"; // Using a valid charset.

        // When
        byte[] result = StringUtils.getBytes(string, charset);
        
        // Then
        assertArrayEquals("Hello".getBytes(charset), result);
    }

}