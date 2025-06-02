package org.apache.commons.compress.compressors.lz4;

import org.apache.commons.compress.compressors.lz77support.Parameters;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Deque;
import java.util.LinkedList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.utils.ByteUtils;

@ExtendWith(MockitoExtension.class)
class BlockLZ4CompressorOutputStream_writeFinalLiteralBlock_17_2_Test {

    private BlockLZ4CompressorOutputStream compressorOutputStream;

    private ByteArrayOutputStream outputStream;

    private class Pair {

        private boolean written;

        private int length;

        public Pair(int length) {
            this.length = length;
            this.written = false;
        }

        public boolean hasBeenWritten() {
            return written;
        }

        public int length() {
            return length;
        }

        public void writeTo(OutputStream out) throws IOException {
            written = true;
            out.write(new byte[length]);
        }
    }

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        compressorOutputStream = new BlockLZ4CompressorOutputStream(outputStream);
    }

    @Test
    void testWriteFinalLiteralBlock() throws Exception {
        // Setup the necessary mocks and state
        Method rewriteLastPairsMethod = BlockLZ4CompressorOutputStream.class.getDeclaredMethod("rewriteLastPairs");
        rewriteLastPairsMethod.setAccessible(true);
        // Mocking Pair class and its methods
        Pair mockPair1 = mock(Pair.class);
        Pair mockPair2 = mock(Pair.class);
        when(mockPair1.hasBeenWritten()).thenReturn(false);
        when(mockPair1.length()).thenReturn(5);
        doAnswer(invocation -> {
            OutputStream out = invocation.getArgument(0);
            out.write(new byte[] { 1, 2, 3, 4, 5 });
            return null;
        }).when(mockPair1).writeTo(any(OutputStream.class));
        when(mockPair2.hasBeenWritten()).thenReturn(false);
        when(mockPair2.length()).thenReturn(3);
        doAnswer(invocation -> {
            OutputStream out = invocation.getArgument(0);
            out.write(new byte[] { 6, 7, 8 });
            return null;
        }).when(mockPair2).writeTo(any(OutputStream.class));
        // Access the private pairs field using reflection
        Field pairsField = BlockLZ4CompressorOutputStream.class.getDeclaredField("pairs");
        pairsField.setAccessible(true);
        Deque<Pair> pairs = (Deque<Pair>) pairsField.get(compressorOutputStream);
        // Add the pairs to the compressor
        pairs.add(mockPair1);
        pairs.add(mockPair2);
        // Invoke the private method using reflection
        Method writeFinalLiteralBlockMethod = BlockLZ4CompressorOutputStream.class.getDeclaredMethod("writeFinalLiteralBlock");
        writeFinalLiteralBlockMethod.setAccessible(true);
        writeFinalLiteralBlockMethod.invoke(compressorOutputStream);
        // Verify that the pairs were written to the output stream
        byte[] expectedOutput = { 1, 2, 3, 4, 5, 6, 7, 8 };
        byte[] actualOutput = outputStream.toByteArray();
        // Assert the output
        assertArrayEquals(expectedOutput, actualOutput);
        // Verify that pairs were cleared after writing
        verify(mockPair1, times(1)).writeTo(any(OutputStream.class));
        verify(mockPair2, times(1)).writeTo(any(OutputStream.class));
        assertTrue(pairs.isEmpty());
    }
}
