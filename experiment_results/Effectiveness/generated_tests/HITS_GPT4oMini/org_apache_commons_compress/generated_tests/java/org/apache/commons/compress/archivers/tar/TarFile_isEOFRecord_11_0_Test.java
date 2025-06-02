package org.apache.commons.compress.archivers.tar;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
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
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.commons.io.input.BoundedInputStream;

public class TarFile_isEOFRecord_11_0_Test {

    private TarFile tarFile;

    private Method isEOFRecordMethod;

    private int recordSize;

    @BeforeEach
    public void setUp() throws Exception {
        // Initialize TarFile with an empty byte array for testing
        tarFile = new TarFile(new byte[0]);
        // Access the private method using reflection
        isEOFRecordMethod = TarFile.class.getDeclaredMethod("isEOFRecord", ByteBuffer.class);
        isEOFRecordMethod.setAccessible(true);
        // Access the private field recordSize using reflection
        Field recordSizeField = TarFile.class.getDeclaredField("recordSize");
        recordSizeField.setAccessible(true);
        recordSize = (int) recordSizeField.get(tarFile);
    }

    @Test
    public void testIsEOFRecord_NullBuffer() throws Exception {
        ByteBuffer buffer = null;
        assertTrue((Boolean) isEOFRecordMethod.invoke(tarFile, buffer), "Expected isEOFRecord to return true for null buffer");
    }

    @Test
    public void testIsEOFRecord_ZeroArray() throws Exception {
        // Create an array of zeros
        byte[] zeroArray = new byte[recordSize];
        ByteBuffer buffer = ByteBuffer.wrap(zeroArray);
        assertTrue((Boolean) isEOFRecordMethod.invoke(tarFile, buffer), "Expected isEOFRecord to return true for zero array");
    }

    @Test
    public void testIsEOFRecord_NonZeroArray() throws Exception {
        byte[] nonZeroArray = new byte[recordSize];
        // Set the first element to a non-zero value
        nonZeroArray[0] = 1;
        ByteBuffer buffer = ByteBuffer.wrap(nonZeroArray);
        assertFalse((Boolean) isEOFRecordMethod.invoke(tarFile, buffer), "Expected isEOFRecord to return false for non-zero array");
    }

    @Test
    public void testIsEOFRecord_PartiallyZeroArray() throws Exception {
        byte[] partialZeroArray = new byte[recordSize];
        // Set the first element to a non-zero value
        partialZeroArray[0] = 1;
        ByteBuffer buffer = ByteBuffer.wrap(partialZeroArray);
        assertFalse((Boolean) isEOFRecordMethod.invoke(tarFile, buffer), "Expected isEOFRecord to return false for partially zero array");
    }
}
