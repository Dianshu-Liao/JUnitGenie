package org.apache.commons.codec.digest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.zip.Checksum;

public class PureJavaCrc32C_update_3_1_Test {

    private PureJavaCrc32C crc32c;

    @BeforeEach
    public void setUp() {
        crc32c = new PureJavaCrc32C();
    }

    @Test
    public void testUpdateSingleByte() throws Exception {
        // Test with a single byte
        invokeUpdate(crc32c, 0x01);
        assertEquals(0xF26B8303, crc32c.getValue());
    }

    @Test
    public void testUpdateMultipleBytes() throws Exception {
        byte[] data = { 0x01, 0x02, 0x03 };
        crc32c.update(data, 0, data.length);
        assertEquals(0xE13B70F7, crc32c.getValue());
    }

    @Test
    public void testReset() throws Exception {
        invokeUpdate(crc32c, 0x01);
        crc32c.reset();
        assertEquals(0xFFFFFFFF, crc32c.getValue());
    }

    @Test
    public void testGetValue() throws Exception {
        invokeUpdate(crc32c, 0x01);
        long value = crc32c.getValue();
        assertEquals(~0xF26B8303 & 0xffffffffL, value);
    }

    private void invokeUpdate(PureJavaCrc32C crc32c, int b) throws Exception {
        Method method = PureJavaCrc32C.class.getDeclaredMethod("update", int.class);
        method.setAccessible(true);
        method.invoke(crc32c, b);
    }
}
