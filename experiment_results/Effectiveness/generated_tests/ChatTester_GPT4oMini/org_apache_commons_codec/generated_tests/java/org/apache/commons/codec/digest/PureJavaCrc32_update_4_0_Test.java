package org.apache.commons.codec.digest;

import java.lang.reflect.Field;
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
        // Set initial crc value to 0
        setCrcValue(crc32, 0);
        // Update with a byte value
        crc32.update(0x01);
        // Verify the crc value after update
        // Expected CRC value after updating with 0x01
        assertEquals(0xE8B7BE43, getCrcValue(crc32));
    }

    @Test
    public void testUpdateMultipleBytes() throws Exception {
        // Set initial crc value to 0
        setCrcValue(crc32, 0);
        // Update with multiple byte values
        crc32.update(0x01);
        crc32.update(0x02);
        crc32.update(0x03);
        // Verify the crc value after updates
        // Expected CRC value after updating with 0x01, 0x02, 0x03
        assertEquals(0xB7B9D5E0, getCrcValue(crc32));
    }

    @Test
    public void testUpdateWithDifferentValues() throws Exception {
        // Set initial crc value to 0
        setCrcValue(crc32, 0);
        // Update with different byte values
        crc32.update(0xFF);
        crc32.update(0x00);
        crc32.update(0x80);
        // Verify the crc value after updates
        // Expected CRC value after updating with 0xFF, 0x00, 0x80
        assertEquals(0xA3B2C7D1, getCrcValue(crc32));
    }

    @Test
    public void testUpdateWithMaxValue() throws Exception {
        // Set initial crc value to 0
        setCrcValue(crc32, 0);
        // Update with the maximum byte value
        crc32.update(0xFF);
        // Verify the crc value after update
        // Expected CRC value after updating with 0xFF
        assertEquals(0xA9C8D2F5, getCrcValue(crc32));
    }

    @Test
    public void testUpdateWithZero() throws Exception {
        // Set initial crc value to 0
        setCrcValue(crc32, 0);
        // Update with zero
        crc32.update(0x00);
        // Verify the crc value after update
        // Expected CRC value after updating with 0x00
        assertEquals(0xE8B7BE43, getCrcValue(crc32));
    }

    private int getCrcValue(PureJavaCrc32 crc32) throws Exception {
        Field crcField = PureJavaCrc32.class.getDeclaredField("crc");
        crcField.setAccessible(true);
        return (int) crcField.get(crc32);
    }

    private void setCrcValue(PureJavaCrc32 crc32, int value) throws Exception {
        Field crcField = PureJavaCrc32.class.getDeclaredField("crc");
        crcField.setAccessible(true);
        crcField.setInt(crc32, value);
    }
}
