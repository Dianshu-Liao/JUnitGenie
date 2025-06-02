package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class binary_StringUtils_getBytesUnchecked_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetBytesUnchecked_StringIsNull() {
        // Given
        String string = null;
        String charsetName = "UTF-8";

        // When
        byte[] result = StringUtils.getBytesUnchecked(string, charsetName);

        // Then
        assertNull(result);
    }

}