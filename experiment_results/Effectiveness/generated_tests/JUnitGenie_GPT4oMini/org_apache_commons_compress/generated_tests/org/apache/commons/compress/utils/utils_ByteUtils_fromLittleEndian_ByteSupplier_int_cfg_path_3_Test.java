package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.ByteUtils.ByteSupplier;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class utils_ByteUtils_fromLittleEndian_ByteSupplier_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testFromLittleEndian() {
        // Arrange
        ByteSupplier supplier = new ByteSupplier() {
            private final byte[] data = {1, 2, 3, 4}; // Example data
            private int index = 0;

            @Override
            public int getAsByte() {
                if (index < data.length) {
                    return data[index++];
                }
                return 0; // Ensure it does not return -1
            }
        };
        int length = 4; // Valid length within the constraints

        try {
            // Act
            long result = ByteUtils.fromLittleEndian(supplier, length);

            // Assert
            assertEquals(67305985L, result); // 1 + 2*256 + 3*65536 + 4*16777216
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testFromLittleEndian_PrematureEndOfData() {
        // Arrange
        ByteSupplier supplier = new ByteSupplier() {
            private int callCount = 0;

            @Override
            public int getAsByte() {
                if (callCount < 2) {
                    callCount++;
                    return 1; // Return valid byte
                }
                return -1; // Simulate premature end of data
            }
        };
        int length = 4; // Valid length within the constraints

        // Act & Assert
        try {
            ByteUtils.fromLittleEndian(supplier, length);
            fail("IOException expected due to premature end of data");
        } catch (IOException e) {
            assertEquals("Premature end of data", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFromLittleEndian_InvalidLength() {
        // Arrange
        ByteSupplier supplier = new ByteSupplier() {
            @Override
            public int getAsByte() {
                return 1; // Return valid byte
            }
        };
        int length = 9; // Invalid length, should be between 0 and 8

        // Act & Assert
        try {
            ByteUtils.fromLittleEndian(supplier, length);
            fail("IOException expected due to invalid length");
        } catch (IOException e) {
            assertEquals("Invalid read length", e.getMessage());
        }
    }

}