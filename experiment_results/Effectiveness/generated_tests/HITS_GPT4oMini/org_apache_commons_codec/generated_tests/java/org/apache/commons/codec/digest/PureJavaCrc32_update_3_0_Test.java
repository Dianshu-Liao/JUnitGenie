package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.Checksum;

public class PureJavaCrc32_update_3_0_Test {

    private PureJavaCrc32 crc32;

    @BeforeEach
    public void setUp() {
        crc32 = new PureJavaCrc32();
    }

    @Test
    public void testUpdateWithEmptyArray() {
        byte[] data = new byte[0];
        crc32.update(data, 0, 0);
        assertEquals(0xffffffffL, crc32.getValue());
    }

    @Test
    public void testUpdateWithSingleByte() {
        byte[] data = { 1 };
        crc32.update(data, 0, 1);
        // Expected CRC value for byte 1
        assertEquals(0x8C, crc32.getValue());
    }

    @Test
    public void testUpdateWithMultipleBytes() {
        byte[] data = { 1, 2, 3, 4 };
        crc32.update(data, 0, data.length);
        // Expected CRC value for bytes 1, 2, 3, 4
        assertEquals(0x1C, crc32.getValue());
    }

    @Test
    public void testUpdateWithOffset() {
        byte[] data = { 0, 1, 2, 3, 4, 5 };
        // Update with bytes 2, 3, 4, 5
        crc32.update(data, 2, 4);
        // Expected CRC value for bytes 2, 3, 4, 5
        assertEquals(0x1C, crc32.getValue());
    }

    @Test
    public void testUpdateWithLengthGreaterThanArray() {
        byte[] data = { 1, 2, 3 };
        // Length exceeds actual data size
        crc32.update(data, 0, 5);
        // Should not throw and should calculate based on available data
        assertEquals(0x1C, crc32.getValue());
    }

    @Test
    public void testUpdateWithNegativeOffset() {
        byte[] data = { 1, 2, 3, 4 };
        try {
            crc32.update(data, -1, 2);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index 0 is out of bounds for length 4", e.getMessage());
        }
    }

    @Test
    public void testUpdateWithNegativeLength() {
        byte[] data = { 1, 2, 3, 4 };
        try {
            crc32.update(data, 0, -1);
        } catch (IllegalArgumentException e) {
            assertEquals("Length must be non-negative", e.getMessage());
        }
    }

    @Test
    public void testUpdateWithZeroLength() {
        byte[] data = { 1, 2, 3 };
        crc32.update(data, 0, 0);
        assertEquals(0xffffffffL, crc32.getValue());
    }

    @Test
    public void testUpdateWithFullCycle() {
        byte[] data = { 0, 1, 2, 3, 4, 5, 6, 7 };
        crc32.update(data, 0, data.length);
        // Expected CRC value for full cycle
        assertEquals(0x1C, crc32.getValue());
    }

    @Test
    public void testUpdateWithRepeatedCalls() {
        byte[] data1 = { 1, 2, 3 };
        byte[] data2 = { 4, 5, 6 };
        crc32.update(data1, 0, data1.length);
        crc32.update(data2, 0, data2.length);
        // Expected CRC value after multiple updates
        assertEquals(0x1C, crc32.getValue());
    }
}
