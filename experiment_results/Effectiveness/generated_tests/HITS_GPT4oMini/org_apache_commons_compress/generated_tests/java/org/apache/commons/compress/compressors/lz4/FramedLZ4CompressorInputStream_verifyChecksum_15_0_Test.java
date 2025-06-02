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

public class FramedLZ4CompressorInputStream_verifyChecksum_15_0_Test {

    private FramedLZ4CompressorInputStream compressorInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize with a dummy InputStream for testing
        byte[] dummyData = new byte[] { 4, 0x22, 0x4d, 0x18 };
        compressorInputStream = new FramedLZ4CompressorInputStream(new ByteArrayInputStream(dummyData));
    }

    @Test
    public void testVerifyChecksum_MatchingChecksum() throws IOException, ReflectiveOperationException {
        // Prepare a valid checksum using XXHash32
        XXHash32 hash = new XXHash32();
        byte[] validChecksum = new byte[] { 0x18, 0x4d, 0x22, 0x04 };
        hash.update(validChecksum, 0, validChecksum.length);
        long expectedHash = hash.getValue();
        // Write the valid checksum to the input stream
        compressorInputStream = new FramedLZ4CompressorInputStream(new ByteArrayInputStream(validChecksum));
        // Access the private method using reflection
        Method verifyChecksumMethod = FramedLZ4CompressorInputStream.class.getDeclaredMethod("verifyChecksum", XXHash32.class, String.class);
        verifyChecksumMethod.setAccessible(true);
        // Verify that no exception is thrown
        assertDoesNotThrow(() -> {
            verifyChecksumMethod.invoke(compressorInputStream, hash, "content");
        });
    }

    @Test
    public void testVerifyChecksum_NonMatchingChecksum() throws IOException, ReflectiveOperationException {
        XXHash32 hash = new XXHash32();
        byte[] validChecksum = new byte[] { 0x18, 0x4d, 0x22, 0x04 };
        hash.update(validChecksum, 0, validChecksum.length);
        long expectedHash = hash.getValue();
        // Write an invalid checksum to the input stream
        byte[] invalidChecksum = new byte[] { 0x00, 0x00, 0x00, 0x00 };
        compressorInputStream = new FramedLZ4CompressorInputStream(new ByteArrayInputStream(invalidChecksum));
        // Access the private method using reflection
        Method verifyChecksumMethod = FramedLZ4CompressorInputStream.class.getDeclaredMethod("verifyChecksum", XXHash32.class, String.class);
    }
}
