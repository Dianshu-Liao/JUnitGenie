package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

class Base16_decode_0_4_Test {

    private Base16 base16;

    private Context context;

    @BeforeEach
    void setUp() {
        base16 = new Base16();
        context = new Context();
    }

    @Test
    void testDecode_WithValidInput() throws Exception {
        byte[] data = new byte[] { '4', '1', '5', '2' };
        context.pos = 0;
        base16.decode(data, 0, data.length, context);
        assertEquals(2, context.pos);
        assertEquals(0x41, context.buffer[0]);
        assertEquals(0x52, context.buffer[1]);
    }

    @Test
    void testDecode_WithOddLengthInput() throws Exception {
        byte[] data = new byte[] { '4', '1', '5' };
        context.pos = 0;
        base16.decode(data, 0, data.length, context);
        assertEquals(1, context.pos);
        assertEquals(0x41, context.buffer[0]);
        assertEquals(1, context.ibitWorkArea);
    }

    @Test
    void testDecode_WithEofContext() throws Exception {
        byte[] data = new byte[] { '4', '1', '5', '2' };
        context.eof = true;
        base16.decode(data, 0, data.length, context);
        assertTrue(context.eof);
        assertEquals(0, context.pos);
    }

    @Test
    void testDecode_WithNegativeLength() throws Exception {
        byte[] data = new byte[] { '4', '1', '5', '2' };
        context.pos = 0;
        base16.decode(data, 0, -1, context);
        assertTrue(context.eof);
        assertEquals(0, context.pos);
    }

    @Test
    void testDecode_WithTrailingCharacter() throws Exception {
        byte[] data = new byte[] { '4', '1', '5' };
        context.pos = 0;
        context.ibitWorkArea = 1;
        assertThrows(IllegalArgumentException.class, () -> {
            invokePrivateMethod("validateTrailingCharacter");
        });
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = Base16.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(base16);
    }

    private static class Context extends BaseNCodec.Context {

        boolean eof = false;

        int pos = 0;

        int ibitWorkArea = 0;

        byte[] buffer = new byte[1024];
    }
}
