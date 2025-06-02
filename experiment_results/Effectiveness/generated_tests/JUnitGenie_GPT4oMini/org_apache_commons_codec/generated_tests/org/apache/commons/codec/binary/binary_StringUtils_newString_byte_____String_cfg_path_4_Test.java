package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class binary_StringUtils_newString_byte_____String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testNewString_withNullBytes_shouldReturnNull() {
        // Arrange
        byte[] bytes = null;
        String charsetName = "UTF-8";

        // Act
        String result = StringUtils.newString(bytes, charsetName);

        // Assert
        assertNull(result);
    }

}