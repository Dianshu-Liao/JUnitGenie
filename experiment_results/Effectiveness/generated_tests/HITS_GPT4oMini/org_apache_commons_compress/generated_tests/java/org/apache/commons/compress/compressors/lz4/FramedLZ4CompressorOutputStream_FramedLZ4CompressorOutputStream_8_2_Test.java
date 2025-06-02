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

public class FramedLZ4CompressorOutputStream_FramedLZ4CompressorOutputStream_8_2_Test {

    private ByteArrayOutputStream outputStream;

    private FramedLZ4CompressorOutputStream.Parameters params;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Assuming Parameters.DEFAULT is a valid instance
        params = FramedLZ4CompressorOutputStream.Parameters.DEFAULT;
    }

    @Test
    public void testFramedLZ4CompressorOutputStream_ValidOutputStream() throws IOException {
        FramedLZ4CompressorOutputStream compressorOutputStream = new FramedLZ4CompressorOutputStream(outputStream);
        assertNotNull(compressorOutputStream);
    }

    @Test
    public void testFramedLZ4CompressorOutputStream_ValidOutputStream_WithParams() throws IOException {
        FramedLZ4CompressorOutputStream compressorOutputStream = new FramedLZ4CompressorOutputStream(outputStream, params);
        assertNotNull(compressorOutputStream);
    }

    @Test
    public void testFramedLZ4CompressorOutputStream_NullOutputStream() {
        assertThrows(NullPointerException.class, () -> {
            new FramedLZ4CompressorOutputStream(null);
        });
    }

    @Test
    public void testFramedLZ4CompressorOutputStream_NullParams() throws IOException {
        assertThrows(NullPointerException.class, () -> {
            new FramedLZ4CompressorOutputStream(outputStream, null);
        });
    }

    @Test
    public void testFramedLZ4CompressorOutputStream_IOException() throws IOException {
        // Create a mock OutputStream that throws IOException
        OutputStream mockOutputStream = new OutputStream() {

            @Override
            public void write(int b) throws IOException {
                throw new IOException("Mock IOException");
            }
        };
        assertThrows(IOException.class, () -> {
            new FramedLZ4CompressorOutputStream(mockOutputStream);
        });
    }
}
