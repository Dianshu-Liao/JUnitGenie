package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base16;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Base16_decode_0_2_Test {

    private Base16 base16;

    private Context context;

    @BeforeEach
    void setUp() {
        base16 = new Base16();
        context = new Context();
    }

    @Test
    void testDecodeWithEofSet() throws Exception {
        context.eof = true;
        byte[] data = { '1', '2' };
        invokeDecode(data, 0, 2, context);
        assertTrue(context.eof);
        assertEquals(0, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithNegativeLength() throws Exception {
        byte[] data = { '1', '2' };
        invokeDecode(data, 0, -1, context);
        assertTrue(context.eof);
        assertEquals(0, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithSingleOctet() throws Exception {
        byte[] data = { '1' };
        invokeDecode(data, 0, 1, context);
        assertEquals(1, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithTwoOctets() throws Exception {
        byte[] data = { '1', '2' };
        invokeDecode(data, 0, 2, context);
        assertEquals(0, context.ibitWorkArea);
        assertEquals(1, context.pos);
    }

    @Test
    void testDecodeWithOddLengthData() throws Exception {
        byte[] data = { '1', '2', '3' };
        invokeDecode(data, 0, 3, context);
        assertEquals(1, context.ibitWorkArea);
        assertEquals(1, context.pos);
    }

    @Test
    void testDecodeWithFullData() throws Exception {
        byte[] data = { '1', '2', '3', '4' };
        invokeDecode(data, 0, 4, context);
        assertEquals(0, context.ibitWorkArea);
        assertEquals(2, context.pos);
    }

    @Test
    void testDecodeWithInvalidOctet() {
        // 'G' is invalid
        byte[] data = { '1', 'G' };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeDecode(data, 0, 2, context);
        });
        assertEquals("Invalid octet in encoded value: 71", exception.getMessage());
    }

    private void invokeDecode(byte[] data, int offset, int length, Context context) throws Exception {
        Method decodeMethod = Base16.class.getDeclaredMethod("decode", byte[].class, int.class, int.class, BaseNCodec.Context.class);
        decodeMethod.setAccessible(true);
        decodeMethod.invoke(base16, data, offset, length, context);
    }

    // Context class to simulate the one used in the decode method.
    static class Context extends BaseNCodec.Context {

        boolean eof;

        int ibitWorkArea;

        int pos;

        Context() {
            eof = false;
            ibitWorkArea = 0;
            pos = 0;
        }
    }
}
