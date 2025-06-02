package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
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
    public void testUpdateWithFullBlocks() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        crc32c.update(data, 0, data.length);
        long expectedCrc = crc32c.getValue();
        assertEquals(0xFFFFFFFFL, expectedCrc);
    }

    @Test
    public void testUpdateWithPartialBlock() {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6, 7 };
        crc32c.update(data, 0, data.length);
        long expectedCrc = crc32c.getValue();
        assertEquals(0xFFFFFFFFL, expectedCrc);
    }

    @Test
    public void testUpdateWithEmptyArray() {
        byte[] data = new byte[0];
        crc32c.update(data, 0, data.length);
        long expectedCrc = crc32c.getValue();
        assertEquals(0xFFFFFFFFL, expectedCrc);
    }

    @Test
    public void testUpdateWithSingleByte() {
        byte[] data = new byte[] { 1 };
        crc32c.update(data, 0, data.length);
        long expectedCrc = crc32c.getValue();
        assertEquals(0xFFFFFFFFL, expectedCrc);
    }

    @Test
    public void testUpdateWithMultipleUpdates() {
        byte[] data1 = new byte[] { 1, 2, 3 };
        byte[] data2 = new byte[] { 4, 5, 6, 7, 8 };
        crc32c.update(data1, 0, data1.length);
        crc32c.update(data2, 0, data2.length);
        long expectedCrc = crc32c.getValue();
        assertEquals(0xFFFFFFFFL, expectedCrc);
    }

    @Test
    public void testUpdateWithDifferentData() {
        byte[] data1 = new byte[] { 1, 1, 1, 1, 1, 1, 1, 1 };
        byte[] data2 = new byte[] { 2, 2, 2, 2, 2, 2, 2, 2 };
        crc32c.update(data1, 0, data1.length);
        crc32c.update(data2, 0, data2.length);
        long expectedCrc = crc32c.getValue();
        assertEquals(0xFFFFFFFFL, expectedCrc);
    }

    @Test
    public void testUpdateWithLargeData() {
        byte[] data = new byte[1024];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (i % 256);
        }
        crc32c.update(data, 0, data.length);
        long expectedCrc = crc32c.getValue();
        assertEquals(0xFFFFFFFFL, expectedCrc);
    }

    @Test
    public void testPrivateMethodInvocation() throws Exception {
        Method resetMethod = PureJavaCrc32C.class.getDeclaredMethod("reset");
        resetMethod.setAccessible(true);
        resetMethod.invoke(crc32c);
        assertEquals(0xFFFFFFFFL, crc32c.getValue());
    }
}
