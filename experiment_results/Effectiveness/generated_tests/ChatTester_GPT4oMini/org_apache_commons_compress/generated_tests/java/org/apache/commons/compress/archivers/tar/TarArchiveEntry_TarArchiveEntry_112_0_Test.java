package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

public class TarArchiveEntry_TarArchiveEntry_112_0_Test {

    private Map<String, String> globalPaxHeaders;

    private byte[] headerBuf;

    private ZipEncoding encoding;

    private boolean lenient;

    private long dataOffset;

    @BeforeEach
    public void setUp() {
        globalPaxHeaders = new HashMap<>();
        // Sample byte array
        headerBuf = new byte[] { 0, 1, 2 };
        // Mocking ZipEncoding
        encoding = mock(ZipEncoding.class);
        lenient = true;
        // Sample data offset
        dataOffset = 100L;
    }

    @Test
    public void testConstructorWithValidParameters() throws IOException {
        TarArchiveEntry entry = new TarArchiveEntry(globalPaxHeaders, headerBuf, encoding, lenient, dataOffset);
        assertNotNull(entry);
        assertEquals(dataOffset, entry.getDataOffset());
    }

    @Test
    public void testConstructorWithNegativeDataOffset() {
        // Testing with negative data offset
        dataOffset = -1L;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveEntry(globalPaxHeaders, headerBuf, encoding, lenient, dataOffset);
        });
        assertEquals("The offset cannot be smaller than 0", exception.getMessage());
    }

    @Test
    public void testConstructorWithEmptyHeaderBuf() throws IOException {
        // Testing with empty header buffer
        headerBuf = new byte[0];
        TarArchiveEntry entry = new TarArchiveEntry(globalPaxHeaders, headerBuf, encoding, lenient, dataOffset);
        assertNotNull(entry);
        assertEquals(dataOffset, entry.getDataOffset());
    }

    @Test
    public void testConstructorThrowsIOException() {
        // Simulate an IOException scenario
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(null, null, encoding, lenient, dataOffset);
        });
    }

    // Reflection test for private method if needed
    @Test
    public void testSetDataOffset() throws Exception {
        TarArchiveEntry entry = new TarArchiveEntry(globalPaxHeaders, headerBuf, encoding, lenient, dataOffset);
        java.lang.reflect.Method method = TarArchiveEntry.class.getDeclaredMethod("setDataOffset", long.class);
        method.setAccessible(true);
        // Invoking private method
        method.invoke(entry, 200L);
        // Additional assertions can be added here based on the expected behavior
        assertEquals(200L, entry.getDataOffset());
    }
}
