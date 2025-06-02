package org.apache.commons.compress.compressors.deflate64;

import org.apache.commons.compress.utils.BitInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.io.EOFException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.compress.compressors.deflate64.HuffmanState.DYNAMIC_CODES;
import static org.apache.commons.compress.compressors.deflate64.HuffmanState.FIXED_CODES;
import static org.apache.commons.compress.compressors.deflate64.HuffmanState.INITIAL;
import static org.apache.commons.compress.compressors.deflate64.HuffmanState.STORED;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.lang3.ArrayFill;

class HuffmanDecoder_readBits_4_2_Test {

    private HuffmanDecoder huffmanDecoder;

    @BeforeEach
    void setUp() {
        // Initialize HuffmanDecoder with a ByteArrayInputStream
        byte[] input = new byte[] { (byte) 0b11001010, (byte) 0b10101011 };
        huffmanDecoder = new HuffmanDecoder(new ByteArrayInputStream(input));
    }

    @Test
    void testReadBits_validInput() throws IOException {
        // Test reading 8 bits
        long result = readBitsFromDecoder(8);
        assertEquals(0b11001010L, result);
    }

    @Test
    void testReadBits_partialByte() throws IOException {
        // Test reading 4 bits
        long result = readBitsFromDecoder(4);
        assertEquals(0b1100L, result);
    }

    @Test
    void testReadBits_exceedingCacheSize() {
        // Test reading more bits than the maximum cache size
        assertThrows(IOException.class, () -> {
            readBitsFromDecoder(64);
        });
    }

    @Test
    void testReadBits_eofException() {
        // Test reading bits when the stream is exhausted
        huffmanDecoder = new HuffmanDecoder(new ByteArrayInputStream(new byte[0]));
        assertThrows(EOFException.class, () -> {
            readBitsFromDecoder(8);
        });
    }

    private long readBitsFromDecoder(int numBits) throws IOException {
        // This method uses reflection to access the private readBits method
        try {
            Method method = HuffmanDecoder.class.getDeclaredMethod("readBits", BitInputStream.class, int.class);
            method.setAccessible(true);
            BitInputStream bitInputStream = new BitInputStream(new ByteArrayInputStream(new byte[] { (byte) 0b11001010, (byte) 0b10101011 }), ByteOrder.BIG_ENDIAN);
            return (long) method.invoke(huffmanDecoder, bitInputStream, numBits);
        } catch (Exception e) {
            throw new IOException("Failed to read bits", e);
        }
    }
}
