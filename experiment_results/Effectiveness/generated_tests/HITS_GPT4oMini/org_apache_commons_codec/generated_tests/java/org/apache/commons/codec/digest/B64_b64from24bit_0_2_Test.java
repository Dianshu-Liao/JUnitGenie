package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.SecureRandom;
import java.util.Random;

public class B64_b64from24bit_0_2_Test {

    @Test
    public void testB64from24bit_withAllZeroes() {
        StringBuilder buffer = new StringBuilder();
        B64.b64from24bit((byte) 0, (byte) 0, (byte) 0, 4, buffer);
        assertEquals("AAAA", buffer.toString());
    }

    @Test
    public void testB64from24bit_withMaxValues() {
        StringBuilder buffer = new StringBuilder();
        B64.b64from24bit((byte) 127, (byte) 127, (byte) 127, 4, buffer);
        assertEquals("///w", buffer.toString());
    }

    @Test
    public void testB64from24bit_withMixedValues() {
        StringBuilder buffer = new StringBuilder();
        B64.b64from24bit((byte) 1, (byte) 2, (byte) 3, 4, buffer);
        assertEquals("AQIDBA", buffer.toString());
    }

    @Test
    public void testB64from24bit_withDifferentOutputLength() {
        StringBuilder buffer = new StringBuilder();
        B64.b64from24bit((byte) 5, (byte) 10, (byte) 15, 3, buffer);
        assertEquals("FKhO", buffer.toString());
    }

    @Test
    public void testB64from24bit_withNegativeByteValues() {
        StringBuilder buffer = new StringBuilder();
        B64.b64from24bit((byte) -1, (byte) -1, (byte) -1, 4, buffer);
        assertEquals("////", buffer.toString());
    }

    @Test
    public void testB64from24bit_withSingleOutputCharacter() {
        StringBuilder buffer = new StringBuilder();
        B64.b64from24bit((byte) 4, (byte) 5, (byte) 6, 1, buffer);
        assertEquals("E", buffer.toString());
    }

    @Test
    public void testB64from24bit_withCustomOutputLength() {
        StringBuilder buffer = new StringBuilder();
        B64.b64from24bit((byte) 10, (byte) 20, (byte) 30, 5, buffer);
        assertEquals("KjU0", buffer.toString());
    }
}
