package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.utils.ArchiveUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.nio.channels.SeekableByteChannel;
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
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.io.input.BoundedInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TarFile_isEOFRecord_11_2_Test {

    private TarFile tarFile;

    private int recordSize;

    @BeforeEach
    public void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Initialize TarFile with a dummy byte array
        byte[] content = new byte[512];
        tarFile = new TarFile(content);
        // Use reflection to access the private field recordSize
        Field field = TarFile.class.getDeclaredField("recordSize");
        field.setAccessible(true);
        recordSize = (int) field.get(tarFile);
    }

    @Test
    public void testIsEOFRecord_NullBuffer() throws Exception {
        // Invoke the private method using reflection
        boolean result = invokeIsEOFRecord(null);
        assertTrue(result, "Expected EOF for null ByteBuffer");
    }

    @Test
    public void testIsEOFRecord_ZeroArray() throws Exception {
        // Create a ByteBuffer with all zeros
        ByteBuffer zeroBuffer = ByteBuffer.allocate(recordSize);
        // Ensure it's filled with zeros
        zeroBuffer.clear();
        boolean result = invokeIsEOFRecord(zeroBuffer);
        assertTrue(result, "Expected EOF for zero-filled ByteBuffer");
    }

    @Test
    public void testIsEOFRecord_NonZeroArray() throws Exception {
        // Create a ByteBuffer with non-zero values
        ByteBuffer nonZeroBuffer = ByteBuffer.allocate(recordSize);
        // Fill with non-zero values
        nonZeroBuffer.put(new byte[] { 1, 2, 3 });
        // Prepare for reading
        nonZeroBuffer.flip();
        boolean result = invokeIsEOFRecord(nonZeroBuffer);
        assertFalse(result, "Expected not EOF for non-zero ByteBuffer");
    }

    private boolean invokeIsEOFRecord(ByteBuffer headerBuf) throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = TarFile.class.getDeclaredMethod("isEOFRecord", ByteBuffer.class);
        method.setAccessible(true);
        return (boolean) method.invoke(tarFile, headerBuf);
    }
}
