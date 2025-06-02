package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.io.File;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class TarArchiveEntry_TarArchiveEntry_107_4_Test {

    private TarArchiveEntry tarArchiveEntry;

    @BeforeEach
    void setUp() {
        // Setup code if needed
    }

    @Test
    void testConstructorWithValidParameters() throws Exception {
        byte[] headerBuf = createValidHeaderBuf();
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        boolean lenient = true;
        // Using reflection to access the constructor
        Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(byte[].class, ZipEncoding.class, boolean.class);
        constructor.setAccessible(true);
        tarArchiveEntry = constructor.newInstance(headerBuf, encoding, lenient);
        // Assert that the object is created successfully
        assertNotNull(tarArchiveEntry);
        // Replace with actual expected name
        assertEquals("validHeaderData", tarArchiveEntry.getName());
    }

    @Test
    void testConstructorWithInvalidHeader() {
        // Invalid header
        byte[] invalidHeaderBuf = new byte[0];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        boolean lenient = false;
        // Using reflection to access the constructor
        assertThrows(IOException.class, () -> {
            Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(byte[].class, ZipEncoding.class, boolean.class);
            constructor.setAccessible(true);
            constructor.newInstance(invalidHeaderBuf, encoding, lenient);
        });
    }

    @Test
    void testConstructorWithNullParameters() {
        ZipEncoding encoding = null;
        boolean lenient = true;
        // Using reflection to access the constructor
        assertThrows(IllegalArgumentException.class, () -> {
            Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(byte[].class, ZipEncoding.class, boolean.class);
            constructor.setAccessible(true);
            constructor.newInstance(null, encoding, lenient);
        });
    }

    private byte[] createValidHeaderBuf() {
        // Create a valid TAR header byte array
        // Replace with actual header data
        String validHeader = "validHeaderData";
        return validHeader.getBytes(StandardCharsets.UTF_8);
    }
}
