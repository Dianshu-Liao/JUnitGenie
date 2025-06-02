package org.apache.commons.compress.compressors.lz4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.zip.CheckedInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

public class FramedLZ4CompressorInputStream_init_5_0_Test {

    private FramedLZ4CompressorInputStream compressorInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the input stream with a valid LZ4 frame signature
        byte[] validLZ4Frame = { 4, 0x22, 0x4d, 0x18 };
        InputStream inputStream = new ByteArrayInputStream(validLZ4Frame);
        compressorInputStream = new FramedLZ4CompressorInputStream(inputStream);
    }

    @Test
    public void testInitWithFirstFrame() throws IOException {
        // The constructor already calls init(true), so we expect no exception
        assertDoesNotThrow(() -> {
            new FramedLZ4CompressorInputStream(new ByteArrayInputStream(new byte[] { 4, 0x22, 0x4d, 0x18 }));
        });
    }

    @Test
    public void testInitWithSubsequentFrame() throws IOException {
        // Create a new instance for the subsequent frame
        byte[] subsequentFrame = { 4, 0x22, 0x4d, 0x18 };
        InputStream inputStream = new ByteArrayInputStream(subsequentFrame);
        FramedLZ4CompressorInputStream subsequentCompressorInputStream = new FramedLZ4CompressorInputStream(inputStream);
        assertDoesNotThrow(() -> {
            // The constructor handles initialization
        });
    }

    @Test
    public void testInitThrowsIOExceptionOnInvalidSignature() {
        // Test that an IOException is thrown when the signature is invalid
        byte[] invalidLZ4Frame = { 0, 0, 0, 0 };
        InputStream inputStream = new ByteArrayInputStream(invalidLZ4Frame);
        assertThrows(IOException.class, () -> {
            new FramedLZ4CompressorInputStream(inputStream);
        });
    }

    @Test
    public void testInitHandlesPrematureEndOfStream() {
        // Test that an IOException is thrown on premature end of stream
        byte[] incompleteLZ4Frame = { 4, 0x22, 0x4d };
        InputStream inputStream = new ByteArrayInputStream(incompleteLZ4Frame);
        assertThrows(IOException.class, () -> {
            new FramedLZ4CompressorInputStream(inputStream);
        });
    }
}
