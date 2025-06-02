package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

public class CharTypes_copyHexBytes_15_0_Test {

    private static byte[] HB;

    private static byte[] HBlower;

    @BeforeAll
    public static void setup() {
        // Initialize HB and HBlower with sample data for testing
        HB = new byte[] { 0x00, 0x01, 0x02, 0x03 };
        HBlower = new byte[] { 0x04, 0x05, 0x06, 0x07 };
        // Set the static fields directly for testing purposes
        try {
            java.lang.reflect.Field hbField = CharTypes.class.getDeclaredField("HB");
            hbField.setAccessible(true);
            hbField.set(null, HB);
            java.lang.reflect.Field hblowerField = CharTypes.class.getDeclaredField("HBlower");
            hblowerField.setAccessible(true);
            hblowerField.set(null, HBlower);
        } catch (Exception e) {
            fail("Failed to set up test data: " + e.getMessage());
        }
    }

    @Test
    public void testCopyHexBytesUppercase() {
        byte[] result = CharTypes.copyHexBytes(true);
        assertArrayEquals(HB, result, "copyHexBytes should return the uppercase byte array.");
    }

    @Test
    public void testCopyHexBytesLowercase() {
        byte[] result = CharTypes.copyHexBytes(false);
        assertArrayEquals(HBlower, result, "copyHexBytes should return the lowercase byte array.");
    }
}
