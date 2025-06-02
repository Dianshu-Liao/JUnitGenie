package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.compress.archivers.zip.ZipConstants.DWORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.SHORT;
import static org.apache.commons.compress.archivers.zip.ZipConstants.WORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.ZIP64_MAGIC;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.EOFException;
import java.io.PushbackInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

class ZipArchiveInputStream_readStoredEntry_30_0_Test {

    private ZipArchiveInputStream zipInputStream;

    private ByteArrayInputStream inputStream;

    @BeforeEach
    void setUp() {
        // Mock input stream with sample ZIP data
        byte[] sampleZipData = createSampleZipData();
        inputStream = new ByteArrayInputStream(sampleZipData);
        zipInputStream = new ZipArchiveInputStream(inputStream);
    }

    private byte[] createSampleZipData() {
        return new byte[] { 0x50, 0x4B, 0x03, 0x04, 0x14, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0C, 0x00, 0x00, 0x00, 0x00, 0x00, 't', 'e', 's', 't', '.', 't', 'x', 't', 0x00, 0x00, 0x00, 0x00 };
    }

    private byte[] createZipDataWithSizeMismatch() {
        // Size mismatch
        return new byte[] { 0x50, 0x4B, 0x03, 0x04, 0x14, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x0C, 0x00, 0x00, 0x00, 0x00, 0x00, 't', 'e', 's', 't', '.', 't', 'x', 't', 0x00, 0x00, 0x00, 0x01 };
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = ZipArchiveInputStream.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(zipInputStream);
    }

    private Object getPrivateField(String fieldName) throws Exception {
        java.lang.reflect.Field field = ZipArchiveInputStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(zipInputStream);
    }

    @Test
    void testReadStoredEntrySuccessfully() throws Exception {
        ZipArchiveEntry entry = zipInputStream.getNextEntry();
        assertNotNull(entry);
        assertEquals("test.txt", entry.getName());
        invokePrivateMethod("readStoredEntry");
        assertNotNull(getPrivateField("lastStoredEntry"));
    }

    @Test
    void testReadStoredEntryTruncatedZipFile() {
        byte[] truncatedZipData = new byte[] { 0x50, 0x4B };
        inputStream = new ByteArrayInputStream(truncatedZipData);
        zipInputStream = new ZipArchiveInputStream(inputStream);
        assertThrows(IOException.class, () -> {
            invokePrivateMethod("readStoredEntry");
        });
    }
}
