package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.Checksum;

public class PureJavaCrc32C_update_2_0_Test {

    private PureJavaCrc32C crc32c;

    @BeforeEach
    public void setUp() {
        crc32c = new PureJavaCrc32C();
    }

    @Test
    public void testUpdateWithEmptyArray() {
        byte[] data = new byte[0];
        crc32c.update(data, 0, 0);
        assertEquals(0xffffffffL, crc32c.getValue());
    }

    @Test
    public void testUpdateWithSingleByte() {
        byte[] data = new byte[] { 1 };
        crc32c.update(data, 0, 1);
        assertEquals(0xFFFEF1F7L, crc32c.getValue());
    }

    @Test
    public void testUpdateWithMultipleBytes() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        crc32c.update(data, 0, data.length);
        assertEquals(0xFFFEF1F7L, crc32c.getValue());
    }

    @Test
    public void testUpdateWithMoreThanEightBytes() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        crc32c.update(data, 0, data.length);
        assertEquals(0xFFFEF1F7L, crc32c.getValue());
    }

    @Test
    public void testUpdateWithDifferentOffsets() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        crc32c.update(data, 2, 4);
        assertEquals(0xFFFEF1F7L, crc32c.getValue());
    }

    @Test
    public void testUpdateWithNegativeOffset() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        crc32c.update(data, -1, 4);
        // should not change
        assertEquals(0xffffffffL, crc32c.getValue());
    }

    @Test
    public void testUpdateWithZeroLength() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        crc32c.update(data, 0, 0);
        // should not change
        assertEquals(0xffffffffL, crc32c.getValue());
    }

//    @Test
//    public void testUpdateWithMaxIntegerLength() {
//        byte[] data = new byte[Integer.MAX_VALUE];
//        crc32c.update(data, 0, Integer.MAX_VALUE);
//        assertEquals(0xFFFEF1F7L, crc32c.getValue());
//    }

    @Test
    public void testReset() {
        byte[] data = new byte[] { 1, 2, 3, 4 };
        crc32c.update(data, 0, data.length);
        assertEquals(0xFFFEF1F7L, crc32c.getValue());
        crc32c.reset();
        assertEquals(0xffffffffL, crc32c.getValue());
    }

    @Test
    public void testGetValueAfterReset() {
        crc32c.reset();
        assertEquals(0xffffffffL, crc32c.getValue());
    }
}
