package org.apache.commons.compress.compressors.deflate64;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.compress.compressors.deflate64.HuffmanState.DYNAMIC_CODES;
import static org.apache.commons.compress.compressors.deflate64.HuffmanState.FIXED_CODES;
import static org.apache.commons.compress.compressors.deflate64.HuffmanState.INITIAL;
import static org.apache.commons.compress.compressors.deflate64.HuffmanState.STORED;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.lang3.ArrayFill;

@ExtendWith(MockitoExtension.class)
class HuffmanDecoder_readBits_10_0_Test {

    private HuffmanDecoder decoder;

    private BitInputStream mockBitInputStream;

    @BeforeEach
    void setUp() {
        // Create a ByteArrayInputStream to simulate input data
        InputStream inputStream = new ByteArrayInputStream(new byte[] { (byte) 0b10101010, (byte) 0b01010101 });
        decoder = new HuffmanDecoder(inputStream);
    }

    @Test
    void testReadBits() throws Exception {
        // Use reflection to access the private method readBits(int)
        long result = invokeReadBits(decoder, 8);
        assertEquals(0b10101010, result);
        result = invokeReadBits(decoder, 8);
        assertEquals(0b01010101, result);
    }

    @Test
    void testReadBitsEOFException() {
        // Simulate an EOFException by providing an empty input stream
        InputStream emptyInputStream = new ByteArrayInputStream(new byte[] {});
        decoder = new HuffmanDecoder(emptyInputStream);
        Exception exception = assertThrows(EOFException.class, () -> {
            invokeReadBits(decoder, 8);
        });
        assertEquals("Truncated Deflate64 Stream", exception.getMessage());
    }

    private long invokeReadBits(HuffmanDecoder decoder, int numBits) throws Exception {
        Method method = HuffmanDecoder.class.getDeclaredMethod("readBits", int.class);
        method.setAccessible(true);
        return (long) method.invoke(decoder, numBits);
    }
}
