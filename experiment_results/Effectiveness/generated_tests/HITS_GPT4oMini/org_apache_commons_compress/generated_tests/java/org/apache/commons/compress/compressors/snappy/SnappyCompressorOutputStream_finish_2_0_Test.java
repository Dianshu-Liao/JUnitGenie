package org.apache.commons.compress.compressors.snappy;

import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

class SnappyCompressorOutputStream_finish_2_0_Test {

    private ByteArrayOutputStream byteArrayOutputStream;

    private TestableSnappyCompressorOutputStream snappyCompressorOutputStream;

    @BeforeEach
    void setUp() throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
        long uncompressedSize = 100;
        snappyCompressorOutputStream = new TestableSnappyCompressorOutputStream(byteArrayOutputStream, uncompressedSize);
    }

    @Test
    void testFinish_WhenNotFinished_ShouldCallCompressorFinish() throws IOException {
        assertFalse(snappyCompressorOutputStream.isFinished());
        snappyCompressorOutputStream.finish();
        assertTrue(snappyCompressorOutputStream.isFinished());
    }

    @Test
    void testFinish_WhenAlreadyFinished_ShouldNotCallCompressorFinishAgain() throws IOException {
        snappyCompressorOutputStream.finish();
        boolean alreadyFinished = snappyCompressorOutputStream.isFinished();
        snappyCompressorOutputStream.finish();
        assertTrue(alreadyFinished);
        assertTrue(snappyCompressorOutputStream.isFinished());
    }

    @Test
    void testFinish_ShouldNotThrowIOException() {
        assertDoesNotThrow(() -> snappyCompressorOutputStream.finish());
    }

    @Test
    void testFinish_WithOutputStream_ShouldWriteToOutputStream() throws IOException {
        snappyCompressorOutputStream.write(new byte[] { 1, 2, 3, 4, 5 });
        snappyCompressorOutputStream.finish();
        byte[] outputData = byteArrayOutputStream.toByteArray();
        assertEquals(5, outputData.length);
    }

    @Test
    void testFinish_WhenIOExceptionOccurs_ShouldPropagateIOException() {
        assertThrows(IOException.class, () -> {
            SnappyCompressorOutputStream faultyStream = new SnappyCompressorOutputStream(byteArrayOutputStream, 0) {

                @Override
                public void finish() throws IOException {
                    throw new IOException("Simulated IOException");
                }
            };
            faultyStream.finish();
        });
    }

    private static class TestableSnappyCompressorOutputStream extends SnappyCompressorOutputStream {

        public TestableSnappyCompressorOutputStream(ByteArrayOutputStream out, long uncompressedSize) throws IOException {
            super(out, uncompressedSize);
        }

        public boolean isFinished() {
            return super.isFinished();
        }
    }
}
