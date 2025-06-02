package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.PercentCodec;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;

public class PercentCodec_encode_6_0_Test {

    private PercentCodec percentCodec;

    @BeforeEach
    public void setUp() {
        percentCodec = new PercentCodec();
    }

    @Test
    public void testEncodeWithNull() throws EncoderException {
        assertNull(percentCodec.encode(null));
    }

    @Test
    public void testEncodeWithByteArray() throws EncoderException {
        byte[] input = new byte[] { 1, 2, 3 };
        // Assuming encode does not alter the input for this test
        byte[] expected = input;
        // Use reflection to access the private encode method
        try {
            Method encodeMethod = PercentCodec.class.getDeclaredMethod("encode", byte[].class);
            encodeMethod.setAccessible(true);
            byte[] result = (byte[]) encodeMethod.invoke(percentCodec, input);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    public void testEncodeWithUnsupportedObject() {
        Exception exception = assertThrows(EncoderException.class, () -> {
            percentCodec.encode("Unsupported String");
        });
        assertEquals("Objects of type java.lang.String cannot be Percent encoded", exception.getMessage());
    }
}
