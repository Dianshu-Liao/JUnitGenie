package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

public class TarArchiveEntry_TarArchiveEntry_106_1_Test {

    @Test
    public void testConstructorWithValidHeaderAndEncoding() {
        byte[] headerBuf = new byte[100];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8.name());
        TarArchiveEntry entry = null;
        try {
            entry = new TarArchiveEntry(headerBuf, encoding);
        } catch (IOException e) {
            fail("IOException should not be thrown for valid header and encoding");
        }
        assertNotNull(entry);
    }

    @Test
    public void testConstructorWithInvalidHeader() {
        byte[] headerBuf = new byte[0];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8.name());
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(headerBuf, encoding);
        });
    }

    @Test
    public void testConstructorWithNullHeader() {
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveEntry(null, ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8.name()));
        });
    }

    @Test
    public void testConstructorWithNullEncoding() {
        byte[] headerBuf = new byte[100];
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveEntry(headerBuf, null);
        });
    }

    @Test
    public void testSetSizeWithValidSize() {
        byte[] headerBuf = new byte[100];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8.name());
        final TarArchiveEntry entry;
        try {
            entry = new TarArchiveEntry(headerBuf, encoding);
            entry.setSize(1024);
            assertEquals(1024, entry.getSize());
        } catch (IOException e) {
            fail("IOException should not be thrown for valid header and encoding");
        }
    }

    @Test
    public void testSetSizeWithNegativeSize() {
        byte[] headerBuf = new byte[100];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8.name());
        final TarArchiveEntry entry;
        try {
            entry = new TarArchiveEntry(headerBuf, encoding);
            assertThrows(IllegalArgumentException.class, () -> {
                entry.setSize(-1);
            });
        } catch (IOException e) {
            fail("IOException should not be thrown for valid header and encoding");
        }
    }

    @Test
    public void testSetDataOffsetWithValidOffset() {
        byte[] headerBuf = new byte[100];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8.name());
        final TarArchiveEntry entry;
        try {
            entry = new TarArchiveEntry(headerBuf, encoding);
            entry.setDataOffset(100);
            assertEquals(100, entry.getDataOffset());
        } catch (IOException e) {
            fail("IOException should not be thrown for valid header and encoding");
        }
    }
}
