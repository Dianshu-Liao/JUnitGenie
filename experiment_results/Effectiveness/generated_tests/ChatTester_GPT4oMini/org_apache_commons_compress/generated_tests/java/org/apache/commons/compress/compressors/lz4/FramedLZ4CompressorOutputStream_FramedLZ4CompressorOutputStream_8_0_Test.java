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

    private OutputStream mockOutputStream;

    @BeforeEach
    public void setUp() {
        mockOutputStream = mock(OutputStream.class);
    }

    @Test
    public void testConstructorWithOutputStream() throws IOException {
        // Act
        FramedLZ4CompressorOutputStream compressorOutputStream = new FramedLZ4CompressorOutputStream(mockOutputStream);
        // Assert
        assertNotNull(compressorOutputStream);
    }

    @Test
    public void testConstructorWithOutputStreamThrowsIOException() {
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
