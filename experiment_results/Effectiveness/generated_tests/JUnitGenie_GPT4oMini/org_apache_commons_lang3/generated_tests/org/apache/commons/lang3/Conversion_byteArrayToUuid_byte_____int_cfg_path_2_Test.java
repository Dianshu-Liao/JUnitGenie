package org.apache.commons.lang3;
import org.apache.commons.lang3.Conversion;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Conversion_byteArrayToUuid_byte_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testByteArrayToUuid_ThrowsIllegalArgumentException() {
        // Arrange
        final byte[] src = new byte[15]; // Array length is less than 16
        final int srcPos = 0;

        // Act
        try {
            Conversion.byteArrayToUuid(src, srcPos);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Assert
            assertEquals("Need at least 16 bytes for UUID", e.getMessage());
        }
    }


}