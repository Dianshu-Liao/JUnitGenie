package org.apache.commons.compress.compressors.gzip;

import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipParameters;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

class GzipCompressorOutputStream_close_0_0_Test {

    private GzipCompressorOutputStream gzipCompressorOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        gzipCompressorOutputStream = new GzipCompressorOutputStream(outputStream);
    }

    @Test
    void testClose_whenNotClosed() throws Exception {
        // Invoke close method using reflection
        Method closeMethod = GzipCompressorOutputStream.class.getDeclaredMethod("close");
        closeMethod.setAccessible(true);
        closeMethod.invoke(gzipCompressorOutputStream);
        // Check if the output stream is closed
        assertThrows(IOException.class, () -> outputStream.write(1));
    }

    @Test
    void testClose_whenAlreadyClosed() throws Exception {
        // Close once
        Method closeMethod = GzipCompressorOutputStream.class.getDeclaredMethod("close");
        closeMethod.setAccessible(true);
        closeMethod.invoke(gzipCompressorOutputStream);
        // Close again, should not throw an exception
        closeMethod.invoke(gzipCompressorOutputStream);
    }

    @Test
    void testClose_withFinish() throws Exception {
        // Invoke finish method using reflection
        Method finishMethod = GzipCompressorOutputStream.class.getDeclaredMethod("finish");
        finishMethod.setAccessible(true);
        finishMethod.invoke(gzipCompressorOutputStream);
        // Now close the stream
        Method closeMethod = GzipCompressorOutputStream.class.getDeclaredMethod("close");
        closeMethod.setAccessible(true);
        closeMethod.invoke(gzipCompressorOutputStream);
        // Check if the output stream is closed
        assertThrows(IOException.class, () -> outputStream.write(1));
    }

    @Test
    void testClose_withExceptionInFinish() throws Exception {
        // Create a subclass to override finish method
        GzipCompressorOutputStream mockGzipCompressorOutputStream = Mockito.mock(GzipCompressorOutputStream.class, Mockito.withSettings().useConstructor(new OutputStream() {

            @Override
            public void write(int b) throws IOException {
                // Mock output stream
            }
        }).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        Method finishMethod = GzipCompressorOutputStream.class.getDeclaredMethod("finish");
        finishMethod.setAccessible(true);
        Mockito.doThrow(new IOException("Finish exception")).when(mockGzipCompressorOutputStream).finish();
        Method closeMethod = GzipCompressorOutputStream.class.getDeclaredMethod("close");
        closeMethod.setAccessible(true);
        // Close the stream and catch the exception
        IOException exception = assertThrows(IOException.class, () -> closeMethod.invoke(mockGzipCompressorOutputStream));
        assertEquals("Finish exception", exception.getMessage());
    }
}
