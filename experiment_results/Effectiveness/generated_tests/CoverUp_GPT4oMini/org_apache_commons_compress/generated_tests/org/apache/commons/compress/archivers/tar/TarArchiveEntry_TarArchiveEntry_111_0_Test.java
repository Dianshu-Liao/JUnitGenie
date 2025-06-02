package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import java.io.IOException;
import java.lang.reflect.Method;
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
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

class TarArchiveEntry_TarArchiveEntry_111_0_Test {

    private TarArchiveEntry tarArchiveEntry;

    private Map<String, String> globalPaxHeaders;

    private byte[] headerBuf;

    private ZipEncoding encoding;

    @BeforeEach
    void setUp() {
        globalPaxHeaders = new HashMap<>();
        headerBuf = new byte[100];
        // Mocking ZipEncoding
        encoding = mock(ZipEncoding.class);
    }

    @Test
    void testConstructorWithValidParameters() {
        try {
            tarArchiveEntry = new TarArchiveEntry(globalPaxHeaders, headerBuf, encoding, true);
            assertNotNull(tarArchiveEntry);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testConstructorWithEmptyGlobalPaxHeaders() {
        try {
            tarArchiveEntry = new TarArchiveEntry(new HashMap<>(), headerBuf, encoding, false);
            assertNotNull(tarArchiveEntry);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testConstructorWithNullHeaderBuf() {
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveEntry(globalPaxHeaders, null, encoding, true);
        });
    }

    @Test
    void testConstructorWithNullEncoding() {
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveEntry(globalPaxHeaders, headerBuf, null, true);
        });
    }

    @Test
    void testConstructorWithInvalidHeaderBuffer() {
        byte[] invalidHeaderBuf = new byte[0];
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(globalPaxHeaders, invalidHeaderBuf, encoding, true);
        });
    }

    @Test
    void testParseTarHeader() throws Exception {
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseTarHeader", Map.class, byte[].class, ZipEncoding.class, boolean.class, boolean.class);
        method.setAccessible(true);
        // Assuming we need to prepare valid parameters for parseTarHeader
        boolean lenient = false;
        boolean anotherFlag = true;
        // Invoke the method
        method.invoke(tarArchiveEntry, globalPaxHeaders, headerBuf, encoding, lenient, anotherFlag);
        // Add assertions based on expected outcomes after invoking parseTarHeader
    }
}
