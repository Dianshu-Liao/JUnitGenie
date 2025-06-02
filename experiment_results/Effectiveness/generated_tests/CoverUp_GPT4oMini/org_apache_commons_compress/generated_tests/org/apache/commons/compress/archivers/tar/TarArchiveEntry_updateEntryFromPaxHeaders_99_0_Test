package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
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
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

public class TarArchiveEntry_updateEntryFromPaxHeaders_99_0_Test {

    private TarArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new TarArchiveEntry("testEntry", false);
    }

    @Test
    public void testUpdateEntryFromPaxHeaders_ValidHeaders() throws Exception {
        Map<String, String> headers = new HashMap<>();
        headers.put("user.name", "testUser");
        headers.put("group.name", "testGroup");
        headers.put("size", "12345");
        invokeUpdateEntryFromPaxHeaders(headers);
        assertEquals("testUser", entry.getUserName());
        assertEquals("testGroup", entry.getGroupName());
        assertEquals(12345, entry.getSize());
    }

    @Test
    public void testUpdateEntryFromPaxHeaders_EmptyHeaders() throws Exception {
        Map<String, String> headers = new HashMap<>();
        invokeUpdateEntryFromPaxHeaders(headers);
        assertEquals("", entry.getUserName());
        assertEquals("", entry.getGroupName());
        assertEquals(0, entry.getSize());
    }

    @Test
    public void testUpdateEntryFromPaxHeaders_InvalidSize() {
        Map<String, String> headers = new HashMap<>();
        headers.put("size", "invalidSize");
        assertThrows(IOException.class, () -> invokeUpdateEntryFromPaxHeaders(headers));
    }

    @Test
    public void testUpdateEntryFromPaxHeaders_NegativeSize() {
        Map<String, String> headers = new HashMap<>();
        headers.put("size", "-100");
        assertThrows(IOException.class, () -> invokeUpdateEntryFromPaxHeaders(headers));
    }

    @Test
    public void testUpdateEntryFromPaxHeaders_NullHeaders() {
        assertThrows(NullPointerException.class, () -> invokeUpdateEntryFromPaxHeaders(null));
    }

    private void invokeUpdateEntryFromPaxHeaders(Map<String, String> headers) throws Exception {
        Method method = TarArchiveEntry.class.getDeclaredMethod("updateEntryFromPaxHeaders", Map.class);
        method.setAccessible(true);
        method.invoke(entry, headers);
    }
}
