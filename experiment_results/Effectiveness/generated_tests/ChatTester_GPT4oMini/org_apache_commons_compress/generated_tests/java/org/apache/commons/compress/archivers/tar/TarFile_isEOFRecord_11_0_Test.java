package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.SeekableByteChannel;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.io.input.BoundedInputStream;

public class TarFile_isEOFRecord_11_0_Test {

    private TarFile tarFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize TarFile with a mock SeekableByteChannel
        tarFile = new TarFile(mock(SeekableByteChannel.class));
    }

    @Test
    public void testIsEOFRecord_NullHeaderBuffer() throws Exception {
        // Invoke the private method using reflection
        Method method = TarFile.class.getDeclaredMethod("isEOFRecord", ByteBuffer.class);
        method.setAccessible(true);
        // Test with null ByteBuffer
        boolean result = (boolean) method.invoke(tarFile, (ByteBuffer) null);
        assertTrue(result, "Expected isEOFRecord to return true for null header buffer");
    }

    @Test
    public void testIsEOFRecord_ZeroArray() throws Exception {
        // Access the private recordSize field using reflection
        Field recordSizeField = TarFile.class.getDeclaredField("recordSize");
        recordSizeField.setAccessible(true);
        int recordSize = (int) recordSizeField.get(tarFile);
        ByteBuffer headerBuf = ByteBuffer.wrap(new byte[recordSize]);
        Method method = TarFile.class.getDeclaredMethod("isEOFRecord", ByteBuffer.class);
        method.setAccessible(true);
        // Test with a ByteBuffer containing zero array
        boolean result = (boolean) method.invoke(tarFile, headerBuf);
        assertTrue(result, "Expected isEOFRecord to return true for zero array in header buffer");
    }

    @Test
    public void testIsEOFRecord_NonZeroArray() throws Exception {
        // Create a ByteBuffer with a non-zero array
        ByteBuffer headerBuf = ByteBuffer.wrap(new byte[] { 1, 2, 3, 4 });
        Method method = TarFile.class.getDeclaredMethod("isEOFRecord", ByteBuffer.class);
        method.setAccessible(true);
        // Test with a ByteBuffer containing non-zero array
        boolean result = (boolean) method.invoke(tarFile, headerBuf);
        assertFalse(result, "Expected isEOFRecord to return false for non-zero array in header buffer");
    }
}
