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

public class FramedLZ4CompressorOutputStream_FramedLZ4CompressorOutputStream_8_0_Test {

    @Test
    public void testConstructorWithValidOutputStream() throws IOException {
        // Arrange
        OutputStream outputStream = new ByteArrayOutputStream();
        // Act
        FramedLZ4CompressorOutputStream compressorOutputStream = new FramedLZ4CompressorOutputStream(outputStream);
        // Assert
        assertNotNull(compressorOutputStream);
    }

    @Test
    public void testConstructorWithNullOutputStream() {
        // Arrange
        OutputStream outputStream = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            new FramedLZ4CompressorOutputStream(outputStream);
        });
    }

    @Test
    public void testConstructorWithIOException() {
        // Arrange
        OutputStream faultyOutputStream = new OutputStream() {

            @Override
            public void write(int b) throws IOException {
                throw new IOException("Output stream error");
            }
        };
        // Act & Assert
        assertThrows(IOException.class, () -> {
            new FramedLZ4CompressorOutputStream(faultyOutputStream);
        });
    }
}
