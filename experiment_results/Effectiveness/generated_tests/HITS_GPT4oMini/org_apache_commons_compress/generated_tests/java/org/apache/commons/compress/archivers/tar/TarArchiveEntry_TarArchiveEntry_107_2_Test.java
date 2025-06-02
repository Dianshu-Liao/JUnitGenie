package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.IOException;
import java.io.File;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class TarArchiveEntry_TarArchiveEntry_107_2_Test {

    @Test
    void testConstructorWithHeaderBufAndEncoding() {
        byte[] headerBuf = new byte[100];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        assertDoesNotThrow(() -> {
            TarArchiveEntry entry = new TarArchiveEntry(headerBuf, encoding);
            assertNotNull(entry);
        });
    }

    @Test
    void testConstructorWithHeaderBufEncodingAndLenient() {
        byte[] headerBuf = new byte[100];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        assertDoesNotThrow(() -> {
            TarArchiveEntry entry = new TarArchiveEntry(headerBuf, encoding, true);
            assertNotNull(entry);
        });
    }

    @Test
    void testConstructorWithHeaderBufAndLenient() {
        byte[] headerBuf = new byte[100];
        assertDoesNotThrow(() -> {
            TarArchiveEntry entry = new TarArchiveEntry(headerBuf, null, true);
            assertNotNull(entry);
        });
    }

    @Test
    void testConstructorWithGlobalPaxHeaders() {
        byte[] headerBuf = new byte[100];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        assertDoesNotThrow(() -> {
            TarArchiveEntry entry = new TarArchiveEntry(Collections.emptyMap(), headerBuf, encoding, false);
            assertNotNull(entry);
        });
    }

    @Test
    void testConstructorWithFile() {
        assertDoesNotThrow(() -> {
            TarArchiveEntry entry = new TarArchiveEntry(new File("example.txt"));
            assertNotNull(entry);
        });
    }
}
