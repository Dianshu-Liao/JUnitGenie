package org.apache.commons.compress.compressors.lz4;

import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
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

class FramedLZ4CompressorInputStream_init_5_0_Test {

    private FramedLZ4CompressorInputStream compressorInputStream;

    @BeforeEach
    void setUp() throws IOException {
        // Mocked input stream for testing
        InputStream mockInputStream = new ByteArrayInputStream(new byte[] { 4, 0x22, 0x4d, 0x18 });
        compressorInputStream = new FramedLZ4CompressorInputStream(mockInputStream);
    }

    @Test
    void testInitFirstFrame() throws Exception {
        // Using reflection to access the private method init(boolean)
        java.lang.reflect.Method initMethod = FramedLZ4CompressorInputStream.class.getDeclaredMethod("init", boolean.class);
        initMethod.setAccessible(true);
        initMethod.invoke(compressorInputStream, true);
    }

    @Test
    void testInitSubsequentFrame() throws Exception {
        // Using reflection to access the private method init(boolean)
        java.lang.reflect.Method initMethod = FramedLZ4CompressorInputStream.class.getDeclaredMethod("init", boolean.class);
        initMethod.setAccessible(true);
        initMethod.invoke(compressorInputStream, false);
    }

    @Test
    void testInitThrowsIOExceptionOnInvalidSignature() throws Exception {
        InputStream invalidInputStream = new ByteArrayInputStream(new byte[] { 0, 0, 0, 0 });
        compressorInputStream = new FramedLZ4CompressorInputStream(invalidInputStream);
        java.lang.reflect.Method initMethod = FramedLZ4CompressorInputStream.class.getDeclaredMethod("init", boolean.class);
        initMethod.setAccessible(true);
        assertThrows(IOException.class, () -> initMethod.invoke(compressorInputStream, true));
    }

    @Test
    void testInitThrowsIOExceptionOnPrematureEnd() throws Exception {
        InputStream prematureEndInputStream = new ByteArrayInputStream(new byte[] { 4, 0x22 });
        compressorInputStream = new FramedLZ4CompressorInputStream(prematureEndInputStream);
        java.lang.reflect.Method initMethod = FramedLZ4CompressorInputStream.class.getDeclaredMethod("init", boolean.class);
        initMethod.setAccessible(true);
        assertThrows(IOException.class, () -> initMethod.invoke(compressorInputStream, true));
    }

    @Test
    void testInitHandlesSuccessfulRead() throws Exception {
        InputStream validInputStream = new ByteArrayInputStream(new byte[] { 4, 0x22, 0x4d, 0x18 });
        compressorInputStream = new FramedLZ4CompressorInputStream(validInputStream);
        java.lang.reflect.Method initMethod = FramedLZ4CompressorInputStream.class.getDeclaredMethod("init", boolean.class);
        initMethod.setAccessible(true);
        // Should not throw
        initMethod.invoke(compressorInputStream, true);
    }
}
