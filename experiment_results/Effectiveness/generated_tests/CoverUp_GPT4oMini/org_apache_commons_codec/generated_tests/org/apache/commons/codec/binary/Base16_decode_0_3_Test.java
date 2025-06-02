package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.Base16;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base16_decode_0_3_Test {

    private Base16 base16;

    private Context context;

    @BeforeEach
    void setUp() {
        base16 = new Base16();
        context = new Context();
    }

    @Test
    void testDecodeWithValidInput() throws Exception {
        byte[] data = new byte[] { '1', 'A', '2', 'B' };
        context.pos = 0;
        context.ibitWorkArea = 0;
        invokeDecode(data, 0, data.length, context);
        assertEquals(2, context.pos);
        assertEquals(0, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithSingleOctet() throws Exception {
        byte[] data = new byte[] { '1' };
        context.pos = 0;
        context.ibitWorkArea = 0;
        invokeDecode(data, 0, data.length, context);
        assertEquals(0, context.pos);
        assertEquals(1, context.ibitWorkArea);
    }

    @Test
    void testDecodeWithEofFlag() throws Exception {
        byte[] data = new byte[] { '1', 'A' };
        context.eof = true;
        invokeDecode(data, 0, data.length, context);
        assertTrue(context.eof);
        assertEquals(0, context.pos);
    }

    @Test
    void testDecodeWithNegativeLength() throws Exception {
        byte[] data = new byte[] { '1', 'A' };
        context.pos = 0;
        context.ibitWorkArea = 0;
        invokeDecode(data, 0, -1, context);
        assertTrue(context.eof);
        assertEquals(0, context.pos);
    }

    @Test
    void testDecodeWithTrailingCharacter() throws Exception {
        byte[] data = new byte[] { '1', 'A', 'C' };
        context.pos = 0;
        context.ibitWorkArea = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            invokeDecode(data, 0, data.length, context);
        });
    }

    @Test
    void testDecodeWithInvalidOctet() throws Exception {
        byte[] data = new byte[] { 'G', 'H' };
        context.pos = 0;
        context.ibitWorkArea = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            invokeDecode(data, 0, data.length, context);
        });
    }

    private void invokeDecode(byte[] data, int offset, int length, Context context) throws Exception {
        Method decodeMethod = Base16.class.getDeclaredMethod("decode", byte[].class, int.class, int.class, Context.class);
        decodeMethod.setAccessible(true);
        decodeMethod.invoke(base16, data, offset, length, context);
    }

    private static class Context {

        boolean eof;

        int pos;

        int ibitWorkArea;
    }
}
