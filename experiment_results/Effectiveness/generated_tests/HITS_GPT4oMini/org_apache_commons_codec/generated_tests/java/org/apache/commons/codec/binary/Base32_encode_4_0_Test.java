package org.apache.commons.codec.binary;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base32_encode_4_0_Test {

    private Base32 base32;

    private TestContext context;

    @BeforeEach
    public void setUp() {
        base32 = new Base32();
        context = new TestContext();
    }

    @Test
    public void testEncodeWithEmptyInput() {
        byte[] input = new byte[0];
        byte[] expected = new byte[0];
        base32.encode(input, 0, input.length, context);
        assertArrayEquals(expected, context.buffer);
    }

    @Test
    public void testEncodeWithSingleByte() {
        byte[] input = new byte[] { (byte) 0xFF };
        byte[] expected = new byte[] { '7', 'A', '=', '=', '=', '=', '=', '=' };
        base32.encode(input, 0, input.length, context);
        assertArrayEquals(expected, context.buffer);
    }

    @Test
    public void testEncodeWithMultipleBytes() {
        byte[] input = new byte[] { (byte) 0x48, (byte) 0x65, (byte) 0x6C, (byte) 0x6C, (byte) 0x6F };
        byte[] expected = new byte[] { 'N', 'S', 'W', 'D', 'E', '3', 'A', '=', '=' };
        base32.encode(input, 0, input.length, context);
        assertArrayEquals(expected, context.buffer);
    }

    @Test
    public void testEncodeWithEndOfFile() {
        byte[] input = new byte[] { (byte) 0x48, (byte) 0x65 };
        context.eof = true;
        base32.encode(input, 0, input.length, context);
        assertEquals(0, context.pos);
    }

    @Test
    public void testEncodeWithLineSeparator() {
        byte[] input = new byte[] { (byte) 0x48, (byte) 0x65, (byte) 0x6C, (byte) 0x6C, (byte) 0x6F };
        base32 = new Base32(5, new byte[] { '\n' });
        byte[] expected = new byte[] { 'N', 'S', 'W', 'D', 'E', '3', 'A', '=', '\n' };
        base32.encode(input, 0, input.length, context);
        assertArrayEquals(expected, context.buffer);
    }

    private static class TestContext extends BaseNCodec.Context {

        public byte[] buffer = new byte[64];

        public int pos = 0;

        public boolean eof = false;

        public int modulus = 0;

        public long lbitWorkArea = 0;

        public int currentLinePos = 0;
    }
}
