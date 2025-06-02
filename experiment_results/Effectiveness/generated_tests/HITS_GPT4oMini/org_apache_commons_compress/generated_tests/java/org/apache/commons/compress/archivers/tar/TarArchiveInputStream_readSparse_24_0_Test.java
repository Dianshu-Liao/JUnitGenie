package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class TarArchiveInputStream_readSparse_24_0_Test {

    private TarArchiveInputStream tarArchiveInputStream;

    @BeforeEach
    public void setUp() {
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        tarArchiveInputStream = new TarArchiveInputStream(inputStream);
    }

    private int invokeReadSparse(byte[] buffer, int offset, int numToRead) throws Exception {
        Method method = TarArchiveInputStream.class.getDeclaredMethod("readSparse", byte[].class, int.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(tarArchiveInputStream, buffer, offset, numToRead);
    }

    private void setSparseInputStreams(List<InputStream> sparseInputStreams) throws Exception {
        Field field = TarArchiveInputStream.class.getDeclaredField("sparseInputStreams");
        field.setAccessible(true);
        field.set(tarArchiveInputStream, sparseInputStreams);
    }

    @Test
    public void testReadSparse_WithNoSparseInputStreams() throws Exception {
        byte[] buffer = new byte[10];
        int bytesRead = invokeReadSparse(buffer, 0, 10);
        assertEquals(-1, bytesRead, "Expected -1 when no sparse input streams are available.");
    }

    @Test
    public void testReadSparse_WithSingleSparseInputStream() throws Exception {
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
        List<InputStream> sparseInputStreams = new ArrayList<>();
        sparseInputStreams.add(new ByteArrayInputStream(data));
        setSparseInputStreams(sparseInputStreams);
        byte[] buffer = new byte[10];
        int bytesRead = invokeReadSparse(buffer, 0, 10);
        assertEquals(5, bytesRead, "Expected to read 5 bytes from the single sparse input stream.");
        assertEquals(1, buffer[0]);
        assertEquals(2, buffer[1]);
        assertEquals(3, buffer[2]);
        assertEquals(4, buffer[3]);
        assertEquals(5, buffer[4]);
    }

    @Test
    public void testReadSparse_WithMultipleSparseInputStreams() throws Exception {
        byte[] data1 = new byte[] { 1, 2, 3 };
        byte[] data2 = new byte[] { 4, 5, 6, 7, 8 };
        List<InputStream> sparseInputStreams = new ArrayList<>();
        sparseInputStreams.add(new ByteArrayInputStream(data1));
        sparseInputStreams.add(new ByteArrayInputStream(data2));
        setSparseInputStreams(sparseInputStreams);
        byte[] buffer = new byte[10];
        int bytesRead = invokeReadSparse(buffer, 0, 10);
        assertEquals(8, bytesRead, "Expected to read 8 bytes from the multiple sparse input streams.");
        assertEquals(1, buffer[0]);
        assertEquals(2, buffer[1]);
        assertEquals(3, buffer[2]);
        assertEquals(4, buffer[3]);
        assertEquals(5, buffer[4]);
        assertEquals(6, buffer[5]);
        assertEquals(7, buffer[6]);
        assertEquals(8, buffer[7]);
    }
}
