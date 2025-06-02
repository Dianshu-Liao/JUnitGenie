package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

public class CharTypes_copyHexBytes_15_0_Test {

    @BeforeAll
    public static void setUp() {
        // Assuming these are static final fields in CharTypes
        // We can't assign values to final variables, so we need to use a different approach.
        // Instead, we will just create a method to initialize them if needed.
    }

    @Test
    public void testCopyHexBytesUppercase() {
        byte[] result = CharTypes.copyHexBytes(true);
        assertNotNull(result);
        assertArrayEquals(CharTypes.HB, result);
    }

    @Test
    public void testCopyHexBytesLowercase() {
        byte[] result = CharTypes.copyHexBytes(false);
        assertNotNull(result);
        assertArrayEquals(CharTypes.HBlower, result);
    }

    @Test
    public void testCopyHexBytesUppercaseClone() {
        byte[] result = CharTypes.copyHexBytes(true);
        // Correcting the buggy line to cast the value to byte
        result[0] = (byte) 0xFF;
        // Original should remain unchanged
        assertArrayEquals(CharTypes.HB, CharTypes.copyHexBytes(true));
    }

    @Test
    public void testCopyHexBytesLowercaseClone() {
        byte[] result = CharTypes.copyHexBytes(false);
        // Correcting the buggy line to cast the value to byte
        result[0] = (byte) 0xFF;
        // Original should remain unchanged
        assertArrayEquals(CharTypes.HBlower, CharTypes.copyHexBytes(false));
    }
}
