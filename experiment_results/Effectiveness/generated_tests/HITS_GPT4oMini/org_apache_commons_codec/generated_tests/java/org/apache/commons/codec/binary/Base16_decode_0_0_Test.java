package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base16_decode_0_0_Test {

    private Base16 base16;

    private TestContext context;

    private static class TestContext extends Context {

        int pos;

        boolean eof;

        int ibitWorkArea;

        byte[] buffer = new byte[1024];
    }

    @BeforeEach
    void setUp() {
        base16 = new Base16();
        context = new TestContext();
    }

    @Test
    void testDecode_ValidHexInput() {
        byte[] input = new byte[] { '4', '1', '4', '2' };
        context.pos = 0;
        base16.decode(input, 0, input.length, context);
        assertEquals(2, context.pos);
        assertEquals(65, context.buffer[0]);
        assertEquals(66, context.buffer[1]);
    }

    @Test
    void testDecode_ValidHexInputWithTrailingHalfByte() {
        byte[] input = new byte[] { '4', '1' };
        context.pos = 0;
        base16.decode(input, 0, input.length, context);
        assertEquals(1, context.pos);
        assertEquals(65, context.buffer[0]);
        assertEquals(1, context.ibitWorkArea);
    }

    @Test
    void testDecode_EmptyInput() {
        byte[] input = new byte[] {};
        context.pos = 0;
        base16.decode(input, 0, input.length, context);
        assertEquals(0, context.pos);
        assertFalse(context.eof);
    }

    @Test
    void testDecode_InvalidHexInput() {
        byte[] input = new byte[] { 'G', '1' };
        context.pos = 0;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            base16.decode(input, 0, input.length, context);
        });
        assertTrue(exception.getMessage().contains("Invalid octet in encoded value"));
    }

    @Test
    void testDecode_EndOfFileHandling() {
        byte[] input = new byte[] { '4', '1', '4' };
        context.pos = 0;
        context.eof = true;
        base16.decode(input, 0, input.length, context);
        assertEquals(1, context.pos);
        assertTrue(context.eof);
    }

    @Test
    void testDecode_SingleHexChar() {
        byte[] input = new byte[] { '4' };
        context.pos = 0;
        base16.decode(input, 0, input.length, context);
        assertEquals(0, context.pos);
        assertEquals(5, context.ibitWorkArea);
    }
}
