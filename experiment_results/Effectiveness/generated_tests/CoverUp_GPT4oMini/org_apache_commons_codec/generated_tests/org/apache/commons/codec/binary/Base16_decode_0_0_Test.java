package org.apache.commons.codec.binary;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.apache.commons.codec.CodecPolicy;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Base16_decode_0_0_Test {

    private Base16 base16;

    private Context context;

    private static class Context {

        boolean eof;

        int ibitWorkArea;

        int pos;
    }

    @BeforeEach
    public void setUp() {
        base16 = new Base16();
        context = new Context();
        context.eof = false;
        context.ibitWorkArea = 0;
        context.pos = 0;
    }

    @Test
    public void testDecodeWithValidData() {
        byte[] data = new byte[] { '1', 'A', '2', 'B' };
        invokeDecode(data, 0, data.length, context);
        assertEquals(2, context.pos);
        assertEquals(0, context.ibitWorkArea);
    }

    @Test
    public void testDecodeWithOddLengthData() {
        byte[] data = new byte[] { '1', 'A', '2' };
        invokeDecode(data, 0, data.length, context);
        assertEquals(1, context.pos);
        assertNotEquals(0, context.ibitWorkArea);
    }

    @Test
    public void testDecodeWithEofFlag() {
        context.eof = true;
        byte[] data = new byte[] { '1', 'A' };
        invokeDecode(data, 0, data.length, context);
        assertTrue(context.eof);
        assertEquals(0, context.pos);
    }

    @Test
    public void testDecodeWithNegativeLength() {
        byte[] data = new byte[] { '1', 'A' };
        invokeDecode(data, 0, -1, context);
        assertTrue(context.eof);
        assertEquals(0, context.pos);
    }

    @Test
    public void testDecodeWithEmptyData() {
        byte[] data = new byte[] {};
        invokeDecode(data, 0, 0, context);
        assertEquals(0, context.pos);
    }

    @Test
    public void testDecodeWithInvalidOctet() {
        byte[] data = new byte[] { 'G' };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeDecode(data, 0, data.length, context);
        });
        assertEquals("Invalid octet in encoded value: 71", exception.getMessage());
    }

    @Test
    public void testDecodeWithTrailingCharacter() {
        byte[] data = new byte[] { '1', 'A', '2', 'B', 'C' };
        invokeDecode(data, 0, data.length, context);
        assertEquals(2, context.pos);
        assertNotEquals(0, context.ibitWorkArea);
    }

    @Test
    public void testDecodeWithHalfByteFromPreviousInvocation() {
        byte[] data = new byte[] { '1' };
        invokeDecode(data, 0, data.length, context);
        assertNotEquals(0, context.ibitWorkArea);
        assertEquals(0, context.pos);
        byte[] data2 = new byte[] { 'A' };
        invokeDecode(data2, 0, data2.length, context);
        assertEquals(1, context.pos);
        assertEquals(0, context.ibitWorkArea);
    }

    private void invokeDecode(byte[] data, int offset, int length, Context context) {
        try {
            java.lang.reflect.Method method = Base16.class.getDeclaredMethod("decode", byte[].class, int.class, int.class, Context.class);
            method.setAccessible(true);
            method.invoke(base16, data, offset, length, context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
