package org.apache.commons.compress.compressors.bzip2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class BZip2CompressorOutputStream_bsFinishedWithStream_4_1_Test {

    private ByteArrayOutputStream outputStream;

    private TestBZip2CompressorOutputStream compressorOutputStream;

    private static class TestBZip2CompressorOutputStream extends BZip2CompressorOutputStream {

        public TestBZip2CompressorOutputStream(ByteArrayOutputStream out) throws IOException {
            super(out);
        }

        public void setBsBuff(int value) {
            // Using reflection to set private bsBuff
            try {
                java.lang.reflect.Field field = BZip2CompressorOutputStream.class.getDeclaredField("bsBuff");
                field.setAccessible(true);
                field.setInt(this, value);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void setBsLive(int value) {
            // Using reflection to set private bsLive
            try {
                java.lang.reflect.Field field = BZip2CompressorOutputStream.class.getDeclaredField("bsLive");
                field.setAccessible(true);
                field.setInt(this, value);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void callBsFinishedWithStream() throws IOException {
            // Using reflection to call private bsFinishedWithStream
            try {
                java.lang.reflect.Method method = BZip2CompressorOutputStream.class.getDeclaredMethod("bsFinishedWithStream");
                method.setAccessible(true);
                method.invoke(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @BeforeEach
    public void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        compressorOutputStream = new TestBZip2CompressorOutputStream(outputStream);
    }

    @Test
    public void testBsFinishedWithStream_WhenBsLiveIsZero() throws IOException {
        // Arrange
        compressorOutputStream.setBsBuff(0);
        compressorOutputStream.setBsLive(0);
        // Act
        compressorOutputStream.callBsFinishedWithStream();
        // Assert
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testBsFinishedWithStream_WhenBsLiveIsGreaterThanZero() throws IOException {
        // Arrange
        compressorOutputStream.setBsBuff(0xFF000000);
        compressorOutputStream.setBsLive(8);
        // Act
        compressorOutputStream.callBsFinishedWithStream();
        // Assert
        byte[] expectedOutput = new byte[] { (byte) 0xFF };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }
}
