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

@ExtendWith(MockitoExtension.class)
class Base32_encode_4_3_Test {

    private Base32 base32;

    private Context context;

    @BeforeEach
    void setUp() {
        base32 = new Base32();
        context = new Context();
    }

    @Test
    void testEncodeWithEof() throws Exception {
        context.eof = true;
        byte[] input = { 1, 2, 3 };
        invokeEncode(input, 0, input.length, context);
        assertEquals(0, context.pos);
    }

    @Test
    void testEncodeWithInAvailLessThanZero() throws Exception {
        context.modulus = 0;
        byte[] input = { 1, 2, 3 };
        invokeEncode(input, 0, -1, context);
        assertTrue(context.eof);
        assertEquals(0, context.pos);
    }

    @Test
    void testEncodeWithModulus1() throws Exception {
        context.modulus = 1;
        context.lbitWorkArea = 0b11111111;
        byte[] input = { 1, 2, 3 };
        invokeEncode(input, 0, input.length, context);
        assertTrue(context.pos > 0);
    }

    @Test
    void testEncodeWithModulus2() throws Exception {
        context.modulus = 2;
        context.lbitWorkArea = 0b11111111;
        byte[] input = { 1, 2, 3 };
        invokeEncode(input, 0, input.length, context);
        assertTrue(context.pos > 0);
    }

    @Test
    void testEncodeWithModulus3() throws Exception {
        context.modulus = 3;
        context.lbitWorkArea = 0b11111111;
        byte[] input = { 1, 2, 3 };
        invokeEncode(input, 0, input.length, context);
        assertTrue(context.pos > 0);
    }

    @Test
    void testEncodeWithModulus4() throws Exception {
        context.modulus = 4;
        context.lbitWorkArea = 0b11111111;
        byte[] input = { 1, 2, 3 };
        invokeEncode(input, 0, input.length, context);
        assertTrue(context.pos > 0);
    }

    private void invokeEncode(byte[] input, int inPos, int inAvail, Context context) throws Exception {
        Method method = Base32.class.getDeclaredMethod("encode", byte[].class, int.class, int.class, Context.class);
        method.setAccessible(true);
        method.invoke(base32, input, inPos, inAvail, context);
    }

    class Context {

        boolean eof;

        int pos;

        int modulus;

        long lbitWorkArea;

        int currentLinePos;

        byte[] lineSeparator = new byte[] { '\n' };
    }
}
