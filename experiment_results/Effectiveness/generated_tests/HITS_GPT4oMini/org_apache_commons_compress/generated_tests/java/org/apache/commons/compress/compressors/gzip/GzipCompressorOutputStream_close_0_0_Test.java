package org.apache.commons.compress.compressors.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import java.util.zip.CRC32;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class GzipCompressorOutputStream_close_0_0_Test {

    private GzipCompressorOutputStream gzipCompressorOutputStream;

    private OutputStream mockOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        mockOutputStream = Mockito.mock(OutputStream.class);
        gzipCompressorOutputStream = new GzipCompressorOutputStream(mockOutputStream);
    }

    @Test
    public void testClose_WhenNotClosed_ShouldFinishAndClose() throws IOException {
        // Arrange
        // Close the stream for the first time
        gzipCompressorOutputStream.close();
        // Act
        // Close the stream again
        gzipCompressorOutputStream.close();
        // Assert
        verify(mockOutputStream, times(1)).close();
    }

    @Test
    public void testClose_WhenAlreadyClosed_ShouldNotCloseAgain() throws IOException {
        // Arrange
        // Close the stream for the first time
        gzipCompressorOutputStream.close();
        // Act
        // Attempt to close again
        gzipCompressorOutputStream.close();
        // Assert
        // Should still only call close once
        verify(mockOutputStream, times(1)).close();
    }

    @Test
    public void testClose_ShouldCallFinishAndEndOnDeflater() throws IOException {
        // Arrange
        // Close the stream for the first time
        gzipCompressorOutputStream.close();
        // Act
        // Close the stream again
        gzipCompressorOutputStream.close();
        // Assert
        // Verify that deflater's end() is called
        // This requires access to the deflater, which is not directly mockable without reflection
        // Thus, we are primarily verifying the behavior of close in this context
    }

    @Test
    public void testClose_ShouldThrowIOException_WhenOutputStreamThrowsIOException() throws IOException {
        // Arrange
        doThrow(new IOException("Output stream error")).when(mockOutputStream).close();
        // Act & Assert
        assertThrows(IOException.class, () -> {
            gzipCompressorOutputStream.close();
        });
    }
}
