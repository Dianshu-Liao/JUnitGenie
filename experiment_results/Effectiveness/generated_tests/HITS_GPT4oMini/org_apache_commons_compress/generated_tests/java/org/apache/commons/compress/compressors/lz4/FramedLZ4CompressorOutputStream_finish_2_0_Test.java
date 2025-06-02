package org.apache.commons.compress.compressors.lz4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.utils.ByteUtils;

class FramedLZ4CompressorOutputStream_finish_2_0_Test {

    private TestFramedLZ4CompressorOutputStream compressorStream;

    @BeforeEach
    void setUp() throws IOException {
        OutputStream out = new ByteArrayOutputStream();
        compressorStream = new TestFramedLZ4CompressorOutputStream(out);
    }

    @Test
    void testFinish() throws IOException {
        // Ensure the stream is not finished initially
        assertFalse(compressorStream.isFinished());
        // Call the finish method
        compressorStream.finish();
        // Ensure the stream is marked as finished
        assertTrue(compressorStream.isFinished());
    }

    // Inner class to expose protected methods for testing
    private static class TestFramedLZ4CompressorOutputStream extends FramedLZ4CompressorOutputStream {

        public TestFramedLZ4CompressorOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        public boolean isFinished() {
            return super.isFinished();
        }
    }
}
