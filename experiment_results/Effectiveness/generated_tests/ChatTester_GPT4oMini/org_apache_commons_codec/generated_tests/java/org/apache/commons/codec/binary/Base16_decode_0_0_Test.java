package org.apache.commons.codec.binary;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

@ExtendWith(MockitoExtension.class)
class Base16_decode_0_0_Test {

    private Base16 base16;

    private Context context;

    @BeforeEach
    void setUp() {
        base16 = new Base16();
        context = new Context();
    }

    @Test
    void testDecodeWithEofFlagSet() {
        context.eof = true;
        byte[] data = new byte[] { 0x1A, 0x2B };
        base16.decode(data, 0, data.length, context);
        assertTrue(context.eof);
        assertEquals(0, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithNegativeLength() {
        byte[] data = new byte[] { 0x1A, 0x2B };
        base16.decode(data, 0, -1, context);
        assertTrue(context.eof);
        assertEquals(0, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithSingleByte() {
        byte[] data = new byte[] { 0x1A };
        base16.decode(data, 0, 1, context);
        assertEquals(1, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithEvenBytes() {
        byte[] data = new byte[] { 0x1A, 0x2B, 0x3C, 0x4D };
        base16.decode(data, 0, data.length, context);
        assertEquals(0, context.ibitWorkArea);
        assertEquals(2, context.pos);
    }

    @Test
    void testDecodeWithOddBytes() {
        byte[] data = new byte[] { 0x1A, 0x2B, 0x3C };
        base16.decode(data, 0, data.length, context);
        assertEquals(1, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithBufferSize() {
        byte[] data = new byte[] { 0x1A, 0x2B, 0x3C, 0x4D };
        context.pos = 0;
        base16.decode(data, 0, data.length, context);
        assertEquals(2, context.pos);
    }

    @Test
    void testDecodeWithHalfByteFromPreviousInvocation() {
        byte[] data = new byte[] { 0x1A };
        base16.decode(data, 0, 1, context);
        assertEquals(1, context.ibitWorkArea);
        byte[] nextData = new byte[] { 0x2B };
        base16.decode(nextData, 0, 1, context);
        assertEquals(0, context.ibitWorkArea);
        assertEquals(1, context.pos);
    }

    private class Context extends BaseNCodec.Context {

        boolean eof;

        int ibitWorkArea;

        int pos;

        public Context() {
            this.eof = false;
            this.ibitWorkArea = 0;
            this.pos = 0;
        }
    }
}
