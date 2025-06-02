package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.SecureRandom;
import java.util.Random;

class B64_b64from24bit_0_0_Test {

    @Test
    void testB64from24bit() {
        // Test case 1: Standard case with maximum byte values
        StringBuilder buffer1 = new StringBuilder();
        B64.b64from24bit((byte) 0xFF, (byte) 0xFF, (byte) 0xFF, 4, buffer1);
        assertEquals("////", buffer1.toString());
        // Test case 2: All zero bytes
        StringBuilder buffer2 = new StringBuilder();
        B64.b64from24bit((byte) 0x00, (byte) 0x00, (byte) 0x00, 4, buffer2);
        assertEquals("AAAA", buffer2.toString());
        // Test case 3: Different byte values
        StringBuilder buffer3 = new StringBuilder();
        B64.b64from24bit((byte) 0x12, (byte) 0x34, (byte) 0x56, 4, buffer3);
        assertEquals("EjRWeThn", buffer3.toString());
        // Test case 4: Edge case with outLen = 0
        StringBuilder buffer4 = new StringBuilder();
        B64.b64from24bit((byte) 0x12, (byte) 0x34, (byte) 0x56, 0, buffer4);
        assertEquals("", buffer4.toString());
        // Test case 5: Edge case with outLen less than 4
        StringBuilder buffer5 = new StringBuilder();
        B64.b64from24bit((byte) 0x01, (byte) 0x02, (byte) 0x03, 2, buffer5);
        assertEquals("AQI", buffer5.toString());
        // Test case 6: Maximum value for bytes
        StringBuilder buffer6 = new StringBuilder();
        B64.b64from24bit((byte) 0x7F, (byte) 0xFF, (byte) 0xFF, 4, buffer6);
        assertEquals("f//", buffer6.toString());
        // Test case 7: Single byte set to zero
        StringBuilder buffer7 = new StringBuilder();
        B64.b64from24bit((byte) 0x00, (byte) 0x01, (byte) 0x02, 3, buffer7);
        assertEquals("AQI", buffer7.toString());
        // Test case 8: All bytes set to the same value
        StringBuilder buffer8 = new StringBuilder();
        B64.b64from24bit((byte) 0x11, (byte) 0x11, (byte) 0x11, 4, buffer8);
        assertEquals("ExEx", buffer8.toString());
    }
}
