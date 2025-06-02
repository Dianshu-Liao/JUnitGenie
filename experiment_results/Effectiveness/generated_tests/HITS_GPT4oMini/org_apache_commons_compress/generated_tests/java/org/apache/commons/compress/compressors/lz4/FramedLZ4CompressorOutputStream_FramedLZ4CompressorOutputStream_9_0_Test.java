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

public class FramedLZ4CompressorOutputStream_FramedLZ4CompressorOutputStream_9_0_Test {

    private ByteArrayOutputStream outputStream;

    private FramedLZ4CompressorOutputStream.Parameters parameters;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        parameters = FramedLZ4CompressorOutputStream.Parameters.DEFAULT;
    }

    @Test
    public void testFramedLZ4CompressorOutputStream_ValidOutputStream() throws IOException {
        FramedLZ4CompressorOutputStream compressorOutputStream = new FramedLZ4CompressorOutputStream(outputStream, parameters);
        assertNotNull(compressorOutputStream);
    }

    @Test
    public void testFramedLZ4CompressorOutputStream_NullOutputStream() {
        assertThrows(NullPointerException.class, () -> {
            new FramedLZ4CompressorOutputStream(null, parameters);
        });
    }

    @Test
    public void testFramedLZ4CompressorOutputStream_NullParameters() throws IOException {
        FramedLZ4CompressorOutputStream compressorOutputStream = new FramedLZ4CompressorOutputStream(outputStream, null);
        assertNotNull(compressorOutputStream);
    }

    @Test
    public void testFramedLZ4CompressorOutputStream_IOExceptionThrown() {
        OutputStream faultyOutputStream = new OutputStream() {

            @Override
            public void write(int b) throws IOException {
                throw new IOException("Forced IOException");
            }
        };
        assertThrows(IOException.class, () -> {
            new FramedLZ4CompressorOutputStream(faultyOutputStream, parameters);
        });
    }
}
