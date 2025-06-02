package org.apache.commons.compress.compressors.snappy;

import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SnappyCompressorOutputStream_finish_2_2_Test {

    private ByteArrayOutputStream byteArrayOutputStream;

    private SnappyCompressorOutputStream snappyCompressorOutputStream;

    @BeforeEach
    void setUp() throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
        // Example size
        long uncompressedSize = 100;
        snappyCompressorOutputStream = new SnappyCompressorOutputStream(byteArrayOutputStream, uncompressedSize);
    }

    @Test
    void testFinishNotFinished() throws IOException {
        // Ensure that the stream is not finished
        assertFalse(isFinished(snappyCompressorOutputStream));
        // Call finish method
        snappyCompressorOutputStream.finish();
        // Verify that the stream is now finished
        assertTrue(isFinished(snappyCompressorOutputStream));
    }

    @Test
    void testFinishAlreadyFinished() throws IOException {
        // First finish the stream
        snappyCompressorOutputStream.finish();
        // Call finish method again
        snappyCompressorOutputStream.finish();
        // Verify that the stream is still finished
        assertTrue(isFinished(snappyCompressorOutputStream));
    }

    @Test
    void testFinishCallsCompressorFinish() throws IOException {
        // Mock the LZ77Compressor to verify finish is called
        LZ77Compressor mockCompressor = new MockLZ77Compressor();
        // Use reflection to set the private compressor field
        setPrivateField(snappyCompressorOutputStream, "compressor", mockCompressor);
        // Call finish method
        snappyCompressorOutputStream.finish();
        // Verify that the finish method of LZ77Compressor was called
        assertTrue(((MockLZ77Compressor) mockCompressor).isFinishCalled());
    }

    private boolean isFinished(SnappyCompressorOutputStream stream) {
        try {
            java.lang.reflect.Method method = SnappyCompressorOutputStream.class.getDeclaredMethod("isFinished");
            method.setAccessible(true);
            return (boolean) method.invoke(stream);
        } catch (Exception e) {
            fail("Failed to invoke isFinished method: " + e.getMessage());
            // Unreachable, but required for compilation
            return false;
        }
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }

    private static class MockLZ77Compressor extends LZ77Compressor {

        private boolean finishCalled = false;

        public MockLZ77Compressor() {
            super(Parameters.builder(1024).build(), block -> {
            });
        }

        @Override
        public void finish() throws IOException {
            finishCalled = true;
            super.finish();
        }

        public boolean isFinishCalled() {
            return finishCalled;
        }
    }
}
