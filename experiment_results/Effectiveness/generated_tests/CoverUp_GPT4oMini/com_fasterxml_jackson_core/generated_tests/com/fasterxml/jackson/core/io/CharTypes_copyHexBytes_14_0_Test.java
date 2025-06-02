package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

public class CharTypes_copyHexBytes_14_0_Test {

    private static byte[] expectedUppercaseHexBytes;

    private static byte[] expectedLowercaseHexBytes;

    @BeforeAll
    public static void setUp() {
        // Assuming the HB and HBlower arrays are initialized somewhere in the CharTypes class.
        expectedUppercaseHexBytes = new byte[] {/* Initialize with expected values for HB */
        };
        expectedLowercaseHexBytes = new byte[] {/* Initialize with expected values for HBlower */
        };
    }

    @Test
    public void testCopyHexBytesUppercase() throws Exception {
        byte[] result = invokeCopyHexBytes(true);
        assertArrayEquals(expectedUppercaseHexBytes, result);
    }

    @Test
    public void testCopyHexBytesLowercase() throws Exception {
        byte[] result = invokeCopyHexBytes(false);
        assertArrayEquals(expectedLowercaseHexBytes, result);
    }

    private byte[] invokeCopyHexBytes(boolean uppercase) throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = CharTypes.class.getDeclaredMethod("copyHexBytes", boolean.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(null, uppercase);
    }
}
