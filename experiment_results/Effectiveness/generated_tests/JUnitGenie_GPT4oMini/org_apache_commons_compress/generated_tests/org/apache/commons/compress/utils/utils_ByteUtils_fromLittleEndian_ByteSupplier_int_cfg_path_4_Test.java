package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.ByteUtils.ByteSupplier;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class utils_ByteUtils_fromLittleEndian_ByteSupplier_int_cfg_path_4_Test {

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
                return -1; // Simulate end of data
            }
        };
        int length = 4; // Length must be greater than 8 to satisfy constraints

        // Act
        long result = 0;
        try {
            result = ByteUtils.fromLittleEndian(supplier, length);
        } catch (IOException e) {
            // Handle exception if necessary
        }

        // Assert
        assertEquals(67305985L, result); // 1 + (2 << 8) + (3 << 16) + (4 << 24)
    }

    @Test(timeout = 4000)
    public void testFromLittleEndian_PrematureEndOfData() {
        // Arrange
        ByteSupplier supplier = new ByteSupplier() {
            private final byte[] data = {1, 2}; // Example data
            private int index = 0;

            @Override
            public int getAsByte() {
                if (index < data.length) {
                    return data[index++];
                }
                return -1; // Simulate end of data
            }
        };
        int length = 4; // Length must be greater than 8 to satisfy constraints

        // Act & Assert
        try {
            ByteUtils.fromLittleEndian(supplier, length);
        } catch (IOException e) {
            // Expected exception
            return;
        }
        // If we reach here, the exception was not thrown
        assert false : "Expected IOException not thrown";
    }

}