package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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

class TarArchiveEntry_TarArchiveEntry_108_1_Test {

    private byte[] headerBuf;

    private ZipEncoding encoding;

    private boolean lenient;

    private long dataOffset;

    @BeforeEach
    void setUp() {
        // Example header buffer
        headerBuf = new byte[100];
        // Assuming a helper for ZipEncoding
        encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        lenient = false;
        // Example data offset
        dataOffset = 123456;
    }

    @Test
    void testConstructorWithValidParameters() throws Exception {
        TarArchiveEntry entry = createTarArchiveEntry(headerBuf, encoding, lenient, dataOffset);
        assertNotNull(entry);
        assertEquals(dataOffset, entry.getDataOffset());
    }

    @Test
    void testConstructorWithNegativeDataOffset() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createTarArchiveEntry(headerBuf, encoding, lenient, -1);
        });
        assertEquals("The offset cannot be smaller than 0", exception.getMessage());
    }

    @Test
    void testConstructorWithNullHeaderBuffer() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            createTarArchiveEntry(null, encoding, lenient, dataOffset);
        });
        assertEquals("headerBuf cannot be null", exception.getMessage());
    }

    private TarArchiveEntry createTarArchiveEntry(byte[] headerBuf, ZipEncoding encoding, boolean lenient, long dataOffset) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(byte[].class, ZipEncoding.class, boolean.class, long.class);
        constructor.setAccessible(true);
        return constructor.newInstance(headerBuf, encoding, lenient, dataOffset);
    }
}
