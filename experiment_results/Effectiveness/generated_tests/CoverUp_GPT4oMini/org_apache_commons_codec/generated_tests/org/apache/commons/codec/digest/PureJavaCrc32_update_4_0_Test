package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.Checksum;

public class PureJavaCrc32_update_4_0_Test {

    private PureJavaCrc32 crc32;

    @BeforeEach
    public void setUp() {
        crc32 = new PureJavaCrc32();
    }

    @Test
    public void testUpdateSingleByte() throws Exception {
        // Initial CRC value
        int initialCrc = invokeGetValue();
        // Update with a single byte
        crc32.update(0xFF);
        // Expected CRC value after update
        int expectedCrc = initialCrc >>> 8 ^ getTValue((initialCrc ^ 0xFF) << 24 >>> 24);
        assertEquals(expectedCrc, invokeGetValue());
    }

    @Test
    public void testUpdateMultipleBytes() throws Exception {
        // Update with multiple bytes
        byte[] data = { 0x01, 0x02, 0x03, 0x04 };
        crc32.update(data, 0, data.length);
        // Calculate expected CRC value
        // Starting value
        int expectedCrc = 0xffffffff;
        for (byte b : data) {
            expectedCrc = expectedCrc >>> 8 ^ getTValue((expectedCrc ^ (b & 0xFF)) << 24 >>> 24);
        }
        assertEquals(expectedCrc, invokeGetValue());
    }

    @Test
    public void testReset() throws Exception {
        // Update and then reset
        crc32.update(0xFF);
        crc32.reset();
        // After reset, CRC should be 0xffffffff
        assertEquals(0xffffffff, invokeGetValue());
    }

    private int invokeGetValue() throws Exception {
        Method getValueMethod = PureJavaCrc32.class.getDeclaredMethod("getValue");
        getValueMethod.setAccessible(true);
        return (int) getValueMethod.invoke(crc32);
    }

    private int getTValue(int index) throws Exception {
        Method getTMethod = PureJavaCrc32.class.getDeclaredMethod("getT", int.class);
        getTMethod.setAccessible(true);
        return (int) getTMethod.invoke(crc32, index);
    }
}
