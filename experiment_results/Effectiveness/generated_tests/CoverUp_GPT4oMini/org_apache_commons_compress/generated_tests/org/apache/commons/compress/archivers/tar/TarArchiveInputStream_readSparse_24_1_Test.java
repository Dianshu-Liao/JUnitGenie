package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.input.BoundedInputStream;

public class TarArchiveInputStream_readSparse_24_1_Test {

    private TarArchiveInputStream tarArchiveInputStream;

    @BeforeEach
    public void setUp() {
        // Initialize with an empty InputStream for testing
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        tarArchiveInputStream = new TarArchiveInputStream(inputStream);
    }

    private int invokeReadSparse(TarArchiveInputStream instance, byte[] buf, int offset, int numToRead) throws Exception {
        Method method = TarArchiveInputStream.class.getDeclaredMethod("readSparse", byte[].class, int.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(instance, buf, offset, numToRead);
    }

    private void invokeSetSparseInputStreams(TarArchiveInputStream instance, List<InputStream> sparseStreams) throws Exception {
        Method method = TarArchiveInputStream.class.getDeclaredMethod("setSparseInputStreams", List.class);
        method.setAccessible(true);
        method.invoke(instance, sparseStreams);
    }

    @Test
    public void testReadSparse_NoSparseInputStreams() throws Exception {
        byte[] buf = new byte[10];
        int result = invokeReadSparse(tarArchiveInputStream, buf, 0, 10);
        assertEquals(0, result);
    }

    @Test
    public void testReadSparse_EmptySparseInputStreams() throws Exception {
        invokeSetSparseInputStreams(tarArchiveInputStream, new ArrayList<>());
        byte[] buf = new byte[10];
        int result = invokeReadSparse(tarArchiveInputStream, buf, 0, 10);
        assertEquals(0, result);
    }

    @Test
    public void testReadSparse_SingleStream() throws Exception {
        byte[] data = { 1, 2, 3, 4, 5 };
        InputStream sparseStream = new ByteArrayInputStream(data);
        List<InputStream> sparseStreams = new ArrayList<>();
        sparseStreams.add(sparseStream);
        invokeSetSparseInputStreams(tarArchiveInputStream, sparseStreams);
        byte[] buf = new byte[10];
        int result = invokeReadSparse(tarArchiveInputStream, buf, 0, 5);
        assertEquals(5, result);
        assertEquals(1, buf[0]);
        assertEquals(2, buf[1]);
        assertEquals(3, buf[2]);
        assertEquals(4, buf[3]);
        assertEquals(5, buf[4]);
    }

    @Test
    public void testReadSparse_MultipleStreams() throws Exception {
        byte[] data1 = { 1, 2, 3 };
        byte[] data2 = { 4, 5, 6 };
        InputStream sparseStream1 = new ByteArrayInputStream(data1);
        InputStream sparseStream2 = new ByteArrayInputStream(data2);
        List<InputStream> sparseStreams = new ArrayList<>();
        sparseStreams.add(sparseStream1);
        sparseStreams.add(sparseStream2);
        invokeSetSparseInputStreams(tarArchiveInputStream, sparseStreams);
        byte[] buf = new byte[10];
        int result = invokeReadSparse(tarArchiveInputStream, buf, 0, 5);
        assertEquals(5, result);
        assertEquals(1, buf[0]);
        assertEquals(2, buf[1]);
        assertEquals(3, buf[2]);
        result = invokeReadSparse(tarArchiveInputStream, buf, 3, 3);
        assertEquals(3, result);
        assertEquals(4, buf[3]);
        assertEquals(5, buf[4]);
    }

    @Test
    public void testReadSparse_ExceedingRead() throws Exception {
        byte[] data = { 1, 2 };
        InputStream sparseStream = new ByteArrayInputStream(data);
        List<InputStream> sparseStreams = new ArrayList<>();
        sparseStreams.add(sparseStream);
        invokeSetSparseInputStreams(tarArchiveInputStream, sparseStreams);
        byte[] buf = new byte[10];
        int result = invokeReadSparse(tarArchiveInputStream, buf, 0, 5);
        assertEquals(2, result);
        assertEquals(1, buf[0]);
    }
}
