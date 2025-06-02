package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.ByteUtils.ByteSupplier;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class utils_ByteUtils_fromLittleEndian_ByteSupplier_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFromLittleEndian() {
        // Arrange
        ByteSupplier supplier = new ByteSupplier() {
            private int index = 0;
            private final byte[] data = {1, 2, 3, 4}; // Example data

            @Override
            public int getAsByte() {
                return (index < data.length) ? data[index++] : 0; // Return 0 instead of -1
            }
        };
        int length = 4; // Valid length

        // Act
        long result = 0;
        try {
            result = ByteUtils.fromLittleEndian(supplier, length);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        assertEquals(67305985L, result); // 1 + 2*256 + 3*65536 + 4*16777216
    }

    @Test(timeout = 4000)
    public void testFromLittleEndian_PrematureEndOfData() {
        // Arrange
        ByteSupplier supplier = new ByteSupplier() {
            private int index = 0;
            private final byte[] data = {1, 2}; // Example data with insufficient length

            @Override
            public int getAsByte() {
                return (index < data.length) ? data[index++] : -1; // Return -1 to trigger exception
            }
        };
        int length = 4; // Length greater than data provided

        // Act & Assert
        try {
            ByteUtils.fromLittleEndian(supplier, length);
        } catch (IOException e) {
            // Expected exception
            assertEquals("Premature end of data", e.getMessage());
        }
    }

}