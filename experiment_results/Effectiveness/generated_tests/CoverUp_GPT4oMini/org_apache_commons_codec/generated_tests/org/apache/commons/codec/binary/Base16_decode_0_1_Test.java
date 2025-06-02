package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base16;
import java.lang.reflect.Method;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.CodecPolicy;

class Base16_decode_0_1_Test {

    private Base16 base16;

    private Context context;

    @BeforeEach
    void setUp() {
        base16 = new Base16();
        context = new Context();
    }

    @Test
    void testDecodeWithValidInput() throws Exception {
        byte[] input = new byte[] { '1', '2', 'A', 'B' };
        context.ibitWorkArea = 0;
        context.pos = 0;
        invokeDecode(input, 0, input.length, context);
        assertEquals(2, context.pos);
        assertEquals(0, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithOddLengthInput() throws Exception {
        byte[] input = new byte[] { '1', '2', 'A' };
        context.ibitWorkArea = 0;
        context.pos = 0;
        invokeDecode(input, 0, input.length, context);
        assertEquals(1, context.pos);
        assertTrue(context.ibitWorkArea > 0);
    }

    @Test
    void testDecodeWithEofFlagSet() throws Exception {
        byte[] input = new byte[] { '1', '2' };
        context.ibitWorkArea = 0;
        context.eof = true;
        invokeDecode(input, 0, input.length, context);
        assertTrue(context.eof);
        assertEquals(0, context.pos);
    }

    @Test
    void testDecodeWithNegativeLength() throws Exception {
        byte[] input = new byte[] { '1', '2', 'A', 'B' };
        context.ibitWorkArea = 0;
        context.pos = 0;
        invokeDecode(input, 0, -1, context);
        assertTrue(context.eof);
        assertEquals(0, context.pos);
    }

    @Test
    void testDecodeWithEmptyInput() throws Exception {
        byte[] input = new byte[] {};
        context.ibitWorkArea = 0;
        context.pos = 0;
        invokeDecode(input, 0, 0, context);
        assertEquals(0, context.pos);
        assertEquals(0, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithInvalidOctet() throws Exception {
        // 'G' is not a valid hex character
        byte[] input = new byte[] { 'G' };
        context.ibitWorkArea = 0;
        context.pos = 0;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeDecode(input, 0, input.length, context);
        });
        assertEquals("Invalid octet in encoded value: 71", exception.getMessage());
    }

    private void invokeDecode(byte[] data, int offset, int length, Context context) throws Exception {
        Method decodeMethod = Base16.class.getDeclaredMethod("decode", byte[].class, int.class, int.class, Context.class);
        decodeMethod.setAccessible(true);
        decodeMethod.invoke(base16, data, offset, length, context);
    }

    private class Context {

        boolean eof = false;

        int ibitWorkArea = 0;

        int pos = 0;
    }
}
