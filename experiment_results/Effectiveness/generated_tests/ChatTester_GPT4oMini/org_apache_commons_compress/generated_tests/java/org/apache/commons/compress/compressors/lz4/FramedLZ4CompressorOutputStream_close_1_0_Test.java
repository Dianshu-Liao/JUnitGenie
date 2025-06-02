package org.apache.commons.compress.compressors.lz4;

import java.io.IOException;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.utils.ByteUtils;

public class FramedLZ4CompressorOutputStream_close_1_0_Test {

    private FramedLZ4CompressorOutputStream compressorOutputStream;

    private OutputStream mockOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        mockOutputStream = Mockito.mock(OutputStream.class);
        compressorOutputStream = new FramedLZ4CompressorOutputStream(mockOutputStream);
    }

    @Test
    public void testClose() throws Exception {
        // Arrange
        doNothing().when(mockOutputStream).close();
        // Invoke the private method 'finish' using reflection
        java.lang.reflect.Method finishMethod = FramedLZ4CompressorOutputStream.class.getDeclaredMethod("finish");
        finishMethod.setAccessible(true);
        // Act
        compressorOutputStream.close();
        // Assert
        verify(mockOutputStream, times(1)).close();
        // Verify that finish() was called
        // Since finish() is not public, we can't verify it directly.
        // You might want to use a spy or an internal mechanism to check if it was executed.
    }

    @Test
    public void testCloseThrowsIOException() throws Exception {
        // Arrange
        doThrow(new IOException("Output stream close failed")).when(mockOutputStream).close();
        // Act & Assert
        assertThrows(IOException.class, () -> {
            compressorOutputStream.close();
        });
        verify(mockOutputStream, times(1)).close();
    }
}
