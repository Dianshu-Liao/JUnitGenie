package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
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
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

public class TarArchiveEntry_parseTarHeader_70_1_Test {

    private TarArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new TarArchiveEntry(new byte[0]);
    }

    @Test
    public void testParseTarHeader_ValidHeader() throws IOException {
        Map<String, String> globalPaxHeaders = new HashMap<>();
        byte[] header = createValidTarHeader();
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        TarArchiveEntry entry = new TarArchiveEntry(globalPaxHeaders, header, encoding, false);
        assertNotNull(entry.getName());
    }

    @Test
    public void testParseTarHeader_CorruptedHeader() {
        Map<String, String> globalPaxHeaders = new HashMap<>();
        byte[] header = createCorruptedTarHeader();
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(globalPaxHeaders, header, encoding, false);
        });
    }

    @Test
    public void testParseTarHeader_NullHeader() {
        Map<String, String> globalPaxHeaders = new HashMap<>();
        byte[] header = null;
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(globalPaxHeaders, header, encoding, false);
        });
    }

    @Test
    public void testParseTarHeader_EmptyHeader() {
        Map<String, String> globalPaxHeaders = new HashMap<>();
        byte[] header = new byte[0];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(globalPaxHeaders, header, encoding, false);
        });
    }

    private byte[] createValidTarHeader() {
        return new byte[] {/* Fill with valid TAR header bytes */
        };
    }

    private byte[] createCorruptedTarHeader() {
        return new byte[] {/* Fill with corrupted TAR header bytes */
        };
    }
}
