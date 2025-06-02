package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.LinkOption;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.File;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
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
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

@ExtendWith(MockitoExtension.class)
class TarArchiveEntry_TarArchiveEntry_112_1_Test {

    private Map<String, String> globalPaxHeaders;

    private byte[] headerBuf;

    @Mock
    private ZipEncoding encoding;

    private boolean lenient;

    private long dataOffset;

    @BeforeEach
    void setUp() {
        globalPaxHeaders = new HashMap<>();
        globalPaxHeaders.put("key1", "value1");
        globalPaxHeaders.put("key2", "value2");
        headerBuf = new byte[100];
        lenient = true;
        dataOffset = 12345L;
    }

    @Test
    void testTarArchiveEntryWithValidParameters() throws Exception {
        assertDoesNotThrow(() -> {
            TarArchiveEntry entry = createTarArchiveEntry(globalPaxHeaders, headerBuf, encoding, lenient, dataOffset);
            assertNotNull(entry);
            assertEquals(dataOffset, entry.getDataOffset());
        });
    }

    @Test
    void testTarArchiveEntryWithNegativeDataOffset() {
        assertThrows(IllegalArgumentException.class, () -> {
            createTarArchiveEntry(globalPaxHeaders, headerBuf, encoding, lenient, -1);
        });
    }

    @Test
    void testTarArchiveEntryWithNullGlobalPaxHeaders() {
        assertThrows(NullPointerException.class, () -> {
            createTarArchiveEntry(null, headerBuf, encoding, lenient, dataOffset);
        });
    }

    @Test
    void testTarArchiveEntryWithNullHeaderBuf() {
        assertThrows(NullPointerException.class, () -> {
            createTarArchiveEntry(globalPaxHeaders, null, encoding, lenient, dataOffset);
        });
    }

    @Test
    void testTarArchiveEntryWithNullEncoding() {
        assertThrows(IOException.class, () -> {
            createTarArchiveEntry(globalPaxHeaders, headerBuf, null, lenient, dataOffset);
        });
    }

    @Test
    void testTarArchiveEntryWithValidParametersAndCheckExtraPaxHeaders() throws Exception {
        TarArchiveEntry entry = createTarArchiveEntry(globalPaxHeaders, headerBuf, encoding, lenient, dataOffset);
        assertEquals(2, entry.getExtraPaxHeaders().size());
        assertTrue(entry.getExtraPaxHeaders().containsKey("key1"));
        assertTrue(entry.getExtraPaxHeaders().containsKey("key2"));
    }

    private TarArchiveEntry createTarArchiveEntry(Map<String, String> globalPaxHeaders, byte[] headerBuf, ZipEncoding encoding, boolean lenient, long dataOffset) throws Exception {
        Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(Map.class, byte[].class, ZipEncoding.class, boolean.class, long.class);
        constructor.setAccessible(true);
        return constructor.newInstance(globalPaxHeaders, headerBuf, encoding, lenient, dataOffset);
    }
}
