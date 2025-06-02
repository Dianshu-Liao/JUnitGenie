package org.apache.commons.codec.digest;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.Checksum;

class PureJavaCrc32_update_3_0_Test {

    private PureJavaCrc32 crc32;

    @BeforeEach
    void setUp() {
        crc32 = new PureJavaCrc32();
    }

    @Test
    void testUpdateWithFullBytes() {
        byte[] input = { 1, 2, 3, 4, 5, 6, 7, 8 };
        crc32.update(input, 0, input.length);
        // Replace with the actual expected CRC value
        int expectedCrc = 0x12345678;
        assertEquals(expectedCrc, getCrc());
    }

    @Test
    void testUpdateWithPartialBytes() {
        byte[] input = { 1, 2, 3, 4, 5, 6, 7 };
        crc32.update(input, 0, input.length);
        // Replace with the actual expected CRC value
        int expectedCrc = 0x23456789;
        assertEquals(expectedCrc, getCrc());
    }

    @Test
    void testUpdateWithEmptyArray() {
        byte[] input = {};
        crc32.update(input, 0, input.length);
        assertEquals(0, getCrc());
    }

    @Test
    void testUpdateWithOffset() {
        byte[] input = { 0, 1, 2, 3, 4, 5, 6, 7 };
        // should only process bytes 1 to 6
        crc32.update(input, 1, 6);
        // Replace with the actual expected CRC value
        int expectedCrc = 0x34567890;
        assertEquals(expectedCrc, getCrc());
    }

    @Test
    void testUpdateWithDifferentLengths() {
        byte[] input1 = { 1, 2, 3, 4 };
        byte[] input2 = { 5, 6, 7, 8 };
        crc32.update(input1, 0, input1.length);
        crc32.update(input2, 0, input2.length);
        // Replace with the actual expected CRC value
        int expectedCrc = 0x456789AB;
        assertEquals(expectedCrc, getCrc());
    }

    // Reflection method to access private fields
    private int getCrc() {
        try {
            Field field = PureJavaCrc32.class.getDeclaredField("crc");
            field.setAccessible(true);
            return (int) field.get(crc32);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
