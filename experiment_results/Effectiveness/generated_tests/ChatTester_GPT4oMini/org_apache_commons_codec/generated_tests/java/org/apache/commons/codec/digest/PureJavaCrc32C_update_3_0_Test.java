package org.apache.commons.codec.digest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.zip.Checksum;

public class PureJavaCrc32C_update_3_0_Test {

    private PureJavaCrc32C crc32C;

    @BeforeEach
    public void setUp() {
        crc32C = new PureJavaCrc32C();
    }

    @Test
    public void testUpdateWithSingleByte() throws Exception {
        // Test with a single byte input
        invokeUpdate(crc32C, 0x01);
        assertEquals(0xF26B8303, getCrcValue(crc32C));
        invokeUpdate(crc32C, 0xFF);
        assertEquals(0xE13B70F7, getCrcValue(crc32C));
        invokeUpdate(crc32C, 0x00);
        assertEquals(0x00000000, getCrcValue(crc32C));
    }

    @Test
    public void testUpdateWithMultipleBytes() throws Exception {
        // Test with multiple byte inputs
        invokeUpdate(crc32C, 0x01);
        invokeUpdate(crc32C, 0x02);
        invokeUpdate(crc32C, 0x03);
        // Expected CRC after multiple updates
        assertEquals(0xE13B70F7, getCrcValue(crc32C));
        invokeUpdate(crc32C, 0x04);
        invokeUpdate(crc32C, 0x05);
        // Expected CRC after more updates
        assertEquals(0xC79A971F, getCrcValue(crc32C));
    }

    @Test
    public void testUpdateWithBoundaryValues() throws Exception {
        // Test with boundary values
        invokeUpdate(crc32C, 0x00);
        // CRC should remain the same
        assertEquals(0x00000000, getCrcValue(crc32C));
        invokeUpdate(crc32C, 0xFF);
        // Expected CRC after updating with 0xFF
        assertEquals(0xE13B70F7, getCrcValue(crc32C));
        invokeUpdate(crc32C, 0x80);
        // Expected CRC after updating with 0x80
        assertEquals(0x9A879FA0, getCrcValue(crc32C));
    }

    // Reflection method to invoke the private update method
    private void invokeUpdate(PureJavaCrc32C crc32C, int b) throws Exception {
        Method method = PureJavaCrc32C.class.getDeclaredMethod("update", int.class);
        method.setAccessible(true);
        method.invoke(crc32C, b);
    }

    private int getCrcValue(PureJavaCrc32C crc32C) throws Exception {
        Field field = PureJavaCrc32C.class.getDeclaredField("crc");
        field.setAccessible(true);
        return (int) field.get(crc32C);
    }
}
