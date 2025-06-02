package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import java.io.IOException;
import java.lang.reflect.Constructor;
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

class TarArchiveEntry_TarArchiveEntry_106_0_Test {

    @Test
    void testTarArchiveEntryWithValidHeaderAndEncoding() throws Exception {
        byte[] headerBuf = "valid header".getBytes(StandardCharsets.UTF_8);
        // Mocking ZipEncoding for valid encoding
        ZipEncoding encoding = mock(ZipEncoding.class);
        TarArchiveEntry entry = invokeConstructor(headerBuf, encoding);
        assertNotNull(entry);
    }

    @Test
    void testTarArchiveEntryWithInvalidHeader() {
        byte[] headerBuf = null;
        // Mocking ZipEncoding for valid encoding
        ZipEncoding encoding = mock(ZipEncoding.class);
        assertThrows(IOException.class, () -> {
            invokeConstructor(headerBuf, encoding);
        });
    }

    @Test
    void testTarArchiveEntryWithEmptyHeader() {
        byte[] headerBuf = new byte[0];
        // Mocking ZipEncoding for valid encoding
        ZipEncoding encoding = mock(ZipEncoding.class);
        assertThrows(IOException.class, () -> {
            invokeConstructor(headerBuf, encoding);
        });
    }

    private TarArchiveEntry invokeConstructor(byte[] headerBuf, ZipEncoding encoding) throws Exception {
        Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(byte[].class, ZipEncoding.class);
        constructor.setAccessible(true);
        return constructor.newInstance(headerBuf, encoding);
    }
}
