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

public class BZip2CompressorOutputStream_bsFinishedWithStream_4_0_Test {

    private BZip2CompressorOutputStream compressorOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        compressorOutputStream = new BZip2CompressorOutputStream(outputStream);
    }

    @Test
    public void testBsFinishedWithStream_WithNoBitsLeft() throws IOException {
        // Act
        compressorOutputStream.finish();
        // Assert
        assertEquals(0, outputStream.size());
    }

    @Test
    public void testBsFinishedWithStream_WithBitsLeft() throws IOException {
        // Simulate writing 8 bits
        // Write 1 byte
        compressorOutputStream.write(0xFF);
        compressorOutputStream.finish();
        // Assert
        assertEquals(1, outputStream.size());
        assertEquals((byte) 0xFF, outputStream.toByteArray()[0]);
    }

    @Test
    public void testBsFinishedWithStream_MultipleWrites() throws IOException {
        // Simulate writing 16 bits
        // Write first byte
        compressorOutputStream.write(0xFF);
        // Write second byte
        compressorOutputStream.write(0xFF);
        compressorOutputStream.finish();
        // Assert
        assertEquals(2, outputStream.size());
        assertEquals((byte) 0xFF, outputStream.toByteArray()[0]);
        assertEquals((byte) 0xFF, outputStream.toByteArray()[1]);
    }

    @Test
    public void testBsFinishedWithStream_IncompleteByte() throws IOException {
        // Simulate writing 8 bits with the last byte being incomplete
        // Write first byte
        compressorOutputStream.write(0x00);
        compressorOutputStream.finish();
        // Assert
        assertEquals(1, outputStream.size());
        assertEquals((byte) 0x00, outputStream.toByteArray()[0]);
    }

    @Test
    public void testBsFinishedWithStream_ZeroBits() throws IOException {
        // Act
        compressorOutputStream.finish();
        // Assert
        assertEquals(0, outputStream.size());
    }
}
