package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
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
    public void testUpdateWithFullBlocks() {
        byte[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
        crc32.update(data, 0, data.length);
        assertEquals(0x5D2B7F7B, crc32.getValue());
    }

    @Test
    public void testUpdateWithPartialBlock() {
        byte[] data = { 1, 2, 3, 4, 5, 6, 7 };
        crc32.update(data, 0, data.length);
        assertEquals(0x5F6B3C8D, crc32.getValue());
    }

    @Test
    public void testUpdateWithZeroLength() {
        byte[] data = {};
        crc32.update(data, 0, 0);
        assertEquals(0xFFFFFFFF, crc32.getValue());
    }

    @Test
    public void testUpdateWithNegativeOffset() {
        byte[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
        try {
            crc32.update(data, -1, 5);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Index -1 out of bounds for length 8", e.getMessage());
        }
    }

    @Test
    public void testUpdateWithExceedingLength() {
        byte[] data = { 1, 2, 3, 4, 5, 6, 7, 8 };
        try {
            crc32.update(data, 0, 10);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals("Index 8 out of bounds for length 8", e.getMessage());
        }
    }

    @Test
    public void testUpdateMultipleTimes() {
        byte[] data1 = { 1, 2, 3, 4 };
        byte[] data2 = { 5, 6, 7, 8 };
        crc32.update(data1, 0, data1.length);
        crc32.update(data2, 0, data2.length);
        assertEquals(0x5D2B7F7B, crc32.getValue());
    }

    @Test
    public void testUpdateWithDifferentData() {
        byte[] data1 = { 1, 2, 3, 4 };
        byte[] data2 = { 8, 7, 6, 5 };
        crc32.update(data1, 0, data1.length);
        crc32.update(data2, 0, data2.length);
        assertEquals(0xE2D7B1A2, crc32.getValue());
    }

    @Test
    public void testUpdateWithLargeData() {
        byte[] data = new byte[1000];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (i % 256);
        }
        crc32.update(data, 0, data.length);
        assertEquals(0xD5B6E0F4, crc32.getValue());
    }
}
