package org.apache.commons.compress.compressors.lz4;

import org.apache.commons.codec.digest.XXHash32;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.CheckedInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

public class FramedLZ4CompressorInputStream_verifyChecksum_15_1_Test {

    private FramedLZ4CompressorInputStream framedLZ4CompressorInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize with a dummy input stream
        framedLZ4CompressorInputStream = new FramedLZ4CompressorInputStream(new ByteArrayInputStream(new byte[0]));
    }

    @Test
    public void testVerifyChecksum_Success() throws Exception {
        // Prepare hash and checksum
        XXHash32 hash = new XXHash32();
        // Example checksum
        byte[] data = new byte[] { 0, 0, 0, 1 };
        hash.update(data, 0, data.length);
        long expectedHash = hash.getValue();
        // Simulate input stream with the expected checksum
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[] { 0, 0, 0, 1 });
        framedLZ4CompressorInputStream = new FramedLZ4CompressorInputStream(inputStream);
        // Invoke the private method using reflection
        invokeVerifyChecksum(hash, "test");
    }

    @Test
    public void testVerifyChecksum_PrematureEndOfStream() throws Exception {
        // Prepare hash
        XXHash32 hash = new XXHash32();
        // Example checksum
        byte[] data = new byte[] { 0, 0, 0, 1 };
        hash.update(data, 0, data.length);
        // Simulate input stream that doesn't provide enough data
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[] { 0, 0 });
        framedLZ4CompressorInputStream = new FramedLZ4CompressorInputStream(inputStream);
        // Expect IOException for premature end of stream
        assertThrows(IOException.class, () -> invokeVerifyChecksum(hash, "test"));
    }

    @Test
    public void testVerifyChecksum_ChecksumMismatch() throws Exception {
        // Prepare hash
        XXHash32 hash = new XXHash32();
        // Example checksum
        byte[] data = new byte[] { 0, 0, 0, 1 };
        hash.update(data, 0, data.length);
        // Simulate input stream with a different checksum
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[] { 0, 0, 0, 2 });
        framedLZ4CompressorInputStream = new FramedLZ4CompressorInputStream(inputStream);
        // Expect IOException for checksum mismatch
        assertThrows(IOException.class, () -> invokeVerifyChecksum(hash, "test"));
    }

    private void invokeVerifyChecksum(XXHash32 hash, String kind) throws Exception {
        Method method = FramedLZ4CompressorInputStream.class.getDeclaredMethod("verifyChecksum", XXHash32.class, String.class);
        method.setAccessible(true);
        method.invoke(framedLZ4CompressorInputStream, hash, kind);
    }
}
