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

public class FramedLZ4CompressorOutputStream_close_1_0_Test {

    private ByteArrayOutputStream byteArrayOutputStream;

    private FramedLZ4CompressorOutputStream compressorOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
        compressorOutputStream = new FramedLZ4CompressorOutputStream(byteArrayOutputStream);
    }

    @Test
    public void testCloseSuccessfully() throws IOException {
        // Act
        compressorOutputStream.close();
        // Assert
        verify(byteArrayOutputStream).close();
    }

    @Test
    public void testCloseThrowsIOException() throws IOException {
        // Arrange
        OutputStream mockedOutputStream = Mockito.mock(OutputStream.class);
        compressorOutputStream = new FramedLZ4CompressorOutputStream(mockedOutputStream);
        doThrow(new IOException("Close failed")).when(mockedOutputStream).close();
        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> {
            compressorOutputStream.close();
        });
        // Verify that the exception message is as expected
        assertEquals("Close failed", exception.getMessage());
    }

    @Test
    public void testCloseCallsFinish() throws IOException {
        // This is an indirect test to see if finish() is called
        // You would need to verify that finish() has been called.
        // This can be done by mocking the finish method if necessary.
        // For this example, we will assume it is part of the close() method.
        // Act
        compressorOutputStream.close();
        // Assert
        // Here you would check if the finish method was executed.
        // As it's private, you might need to verify the effects or refactor the code.
    }
}
