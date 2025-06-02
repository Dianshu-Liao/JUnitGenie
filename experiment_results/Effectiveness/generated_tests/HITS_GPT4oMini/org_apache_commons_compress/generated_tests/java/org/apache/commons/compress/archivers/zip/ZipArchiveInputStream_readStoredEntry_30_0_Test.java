package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.zip.ZipException;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.compress.archivers.zip.ZipConstants.DWORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.SHORT;
import static org.apache.commons.compress.archivers.zip.ZipConstants.WORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.ZIP64_MAGIC;
import java.io.EOFException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
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

    private ZipArchiveInputStream zipArchiveInputStream;

    private ByteArrayInputStream inputStream;

    @BeforeEach
    void setUp() {
        byte[] mockData = new byte[] {/* Add mock ZIP data here */
        };
        inputStream = new ByteArrayInputStream(mockData);
        zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
    }

    @Test
    void testReadStoredEntry_Success() throws Exception {
        ZipArchiveEntry mockEntry = mock(ZipArchiveEntry.class);
        when(mockEntry.getCompressedSize()).thenReturn(100L);
        when(mockEntry.getSize()).thenReturn(100L);
        setCurrentEntry(mockEntry);
        invokeReadStoredEntry();
        Field lastStoredEntryField = ZipArchiveInputStream.class.getDeclaredField("lastStoredEntry");
        lastStoredEntryField.setAccessible(true);
        ByteArrayInputStream lastStoredEntry = (ByteArrayInputStream) lastStoredEntryField.get(zipArchiveInputStream);
        assertNotNull(lastStoredEntry);
    }

    @Test
    void testReadStoredEntry_TruncatedZIPFile() throws Exception {
        byte[] truncatedData = new byte[] {/* Add truncated ZIP data here */
        };
        inputStream = new ByteArrayInputStream(truncatedData);
        zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
        setCurrentEntry(mock(ZipArchiveEntry.class));
        assertThrows(IOException.class, this::invokeReadStoredEntry);
    }

    @Test
    void testReadStoredEntry_CompressedAndUncompressedSizeMismatch() throws Exception {
        ZipArchiveEntry mockEntry = mock(ZipArchiveEntry.class);
        when(mockEntry.getCompressedSize()).thenReturn(100L);
        when(mockEntry.getSize()).thenReturn(200L);
        setCurrentEntry(mockEntry);
        assertThrows(ZipException.class, this::invokeReadStoredEntry);
    }

    @Test
    void testReadStoredEntry_ActualAndClaimedSizeMismatch() throws Exception {
        ZipArchiveEntry mockEntry = mock(ZipArchiveEntry.class);
        when(mockEntry.getCompressedSize()).thenReturn(100L);
        when(mockEntry.getSize()).thenReturn(100L);
        setCurrentEntry(mockEntry);
        ByteArrayOutputStream mockBos = mock(ByteArrayOutputStream.class);
        when(mockBos.toByteArray()).thenReturn(new byte[50]);
        Field lastStoredEntryField = ZipArchiveInputStream.class.getDeclaredField("lastStoredEntry");
        lastStoredEntryField.setAccessible(true);
        lastStoredEntryField.set(zipArchiveInputStream, new ByteArrayInputStream(mockBos.toByteArray()));
        assertThrows(ZipException.class, this::invokeReadStoredEntry);
    }

    private void setCurrentEntry(ZipArchiveEntry entry) throws Exception {
        Field currentField = ZipArchiveInputStream.class.getDeclaredField("current");
        currentField.setAccessible(true);
        currentField.set(zipArchiveInputStream, new CurrentEntry(entry));
    }

    private void invokeReadStoredEntry() throws Exception {
        Method readStoredEntryMethod = ZipArchiveInputStream.class.getDeclaredMethod("readStoredEntry");
        readStoredEntryMethod.setAccessible(true);
        readStoredEntryMethod.invoke(zipArchiveInputStream);
    }

    private static class CurrentEntry {

        ZipArchiveEntry entry;

        CurrentEntry(ZipArchiveEntry entry) {
            this.entry = entry;
        }
    }
}
